<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/head.jsp"%>



<main class="main">
	<pre>${personaje}</pre>

	<form action="formulario" method="post">
		<div>
			<input type="hidden" name="id" value="${personaje.id}">
		</div>
		<div>
			<label for="usuario" class="col-sm-3 col-form-label"></label> <input
				class="form-control" id="usuario" name="usuario" placeholder="Usuario"
				value="${sessionScope.user}"type="hidden">
		</div>
		<div>
			<label for="name" class="col-sm-3 col-form-label">Nombre</label> <input
				class="form-control" id="name" name="name" placeholder="Nombre"
				value="${personaje.name}">
		</div>
		<div>
			<label for="img" class="col-sm-3 col-form-label">URL de tu imagen</label> <input
				class="form-control" id="img" name="img" placeholder="URL imagen"
				value="${personaje.img}">
		</div>
		<div>
			<label for="tipo" class="col-sm-3 col-form-label">Tipo</label> <input
				class="form-control" id="tipo" name="tipo" placeholder="tipo"
				value="${personaje.tipo}">
		</div>
		<div>
			<label for="vida" class="col-sm-3 col-form-label">Vida</label> <input
				class="form-control" id="vida" name="vida" placeholder="vida"
				value="${personaje.vida}">
		</div>
		<div>
			<label for="atk" class="col-sm-3 col-form-label">Daño</label> <input
				class="form-control" id="atk" name="atk" placeholder="daño"
				value="${personaje.atk}">
		</div>
		<div>
			<label for="deff" class="col-sm-3 col-form-label">Defensa</label> <input
				class="form-control" id="deff" name="deff" placeholder="Defensa"
				value="${personaje.deff}">
		</div>
		<div class="btn-form">
			<button type="submit" class="btn a-active">Guardar</button>
		</div>
	</form>
</main>
</body>
</html>