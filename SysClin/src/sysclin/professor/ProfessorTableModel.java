
package sysclin.professor;

import javax.swing.table.AbstractTableModel;


public class ProfessorTableModel extends AbstractTableModel {
     public AlunoTableModel(List<Professor> professores) {
        this.professores = professores;
        this.tituloColuas = new String[]{"Nome", "Cpf", "Endereço"};
    }

    private List<Professor> professores;
    private final String[] tituloColuas;

    @Override
    /*get row pega o numero de linhas*/
    public int getRowCount() {
        return getProfessores().size();
    }

    @Override
    public int getColumnCount() {
        return tituloColuas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Professor professor = getProfessores().get(rowIndex);

        switch (columnIndex) {
            case 0:
                return professor.getNome();
            case 1:
                return professor.getCpf();
            case 2:
                return professor.getEndereco();
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

    public Professor getRow(int row) {
        return getProfessores().get(row);
    }

    /**
     * @return the alunos
     */
    public List<Professor> getProfessores() {
        return professor;
    }

    /**
     * @param alunos the alunos to set
     */
    public void setProfessores(List<Professor> professores) {
        this.professores = professores;
        fireTableDataChanged();
    }
}
