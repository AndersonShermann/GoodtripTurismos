package com.goodtrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.goodtrip.model.Horario;
import com.goodtrip.repository.HorarioRepository;

@Controller
@RequestMapping
public class HorarioController {
	@Autowired
	private HorarioRepository horarioRepository;
	
	/*
	//Página Inicial	
	@GetMapping("/home")
	public String start() {
		return "index.html";
	}
	*/
 	
	// lista todos os dados do banco horario
	@GetMapping("/listar-horario")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("horarios/listar.html");
 
		List<Horario> horarios = horarioRepository.findAll();
		modelAndView.addObject("horario", horarios);
 
		return modelAndView;
	}
	
	@GetMapping("/cadastro-horario")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("horarios/cadastro.html");
 
		//passa um objeto Horario vazio por conta do construtor vazio.
		modelAndView.addObject("horario", new Horario());
 
		return modelAndView;
	}
	
	@PostMapping("/cadastrar-horario")
	public ModelAndView cadastrar(Horario horario){
 
		ModelAndView modelAndView = new ModelAndView("redirect:/listar-horario");
 
		horarioRepository.save(horario);
 
		return modelAndView;
	}
 
	
	@GetMapping("/{id}/editar-horario")
	public ModelAndView editar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("horarios/editar.html");
		Horario horario = horarioRepository.getReferenceById(id);
		modelAndView.addObject("horario", horario);
 
		return modelAndView;
	}
 
	@PostMapping("/{id}/editar-horario")
	public ModelAndView editar(Horario horario){		
 		
		horarioRepository.save(horario);
		ModelAndView modelAndView = new ModelAndView("redirect:/listar-horario");
 
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir-horario")
	public ModelAndView excluir(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listar-horario");
 
		horarioRepository.deleteById(id);
 
		return modelAndView;
	}
	
	@GetMapping("horario/{id}-horario")
	public ModelAndView detalhar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("horarios/detalhar.html");
 
		Horario horario = horarioRepository.getReferenceById(id);
		modelAndView.addObject("horario", horario);
 
		return modelAndView;
	}
}
