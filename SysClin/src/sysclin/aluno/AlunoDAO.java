package sysclin.aluno;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sysclin.util.GenericDAO;
import sysclin.util.HibernateUtil;

public class AlunoDAO extends GenericDAO<Aluno> {

    public AlunoDAO() {
        super(Aluno.class);
    }

    public void salvar(Aluno aluno) {
        if (aluno.getId()== 0) {
            adicionar(aluno);
            JOptionPane.showMessageDialog(null, "Aluno Cadastrado com Sucesso!");
        } else {
            atualizar(aluno);
            JOptionPane.showMessageDialog(null, "Aluno Alterado com Sucesso!");
        }

    }

}
