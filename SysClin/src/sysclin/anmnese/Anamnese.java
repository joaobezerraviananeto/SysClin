
package sysclin.anmnese;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;


@Entity
public class Anamnese{
   
    
    @Id
    @GeneratedValue
    private int id;
    
    
    @Column (length = 10)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataAtendimento;
    
    
    @Column (length = 10)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date duracaoAtendimento;
    
    
    @Column (length = 100)
    private String queixaPrincipal;
    
    @Column (length = 500)
    private String historia;
    
    @Column (length = 100)
    private String probReumatismo;
    
    
    @Column (length = 100)
    private String probCardiacos;
    
    
    @Column (length = 100)
    private String probRespiratorios;
    
    @Column (length = 100)
    private String probGastricos;
    
    
    @Column (length = 100)
    private String alergias;
    
    @Column (length = 100)    
    private boolean hepatite;
    
    @Column (length = 100)
    private boolean gravidez;
    
    @Column (length = 100)
    private boolean diabetes;
    
    
    @Column (length = 100)
    private boolean probCicratizacao;
    
    
    @Column (length = 10)
    private int codigoDoenca;
    
    @Column (length = 100)
    private String usoDeMedicamentos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQueixaPrincipal() {
        return queixaPrincipal;
    }

    public void setQueixaPrincipal(String queixaPrincipal) {
        this.queixaPrincipal = queixaPrincipal;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getProbReumatismo() {
        return probReumatismo;
    }

    public void setProbReumatismo(String probReumatismo) {
        this.probReumatismo = probReumatismo;
    }

    public String getProbCardiacos() {
        return probCardiacos;
    }

    public void setProbCardiacos(String probCardiacos) {
        this.probCardiacos = probCardiacos;
    }

    public String getProbRespiratorios() {
        return probRespiratorios;
    }

    public void setProbRespiratorios(String probRespiratorios) {
        this.probRespiratorios = probRespiratorios;
    }

    public String getProbGastricos() {
        return probGastricos;
    }

    public void setProbGastricos(String probGastricos) {
        this.probGastricos = probGastricos;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public boolean isHepatite() {
        return hepatite;
    }

    public void setHepatite(boolean hepatite) {
        this.hepatite = hepatite;
    }

    public boolean isGravidez() {
        return gravidez;
    }

    public void setGravidez(boolean gravidez) {
        this.gravidez = gravidez;
    }

    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }

    public boolean isProbCicratizacao() {
        return probCicratizacao;
    }

    public void setProbCicratizacao(boolean probCicratizacao) {
        this.probCicratizacao = probCicratizacao;
    }

    public int getCodigoDoenca() {
        return codigoDoenca;
    }

    public void setCodigoDoenca(int codigoDoenca) {
        this.codigoDoenca = codigoDoenca;
    }

    public String getUsoDeMedicamentos() {
        return usoDeMedicamentos;
    }

    public void setUsoDeMedicamentos(String usoDeMedicamentos) {
        this.usoDeMedicamentos = usoDeMedicamentos;
    }

    public Date getDataAtendimento() {
        return dataAtendimento;
    }

    public void setDataAtendimento(Date dataAtendimento) {
        this.dataAtendimento = dataAtendimento;
    }

    public Date getDuracaoAtendimento() {
        return duracaoAtendimento;
    }

    public void setDuracaoAtendimento(Date duracaoAtendimento) {
        this.duracaoAtendimento = duracaoAtendimento;
    }
    }
