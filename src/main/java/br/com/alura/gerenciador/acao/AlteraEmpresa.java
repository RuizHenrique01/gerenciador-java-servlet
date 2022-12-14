package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando empresa");
		String empresa = request.getParameter("nome");
		String paramDataAbertura = request.getParameter("dataAbertura");
		String idParam = request.getParameter("id");
		Integer id  = Integer.valueOf(idParam);
		
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			dataAbertura = sdf.parse(paramDataAbertura);
		}catch(ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa emp = banco.buscaPorId(id);
		emp.setNome(empresa);
		emp.setDataAbertura(dataAbertura);
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
