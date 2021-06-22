// Direitos Autorais, PUCRS/Escola Politécnica
// Início: 2021-06-15
// https://github.com/GustavoPucRS/Avaliacao4-Ludo

import java.util.Scanner;

/**
 * A classe MainApp possui o desenvolvimento e o método main(), 
 * permitindo uma partida entre quatro jogadores.
 * 
 * @author Gustavo da Nóbrega Silva (21100654-9)
 * @version 1.0 (21/06/2021)
 */
public class MainApp
{
    /**
     * Cria uma matriz 25x25, preenchida com espaços. 
     * 
     * @return a matriz criada
     */
    public static String[][] init()
    {
        int i;
        int j;
        String[][] board = new String[25][25];
        // Colocando as peças no inicio do tabuleiro
        for(j = 0; j < 25; j = j + 7)
        {
            board[0][j] = "1";
        }
        for(j = 1; j < 25; j = j + 7)
        {
            board[0][j] = "2";
        }
        for(j = 2; j < 25; j = j + 7)
        {
            board[0][j] = "3";
        }
        for(j = 3; j < 25; j = j + 7)
        {
            board[0][j] = "4";
        }
        
        for(j = 5; j < 25; j = j + 7)
        {
            board[0][j] = " ";
        }
            
        for(i = 1; i < 25; i = i + 1)
        {
            for(j = 0; j < 25; j = j + 1)
            {
                board[i][j] = " ";
            }
        }
        return board;
    }
    
    /**
     * 
     * @param
     */
    public static void dump(String[][] board)
    {
        int i;
        int j;
        for(i = 0; i < 25; i = i + 1) 
        {
            for(j = 4; j < 25; j = j + 7)
            {
                board[i][j] = "|";
            }
        }
        for(i = 0; i < 25; i = i + 1) 
        {
            for(j = 6; j < 25; j = j + 7)
            {
                board[i][j] = "|";
            }
        }
        for(i = 0; i < 25; i = i + 1) 
        {
            System.out.print("|");
            for(j = 0; j < 25; j = j + 1)
            {
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }
    }
    
    public static boolean fimDeJogo(String[][] board)
    {        
        return vitoria(board);
    }
    
    public static boolean vitoria(String[][] board)
    {
        if ((board[24][0].equals("1")) && (board[24][1].equals("2"))
        && (board[24][2].equals("3")) && (board[24][3].equals("4")))
        {
            return true;
        }
        if ((board[24][7].equals("1")) && (board[24][8].equals("2"))
        && (board[24][9].equals("3")) && (board[24][10].equals("4")))
        {
            return true;
        }
        if ((board[24][14].equals("1")) && (board[24][15].equals("2"))
        && (board[24][16].equals("3")) && (board[24][17].equals("4")))
        {
            return true;
        }
        if ((board[24][21].equals("1")) && (board[24][22].equals("2"))
        && (board[24][23].equals("3")) && (board[24][24].equals("4")))
        {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args)
    {
        String[][] board;
        String player;
        int jogada;
        int rodada;
        int coluna;
        int[] movLinha;
        int v;
        int movReal;
        int colunaReal;
        int dado;
        Scanner entrada;
        
        entrada = new Scanner(System.in);
        board = init();
        player = "1";
        v = 0;
        movReal = 0;
        rodada = 0;
        movLinha = new int[16];
        System.out.printf("Jogo de tabuleiro Ludo!\n\n");
        while (!fimDeJogo(board))
        {
            dump(board);
            System.out.printf("Jogada de: player %s\n", player);
            System.out.print("Coloque 1 para jogar dado: ");
            jogada = entrada.nextInt();
            if (jogada != 1)
            {
                System.out.print("\tValor inválido. Digite novamente: ");
                jogada = entrada.nextInt();
            }
            rodada = Auxiliar.round(rodada);
            System.out.printf("Rodada: %d\n",rodada);
            dado = jogada + (int)(Math.random() *(6));
            System.out.printf("O valor do dado é: %d\n",dado);
            System.out.print("Escolha a coluna que a peça vai mover (1,2,3,4): ");
            coluna = entrada.nextInt();
            while (coluna < 1 || coluna > 4)
            {
                System.out.print("\tValor inválido. Digite novamente: ");
                coluna = entrada.nextInt();
            }
            if (player.equals("1"))
            {
                if (movLinha[coluna -1] + dado < 25)
                {
                    movReal = coluna - 1;
                    colunaReal = coluna -1;
                    board [movLinha[movReal]][colunaReal] = " ";
                    movLinha[movReal] = movLinha[movReal] + dado;
                    board [movLinha[movReal]][colunaReal] = String.valueOf(coluna);
                }
                else
                {
                    System.out.println("Valor inválido.");
                    System.out.println("Valor exato para chegar na última linha!");
                }
            }
            if (player.equals("2"))
            {
                if (movLinha[coluna + 3] + dado < 25)
                {
                    movReal = coluna + 3;
                    colunaReal = coluna + 6;
                    board [movLinha[movReal]][colunaReal] = " ";
                    movLinha[movReal] = movLinha[movReal] + dado;
                    board [movLinha[movReal]][colunaReal] = String.valueOf(coluna);
                }
                else
                {
                    System.out.println("Valor inválido.");
                    System.out.println("Valor exato para chegar na última linha!");
                }
            }
            if (player.equals("3"))
            {
                if (movLinha[coluna + 7] + dado < 25)
                {
                    movReal = coluna + 7;
                    colunaReal = coluna + 13;
                    board [movLinha[movReal]][colunaReal] = " ";
                    movLinha[movReal] = movLinha[movReal] + dado;
                    board [movLinha[movReal]][colunaReal] = String.valueOf(coluna);
                }
                else
                {
                    System.out.println("Valor inválido.");
                    System.out.println("Valor exato para chegar na última linha!");
                }
            }
            if (player.equals("4"))
            {
                if (movLinha[coluna + 11] + dado < 25)
                {
                    movReal = coluna + 11;
                    colunaReal = coluna + 20;
                    board [movLinha[movReal]][colunaReal] = " ";
                    movLinha[movReal] = movLinha[movReal] + dado;
                    board [movLinha[movReal]][colunaReal] = String.valueOf(coluna);
                }
                else
                {
                    System.out.println("Valor inválido.");
                    System.out.println("Valor exato para chegar na última linha!");
                }
            }
            if (player.equals("1"))
            {
                player = "2";
            } 
            else if (player.equals("2"))
            {
                player = "3";        
            }
            else if (player.equals("3"))
            {
                player = "4";        
            }
            else if (player.equals("4"))
            {
                player = "1";        
            }
        }
        entrada.close();
        dump(board);
        System.out.println("**FIM DE JOGO**");
    }
}