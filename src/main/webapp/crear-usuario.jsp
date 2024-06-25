<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/head.jsp"%>



<main class="main">
	<pre>${usuario}</pre>

	<form action="crear-usuario" method="post">
		<div>
			<input type="hidden" name="id" value="${usuario.id}">
		</div>
		<div>
			<label for="user" class="col-sm-3 col-form-label">Usuario</label> <input
				class="form-control" id="user" name="user" placeholder="Usuario"
				>
		</div>
		<div>
			<label for="email" class="col-sm-3 col-form-label">Email</label> <input type="email"
				class="form-control" id="email" name="email" placeholder="Email"
				>
		</div>
		<div>
			<label for="pass" class="col-sm-3 col-form-label">Contraseña</label> <input type="password"
				class="form-control" id="pass" name="pass" placeholder="Contraseña"
				>
		</div>
	
		<div class="btn-form">
			<button type="submit" class="btn a-active">Guardar</button>
		</div>
	</form>
</main>
</body>
</html>