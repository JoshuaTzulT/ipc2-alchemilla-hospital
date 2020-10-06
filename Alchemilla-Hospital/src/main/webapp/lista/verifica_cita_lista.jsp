
<%@page import="proyecto.alchemilla.entidades.Cita"%>

<%@page import="java.util.List"%>
<div>      
    <table class = "oscuridad" border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>Nombre del m�dico</th>
                <th>Id del m�dico</th>
                <th>Fecha agendada</th>
                <th>Hora Agendada</th>
            </tr>
        </thead>
        <tbody>

            <%
                int i = 1;
                List<Cita> lista = (List) request.getAttribute("lista");

            %>

            <%  for (Cita cita : lista) {
            %>        
            <tr>
                <td><%=i++%></td>
                <td><%=cita.getNombreDelMedico()%></td>
                <td><%=cita.getIdMedico()%></td>
                <td><%=cita.getFecha()%></td>
                <td><%=cita.getHora()%></td>    
            </tr>
            <%}%>
        </tbody>
    </table>

    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">A�adir un nuevo usuario</a>                         
</div>            


