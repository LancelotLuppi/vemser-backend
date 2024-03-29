package br.com.luppi.teste;

import br.com.luppi.classes.cliente.Cliente;
import br.com.luppi.classes.cliente.dados.Contato;
import br.com.luppi.classes.cliente.dados.Endereco;
import br.com.luppi.classes.conta.ContaCorrente;
import br.com.luppi.classes.conta.ContaPoupanca;

public class Main {
    public static void main(String[] args) {

        // Teste das contas: br.com.luppi.classes.conta.ContaPoupanca e br.com.luppi.classes.conta.ContaCorrente
        ContaCorrente cc1 = new ContaCorrente();
        cc1.setSaldo(300);
        Cliente charmander = new Cliente();
        charmander.setNome("Charmander");
        cc1.setCliente(charmander);
        cc1.setNumeroConta("8796573");
        cc1.setAgencia(12);
        cc1.setChequeEspecial(500);

        ContaPoupanca cp1 = new ContaPoupanca();
        cp1.setSaldo(300);
        Cliente squirtle = new Cliente();
        squirtle.setNome("Squirtle");
        cp1.setCliente(squirtle);
        cp1.setNumeroConta("5305186");
        cp1.setAgencia(6);

        cc1.depositar(400);
        cp1.depositar(400);

        cc1.sacar(250);
        cp1.sacar(250);

        cc1.transferir(cp1, 100);
        cp1.transferir(cc1, 100);

        cc1.depositar(10000);
        cp1.depositar(10000);

        cp1.transferir(cc1, 6000);
        cc1.transferir(cp1, 10000);
        cc1.transferir(cp1, 6950);
        cp1.creditarTaxa();


        System.out.println(" ");

        cc1.imprimir();
        cp1.imprimir();

        System.out.println(" ");
        // Teste das classes: br.com.luppi.classes.cliente.Cliente, br.com.luppi.classes.cliente.dados.Endereco e br.com.luppi.classes.cliente.dados.Contato
        Contato contato1 = new Contato();
        contato1.setDescricao("br.com.luppi.classes.cliente.dados.Contato celular pessoal");
        contato1.setTelefone("(54)9978439");
        contato1.setTipo(1);

        Contato contato2 = new Contato();
        contato2.setDescricao("br.com.luppi.classes.cliente.dados.Contato celular profissional");
        contato2.setTelefone("(11)9977849");
        contato2.setTipo(0);

        Endereco endereco1 = new Endereco();
        endereco1.setTipo(1);
        endereco1.setLogradouro("Rua dos Charizard");
        endereco1.setTipo(42);
        endereco1.setComplemento("AP 123");
        endereco1.setCep("93140-342");
        endereco1.setCidade("São Leopoldo");
        endereco1.setEstado("RS");
        endereco1.setPais("Brasil");

        Endereco endereco2 = new Endereco();
        endereco2.setTipo(0);
        endereco2.setLogradouro("Rua dos Blastoize");
        endereco2.setNumero(11);
        endereco2.setComplemento("AP 521");
        endereco2.setCep("74720-280");
        endereco2.setCidade("Goiânia");
        endereco2.setEstado("GO");
        endereco2.setPais("Brasil");

        Cliente luppi = new Cliente();
        luppi.setNome("Gabriel Luppi");
        luppi.setCpf("440.596.260-07");

        luppi.setContatos(0, contato1);

        luppi.setEnderecos(0, endereco1);
        luppi.setEnderecos(3, endereco2);

        luppi.imprimirCliente();
//        luppi.imprimirEnderecos();
//        luppi.imprimirContatos();
//
//        contato1.imprimirContato();
//        endereco2.imprimeEndereco();



    }
}
