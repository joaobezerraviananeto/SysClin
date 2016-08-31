package sysclin.aluno;

import javax.swing.JOptionPane;
import sysclin.util.GenericDAO;

public class AlunoDAO extends GenericDAO<Aluno> {

    public AlunoDAO() {
        super(Aluno.class);
    }

    public void salvar(Aluno aluno) {
        if (aluno.getId()== 0) {
            adicionar(aluno);
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
        } else {
            atualizar(aluno);
            JOptionPane.showMessageDialog(null, "Aluno alterado com sucesso!");
        }

    }

}
