    <div id="principal">
    <form action="<%=request.getContextPath()%>/CitaLaboratorioGestor?accion=insert" method="POST" enctype="multipart/form-data">
        <table border="1">
            <tbody>
                <tr>
                    <td>ID Cita Laboratorio</td>
                    <td><input type="text" name="idCita"></td>
                </tr>   

                <tr>
                    <td>ID del paciente</td>
                    <td><input type="text" name="idPaciente"></td>
                </tr>

                <tr>
                    <td>ID del Laboratorista</td>
                    <td><input type="text" name="idLaboratorista"></td>
                </tr> 

                <tr>
                    <td>Código del Examen</td>
                    <td><input type="text" name="codigoExamen"></td>
                </tr>  

                <tr>
                    <td>Nombre del Exámen</td>
                    <td><input type="text" name="nombreExamen"></td>
                </tr> 

                <tr>
                    <td>Orden médica</td>
                    <td><input type="file" name="file"></td>
                </tr> 

                <tr>
                    <td>Fecha agendada</td>
                    <td><input type="date" name="fecha"></td>
                </tr> 

                <tr>
                    <td>Hora agendada</td>
                    <td><input type="time" name="hora"></td>
                </tr> 

                <tr>
                    <td>Costo</td>
                    <td><input type="text" name="costo"></td>
                </tr> 

                <tr>
                    <td>Informe</td>
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
