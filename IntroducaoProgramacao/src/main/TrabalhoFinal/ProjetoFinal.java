import java.util.Random;
import java.util.Scanner;

public class ProjetoFinal {
    public ProjetoFinal() {

        Scanner sc = new Scanner(System.in);
        Random aleatorio = new Random();

        char planoUsuario[][] = new char[8][8];
        char planoBatalha[][] = new char[8][8];
        int posicionamentoNavios[][] = new int[8][8];

        System.out.println("   ___       _        _ _                 __                 _ ");
        System.out.println("  / __\\ __ _| |_ __ _| | |__   __ _    /\\ \\ \\__ ___   ____ _| |");
        System.out.println(" /__\\/// _` | __/ _` | | '_ \\ / _` |  /  \\/ / _` \\ \\ / / _` | |");
        System.out.println("/ \\/  \\ (_| | || (_| | | | | | (_| | / /\\  / (_| |\\ V / (_| | |");
        System.out.println("\\_____/\\__,_|\\__\\__,_|_|_| |_|\\__,_| \\_\\ \\/ \\__,_| \\_/ \\__,_|_|");
        System.out.println("                                                                ");

        iniciarTabuleiroUsuario(planoUsuario);
        iniciarTabuleiroBatalha(planoBatalha);

        posicionamentoNavios(planoBatalha, aleatorio, posicionamentoNavios);

        jogando(sc, planoUsuario, planoBatalha, posicionamentoNavios);

        sc.close();
    }

    private void iniciarTabuleiroUsuario(char[][] planoUsuario) {

        // Método que inicializa o tabuleiro visível ao usuário com água (~)
        for (int i = 0; i < planoUsuario.length; i++) {
            for (int j = 0; j < planoUsuario[i].length; j++) {
                planoUsuario[i][j] = '~';
            }
        }
        mostrarPlanoUsuario(planoUsuario);
    }

    private void iniciarTabuleiroBatalha(char[][] planoBatalha) {
        // Método que inicializa o tabuleiro interno (batalha) com água (~)
        for (int i = 0; i < planoBatalha.length; i++) {
            for (int j = 0; j < planoBatalha[i].length; j++) {
                planoBatalha[i][j] = '~';
            }
        }
    }

