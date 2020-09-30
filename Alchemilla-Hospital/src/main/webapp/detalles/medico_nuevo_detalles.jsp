<div id="principal">
    <form action="<%=request.getContextPath()%>/MedicoGestor?accion=insert" method="POST">
        <table border="1">

            <tbody>
                <tr>
                    <td>Id del médico</td>
                    <td><input type="text" name="idDeMedico"></td>
                </tr>                   

                <tr>
                    <td>Nombre del médico</td>
                    <td><input type="text" name="nombreDeMedico"></td>
                </tr> 


                <tr>
                    <td>Número de colegiado</td>
                    <td><input type="text" name="numeroColegiado"></td>
                </tr> 


                <tr>
                    <td>DPI</td>
                    <td><input type="text" name="dpi"></td>
                </tr>  

                <tr>
                    <td>Teléfono</td>
                    <td><input type="text" name="telefono"></td>
                </tr> 

                <tr>
                    <td>Especialidad(es)</td>
                    <td><input type="text" name="especialidad"></td>
                </tr>  

                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"></td>
                </tr> 

                <tr>

                <tr>
                    <td>Inicio del horario de atención</td>
                    <td><input type="time"  name="horaInicio" min="09:00" max="18:00" required></td>

                </tr>

                <tr>
                    <td>Fin del horario de atención</td>
                    <td><input type="time"  name="horaFin" min="09:00" max="18:00" required></td>

                </tr>

                <tr>
                    <td>Fecha de contratación</td>
                    <td><input type="date" name="fechaContrato"  min="2020-01-01" max="2020-12-31"></td>
                </tr> 



            </tbody>
        </table>



        <input type="submit" value ="Guardar"/>
    </form>

    <a href="<%=request.getContextPath()%>/principal">Volver</a> 

    <p class="login_error"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
    </p>
</div>            
