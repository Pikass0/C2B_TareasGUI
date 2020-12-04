package tareas.servicios;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tareas.db.PoolConexiones;

import tareas.dominio.Tarea;
import tareas.excepciones.TareaException;

public class GestionTareas implements GestionTareasInterface {

    private static final String SELECT_TAREAS_X_ESTADO = "select * from tareas where archivado = false and estado like ?";
    private static final String UPDATE_TAREA_X_ID = "update tareas set estado = ? where id_tarea = ?";
    private static final String INSERT_TAREA = "INSERT INTO TAREAS (DESCRIPCION) VALUES (?)";
    private static final String DELETE_TAREA = "delete from tareas where id_tarea = ?";
    private static final String UPDATE_ARCHIVAR = "update tareas set archivado = true where id_tarea = ?";

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
            } finally {
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

            } finally {
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

            } finally {
                PoolConexiones.liberaConexion(con);
            }
        }

    }

    @Override
    public void deleteTarea(List<Integer> idTarea) throws TareaException, SQLException {

        Connection con = PoolConexiones.getConexionLibre();
        if (con != null) {
            try {
                //prearar consulta dependiendo de cuantos ids tenga
                if (idTarea.size() == 1) {
                    //consulta
                    PreparedStatement ps = con.prepareStatement(DELETE_TAREA);
                    ps.setInt(1, idTarea.get(0));
                    ps.executeUpdate();

                } else {
                    //concatenamos tantos "?" como id haya
                    String query = "delete from tareas where id_tarea in ";

                    StringBuilder parametrosIN = new StringBuilder();
                    parametrosIN.append(" (");
                    for (int i = 0; i < idTarea.size(); i++) {
                        parametrosIN.append("?");
                        if (idTarea.size() > i + 1) {
                            parametrosIN.append(",");
                        }
                    }
                    parametrosIN.append(")");

                    PreparedStatement ps = con.prepareStatement(query + parametrosIN);
                    for (int i = 1; i < idTarea.size() + 1; i++) {
                        ps.setInt(i, idTarea.get(i-1));
                    }

                    ps.executeUpdate();

                }

            } finally {
                PoolConexiones.liberaConexion(con);
            }
        }

    }

    @Override
    public void archivarTarea(List<Integer> idTarea) throws TareaException, SQLException {
       
        Connection con = PoolConexiones.getConexionLibre();
        if (con != null) {
            try {
                //prearar consulta dependiendo de cuantos ids tenga
                if (idTarea.isEmpty()) throw new TareaException("No se han seleccionado tareas");
                if (idTarea.size() == 1) {
                    //consulta
                    PreparedStatement ps = con.prepareStatement(UPDATE_ARCHIVAR);
                    ps.setInt(1, idTarea.get(0));
                    ps.executeUpdate();

                } else {
                    //concatenamos tantos "?" como id haya
                    String query = "update  tareas set archivado = true where id_tarea in ";

                    StringBuilder parametrosIN = new StringBuilder();
                    parametrosIN.append(" (");
                    for (int i = 0; i < idTarea.size(); i++) {
                        parametrosIN.append("?");
                        if (idTarea.size() > i + 1) {
                            parametrosIN.append(",");
                        }
                    }
                    parametrosIN.append(")");

                    PreparedStatement ps = con.prepareStatement(query + parametrosIN);
                    for (int i = 1; i < idTarea.size() + 1; i++) {
                        ps.setInt(i, idTarea.get(i-1));
                    }

                    ps.executeUpdate();

                }

            } finally {
                PoolConexiones.liberaConexion(con);
            }
        }
    }

}