    private void posicionamentoNavios(char[][] planoBatalha, Random aleatorio, int[][] posicionamentoNavios) {
        int celulaPosicionamento = 0; // Contador de células para identificar cada posição do navio

        // Definição de quantidade e tamanho de cada tipo de navio
        int qtdPortaAvioes = 1, tamanhaPortaAvioes = 4;
        char tipoPortaAvioes = 'P';
        int qtdCruzadores = 2, tamanhaCruzador = 3;
        char tipoCruzador = 'C';
        int qtdDestroyers = 3, tamanhoDestroyers = 2;
        char tipoDestroyer = 'D';
        int submarinos = 4;
        char tipoSubmarino = 'S';

        // Posiciona submarinos no tabuleiro
        while (submarinos > 0) {
            int linha = aleatorio.nextInt(planoBatalha.length);
            int coluna = aleatorio.nextInt(planoBatalha.length);

            if (planoBatalha[linha][coluna] == '~') {
                planoBatalha[linha][coluna] = tipoSubmarino;
                submarinos--;
                posicionamentoNavios[linha][coluna] = celulaPosicionamento++;
            }
        }

        // Posiciona destroyers no tabuleiro
        while (qtdDestroyers > 0) {
            int linha = aleatorio.nextInt(planoBatalha.length); // Gera linha aleatória
            int coluna = aleatorio.nextInt(planoBatalha.length); // Gera coluna aleatória
            boolean horizontal = aleatorio.nextBoolean(); // Decide se será horizontal ou vertical

            if (horizontal) {
                if (coluna + tamanhoDestroyers <= planoBatalha.length) { // Verifica se cabe horizontalmente
                    boolean cabeDestroyer = true;
                    for (int j = 0; j < tamanhoDestroyers; j++) {
                        if (planoBatalha[linha][coluna + j] != '~') { // Verifica se há espaço livre
                            cabeDestroyer = false;
                            break;
                        }
                    }
                    if (cabeDestroyer) {
                        for (int j = 0; j < tamanhoDestroyers; j++) {
                            planoBatalha[linha][coluna + j] = tipoDestroyer; // Posiciona navio
                            posicionamentoNavios[linha][coluna + j] = celulaPosicionamento++;
                        }
                        qtdDestroyers--;
                    }
                }
            } else {
                if (linha + tamanhoDestroyers <= planoBatalha.length) { // Verifica se cabe verticalmente
                    boolean cabeDestroyer = true;
                    for (int j = 0; j < tamanhoDestroyers; j++) {
                        if (planoBatalha[linha + j][coluna] != '~') {
                            cabeDestroyer = false;
                            break;
                        }
                    }
                    if (cabeDestroyer) {
                        for (int j = 0; j < tamanhoDestroyers; j++) {
                            planoBatalha[linha + j][coluna] = tipoDestroyer;
                            posicionamentoNavios[linha + j][coluna] = celulaPosicionamento++;
                        }
                        qtdDestroyers--;
                    }
                }
            }
        }

        // Posiciona Cruzadores no tabuleiro da mesma forma que os destroyers
        while (qtdCruzadores > 0) {
            int linha = aleatorio.nextInt(planoBatalha.length);
            int coluna = aleatorio.nextInt(planoBatalha.length);
            boolean horizontal = aleatorio.nextBoolean();

            if (horizontal) {
                if (coluna + tamanhaCruzador <= planoBatalha.length) {
                    boolean cabeCruzador = true;
                    for (int j = 0; j < tamanhaCruzador; j++) {
                        if (planoBatalha[linha][coluna + j] != '~') {
                            cabeCruzador = false;
                            break;
                        }
                    }
                    if (cabeCruzador) {
                        for (int j = 0; j < tamanhaCruzador; j++) {
                            planoBatalha[linha][coluna + j] = tipoCruzador;
                            posicionamentoNavios[linha][coluna + j] = celulaPosicionamento++;
                        }
                        qtdCruzadores--;
                    }
                }
            } else {
                if (linha + tamanhaCruzador <= planoBatalha.length) {
                    boolean cabeCruzador = true;
                    for (int j = 0; j < tamanhaCruzador; j++) {
                        if (planoBatalha[linha + j][coluna] != '~') {
                            cabeCruzador = false;
                            break;
                        }
                    }
                    if (cabeCruzador) {
                        for (int j = 0; j < tamanhaCruzador; j++) {
                            planoBatalha[linha + j][coluna] = tipoCruzador;
                            posicionamentoNavios[linha + j][coluna] = celulaPosicionamento++;
                        }
                        qtdCruzadores--;
                    }
                }

            }
        }

        // Posiciona Porta aviões no tabuleiro da mesma forma que os destroyers
        while (qtdPortaAvioes > 0) {
            int linha = aleatorio.nextInt(planoBatalha.length);
            int coluna = aleatorio.nextInt(planoBatalha.length);
            boolean horizontal = aleatorio.nextBoolean();

            if (horizontal) {
                if (coluna + tamanhaPortaAvioes <= planoBatalha.length) {
                    boolean cabePortaAvioes = true;
                    for (int j = 0; j < tamanhaPortaAvioes; j++) {
                        if (planoBatalha[linha][coluna + j] != '~') {
                            cabePortaAvioes = false;
                            break;
                        }
                    }
                    if (cabePortaAvioes) {
                        for (int j = 0; j < tamanhaPortaAvioes; j++) {
                            planoBatalha[linha][coluna + j] = tipoPortaAvioes;
                            posicionamentoNavios[linha][coluna + j] = celulaPosicionamento++;
                        }
                        qtdPortaAvioes--;
                    }
                }
            } else {
                if (linha + tamanhaPortaAvioes <= planoBatalha.length) {
                    boolean cabePortaAvioes = true;
                    for (int j = 0; j < tamanhaPortaAvioes; j++) {
                        if (planoBatalha[linha + j][coluna] != '~') {
                            cabePortaAvioes = false;
                            break;
                        }
                    }
                    if (cabePortaAvioes) {
                        for (int j = 0; j < tamanhaPortaAvioes; j++) {
                            planoBatalha[linha + j][coluna] = tipoPortaAvioes;
                            posicionamentoNavios[linha + j][coluna] = celulaPosicionamento++;
                        }
                        qtdPortaAvioes--;
                    }
                }
            }
        }
    }

