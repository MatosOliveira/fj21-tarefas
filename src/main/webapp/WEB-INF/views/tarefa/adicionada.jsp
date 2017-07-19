<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tarefa adicionada</title>
</head>
<body>

	<!-- Cabecalho da pagina -->
	<c:import url="/WEB-INF/views/tarefa/cabecalho.jsp"/>
	
	<p>Nova tarefa adicionada com sucesso!</p>
	
	<!-- Botao para exibir lista das tarefas -->
	<p><input type="button" onclick="window.location.href='listaTarefas'" value="Exibir Lista de Tarefas"> </p>
	
	<!-- Rodape da pagina -->
	<c:import url="/WEB-INF/views/tarefa/rodape.jsp"/>
	
</body>
</html>