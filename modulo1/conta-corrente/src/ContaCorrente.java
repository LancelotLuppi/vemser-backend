public class ContaCorrente {
    Cliente cliente;
    String numeroConta;
    int agencia;
    double saldo;
    double chequeEspecial;

    public void imprimirContaCorrente(){
        System.out.println("----------------------------------------"
                + "Imprimindo dados da conta corrente"
                + "\nCliente: " + this.cliente.nome
                + "\nNumero da conta: " + this.numeroConta
                + "\nAgencia: " + this.agencia
                + "\nSaldo: " + this.saldo
                + "\nCheque especial: " + this.chequeEspecial
        );
    }

    public boolean sacar(double valor){
        if(valor>0 && valor <= this.saldo+this.chequeEspecial){
            saldo -= valor;
            return true;
        } else {
            return false;
        }
    }

    public boolean depositar(double valor) {
        if(valor > 0){
            saldo += valor;
            return true;
        } else {
            return false;
        }
    }

    public double retornarSaldoComChequeEspecial() {
        double saldoTotal = this.saldo + this.chequeEspecial;
        return saldoTotal;
    }

    public boolean transferir(ContaCorrente contaDestino, double valor){
        if(this.sacar(valor) == true){
            contaDestino.depositar(valor);
            return true;
        } else {
            return false;
        }
    }

}
