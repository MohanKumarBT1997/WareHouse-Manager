package com.jsp.wm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.wm.requestdto.WareHouseRequest;
import com.jsp.wm.responsedto.WareHouseResponse;
import com.jsp.wm.service.WareHouseService;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/v1")
public class WareHouseController {

	@Autowired
	private WareHouseService wareHouseService;
	
	@PostMapping("/warehouses")
	public String createWareHouse(@RequestBody @Valid WareHouseRequest wareHouseRequest){
		return "WareHouse created";
	}
}
