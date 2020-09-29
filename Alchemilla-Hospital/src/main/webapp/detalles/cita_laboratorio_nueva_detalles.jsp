<div id="principal">
    <form action="<%=request.getContextPath()%>/CitaMedicaGestion?accion=insert" method="POST">
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

               

            </tbody>
        </table>
        <input type="submit" value ="Guardar"/>
    </form>

    <a href="<%=request.getContextPath()%>/principal">Volver</a> 
    
    <p class="login_error"><%=request.getAttribute("error")==null?"":request.getAttribute("error")%>
        </p>
</div>            
