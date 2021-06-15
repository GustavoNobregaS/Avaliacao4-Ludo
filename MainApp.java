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
        String jogador;
        int linha;
        int coluna;
        int i;
        int j;
        
        Scanner entrada;
        entrada = new Scanner(System.in);
        
        
        String[][] tabuleiro = new String[19][19];
        System.out.println(" ------------------- ");
        for(i = 0; i < 19; i = i + 1)
        {
            for(j = 0; j < 19; j = j + 1)
            {
                tabuleiro[i][j] = " ";
            }
        }
        
        for(i = 0; i < 19; i = i + 1)
        {
            if (i < 6 || i > 12)
            {
                for(j = 6; j < 13; j = j + 6)
                {
                    tabuleiro[i][j] = "|";
                }
            }
        }
        for(i = 1; i < 18; i = i + 1)
        {
            if (i < 8 || i > 10)
            {
                for(j = 8; j < 11; j = j + 2)
                {
                    tabuleiro[i][j] = "|";
                }
            }
        }
        for(j = 1; j < 18; j = j + 2)
        {
            if(j == 1 || j == 7 || j == 11 || j == 17)
            {
                i = 9;
                tabuleiro[i][j] = "|";
            }
        }
        
        for(j = 0; j < 19; j = j + 1)
        {
            if (j < 6 || j > 12)
            {
                for(i = 6; i < 13; i = i + 6)
                {
                    tabuleiro[i][j] = "-";
                }
            }
        }
        for(j = 1; j < 18; j = j + 1)
        {
            if (j < 8 || j > 10)
            {
                for(i = 8; i < 11; i = i + 2)
                {
                    tabuleiro[i][j] = "-";
                }
            }
        }
        for(i = 1; i < 18; i = i + 2)
        {
            if(i == 1 || i == 7 || i == 11 || i == 17)
            {
                j = 9;
                tabuleiro[i][j] = "-";
            }
        }
        
        tabuleiro[5][1] = "a";
        tabuleiro[5][2] = "b";
        tabuleiro[5][3] = "c";
        tabuleiro[5][4] = "d";
        tabuleiro[18][1] = "#";
        tabuleiro[18][2] = "$";
        tabuleiro[18][3] = "%";
        tabuleiro[18][4] = "&";
        tabuleiro[0][14] = "1";
        tabuleiro[0][15] = "2";
        tabuleiro[0][16] = "3";
        tabuleiro[0][17] = "4";
        tabuleiro[13][14] = "v";
        tabuleiro[13][15] = "w";
        tabuleiro[13][16] = "y";
        tabuleiro[13][17] = "z";
        
        for(i = 0; i < 19; i = i + 1)
        {
            System.out.print("|");
            for(j = 0; j < 19; j = j + 1)
            {
                System.out.print(tabuleiro[i][j]);
            }
            System.out.println("|");
        }
        System.out.println(" ------------------- ");
    }
}
