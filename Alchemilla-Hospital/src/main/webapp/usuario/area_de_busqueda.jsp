<!--<link rel="stylesheet" href="CSS/estilo.css"/>-->
<body>
    <div  style="margin-left: 425px;margin-top: 100px;">
        <form action="${pageContext.request.contextPath}/MedicoGestor" method="POST">
            <div>
                <div>
                    <div  style="width: 100px;">
                        <b>Buscar por algún criterio</b>
                    </div>
                    <div>
                        <input type="text" placeholder="Buscar por criterio" name="nombre_de_usuario" required="">						
                    </div>
                </div>

                <div>
                    <div>
                        <button type="submit">Ingresar</button>
                    </div>
                </div>
            </div>		
        </form>		
    </div>
</body>