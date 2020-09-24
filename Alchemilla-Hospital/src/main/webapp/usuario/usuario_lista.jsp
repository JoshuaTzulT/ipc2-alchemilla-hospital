
<%@page import="proyecto.alchemilla.entidades.Usuario"%>
<%@page import="java.util.List"%>
<div id="principal" >
<table border="1">
    <thead>
        <tr>
            <th>#</th>
            <th>Nombre de Usuario</th>
            <th>Password</th>
            <th>Email</th>
            <th>Alias</th>
        </tr>
    </thead>
    <tbody>
          <%
            int i = 1;
            List <Usuario> lista = (List)request.getAttribute("lista");       
        %>
        
        <%
            for(Usuario u : lista){
        %>        
            
                <tr>
                    <td><%=i++%></td>
                    <td><%=u.getNombreDeUsuario()%></td>
                    <td><%=u.getPassword()%></td>
                    <td><%=u.getEmail()%></td>
                    <td><%=u.getAlias()%></td>
                </tr>
            <%}%>
        
    </tbody>
</table>
          
<!--            <a href="/UserManagement?action=new">Add New User</a>                         -->
</div>            
         