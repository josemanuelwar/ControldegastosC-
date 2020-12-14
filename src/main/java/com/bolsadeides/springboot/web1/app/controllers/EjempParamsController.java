package com.bolsadeides.springboot.web1.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjempParamsController {
	
	@GetMapping("/")
	public String index(){
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto",required = false, defaultValue = "algun valor") String texto, Model model) {
		model.addAttribute("resultado","El texto enviado es: "+texto);
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String param(@RequestParam() String saludo, @RequestParam() Integer numero, Model model) {
		model.addAttribute("resultado","El saludo enviado es: "+ saludo +" y el numero es : "+ numero);
		return "params/ver";
	}
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model mode) {
		String saludo= request.getParameter("saludo");
		Integer numero=null;
		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		}catch (NumberFormatException e) {
			// TODO: handle exception
			numero=0;
		}
			mode.addAttribute("resultado","El saludo enviado es: "+ saludo +" y el numero es : "+ numero);
		return "params/ver";
	}
}
