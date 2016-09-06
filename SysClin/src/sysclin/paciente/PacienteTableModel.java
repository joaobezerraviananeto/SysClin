
package sysclin.paciente;

import static java.util.Collections.list;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class PacienteTableModel extends AbstractTableModel{
    
    public PacienteTableModel(List<Paciente> pacientes){
            this.pacientes=pacientes;
            this.tituloColunas= new String[]{"Nome", "Telefone", "endereço", "Observação"};
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
        
        }
    
}
