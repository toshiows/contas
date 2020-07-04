package br.com.caelum.contas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.UsuarioDAO;
import br.com.caelum.contas.modelo.Usuario;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String formLogin() {
		return "usuario/formLogin";
	}
	
	@RequestMapping("/efetuaLogin")
	public String login(Usuario usuario, HttpSession session) {
		
		UsuarioDAO dao = new UsuarioDAO();
		
		if(dao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu-login";
		}
		
		return "redirect:/login";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
