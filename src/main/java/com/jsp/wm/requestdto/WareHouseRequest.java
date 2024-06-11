package com.jsp.wm.requestdto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseRequest {
	
	@NotNull(message = "Warehouse name cannot be null")
	@NotBlank(message = "Warehouse name cannot be blank")
	private String name;
	
}
