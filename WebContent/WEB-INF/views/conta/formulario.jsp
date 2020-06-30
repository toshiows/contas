<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Contas</title>
</head>
<body>
<h3>Fomulário cadastro de contas</h3>

<form action="adicionaConta" method="POST">
	Descrição:
	<textarea rows="5" cols="20" name="descricao"></textarea>
	<br/>
	Valor:
	<input type="text" name="valor">
	<br/>
	Tipo:
	<select name="tipo">
		<option value="ENTRADA">ENTRADA</option>
		<option value="SAIDA">SAIDA</option>
	</select>
	<input type="submit" value="Adcionar">
</form>
</body>
</html>