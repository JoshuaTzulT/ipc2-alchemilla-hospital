<!--<link rel ="stylesheet" href="CSS/estilo.css">
<body>
    <div class="bgr">
        <form action="<=request.getContextPath()%>/UsuarioGestion?accion=registar" method="POST">
            <div class="container">
                <div class="row">
                    <div class="col" style="width: 100px;">
                        <b>Nombre</b>
                    </div>
                    <div class="col">
                        <input type="text" placeholder="Su nombre"
                               name ="nombreDeUsuario" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col" style="width: 100px;">
                        <b>Alias</b>
                    </div>
                    <div class="col">
                        <input type="text" placeholder="Nombre de usuario"
                               name ="alias" required>
                    </div>
                </div>
                
                <div class="row">
                    <div class="col" style="width: 100px;">
                        <b>Email</b>
                    </div>
                    <div class="col">
                        <input type="text" placeholder="Ingrese su E-mail"
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
                        <p class="login_error">%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
                        </p>
                        <button type="submit">Ingresar</button>
                    </div>

                    <div>
                        <a href="<=request.getContextPath()%>/UsuarioGestion?accion=registrar">No tiene una cuenta? Registresé acá</a>
                    </div>
                </div>
            </div>
        </form>
    </div>
</body>-->







































<div id="principal">
    <form action="<=request.getContextPath()>/UsuarioGestion?accion=registar" method="POST">
        <table border="1">

            <tbody>
                <tr>
                    <td>Nombre de Usuario</td>
                    <td><input type="text" name="nombreDeUsuario"></td>
                </tr>   

                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"></td>
                </tr> 

                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"></td>
                </tr>  

                <tr>
                    <td>Alias</td>
                    <td><input type="text" name="alias"></td>
                </tr>  

            </tbody>
        </table>
        <input type="submit" value ="Guardar"/>
    </form>

    <a href="<=request.getContextPath()%>/UsuarioGestion?acccion=lista">Volver</a> 
    
    <p class="login_error"><=request.getAttribute("error")==null?"":request.getAttribute("error")%>
        </p>
</div>            
