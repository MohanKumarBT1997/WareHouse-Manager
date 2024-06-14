package com.jsp.wm.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.wm.entity.Storage;
import com.jsp.wm.entity.WareHouse;
import com.jsp.wm.exception.StorageNotFoundByIdException;
import com.jsp.wm.exception.WarehouseNotFoundByIdException;
import com.jsp.wm.mapper.StorageMapper;
import com.jsp.wm.repository.StorageRepository;
import com.jsp.wm.repository.WareHouseRepository;
import com.jsp.wm.requestdto.StorageRequest;
import com.jsp.wm.responsedto.StorageResponse;
import com.jsp.wm.service.StorageService;
import com.jsp.wm.utility.ResponseStructure;
import com.jsp.wm.utility.SimpleStructure;

@Service
public class StorageServiceImpl implements StorageService{

	@Autowired
	private StorageRepository storageRepository;

	@Autowired
	private WareHouseRepository wareHouseRespository;

	@Autowired
	private StorageMapper storageMapper;


	@Override
	public ResponseEntity<SimpleStructure<String>> createStorage(StorageRequest storageRequest,
			int wareHouseId, int noOfStorageUnits)  {

		WareHouse wareHouse =  wareHouseRespository.findById(wareHouseId)
				.orElseThrow(()-> new WarehouseNotFoundByIdException("Warehouse not found"));

		List<Storage> storages = new ArrayList<Storage>();

		int count = 0;

		while(noOfStorageUnits > 0) {

			Storage storage  = storageMapper.mapToStorage(storageRequest, new Storage());

			storage.setMaxAdditionalWeight(storageRequest.getCapacityInWeight());
			storage.setAvailableArea(storageRequest.getLengthInMeters() * storageRequest.getBreadthInMeters()
					* storageRequest.getHeightInMeters());

			wareHouse.setTotalCapacity(storageRequest.getCapacityInWeight() * noOfStorageUnits 
					+ wareHouse.getTotalCapacity());

			storage.setWareHouse(wareHouse);

			storages.add(storage);
			count++;
			noOfStorageUnits --;
		}

		storageRepository.saveAll(storages);


		return ResponseEntity.status(HttpStatus.CREATED).body(new SimpleStructure<String>()
				.setStatus(HttpStatus.CREATED.value())
				.setMesssage(" "+count + " Storages created"));

	}


	@Override
	public ResponseEntity<ResponseStructure<StorageResponse>> updateStorage(int storageId,
			StorageRequest storageRequest) {
		return storageRepository.findById(storageId).map(existingStorage -> {

			existingStorage = storageMapper.mapToStorage(storageRequest, existingStorage);

			 return ResponseEntity.status(HttpStatus.OK).body(new ResponseStructure<StorageResponse>()
					.setStatus(HttpStatus.OK.value())
					.setMessage("Storage updsates")
					.setData(storageMapper.mapToStorageResponse(existingStorage)));
			
		}).orElseThrow(() -> new StorageNotFoundByIdException("Storage not found by Id"));
	}


}
