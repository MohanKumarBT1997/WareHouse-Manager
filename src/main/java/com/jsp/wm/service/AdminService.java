package com.jsp.wm.service;

import org.springframework.http.ResponseEntity;

import com.jsp.wm.requestdto.AdminRequest;
import com.jsp.wm.responsedto.AdminResponse;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> createSuperAdmin(@Valid AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@Valid AdminRequest adminRequest, int wareHouseId);



}
