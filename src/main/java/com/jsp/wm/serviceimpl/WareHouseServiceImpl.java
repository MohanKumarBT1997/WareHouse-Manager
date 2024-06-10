package com.jsp.wm.serviceimpl;

import org.springframework.http.ResponseEntity;

import com.jsp.wm.requestdto.WareHouseRequest;
import com.jsp.wm.responsedto.WareHouseResponse;
import com.jsp.wm.service.WareHouseService;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

public class WareHouseServiceImpl implements WareHouseService {

	@Override
	public ResponseEntity<ResponseStructure<WareHouseResponse>> createWareHouse(
			@Valid WareHouseRequest wareHouseRequest) {
		return null;
	}
	
	

}
