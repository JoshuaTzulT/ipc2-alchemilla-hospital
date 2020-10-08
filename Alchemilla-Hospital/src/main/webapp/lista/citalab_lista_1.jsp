
<%@page import="proyecto.alchemilla.entidades.CitaLaboratorio"%>
<%@page import="proyecto.alchemilla.entidades.Cita"%>
<%@page import="proyecto.alchemilla.entidades.Paciente"%>

<%@page import="java.util.List"%>
<link rel="stylesheet" href="CSS/estilo.css">
<div id="principal">

    <form action="/Alchemilla-Hospital/PacienteGestor" method="POST">

        <div>
            <div>
                <b>Buscar por un Criterio</b>
            </div>
            <div>
                <input type="text" placeholder="Paciente" name="nombre_de_usuario" required="">                        
            </div>
        </div>

        <div>
            <div> 
                <button type="submit" style="margin-left: 215px;margin-top: -65px;">Buscar</button>
            </div>
        </div>

    </form>


    <table class="oscuridad" style="margin-top: 60px;margin-left: 60px;" border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>ID de la cita</th>
                <th>ID del paciente</th>
                <th>ID del laboratatorista</th>
                <th>ID del examen</th>
                <th>Nombre del Examen</th>
                <th>Fecha del examen</th>
                <th>Hora del Examen</th>
            </tr>
        </thead>
        <tbody>
            <%
                int i = 1;
                List<CitaLaboratorio> lista = (List) request.getAttribute("lista");
            %>

            <%
                for (CitaLaboratorio cl: lista) {
            %>        

            <tr>
                <td><%=i++%></td>
                <td><%=cl.getIDPaciente()%></td>
                <td><%=cl.getIDPaciente()%></td>
                <td><%=cl.getIDLaboratorista()%></td>
                <td><%=cl.getIDExamen()%></td>
                <td><%=cl.getFechaExamen()%></td>
                <td><%=cl.getHoraExamen()%></td>    
            </tr>
            <%}%>

        </tbody>
    </table>

    <a href="<%=request.getContextPath()%>/MedicoGestor?accion=nuevo">Añadir un nuevo usuario</a>      

</div>            



