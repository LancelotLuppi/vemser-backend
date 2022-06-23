public class ContaPoupanca extends Conta implements Impressao {
    static final double JUROS_MENSAL = 1.01;

    @Override
    public void imprimir() {
        System.out.println("------------------------"
                + "Imprimindo dados da conta poupança"
                + "\nCliente: " + this.getCliente().getNome()
                + "\nNumero da conta: " + this.getNumeroConta()
                + "\nAgencia: " + this.getAgencia()
                + "\nSaldo: " + this.getSaldo()
                + "\nJuros mensal: " + JUROS_MENSAL
        );
    }

    public void creditarTaxa(){
        this.setSaldo(this.getSaldo() * JUROS_MENSAL);
    }
}
