package com.jsp.wm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wm.requestdto.WareHouseRequest;
import com.jsp.wm.responsedto.WareHouseResponse;
import com.jsp.wm.service.WareHouseService;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1")
public class WareHouseController {

	@Autowired
	private WareHouseService warehouseService;
	
	@PreAuthorize("hasAuthority('CREATE_WAREHOUSE')")
	@PostMapping("/warehouses")
	public ResponseEntity<ResponseStructure<WareHouseResponse>> createWarehouse(@RequestBody @Valid WareHouseRequest warehouseRequest){
		return warehouseService.createWarehouse(warehouseRequest);
	}
	
	
	@PreAuthorize("hasAuthority('UPDATE_WAREHOUSE')")
	@PutMapping("/warehouses/{warehouseId}")
	public ResponseEntity<ResponseStructure<WareHouseResponse>> updateWarehouse(@RequestBody @Valid WareHouseRequest warehouseRequest,
			@PathVariable int warehouseId){
		return warehouseService.updateWarehouse(warehouseRequest,warehouseId);
	}
}
