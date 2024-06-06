package com.jsp.wm.mapper;




import org.springframework.stereotype.Component;

import com.jsp.wm.entity.Admin;
import com.jsp.wm.requestdto.AdminRequest;
import com.jsp.wm.responsedto.AdminResponse;
@Component
public class AdminMapper {

	public Admin mapToAdmin(AdminRequest adminRequest, Admin admin) {
		admin.setName(adminRequest.getName());
		admin.setEmail(adminRequest.getEmail());
		admin.setPassword(adminRequest.getPassword());
		return admin;
	}

	public AdminResponse mapToAdminResponse(Admin admin) {
		return AdminResponse.builder()
				.name(admin.getName())
				.email(admin.getEmail())
				.adminId(admin.getAdminId())
				.adminType(admin.getAdminType())
				.build();
	}

}
