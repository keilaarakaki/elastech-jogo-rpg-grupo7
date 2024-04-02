package JogoRPG;

public class Inimigo extends Jogador {
    public Inimigo(){
        super();
    }

    // Array nomes Inimigo
    String [] nome = {"Rafael","Icoma","Java","Thanos"};

    // Array de armas
    // pode usar qualquer arma do jogo - tanto de Guerreira quanto de Maga
    String[] arma = {"🗡️", "🏹", "🔨", "⚔️","🔱","🪓","⚒️","🛡️","🧪", "💊", "🍷", "🌿","✨", "🔥", "️💫"};

    // Array de avatares
    String[] avatar = {"👹","👿","🐉","🧟‍♀️","🦹‍♂️"};


    public String avatar() {
        return (avatar[random.nextInt(avatar.length)]);
    }

    public void mostrarArsenal(){
        super.mostrarArsenal(arma, "\n\n Inimigo: " + getNome() + getAvatar() + "\n Arsenal inimigo: ");
    }

    public String nome(){
        return(nome[random.nextInt(nome.length)]);
    }

    public String armaAtaque(){
        return super.armaAtaque(arma);
    }

    public void mostraInimigos(){
        for (String nome : nome) {
            System.out.print(nome + " ");
        }
    }

}
