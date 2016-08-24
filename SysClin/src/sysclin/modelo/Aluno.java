package sysclin.modelo;

import java.util.Date;


public class Aluno extends Usuario {
    
    private String periodo;
    
    public Aluno(String nome, int cpf, String telefone, Date dataNascimento, char sexo, String endereco, String cidade, String uf, String login, String senha, String instituicao, String periodo) {
        super(nome, cpf, telefone, dataNascimento, sexo, endereco, cidade, uf, login, senha, instituicao);
        
        setPeriodo(periodo);
        
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    
}
