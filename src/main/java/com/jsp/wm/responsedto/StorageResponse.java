package com.jsp.wm.responsedto;

import java.util.List;

import com.jsp.wm.enums.MaterialTypes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageResponse {

	private int storageId;
	private String blockName;
	private String section;
	private double capacityInKg;
	private List<MaterialTypes> materialTypes;
	private double maxAdditionalWeight;
	private double availableArea;

}
