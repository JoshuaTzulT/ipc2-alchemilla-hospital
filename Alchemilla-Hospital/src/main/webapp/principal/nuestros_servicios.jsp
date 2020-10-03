
<jsp:include page="../principal/pieDePagina.jsp"></jsp:include>


<link rel="stylesheet" href="CSS/estilo.css"/>
<div id="nav" class="vmenu">
    <a class="menu_link${PRINCIPAL}" href="<%=request.getContextPath()%>/MenuGestor?accion=principal">P�gina Principal</a>  
    <a class="menu_link" href="<%=request.getContextPath()%>/MedicoGestor?accion=lista">Nuestros M�dicos</a>
    <a class="menu_link" href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=comprobar">Disponibilidad de horarios</a>
    <a class="menu_link" href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">Agendar una cita m�dica</a>
    <a class="menu_link" href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=lista">Ver mis citas m�dicas</a>
    <a class="menu_link" href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">Mi historial m�dico</a>
</div>

<script>
    //Esto a�ade una clase actival al boton, es decir lo resalta.
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