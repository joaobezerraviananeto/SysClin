/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysclin.modelo;

import java.util.Date;

/**
 *
 * @author João
 */
public class Supervisor extends Usuario{
    
    public Supervisor(String nome, int cpf, String telefone, Date dataNascimento, char sexo, String endereco, String cidade, String uf, String login, String senha, String instituicao) {
        super(nome, cpf, telefone, dataNascimento, sexo, endereco, cidade, uf, login, senha, instituicao);
    }
    
}
