public class Main {
    public static void main(String[] args) {

        ContaCorrente c1 = new ContaCorrente();
        c1.saldo = 10000;
        c1.chequeEspecial = 300;
        ContaCorrente c2 = new ContaCorrente();
        c2.saldo = 10000;
        c2.chequeEspecial = 300;

        Cliente maicon = new Cliente();
        c1.cliente = maicon;
        Cliente rafael = new Cliente();
        c2.cliente = rafael;

        c1.sacar(2500); // Resolveu comprar um Nintendo Switch
        c2.depositar(8000); // Dia de pagamento
        c2.transferir(c1, 500); // Maicon ganhou a aposta de que todos os alunos seriam contratados

        // Testes de regras:
        c1.depositar(-20);
        c2.sacar(-349);
        c1.sacar(20000);
        c1.transferir(c2, -7500);
        c2.transferir(c1, 9999999);

        System.out.println("Saldo - conta Maicon: " + c1.saldo);
        System.out.println("Saldo - conta Rafael: " + c2.saldo);



        // Teste das classes: Cliente, Endereco e Contato
        Contato contato1 = new Contato();
        contato1.descricao = "Pessoal";
        contato1.telefone = "(54)9978439";
        contato1.tipo = 1;

        Contato contato2 = new Contato();
        contato2.descricao = "Profissional";
        contato2.telefone = "(11)9977849";
        contato2.tipo = 0;

        Endereco endereco1 = new Endereco();
        endereco1.tipo = 1;
        endereco1.logradouro = "Rua dos Charizard";
        endereco1.numero = 34;
        endereco1.complemento = "AP 123";
        endereco1.cep = "93140-342";
        endereco1.cidade = "São Leopoldo";
        endereco1.estado = "RS";
        endereco1.pais = "Brasil";

        Endereco endereco2 = new Endereco();
        endereco2.tipo = 0;
        endereco2.logradouro = "Rua dos Blastoize";
        endereco2.numero = 11;
        endereco2.complemento = "AP 534";
        endereco2.cep = "74720-280";
        endereco2.cidade = "Goiânia";
        endereco2.estado = "GO";
        endereco2.pais = "Brasil";

        Cliente luppi = new Cliente();
        luppi.nome = "Gabriel Luppi";
        luppi.cpf = "440.596.260-07";

        luppi.contatos[0] = contato1;
        luppi.contatos[1] = contato2;

        luppi.enderecos[0] = endereco1;
        luppi.enderecos[1] = endereco2;
        luppi.imprimirCliente();
        luppi.imprimirEnderecos();
        luppi.imprimirContatos();

        contato1.imprimirContato();
        endereco2.imprimeEndereco();
    }
}
