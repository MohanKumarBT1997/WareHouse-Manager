package com.jsp.wm.mapper;

import org.springframework.stereotype.Component;

import com.jsp.wm.entity.Warehouse;
import com.jsp.wm.requestdto.WarehouseRequest;
import com.jsp.wm.responsedto.WarehouseResponse;

@Component
public class WarehouseMapper {

	public Warehouse mapToWarehouse(WarehouseRequest warehouseRequest,Warehouse warehouse) {
		warehouse.setName(warehouseRequest.getName());
		return warehouse;
	}
	
	public WarehouseResponse mapToWarehouseResponse(Warehouse warehouse) {
		return WarehouseResponse.builder()
				.name(warehouse.getName())
				.warehouseId(warehouse.getWarehouseId())
				.totalCapacity(0).build();
	}
}
