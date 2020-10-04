<link rel ="stylesheet" href="../CSS/estilo.css"/>
<div id="principal" style="margin-left: 425px;margin-top: 100px;">
    <form action="<%=request.getContextPath()%>/MedicoGestor" method="POST">
    <div class ="container">
        <div class="row">
            <div class ="col" style="width: 100px;">
                <b>Usuario</b>
            </div>
            <div class="col">
                <input type="text" placeholder="Nombre de usuario" name="nombre_de_usuario" required="">						
            </div>
        </div>

        <div class="row">
            <div class="col">
               
                <button type="submit">Ingresar</button>
            </div>
        </div>
    </div>		
</form>		
</div>