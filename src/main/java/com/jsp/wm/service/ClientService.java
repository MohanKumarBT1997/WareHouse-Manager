package com.jsp.wm.service;

import org.springframework.http.ResponseEntity;

import com.jsp.wm.requestdto.ClientRequest;
import com.jsp.wm.responsedto.ApiKeyResponse;
import com.jsp.wm.utility.ResponseStructure;

import jakarta.validation.Valid;

public interface ClientService {

	ResponseEntity<ResponseStructure<ApiKeyResponse>> registerClient(@Valid ClientRequest clientRequest);


}
