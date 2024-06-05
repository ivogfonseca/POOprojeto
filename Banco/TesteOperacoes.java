import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TesteOperacoes {
    private List<Cliente> listaClientes;
    private List<Conta> listaContas;
    
    public TesteOperacoes(List<Cliente> listaClientes, List<Conta> listaContas) {
        this.listaClientes = listaClientes;
        this.listaContas = listaContas;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Conta> getListaContas() {
        return listaContas;
    }

    public void setListaContas(List<Conta> listaContas) {
        this.listaContas = listaContas;
    }
    
    public void criarConta(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite seu endereço:");
        String endereco = scanner.nextLine();
        System.out.println("Digite sua profissão:");
        String profissao = scanner.nextLine();
        Cliente novoCliente = new Cliente(nome, endereco, profissao);
        listaClientes.add(novoCliente);
        try {  
            System.out.println("Digite 1 pra Conta Corrente ou Digite 2 para Poupança:");
        int tipoConta = scanner.nextInt();
        System.out.println("Digite número da agência:");
        int numeroAgencia = scanner.nextInt();
        System.out.println("Digite número da conta:");
        int numeroConta = scanner.nextInt();
        System.out.println("Digite seu saldo:");
        float saldo = scanner.nextFloat();
        if (saldo < 0) {
            throw new IllegalArgumentException("O saldo não pode ser negativo.");
        }
        
        if (tipoConta == 1) {
            ContaCorrente usuario = new ContaCorrente(numeroAgencia, numeroConta, saldo, novoCliente);
            listaContas.add(usuario);
        } else if (tipoConta == 2) {
            ContaPoupanca usuario = new ContaPoupanca(numeroAgencia, numeroConta, saldo, novoCliente);
            listaContas.add(usuario);
        } else {
            System.out.println("Tipo de conta inválido.");
        }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira números inteiros para agência e conta.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }  
           
        }
        public void realizarOperacoes(int numAgenciaEnviada, int numContaEnviada, int numAgenciaRecebida, int numContaRecebida) {
            Conta contaEnviada = null;
            for (int i = 0; i < listaContas.size(); i++) {
                Conta conta = listaContas.get(i);
                if (conta.getNumeroAgencia() == numAgenciaEnviada && conta.getNumeroConta() == numContaEnviada) {
                    contaEnviada = conta;
                    break;
                }
            }
            Conta contaRecebida = null;
            for (int i = 0; i < listaContas.size(); i++) {
                Conta conta = listaContas.get(i);
                if (conta.getNumeroAgencia() == numAgenciaRecebida && conta.getNumeroConta() == numContaRecebida) {
                    contaRecebida = conta;
                    break;
                }
            }
            
            if (contaEnviada == null) {
                System.out.println("Conta de envio não encontrada.");
                return;
            }
            
            if (contaRecebida == null) {
                System.out.println("Conta de recebimento não encontrada.");
                return;
            }
            
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o valor a ser transferido:");
            float valorTransferencia = scanner.nextFloat();
            
            try {
                contaEnviada.transferencia(contaRecebida, valorTransferencia);
                System.out.println("Transferência realizada com sucesso.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        
}
