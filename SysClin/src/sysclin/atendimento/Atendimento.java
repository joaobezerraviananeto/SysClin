
package sysclin.atendimento;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@DiscriminatorValue("Atendimento")
public abstract class Atendimento {
    
    @Id
    @GeneratedValue
    private int id;
    
    
    @Column (length = 10)
    private Date dataAtendimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return dataAtendimento;
    }

    public void setData(Date data) {
        this.dataAtendimento = data;
    }
}
