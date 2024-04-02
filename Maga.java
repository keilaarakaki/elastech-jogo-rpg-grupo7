package JogoRPG;

import java.util.Scanner;

public class Maga extends Jogador{
    Scanner entrada = new Scanner(System.in);
    // Construtor
    public Maga (String nome){
        super(nome);
    }

    // Array de armas
    String[] arma = {"🧪", "💊", "🍷", "🌿", "✨", "🔥", "️💫"};

    // Array de avatares
    String[] avatar = {"🧙‍♀️","🧝‍♀️","👩‍🔬","🧚‍♀️"};

    public void mostrarArsenal() {
        super.mostrarArsenal(arma, "Seus artefatos: ");
    }

    public void avatar(){
        setAvatar(super.avatar(avatar));
    }

    public String armaAtaque(){
        return super.armaAtaque(arma);
    }
}
