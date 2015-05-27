/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.DAO;

/**
 *
 * @author thamires
 */
public interface ArqVerificacao {
    public boolean verificarStringVazia(String string);
    public boolean verificarStringSoNumeros(String string);
    public boolean verificarCpf(String strCpf);
}

