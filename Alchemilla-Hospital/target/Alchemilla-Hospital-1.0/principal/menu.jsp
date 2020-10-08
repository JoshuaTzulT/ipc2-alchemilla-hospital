
<div id ="nav" class="vmenu">
    <a class="menu_link${PRINCIPAL}" href="<%=request.getContextPath()%>/principal">P�GINA PRINCIPAL</a>  
    <a href="<%=request.getContextPath()%>/MedicoGestor?accion=lista">LISTAR M�DICOS</a>

    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=lista">VER MIS CITAS M�DICAS</a>
    <a href="<%=request.getContextPath()%>/MedicoGestor?accion=nuevo">INSERTAR MEDICO </a>
    <a href="<%=request.getContextPath()%>/LaboratoristaGestor?accion=nuevo">INSERTAR LABORATORISTA </a>
    <a href="<%=request.getContextPath()%>/ConsultaGestor?accion=nuevo">INSERTAR CONSULTA </a>
    <a href="<%=request.getContextPath()%>/ExamenesGestor?accion=nuevo">INSERTAR EXAMEN </a>
    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">AGENDAR UNA CITA M�DICA</a>
    <a href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">HISTORIAL M�DICO</a>
    <a href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">BUSCAR CITA LABORATORIO</a>
    <a href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">REALIZAR UN EXAMEN DE LABORATORIO</a>
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