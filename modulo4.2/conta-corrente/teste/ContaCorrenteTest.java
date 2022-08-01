package br.com.luppi.teste;

import br.com.luppi.classes.conta.ContaCorrente;
import br.com.luppi.classes.conta.ContaPagamento;
import br.com.luppi.classes.conta.ContaPoupanca;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaCorrenteTest {

    Integer saque;
    Boolean saqueEfetuado;
    Integer transferencia;
    Boolean transferenciaEfetuada;
    Integer deposito;
    Boolean depositoEfetuado;

    @Test
    public void testarSaqueContaCorrenteEVerificarSaldoComSucesso() {
        //setup
        ContaCorrente contaCorrente = gerarContaCorrente(1750, 500);
        saque = 2000;

        //act
        saqueEfetuado = contaCorrente.sacar(saque);

        //asserts
        Assertions.assertTrue(saqueEfetuado);
        Assertions.assertEquals(-250 , contaCorrente.getSaldo());
    }

    @Test
    public void testarSaqueContaCorrenteSemSaldo() {
        ContaCorrente contaCorrente = gerarContaCorrente(900, 150);
        saque = 1500;

        saqueEfetuado = contaCorrente.sacar(saque);

        Assertions.assertFalse(saqueEfetuado);
        Assertions.assertEquals(900 , contaCorrente.getSaldo());
    }

    @Test
    public void testarSaqueContaPoupancaEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = gerarContaPoupanca(3000);
        saque = 300;

        contaPoupanca.creditarTaxa();
        saqueEfetuado = contaPoupanca.sacar(saque);

        Assertions.assertTrue(saqueEfetuado);
        Assertions.assertEquals(2730, contaPoupanca.getSaldo());
    }

    @Test
    public void testarSaqueContaPoupancaSemSaldo() {
        ContaPoupanca contaPoupanca = gerarContaPoupanca(3000);
        saque = 3031;

        contaPoupanca.creditarTaxa();
        saqueEfetuado = contaPoupanca.sacar(saque);

        Assertions.assertFalse(saqueEfetuado);
        Assertions.assertEquals(3030, contaPoupanca.getSaldo());
    }

    @Test
    public void testarSaqueContaPagamentoEVerificarSaldoComSucesso() {
        ContaPagamento contaPagamento = gerarContaPagamento(1235.25);
        saque = 1230;

        saqueEfetuado = contaPagamento.sacar(saque);

        Assertions.assertTrue(saqueEfetuado);
        Assertions.assertEquals(1, contaPagamento.getSaldo());

    }

    @Test
    public void testarSaqueContaPagamentoSemSaldo() {
        ContaPagamento contaPagamento = gerarContaPagamento(1000);
        saque = 1000;

        saqueEfetuado = contaPagamento.sacar(saque);

        Assertions.assertFalse(saqueEfetuado);
        Assertions.assertEquals(1000, contaPagamento.getSaldo());
    }

    @Test
    public void testarTransferenciaEVerificarSaldoComSucesso() {
        ContaPoupanca contaPoupanca = gerarContaPoupanca(2500);
        ContaCorrente contaCorrente = gerarContaCorrente(4200, 578);
        transferencia = 600;

        transferenciaEfetuada = contaPoupanca.transferir(contaCorrente, transferencia);

        Assertions.assertTrue(transferenciaEfetuada);
        Assertions.assertEquals(1900, contaPoupanca.getSaldo());
        Assertions.assertEquals(4800, contaCorrente.getSaldo());
    }

    @Test
    public void testarTransferenciaSemSaldo() {
        ContaPoupanca contaPoupanca = gerarContaPoupanca(2500);
        ContaCorrente contaCorrente = gerarContaCorrente(4200, 300);
        transferencia = 2501;

        transferenciaEfetuada = contaPoupanca.transferir(contaCorrente, transferencia);

        Assertions.assertFalse(transferenciaEfetuada);
        Assertions.assertEquals(2500, contaPoupanca.getSaldo());
        Assertions.assertEquals(4200, contaCorrente.getSaldo());
    }

    @Test
    public void testarDepositoEVerificarSaldoComSucesso() {
        ContaCorrente contaCorrente = gerarContaCorrente(200, 0);
        deposito = 1600;

        depositoEfetuado = contaCorrente.depositar(deposito);

        Assertions.assertTrue(depositoEfetuado);
        Assertions.assertEquals(1800, contaCorrente.getSaldo());
    }

    @Test
    public void testarDepositoNegativo() {
        ContaCorrente contaCorrente = gerarContaCorrente(200, 0);
        deposito = -2000;

        depositoEfetuado = contaCorrente.depositar(deposito);

        Assertions.assertFalse(depositoEfetuado);
        Assertions.assertEquals(200, contaCorrente.getSaldo());
    }

    

    private ContaCorrente gerarContaCorrente(int saldo, int valorChequeEspecial) {
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.setSaldo(saldo);
        contaCorrente.setChequeEspecial(valorChequeEspecial);
        return contaCorrente;
    }

    private ContaPoupanca gerarContaPoupanca(int saldo) {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setSaldo(saldo);
        return contaPoupanca;
    }

    private ContaPagamento gerarContaPagamento(double saldo) {
        ContaPagamento contaPagamento = new ContaPagamento();
        contaPagamento.setSaldo(saldo);
        return contaPagamento;
    }
}
