<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<c:url value="/entrada" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="login-parcial.jsp" />

	<form action="${linkServletNovaEmpresa}" method="post">
		<label for="nomeEmpresa">
			Nome:
			<input id="nomeEmpresa" type="text" name="nome" value="${ empresa.nome }"/>
		</label>
		
		<label for="dataAberturaEmpresa">
			Data de abertura:
			<input id="dataAberturaEmpresa" type="datetime" name="dataAbertura" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/>"/>
		</label>

		<input type="hidden" name="id" value="${ empresa.id }"/>
		<input type="hidden" name="acao" value="AlteraEmpresa"/>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>