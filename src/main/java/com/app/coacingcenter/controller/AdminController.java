package com.app.coacingcenter.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.dto.UserDto;
import com.app.coacingcenter.utils.CustomMailSender;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private Configuration freemarkerConfig;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseDto list() {
		return new ResponseDto(200, "success", null);
	}

	@RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
	public ResponseDto show(@PathVariable Integer id) {
		return null;

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseDto save(@RequestBody UserDto user) {
		return null;
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public ResponseDto updateProduct(@PathVariable Integer id, @RequestBody UserDto user) {
		return null;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ResponseDto delete(@PathVariable Integer id) {
		return null;
	}

	@RequestMapping(value = "/testemail/{courseId}/{emailId}", method = RequestMethod.GET)
	public String testemail(@PathVariable Integer courseId, @PathVariable String emailId)
			throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException,
			TemplateException {

		Template t = freemarkerConfig.getTemplate("ebook-link-email.ftl");

		Map<String, Object> model = new HashMap<>();
		model.put("name", "Sathiya");
		model.put("courseId", courseId);

		String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

		CustomMailSender.sendEmail(emailId, "Ebook For " + "Java", html);

		return "success";

	}

}
