package jogodavelha;

import java.util.Scanner;

public class JogoDaVelha {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        //Vetor usado para imprimir o tabuleiro
        char[][] tabuleiro = new char[3][3];
        
        //Apresentação do sinal referente a cada jogador
        System.out.println("jogador 1 (x)");
        System.out.println("jogador 2 (O)");

        //Variável que determina o fim do jogo 
        boolean ganhou = false;
        
        //Contador de rodadas
        int jogada = 1;
        
        int linha = 0, coluna = 0;
        
        char sinal;
        
        //Atribução de caracteres para dar forma ao tabuleiro
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = '?';
            }
        }
        System.out.println();
        
        //Loop de repetição das rodadas
        while (!ganhou) {
            try {
                //A posição informada será verificada antes do prosseguimento do código
                boolean linhaValida = false;
                boolean colunaValida = false;
                
                // Alternância das rodadas entre os jogadores
                if (jogada % 2 == 1) {
                    System.out.println("jogador 1, informe a posição:");
                    sinal = 'x';
                } else {
                    System.out.println("jogador 2, informe a posição:");
                    sinal = 'O';
                }
                
                //Verificar linha
                while (!linhaValida) {
                    System.out.println("digite a linha:");
                    linha = scan.nextInt();
                    if (linha <= 3 & linha >= 1) {
                        linhaValida = true;

                    } else {
                        System.out.println("digite uma linha valida");
                    }
                }
                //Verificar a coluna
                while (!colunaValida) {
                    System.out.println("digite a coluna:");
                    coluna = scan.nextInt();
                    if (coluna <= 3 & coluna >= 1) {
                        colunaValida = true;
                    } else {
                        System.out.println("digite uma coluna valida");
                    }

                }

                /*
                Para tornar o  código mais agradável ao usuário as coordenadas (linhas ecolunas)
                serão recebidas variando de 1 a 3, porém para o funcionamento do código devemos considerar
                números de 0 a 2.
                 */
                linha--;
                coluna--;
                
                /*
                Verificar se a posição informada já foi preenchida, se for o caso, será pedido novamente
                que o usuário informe linha e coluna, caso contrário o sinal referente ao jogador
                daquela rodada será atribuido a posição do vetor que representa o tabuleiro
                */
                if ((tabuleiro[linha][coluna] == 'x') || (tabuleiro[linha][coluna] == 'O')) {
                    System.out.println("posição ja preenchida");
                } else {
                    tabuleiro[linha][coluna] = sinal;
                    jogada++;
                }
                for (int i = 0; i < tabuleiro.length; i++) {
                    for (int j = 0; j < tabuleiro[i].length; j++) {
                        System.out.print(tabuleiro[i][j] + " | ");

                    }
                    System.out.println();
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Erro!");
            }
            
            //Verificação do fim da partida
            
            //Análise com todas as possibilidades de vitória para o jogador 1
            if ((tabuleiro[0][0] == 'x') && (tabuleiro[0][1] == 'x') && (tabuleiro[0][2] == 'x')
                    || (tabuleiro[1][0] == 'x') && (tabuleiro[1][1] == 'x') && (tabuleiro[1][2] == 'x')
                    || (tabuleiro[2][0] == 'x') && (tabuleiro[2][1] == 'x') && (tabuleiro[2][2] == 'x')
                    || (tabuleiro[0][0] == 'x') && (tabuleiro[1][0] == 'x') && (tabuleiro[2][0] == 'x')
                    || (tabuleiro[0][1] == 'x') && (tabuleiro[1][1] == 'x') && (tabuleiro[2][1] == 'x')
                    || (tabuleiro[0][2] == 'x') && (tabuleiro[1][2] == 'x') && (tabuleiro[2][2] == 'x')
                    || (tabuleiro[0][0] == 'x') && (tabuleiro[1][1] == 'x') && (tabuleiro[2][2] == 'x')) {

                ganhou = true;
                System.out.println("Parabens! jogador 1 venceu ");
            
            //Análise com todas as possibilidades de vitória para o jogador 2
            } else if ((tabuleiro[0][0] == 'O') && (tabuleiro[0][1] == 'O') && (tabuleiro[0][2] == 'O')
                    || (tabuleiro[1][0] == 'O') && (tabuleiro[1][1] == 'O') && (tabuleiro[1][2] == 'O')
                    || (tabuleiro[2][0] == 'O') && (tabuleiro[2][1] == 'O') && (tabuleiro[2][2] == 'O')
                    || (tabuleiro[0][0] == 'O') && (tabuleiro[1][0] == 'O') && (tabuleiro[2][0] == 'O')
                    || (tabuleiro[0][1] == 'O') && (tabuleiro[1][1] == 'O') && (tabuleiro[2][1] == 'O')
                    || (tabuleiro[0][2] == 'O') && (tabuleiro[1][2] == 'O') && (tabuleiro[2][2] == 'O')
                    || (tabuleiro[0][0] == 'O') && (tabuleiro[1][1] == 'O') && (tabuleiro[2][2] == 'O')) {

                ganhou = true;
                System.out.println("Parabens! jogador 2 venceu");
                
            //Caso todas as possibilidades de jogada tenham sido realizadas e nenhum vencedor então temos um empate
            // que será detectado através da comparação entre o  número de jogadas e o tamanho do tabuleiro
            } else if (jogada > 9) {

                ganhou = true;
                System.out.println("Velha!!");
            }

        }
    }
}
