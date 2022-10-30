<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List,br.com.alura.gerenciador.modelo.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<c:url value="/entrada" var="linkEntrada"/>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java standard Taglib</title>
</head>
<body>
	<ul>
	
		<c:if test="${not empty empresa}">
			<p>Empresa ${ empresa } cadastrada com sucesso!</p>
		</c:if>
	
		<a href="${linkEntrada}?acao=NovaEmpresaForm">Nova Empresa</a>
		
		<p>Lista de empresas:</p>
	
		<c:forEach items="${empresas}" var="empresa">
			<li>${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
			<a href="${linkEntrada}?acao=MostraEmpresa&id=${ empresa.id }">editar</a>
			<a href="${linkEntrada}?acao=RemoveEmpresa&id=${ empresa.id }">excluir</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>