package tareas.gui;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import tareas.dominio.Tarea;

public class TareaModel extends AbstractTableModel {

    private String[] nombresColumnas = {"Tarea"};
    private List<Tarea> tareas;

    public TareaModel(List<Tarea> tareas) {
        this.tareas = tareas;
    }
    
    
    
    @Override
    public int getRowCount() {
        return tareas.size();
    }

    @Override
    public int getColumnCount() {
        return nombresColumnas.length;
    }

   
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        switch (columnIndex) {
            case 0:
                return tareas.get(rowIndex).getDescripcion();

        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        return nombresColumnas[column];
    }
    
    
    
    

}
