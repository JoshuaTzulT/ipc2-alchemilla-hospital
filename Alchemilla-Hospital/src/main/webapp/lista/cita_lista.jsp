
<%@page import="proyecto.alchemilla.entidades.Cita"%>

<%@page import="java.util.List"%>
<div id="principal" >
    <table border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>Código de la cita médica</th>
                <th>ID del paciente</th>
                <th>ID del médico</th>
                <th>Tipo de Cita Médica</th>
                <th>Fecha agendada</th>
                <th>Hora Agendada</th>
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
                <td><%=cita.getCodigoCita()%></td>
                <td><%=cita.getIdPaciente()%></td>
                <td><%=cita.getIdMedico()%></td>
                <td><%=cita.getTipoDeConsulta()%></td>
                <td><%=cita.getFecha()%></td>
                <td><%=cita.getHora()%></td>    
 
            </tr>
            <%}%>

        </tbody>
    </table>

    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">Añadir un nuevo usuario</a>                         
</div>            


