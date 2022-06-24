package br.com.luppi.teste;

import br.com.luppi.classes.cliente.Cliente;
import br.com.luppi.classes.cliente.dados.Contato;
import br.com.luppi.classes.cliente.dados.Endereco;
import br.com.luppi.classes.conta.Conta;
import br.com.luppi.classes.conta.ContaCorrente;
import br.com.luppi.classes.conta.ContaPagamento;
import br.com.luppi.classes.conta.ContaPoupanca;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        // Criando Conta Corrente e Cliente
        ContaCorrente cc = new ContaCorrente();
        cc.setSaldo(3000);
        cc.setAgencia("321");
        cc.setNumeroConta("0986546");
        cc.setChequeEspecial(500);

        ContaPagamento cpag = new ContaPagamento();
        cpag.setSaldo(8000);
        cpag.setAgencia("321");
        cpag.setNumeroConta("0932648");

        Cliente luppi = new Cliente();
        luppi.setNome("Gabriel Luppi");
        luppi.setCpf("611.229.280-76");

        Contato contatoLuppi = new Contato();
        contatoLuppi.setDescricao("Contato do cliente Gabriel Luppi");
        contatoLuppi.setTelefone("549807398");
        contatoLuppi.setTipo(1);

        Contato contatoLuppi2 = new Contato();
        contatoLuppi2.setDescricao("Segundo contato do cliente Gabriel Luppi");
        contatoLuppi2.setTelefone("11983098");
        contatoLuppi2.setTipo(2);

        luppi.setContatos(contatoLuppi);
        luppi.setContatos(contatoLuppi2);

        Endereco enderecoLuppi = new Endereco();
        enderecoLuppi.setCep("04856-170");
        enderecoLuppi.setCidade("São Paulo");
        enderecoLuppi.setNumero(321);
        enderecoLuppi.setComplemento("Rua Lugia");
        enderecoLuppi.setEstado("SP");
        enderecoLuppi.setLogradouro("Rua Pikachu");
        enderecoLuppi.setPais("Brasil");
        enderecoLuppi.setTipo(1);

        luppi.setEnderecos(enderecoLuppi);

        luppi.imprimirCliente();


        ContaPoupanca cp = new ContaPoupanca();
        cp.setSaldo(20000);
        cp.setAgencia("64");
        cp.setNumeroConta("09874298");
        Cliente hiluiza = new Cliente();
        hiluiza.setNome("Hiluiza");
        hiluiza.setCpf("913.481.490-60");

        cc.setCliente(luppi);
        cpag.setCliente(luppi);
        cp.setCliente(hiluiza);

        System.out.println("\n\n----------------------------------------Testes de movimentacoes:\n");

        System.out.println("-----------------Saques Conta Pagamento-----------------");
        cpag.sacar(300);
        System.out.println("Saque positivo - saldo esperado cpag (7695.75), recebido: " + cpag.getSaldo());
        cpag.sacar(-20);
        System.out.println("Saque negativo - saldo esperado cpag (7695.75), recebido: " + cpag.getSaldo());
        cpag.sacar(9000);
        System.out.println("Saque fora de limite - saldo esperado cpag (7695.75), recebido: " + cpag.getSaldo() + "\n");


        System.out.println("-----------------Depositos Conta Pagamento-----------------");
        cpag.depositar(750.5);
        System.out.println("Deposito positivo - saldo esperado cpag (8446.25), recebido: " + cpag.getSaldo());
        cpag.depositar(-300);
        System.out.println("Deposito negativo - saldo esperado cpag (8446.25), recebido: " + cpag.getSaldo() + "\n");


        System.out.println("-----------------Saques Conta Corrente-----------------");
        cc.sacar(500);
        System.out.println("Saque positivo - saldo esperado cc (2500.0), recebido: " + cc.getSaldo());
        cc.sacar(-20);
        System.out.println("Saque negativo - saldo esperado cc (2500.0), recebido: " + cc.getSaldo());
        cc.sacar(9000);
        System.out.println("Saque fora de limite - saldo esperado cc (2500.0), recebido: " + cc.getSaldo());

        cc.sacar(3000);
        System.out.println("Saque limite de credito - saldo esperado cc (-500.0), recebido: " + cc.getSaldo() + "\n");


        System.out.println("-----------------Depositos Conta Corrente-----------------");
        cc.depositar(1000);
        System.out.println("Deposito positivo - saldo esperado cc (500), recebido: " + cc.getSaldo());
        cc.depositar(-430);
        System.out.println("Deposito negativo - saldo esperado cc (500), recebido: " + cc.getSaldo() + "\n");


        System.out.println("-----------------Saques Conta Poupanca-----------------");
        cp.sacar(6000);
        System.out.println("Saque positivo - saldo esperado cp (14000.0), recebido: " + cp.getSaldo());
        cp.sacar(-2056);
        System.out.println("Saque negativo - saldo esperado cp (14000.0), recebido: " + cp.getSaldo());
        cp.sacar(60000);
        System.out.println("Saque fora de limite - saldo esperado cp (14000.0), recebido: " + cp.getSaldo() + "\n");


        System.out.println("-----------------Depositos Conta Poupanca-----------------");
        cp.depositar(325);
        System.out.println("Deposito positivo - saldo esperado cp (14325), recebido: " + cp.getSaldo());
        cp.depositar(-700);
        System.out.println("Deposito negativo - saldo esperado cp (14325), recebido: " + cp.getSaldo());
        cp.creditarTaxa();
        System.out.println("Saldo creditado - saldo esperado cp (14468.25), recebido: " + cp.getSaldo() + "\n");


        System.out.println("\n-----------------Transferências Conta Poupanca-----------------\n");
        cp.transferir(cc, 3000);
        System.out.println("Transferencia positica cp->cc - saldo esperado Conta Poupanca (11468.25), recebido: " + cp.getSaldo());
        System.out.println("Transferencia positica cp->cc - saldo esperado Conta Corrente (3500.0), recebido: " + cc.getSaldo() + "\n");
        cp.transferir(cc, -300);
        System.out.println("Transferencia negativa cp->cc - saldo esperado Conta Poupanca (11468.25), recebido: " + cp.getSaldo());
        System.out.println("Transferencia negativa cp->cc - saldo esperado Conta Corrente (3500.0), recebido: " + cc.getSaldo() + "\n");

        cc.transferir(cpag, 400);
        System.out.println("Transferencia positica cc->cpag - saldo esperado Conta Corrente (3100.0), recebido: " + cc.getSaldo());
        System.out.println("Transferencia positica cc->cpag - saldo esperado Conta Pagamento (8846.25), recebido: " + cpag.getSaldo() + "\n");
        cc.transferir(cpag, -400);
        System.out.println("Transferencia negativa cc->cpag - saldo esperado Conta Corrente (3100.0), recebido: " + cc.getSaldo());
        System.out.println("Transferencia negativa cc->cpag - saldo esperado Conta Pagamento (8846.25), recebido: " + cpag.getSaldo() + "\n");
        cc.transferir(cpag, 3600);
        System.out.println("Transferencia com credito cc->cpag - saldo esperado Conta Corrente (-500.0), recebido: " + cc.getSaldo());
        System.out.println("Transferencia com credito cc->cpag - saldo esperado Conta Pagamento (12446.25), recebido: " + cpag.getSaldo() + "\n");
        cpag.transferir(cp, 1000);
        System.out.println("Transferencia positiva cpag->cp - saldo esperado Conta Pagamento (11446.25), recebido: " + cpag.getSaldo());
        System.out.println("Transferencia positiva cpag->cp - saldo esperado Conta Poupanca (12468.25), recebido: " + cp.getSaldo() + "\n");
        cpag.transferir(cp, -3000);
        System.out.println("Transferencia negativa cpag->cp - saldo esperado Conta Pagamento (11446.25), recebido: " + cpag.getSaldo());
        System.out.println("Transferencia negativa cpag->cp - saldo esperado Conta Poupanca (12468.25), recebido: " + cp.getSaldo() + "\n");
        cpag.transferir(cp, 30000);
        System.out.println("Transferencia fora de saldo cpag->cp - saldo esperado Conta Pagamento (11446.25), recebido: " + cpag.getSaldo());
        System.out.println("Transferencia fora de saldo cpag->cp - saldo esperado Conta Poupanca (12468.25), recebido: " + cp.getSaldo() + "\n");


        System.out.println("\n\n----------------------------------------Impressao de dados das contas:\n");
        System.out.println("-----------------Conta Pagamento-----------------");
        cpag.imprimir();
        System.out.println("\n");
        System.out.println("-----------------Conta Corrente-----------------");
        cc.imprimir();
        System.out.println("\n");
        System.out.println("-----------------Conta Poupanca-----------------");
        cp.imprimir();
        System.out.println("\n");

        ContaPagamento cpag2 = new ContaPagamento();
        cpag2.setSaldo(14.25);
        System.out.println(cpag2.sacar(10));
    }
}
