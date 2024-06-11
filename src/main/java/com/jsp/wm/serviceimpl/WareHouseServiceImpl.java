package com.jsp.wm.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.wm.entity.Warehouse;
import com.jsp.wm.mapper.WarehouseMapper;
import com.jsp.wm.repository.WarehouseRepository;
import com.jsp.wm.requestdto.WarehouseRequest;
import com.jsp.wm.responsedto.WarehouseResponse;
import com.jsp.wm.service.WarehouseService;
import com.jsp.wm.utility.ResponseStructure;

@Service
public class WarehouseServiceImpl implements WarehouseService {

	@Autowired
	private WarehouseRepository warehouseRepository;
	
	@Autowired
	private WarehouseMapper warehouseMapper;
	
	@Override
	public ResponseEntity<ResponseStructure<WarehouseResponse>> createWarehouse( WarehouseRequest warehouseRequest) {

			Warehouse warehouse = warehouseMapper.mapToWarehouse(warehouseRequest, new Warehouse());
			warehouseRepository.save(warehouse);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStructure<WarehouseResponse>()
					.setStatus(HttpStatus.CREATED.value())
					.setMessage("Warehouse created")
					.setData(warehouseMapper.mapToWarehouseResponse(warehouse)));
	}
}
