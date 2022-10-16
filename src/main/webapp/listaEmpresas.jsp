<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.List, br.com.alura.gerenciador.servlet.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html>
<c:url value="/removeEmpresa" var="linkRemoveEmpresa"/>
<c:url value="/mostraEmpresa" var="linkMostraEmpresa"/>
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
	
		<p>Lista de empresas:</p>
	
		<c:forEach items="${empresas}" var="empresa">
			<li>${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>
			<a href="${linkMostraEmpresa}?id=${ empresa.id }">editar</a>
			<a href="${linkRemoveEmpresa}?id=${ empresa.id }">excluir</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>