import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        int selecionador;
        List<Conta> contaList = new ArrayList<>();
        Cliente cliente = null;

        do {
            System.out.println("******************TELA INICIAL******************");
            System.out.println("1-Cadastrar Cliente;");
            System.out.println("2-Acessar Conta;");
            System.out.println("3-Sair.");

            System.out.println("\nDigite uma opção:");
            selecionador = scan.nextInt();

            switch (selecionador) {
                case 1:
                    System.out.println("\n\n\n\n\n\n");
                    String nome;

                    scan.nextLine();
                    System.out.println("Digite o nome completo:");
                    nome = scan.nextLine();

                    System.out.println("Digite a senha:");
                    int senha = scan.nextInt();

                    cliente = new Cliente(nome);
                    System.out.println("\n\nDeseja criar uma conta corrente(1) ou uma conta poupança (2):");
                    int i = scan.nextInt();
                    if (i == 1) {
                        Conta cc = new ContaCorrente(cliente,senha);
                        contaList.add(cc);
                        System.out.println("Conta Corrente criada com sucesso!");
                        cc.imprimirExtrato();
                    } else if (i == 2) {
                        Conta cp = new ContaPoupanca(cliente,senha);
                        contaList.add(cp);
                        System.out.println("Conta Poupança criada com sucesso!");
                        cp.imprimirExtrato();
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    if (contaList.isEmpty()) {
                        System.out.println("Nenhuma conta cadastrada!");
                        break;
                    }

                    int select;
                    System.out.println("\n\n\n\n\n\n");
                    System.out.println("******************MENU******************");
                    System.out.println("\n1-Conta Corrente;");
                    System.out.println("2-Conta Poupança;");
                    System.out.println("3-Sair.");
                    select = scan.nextInt();
                    if (select == 3) break;

                    Conta contaSelecionada = null;
                    System.out.println("Digite o número da conta:");
                    int numeroConta = scan.nextInt();

                    System.out.println("Digite o digito da conta");
                    int numeroDigito = scan.nextInt();

                    System.out.println("Digite a senha:");
                    int senhaConta = scan.nextInt();

                    for (Conta conta : contaList) {
                        if (conta.getConta() == numeroConta &&conta.getDigito() == numeroDigito) {
                            if(conta.getSenha()==senhaConta) {
                                contaSelecionada = conta;
                                break;
                            }


                        }
                    }

                    if (contaSelecionada == null) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }

                    int k;
                    do {
                        double d;
                        System.out.println((select == 1 ? "Conta Corrente:" : "Conta Poupança:"));
                        System.out.println("\n1-Sacar;");
                        System.out.println("2-Depositar;");
                        System.out.println("3-Transferir;");
                        System.out.println("4-Imprimir Dados da Conta;");
                        System.out.println("5-Sair;");
                        k = scan.nextInt();

                        switch (k) {
                            case 1:
                                System.out.println("\nDigite valor a ser sacado:");
                                d = scan.nextDouble();
                                contaSelecionada.sacar(d);
                                break;

                            case 2:
                                System.out.println("\nDigite valor a ser depositado:");
                                d = scan.nextDouble();
                                contaSelecionada.depositar(d);
                                break;

                            case 3:
                                System.out.println("\nDigite a conta e o valor a ser transferido:");
                                System.out.println("Número da conta destino:");
                                numeroConta = scan.nextInt();

                                System.out.println("Digito da conta:");
                                numeroDigito = scan.nextInt();
                                Conta contaDestino = null;
                                for (Conta conta : contaList) {
                                    if (conta.getConta() == numeroConta && conta.getDigito()==numeroDigito) {
                                        contaDestino = conta;
                                        break;
                                    }
                                }

                                if (contaDestino == null) {
                                    System.out.println("Conta destino não encontrada!");
                                    break;
                                }

                                System.out.println("Valor:");
                                d = scan.nextDouble();
                                contaSelecionada.transferir(d, contaDestino);
                                break;

                            case 4:
                                contaSelecionada.imprimirExtrato();
                                break;

                            case 5:
                                System.out.println("Saindo!!!");
                                break;

                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                    } while (k != 5);
                    break;

                case 3:
                    System.out.println("Saindo da Conta!!!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (selecionador != 3);
    }
}
