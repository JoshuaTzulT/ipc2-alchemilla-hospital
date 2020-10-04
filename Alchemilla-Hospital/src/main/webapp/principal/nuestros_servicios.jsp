
<jsp:include page="../principal/pieDePagina.jsp"></jsp:include>

<link rel="stylesheet" href="CSS/estilo.css"/>
<div id="nav" class="vmenu">
    <a class="menu_link${PRINCIPAL}" href="<%=request.getContextPath()%>/MenuGestor?accion=principal">Inicio</a>  
    <a href="<%=request.getContextPath()%>/MedicoGestor?accion=lista">Nuestros Médicos</a>
    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=comprobar">Disponibilidad de horarios</a>
    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">Agendar una cita médica</a>
    <a href="<%=request.getContextPath()%>/">Agendar examen en el laboratorio</a>
    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=miCita">Ver todas mis citas médicas</a>
    <a href="<%=request.getContextPath()%>/">Ver todas mis cita en el laboratorio</a>
    <a href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">Mi historial médico</a>
</div>

<script>
    //Esto añade una clase actival al boton, es decir lo resalta.
    var encabezado = document.getElmentById("nav");
    var links = encabezado.getElementsByClassName("menu_link");

    for (var i = 0; i < links.length; i++) {
        links[i].addEventListener("click", function () {
            var actual = document.getElementsByClassName("activo");
            actual[0].className = actual[0].className.replace("activo", "");
            this.className += "activo";
        });
    }
</script>