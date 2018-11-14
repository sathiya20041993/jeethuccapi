package com.app.coacingcenter.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.DataFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.app.coacingcenter.FileStorageProperties;
import com.app.coacingcenter.dto.CoachingCenterDto;
import com.app.coacingcenter.dto.CourseCreationRequestDto;
import com.app.coacingcenter.dto.CoursesDto;
import com.app.coacingcenter.dto.FileDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.entity.CoachingCenter;
import com.app.coacingcenter.entity.Course;
import com.app.coacingcenter.exceptions.FileStorageException;
import com.app.coacingcenter.exceptions.MyFileNotFoundException;
import com.app.coacingcenter.repository.CoachingCenterRepository;
import com.app.coacingcenter.repository.CourseRepository;
import com.app.coacingcenter.service.CochingService;
import com.app.coacingcenter.service.CoursesService;
import com.app.coacingcenter.utils.FieldMapperService;

@Service
public class CoursesServiceImpl implements CoursesService {

	private final Path fileStorageLocation;

	@Autowired
	CoachingCenterRepository coachingCenterRepository;

	@Autowired
	FieldMapperService fieldMapperService;

	@Autowired
	CochingService cochingService;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	public CoursesServiceImpl(FileStorageProperties fileStorageProperties) {
		this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();

		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
					ex);
		}
	}

	@Override
	public ResponseDto saveCourses(CourseCreationRequestDto courseCreationRequestDto) {
		CoachingCenter coachingCenter = null;
		Optional<CoachingCenter> centerOptional = coachingCenterRepository
				.findById(courseCreationRequestDto.getCenterDto().getCenterSeq());
		List<CoursesDto> courses = courseCreationRequestDto.getCourses();

		Set<String> courseNames = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);

		for (CoursesDto cDto : courses) {
			courseNames.add(cDto.getCourseName());
		}
		if (courseNames.size() != courses.size()) {
			return new ResponseDto(415, "Duplicate course not allowed.", null);
		}
		List<Course> persistingCourse = new ArrayList<>();

		if (centerOptional.isPresent()) {

			coachingCenter = centerOptional.get();

			for (CoursesDto courseDto : courses) {

				Course course = fieldMapperService.populateDataToNewInstance(courseDto, Course.class);
				course.setCouchingCenter(coachingCenter);
				persistingCourse.add(course);
			}

			coachingCenter.setCourses(persistingCourse);
			coachingCenterRepository.save(coachingCenter);
			return new ResponseDto(200, "success", null);
		}
		return new ResponseDto(410, "Failed", null);
	}

	@Override
	public ResponseDto getByCenterSeqenceNumber(Integer centerSeq) {
		CourseCreationRequestDto courseCreationDto = new CourseCreationRequestDto();

		Optional<CoachingCenter> centerOptional = coachingCenterRepository.findById(centerSeq);

		if (centerOptional.isPresent()) {
			CoachingCenter coachingCenter = centerOptional.get();
			CoachingCenterDto centerDto = fieldMapperService.populateDataToNewInstance(coachingCenter,
					CoachingCenterDto.class);
			courseCreationDto.setCenterDto(centerDto);

			List<CoursesDto> coursesDto = cochingService.getCoursesInCenter(coachingCenter);
			if (!CollectionUtils.isEmpty(coursesDto)) {
				coursesDto.sort((a, b) -> Boolean.compare(b.getIsActive(), a.getIsActive()));

			}
			courseCreationDto.setCourses(coursesDto);
			return new ResponseDto(200, "Success", courseCreationDto);
		}
		return new ResponseDto(410, "Failed", null);
	}

	@Override
	public ResponseDto getActiveCources(Integer centerSeq) {
		CourseCreationRequestDto courseCreationDto = new CourseCreationRequestDto();

		Optional<CoachingCenter> centerOptional = coachingCenterRepository.findById(centerSeq);

		if (centerOptional.isPresent()) {
			CoachingCenter coachingCenter = centerOptional.get();
			CoachingCenterDto centerDto = fieldMapperService.populateDataToNewInstance(coachingCenter,
					CoachingCenterDto.class);
			courseCreationDto.setCenterDto(centerDto);

			List<CoursesDto> coursesDto = cochingService.getActiveCoursesInCenter(coachingCenter);
			if (!CollectionUtils.isEmpty(coursesDto)) {
				coursesDto.sort((a, b) -> Boolean.compare(b.getIsActive(), a.getIsActive()));

			}
			courseCreationDto.setCourses(coursesDto);
			return new ResponseDto(200, "Success", courseCreationDto);
		}
		return new ResponseDto(410, "Failed", null);
	}

	@Override
	public ResponseDto updateCourse(CoursesDto coursesDto) {

		Optional<Course> optCourse = courseRepository.findById(coursesDto.getCourseSeq());

		if (optCourse.isPresent()) {
			Course course = optCourse.get();
			course.setFeesAmount(coursesDto.getFees());
			course.setIsActive(coursesDto.getIsActive());
			course.setIsEbookAvailable(coursesDto.getIsEbookAvailable());
			course.setFileName(coursesDto.getFileName());

			courseRepository.save(course);
		}

		return new ResponseDto(200, "Success", null);
	}

	public void saveFile(FileDto savefile, CoursesDto coursesDto) throws IOException, DataFormatException {

		String compressed_base64_string = savefile.getBase64();
		String outputFilePath = "F:/courseZipFiles/" + savefile.getName();
		File file = new File(outputFilePath);
		FileOutputStream fos = new FileOutputStream(file);
		byte[] zipData = Base64.getMimeDecoder().decode(compressed_base64_string);
		fos.write(zipData);
		fos.close();
	}

	@Override
	public Resource loadFileAsResource(Integer courseSeq) {

		Optional<Course> optCourse = courseRepository.findById(courseSeq);

		if (optCourse.isPresent()) {
			Course course = optCourse.get();
			String fileName = course.getFileName();
			if (!StringUtils.hasText(fileName)) {
				throw new MyFileNotFoundException("File not found ");
			}
			try {
				Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
				Resource resource = new UrlResource(filePath.toUri());
				if (resource.exists()) {
					return resource;
				} else {
					throw new MyFileNotFoundException("File not found " + fileName);
				}
			} catch (MalformedURLException ex) {
				throw new MyFileNotFoundException("File not found " + fileName, ex);
			}
		} else {
			throw new MyFileNotFoundException("File not found ");
		}

	}

	// public static void main(String[] args) {
	// Set<String> s1 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
	// s1.addAll(Arrays.asList(new String[] { "a", "b", "c", "A" }));
	//
	// for (String s : s1) {
	// System.out.println(s);
	// }
	// }
}
