
<%@page import="proyecto.alchemilla.entidades.Cita"%>

<%@page import="java.util.List"%>
<div id="principal" >
    
<!--    <form action="/Alchemilla-Hospital/CitaMedicaGestor" method="POST">

        <div>
            <div>
                <b>Buscar cita</b>
            </div>
            <div>
                <input type="text" placeholder="ID del médico" name="nombreDr" required="">                        
            </div>
             <div>
                <input type="text" placeholder="Fecha para la cita" name="fecha" required="">                        
            </div>
             <div>
                <input type="text" placeholder="Hora para la cita" name="hora" required="">                        
            </div>
        </div>

        <div>
            <div> 
                <button type="submit" style="margin-left: 215px;margin-top: -65px;">Buscar</button>
            </div>
        </div>

    </form>-->
    
    
    
    
    <table border="1">
        <thead>
            <tr>
                <th>#</th>
                <th>Nombre del médico</th>
                <th>Id del médico</th>
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

    <a href="<%=request.getContextPath()%>/CitaMedicaGestor?accion=nuevo">Añadir un nuevo usuario</a>                         
</div>            


