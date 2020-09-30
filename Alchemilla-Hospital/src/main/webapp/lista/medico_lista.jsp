
<%@page import="proyecto.alchemilla.entidades.Medico"%>
<%@page import="proyecto.alchemilla.entidades.Usuario"%>
<%@page import="java.util.List"%>
<div id="principal" >
    <table style="margin-top: 125px;margin-left: 60px;" border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>ID Médico</th>
                <th>Nombre del Médico</th>
                <th>Colegiado No.</th>
                <th>DPI</th>
                <th>Especialidad</th>
                <th>Email</th>
                <th>Atiende desde </th>
                <th>Hasta</th>
                <th>Fecha de Contratación</th>
            </tr>
        </thead>
        <tbody>
            <%
                int i = 1;
                List<Medico> lista = (List) request.getAttribute("lista");
            %>

            <%
                for (Medico medico : lista) {
            %>        

            <tr>
                <td><%=i++%></td>
                <td><%=medico.getIdMedico()%></td>
                <td><%=medico.getNombre()%></td>
                <td><%=medico.getNumeroDeColegiado()%></td>
                <td><%=medico.getDpi()%></td>
                <td><%=medico.getEspecialidad()%></td>
                <td><%=medico.getEmail()%></td>    
                <td><%=medico.getHorarioDeAtencionInicio()%></td>
                <td><%=medico.getHorarioDeAtencionFinal()%></td>
                <td><%=medico.getFechaDeInicio()%></td>
            </tr>
            <%}%>

        </tbody>
    </table>

    <a href="<%=request.getContextPath()%>/MedicoGestor?accion=nuevo">Añadir un nuevo usuario</a>                         
</div>            






<div class="logeo" style="margin-left: 425px;margin-top: 100px;">
		<form action="/Alchemilla-Hospital/Criterio" method="POST">
			<div class="container">
				<div class="row">
					<div class="col" style="width: 100px;">
						<b>Usuario</b>
					</div>
					<div class="col">
						<input type="text" placeholder="Nombre de usuario" name="nombre_de_usuario" required="">						
					</div>
				</div>
			
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<p class="login_error">
                                                </p>   
                                                <button type="submit">Ingresar</button>
                                        </div>
				</div>
			</div>		
		</form>		
	</div>