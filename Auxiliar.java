// Direitos Autorais, PUCRS/Escola Politécnica
// Início: 2021-06-22
// https://github.com/GustavoPucRS/Avaliacao4-Ludo

import java.util.Scanner;

/**
 * A classe Auxiliar possue um subprograma que 
 * permite calcular a soma da linha com o dado.
 * 
 * @author Gustavo da Nóbrega Silva (21100654-9)
 * @version 1.0 (22/06/2021)
 */
public class Auxiliar
{
    public static int movDado(int jogada)
    {
        int n;
        n = jogada + (int)(Math.random() *(6));
        return n;
    }
}