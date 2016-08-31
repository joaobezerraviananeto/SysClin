
package sysclin.aluno;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Joao_Viana
 */
public class AlunoTableModel extends AbstractTableModel {

    public AlunoTableModel(List<Aluno> alunos) {
        this.alunos = alunos;
        this.tituloColuas = new String[]{"Nome", "Cpf", "Endereço"};
    }

    private List<Aluno> alunos;
    private final String[] tituloColuas;

    @Override
    /*get row pega o numero de linhas*/
    public int getRowCount() {
        return getAlunos().size();
    }

    @Override
    public int getColumnCount() {
        return tituloColuas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aluno aluno = getAlunos().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return aluno.getNome();
            case 1:
                return aluno.getCpf();
            case 2:
                return aluno.getEndereco();
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

    public Aluno getRow(int row) {
        return getAlunos().get(row);
    }

    /**
     * @return the alunos
     */
    public List<Aluno> getAlunos() {
        return alunos;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
        fireTableDataChanged();
    }

}
