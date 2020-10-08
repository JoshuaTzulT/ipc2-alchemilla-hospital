
<%@page import="proyecto.alchemilla.entidades.Cita"%>

<%@page import="java.util.List"%>
<div id="principal" >
    <table border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>Nombre del paciente</th>
                <th>Nombre del médico</th>
                <th>Tipo de consulta</th>
                <th>Fecha agendada</th>
                <th>Hora Agendada</th>
                <th>Costo de la consulta</th>
            </tr>
        </thead>
        <tbody>
           
            <%
                int i = 1;
                    List<Cita> lista = (List) request.getAttribute("lista");
                    
            %>

            <%
                for (Cita cita : lista) {
            %>        

            <tr>
                <td><%=i++%></td>
                <td><%=cita.getNombreDelPaciente()%></td>
                <td><%=cita.getNombreDelMedico()%></td>
                <td><%=cita.getTipoDeConsulta()%></td>
                <td><%=cita.getFecha()%></td>
                <td><%=cita.getHora()%></td>    
                <td><%=cita.getCosto()%></td>
            </tr>
            <%}%>

        </tbody>
    </table>

    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">Añadir un nuevo usuario</a>                         
</div>            


