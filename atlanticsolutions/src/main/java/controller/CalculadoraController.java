package controller;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("calculadora")
public class CalculadoraController {
	
	Logger logger;
	
	@RequestMapping(value = "/")
	public String hello() {
		return "deu certo";
	}
	
	@RequestMapping(value = "/soma", method = RequestMethod.GET)
	public Double soma(Double numero1, Double numero2) {
		try {
			if (numero1 != null && numero2 != null) 
				return Double.sum(numero1, numero2);
			throw new Exception("Erro ao calcular soma: números nulos"); 
			
		} catch (Exception e) {
			logger.error("Erro ao calcular soma: ", e);
		}
		return numero2;
	}

}
