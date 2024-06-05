public class ContaPoupanca extends Conta {
    private double taxaRendimento = 0.05;
    
    public ContaPoupanca(int numeroAgencia, int numeroConta, float saldo, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        }

    public double simularOperação(int meses){
        double saldoAtual = getSaldo();
        for (int i = 0; i < meses; i++) {
            double rendimentoMensal = saldoAtual * taxaRendimento;
            saldoAtual += rendimentoMensal;
        }
        return saldoAtual;
    }
    
} 


