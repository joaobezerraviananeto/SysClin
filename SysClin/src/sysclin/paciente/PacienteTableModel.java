package sysclin.paciente;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PacienteTableModel extends AbstractTableModel {

    public PacienteTableModel(List<Paciente> pacientes) {
        this.pacientes = pacientes;
        this.tituloColunas = new String[]{"Nome", "Telefone", "endereço", "Observação"};
    }
    private List<Paciente> pacientes;
    private final String[] tituloColunas;

    @Override
    public int getRowCount() {
        return pacientes.size();
    }

    @Override
    public int getColumnCount() {
        return tituloColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paciente paciente = pacientes.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return paciente.getNome();
            case 1:
                return paciente.getTelefone();
            case 2:
                return paciente.getEndereco();
            case 3:
                return paciente.getObservacao();
            default:
                return null;
        }

    }

}
