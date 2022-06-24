package br.com.luppi.classes.cliente;

import br.com.luppi.classes.cliente.dados.Contato;
import br.com.luppi.classes.cliente.dados.Endereco;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private String cpf;

    private ArrayList<Contato> contatosList = new ArrayList<>();
    private ArrayList<Endereco> enderecosList = new ArrayList<>();

    public void imprimirContatos(){
        for(int i=0; i< getContatos().size(); i++){
            if(contatosList.get(i) != null) {
                contatosList.get(i).imprimirContato();
            }
        }
    }
    public void imprimirEnderecos(){
        for(int i=0; i< getEnderecos().size(); i++) {
            if(enderecosList != null) {
                enderecosList.get(i).imprimeEndereco();
            }
        }
    }
    public void imprimirCliente(){
        System.out.println("----------------------------------------"
            + "Nome e CPF do titular"
            + "\nNome: " + this.nome
            + "\nCPF: " + this.cpf
        );
        imprimirContatos();
        imprimirEnderecos();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ArrayList<Contato> getContatos() {
        return contatosList;
    }

    public void setContatos(Contato contato) {
        contatosList.add(contato);
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecosList;
    }

    public void setEnderecos(Endereco endereco) {
            enderecosList.add(endereco);
    }
}
