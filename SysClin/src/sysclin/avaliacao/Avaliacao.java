
package sysclin.avaliacao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Avaliacao {
    
   @Id
    @GeneratedValue
    private int id;
   
   @Column (length = 200)
    private String observacao;
   
    @Column (length = 200)
    private String conceito;

    public Avaliacao(int id, String observacao, String conceito) {
        this.id = id;
        this.observacao = observacao;
        this.conceito = conceito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getConceito() {
        return conceito;
    }

    public void setConceito(String conceito) {
        this.conceito = conceito;
    }
    
    
}
