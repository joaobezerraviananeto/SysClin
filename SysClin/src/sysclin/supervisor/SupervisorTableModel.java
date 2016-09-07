
package sysclin.supervisor;

import sysclin.aluno.*;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import sysclin.aluno.Aluno;

public class SupervisorTableModel extends AbstractTableModel {

    public SupervisorTableModel(List<Supervisor> supervisores) {
        this.supervisores = supervisores;
        this.tituloColuas = new String[]{"Id", "Nome", "CPF"};
    }

    private List<Supervisor> supervisores;
    private final String[] tituloColuas;

    @Override
    /*get row pega o numero de linhas*/
    public int getRowCount() {
        return supervisores.size();
    }

    @Override
    public int getColumnCount() {
        return tituloColuas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Supervisor supervisor = supervisores.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return supervisor.getId();
            case 1:
                return supervisor.getNome();
            case 2:
                return supervisor.getCpf();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        // return tituloColuas[column];
        switch (column) {
            case 0:
                return tituloColuas[0];
            case 1:
                return tituloColuas[1];
            case 2:
                return tituloColuas[2];
            default:
                return null;
        }
    }

}
