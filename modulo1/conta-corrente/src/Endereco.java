public class Endereco {
    int tipo;
    String logradouro;
    int numero;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

    public void imprimeEndereco(){
        System.out.println("--------------------------------------"
            + "\nTipo de endereço: " + this.tipo + " (1-Residencial | 2-Comercial)"
            + "\nLogradouro: " + this.logradouro
            + "\nNumero: " + this.numero
            + "\nComplemento: " + this.complemento
            + "\nCEP: " + this.cep
            + "\nCidade: " + this.cidade
            + "\nEstado: " + this.estado
            + "\nPaís: " + this.pais
        );
    }
}
