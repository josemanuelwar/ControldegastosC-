package com.bolsadeides.springboot.web1.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "forward:/app/index";
		//return "redirect:/app/index";
	}
}
