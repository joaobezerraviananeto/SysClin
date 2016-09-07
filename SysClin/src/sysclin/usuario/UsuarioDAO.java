/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysclin.usuario;

import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import sysclin.util.GenericDAO;
import sysclin.util.HibernateUtil;

/**
 *
 * @author João
 */
public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO() {
        super(Usuario.class);
    }

    public boolean isLoginValido(String login, String senha) {
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            Criteria criteria = getSessao().createCriteria(Usuario.class);
            Usuario usuario = (Usuario) criteria.add(Restrictions.eq("senha", senha)).add(Restrictions.eq("login", login)).uniqueResult();
            return usuario != null;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao realizar o login"+e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }

    }

}
