package com.app.coacingcenter.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.CourseCreationRequestDto;
import com.app.coacingcenter.dto.CoursesDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.service.CoursesService;

@RestController
@RequestMapping("/courses")
public class CoursesController {

	private static final Logger LOGGER = Logger.getLogger(CoursesController.class.getName());

	@Autowired
	CoursesService coursesService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseDto save(@RequestBody CourseCreationRequestDto courseCreationRequestDto) {

		return coursesService.saveCourses(courseCreationRequestDto);

	}

	@RequestMapping(value = "/getByCenterSeqenceNumber/{centerSeq}", method = RequestMethod.GET)
	public ResponseDto getByCenterSeqenceNumber(@PathVariable Integer centerSeq) {

		return coursesService.getByCenterSeqenceNumber(centerSeq);

	}

	@RequestMapping(value = "/active/{centerSeq}", method = RequestMethod.GET)
	public ResponseDto getActiveCources(@PathVariable Integer centerSeq) {
		return coursesService.getActiveCources(centerSeq);

	}

	@RequestMapping(value = "/updateCourse", method = RequestMethod.POST)
	public ResponseDto updateCourse(@RequestBody CoursesDto coursesDto) {

		return coursesService.updateCourse(coursesDto);

	}

	@RequestMapping(value = "/download-ebook/{courseSeq}", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile(@PathVariable Integer courseSeq, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = coursesService.loadFileAsResource(courseSeq);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			LOGGER.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

}
