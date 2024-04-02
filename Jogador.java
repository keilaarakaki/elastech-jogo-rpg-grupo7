package JogoRPG;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Jogador {
    Scanner entrada = new Scanner(System.in);

    private String nome;
    private int nivel;
    private int porcentagem_vida;
   // private int poder_ataque; // implementar
    //private int poderDefesa; // valor do ataque - poder defesa e desc da % vida - implementar
    private String avatar;

    // Array de emojis pra Vencedor
    String [] emojiVencedor = {"🏆","👑","🎈","🥇","🎉","🥳"};

    // Array de emojis pra Perdedor
    String [] emojiPerdedor = {"💀","☠️","💔","⚰️","😢","😭","😔"};
    Random random = new Random();

    //aqui teremos sobrecarga de construtores, dependendo dos parâmetros, o Java definirá qual será chamado
    public Jogador(String nome){// nome jogador é digitado pelo usuário - esse construtor é usado p/ criar Guerreira e Maga
        this.nome = nome;
        this.nivel = 0; // sempre inicia o jogo com nível 0 - nível é o número de vitórias
        this.porcentagem_vida = 100; // sempre inicia o jogo com 100% de vida
        //this.poder_ataque = 0; // será randômico NEM PRECISA TER COMO ATRIBUTO, CADA ATAQUE TEM UM PODER
    }

    public Jogador(){ // contrutor usado para criar inimigo - o nome do inimigo é gerado randomicamente após a classe inimigo ser instanciada
        this.nivel = 0; // sempre inicia o jogo com nível 0
        this.porcentagem_vida = 100; // sempre inicia o jogo com 100% de vida
        //this.poder_ataque = 0; // será randômico NEM PRECISA TER COMO ATRIBUTO, CADA ATAQUE TEM UM PODER
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPorcentagem_vida() {
        return porcentagem_vida;
    }

    public void setPorcentagem_vida(int porcentagem_vida) {
        this.porcentagem_vida = porcentagem_vida;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int poderAtaque(){
        return (random.nextInt(21) + 10); // varia de 10 a 30
    }


    public String emojiFimDeJogo(int resultado){
        if (resultado == 1){ // Venceu o jogo
            return(emojiVencedor[random.nextInt(emojiVencedor.length)]);
        }else{ // perdeu o jogo
            return(emojiPerdedor[random.nextInt(emojiPerdedor.length)]);
        }
    }


    public void aumentarNivel() {// método para incrementar o nível - que aqui será o número de vitórias
        this.nivel++;
    }

    public void mostrarArsenal(String[] arsenal, String mensagem) { //arsenal e mensagem personalizada p/ cd tipo de
        System.out.print(mensagem);                                //jogador: guerreira, maga e inimigo
        for (String item : arsenal) {
            System.out.print(item + " ");
        }
    }

    public String avatar(String[] lstAvatar){ //retorna o avatar escolhido pra personagem
        int escolha, i;
        do{
            System.out.println("\nAvatares disponíveis: ");
            i = 1;
            for (String avatar : lstAvatar){
                System.out.println(i + "- " + avatar);
                i++;
            }
            System.out.println("Escolha seu avatar entre 1 e " + lstAvatar.length + ": ");
            while (!entrada.hasNextInt()) { //ROTINA USADA CASO O USUÁRIO DIGITE ALGO DIFERENTE DE UM NÚMERO
                System.out.println("Opção inválida! Digite um número correspondente à opção desejada.");
                System.out.print("Escolha uma opção: ");
                entrada.next(); // Limpar o buffer do scanner pra não ficar em loop
            }
            escolha = entrada.nextInt();
            if (escolha > 0 && escolha <= lstAvatar.length){
                System.out.println("O avatar escolhido foi: " + lstAvatar[escolha-1]);
                setAvatar(lstAvatar[escolha-1]);
            } else {
                // Caso contrário, informar ao usuário que o número é inválido
                System.out.println("Número inválido. O número deve estar entre 1 e " + lstAvatar.length + ".");
            }
        }while(escolha < 1 || escolha > lstAvatar.length);
        return lstAvatar[escolha-1]; // ou poderia retornar o índice da lista
    }
    public  void exibirRanking(List<Jogador> jogadores) { // ainda não implementado
        // o método comparator irá ordenar os jogadores pelo atributo nível em ordem decrescente
        jogadores.sort(Comparator.comparingInt(Jogador::getNivel).reversed());

        System.out.println("Ranking:");
        int posicao = 1;
        for (Jogador jogador : jogadores) {
            System.out.println(posicao + ". " + jogador.getNome() + " - Nível: " + jogador.getNivel());
            posicao++;
        }
    }

    public String armaAtaque(String[] arsenal){
        return(arsenal[random.nextInt(arsenal.length)]);
    }

}
