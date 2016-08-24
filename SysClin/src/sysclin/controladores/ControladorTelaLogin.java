/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysclin.controladores;

import sysclin.modelo.Aluno;
import sysclin.modelo.Usuario;
import java.util.Date;

/**
 *
 * @author Joao_Viana
 */
public class ControladorTelaLogin {
    
    public boolean existeUsuarioSupervisor(){
    
        return false;
    }
    
    
    public Usuario autenticarUsuario(String login, String senha){
        if(login.equals("joao") && senha.equals("joao")){
        
            Usuario joao = new Aluno("joao", 1123, "joao", new Date(), 'M', "", "", "", "", "", "", "");
        
            return joao;
        }
        else {
            return null;    
        }
        
    }
    
}
