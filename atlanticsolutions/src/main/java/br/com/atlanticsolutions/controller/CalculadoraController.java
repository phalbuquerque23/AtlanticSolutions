package br.com.atlanticsolutions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.atlanticsolutions.dto.CalculadoraDTO;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {
	@PostMapping(consumes = {"application/xml"}, produces = {"application/json"})
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> calcula(CalculadoraDTO calculadoraDTO) {
		try {
			if (calculadoraDTO.getNumero1() != null && calculadoraDTO.getNumero2() != null) {
				if(calculadoraDTO.getOperacao().equals("soma")) {
					Double soma =  calculadoraDTO.getNumero1() + calculadoraDTO.getNumero2();
					String resultado = "O resultado é "+soma;
					return new ResponseEntity<>(resultado, HttpStatus.OK);
				}else if(calculadoraDTO.getOperacao().equals("subtrai")) {
					Double subtrai = calculadoraDTO.getNumero1() - calculadoraDTO.getNumero2();
					String resultado = "O resultado é "+subtrai;
					return new ResponseEntity<>(resultado, HttpStatus.OK);
				}else {
						return new ResponseEntity<>("Erro ao calcular, contate os adinistradores.", HttpStatus.INTERNAL_SERVER_ERROR);
					}
				}
			return new ResponseEntity<>("Erro ao calcular: números nulos", HttpStatus.INTERNAL_SERVER_ERROR);
			
		} catch (Exception e) {
			return new ResponseEntity<>("Erro ao calcular: "+e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
