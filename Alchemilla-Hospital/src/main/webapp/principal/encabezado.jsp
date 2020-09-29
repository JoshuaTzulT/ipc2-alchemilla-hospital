<%@page import="proyecto.alchemilla.entidades.Usuario"%>
<link rel="stylesheet" href="CSS/estilo.css">
<div id="encabezado">
	<div style="text-align: center; font-size: 35px; color: white;">${TITULO}</div>  
	<div style="position: fixed; right: 10px; top: 10px;color: white;">Bienvenido <%=((Usuario)session.getAttribute("USUARIO_ACTUAL")).getNombreDeUsuario()%></div>
        <div style="position: fixed; right: 10px; top: 30px; color: white;"><a href="<%=request.getContextPath()%>/logout">Salir</a></div>
</div>




<%--<%=request.getContextPath()%>--%>