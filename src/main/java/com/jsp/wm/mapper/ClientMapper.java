package com.jsp.wm.mapper;

import org.springframework.stereotype.Component;

import com.jsp.wm.entity.Client;
import com.jsp.wm.requestdto.ClientRequest;
import com.jsp.wm.responsedto.ApiKeyResponse;

@Component
public class ClientMapper {

	public Client mapToClient(ClientRequest clientRequest, Client client)
	{
		client.setBusinessName(clientRequest.getBusinessName());
		client.setEmail(clientRequest.getEmail());
		client.setContactNumber(clientRequest.getContactNumber());
		
		return client;
	}
	
	public ApiKeyResponse mapToClientResponse(Client client) {
		return ApiKeyResponse.builder()
				.apikey(client.getApiKey())
				.message("Apikey created successfully")
				.build();
	}
}
