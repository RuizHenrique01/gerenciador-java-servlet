<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<c:url value="/entrada" var="linkServletNovaEmpresa"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa}" method="post">
		<label for="login">
			Login:
			<input id="login" type="text" name="login"/>
		</label>
		
		<label for="senha">
			Senha:
			<input id="senha" type="password" name="senha"/>
		</label>

		<input type="hidden" name="acao" value="Login"/>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>