
<%@page import="proyecto.alchemilla.entidades.CitaLaboratorio"%>
<%@page import="proyecto.alchemilla.entidades.Cita"%>

<%@page import="java.util.List"%>
<div id="principal" >
    <table border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>Nombre del paciente</th>
                <th>Nombre del exámen</th>
                <th>Fecha agendada</th>
                <th>Hora Agendada</th>
                <th>Costo del exámen</th>
            </tr>
        </thead>
        <tbody>
           
            <%
                int i = 1;
                    List<CitaLaboratorio> lista = (List) request.getAttribute("lista");
                    
            %>

            <%
                for (CitaLaboratorio cita : lista) {
            %>        

            <tr>
                <td><%=i++%></td>
                <td><%=cita.getNombreDePaciente()%></td>
                <td><%=cita.getNombreDelExamen()%></td>
                <td><%=cita.getFechaExamen()%></td>
                <td><%=cita.getHoraExamen()%></td>    
                <td><%=cita.getCosto()%></td>
            </tr>
            <%}%>

        </tbody>
    </table>

    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">Añadir un nuevo usuario</a>                         
</div>            


