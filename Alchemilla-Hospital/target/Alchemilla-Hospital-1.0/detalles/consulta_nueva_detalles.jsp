<div id="principal">
    <form action="<%=request.getContextPath()%>/ConsultaGestor?accion=insert" method="POST">
        <table border="1">

            <tbody>
                <tr>
                    <td>Tipo de consulta</td>
                    <td><input type="text" name="tipoDeConsulta"></td>
                </tr>                   

                <tr>
                    <td>Costo de la consulta</td>
                    <td><input type="text" name="costoConsulta"></td>
                </tr>                

            </tbody>
        </table>



        <input type="submit" value ="Guardar"/>
    </form>

    <a href="<%=request.getContextPath()%>/principal">Volver</a> 

    <p class="login_error"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
    </p>
</div>            
