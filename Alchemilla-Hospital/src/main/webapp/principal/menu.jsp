
<div id="nav" class="vmenu">
    <a class="menu_link${PRINCIPAL}" href="<%=request.getContextPath()%>/principal">Pagina Principal</a>  
    <a class="menu_link${UG}" href="<%=request.getContextPath()%>/UsuarioGestion?accion=lista">LISTAR USUARIOS</a> <!--ESTO YA ES INNECESARIO-->
    <a class="menu_link" href="#">Listar Medicos</a>
    <a class="menu_link" href="<%=request.getContextPath()%>/usuario/area_de_busqueda.jsp">Buscar Médicos</a>
    <a class="menu_link" href="<%=request.getContextPath()%>/usuario/cita_nueva_detalles.jsp">AGENDAR UNA CITA</a>
</div>

<script>
    //Esto añade una clase actival al boton, es decir lo resalta.
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