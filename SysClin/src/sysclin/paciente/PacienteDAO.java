
package sysclin.paciente;

import javax.swing.JOptionPane;
import sysclin.util.GenericDAO;


public class PacienteDAO extends GenericDAO<Paciente> {
     public PacienteDAO() {
        super(Paciente.class);
    }

    public void salvar(Paciente paciente) {
        if (paciente.getId()== 0) {
            adicionar(paciente);
            JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
        } else {
            atualizar(paciente);
            JOptionPane.showMessageDialog(null, "Paciente alterado com sucesso!");
        }

    }
}
