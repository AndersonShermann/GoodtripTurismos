package com.goodtrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.goodtrip.model.Usuario;
import com.goodtrip.repository.UsuarioRepository;

@Controller
@RequestMapping("/")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	//Página Inicial
	@GetMapping("/home")
	public String start() {
		return "index.html";
	}

 
	// lista todos os dados do banco usuario
	@GetMapping("/listar")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("usuarios/listar.html");
 
		List<Usuario> usuarios = usuarioRepository.findAll();
		modelAndView.addObject("usuario", usuarios);
 
		return modelAndView;
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastrar() {
		ModelAndView modelAndView = new ModelAndView("usuarios/cadastro.html");
 
		//passa um objeto Usuario vazio por conta do construtor vazio.
		modelAndView.addObject("usuario", new Usuario());
 
		return modelAndView;
	}
	
	@PostMapping("/cadastrar")
	public ModelAndView cadastrar(Usuario usuario){
 
		ModelAndView modelAndView = new ModelAndView("redirect:/listar");
 
		usuarioRepository.save(usuario);
 
		return modelAndView;
	}
 
	
	@GetMapping("/{id}/editar")
	public ModelAndView editar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("usuarios/editar");
 
		Usuario usuario = usuarioRepository.getReferenceById(id);
		modelAndView.addObject("usuario", usuario);
 
		return modelAndView;
	}
 
	@PostMapping("/{id}/editar")
	public ModelAndView editar(Usuario usuario){		
 		
		usuarioRepository.save(usuario);
		ModelAndView modelAndView = new ModelAndView("redirect:/listar");
 
		return modelAndView;
	}
	
	@GetMapping("/{id}/excluir")
	public ModelAndView excluir(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("redirect:/listar");
 
		usuarioRepository.deleteById(id);
 
		return modelAndView;
	}
	
	@GetMapping("/usuario/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("usuarios/detalhar.html");
 
		Usuario usuario = usuarioRepository.getReferenceById(id);
		modelAndView.addObject("usuario", usuario);
 
		return modelAndView;
	}
	
	
}