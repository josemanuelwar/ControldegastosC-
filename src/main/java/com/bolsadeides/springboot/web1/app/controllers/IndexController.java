package com.bolsadeides.springboot.web1.app.controllers;


//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeides.springboot.web1.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@RequestMapping(value = {"/index","/"," ","/home"}, method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		/*otra forma de pasar varibles e Modelmap  Model model*/
		//model.addAttribute("titulo", "hola desde el Spring framework");
		//map.put("titulo","hola desde Spring framewor con Map");
		mv.addObject("titulo",textoIndex);
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();
		usuario.setApellido("sanchez juarez");
		usuario.setNombre("jose manuel");
		usuario.setEmail("josemanuelwar@hotmail.es");
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo",textoPerfil.concat(usuario.getNombre()));
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		/*List<Usuario> usuario = new ArrayList<>();
		usuario.add(new Usuario("jose manuel", "sanchez juarez","josemanuelwar@hotmail.es"));
		usuario.add(new Usuario("manuel", "sanchez juarez","josemanuelwar@hotmail.es"));
		usuario.add(new Usuario("jose", "sanchez juarez","josemanuelwar@hotmail.es"));
		*/
		model.addAttribute("titulo",textoListar);
		//model.addAttribute("usuarios",usuario);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuario(){
		List<Usuario> usuario = Arrays.asList(new Usuario("jose manuel", "sanchez juarez","josemanuelwar@hotmail.es"),
				new Usuario("manuel", "sanchez juarez","josemanuelwar@hotmail.es"),
				new Usuario("jose", "sanchez juarez","josemanuelwar@hotmail.es")
				,new Usuario("lucrecia", "sanchez juarez","josemanuelwar@hotmail.es"));
		return usuario;
	}
}
