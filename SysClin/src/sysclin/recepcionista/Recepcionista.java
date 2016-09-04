
package sysclin.recepcionista;

import javax.persistence.Entity;
import sysclin.usuario.Usuario;

@Entity
public class Recepcionista extends Usuario{
       private String turno;

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
       
}
