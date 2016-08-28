/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysclin.aluno;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sysclin.util.HibernateUtil;

public class AlunoDAO {

    private Session sessao;
    private Transaction transacao;

    public void cadastrar(Aluno aluno) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(aluno);
            transacao.commit();
            sessao.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar o aluno", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void alterar(Aluno aluno) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(aluno);
            transacao.commit();
            sessao.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar alterar o aluno", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public List<Aluno> buscarAlunos(){
    
    }
}
