
<jsp:include page="../principal/pieDePagina.jsp"></jsp:include>

<link rel="stylesheet" href="CSS/estilo.css"/>
<div id="nav" class="vmenu">
    <a class="menu_link${PRINCIPAL}" href="<%=request.getContextPath()%>/MenuGestor?accion=principal">Inicio</a>  
    <a href="<%=request.getContextPath()%>/MedicoGestor?accion=lista">Buscar pacientes</a>
    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=comprobar">Solicitar exámen para un paciente</a>
    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">Agendar una nueva consulta</a>
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