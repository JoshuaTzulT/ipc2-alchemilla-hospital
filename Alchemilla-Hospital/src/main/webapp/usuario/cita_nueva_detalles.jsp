<div id="principal">
    <form action="<%=request.getContextPath()%>/CitaMedicaGestor?accion=insert" method="POST">
        <table border="1">

            <tbody>
                <tr>
                    <td>Id Pacientre</td>
                    <td><input type="text" name="idDePaciente"></td>
                </tr>   
                
                  <tr>
                    <td>Nombre del paciente</td>
                    <td><input type="text" name="nombreDePaciente"></td>
                </tr>

                <tr>
                    <td>ID Medico</td>
                    <td><input type="text" name="idDeMedico"></td>
                </tr> 

                <tr>
                    <td>Nombre del Médico</td>
                    <td><input type="text" name="nombreDeMedico"></td>
                </tr>  

                <tr>
                    <td>Fecha para la cita</td>
                    <td><input type="date" name="fecha"  min="2020-01-01" max="2020-12-31"></td>
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
    
    <p class="login_error"><%=request.getAttribute("error")==null?"":request.getAttribute("error")%>
        </p>
</div>            
