package com.jsp.wm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wm.requestdto.StorageRequest;
import com.jsp.wm.responsedto.StorageResponse;
import com.jsp.wm.service.StorageService;
import com.jsp.wm.utility.ResponseStructure;
import com.jsp.wm.utility.SimpleStructure;


@RestController
@RequestMapping("/api/v1")
public class StorageController {

	@Autowired
	private StorageService storageService;
	
	@PreAuthorize("hasAuthority('CREATE_STORAGE')")
	@PostMapping("warehouses/{wareHouseId}/storages")
	public ResponseEntity<SimpleStructure<String>> createStorage(@RequestBody  StorageRequest storageRequest ,
			@PathVariable int wareHouseId, @RequestParam("no_of_storage_units") int noOfStorageUnits ){
		return storageService.createStorage(storageRequest , wareHouseId , noOfStorageUnits);
	}
	
	
	@PreAuthorize("hasAuthority('UPDATE_STORAGE')")
	@PutMapping("/storages/{storageId}")
	public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(@PathVariable int storageId, @RequestBody StorageRequest storageRequest) {
	
		return storageService.updateStorage(storageId, storageRequest);
	}


}
