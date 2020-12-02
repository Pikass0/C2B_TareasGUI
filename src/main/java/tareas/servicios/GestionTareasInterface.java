
package tareas.servicios;

import java.sql.SQLException;
import java.util.List;
import tareas.dominio.Tarea;
import tareas.excepciones.TareaException;

public interface GestionTareasInterface {
    
    public List<Tarea> getTareasPorEstado(String estado) throws TareaException, SQLException;
    public List<Tarea> modificarTarea(int idTarea, String nuevoEstado) throws TareaException, SQLException;
    public void insertarTarea(String descripcion) throws TareaException, SQLException;
    
    
    
}
