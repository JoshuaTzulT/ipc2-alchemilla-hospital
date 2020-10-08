<div style="margin-left: 425px;margin-top: 100px;">
    <form action="<%=request.getContextPath()%>/BuscarCita" method="POST">
        <div>
            <div>
                <div style="width: 100px;">
                    <b>Seleccione el horario de la(s) citas(s) a buscar</b>
                </div>
                <div>
                    <input type="time"  name="criterioUno">						
                </div>
                <div>
                    <input type="time"  name="criterioDos">						
                </div>

                <div style="width: 100px;">
                    <b>Seleccione la(s) fecha(s) de la(s) cita(s) a buscar</b>
                </div>
                <div>
                    <input type="date" name="criterioTres"  >						
                </div>

                <div>
                    <input type="date" name="criterioCuatro"  >						
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