package com.jsp.wm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wm.requestdto.WarehouseRequest;
import com.jsp.wm.responsedto.WarehouseResponse;
import com.jsp.wm.service.WarehouseService;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1")
public class WarehouseController {

	@Autowired
	private WarehouseService warehouseService;
	
	@PreAuthorize("hasAuthority('CREATE_WAREHOUSE')")
	@PostMapping("/warehouses")
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(@RequestBody @Valid WarehouseRequest warehouseRequest){
		return warehouseService.createWarehouse(warehouseRequest);
	}
}
