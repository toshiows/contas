package br.com.caelum.contas.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	private ContaDAO dao;
	
	@Autowired
	public ContaController(ContaDAO dao) {
		this.dao = dao;
	}
	
	
	@RequestMapping("formulario")
	public String formulario() {
		return "conta/formulario";
	}
	
	
	@RequestMapping("/adicionaConta")
	public String adicionar(@Valid Conta conta, BindingResult result) {
		
		if(result.hasErrors()) {
			return "conta/formulario";
		}
	
		dao.adiciona(conta);
		
		return "conta/sucesso";
	}
	
	@RequestMapping("/listaContas")
	public ModelAndView listar() {
		
		List<Conta> contas = dao.lista();
		
		ModelAndView mv = new ModelAndView("conta/lista");
		mv.addObject("contas", contas);
		
		return mv;
	}
	
	@RequestMapping("/deletarConta")
	public String deletar(Conta conta) {
		
		dao.remove(conta);
		
		return "redirect:/listaContas";
	}
	
	@RequestMapping("/mostraConta")
	public ModelAndView mostrar(Long id) {

		Conta conta = dao.buscaPorId(id);
		ModelAndView mv = new ModelAndView("conta/mostra");
		mv.addObject("conta", conta);
		
		return mv;
	}
	
	@RequestMapping("/alteraConta")
	public String alterar(Conta conta) {
		dao.altera(conta);
		
		return "redirect:/listaContas";
	}
	
	@RequestMapping("/pagaConta")
	public void pagar(Long id, HttpServletResponse response) {
		dao.paga(id);
		
		response.setStatus(200);
	}
}
