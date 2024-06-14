package com.jsp.wm.requestdto;

import java.util.List;

import com.jsp.wm.enums.MaterialTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StorageRequest {

	private String blockName;
	private String section;
	private double capacityInWeight;
	private double lengthInMeters;
	private double breadthInMeters;
	private double heightInMeters;
	private List<MaterialTypes> materialTypes;

}
