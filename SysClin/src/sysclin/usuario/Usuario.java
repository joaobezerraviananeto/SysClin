package sysclin.usuario;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

/**
 *
 * @author João
 */
@MappedSuperclass
@DiscriminatorValue("usuario")
public abstract class Usuario {
    
    @Id
    @GeneratedValue
    private int id;
    
    @Column (length = 100, nullable = false)
    private String nome;
     
    @Column (length = 11)
    private long cpf;
    
    @Column (length=20)
    private String telefone;
    
    @Column (length = 15)
    private Date dataNascimento;
    
    
    @Column (length = 1)
    private char sexo;
    
    @Column (length = 150)
    private String endereco;
    
    @Column (length = 150)
    private String bairro;
    
    @Column (length = 6)
    private int enderecoNumero;
    
    
    @Column (length = 100)
    private String cidade;
    
    
    @Column (length = 2)
    private String uf;
    
    
    @Column (length = 50)
    private String login;
    
    
    @Column (length = 50)
    private String senha;
    
    @Column (length = 40)
    private String email;
    
    
    @Column (length = 300)
    private String complemento;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the enderecoNumero
     */
    public int getEnderecoNumero() {
        return enderecoNumero;
    }

    /**
     * @param enderecoNumero the enderecoNumero to set
     */
    public void setEnderecoNumero(int enderecoNumero) {
        this.enderecoNumero = enderecoNumero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

      
    
}
