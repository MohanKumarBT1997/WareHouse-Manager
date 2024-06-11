package com.jsp.wm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wm.requestdto.AdminRequest;
import com.jsp.wm.responsedto.AdminResponse;
import com.jsp.wm.service.AdminService;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class AdminController{
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<AdminResponse>> createSuperAdmin(@RequestBody @Valid AdminRequest adminRequest){
		return adminService.createSuperAdmin(adminRequest);
	}
	
	
	@PreAuthorize("hasAuthority('CREATE_ADMIN')")
	@PostMapping("/warehouses/{warehouseId}/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin
	(@RequestBody @Valid AdminRequest adminRequest, @PathVariable int warehouseId){
		return adminService.createAdmin(adminRequest,warehouseId);
	}
	
	@PutMapping("/admins")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdmin(@RequestBody @Valid AdminRequest adminRequest){
		return adminService.updateAdmin(adminRequest);
	}
	
	@PreAuthorize("hasAuthority('UPDATE_ADMIN')")
	@PutMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> updateAdminBySuperAdmin(@RequestBody @Valid AdminRequest adminRequest,
			@PathVariable int adminId){
		return adminService.updateAdminBySuperAdmin(adminRequest,adminId);
	}
	
	@PreAuthorize("hasAuthority('READ')")
	@GetMapping("/admins/{adminId}")
	public ResponseEntity<ResponseStructure<AdminResponse>> findAdminById(@PathVariable int adminId){
		return adminService.findAdminById(adminId);
	}
	
	@PreAuthorize("hasAuthority('READ')")
	@GetMapping("/admins")
	public ResponseEntity<ResponseStructure<List<AdminResponse>>> findAllAdmins(){
		return adminService.findAllAdmins();
	}
	
}
