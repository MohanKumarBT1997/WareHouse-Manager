package com.jsp.wm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.wm.requestdto.ClientRequest;
import com.jsp.wm.responsedto.ApiKeyResponse;
import com.jsp.wm.service.ClientService;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@PostMapping("/clients")
	public ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClient(@RequestBody @Valid ClientRequest clientRequest){
		return clientService.registerClient(clientRequest);
	}
	
}
