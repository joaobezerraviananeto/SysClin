package sysclin.paciente;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Paciente {
    @Id
    @GeneratedValue
    private int id;
    
    @Column (length = 100)
    private String nome;
    
    @Column (length = 8)
    private Date dataNascimento;
    
    @Column (length = 18)
    private String telefone;
    
    
    @Column (length = 120)
    private String endereco;
    
    
    @Column (length = 100)
    private String cidade;
    
    
    @Column (length = 2)
    private String uf;
    
      
    
    @Column (length = 1)
    private char sexo; 
    
    
    @Column (length = 100)
    private String nomePai;
    
    
    
    @Column (length = 100)
    private String nomeMae;
    
    
    @Column (length = 150)
    private String observacao;

    public Paciente(int id, String nome, Date dataNascimento, String telefone, String endereco, String cidade, String uf, String cor, char sexo, String estadoCivil, String religiao, String profissao, String empresa, String nomePai, String nomeMae, String status, String observacao) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.nomePai = nomePai;
        this.nomeMae = nomeMae;
        this.observacao = observacao;
        
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

 

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

      public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

   
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
            
         
}
