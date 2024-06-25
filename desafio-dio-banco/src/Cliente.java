import java.util.Random;

public class Cliente {
    private int id;
    private String nome;

    public Cliente(String nome){
        this.id =new Random().nextInt();
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
