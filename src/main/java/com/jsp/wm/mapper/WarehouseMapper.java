package com.jsp.wm.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.wm.entity.Address;
import com.jsp.wm.entity.WareHouse;
import com.jsp.wm.requestdto.WareHouseRequest;
import com.jsp.wm.responsedto.AddressResponse;
import com.jsp.wm.responsedto.WareHouseResponse;

@Component
public class WarehouseMapper {

	public WareHouse mapToWarehouse(WareHouseRequest warehouseRequest,WareHouse warehouse) {
		warehouse.setName(warehouseRequest.getName());
		return warehouse;
	}
	
	public WareHouseResponse mapToWarehouseResponse(WareHouse warehouse) {
		return WareHouseResponse.builder()
				.name(warehouse.getName())
				.warehouseId(warehouse.getWarehouseId())
				.totalCapacityInKg(warehouse.getTotalCapacity()).build();
	}
	
	
	@Autowired
	private AddressMapper addressMapper;
	
	public WareHouseResponse mapToWareHouseAddress(WareHouse warehouse, Address address) {
		WareHouseResponse response = mapToWarehouseResponse(warehouse);
		response.setAddressResponse(addressMapper.mapToAddressResponse(address));
		
		return response;
	}
}
