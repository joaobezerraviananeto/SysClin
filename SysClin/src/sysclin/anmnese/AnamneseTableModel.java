
package sysclin.anmnese;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class AnamneseTableModel extends AbstractTableModel {
    
    public AnamneseTableModel(List<Anamnese> anamneses ){
        this.anamneses=anamneses;
        tituloColunas = new String[]{"Data", "Duração", "Queixa principal"};
    }

    private List <Anamnese> anamneses;
    private final String tituloColunas[];

    @Override
    public int getRowCount() {
        return anamneses.size();
         }

    @Override
    public int getColumnCount() {
        return tituloColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Anamnese anamnese = anamneses.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return anamnese.getData();
            case 1:
                return anamnese.getDuracao();
            case 2:
                return anamnese.getQueixaPrincipal();
            default:
                return null;
               
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return tituloColunas[0];
            case 1:
                return tituloColunas[1];
            case 2:
                return tituloColunas[2];
            default:
                return null;
        }
    }
   
    
}
