package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Criando nova empresa");
		PrintWriter out = response.getWriter();
		String empresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("dataAbertura");
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		}catch(ParseException e) {
			throw new ServletException(e);
		}
		Empresa novaEmpresa = new Empresa(empresa);
		novaEmpresa.setDataAbertura(dataAbertura);
		Banco banco = new Banco();
		banco.adicionar(novaEmpresa);
		
		request.setAttribute("empresa", novaEmpresa.getNome());
		
		return "redirect:entrada?acao=ListaEmpresas";
		
		//RequestDispatcher rd =  request.getRequestDispatcher("/listaEmpresa");
		//request.setAttribute("empresa", novaEmpresa.getNome());
		//rd.forward(request, response);
	}

}
