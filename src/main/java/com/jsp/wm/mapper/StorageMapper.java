package com.jsp.wm.mapper;

import org.springframework.stereotype.Component;

import com.jsp.wm.entity.Storage;
import com.jsp.wm.requestdto.StorageRequest;
import com.jsp.wm.responsedto.StorageResponse;

@Component
public class StorageMapper {

	public Storage mapToStorage(StorageRequest storageRequest, Storage storage) {
		storage.setBlockName(storageRequest.getBlockName());
		storage.setSection(storageRequest.getSection());
		storage.setLengthInMeters(storageRequest.getLengthInMeters());
		storage.setBreadthInMeters(storageRequest.getBreadthInMeters());
		storage.setHeightInMeters(storageRequest.getHeightInMeters());
		storage.setCapacityInWeight(storageRequest.getCapacityInWeight());
		storage.setMaterialTypes(storageRequest.getMaterialTypes());

		return storage;

	}

	public StorageResponse mapToStorageResponse(Storage storage) {
		return StorageResponse.builder()
				.storageId(storage.getStorageId())
				.blockName(storage.getBlockName())
				.section(storage.getSection())
				.capacityInKg(storage.getCapacityInWeight())
				.materialTypes(storage.getMaterialTypes())
				.availableArea(storage.getAvailableArea())
				.maxAdditionalWeight(storage.getMaxAdditionalWeight())
				.materialTypes(storage.getMaterialTypes())
				.build();

	}

}
