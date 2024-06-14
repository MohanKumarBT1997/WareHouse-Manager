package com.jsp.wm.serviceimpl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.wm.entity.Client;
import com.jsp.wm.mapper.ClientMapper;
import com.jsp.wm.repository.ClientRepository;
import com.jsp.wm.requestdto.ClientRequest;
import com.jsp.wm.responsedto.ApiKeyResponse;
import com.jsp.wm.service.ClientService;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private ClientMapper clientMapper;

	@Override
	public ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClient(@Valid ClientRequest clientRequest) {
		
		String apiKey = UUID.randomUUID().toString();
		
		Client client = clientMapper.mapToClient(clientRequest, new Client());
		client.setApiKey(apiKey);

		
		client = clientRepository.save(client);

		return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseStructure<ApiKeyResponse>()
				.setStatus(HttpStatus.CREATED.value())
				.setMessage("Client Registered")
				.setData(clientMapper.mapToClientResponse(client)));
	}

}
