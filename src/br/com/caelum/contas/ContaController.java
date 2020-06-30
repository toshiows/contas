package br.com.caelum.contas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

@Controller
public class ContaController {

	@RequestMapping("formulario")
	public String formulario() {
		return "conta/formulario";
	}
	
	
	@RequestMapping("/adicionaConta")
	public String adiciona(Conta conta) {
		
		ContaDAO dao = new ContaDAO();
		dao.adiciona(conta);
		
		return "conta/sucesso";
	}
}
