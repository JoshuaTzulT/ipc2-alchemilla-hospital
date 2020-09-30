<link rel="stylesheet" href="CSS/estilo.css"/>
<body>
	<div class="logeo">
		<form action="<%=request.getContextPath()%>/Criterio" method="POST">
			<div class="container">
				<div class="row">
					<div class="col" style="width: 100px;">
						<b>Usuario</b>
					</div>
					<div class="col">
						<input type="text" placeholder="Nombre de usuario"
							name ="nombre_de_usuario" required>						
					</div>
				</div>
			
				<div class="row">
					<div class="col"></div>
					<div class ="col">
						<p class="login_error"><%=request.getAttribute("error") == null ? "" : request.getAttribute("error")%>
                                                </p>   
                                                <button type="submit">Ingresar</button>
                                        </div>
				</div>
			</div>		
		</form>		
	</div>
</body>