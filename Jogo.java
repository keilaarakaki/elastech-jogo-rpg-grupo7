package JogoRPG;

import java.util.Scanner;

public class Jogo {
    Inimigo inimigo = new Inimigo(); // instanciando o objeto inimigo a partir da subclasse Inimigo

    private Jogador personagem; // Adicionando personagem como um atributo da classe Jogo - a classe inteira o enxergará

    Scanner entrada = new Scanner(System.in);
    int ataque;
    int opcao;
    String [] cenario = {"🏰 1- Castelo do Caos Encantado", "🏞️ 2- Vale dos Bugs Bizarros", "🏕️ 3- Montanha da Mente Mística", "🏝️ 4- Ilha da Imaginação Inexplorada", "🏫 5- Academia ElasTech", "🌄 6- Floresta da Orientação a Objetos"};
    public void contagemRegressiva(int qtd, boolean exibeNumero) {
        try {
            // Contagem regressiva de 3 até 1
            for (int i = qtd; i >= 1; i--) {
                if (exibeNumero){
                    System.out.print(i + "    ");
                }else{
                    System.out.print(".    ");
                }
                // Pausa de 1 segundo entre cada contagem
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("A contagem regressiva foi interrompida.");
        }
    }

    public void tempo(int qtd) {
        try {
            Thread.sleep(qtd);
        } catch (InterruptedException e) {
            System.out.println("Erro na passagem de tempo.");
        }
    }

    public void letraVermelha(){
        System.out.print("\u001B[31m");
    }

    public void letraVerde(){
        System.out.print("\u001B[32m");
    }

    public void letraPadrao(){
        System.out.print("\u001B[0m");
    }

    public void letraAmarela(){
        System.out.print("\u001B[33m");
    }

    public void letraAzul(){
        System.out.printf("\u001B[34m");
    }

    public void letraMagenta(){
        System.out.printf("\u001B[35m");
    }

    public void letraCiano(){
        System.out.printf("\u001B[36m");
    }

    public void letraBranca(){
        System.out.printf("\u001B[37m");
    }

    public void fundoVermelho(){
        System.out.printf("\u001B[41m");
    }

    public void fundoVerde(){
        System.out.printf("\u001B[42m");
    }

    public void fundoAmarelo(){
        System.out.printf("\u001B[43m");
    }

    public void fundoAzul(){
        System.out.printf("\u001B[44m");
    }

    public void fundoMagenta(){
        System.out.printf("\u001B[45m");
    }

    public void fundoCiano(){
        System.out.printf("\u001B[46m");
    }

    public void fundoBranco(){
        System.out.printf("\u001B[47m");
    }

    public void fundoPadrao(){
        System.out.printf("\u001B[49m");
    }
    public void exibeCaracteres(String[] texto){
        for (int i = 0; i < texto.length; i++) { // neste caso, esse for passará apenas uma vez, pois o array só tem 1 string - o array só tem 1 posição
            for (int j = 0; j < texto[i].length(); j++) { //o i sempre será 1, pois o array só tem 1 posição
                System.out.print(texto[i].charAt(j)); //charAt é um método que pega um caracter de uma determinada possição de uma String
                tempo(100);
            }
        }
    }

    public void titulo(){
        fundoAmarelo();
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");

        fundoPadrao();
        String [] jogo = {"CodeCaos: A Jornada ElasTech pelo Reino de Java"};
        letraVermelha();
        exibeCaracteres(jogo);

        String [] versao = {" - Release 6.66"};
        letraVerde();
        exibeCaracteres(versao);

        letraPadrao();
    }
    public void historia() {
        System.out.println("\n\nO Reino de Java está em perigo. Numa academia de magia, o Professor Mal, um bruxo das trevas,  planeja subjugar o reino para seus propósitos malignos.");
        tempo(2700);
        System.out.println("\n \nPor isso, sua missão como jogador é derrotar o Professor Mal e restaurar a paz e a ordem em Java.");
        tempo(2700);
        System.out.println("\n \nDotado de coragem, habilidades únicas e com trabalho em equipe, você irá enfrentar desafios perigosos até confrontar o vilão. Com determinação e ajuda de seus");
        tempo(2700);
        System.out.println("\n\ncompanheiros o Professor Mal será derrotado e você tornar-se-á um herói celebrado e servirá de inspiração para outros que desejam defender o bem contra o mal.");
        tempo(3000);
    }

    public void msgInicial(){
        letraVermelha();
        System.out.printf("\n\nP r e p a r e - s e !\n\n");
        letraVerde();
        System.out.printf("O jogo iniciará em 3 segundos...\n\n");
        tempo(500);
        letraPadrao();
    }

    public void cenario(){
        int escolha;
        letraVerde();
        System.out.println("\n\n\nVamos configurar seu jogo");
        letraPadrao();
        do{
            System.out.print("\n\nCenários disponíveis: \n");
            for (String cenario : cenario) {
                System.out.println(cenario);
            }
            System.out.println("Escolha o cenário desejado entre 1 e " + cenario.length + ": ");
            while (!entrada.hasNextInt()) {  // ROTINA USADA CASO O USUÁRIO DIGITE ALGO DIFERENTE DE UM NÚMERO
                System.out.println("Opção inválida! Digite um número correspondente à opção desejada.");
                System.out.print("Escolha uma opção: ");
                entrada.next(); // Limpar o buffer do scanner pra não ficar em loop
            }
            escolha = entrada.nextInt();
            if (escolha > 0 && escolha <= cenario.length){
                System.out.println("Bem-vinda a " + cenario[escolha-1]);
            } else {
                // Caso contrário, informar ao usuário que o número é inválido
                System.out.println("Número inválido. O número deve estar entre 1 e " + cenario.length + ".");
            }
        }while(escolha < 1 || escolha > cenario.length);
    }

    public void criarInimigo(){
        letraAzul();
        System.out.println("\n\n\nAguarde enquanto sorteamos seu oponente");
        letraVermelha();
        contagemRegressiva(5,false);
        letraPadrao();

        inimigo.setNome(inimigo.nome()); // p/ setar o nome, chamamos o método nome que retorna um nome randomicamente
        inimigo.setAvatar(inimigo.avatar());// chamamos o método avatar para randomicamente setarmos o avatar do inimigo
        inimigo.setNivel(0);
        inimigo.setPorcentagem_vida(100); // setado pois se jogar novamente precisa ter 100% de vida
        inimigo.mostrarArsenal();
    }

    public Jogador criarPersonagem() {
        int tipoPersonagem;
        do {
            System.out.println("\n\nDigite 1 para jogar como Guerreira ou 2 para jogar como Maga: ");
            while (!entrada.hasNextInt()) {  // ROTINA USADA CASO O USUÁRIO DIGITE ALGO DIFERENTE DE UM NÚMERO
                System.out.println("Opção inválida! Digite um número correspondente à opção desejada.");
                System.out.print("Escolha uma opção: ");
                entrada.next(); // Limpar o buffer do scanner pra não ficar em loop
            }
            tipoPersonagem = entrada.nextInt();
            if (tipoPersonagem != 1 && tipoPersonagem != 2) {
                System.out.println("Opção inválida!");
            }
        } while (tipoPersonagem != 1 && tipoPersonagem != 2);

        entrada.nextLine(); //Consumir linha após o nextInt usado anteriormente
        System.out.println("\n\nEntre com o nome da sua personagem: ");
        String nome = entrada.nextLine();

        Jogador personagem; // variável personagem do tipo Jogador
        if (tipoPersonagem == 1) { //guerreira
            Guerreira guerreira = new Guerreira(nome);
            guerreira.avatar(); //método para escolha do avatar
            guerreira.mostrarArsenal();
            personagem = guerreira;
            // está atribuindo 1 instância da classe Guerreira p/ variável personagem - é uma instância da subclasse guerreira
            // assim conseguimos acessar diretamente os métodos e atributos da classe Guerreira através da variável personagem
            // tb inclui métodos e atributos herdados da classe pai jogador

        } else {//maga
            Maga maga = new Maga(nome);
            maga.avatar();
            maga.mostrarArsenal();
            personagem = maga;
            // está atribuindo 1 instância da classe Maga p/ variável personagem - é uma instância da subclasse Maga
            // assim conseguimos acessar diretamente os métodos e atributos da classe Maga através da variável personagem
            // tb inclui métodos e atributos herdados da classe pai jogador
        }
        return personagem;
    }

    public void iniciarLuta() {
        do {
            ataque = personagemAtaca(); //método onde a personagem irá atacar o inimigo
            if (inimigo.getPorcentagem_vida() <= 0) { // se inimigo perdeu
                break;
            }
            ataqueInimigo(); //método onde o inimigo ataca a personagem
            if (personagem.getPorcentagem_vida() != 0 ){ // se personagem possuir % de vida
                System.out.println(personagem.getPorcentagem_vida() + "% " + personagem.getAvatar());
                tempo(1000);
            }
        } while (personagem.getPorcentagem_vida() > 0 && inimigo.getPorcentagem_vida() > 0);
    }

    private int personagemAtaca() { //método onde a personagem ataca o inimigo
        ataque = personagem.poderAtaque(); // busca valor do ataque
        String arma;
        if (personagem instanceof Guerreira) { // se personagem foi intanciada a partir da classe Guerreira
            arma = selecionaArma(((Guerreira) personagem).arma);
        } else { // no caso de personagem instanceof Maga - ter sido instanciado a partir da classe Maga
            arma = selecionaArma(((Maga) personagem).arma);
        }

        // ESTE CÓDIGO COMENTADO É PARA SELEÇÃO RANDÔMICA DA ARMA DE ATAQUE
        /*if (personagem instanceof Guerreira) {
            arma = ((Guerreira) personagem).armaAtaque();
        } else { // no caso de personagem instanceof Maga - ter sido instanciado a partir da classe Maga
            arma = ((Maga) personagem).armaAtaque();
        }*/

        System.out.println("\n" + personagem.getPorcentagem_vida() + "% " + personagem.getAvatar() + " " + arma + " Poder deste ataque: " + ataque);
        tempo(1000);
        if (inimigo.getPorcentagem_vida() >= ataque) { //verifica se com o ataque o inimigo continuará vivo
            inimigo.setPorcentagem_vida(inimigo.getPorcentagem_vida() - ataque);
        } else { //inimigo perdeu
            inimigo.setPorcentagem_vida(0); // zero pra não ficar com % de vida negativa, caso o valor do ataque seja maior que a % de vida
            System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t" + inimigo.getPorcentagem_vida() + "% " + inimigo.getAvatar() + " - já era");
            tempo(1000);
        }
        return ataque;
    }

    public String selecionaArma(String[] arsenal){
        int escolha;
        letraVerde();
        do {
            System.out.print("\nArmamento/artefato disponível: ");
            for (int i = 0; i < arsenal.length; i++) {
                System.out.print((i + 1) + "." + arsenal[i] + "  ");
            }
            System.out.print("\nEscolha um item digitando o número correspondente: ");
            while (!entrada.hasNextInt()) {  // ROTINA USADA CASO O USUÁRIO DIGITE ALGO DIFERENTE DE UM NÚMERO
                System.out.println("Opção inválida! Digite um número correspondente à opção desejada.");
                System.out.print("Escolha uma opção: ");
                entrada.next(); // Limpar o buffer do scanner pra não ficar em loop
            }
            escolha = entrada.nextInt();
            if (escolha < 1 || escolha > arsenal.length) {
                System.out.println("Opção inválida! Escolha um número entre 1 e " + arsenal.length + ".");
            }
        } while (escolha < 1 || escolha > arsenal.length);
        letraPadrao();
        return arsenal[escolha - 1];
    }

    private void ataqueInimigo() {
        ataque = inimigo.poderAtaque(); // busca valor do ataque
        System.out.println("\t \t \t \t \t \t \t \t \t \t \t \t \t" + inimigo.getPorcentagem_vida() + "% " + inimigo.getAvatar() + " " + inimigo.armaAtaque() + " Poder deste ataque: " + ataque);
        tempo(1000);
        if (personagem.getPorcentagem_vida() >= ataque) { //verifica se com o ataque a personagem continuará viva
            personagem.setPorcentagem_vida(personagem.getPorcentagem_vida() - ataque);
        } else { // personagem perdeu
            personagem.setPorcentagem_vida(0); // foi zerado pra não ficar com % de vida negativa, caso o valor do ataque seja maior que a % de vida
            System.out.println(personagem.getPorcentagem_vida() + "% " + personagem.getAvatar() + " - já era");
            tempo(1000);
        }
    }

    public void avaliarResultado() {
        if (personagem.getPorcentagem_vida() != 0) { //se personagem saiu vivo da batalha - ganhou
            personagem.aumentarNivel();
            System.out.println("\nVocê venceu! " + personagem.emojiFimDeJogo(1) + " seu nível aumentou para " + personagem.getNivel() + "\t \t \t" + inimigo.getNome() + " perdeu! " + inimigo.emojiFimDeJogo(2));
        } else { // inimigo ganhou a batalha
            inimigo.aumentarNivel();
            System.out.println("\nVocê foi derrotada! " + personagem.emojiFimDeJogo(2) + " seu nível atual é " + personagem.getNivel() + "\t \t \t " + inimigo.getNome() + " venceu! " + inimigo.emojiFimDeJogo(1));
        }
    }

    public int menu(){
        do{
            letraCiano();
            System.out.println("\n");
            System.out.println("------------------------------");
            System.out.println("| * *** **** MENU **** *** * |");
            System.out.println("|----------------------------|");
            System.out.println("| 1. Jogar                   |");
            System.out.println("| 2. Instruções              |");
            System.out.println("| 3. Estatística             |");
            System.out.println("| 4. Sair                    |");
            System.out.println("|____________________________|");
            while (!entrada.hasNextInt()) {  // ROTINA USADA CASO O USUÁRIO DIGITE ALGO DIFERENTE DE UM NÚMERO
                System.out.println("Opção inválida! Digite um número correspondente à opção desejada.");
                System.out.print("Escolha uma opção: ");
                entrada.next(); // Limpar o buffer do scanner pra não ficar em loop
            }
            opcao = entrada.nextInt();
            if (opcao < 1 || opcao > 4){
                System.out.println("Opção inválida!");
            }
        }while (opcao < 1 || opcao > 4);
        return opcao;
    }

    public void instrucoes(){
        System.out.println("\n\nSeu objetivo é derrotar o inmigo, que é escolhido aleatoriamente pelo sitema entre os seguintes vilões: ");
        // tive que exibir de forma fixa os inimigos ao invés de usar o método inimigo.mostraInimigos pois a classe ainda não foi instanciada - o jogo ainda não foi iniciado
        String [] inimigos = {"Rafael, Icoma, Java ou Thanos"};
        letraVermelha();
        exibeCaracteres(inimigos);
        letraPadrao();
        System.out.println("\nVocê também precisará contar com a sorte.");
        System.out.println("Está preparada? Que comecem os jogos!!!");
        tempo(1500);
    }

    public void iniciarJogo() {
        opcao = 0;
        int rounds = 0;
        double porcent_vitorias = 0;
        titulo();
        historia();

        while (opcao != 4) {
            menu();
            switch (opcao) {
                case 1: // Jogar
                    cenario();
                    criarInimigo();
                    String dadosInimigo = inimigo.getPorcentagem_vida() + "% " + inimigo.getNome() + " " + inimigo.getAvatar();
                    tempo(1000);
                    boolean criarPersonagem = false;
                    String resposta;
                    if (rounds == 0) {
                        // na 1ª batalha sempre irá criar personagem
                        criarPersonagem = true;
                    }else{ // verificar se quer criar outro personagem ou continuar com o mesmo
                        do{
                            System.out.println("\n\nDeseja criar um novo personagem (S/N)?");//caso contrário, continuará a jogar com o anterior
                            resposta = entrada.next(); // não precisa ser next line, não será palavra composta
                            if (resposta.equalsIgnoreCase("s")) { //pode ser S ou s
                                criarPersonagem = true;
                            }else if (resposta.equalsIgnoreCase("n")) { // poder ser n ou N
                                criarPersonagem = false;
                            }else {
                                System.out.println("Resposta inválida. Digite 's' para sim ou 'n' para não.");
                            }
                        }while (!resposta.equalsIgnoreCase("s") && !resposta.equalsIgnoreCase("n"));
                            //pra ignorar se digitar em maiúscula ou minúscula fica no while enquanto resposta for diferente de S,s,N,n
                    }

                    if (criarPersonagem){
                        rounds = 0; // zera pois será o primeiro round dessa personagem que está sendo criada
                        personagem = criarPersonagem();
                    }
                    personagem.setPorcentagem_vida(100); //setei, pois se for usar mesmo personagem, tem que iniciar batalha com 100%
                    ++rounds;
                    msgInicial();
                    contagemRegressiva(3, true);
                    String dadosJogador = personagem.getPorcentagem_vida() + "% " + personagem.getNome() + " " + personagem.getAvatar();
                    System.out.println("\n\n \t \t" + dadosJogador + "\t \t \t \t   VERSUS \t \t" + dadosInimigo);

                    iniciarLuta();
                    avaliarResultado();
                    tempo(1500);
                    break;
                case 2: // Instruções
                    instrucoes();
                    tempo(1500);
                    break;
                case 3: //estatística
                    letraAzul();
                    if (rounds == 0) {
                        System.out.println("\nVocê não participou de nenhuma batalha!");
                    }else {
                        System.out.println("\nEstatística");
                        letraPadrao();
                        System.out.println(personagem.getAvatar() + " " + personagem.getNome() + " participou de " + rounds + " batalhas");
                        System.out.println("Número de vitórias: " + personagem.getNivel());
                        System.out.println("Número de derrotas: " + (rounds - personagem.getNivel()));
                        if (personagem.getNivel() != 0) {
                            porcent_vitorias = ((double) personagem.getNivel() / rounds) * 100;
                            System.out.println("Porcentagem de vitórias: " + porcent_vitorias + " %");
                        }
                    }
                    tempo(1500);
                    break;
                default: // mensagem final de saída
                    letraVerde();
                    System.out.println("\nObrigada por jogar CodeCaos.❤️ Sua jornada ElasTech pelo Reino de Java ainda não terminou!!! 😅😎");
                    tempo(1500);
                    break;
            }
        }
    }
}

