package sysclin.aluno;
import javax.persistence.Column;
import javax.persistence.Entity;
import sysclin.usuario.Usuario;

@Entity
public class Aluno extends Usuario {
    
    @Column(length = 40)
    private String periodo;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
       
}
