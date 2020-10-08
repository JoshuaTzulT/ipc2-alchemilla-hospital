<%@page import="proyecto.alchemilla.entidades.Medico"%>
<link rel ="stylesheet" href="../CSS/estilo.css"/>
<div id="encabezado">
	<div style="text-align: center; font-size: 35px; color: white;">${TITULO}</div>  
	<div style="position: fixed; right: 10px; top: 10px;color: white;">Bienvenido <%=((Medico)session.getAttribute("MEDICO_ACTUAL")).getNombre()%></div>
        <div style="position: fixed; right: 10px; top: 30px; color: white;"><a href="<%=request.getContextPath()%>/logout">Salir</a></div>
</div>
