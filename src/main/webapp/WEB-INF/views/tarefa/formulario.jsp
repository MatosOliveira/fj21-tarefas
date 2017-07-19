<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionando Tarefas</title>
</head>
<body>

	<!-- Cabecalho da pagina -->
	<c:import url="/WEB-INF/views/tarefa/cabecalho.jsp"/>
	
	<h3>Adicionar Tarefas</h3>
	
	<form action="adicionaTarefa" method="post">
		<p>Descri��o</p>
		<br />
		<textarea name="descricao" rows="5" cols="100"></textarea>
		<br /> <input type="submit" value="Adicionar">
	</form>
	
	<!-- Rodape da pagina -->
	<c:import url="/WEB-INF/views/tarefa/rodape.jsp"/>
	
</body>
</html>