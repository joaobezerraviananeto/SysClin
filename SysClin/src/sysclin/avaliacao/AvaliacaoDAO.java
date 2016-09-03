
package sysclin.avaliacao;

import javax.swing.JOptionPane;
import sysclin.util.GenericDAO;


public class AvaliacaoDAO extends GenericDAO<Avaliacao>{
    
    public AvaliacaoDAO(){
        super(Avaliacao.class);
    }
    
    public void salvar(Avaliacao avaliacao){
         if (avaliacao.getId()== 0) {
            adicionar(avaliacao);
            JOptionPane.showMessageDialog(null, "Avaliação cadastrada com sucesso!");
        } else {
            atualizar(avaliacao);
            JOptionPane.showMessageDialog(null, "Avaliação alterado com sucesso!");
        }
    }
}
