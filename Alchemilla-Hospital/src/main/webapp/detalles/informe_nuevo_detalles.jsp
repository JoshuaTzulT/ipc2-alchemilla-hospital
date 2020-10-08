<div id="principal">
    <form action="<%=request.getContextPath()%>/MedicoGestor?accion=realizarInforme" method="POST">
        <table border="1">

            <tbody>
                <tr>
                    <td>Codigo del informe</td>
                    <td><input type="text" name="idInforme"></td>
                </tr>                   

                <tr>
                    <td>Codigo del paciente</td>
                    <td><input type="text" name="idPaciente"></td>
                </tr> 


                <tr>
                    <td>Codigo del Médico</td>
                    <td><input type="text" name="idMedico"></td>
                </tr> 


                <tr>
                    <td>Informe</td>
                    <td><input type="text" name="informeP"></td>
                </tr>  

                <tr>
                    <td>Fecha</td>
                    <td><input type="text" name="fecha"></td>
                </tr> 

                <tr>
                    <td>Hora</td>
                    <td><input type="text" name="hora"></td>
                </tr>  

            </tbody>
        </table>



        <input type="submit" value ="Guardar"/>
    </form>

    <a href="<%=request.getContextPath()%>/principal">Volver</a> 

    <p class="login_error"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
    </p>
</div>            
