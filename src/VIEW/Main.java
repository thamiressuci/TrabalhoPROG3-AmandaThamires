/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
 
package VIEW;

import java.awt.Menu;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author DESTRUTOR
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        MenuView progPrincipal = new MenuView(); //criando o menu principal
        progPrincipal.getOperacao(); //iniciando o programa em si
    }
}
