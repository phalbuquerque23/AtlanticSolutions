package br.com.atlanticsolutions.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.atlanticsolutions.dto.CalculadoraDTO;

@RestController
public class HomeController {
	@RequestMapping("/")
	   public ModelAndView index(){
		ModelAndView mv = new ModelAndView("/calculadora");
        mv.addObject("calculadoraDTO", new CalculadoraDTO());
        return mv;
	}
}