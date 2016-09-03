
package sysclin.anmnese;

import javax.swing.JOptionPane;
import sysclin.util.GenericDAO;


public class AnamneseDAO extends GenericDAO<Anamnese>{
    public AnamneseDAO(){
    super(Anamnese.class);
}
    
    
    public void salvar(Anamnese anamnese) {
        if (anamnese.getId()== 0) {
            adicionar(anamnese);
            JOptionPane.showMessageDialog(null, "Anamnese cadastrado com sucesso!");
        } else {
            atualizar(anamnese);
            JOptionPane.showMessageDialog(null, "Anamnese alterado com sucesso!");
        }

    }
}
