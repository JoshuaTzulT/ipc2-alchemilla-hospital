
<jsp:include page="../principal/pieDePagina.jsp"></jsp:include>

<link rel="stylesheet" href="CSS/estilo.css"/>
<div id="nav" class="vmenu">
    <a class="menu_link${PRINCIPAL}" href="<%=request.getContextPath()%>/MenuGestor?accion=principal">Inicio</a>  
    <a href="<%=request.getContextPath()%>/MedicoGestor?accion=histocita_paciente">Historial de Citas Médicas</a>
    <a href="<%=request.getContextPath()%>/MedicoGestor?accion=histolab_paciente">Historial de Exames de Laboratorio</a>
    <a href="<%=request.getContextPath()%>/CitaLaboratorioGestor?accion=nuevo">Citas Agendadas</a>
    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">Pacientes con mayor cantidad de Reportes</a>
    <a href="<%=request.getContextPath()%>/MedicoGestor?accion=secreportes">Seccion de reportes</a>
    
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