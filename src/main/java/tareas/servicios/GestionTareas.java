
package tareas.servicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tareas.db.PoolConexiones;

import tareas.dominio.Tarea;
import tareas.excepciones.TareaException;


public class GestionTareas implements GestionTareasInterface{

    private static final String SELECT_TAREAS_X_ESTADO = "select * from tareas where estado like ?";
    private static final String UPDATE_TAREA_X_ID = "update tareas set estado = ? where id_tarea = ?";
    private static final String INSERT_TAREA = "INSERT INTO TAREAS (DESCRIPCION) VALUES (?)";

    @Override
    public List<Tarea> getTareasPorEstado(String estado) throws TareaException, SQLException {
        Connection con = PoolConexiones.getConexionLibre();
        ArrayList<Tarea> tareas = new ArrayList<>();
        
        if (con != null) {
            try {
                //consulta
                PreparedStatement ps = con.prepareStatement(SELECT_TAREAS_X_ESTADO);
                ps.setString(1, estado);
                ResultSet rs = ps.executeQuery();
                
                while (rs.next()) {                    
                    tareas.add(new Tarea(rs.getInt("ID_TAREA"), rs.getString("DESCRIPCION"), rs.getString("ESTADO")));
                }
                
                PoolConexiones.liberaConexion(con);
            } catch (SQLException ex) {
                Logger.getLogger(GestionTareas.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                PoolConexiones.liberaConexion(con);
            }
        } 
        return tareas;
    }

    @Override
    public List<Tarea> modificarTarea(int idTarea, String nuevoEstado) throws TareaException, SQLException {
        
        Connection con = PoolConexiones.getConexionLibre();
        ArrayList<Tarea> tareas = new ArrayList<>();
        
        if (con != null) {
            try {
                //consulta
                PreparedStatement ps = con.prepareStatement(UPDATE_TAREA_X_ID);
                ps.setString(1, nuevoEstado);
                ps.setInt(2, idTarea);
                ps.executeUpdate();

            } finally{
                PoolConexiones.liberaConexion(con);
            }
        } 
        return tareas;

    }

    @Override
    public void insertarTarea(String descripcion) throws TareaException, SQLException {
        
        Connection con = PoolConexiones.getConexionLibre();
        if (con != null) {
            try {
                //consulta
                PreparedStatement ps = con.prepareStatement(INSERT_TAREA);
                ps.setString(1, descripcion);
                ps.executeUpdate();

            } finally{
                PoolConexiones.liberaConexion(con);
            }
        } 

        
    }
    
 
    
}
