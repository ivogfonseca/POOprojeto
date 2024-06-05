public class ContaCorrente extends Conta {
    public double taxaManutencao = 50;
    
    public ContaCorrente(int numeroAgencia, int numeroConta, double saldo, Cliente cliente) {
        super(numeroAgencia, numeroConta, saldo, cliente);
        //TODO Auto-generated constructor stub
    }

    public double simularOperacao(int meses){
        double saldoM = getSaldo();
        for(int i = 0; i < meses; i++){
            saldoM -= taxaManutencao;
            if(saldoM < 0){
                saldoM = 0;
                break;
            }
        }
        return saldoM;
    }
    
}
