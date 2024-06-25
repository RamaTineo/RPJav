<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/head.jsp"%>
<!--------------- MAIN -------------->
<main class="main">

	<div class="select-pj">
		<c:forEach items="${enemigos}" var="p">
			<div class="card">
				<img src="${p.img}" class="card-img-top" alt="${p.tipo}">
				<div class="card-body">
					<h5 class="card-title">${p.name}de clase ${p.tipo}</h5>
					<p class="card-text"></p>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Daño: ${p.atk}</li>
					<li class="list-group-item">Salud: ${p.vida}</li>
					<li class="list-group-item">Defensa: ${p.deff}</li>
				</ul>

				<!-- 			TODO  Hacer pag de combate. Insertar card de enemigos y propia y ver como programar el combate -->

			</div>
		</c:forEach>
		<div class="select-pj">
			<c:forEach items="${personajes}" var="p">
				<div class="card">
					<img src="${p.img}" class="card-img-top" alt="${p.tipo}">
					<div class="card-body">
						<h5 class="card-title">${p.name}de clase ${p.tipo}</h5>
						<p class="card-text"></p>
					</div>
					<ul class="list-group list-group-flush">
						<li class="list-group-item">Daño: ${p.atk}</li>
						<li class="list-group-item">Salud: ${p.vida}</li>
						<li class="list-group-item">Defensa: ${p.deff}</li>
					</ul>

					<!-- 			TODO  Hacer pag de combate. Insertar card de enemigos y propia y ver como programar el combate -->

				</div>
			</c:forEach>
		</div>
	</div>

</main>
<!--------------- FOOTER -------------->
<footer> </footer>
</body>
</html>