public class Conta {
    private int numeroAgencia;
    private int numeroConta;
    private float saldo;
    private Cliente cliente;
    
    
    public Conta(int numeroAgencia, int numeroConta, float saldo, Cliente cliente) {
        this.numeroAgencia = numeroAgencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }


    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }


    public int getNumeroConta() {
        return numeroConta;
    }


    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }


    public float getSaldo() {
        return saldo;
    }


    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void deposito(float quantia) {
        if (quantia > 0) {
            saldo += quantia;
            System.out.println("Depósito de R$" + quantia);
            System.out.println("Novo saldo: R$" + saldo);
        }
    }
    
    public void saque(float quantia){
        if(quantia > 0 && saldo >= quantia){
            saldo-= quantia;
            System.out.println("Saque de R$" + quantia );
            System.out.println("Novo saldo: R$" + saldo);
        }
    }

    public void transferencia(Conta recebida, float quantia){
        if(this.saldo >= quantia){
            saldo = saldo - quantia;
            float newSaldo = quantia + recebida.getSaldo();
            recebida.setSaldo(newSaldo);
        } 
            
    }
    public void exibirSaldo(){
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Saldo: " + saldo);
    }
}    
