<div id="principal">
    <form action="<%=request.getContextPath()%>/CitaMedicaGestor?accion=insert" method="POST">
        <table border="1">

            <tbody>
                <tr>
                    <td>Codigo de la cita</td>
                    <td><input type="text" name="codigoCita" required></td>
                </tr> 
                <tr>
                    <td>Id Paciente</td>
                    <td><input type="text" name="idDePaciente" required></td>
                </tr>                   
                <tr>
                    <td>ID Medico</td>
                    <td><input type="text" name="idDeMedico" required></td>
                </tr> 
                <tr>
                    <td>Tipo De Consulta</td>
                    <td><input type="text" name="tipoDeConsulta" required></td>
                </tr>  
                <tr>
                    <td>Fecha para la cita</td>
                    <td><input type="date" name="fecha"  min="2020-01-01" max="2020-12-31" required></td>
                </tr> 
                <tr>
                    <td>Hora para la cita</td>
                    <td><input type="time"  name="hora" min="09:00" max="18:00" required></td>
                </tr>  
            </tbody>
        </table>



        <input type="submit" value ="Guardar"/>
    </form>

    <a href="<%=request.getContextPath()%>/principal">Volver</a> 

    <p class="login_error"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
    </p>
</div>            
