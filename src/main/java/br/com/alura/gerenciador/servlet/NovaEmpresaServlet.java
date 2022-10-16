package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		response.sendRedirect("listaEmpresa");
		
		//RequestDispatcher rd =  request.getRequestDispatcher("/listaEmpresa");
		//request.setAttribute("empresa", novaEmpresa.getNome());
		//rd.forward(request, response);
	}

}
