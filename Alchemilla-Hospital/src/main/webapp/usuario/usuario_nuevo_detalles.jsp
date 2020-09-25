<div id="principal">
    <form action="<%=request.getContextPath()%>/UsuarioGestion?accion=insert" method="POST">
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

    <a href="<%=request.getContextPath()%>/UsuarioGestion?acccion=lista">Volver</a> 
    
    <p class="login_error"><%=request.getAttribute("error")==null?"":request.getAttribute("error")%>
        </p>
</div>            
