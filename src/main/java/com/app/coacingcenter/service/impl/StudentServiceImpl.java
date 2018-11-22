package com.app.coacingcenter.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.app.coacingcenter.dto.LabelValuePair;
import com.app.coacingcenter.dto.PaymentDetailDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.dto.StudentDto;
import com.app.coacingcenter.dto.StudentIndentDto;
import com.app.coacingcenter.entity.CoachingCenter;
import com.app.coacingcenter.entity.Course;
import com.app.coacingcenter.entity.PaymentDetail;
import com.app.coacingcenter.entity.Student;
import com.app.coacingcenter.entity.StudentCourse;
import com.app.coacingcenter.entity.User;
import com.app.coacingcenter.repository.CoachingCenterRepository;
import com.app.coacingcenter.repository.CourseRepository;
import com.app.coacingcenter.repository.PaymentDetailRepository;
import com.app.coacingcenter.repository.StudentCourseRepository;
import com.app.coacingcenter.repository.StudentRepository;
import com.app.coacingcenter.repository.UserRepository;
import com.app.coacingcenter.service.StudentService;
import com.app.coacingcenter.utils.CommonUtility;
import com.app.coacingcenter.utils.DateTimeUtil;
import com.app.coacingcenter.utils.FieldMapperService;
import com.app.coacingcenter.utils.SuccessorStringGenerator;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	CoachingCenterRepository coachingCenterRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	FieldMapperService fieldMapperService;

	@Autowired
	PaymentDetailRepository paymentDetailRepository;

	@Autowired
	StudentCourseRepository studentCourseRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public List<StudentDto> getStudents() {
		List<Student> students = studentRepo.findAll();
		List<StudentDto> studentDtos = new ArrayList<>();
		for (Student student : students) {
			studentDtos.add(populateStudentDto(student));
		}
		return studentDtos;
	}

	@Override
	public StudentDto getStudent(Integer studentId) {
		Optional<Student> student = studentRepo.findById(studentId);
		if (student.isPresent())
			return populateStudentDto(student.get());
		else
			return new StudentDto();
	}

	private StudentDto populateStudentDto(Student student) {
		StudentDto studentDto = null;
		studentDto = fieldMapperService.populateDataToNewInstance(student, StudentDto.class);
		List<String> course = new ArrayList<>();
		for (StudentCourse studentCourse : student.getStudentCourse()) {
			course.add(studentCourse.getCourse().getCourseName());
		}
		studentDto.setCourse(course);
		return studentDto;
	}

	@Override
	public Map<String, Object> saveStudent(StudentDto studentDto) {
		Map<String, Object> resData = new HashMap<>();
		Student student = null;
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		if (studentDto.getStudentId() != null) {
			Optional<Student> studentOption = studentRepo.findById(studentDto.getStudentId());
			student = studentOption.get();
			fieldMapperService.mergeObjects(studentDto, student);
		} else {
			student = fieldMapperService.populateDataToNewInstance(studentDto, Student.class);
			student.setJoinDate(date);
			student.setStudentCode(SuccessorStringGenerator.next(studentRepo.getLastStudentCode()));
		}
		User submittedUser = userRepository.findById(studentDto.getUserSeq()).get();
		student.setUser(submittedUser);
		// save center id.
		CoachingCenter center = coachingCenterRepository.findById(studentDto.getCenterId()).get();
		student.setCouchingCenter(center);
		// save payment details.
		PaymentDetail paymentDetail = fieldMapperService.populateDataToNewInstance(studentDto.getPaymentDetails(),
				PaymentDetail.class);
		paymentDetail.setCouchingCenter(center);
		paymentDetail.setStudent(student);
		paymentDetail.setUser(submittedUser);
		paymentDetail.setPaymentDate(date);
		student.getPayments().add(paymentDetail);
		// save course

		Integer lastCertificateNumber = studentCourseRepository.maxCertificateNumber();

		List<StudentCourse> courseStudentList = new ArrayList<>();
		for (String course : studentDto.getCourse()) {
			StudentCourse courseStudent = new StudentCourse();
			Course courseEntity = courseRepository.getOne(Integer.valueOf(course));
			courseStudent.setStudent(student);
			courseStudent.setCourse(courseEntity);
			courseStudent.setCourseFee(courseEntity.getFeesAmount());
			courseStudent.setStatus("JOINED");
			courseStudent.setUser(userRepository.findById(studentDto.getUserSeq()).get());
			courseStudent.setCertificateNumberSuffix(lastCertificateNumber + CommonUtility.getRandomFifty());
			courseStudent.setCenterSeq(studentDto.getCenterId());
			courseStudent.setRegisteredDate(date);
			courseStudentList.add(courseStudent);
			lastCertificateNumber = lastCertificateNumber + CommonUtility.getRandomFifty();
		}
		student.getStudentCourse().addAll(courseStudentList);
		Student studentSaved = studentRepo.save(student);
		resData.put("studentId", studentSaved.getStudentId());
		resData.put("studentCode", studentSaved.getStudentCode());
		return resData;
	}

	@Override
	public List<StudentDto> getStudentsBySenterSeq(Integer centerSeq) {

		List<Student> students = studentRepo.findByCouchingCenterCenterSeqId(centerSeq);
		List<StudentDto> studentDtos = new ArrayList<>();
		for (Student student : students) {
			studentDtos.add(populateStudentDto(student));
		}
		return studentDtos;
	}

	@Override
	public List<StudentDto> getSearchStudent(Integer centerSeq, String key) {
		String likeKey = "%" + key + "%";
		List<Student> students = studentRepo.findByCouchingCenterCenterSeqIdAndStudentNameLike(centerSeq, likeKey);
		List<StudentDto> studentDtos = new ArrayList<>();
		for (Student student : students) {
			studentDtos.add(fieldMapperService.populateDataToNewInstance(student, StudentDto.class));
		}
		return studentDtos;
	}

	@Override
	public Map<String, Object> getStudentPayments(Integer studentId) {
		Map<String, Object> dataMap = new HashMap<>();
		Optional<Student> student = studentRepo.findById(studentId);
		if (student.isPresent()) {
			List<PaymentDetail> paymentDetails = student.get().getPayments();
			List<PaymentDetailDto> paymentDetailDtos = new ArrayList<>();
			for (PaymentDetail paymentDetail : paymentDetails) {
				paymentDetailDtos
						.add(fieldMapperService.populateDataToNewInstance(paymentDetail, PaymentDetailDto.class));
			}
			dataMap.put("data", paymentDetailDtos);
			dataMap.put("student", fieldMapperService.populateDataToNewInstance(student.get(), StudentDto.class));
		}
		return dataMap;
	}

	@Override
	public Map<String, Object> getStudentPayment(Integer studentId) {
		Map<String, Object> dataMap = new HashMap<>();
		Optional<Student> student = studentRepo.findById(studentId);
		if (student.isPresent()) {
			List<PaymentDetail> paymentDetails = student.get().getPayments();
			PaymentDetailDto paymentDetailDto = new PaymentDetailDto();
			paymentDetailDto.setTotalFee(0);
			paymentDetailDto.setDueAmount(0);
			for (PaymentDetail paymentDetail : paymentDetails) {
				paymentDetailDto.setTotalFee(paymentDetailDto.getTotalFee() + paymentDetail.getTotalFee());
				paymentDetailDto.setDueAmount(paymentDetailDto.getDueAmount() + paymentDetail.getDueAmount());
			}
			dataMap.put("studentCode", student.get().getStudentCode());
			dataMap.put("data", paymentDetailDto);
			dataMap.put("student", fieldMapperService.populateDataToNewInstance(student.get(), StudentDto.class));
		}
		return dataMap;
	}

	@Override
	public String saveStudentPayment(PaymentDetailDto paymentDetailDto) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		try {
			PaymentDetail paymentDetail = new PaymentDetail();
			Student student = studentRepo.findById(paymentDetailDto.getStudentId()).get();
			paymentDetail.setStudent(student);
			paymentDetail.setDueAmount(paymentDetailDto.getPaidAmount() * -1);
			paymentDetail.setPaidAmount(paymentDetailDto.getPaidAmount());
			paymentDetail.setCouchingCenter(student.getCouchingCenter());
			paymentDetail.setPaymentDate(date);
			paymentDetail.setUser(userRepository.findById(paymentDetailDto.getUserSeq()).get());
			paymentDetailRepository.save(paymentDetail);
			return "Payment Successful!";
		} catch (Exception e) {
			return "Payment Failed!";
		}
	}

	@Override
	public ResponseDto getStudentCourses(Integer studentId) {

		List<StudentCourse> studentCourses = studentCourseRepository.findAllByStudentStudentId(studentId);
		List<LabelValuePair> labelValues = new ArrayList<>();

		for (StudentCourse studentCourse : studentCourses) {
			Course course = studentCourse.getCourse();
			LabelValuePair labelValue = new LabelValuePair();
			labelValue.setValue(course.getCourseId());
			labelValue.setLabel(course.getCourseName());
			labelValues.add(labelValue);
		}
		return new ResponseDto(200, "success", labelValues);
	}

	@Override
	public ResponseDto getStudentCourseCertificateInfo(Integer studentId, Integer courseId) {
		List<StudentCourse> studentCourses = studentCourseRepository
				.findAllByStudentStudentIdAndCourseCourseId(studentId, courseId);
		ResponseDto responseDto = null;
		if (!CollectionUtils.isEmpty(studentCourses)) {
			StudentCourse studentCourse = studentCourses.get(0);
			if (!studentCourse.getIsIndentCompleted()) {
				Course course = studentCourses.get(0).getCourse();
				Map<String, String> certificateInfo = new HashMap<>();
				certificateInfo.put("certificateNumber",
						course.getCertificateSeriesPrefix() + studentCourse.getCertificateNumberSuffix());
				responseDto = new ResponseDto(200, "success", certificateInfo);

			} else {
				responseDto = new ResponseDto(205, "Indent already Done !", null);
			}

		} else {
			responseDto = new ResponseDto(205, "Course Not Found!", null);
		}
		return responseDto;
	}

	@Override
	public ResponseDto saveStudentIndent(StudentIndentDto studentIndentDto) {
		String batchName = studentIndentDto.getBatchName();

		List<Map<String, Object>> studentIndents = studentIndentDto.getStudentIndents();
		List<StudentCourse> indentedStudentCourse = new ArrayList<>();
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());

		for (Map<String, Object> indentInfo : studentIndents) {

			Integer studentId = (Integer) indentInfo.get("studentId");
			Integer courseId = (Integer) indentInfo.get("courseSeq");
			String grade = (String) indentInfo.get("grade");
			String certificateNumber = (String) indentInfo.get("certificateNumber");

			List<StudentCourse> studentCourses = studentCourseRepository
					.findAllByStudentStudentIdAndCourseCourseId(studentId, courseId);

			StudentCourse studentCourse = studentCourses.get(0);
			studentCourse.setGradeObtained(grade);
			studentCourse.setIndentedDate(date);
			studentCourse.setCertificateNumber(certificateNumber);
			studentCourse.setIsIndentCompleted(true);
			String dateToBeAddedInBatchNAme = DateTimeUtil.dateToString(date, "dd-MM-yyyy");
			studentCourse.setBatchName(batchName + " " + dateToBeAddedInBatchNAme);

			indentedStudentCourse.add(studentCourse);

		}
		studentCourseRepository.saveAll(indentedStudentCourse);

		return new ResponseDto(200, "success", null);
	}

}
