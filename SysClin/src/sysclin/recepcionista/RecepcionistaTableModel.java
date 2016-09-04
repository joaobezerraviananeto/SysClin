package sysclin.recepcionista;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RecepcionistaTableModel extends AbstractTableModel {

    public RecepcionistaTableModel(List<Recepcionista> recepcionistas) {
        this.recepcionistas = recepcionistas;
        nomeColunas = new String[]{"Nome", "Telefone", "Turno", "Endereço"};
    }
    private List<Recepcionista> recepcionistas;
    private String[] nomeColunas;

    @Override
    public int getRowCount() {
        return recepcionistas.size();
    }

    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Recepcionista recepcionista = recepcionistas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return recepcionista.getNome();
            case 1:
                return recepcionista.getTelefone();
            case 2:
                return recepcionista.getTurno();
            case 3:
                return recepcionista.getEndereco();
            default:
                return null;
        }

    }

}
