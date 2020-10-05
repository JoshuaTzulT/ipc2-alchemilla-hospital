<link rel ="stylesheet" href="CSS/estilo.css">
<body>
    <div class="bgr">
        <form action="<%=request.getContextPath()%>/login" method="POST">
            <div class="container">
                <div class="row">
                    <div class="col" style="width: 100px;">
                        <b>E-mail</b>
                    </div>
                    <div class="col">
                        <input type="text" placeholder="Ingrese su Email"
                               name ="email" required>
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
                </div>
            </div>
        </form>
                        
                        <form action ="<%=request.getContextPath()%>/UsuarioGestion?accion=registrar" method="POST">
                        <a href="<%=request.getContextPath()%>/UsuarioGestion?accion=registrar">No tiene una cuenta? Registresé acá</a>
                    </form>
                        
    </div>
</body>