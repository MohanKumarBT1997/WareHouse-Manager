package com.jsp.wm.mapper;

import org.springframework.stereotype.Component;

import com.jsp.wm.entity.Address;
import com.jsp.wm.requestdto.AddressRequest;
import com.jsp.wm.responsedto.AddressResponse;

@Component
public class AddressMapper {

	public Address mapToAddress(AddressRequest addressRequest, Address address) {
		
		address.setAddressLine(addressRequest.getAddressLine());
		address.setCity(addressRequest.getCity());
		address.setState(addressRequest.getState());
		address.setCountry(addressRequest.getCountry());
		address.setPincode(addressRequest.getPincode());
		return address;
	}
	
	
	public AddressResponse mapToAddressResponse(Address address) {
		
		return AddressResponse.builder()
				.addressId(address.getAddressId())
				.addressLine(address.getAddressLine())
				.city(address.getCity())
				.state(address.getState())
				.country(address.getCountry())
				.pincode(address.getPincode())
				.build();
	}
}
