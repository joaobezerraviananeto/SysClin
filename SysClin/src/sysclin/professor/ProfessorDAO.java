/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysclin.professor;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sysclin.util.HibernateUtil;

/**
 *
 * @author Joao_Viana
 */
public class ProfessorDAO {
    private Session sessao;
    private Transaction transacao;

    public void cadastrar(Professor professor) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(professor);
            transacao.commit();
            sessao.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar o professor", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void alterar(Professor professor) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(professor);
            transacao.commit();
            sessao.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar alterar o professor", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluir(Professor professor) {
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este Professor?", "Certeza?", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                transacao = sessao.beginTransaction();
                sessao.delete(professor);
                transacao.commit();
                sessao.clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar deletar o professor", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public List<Professor> buscarProfessores() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Criteria criteriaProfessor = sessao.createCriteria(Professor.class);
        List<Professor> professor = criteriaProfessor.list();
        sessao.clear();

        return professor;
    }
}
