
<html>
    <head>
        <title>Alchemilla | Hospital</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilo1.css">
    </head>
    <body>
        <form action="<%=request.getContextPath()%>/Inicio" method="POST">
            <header>
                <div class ="main">
                    <div class ="logo">
                        <!--				<img src ="logo.png"
                                                </div>-->
                        <ul>
                            <li class="active"><a href="#">Inicio</a></li>
                            <li><a href="<%=request.getContextPath()%>/MenuGestor?accion=nuestros_servicios">Nuestros Servicios</a></li>
                            <li><a href="#">Sobre Nosotros</a></li>
                            <li><a href="#">Galer�a</a></li>
                            <li><a href="Inicio?accion=sesion">Iniciar Sesi�n</a></li>
                        </ul>
                    </div>
                    <div class="title">
                        <h1>Alchemilla</h1>
                    </div>
                </div>
            </header>
        </form>
    </body>
</html>