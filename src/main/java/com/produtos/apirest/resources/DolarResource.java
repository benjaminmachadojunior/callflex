package com.produtos.apirest.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.produtos.apirest.models.Dolar;
import com.produtos.apirest.repository.DolarRepository;
import com.produtos.apirest.service.DolarService;

@RestController
@RequestMapping(value="/api")
//@Api(value="API REST Dolar")
public class DolarResource {

	@Autowired
	DolarRepository dolarRepository;
	@Autowired
	DolarService dolarService;
	
//	@ApiOperation(value="Retorna uma lista de Dolar")
	@GetMapping("/dolar/{id}")
	public String findByConsultaDolar(@PathVariable(value="id") Long id){
		return dolarService.findByConsultaDolar(id);
//		return dolarRepository.findAll();
	}

//	@ApiOperation(value="Retorna uma lista de Dolar")
	@GetMapping("/dolarpordia")
	public String findByConsultaDolarpordia(@RequestParam("datainicio") Date datainicio,
			@RequestParam("datafim") Date datafim){
		return dolarService.findByConsultaDolarpordia(datainicio, datafim);
//		return dolarRepository.findAll();
	}
	
	
}
