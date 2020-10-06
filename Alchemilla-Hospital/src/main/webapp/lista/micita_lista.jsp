
<%@page import="proyecto.alchemilla.entidades.Cita"%>

<%@page import="java.util.List"%>
<div id="principal" >
    <table class ="oscuridad" border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>Nombre del paciente</th>
                <th>Tipo de consulta</th>
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
                <td><%=cita.getNombreDelPaciente()%></td>
                <td><%=cita.getTipoDeConsulta()%></td>
                <td><%=cita.getFecha()%></td>
                <td><%=cita.getHora()%></td>    
 
            </tr>
            <%}%>

        </tbody>
    </table>

    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">Añadir un nuevo usuario</a>                         
</div>            


