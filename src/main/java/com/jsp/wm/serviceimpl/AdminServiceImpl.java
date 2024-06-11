
package com.jsp.wm.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.wm.entity.Admin;
import com.jsp.wm.enums.AdminType;
import com.jsp.wm.exception.IllegalOperationException;
import com.jsp.wm.exception.WarehouseNotFoundByIdException;
import com.jsp.wm.mapper.AdminMapper;
import com.jsp.wm.repository.AdminRepository;
import com.jsp.wm.repository.WareHouseRepository;
import com.jsp.wm.requestdto.AdminRequest;
import com.jsp.wm.responsedto.AdminResponse;
import com.jsp.wm.service.AdminService;
import com.jsp.wm.utility.ResponseStructure;


@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private WareHouseRepository warehouseRepository;

	@Autowired
	private AdminMapper adminMapper;

	@Override
	public ResponseEntity<ResponseStructure<AdminResponse>> createSuperAdmin( AdminRequest adminRequest){

		if(adminRepository.existsByAdminType(AdminType.SUPER_ADMIN))
			throw new IllegalOperationException("SUPER_ADMIN already present");


		Admin  admin =  adminMapper.mapToAdmin(adminRequest , new Admin());
		admin.setAdminType(AdminType.SUPER_ADMIN);
		admin= adminRepository.save(admin);

		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStructure<AdminResponse>()
				.setStatus(HttpStatus.CREATED.value())
				.setMessage("Super Admin created")
				.setData(adminMapper.mapToAdminResponse(admin)));
	}

	public ResponseEntity<ResponseStructure<AdminResponse>> createAdmin( AdminRequest adminRequest,
			int warehouseId) {
			
		return warehouseRepository.findById(warehouseId).map(warehouse->{
			Admin admin = adminMapper.mapToAdmin(adminRequest, new Admin());
			admin.setAdminType(AdminType.ADMIN);
			admin=adminRepository.save(admin);

			warehouse.setAdmin(admin);
			
			warehouseRepository.save(warehouse);
		
		   return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStructure<AdminResponse>()
					.setStatus(HttpStatus.CREATED.value())
					.setMessage("Admin created")
					.setData(adminMapper.mapToAdminResponse(admin)));


		}).orElseThrow(()-> new WarehouseNotFoundByIdException("Invalid WareHouse Id"));
	}
}


