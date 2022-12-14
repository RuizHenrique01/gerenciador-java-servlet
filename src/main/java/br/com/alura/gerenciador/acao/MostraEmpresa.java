package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Mostrando empresa");
		String idParam = request.getParameter("id");
		Integer id  = Integer.valueOf(idParam);
		Banco banco = new Banco();
		Empresa empresa = banco.buscaPorId(id);
		
		request.setAttribute("empresa", empresa);
		return "forward:formAlteraEmpresa.jsp";
	}

}
