
package sysclin.supervisor;

import javax.swing.JOptionPane;
import sysclin.util.GenericDAO;

public class SupervisorDAO extends GenericDAO<Supervisor> {
  public SupervisorDAO(){
      super(Supervisor.class);
  }
  
  public void salvar(Supervisor supervisor){
      if(supervisor.getId()==0){
          adicionar(supervisor);
          JOptionPane.showMessageDialog(null, "Supervisor cadastrado com sucesso!");
      }else{
          atualizar(supervisor);
           JOptionPane.showMessageDialog(null, "Supervisor alterado com sucesso com Sucesso!");
      }
  }
  
  public boolean existeUmSupervisor(){
     return !listar().isEmpty();
  }
}
