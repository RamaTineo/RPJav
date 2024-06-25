<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/head.jsp"%>
<!--------------- MAIN -------------->
<main class="main">
<form action="login" method="post">
	<h2 class="titulo">Ingrese su usuario y contraseña:</h2>
  <div class="row login">
    <label for="user" class="col-sm-2 col-form-label">Usuario</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="user" name="user">
    </div>
  </div>
  <div class="row login">
    <label for="pass" class="col-sm-2 col-form-label">Contraseña</label>
    <div class="col-sm-10">
      <input type="password" class="form-control" id="pass" name="pass">
    </div>
  </div>
  <div class="btn-form">
  <button type="submit" class="btn a-active">Ingresar</button>
  </div>
  <div class=" danger">${error}</div>
 </form> 
 <a href="crear-usuario" class="btn a-active">Crear usuario</a>


</main>
<!--------------- FOOTER -------------->
<footer> </footer>
</body>

</html>