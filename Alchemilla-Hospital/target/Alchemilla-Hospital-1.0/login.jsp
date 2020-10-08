<link rel ="stylesheet" href="CSS/estilo.css">
<body>
    <div class="bgr">
        <form action="/Alchemilla-Hospital/login" method="POST">
            <div class="container">
                <div class="row">
                    <div class="col" style="width: 100px;">
                        <b style="color: azure;">E-mail</b>
                    </div>
                    <div class="col">
                        <input type="text" placeholder="Ingrese su Email" name="email" required="">
                    </div>
                </div>
                <div class="row">
                    <div class="col">
                        <b style="color: azure;">Contraseña</b>
                    </div>
                    <div class="row">
                        <input type="password" placeholder="Ingrese su contraseña" name="password" required="">
                    </div>
                </div>
                <div>

                    <div>
                        <p class="login_error">
                        </p>
                        <button type="submit">Ingresar</button>
                    </div>
                </div>
            </div>
        </form>                                
                        
    </div>
</body>