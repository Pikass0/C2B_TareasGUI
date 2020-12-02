package tareas.dominio;

public class Tarea {

    public static final String TODO = "TODO";
    public static final String IN_PROGRESS = "IN PROGRESS";
    public static final String DONE = "DONE";
    
    private int idTarea;
    private String descripcion;
    private String estado;

    public Tarea(int idTarea, String descripcion, String estado) {
        this.idTarea = idTarea;
        this.descripcion = descripcion;
        this.estado = estado;

    }

    public int getIdTarea() {
        return idTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getEstado() {
        return estado;
    }

}
