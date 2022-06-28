package br.com.atlanticsolutions;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.atlanticsolutions.algoritmo.AlgoritmoSequenciaProva;

public class AlgoritmoSequenciaProvaTest {
	AlgoritmoSequenciaProva algoritmoSequenciaProva = new AlgoritmoSequenciaProva();

	public static final String SAIDA_EXEMPLO_1 = "1-10";
	public static final String SAIDA_EXEMPLO_2 = "1-4,6-9";
	public static final String SAIDA_EXEMPLO_3 = "1-5,8,10-15";
	public static final String SAIDA_EXEMPLO_4 = "1-3,5,7,10-13,20";
	public static final String SAIDA_EXEMPLO_5 = "1,3,5-6,9-12";
	
    @Test
    public void deveRetornarSaidaExemplo1() {
        int[] numeros = {1,2,3,4,5,6,7,8,9,10};
        String stringFormatada = algoritmoSequenciaProva.obterSequenciaFormatada(numeros);
        assertEquals("Saída : ", SAIDA_EXEMPLO_1, stringFormatada);

    }
    
    @Test
    public void deveRetornarSaidaExemplo2() {
        int[] numeros = {1,2,3,4,6,7,8,9};
        String stringFormatada = algoritmoSequenciaProva.obterSequenciaFormatada(numeros);
        assertEquals("Saída : ", SAIDA_EXEMPLO_2, stringFormatada);

    }
    
    @Test
    public void deveRetornarSaidaExemplo3() {
        int[] numeros = {1,2,3,4,5,8,10,11,12,13,14,15};
        String stringFormatada = algoritmoSequenciaProva.obterSequenciaFormatada(numeros);
        assertEquals("Saída : ", SAIDA_EXEMPLO_3, stringFormatada);

    }
    
    @Test
    public void deveRetornarSaidaExemplo4() {
        int[] numeros = {1,2,3,5,7,10,11,12,13,20};
        String stringFormatada = algoritmoSequenciaProva.obterSequenciaFormatada(numeros);
        assertEquals("Saída : ", SAIDA_EXEMPLO_4, stringFormatada);

    }
    
    @Test
    public void deveRetornarSaidaExemplo5() {
        int[] numeros = {1,3,5,6,9,10,11,12};
        String stringFormatada = algoritmoSequenciaProva.obterSequenciaFormatada(numeros);
        assertEquals("Saída : ", SAIDA_EXEMPLO_5, stringFormatada);

    }
}
