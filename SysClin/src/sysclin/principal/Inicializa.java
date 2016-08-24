/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysclin.principal;

import sysclin.controladores.ControladorTelaLogin;
import sysclin.telas.Login;
import sysclin.telas.TelaCadastroSupervisor;

/**
 *
 * @author João
 */
public class Inicializa {
    public static void main(String[] args) {
        
        ControladorTelaLogin controladorTelaLogin = new ControladorTelaLogin();
        
        if( controladorTelaLogin.existeUsuarioSupervisor()) {
            new Login().setVisible(true);
        } else {
            new TelaCadastroSupervisor().setVisible(true);
        }
        
    }
}
