import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public static void main(String[] args) {

        Banco banco = new Banco("Santander");
        Cliente joao = new Cliente("João");
        Conta contaCorrente = new ContaCorrente(joao, 1234);
        Conta contaPoupanca = new ContaPoupanca(joao, 5678);
        banco.adicionarConta(contaPoupanca);
        banco.adicionarConta(contaCorrente);

        for(Conta c:banco.getContas()){
            System.out.println(c);
        }
    }
}
