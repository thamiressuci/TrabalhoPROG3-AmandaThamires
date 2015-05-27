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
public class VerificacaoDaoImp {
    
    public boolean verificarStringVazia(String string){
		if (string.isEmpty() || string.equals("")) return true;
		else return false;
	}
	
	public boolean verificarStringSoNumeros (String string){
		if(string == null)  
	        return false;  
	    for (char letra : string.toCharArray())  
	        if(letra < '0' || letra > '9')  
	            return false;  
	    return true;  
	}
	
	public boolean verificarCpf(String strCpf) {  
        if (strCpf.equals("")) {  
            return false;  
        }  
        int d1, d2;  
        int digito1, digito2, resto;  
        int digitoCPF;  
        String nDigResult;  
  
        d1 = d2 = 0;  
        digito1 = digito2 = resto = 0;  
  
        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {  
            digitoCPF = Integer.valueOf(strCpf.substring(nCount - 1, nCount)).intValue();  
  
            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
            d1 = d1 + (11 - nCount) * digitoCPF;  
  
            //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
            d2 = d2 + (12 - nCount) * digitoCPF;  
        }  
  
        //Primeiro resto da divisao por 11.  
        resto = (d1 % 11);  
  
        //Se o resultado for 0 ou 1 o digito é 0 caso contrario o digito e 11 menos o resultado anterior.  
        if (resto < 2) {  
            digito1 = 0;  
        } else {  
            digito1 = 11 - resto;  
        }  
  
        d2 += 2 * digito1;  
  
        //Segundo resto da divisao por 11.  
        resto = (d2 % 11);  
  
         //Se o resultado for 0 ou 1 o digito e 0 caso contrario o digito e 11 menos o resultado anterior.  
        if (resto < 2) {  
            digito2 = 0;  
        } else {  
            digito2 = 11 - resto;  
        }  
  
        //Digito verificador do CPF que esta sendo validado.  
        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());  
  
        //Concatenando o primeiro resto com o segundo.  
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);  
  
        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
        return nDigVerific.equals(nDigResult);  
    }  
}