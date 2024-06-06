package com.jsp.wm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wm.requestdto.AdminRequest;
import com.jsp.wm.responsedto.AdminResponse;
import com.jsp.wm.service.AdminService;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1")
public class AdminController{
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/super_admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin(@RequestBody @Valid AdminRequest adminRequest){
		return adminService.createAdmin(adminRequest);
	}
	

}
