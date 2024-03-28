package JogoRPG;

import java.util.Scanner;

public class Jogo {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        // DEFINIÇÃO DA JOGADORA
        Jogador jogador = new Jogador();
        System.out.println("Entre com o nome da sua personagem: ");
        jogador.setNome(entrada.nextLine());
        System.out.println("Digite 1 para jogar como Guerreira e 2 para jogar como Maga");
        // testar opções ****************************************************************
        jogador.setFlag_tipo_jogador(entrada.nextInt());
        if (jogador.getFlag_tipo_jogador() == 1) {
            // IMPLEMENTAR ESCOLHA DO AVATAR AQUI
            jogador.setAvatar(jogador.avatarGuerreira());
        }else{
            jogador.setAvatar(jogador.avatarMaga());
        }


        // DEFINIÇÃO DO INIMIGO
        Jogador inimigo = new Jogador();
        inimigo.setNome("Lúcifer");
        inimigo.setFlag_tipo_jogador(3); // Padrão do jogo 3 é inimigo
        inimigo.setAvatar(inimigo.avatarInimiga());

        // INÍCIO
        System.out.println(jogador.getPorcentagem_vida() + "% " +  jogador.getNome() + " " + jogador.getAvatar() + "                         VERSUS                         " + inimigo.getPorcentagem_vida() + "% " + inimigo.getNome() + " " + inimigo.getAvatar());

        // LUTA

        System.out.println(jogador.getPorcentagem_vida() + "% " +  jogador.getAvatar() + " " + jogador.ataque() + " Poder deste ataque: " + jogador.poderAtaque() +
                  "                                   "  + inimigo.getPorcentagem_vida() + "% " + inimigo.getAvatar() + " " + inimigo.ataque() + " Poder deste ataque: " + inimigo.poderAtaque());
    }
}
