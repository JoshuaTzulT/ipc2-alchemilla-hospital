<div id="principal">
    <form action="<%=request.getContextPath()%>/LaboratoristaGestor?accion=insert" method="POST">
        <table border="1">

            <tbody>
                <tr>
                    <td>Id del laboratorista</td>
                    <td><input type="text" name="idDeLaboratorista"></td>
                </tr>                   

                <tr>
                    <td>Nombre del laboratorista</td>
                    <td><input type="text" name="nombreDeLaboratorista"></td>
                </tr> 


                <tr>
                    <td>Registro ministerio de Salud</td>
                    <td><input type="text" name="registroMinisterio"></td>
                </tr> 


                <tr>
                    <td>DPI</td>
                    <td><input type="text" name="dpi"></td>
                </tr>  

                <tr>
                    <td>Telefono</td>
                    <td><input type="text" name="telefono"></td>
                </tr> 

                <tr>
                    <td>Examen</td>
                    <td><input type="text" name="examen"></td>
                </tr> 

                <tr>
                    <td>Email</td>
                    <td><input type="text" name="email"></td>
                </tr> 


                <tr>
                    <td>Días en los que trabaja</td>
                    <td><input type="text" name="diasTrabajo"></td>
                </tr>  


                <tr>
                    <td>Contraseña del laboratorista</td>
                    <td><input type="text" name="contraseña"></td>
                </tr>  

                <tr>
                    <td>Fecha de contratación</td>
                    <td><input type="date" name="contratoFecha"></td>
                </tr>  

            </tbody>
        </table>



        <input type="submit" value ="Guardar"/>
    </form>

    <a href="<%=request.getContextPath()%>/principal">Volver</a> 

    <p class="login_error"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
    </p>
</div>            
