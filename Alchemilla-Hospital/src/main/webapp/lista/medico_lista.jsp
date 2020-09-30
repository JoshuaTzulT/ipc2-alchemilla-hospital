
<%@page import="proyecto.alchemilla.entidades.Medico"%>
<%@page import="proyecto.alchemilla.entidades.Usuario"%>
<%@page import="java.util.List"%>
<div id="principal" >
    <table border="1">
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
