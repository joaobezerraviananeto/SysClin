
package sysclin.supervisor;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import sysclin.util.GenericDAO;
import sysclin.util.HibernateUtil;

public class SupervisorDAO extends GenericDAO<Supervisor> {
  public SupervisorDAO(){
      super(Supervisor.class);
  }
  /*
  public void salvar(Supervisor supervisor){
      if(supervisor.getId()==0){
          adicionar(supervisor);
          JOptionPane.showMessageDialog(null, "Supervisor cadastrado com sucesso!");
      }else{
          atualizar(supervisor);
           JOptionPane.showMessageDialog(null, "Supervisor alterado com sucesso com Sucesso!");
      }
  }
*/
  
  public boolean existeUmSupervisor(){
     return !listar().isEmpty();
  }
  
  public List<Supervisor>pesqPorPalavraChave(String palChave){
      setSessao(HibernateUtil.getSessionFactory().openSession());
      setTransacao(getSessao().beginTransaction());
      Criteria crit = getSessao().createCriteria(Supervisor.class);
      crit.add(Restrictions.or(
              Restrictions.ilike("nome", "%"+palChave+"%"), 
              Restrictions.ilike("cpf", "%"+palChave+"%"), 
              Restrictions.ilike("telefone", "%"+palChave+"%"))
      );
      return crit.list();
  }
}
