package com.app.coacingcenter.service;

import com.app.coacingcenter.dto.ProjectDto;
import com.app.coacingcenter.dto.ProjectPaymentDto;
import com.app.coacingcenter.dto.ResponseDto;

public interface ProjectService {

	ResponseDto getAllprojects();

	ResponseDto saveOrUpdate(ProjectDto project);

	ResponseDto getProjectInfo(ProjectDto project);

	ResponseDto addPayment(ProjectPaymentDto projectPaymentDto);

}
