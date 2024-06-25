<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="./CSS/Styles.css">
<title>RPGon || El RPG que deberia ser un carrito de compras</title>
</head>

<body class="body">
	<!--------------- HEADER -------------->
	<header>
		<nav class="navbar">
				<h1 class="h1">RPGon el RPG de cartas hecho con Java</h1>
			<div>
				<a href="./index"> <img
					src="https://res.cloudinary.com/ramatineo/image/upload/v1669752612/RPGon/images/logo_bp8gfn.png"
					alt="Logo espadas" width="100" height="100"
					class="d-inline-block align-text-top">
				</a>
			<ul>
			<li><c:choose>
			<c:when test="${sessionScope.user !=null }">
			<h4>Bienvenido ${sessionScope.user} <a href="logout" class="btn danger">Cerrar sesión</a></h4>
			</c:when>
			<c:otherwise>
			<a href="login" class="btn a-active">Iniciar sesión</a>
			</c:otherwise>
			</c:choose>
			</li>
			<c:if test="${sessionScope.user !=null }">
			<li>
				<a href="formulario" class="btn a-active">Crear personaje</a>
				</li>
				</c:if>
				</ul>
			</div>
		</nav>
	</header>