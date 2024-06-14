package com.jsp.wm.service;

import org.springframework.http.ResponseEntity;

import com.jsp.wm.requestdto.StorageRequest;
import com.jsp.wm.responsedto.StorageResponse;
import com.jsp.wm.utility.ResponseStructure;
import com.jsp.wm.utility.SimpleStructure;

public interface StorageService {


	public ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest, int wareHouseId, int noOfStorageUnits);

	public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(int storageId,
			StorageRequest storageRequest);


}
