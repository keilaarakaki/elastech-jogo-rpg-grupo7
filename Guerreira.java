package JogoRPG;

import java.util.Scanner;

public class Guerreira extends Jogador{
    Scanner entrada = new Scanner(System.in);
    //Construtor
    public Guerreira (String nome){
        super(nome);
    }

    // Array de armas
    String[] arma = {"🗡️", "🏹", "🔨", "⚔️","🔱","🪓","⚒️","🛡️"};

    // Array de avatares
    String[] avatar = {"🦸‍","👩‍🚀","👩‍🎤","👩"};

    public void mostrarArsenal() {
        super.mostrarArsenal(arma, "Seu arsenal: ");
    }
    public void avatar(){
        setAvatar(super.avatar(avatar));
    }

    public String armaAtaque(){
        return super.armaAtaque(arma);
    }


}
