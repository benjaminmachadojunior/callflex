package com.produtos.apirest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import java.text.Collator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.springframework.web.client.RestTemplate;

import com.produtos.apirest.models.Dolar;
import com.produtos.apirest.repository.DolarRepository;

@Service
public class DolarService {

	@Autowired
	DolarRepository dolarRepository;
	
	public String findByConsultaDolar(Long id){
		
		RestTemplate restTemprete = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.1/dados/ultimos/"+id;
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemprete.exchange(resourceURL, HttpMethod.GET, entity, String.class);
		return response.getBody();
	}
	public String findByConsultaDolarpordia(Date datainicio, Date datafim){
		
		RestTemplate restTemprete = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		String resourceURL = "https://api.bcb.gov.br/dados/serie/bcdata.sgs.1/dados/ultimos/90";
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<String> response = restTemprete.exchange(resourceURL, HttpMethod.GET, entity, String.class);
		dolarRepository.saveTodos(response.getBody());
		
		return response.getBody();
	}
}
