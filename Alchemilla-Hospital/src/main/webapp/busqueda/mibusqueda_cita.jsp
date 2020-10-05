<form action="/Alchemilla-Hospital/CitaMedicaGestor?accion=miCita" method="POST" style="margin-left: 500px;margin-top: 100px;">

        <div>
            <div>
                <b>Buscar cita</b>
            </div>
            <div>
                <input type="text" placeholder="ID del médico" name="nombreDr" required="">                        
            </div>
             <div>
                <input type="date" name="fecha" required="">                        
            </div>
             <div>
                <input type="time" name="hora" required="">                        
            </div>
        </div>

        <div>
            <div> 
                <button type="submit" style="margin-left: 215px;margin-top: -65px;">Buscar</button>
            </div>
        </div>

    </form>