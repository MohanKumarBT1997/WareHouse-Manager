package com.jsp.wm.service;

import org.springframework.http.ResponseEntity;

import com.jsp.wm.requestdto.WarehouseRequest;
import com.jsp.wm.responsedto.WarehouseResponse;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface WarehouseService {

	ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse(@Valid WarehouseRequest warehouseRequest);

}
