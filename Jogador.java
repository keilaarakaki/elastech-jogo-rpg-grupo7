package JogoRPG;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;


public class Jogador {
    private String nome;
    private int flag_tipo_jogador; //1-Guerreiro 2-Mago 3-Inimigo
    private int porcentagem_vida;
    private int poder_ataque;
    private String avatar;

    // Array de armas
    String[] armaGuerreira = {"🗡️", "🏹", "🔨", "⚔️"};
    String[] armaMaga = {"🧪", "💊", "🍷", "🌿"};
    String[] armaInimiga = {"🗡️", "🏹", "🔨", "⚔️", "🧪", "💊", "🍷", "🌿"}; // pode usar qualquer arma do jogo - tanto de Guerreiro quanto de Mago

    // Array de avatares
    String[] avatarGuerreira = {"🦸‍","👩‍🚀","👩‍🎤","👩"};
    String[] avatarMaga = {"🧙‍♀️","🧝‍♀️","👩‍🔬","🧚‍♀️"};
    String[] avatarInimiga = {"👹","👿","🐉","🧟‍♀️","🕷️"};
    Random random = new Random();
    public Jogador(){ // o nome e flag_tipo_jogador serão setados conforme opção digitada pelo usuário, não serão iniciados no construtor
        this.porcentagem_vida = 100; // sempre inicia o jogo com 100% de vida
        this.poder_ataque = 0; // será randômico NEM PRECISA TER COMO ATRIBUTO, CADA ATAQUE TEM UM PODER
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getFlag_tipo_jogador() {
        return flag_tipo_jogador;
    }

    public void setFlag_tipo_jogador(int flag_tipo_jogador) {
        this.flag_tipo_jogador = flag_tipo_jogador;
    }

    public int getPorcentagem_vida() {
        return porcentagem_vida;
    }

    public void setPorcentagem_vida(int porcentagem_vida) {
        this.porcentagem_vida = porcentagem_vida;
    }

    public int getPoder_ataque() {
        return poder_ataque;
    }

    public void setPoder_ataque(int poder_ataque) {
        this.poder_ataque = poder_ataque;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int poderAtaque(){
        return (random.nextInt(11));
    }
    public String avatar(){
        if (flag_tipo_jogador == 1) {
            return("\uD83E\uDDB8\u200D♀\uFE0F"); // GUERREIRA
        }else {
            return("\uD83E\uDDD9\u200D♂\uFE0F"); // Mago
        }
    }

    public String avatarInimiga() {
        return (avatarInimiga[random.nextInt(avatarInimiga.length)]);
    }

    public String avatarGuerreira(){
        return (avatarGuerreira[random.nextInt(avatarGuerreira.length)]);
    }

    public String avatarMaga(){
        return (avatarMaga[random.nextInt(avatarMaga.length)]);
    }
    public String ataque(){
        if (flag_tipo_jogador == 1){
            return (armaGuerreira[random.nextInt(armaGuerreira.length)]);
        }else{
            return (armaMaga[random.nextInt(armaMaga.length)]);
        }
    }
}
