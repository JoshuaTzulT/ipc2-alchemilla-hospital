<div id="principal">
    <form action="<%=request.getContextPath()%>/ExamenesGestor?accion=insert" method="POST">
        <table border="1">

            <tbody>
                <tr>
                    <td>Código del examen</td>
                    <td><input type="text" name="idDeExamen"></td>
                </tr>                   

                <tr>
                    <td>Nombre del examen</td>
                    <td><input type="text" name="nombreDeExamen"></td>
                </tr> 


                <tr>
                    <td>Requiere una orden</td>
                    <td><input type="text" name="orden"></td>
                </tr> 


                <tr>
                    <td>Descripción</td>
                    <td><input type="text" name="descr"></td>
                </tr>  

                <tr>
                    <td>Costo del Examen</td>
                    <td><input type="text" name="costoExamen"></td>
                </tr> 

                <tr>
                    <td>Informe para adjuntar</td>
                    <td><input type="text" name="informe"></td>
                </tr>  

            </tbody>
        </table>



        <input type="submit" value ="Guardar"/>
    </form>

    <a href="<%=request.getContextPath()%>/principal">Volver</a> 

    <p class="login_error"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
    </p>
</div>            
