package com.app.coacingcenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.coacingcenter.dto.CoachingCenterDto;
import com.app.coacingcenter.dto.ResponseDto;
import com.app.coacingcenter.service.CochingService;
import com.app.coacingcenter.utils.UserSessionUtils;

@RestController
@RequestMapping("/couching-center")
public class CoachingCenterController {

	@Autowired
	CochingService cochingService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ResponseDto list() {
		return cochingService.getAllcouchingcenters();

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseDto save(@RequestBody CoachingCenterDto dto) {

		return cochingService.save(dto);

	}

	@RequestMapping(value = "/get/{centerId}", method = RequestMethod.GET)
	public ResponseDto getDetail(@RequestHeader("userId") String userId, @RequestHeader("sessionId") String sessionId,
			@PathVariable String centerId) {

		if (!UserSessionUtils.validateUserSession(userId, sessionId)) {
			return new ResponseDto(400, "Forbidden", false);
		}
		return cochingService.getCenterDetail(centerId);

	}

	@RequestMapping(value = "/checkDuplicate/{centerId}", method = RequestMethod.GET)
	public ResponseDto checkCenterIdExist(@PathVariable String centerId) {
		return cochingService.checkCenterIdExist(centerId);

	}

	@RequestMapping(value = "/labelValue", method = RequestMethod.GET)
	public ResponseDto getAllAsLabelValue() {
		return cochingService.getAllAsLabelValue();

	}

	@RequestMapping(value = "/counselors/{centerSeq}", method = RequestMethod.GET)
	public ResponseDto getcounselorsAsLabelValue(@PathVariable Integer centerSeq) {
		return cochingService.getcounselorsAsLabelValue(centerSeq);

	}

	@RequestMapping(value = "/batches-with-pending-certificate/{centerId}", method = RequestMethod.GET)
	public ResponseDto getBAtchesWithPendingCertificate(@PathVariable String centerId) {
		return cochingService.getBAtchesWithPendingCertificate(centerId);

	}

}