    private void jogando(Scanner sc, char[][] planoUsuario, char[][] planoBatalha, int[][] posicionamentoNavios) {
        // Variáveis para contagem de acertos, erros e tentativas do jogo
        int tentativas = 0;
        int acertos = 0;
        int erros = 0;
        int linhaJogada, colunaJogada;
        int naviosAfundados = 0;

        int portaAvioesAfundados = 0;
        int cruzadoresAfundados = 0;
        int destroyersAfundados = 0;
        int submarinosAfundados = 0;

        // Calcula o total de células de navios no tabuleiro
        int totalNavios = 0;
        for (int i = 0; i < planoBatalha.length; i++) {
            for (int j = 0; j < planoBatalha[i].length; j++) {
                if (planoBatalha[i][j] != '~') {
                    totalNavios++;
                }
            }
        }

        // Loop principal do jogo: continua até 30 tentativas ou afundar todos os navios
        do {
            System.out.println();
            System.out.print("Digite a linha que deseja atacar (1 - 8): ");
            linhaJogada = sc.nextInt();
            System.out.print("Digite a coluna que deseja atacar (1 - 8): ");
            colunaJogada = sc.nextInt();
            System.out.println();

            // Ajusta para índice do array
            linhaJogada--;
            colunaJogada--;

            // Valida coordenadas digitadas
            if (linhaJogada >= planoUsuario.length || linhaJogada < 0 ||
                    colunaJogada >= planoUsuario[0].length || colunaJogada < 0) {
                System.out.println("Escolha inválida! Tente novamente.");
                continue;

                // Verifica se já foi jogado na posição
            } else if (planoUsuario[linhaJogada][colunaJogada] == 'A'
                    || planoUsuario[linhaJogada][colunaJogada] == 'X') {
                System.out.println("Você já jogou aqui! Tentativa perdida.");
                tentativas++;

            } else if (planoBatalha[linhaJogada][colunaJogada] != '~') { // Acertou o tiro
                acertos++;
                tentativas++;
                planoUsuario[linhaJogada][colunaJogada] = 'A';

                // Verificação de afundamentos
                char tipo = planoBatalha[linhaJogada][colunaJogada];

                if (tipo == 'S') {
                    // Submarino ocupa 1 célula -> afunda imediatamente
                    submarinosAfundados++;
                    naviosAfundados++;
                    System.out.println("AFUNDOU! Você destruiu um navio");
                } else {
                    // Para D, C, P: chama método que retorna se o navio foi completamente afundado
                    boolean afundou = afundouNavio(tipo, planoUsuario, planoBatalha, linhaJogada, colunaJogada);

                    if (tipo == 'D') {
                        if (afundou) {
                            destroyersAfundados++;
                            naviosAfundados++;
                            System.out.println("AFUNDOU! Você destruiu um navio");
                        } else {
                            System.out.println("Acertou uma parte de um navio!");
                        }
                    } else if (tipo == 'C') {
                        if (afundou) {
                            cruzadoresAfundados++;
                            naviosAfundados++;
                            System.out.println("AFUNDOU! Você destruiu um navio");
                        } else {
                            System.out.println("Acertou uma parte de um navio!");
                        }
                    } else if (tipo == 'P') {
                        if (afundou) {
                            portaAvioesAfundados++;
                            naviosAfundados++;
                            System.out.println("AFUNDOU! Você destruiu um navio!");
                        } else {
                            System.out.println("Acertou uma parte de um navio!");
                        }
                    }
                }
            } else { // Errou o tiro
                System.out.println("Errou! Você atingiu a água :(");
                planoUsuario[linhaJogada][colunaJogada] = 'X';
                tentativas++;
                erros++;
            }

            double percentual = ((double) acertos / totalNavios) * 100;
            System.out.printf("Tentativa %d/30\t| Acertos: %d/%d\t| Taxa: %.2f%%%n",
                    tentativas, acertos, totalNavios, percentual);

            // Mostrar posição do erro
            mostrarPlanoUsuario(planoUsuario);
            System.out.println();

        } while (tentativas < 30 && acertos < totalNavios);

        // Após completar o while, retornar estatísticas finais
        System.out.println("========================================");
        System.out.println("           ESTATÍSTICAS FINAIS          ");
        System.out.println("========================================");

        // Definindo status do jogo
        String status;
        if (acertos == totalNavios) {
            status = "VITÓRIA!";
        } else {
            status = "DERROTA";
        }

        // Imprimindo informações do jogo ao usuário
        System.out.println("Status: " + status);
        System.out.println("Tentativas usadas: " + tentativas + "/30");
        System.out.println("Total de acertos: " + acertos);
        System.out.println("Total de erros: " + erros);

        // Definindo e mostrando a taxa de acerto total obtida durante o jogo
        double taxaAcerto = (acertos + erros) > 0 ? ((double) acertos / (acertos + erros)) * 100 : 0.0;
        System.out.printf("Taxa de acerto: %.2f%%\n", taxaAcerto);

        System.out.println("Navios afundados: " + naviosAfundados + "/10");
        System.out.println("- Porta-aviões: " + portaAvioesAfundados + "/1");
        System.out.println("- Cruzadores: " + cruzadoresAfundados + "/2");
        System.out.println("- Destroyers: " + destroyersAfundados + "/3");
        System.out.println("- Submarinos: " + submarinosAfundados + "/4");

        // Definindo pontos com base nos acertos e navios afundados
        int pontosAcertos = acertos * 10;
        int pontosNavios = naviosAfundados * 50;
        int penalidadeErros = erros * -2;

        // Definindo bônus do tempo de partida, com base nas tentativas utilizadas para
        // vencer o jogo
        int bonusRapida;
        if (tentativas <= 20 && status.equals("VITÓRIA!")) {
            bonusRapida = 100;
        } else {
            bonusRapida = 0;
        }

        // Calculando pontuação final com base nos resultados obtidos anteriormente
        int pontuacaoFinal = pontosAcertos + pontosNavios + penalidadeErros + bonusRapida;

        // Imprimindo pontuação final completa, demonstrando cada categoria
        System.out.println("PONTUAÇÃO FINAL: " + pontuacaoFinal + " pontos");
        System.out.println("- Acertos: " + pontosAcertos);
        System.out.println("- Navios afundados: " + pontosNavios);
        System.out.println("- Penalidade erros: " + penalidadeErros);
        System.out.println("- Bônus vitória rápida: " + bonusRapida);

        // Definindo classificação com base na pontação final
        String classificacao;
        if (pontuacaoFinal > 400)
            classificacao = "EXCELENTE!";
        else if (pontuacaoFinal >= 300)
            classificacao = "BOM";
        else if (pontuacaoFinal >= 200)
            classificacao = "REGULAR";
        else
            classificacao = "PRECISA MELHORAR";

        System.out.println("Classificação: " + classificacao);
        System.out.println("========================================");

        System.out.print("Deseja ver o tabuleiro de batalha completo? (S/N): ");
        char verTabuleiro = sc.next().toUpperCase().charAt(0);
        if (verTabuleiro == 'S') {
            System.out.println("\n**TABULEIRO DE BATALHA COMPLETO**");
            System.out.print("  ");
            for (int c = 1; c < planoBatalha.length + 1; c++) {
                System.out.print(c + " ");
            }
            System.out.println();
            for (int i = 0; i < planoBatalha.length; i++) {
                System.out.print((i + 1) + " ");
                for (int j = 0; j < planoBatalha[i].length; j++) {
                    System.out.print(planoBatalha[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    private boolean afundouNavio(char tipo, char[][] planoUsuario, char[][] planoBatalha, int linhaJogada,
            int colunaJogada) {

        if (tipo == 'D') {
            // Verifica se a célula à esquerda existe, é do tipo Destroyer e já foi atingida
            if (colunaJogada > 0 && planoBatalha[linhaJogada][colunaJogada - 1] == 'D'
                    && planoUsuario[linhaJogada][colunaJogada - 1] == 'A') {
                return true;
            }
            // Verifica se a célula à direita existe, é do tipo Destroyer e já foi atingida
            if (colunaJogada < 7 && planoBatalha[linhaJogada][colunaJogada + 1] == 'D'
                    && planoUsuario[linhaJogada][colunaJogada + 1] == 'A') {
                return true;
            }
            // Verifica se a célula acima existe, é do tipo Destroyer e já foi atingida
            if (linhaJogada > 0 && planoBatalha[linhaJogada - 1][colunaJogada] == 'D'
                    && planoUsuario[linhaJogada - 1][colunaJogada] == 'A') {
                return true;
            }
            // Verifica se a célula abaixo existe, é do tipo Destroyer e já foi atingida
            if (linhaJogada < 7 && planoBatalha[linhaJogada + 1][colunaJogada] == 'D'
                    && planoUsuario[linhaJogada + 1][colunaJogada] == 'A') {
                return true; // Destroyer afundou
            }
            return false; // Se nenhuma das células vizinhas foi atingida, ainda não afundou
        }

        if (tipo == 'C') {
            boolean afundou = false;

            // Caso horizontal - ataque no meio do navio: [C][A][C]
            if (colunaJogada > 0 && colunaJogada < 7
                    && planoBatalha[linhaJogada][colunaJogada - 1] == 'C'
                    && planoUsuario[linhaJogada][colunaJogada - 1] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada + 1] == 'C'
                    && planoUsuario[linhaJogada][colunaJogada + 1] == 'A') {
                afundou = true;
            }

            // horizontal - início [A][C][C]
            if (!afundou && colunaJogada < 6
                    && planoBatalha[linhaJogada][colunaJogada + 1] == 'C'
                    && planoUsuario[linhaJogada][colunaJogada + 1] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada + 2] == 'C'
                    && planoUsuario[linhaJogada][colunaJogada + 2] == 'A') {
                afundou = true;
            }

            // horizontal - fim [C][C][A]
            if (!afundou && colunaJogada > 1
                    && planoBatalha[linhaJogada][colunaJogada - 1] == 'C'
                    && planoUsuario[linhaJogada][colunaJogada - 1] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada - 2] == 'C'
                    && planoUsuario[linhaJogada][colunaJogada - 2] == 'A') {
                afundou = true;
            }

            // // Caso vertical - ataque no meio do navio
            if (!afundou && linhaJogada > 0 && linhaJogada < 7
                    && planoBatalha[linhaJogada - 1][colunaJogada] == 'C'
                    && planoUsuario[linhaJogada - 1][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada + 1][colunaJogada] == 'C'
                    && planoUsuario[linhaJogada + 1][colunaJogada] == 'A') {
                afundou = true;
            }

            // Caso vertical - ataque na primeira célula do navio
            if (!afundou && linhaJogada < 6
                    && planoBatalha[linhaJogada + 1][colunaJogada] == 'C'
                    && planoUsuario[linhaJogada + 1][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada + 2][colunaJogada] == 'C'
                    && planoUsuario[linhaJogada + 2][colunaJogada] == 'A') {
                afundou = true;
            }

            // Caso vertical - ataque na última célula do navio
            if (!afundou && linhaJogada > 1
                    && planoBatalha[linhaJogada - 1][colunaJogada] == 'C'
                    && planoUsuario[linhaJogada - 1][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada - 2][colunaJogada] == 'C'
                    && planoUsuario[linhaJogada - 2][colunaJogada] == 'A') {
                afundou = true;
            }

            return afundou; // Retorna true se todas as células do cruzador foram atingidas
        }

        if (tipo == 'P') {
            boolean afundou = false;

            // Horizontal - ataque na primeira célula do navio: [A][P][P][P]
            if (colunaJogada <= 4
                    && planoBatalha[linhaJogada][colunaJogada + 1] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada + 1] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada + 2] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada + 2] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada + 3] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada + 3] == 'A') {
                afundou = true;
            }

