
package sysclin.aluno;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import sysclin.aluno.Aluno;

public class AlunoTableModel extends AbstractTableModel {

    public AlunoTableModel(List<Aluno> alunos) {
        this.alunos = alunos;
        this.tituloColuas = new String[]{"id", "Nome", "CPF"};
    }

    private List<Aluno> alunos;
    private final String[] tituloColuas;

    @Override
    /*get row pega o numero de linhas*/
    public int getRowCount() {
        return alunos.size();
    }

    @Override
    public int getColumnCount() {
        return tituloColuas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = alunos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return aluno.getId();
            case 1:
                return aluno.getNome();
            case 2:
                return aluno.getCpf();
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
