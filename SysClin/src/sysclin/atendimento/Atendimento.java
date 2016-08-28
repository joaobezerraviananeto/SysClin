
package sysclin.atendimento;

import java.util.Date;
import javax.persistence.Column;

@
public abstract class Atendimento {
    
    @Column (length = 10)
    private int id;
    private Date data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
