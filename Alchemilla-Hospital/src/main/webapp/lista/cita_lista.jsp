
<%@page import="proyecto.alchemilla.entidades.Cita"%>

<%@page import="java.util.List"%>
<div id="principal" >
    <table border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>C�digo de la cita m�dica</th>
                <th>ID del paciente</th>
                <th>ID del m�dico</th>
                <th>Tipo de Cita M�dica</th>
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

    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">A�adir un nuevo usuario</a>                         
</div>            


