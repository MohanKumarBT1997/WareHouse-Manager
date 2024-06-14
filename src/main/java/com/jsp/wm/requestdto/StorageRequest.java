package com.jsp.wm.requestdto;

import java.util.List;

import com.jsp.wm.enums.MaterialTypes;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
	
	@Enumerated(EnumType.STRING)
	private List<MaterialTypes> materialTypes;

}
