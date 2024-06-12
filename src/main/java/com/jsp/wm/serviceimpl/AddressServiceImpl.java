package com.jsp.wm.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.wm.entity.Address;
import com.jsp.wm.exception.AddressNotFoundByIdException;
import com.jsp.wm.exception.WarehouseNotFoundByIdException;
import com.jsp.wm.mapper.AddressMapper;
import com.jsp.wm.repository.AddressRepository;
import com.jsp.wm.repository.WareHouseRepository;
import com.jsp.wm.requestdto.AddressRequest;
import com.jsp.wm.responsedto.AddressResponse;
import com.jsp.wm.service.AddressService;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private AddressMapper addressMapper;
	
	@Autowired
	private WareHouseRepository warehouseRepository;

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> addAddress(@Valid AddressRequest addressRequest,
			int warehouseId) {
		
	  return warehouseRepository.findById(warehouseId).map(warehouse ->{
			
			Address address = addressMapper.mapToAddress(addressRequest, new Address());
			
			address.setWarehouse(warehouse);
			address = addressRepository.save(address);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStructure<AddressResponse>()
					.setStatus(HttpStatus.CREATED.value())
					.setMessage("Address added").
					setData(addressMapper.mapToAddressResponse(address))
					);
					
		}).orElseThrow(() -> new  WarehouseNotFoundByIdException("Invalid WareHouse Id"));
		
	}

	@Override
	public ResponseEntity<ResponseStructure<AddressResponse>> updateAddress(@Valid AddressRequest addressRequest,
			int addressId) {
		
		return addressRepository.findById(addressId).map(exAddress -> {
			addressMapper.mapToAddress(addressRequest, exAddress);
			Address address = addressRepository.save(exAddress);
			
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseStructure<AddressResponse>()
					.setStatus(HttpStatus.OK.value())
					.setMessage("Address updated").
					setData(addressMapper.mapToAddressResponse(address))
					);
			
		}).orElseThrow(() -> new AddressNotFoundByIdException("Address not found by Id"));
	}

}
