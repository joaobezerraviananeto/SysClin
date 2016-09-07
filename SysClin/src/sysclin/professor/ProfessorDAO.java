
package sysclin.professor;

import javax.swing.JOptionPane;
import sysclin.util.GenericDAO;

public class ProfessorDAO extends GenericDAO<Professor> {
      
    public ProfessorDAO(){
        super(Professor.class);
    }
    
    public void salvar(Professor professor){
        if(professor.getId()==0){
            adicionar(professor);
            JOptionPane.showMessageDialog(null, "Professor cadastrado com sucesso");
        }else{
            atualizar(professor);
            JOptionPane.showMessageDialog(null, "Professor alterado com sucesso");
        }
    }
}
