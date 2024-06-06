import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        
        List<Cliente> listaClientes = new ArrayList<>();
        List<Conta> listaContas = new ArrayList<>();

        Cliente cliente1 = new Cliente("Ivo", "Jaqueira", "Astronauta");
        Conta conta1 = new Conta(10, 01, 100, cliente1);
        
        Cliente cliente2 = new Cliente("Ana", "Silva", "Engenheira");
        Conta conta2 = new Conta(20, 02, 200, cliente2);
        
        Cliente cliente3 = new Cliente("João", "Oliveira", "Professor");
        Conta conta3 = new Conta(30, 03, 300, cliente3);
        
        Cliente cliente4 = new Cliente("Maria", "Costa", "Médica");
        Conta conta4 = new Conta(40, 04, 400, cliente4);
        
        Cliente cliente5 = new Cliente("Pedro", "Santos", "Advogado");
        Conta conta5 = new Conta(50, 05, 500, cliente5);

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);
        listaClientes.add(cliente3);
        listaClientes.add(cliente4);
        listaClientes.add(cliente5);

        listaContas.add(conta1);
        listaContas.add(conta2);
        listaContas.add(conta3);
        listaContas.add(conta4);
        listaContas.add(conta5);
        
        TesteOperacoes testeOperacoes = new TesteOperacoes(listaClientes, listaContas);
        testeOperacoes.apresentarMenu();

        

    }
}
