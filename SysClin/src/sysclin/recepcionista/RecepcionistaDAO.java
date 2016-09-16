
package sysclin.recepcionista;

import javax.swing.JOptionPane;
import sysclin.util.GenericDAO;

public class RecepcionistaDAO extends GenericDAO<Recepcionista> {
     public RecepcionistaDAO(){
         super(Recepcionista.class);
     }
     
     public void salvar(Recepcionista recepcionista){
         if(recepcionista.getId()==0){
             adicionar(recepcionista);
             JOptionPane.showMessageDialog(null, "Recepcionista cadastrado com sucesso");
         }else{
             atualizar(recepcionista);
             JOptionPane.showMessageDialog(null, "Recepcionista alterado com sucesso");
         }
     }
}