package com.app.coacingcenter.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.FeeReceiptModel;
import com.app.coacingcenter.entity.CoachingCenter;
import com.app.coacingcenter.entity.StudentCourse;
import com.app.coacingcenter.repository.CoachingCenterRepository;
import com.app.coacingcenter.repository.PaymentDetailRepository;
import com.app.coacingcenter.repository.StudentCourseRepository;
import com.app.coacingcenter.utils.CurrencyConvertor;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@RestController
@RequestMapping(value = "invoice")
public class InvoiceController {

	@Autowired
	private Configuration freemarkerConfig;

	@Autowired
	CoachingCenterRepository coachingCenterRepository;

	@Autowired
	StudentCourseRepository studentCourseRepository;

	@Autowired
	PaymentDetailRepository paymentDetailRepository;

	@RequestMapping(method = RequestMethod.POST)
	public String invoice(@RequestBody FeeReceiptModel model) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		return getReceiptHtmlString(model);

	}

	public String getReceiptHtmlString(FeeReceiptModel model) throws TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException {
		CoachingCenter center = coachingCenterRepository.findById(model.getCenterSeq()).get();
		model.setPostalAddress(center.getPostalAddress());
		model.setReceiptNo(
				"DIGPAY" + paymentDetailRepository.getLastPaySeq(model.getStudentId(), model.getCenterSeq()));
		model.setPaidAmount(CurrencyConvertor.convertToINR(Double.valueOf(model.getPaidAmount())));
		setCourse(model);
		Template t = freemarkerConfig.getTemplate("fee-receipt.ftl");
		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
		return html;

	}

	private void setCourse(FeeReceiptModel model) {
		StringBuilder coursesBuilder = new StringBuilder();
		if (!StringUtils.hasText(model.getCourseName()) && null != model.getStudentId()) {
			List<StudentCourse> studentCourses = studentCourseRepository
					.findAllByStudentStudentId(model.getStudentId());
			for (StudentCourse studentCourse : studentCourses) {
				if (StringUtils.hasText(coursesBuilder.toString())) {
					coursesBuilder.append(",");
					coursesBuilder.append(studentCourse.getCourse().getCourseName());
				} else {
					coursesBuilder.append(studentCourse.getCourse().getCourseName());
				}
			}
		} else if (StringUtils.hasText(model.getCourseName())) {
			coursesBuilder.append(model.getCourseName());
		}
		model.setCourseName(coursesBuilder.toString());
	}

}
