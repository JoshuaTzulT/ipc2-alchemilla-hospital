<link rel ="stylesheet" href="CSS/estilo.css">
<body>
    <div class="bgr">
        <form action="<%=request.getContextPath()%>/login" method="POST">
            <div class="container">
                <div class="row">
                    <div class="col" style="width: 100px;">
                        <b>Usuario</b>
                    </div>
                    <div class="col">
                        <input type="text" placeholder="Nombre de usuario"
                               name ="nombre_de_usuario" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <b>Contraseña</b>
                    </div>
                    <div class="row">
                        <input type="password" placeholder="Ingrese su contraseña"
                               name="password" required>
                    </div>
                </div>
                <div>

                    <div>
                        <p class="login_error"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
                        </p>
                        <button type="submit">Ingresar</button>
                    </div>

                    <div>
                        <a href="<%=request.getContextPath()%>/MedicoGestor?accion=nuevo">No tiene una cuenta? Registresé acá</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>