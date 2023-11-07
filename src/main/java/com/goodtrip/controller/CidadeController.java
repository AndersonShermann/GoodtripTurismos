package com.goodtrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.goodtrip.model.Cidade;
import com.goodtrip.repository.CidadeRepository;

@Controller
@RequestMapping
public class CidadeController {
	@Autowired
	private CidadeRepository cidadeRepository;
	
	/*
	//Página Inicial	
	@GetMapping("/home")
	public String start() {
		return "index.html";
	}
	*/
 	
	// lista todos os dados do banco cidade
	@GetMapping("/listar-cidade")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("cidades/listar.html");
 
		List<Cidade> cidades = cidadeRepository.findAll();
		modelAndView.addObject("cidade", cidades);
 
		return modelAndView;
	}
	
	@GetMapping("/cadastro-cidade")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("cidades/cadastro.html");
 
		//passa um objeto Cidade vazio por conta do construtor vazio.
		modelAndView.addObject("cidade", new Cidade());
 
		return modelAndView;
	}
	
	@PostMapping("/cadastrar-cidade")
	public ModelAndView cadastrar(Cidade cidade){
 
		ModelAndView modelAndView = new ModelAndView("redirect:/listar-cidade");
 
		cidadeRepository.save(cidade);
 
		return modelAndView;
	}
 
	
	@GetMapping("/{id}/editar-cidade")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cidades/editar.html");
 
		Cidade cidade = cidadeRepository.getReferenceById(id);
		modelAndView.addObject("cidade", cidade);
 
		return modelAndView;
	}
 
	@PostMapping("/{id}/editar-cidade")
	public ModelAndView editar(Cidade cidade){		
 		
		cidadeRepository.save(cidade);
		ModelAndView modelAndView = new ModelAndView("redirect:/listar-cidade");
 
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir-cidade")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listar-cidade");
 
		cidadeRepository.deleteById(id);
 
		return modelAndView;
	}
	
	@GetMapping("cidade/{id}-cidade")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cidades/detalhar.html");
 
		Cidade cidade = cidadeRepository.getReferenceById(id);
		modelAndView.addObject("cidade", cidade);
 
		return modelAndView;
	}
}
