package com.jsp.wm.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.wm.entity.WareHouse;
import com.jsp.wm.exception.WarehouseNotFoundByCityException;
import com.jsp.wm.exception.WarehouseNotFoundByIdException;
import com.jsp.wm.mapper.WarehouseMapper;
import com.jsp.wm.repository.AddressRepository;
import com.jsp.wm.repository.WareHouseRepository;
import com.jsp.wm.requestdto.WareHouseRequest;
import com.jsp.wm.responsedto.WareHouseResponse;
import com.jsp.wm.service.WareHouseService;
import com.jsp.wm.utility.ResponseStructure;


@Service
public class WareHouseServiceImpl implements WareHouseService {

	@Autowired
	private WareHouseRepository warehouseRepository;
	
	@Autowired
	private WarehouseMapper warehouseMapper;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public ResponseEntity<ResponseStructure<WareHouseResponse>> createWarehouse( WareHouseRequest warehouseRequest) {

			WareHouse warehouse = warehouseMapper.mapToWarehouse(warehouseRequest, new WareHouse());
			warehouseRepository.save(warehouse);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStructure<WareHouseResponse>()
					.setStatus(HttpStatus.CREATED.value())
					.setMessage("Warehouse created")
					.setData(warehouseMapper.mapToWarehouseResponse(warehouse)));
	}

	@Override
	public ResponseEntity<ResponseStructure<WareHouseResponse>> updateWarehouse(WareHouseRequest warehouseRequest,
			int warehouseId) {
		
		
		return	warehouseRepository.findById(warehouseId)
				.<ResponseEntity<ResponseStructure<WareHouseResponse>>>map(exWarehouse -> {

			exWarehouse = warehouseMapper.mapToWarehouse(warehouseRequest, exWarehouse);

			WareHouse warehouse = warehouseRepository.save(exWarehouse);

			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseStructure<WareHouseResponse>()
							.setStatus(HttpStatus.OK.value())
							.setMessage("Warehouse Updated")
							.setData(warehouseMapper.mapToWarehouseResponse(warehouse)));
		}).orElseThrow(()-> new WarehouseNotFoundByIdException("Warehouse Not Found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<WareHouseResponse>> findWarehouseById(int warehouseId) {
			
		return warehouseRepository.findById(warehouseId).
				<ResponseEntity<ResponseStructure<WareHouseResponse>>>map(warehouse->{
			
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(new ResponseStructure<WareHouseResponse>()
							.setStatus(HttpStatus.FOUND.value())
							.setMessage("Warehouse Found")
							.setData(warehouseMapper.mapToWarehouseResponse(warehouse)));
		}).orElseThrow(()-> new WarehouseNotFoundByIdException("Warehouse not found by Id"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<WareHouseResponse>>> findWarehouses() {
		
		List<WareHouseResponse> warehouses = warehouseRepository.findAll().stream()
	            .map(warehouseMapper::mapToWarehouseResponse).toList();
		
		
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<WareHouseResponse>>()
						.setStatus(HttpStatus.FOUND.value())
						.setMessage("Warehouses Found")
						.setData(warehouses));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<WareHouseResponse>>> findWarehousesByCity(String city) {
		
		List<WareHouseResponse> addressResponse = addressRepository.findWarehousesByCity(city).stream()
				.map(address -> warehouseMapper.mapToWareHouseAddress(address.getWarehouse(), address)).toList(); 
		
		if(addressResponse.isEmpty())
			throw new WarehouseNotFoundByCityException("City not found");
		
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(new ResponseStructure<List<WareHouseResponse>>()
						.setStatus(HttpStatus.FOUND.value())
						.setMessage("Warehouses Found by "+city)
						.setData(addressResponse));
		
	}
}
