
<div id="nav" class="vmenu">
    <a class="menu_link${PRINCIPAL}" href="<%=request.getContextPath()%>/principal">P�GINA PRINCIPAL</a>  
    <a class="menu_link${UG}" href="<%=request.getContextPath()%>/UsuarioGestion?accion=lista">LISTAR USUARIOS</a> <!--ESTO YA ES INNECESARIO-->
    <a class="menu_link" href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=lista">LISTAR M�DICOS</a>
    <a class="menu_link" href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">BUSCAR M�DICOS</a>
    <a class="menu_link" href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">BUSCAR CITAS M�DICAS</a>
     <a class="menu_link" href="<%=request.getContextPath()%>/ConsultaGestor?accion=nuevo">INSERTAR CONSULTA </a>
    <a class="menu_link" href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">AGENDAR UNA CITA M�DICA</a>
    <a class="menu_link" href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">HISTORIAL M�DICO</a>
        <a class="menu_link" href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">BUSCAR CITA LABORATORIO</a>
        <a class="menu_link" href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">REALIZAR UN EXAMEN DE LABORATORIO</a>
</div>

<script>
    //Esto a�ade una clase actival al boton, es decir lo resalta.
    var encabezado=document.getElmentById("nav");
    var links = encabezado.getElementsByClassName("menu_link");
    
    for(var i =0; i<links.length; i++){
        links[i].addEventListener("click", function(){
            var actual= document.getElementsByClassName("activo");
            actual[0].className = actual[0].className.replace("activo", "");
            this.className+="activo";
        });
    }
</script>