package br.com.atlanticsolutions.controller;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.atlanticsolutions.dto.CalculadoraDTO;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {
	
	Logger logger;
	
	@PostMapping(consumes = {"application/xml"}, produces = {"application/json"})
	@RequestMapping(value = "/soma", method = RequestMethod.POST)
	public ResponseEntity<?> soma(@RequestBody CalculadoraDTO somaDTO) {
		try {
			if (somaDTO.getNumero1() != null && somaDTO.getNumero2() != null) {
				Double soma =  somaDTO.getNumero1() + somaDTO.getNumero2();
				return new ResponseEntity<>(soma, HttpStatus.OK);
				}
			return new ResponseEntity<>("Erro ao calcular soma: números nulos", HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (Exception e) {
			logger.error("Erro ao calcular soma: ", e);
			return new ResponseEntity<>("Erro ao calcular soma: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = {"application/xml"}, produces = {"application/json"})
	@RequestMapping(value = "/subtrai", method = RequestMethod.POST)
	public ResponseEntity<?> subtrai(@RequestBody CalculadoraDTO calculadoraDTO) {
		try {
			if (calculadoraDTO.getNumero1() != null && calculadoraDTO.getNumero2() != null) {
				Double soma =  calculadoraDTO.getNumero1() - calculadoraDTO.getNumero2();
				return new ResponseEntity<>(soma, HttpStatus.OK);
				}
			return new ResponseEntity<>("Erro ao calcular subtração: números nulos", HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (Exception e) {
			logger.error("Erro ao calcular soma: ", e);
			return new ResponseEntity<>("Erro ao calcular subtração: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
