
package sysclin.professor;

import sysclin.usuario.Usuario;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Professor extends Usuario {
    
    @Column(length = 40)
    private String turma;
    
    @Column (length = 50)
    private String especialização;

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getEspecialização() {
        return especialização;
    }

    public void setEspecialização(String especialização) {
        this.especialização = especialização;
    }
    
}
