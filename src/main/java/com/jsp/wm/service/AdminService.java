package com.jsp.wm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.wm.enums.AdminType;
import com.jsp.wm.requestdto.AdminRequest;
import com.jsp.wm.responsedto.AdminResponse;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface AdminService {

	ResponseEntity<ResponseStructure<AdminResponse>> createSuperAdmin( AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> createAdmin( AdminRequest adminRequest, int wareHouseId);

	ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@Valid AdminRequest adminRequest);

	ResponseEntity<ResponseStructure<AdminResponse>> updateAdminBySuperAdmin(@Valid AdminRequest adminRequest,
			int adminId);

	ResponseEntity<ResponseStructure<AdminResponse>> findAdminById(int adminId);


	ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllByAdminType(AdminType adminType);

}
