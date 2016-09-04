package sysclin.professor;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ProfessorTableModel extends AbstractTableModel {

    public ProfessorTableModel(List<Professor> professores) {
        this.professores = professores;
        tituloColunas = new String[]{"Nome", "Telefone", "Turma", "Endereço"};
    }

    private List<Professor> professores;
    private String tituloColunas[];

    @Override
    public int getRowCount() {
        return professores.size();
    }

    @Override
    public int getColumnCount() {
        return tituloColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Professor professor = professores.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return professor.getNome();
            case 1:
                return professor.getTelefone();
            case 2:
                return professor.getTurma();
            case 3:
                return professor.getEndereco();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return tituloColunas[0];
            case 1:
                return tituloColunas[1];
            case 2:
                return tituloColunas[2];
            case 3:
                return tituloColunas[3];
            default:
                return null;
        }
    }
}
