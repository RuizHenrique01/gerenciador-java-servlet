<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa}" method="post">
		<label for="nomeEmpresa">
			Nome:
			<input id="nomeEmpresa" type="text" name="nome"/>
		</label>
		
		<label for="dataAberturaEmpresa">
			Data de abertura:
			<input id="dataAberturaEmpresa" type="datetime" name="dataAbertura"/>
		</label>

		<button type="submit">Enviar</button>
	</form>
</body>
</html>