            // Horizontal - ataque na segunda célula do navio: [P][A][P][P]
            if (!afundou && colunaJogada >= 1 && colunaJogada <= 5
                    && planoBatalha[linhaJogada][colunaJogada - 1] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada - 1] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada + 1] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada + 1] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada + 2] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada + 2] == 'A') {
                afundou = true;
            }

            // Horizontal - ataque na terceira célula do navio: [P][P][A][P]
            if (!afundou && colunaJogada >= 2 && colunaJogada <= 6
                    && planoBatalha[linhaJogada][colunaJogada - 2] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada - 2] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada - 1] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada - 1] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada + 1] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada + 1] == 'A') {
                afundou = true;
            }

            // Horizontal - ataque na quarta célula do navio: [P][P][P][A]
            if (!afundou && colunaJogada >= 3
                    && planoBatalha[linhaJogada][colunaJogada - 3] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada - 3] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada - 2] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada - 2] == 'A'
                    && planoBatalha[linhaJogada][colunaJogada - 1] == 'P'
                    && planoUsuario[linhaJogada][colunaJogada - 1] == 'A') {
                afundou = true;
            }

            // Vertical - ataque na primeira célula do navio
            if (!afundou && linhaJogada <= 4
                    && planoBatalha[linhaJogada + 1][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada + 1][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada + 2][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada + 2][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada + 3][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada + 3][colunaJogada] == 'A') {
                afundou = true;
            }

            // Vertical - ataque na segunda célula
            if (!afundou && linhaJogada >= 1 && linhaJogada <= 5
                    && planoBatalha[linhaJogada - 1][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada - 1][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada + 1][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada + 1][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada + 2][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada + 2][colunaJogada] == 'A') {
                afundou = true;
            }

            // Vertical - ataque na terceira célula
            if (!afundou && linhaJogada >= 2 && linhaJogada <= 6
                    && planoBatalha[linhaJogada - 2][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada - 2][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada - 1][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada - 1][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada + 1][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada + 1][colunaJogada] == 'A') {
                afundou = true;
            }

            // Vertical - ataque na quarta célula
            if (!afundou && linhaJogada >= 3
                    && planoBatalha[linhaJogada - 3][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada - 3][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada - 2][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada - 2][colunaJogada] == 'A'
                    && planoBatalha[linhaJogada - 1][colunaJogada] == 'P'
                    && planoUsuario[linhaJogada - 1][colunaJogada] == 'A') {
                afundou = true; // Retorna true se todas as partes do porta-aviões estiverem atingidas
            }

            return afundou; // Se não cumpriu nenhuma das condições, retorna false
        }

        return false;
    }

    private void mostrarPlanoUsuario(char[][] planoUsuario) {
        // Método que exibe o tabuleiro visível ao usuário
        System.out.println("\n**CAMPO DE BATALHA**");
        System.out.print("  ");
        for (int c = 1; c < planoUsuario.length + 1; c++) {
            System.out.print(c + " ");
        }
        System.out.println();
        for (int i = 0; i < planoUsuario.length; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < planoUsuario[i].length; j++) {
                System.out.print(planoUsuario[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new ProjetoFinal();
    }
}
