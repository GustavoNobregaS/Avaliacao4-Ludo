// Direitos Autorais, PUCRS/Escola Politécnica
// Início: 2021-06-15
// https://github.com/GustavoPucRS/Avaliacao4-Ludo

import java.util.Scanner;

/**
 * A classe MainApp possui o desenvolvimento e o método main(), 
 * permitindo uma partida entre quatro jogadores.
 * 
 * @author Gustavo 
 * @version 1.0 (15/06/2021)
 */
public class MainApp
{
    public static void main(String[] args)
    {
        int i;
        int j;
        
        Scanner entrada;
        
        entrada = new Scanner(System.in);
        
        String[][] tabuleiro = new String[13][13];
        for(i = 0; i < 13; i = i + 1)
        {
            for(j = 0; j < 13; j = j + 1)
            {
                tabuleiro[i][j] = " ";
            }
        }
        for(i = 0; i < 13; i = i + 1)
        {
            System.out.print("|");
            for(j = 0; j < 13; j = j + 1)
            {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println("|");
        }
    }
}
