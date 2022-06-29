package br.com.atlanticsolutions.algoritmo;

public class AlgoritmoSequenciaProva {
	/**	 
	 * Implemente o método que recebe um array de Inteiros de uma maneira que retorne uma String com os
	 * números organizados nas seguintes condições: 
	 * 
     *      Condição 1:  "-"(hífen)    Quando os números forem sequenciais, deve-se mostrar o primeiro e o último número do período apenas colocando um "-" no meio deles.     
	 *      Condição 2:  ","(vírgula)  Quando existir uma quebra na sequência dos números, deve-se colocar "," e em seguida o número que quebrou a sequência.
	 *      Condição 3:  " "(espaço)   Você não precisa se preocupar em colocar o caractere espaço " " entre os números na formatação da sua String.
	 * 
	 * Para melhor entendimento, veja alguns exemplos de entrada/saída do que se espera do algoritmo:
	 * 
     *      Exemplo 1 : Entrada : {1,2,3,4,5,6,7,8,9,10}
     *                  Saída   : "1-10"
     *
     *      Exemplo 2 : Entrada : {1,2,3,4,6,7,8,9}
     *                  Saída   : "1-4,6-9"
     *
	 *      Exemplo 3 : Entrada : {1,2,3,4,5,8,10,11,12,13,14,15}
	 *                  Saída   : "1-5,8,10-15"	 
	 * 
	 *      Exemplo 4 : Entrada : {1,2,3,5,7,10,11,12,13,20}
	 *                  Saída   : "1-3,5,7,10-13,20"
	 * 
	 *      Exemplo 5 : Entrada : {1,3,5,6,9,10,11,12}
	 *                  Saída   : "1,3,5-6,9-12"	        
	 */

	public String obterSequenciaFormatada(int[] valores){
        String retorno = new String("");
        int ultimoNumero = 0;
        int penultimoNumero = 0;
        boolean iniciandoSequencia = true;

        for (int n : valores) {
            if(ultimoNumero == 0) { // iniciar
                retorno += String.valueOf(n);
                penultimoNumero = n;
                ultimoNumero = n;
                iniciandoSequencia = false;
            }else if(ultimoNumero + 1 == n) {// é sequencia
                if(ultimoNumero-penultimoNumero > 1|| ultimoNumero-penultimoNumero == 0){
                    iniciandoSequencia = true;
                }
                retorno = formataQuandoSequencia(retorno.toString(), n, iniciandoSequencia);
                iniciandoSequencia = false;
                penultimoNumero = ultimoNumero;
                ultimoNumero = n;
            }else{
                retorno += ","+n;
                penultimoNumero = ultimoNumero;
                ultimoNumero = n;
            }
        }
        return retorno;
    }
	
	public String formataQuandoSequencia(String texto, int novoNumeroSequencia, boolean inicioSequencia){
        if(inicioSequencia){
            texto += "-";
        }
        for (int i = 0; i < texto.length(); i++) {
            String lastCharacter = texto.substring(texto.length() - 1);
            if (lastCharacter.equals("-")){
                break;
            }else{
                texto = texto.substring(0, texto.length() - 1);
            }
        }
        texto+=String.valueOf(novoNumeroSequencia);
        return texto;
    }
	
}
