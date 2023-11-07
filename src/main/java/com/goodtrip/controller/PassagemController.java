package com.goodtrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.goodtrip.model.Passagem;
import com.goodtrip.repository.PassagemRepository;

@Controller
@RequestMapping
public class PassagemController {

	@Autowired
	private PassagemRepository passagemRepository;
	
	/*
	//Página Inicial	
	@GetMapping("/home")
	public String start() {
		return "index.html";
	}
	*/
 	
	// lista todos os dados do banco passagem
	@GetMapping("/listar-passagem")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("passagens/listar.html");
 
		List<Passagem> passagems = passagemRepository.findAll();
		modelAndView.addObject("passagem", passagems);
 
		return modelAndView;
	}
	
	@GetMapping("/cadastro-passagem")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("passagens/cadastro.html");
 
		//passa um objeto Passagem vazio por conta do construtor vazio.
		modelAndView.addObject("passagem", new Passagem());
 
		return modelAndView;
	}
	
	@PostMapping("/cadastrar-passagem")
	public ModelAndView cadastrar(Passagem passagem){
 
		ModelAndView modelAndView = new ModelAndView("redirect:/listar-passagem");
 
		passagemRepository.save(passagem);
 
		return modelAndView;
	}
 
	
	@GetMapping("/{id}/editar-passagem")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("passagens/editar.html");
 
		Passagem passagem = passagemRepository.getReferenceById(id);
		modelAndView.addObject("passagem", passagem);
 
		return modelAndView;
	}
 
	@PostMapping("/{id}/editar-passagem")
	public ModelAndView editar(Passagem passagem){		
 		
		passagemRepository.save(passagem);
		ModelAndView modelAndView = new ModelAndView("redirect:/listar-passagem");
 
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir-passagem")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listar-passagem");
 
		passagemRepository.deleteById(id);
 
		return modelAndView;
	}
	
	@GetMapping("/passagem/{id}-passagem")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("passagens/detalhar.html");
 
		Passagem passagem = passagemRepository.getReferenceById(id);
		modelAndView.addObject("passagem", passagem);
 
		return modelAndView;
	}
}
