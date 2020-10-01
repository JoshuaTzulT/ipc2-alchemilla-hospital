<div id="principal" style="margin-left: 425px;margin-top: 100px;">
    <form action="<%=request.getContextPath()%>/BuscarCita" method="POST">
        <div class="container">
            <div class="row">
                <div class="col" style="width: 100px;">
                    <b>Seleccione el horario de la(s) citas(s) a buscar</b>
                </div>
                <div class="col">
                    <input type="time"  name="criterioUno">						
                </div>
                <div class="col">
                    <input type="time"  name="criterioDos">						
                </div>

                <div class="col" style="width: 100px;">
                    <b>Seleccione la(s) fecha(s) de la(s) cita(s) a buscar</b>
                </div>
                <div class="col">
                    <input type="date" name="criterioTres"  >						
                </div>

                <div class="col">
                    <input type="date" name="criterioCuatro"  >						
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