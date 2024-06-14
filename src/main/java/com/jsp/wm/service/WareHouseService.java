package com.jsp.wm.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.wm.requestdto.WareHouseRequest;
import com.jsp.wm.responsedto.WareHouseResponse;
import com.jsp.wm.utility.ResponseStructure;


public interface WareHouseService {

	ResponseEntity<ResponseStructure<WareHouseResponse>> createWarehouse( WareHouseRequest warehouseRequest);

	ResponseEntity<ResponseStructure<WareHouseResponse>> updateWarehouse( WareHouseRequest warehouseRequest,
			int warehouseId);

	ResponseEntity<ResponseStructure<WareHouseResponse>> findWarehouseById(int warehouseId);

	ResponseEntity<ResponseStructure<List<WareHouseResponse>>> findWarehouses();

	ResponseEntity<ResponseStructure<List<WareHouseResponse>>> findWarehousesByCity(String city);


}
