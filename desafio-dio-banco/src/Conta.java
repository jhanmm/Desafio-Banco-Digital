import java.util.Random;

public abstract class Conta implements IConta{

    protected int agencia;
    protected int conta;
    protected int digito;
    protected double saldo;
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    protected Cliente cliente;
    private int senha;


    public Conta(Cliente cliente,int senha){
        this.agencia = AGENCIA_PADRAO;
        this.conta = SEQUENCIAL++;
        this.cliente = cliente;
        this.digito = new Random().nextInt(0,9);
        this.senha = senha;
    }

    @Override
    public void sacar(double valor){
        if(saldo>=valor) {
            saldo -= valor;
        }else{
            System.out.println("Saldo insuficiente!");
        }

    }

    @Override
    public void depositar(double valor){
        saldo+=valor;

    }

    @Override
    public void transferir(double valor, Conta contaDestino){
        if(saldo>=valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
        }else{
            System.out.println("Saldo insuficiente!");
        }

    }

    public int getAgencia() {
        return agencia;
    }

    public int getConta() {
        return conta;
    }

    public int getDigito() {
        return digito;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getSenha() {
        return senha;
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Conta: %d", this.conta));
        System.out.println(String.format("Digito: %d", this.digito));
        System.out.println(String.format("Saldo: R$%.2f", this.saldo));
    }

    @Override
    public String toString() {
        return "Conta{" +
                "agencia=" + agencia +
                ", conta=" + conta +
                ", digito=" + digito +
                ", saldo=" + saldo +
                ", cliente=" + cliente +
                '}';
    }
}
