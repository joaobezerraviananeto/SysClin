/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysclin.recepcionista;

import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sysclin.aluno.Aluno;
import sysclin.util.HibernateUtil;

/**
 *
 * @author Joao_Viana
 */
public class RecepcionistaDAO {
     private Session sessao;
    private Transaction transacao;

    public void cadastrar(Recepcionista recepcionista) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.save(recepcionista);
            transacao.commit();
            sessao.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cadastrar o recepcionista", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void alterar(Recepcionista recepcionista) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            transacao = sessao.beginTransaction();
            sessao.update(recepcionista);
            transacao.commit();
            sessao.clear();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar alterar o recepcionista", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void excluir(Recepcionista recepcionista) {
        int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este recepcionista?", "Certeza?", JOptionPane.YES_NO_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            try {
                sessao = HibernateUtil.getSessionFactory().openSession();
                transacao = sessao.beginTransaction();
                sessao.delete(recepcionista);
                transacao.commit();
                sessao.clear();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar deletar o recepcionista", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public List<Recepcionista> buscarAlunos() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        transacao = sessao.beginTransaction();
        Criteria criteriaRecepcionista = sessao.createCriteria(Aluno.class);
        List<Recepcionista> recepcionista = criteriaRecepcionista.list();
        sessao.clear();

        return recepcionista;
}
}