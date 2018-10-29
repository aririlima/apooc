package com.appoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.appoc.model.Usuario;
import com.appoc.repository.UserRepository;

//CONTROLLER RESPONSÁVEL PELO LOGIN, LOGOUT E CADASTRO DE UCUÁRIOS NO SISTEMA

@RestController
@RequestMapping(value="/")
public class CadastroController {

	@Autowired
	private UserRepository ur;	
	
	@GetMapping(value="")
	public ModelAndView getLogin() {
				
		return new ModelAndView("global/login");
	}
	
	@PostMapping(value="{login}/{senha}")
	public ModelAndView doLogin(@PathVariable("login") String login, @PathVariable("senha") String senha) {
		
		System.out.println("AKIIII");
		Usuario user = ur.findByEmail(login);
				
		if(user != null && user.getSenha() == senha) {
			return new ModelAndView("global/home");
		}else {
			return new ModelAndView("global/cadastroNaoRealizado");
		}
	}
	
	@GetMapping(value="userCadastro")
	public ModelAndView getCadastro(Usuario user) {
		return new ModelAndView("global/userCadastro");
	}
	
	@PostMapping(value="userCadastro")
	public ModelAndView userCadastro(Usuario user) {
//		Role role = null;
//		role.setRoleId("user");
//		user.getUserRoles().add(role);
		try {
			System.out.println("ENTROU 1");
			if(user != ur.findByEmail(user.getEmail())) {
				System.out.println("ENTROU 2");
				user.setSenha(new BCryptPasswordEncoder().encode(user.getSenha()));
				//user.setUserRoles(user.getUserRoles());
				ur.save(user);
			}
			return new ModelAndView("global/cadastroRealizado");
		}catch(Exception ex) {
			System.out.println("ENTROU 3");
			System.out.println(ex);
			return null;
		}
	}
	
}

