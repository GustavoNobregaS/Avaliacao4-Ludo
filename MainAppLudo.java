// Direitos Autorais, PUCRS/Escola Politécnica
// Início: 2021-06-15
// https://github.com/GustavoPucRS/Avaliacao4-Ludo

import java.util.Scanner;

/**
 * A classe MainApp possui o desenvolvimento e o método main(), 
 * permitindo uma partida entre quatro jogadores.
 * 
 * @author Gustavo da Nóbrega Silva (21100654-9)
 * @version 2.0 (20/06/2021)
 */
public class MainAppLudo
{
    /**
     * Cria uma matriz 19x19, preenchida com espaços. 
     * 
     * @return a matriz criada
     */
    public static String[][] init()
    {
        int i;
        int j;
        String[][] board = new String[19][19];
        for(i = 0; i < 19; i = i + 1)
        {
            for(j = 0; j < 19; j = j + 1)
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
        System.out.println(" ------------------- ");
        for(i = 0; i < 19; i = i + 1)
        {
            if (i < 6 || i > 12)
            {
                for(j = 6; j < 13; j = j + 6)
                {
                    board[i][j] = "|";
                }
            }
        }
        for(i = 1; i < 18; i = i + 1)
        {
            if (i < 8 || i > 10)
            {
                for(j = 8; j < 11; j = j + 2)
                {
                   board[i][j] = "|";
                }
            }
        }
        for(j = 1; j < 18; j = j + 2)
        {
            if(j == 1 || j == 7 || j == 11 || j == 17)
            {
                i = 9;
                board[i][j] = "|";
            }
        }
        
        for(j = 0; j < 19; j = j + 1)
        {
            if (j < 6 || j > 12)
            {
                for(i = 6; i < 13; i = i + 6)
                {
                    board[i][j] = "-";
                }
            }
        }
        for(j = 1; j < 18; j = j + 1)
        {
            if (j < 8 || j > 10)
            {
                for(i = 8; i < 11; i = i + 2)
                {
                    board[i][j] = "-";
                }
            }
        }
        for(i = 1; i < 18; i = i + 2)
        {
            if(i == 1 || i == 7 || i == 11 || i == 17)
            {
                j = 9;
                board[i][j] = "-";
            }
        }
        
        board[18][1] = "#";
        board[18][2] = "$";
        board[18][3] = "%";
        board[18][4] = "&";
        board[5][1] = "a";
        board[5][2] = "b";
        board[5][3] = "c";
        board[5][4] = "d";
        board[0][14] = "6";
        board[0][15] = "7";
        board[0][16] = "8";
        board[0][17] = "9";
        board[13][14] = "w";
        board[13][15] = "x";
        board[13][16] = "y";
        board[13][17] = "z";
        board[9][8] = "F";
        board[9][9] = "I";
        board[9][10] = "M";
        
        for(i = 0; i < 19; i = i + 1)
        {
            System.out.print("|");
            for(j = 0; j < 19; j = j + 1)
            {
                System.out.print(board[i][j]);
            }
            System.out.println("|");
        }
        System.out.println(" ------------------- ");
    }
    
    public static boolean fimDeJogo(String[][] board)
    {        
        return vitoria(board,"1") || vitoria(board,"2")
        || vitoria(board,"3") || vitoria(board,"4");
    }
    
    public static boolean vitoria(String[][] board, String player)
    {
        if (board[10][9].equals(player))
        {
            return true;
        }
                       
        return false;
    }
    
    public static void numVitorioso(String[][] board)
    {
        int i;
        int j;
        
        for(j = 1; j < 5; j = j + 1) // j = 0, 1, 2
        {
            if (board[18][j].equals(" "))
            {
                System.out.println("Player 1 ganhou!");
            }
        }
        for(j = 1; j < 5; j = j + 1) // j = 0, 1, 2
        {
            if (board[5][j].equals(" "))
            {
                System.out.println("Player 2 ganhou!");
            }
        }
        for(j = 14; j < 18; j = j + 1) // j = 0, 1, 2
        {
            if (board[0][j].equals(" "))
            {
                System.out.println("Player 3 ganhou!");
            }
        }
        for(j = 14; j < 18; j = j + 1) // j = 0, 1, 2
        {
            if (board[13][j].equals(" "))
            {
                System.out.println("Player 4 ganhou!");
            }
        }
    }
    
    public static void main(String[] args)
    {
        String[][] board;
        String player;
        String peao;
        int jogada;
        int min = 1;
        int max = 6;
        int dado;
        
        Scanner entrada;
        
        entrada = new Scanner(System.in);
        board = init();
        player = "1";
        peao = " ";
        
        System.out.printf("Jogo de tabuleiro Ludo!\n\n");
        while (!fimDeJogo(board))
        {
            dump(board);
            System.out.println("Player 1 = #,$,%,&");
            System.out.println("Player 2 = a,b,c,d");
            System.out.println("Player 3 = 6,7,8,9");
            System.out.println("Player 4 = w,x,y,z");
            System.out.printf("Jogada de: player %s\n", player);
            System.out.print("Coloque 1 para jogar dado ou 2 para parar jogo: ");
            jogada = entrada.nextInt();
            while (jogada < 1 || jogada > 2)
            {
                System.out.print("\tValor inválido. Digite novamente: ");
                jogada = entrada.nextInt();
            }
            if (jogada == 1)
            {
                dado = (int)Math.floor(Math.random()*(max - min + 1) + min);
                System.out.printf("O valor do dado é: %d\n",dado);
                if (player.equals("1"))
                {
                    System.out.println("'#,$,%,&' são suas 4 peças.");
                    System.out.println("Escolha a peça que vai se mover: ");
                    peao = entrada.next();
                    while (!(peao.equals("#")||peao.equals("$")
                    ||peao.equals("%")||peao.equals("&")))
                    {
                        System.out.print("\tValor inválido. Digite novamente: ");
                        peao = entrada.next();
                        System.out.println(peao);
                    }
                }
                if (player.equals("2"))
                {
                    System.out.println("'a,b,c,d' são suas 4 peças.");
                    System.out.println("Escolha a peça que vai se mover: ");
                    peao = entrada.next();
                    while (!(peao.equals("a")||peao.equals("b")
                    ||peao.equals("c")||peao.equals("d")))
                    {
                        System.out.print("\tValor inválido. Digite novamente: ");
                        peao = entrada.next();
                    }
                }
                if (player.equals("3"))
                {
                    System.out.println("'6,7,8,9' são suas 4 peças.");
                    System.out.println("Escolha a peça que vai se mover: ");
                    peao = entrada.next();
                    while (!(peao.equals("6")||peao.equals("7")
                    ||peao.equals("8")||peao.equals("9")))
                    {
                        System.out.print("\tValor inválido. Digite novamente: ");
                        peao = entrada.next();
                    }
                }
                if (player.equals("4"))
                {
                    System.out.println("'w,x,y,z' são suas 4 peças.");
                    System.out.println("Escolha a peça que vai se mover: ");
                    peao = entrada.next();
                    while (!(peao.equals("w")||peao.equals("x")
                    ||peao.equals("y")||peao.equals("z")))
                    {
                        System.out.print("\tValor inválido. Digite novamente: ");
                        peao = entrada.next();
                    }
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
        numVitorioso(board);
    }
}