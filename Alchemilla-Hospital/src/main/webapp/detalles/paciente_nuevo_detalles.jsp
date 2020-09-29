<div id="principal">
    <form action="<%=request.getContextPath()%>/PacienteGestor?accion=insert" method="POST">
        <table border="1">

            <tbody>
                <tr>
                    <td>Id Paciente</td>
                    <td><input type="text" name="idDePaciente"></td>
                </tr>                   

                <tr>
                    <td>Nombre</td>
                    <td><input type="text" name="nombrePaciente"></td>
                </tr> 


                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono"></td>
                </tr> 


                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"></td>
                </tr>  

                <tr>
                    <td>DPI</td>
                    <td><input type="text" name="dpi"></td>
                </tr> 

                <tr>
                    <td>Sexo</td>
                    <td><input type="text" name="sexo"></td>
                </tr>  

                <tr>
                    <td>Fecha de nacimiento</td>
                    <td><input type="date" name="fecha"  min="1920-01-01" max="2020-12-31"></td>
                </tr> 

                <tr>
                    <td>Peso</td>
                    <td><input type="text" name="peso"></td>
                </tr>  

                <tr>
                    <td>Tipo de Sangre</td>
                    <td><input type="text" name="tipoSangre"></td>
                </tr>  

            </tbody>
        </table>



        <input type="submit" value ="Guardar"/>
    </form>

    <a href="<%=request.getContextPath()%>/principal">Volver</a> 

    <p class="login_error"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
    </p>
</div>            
