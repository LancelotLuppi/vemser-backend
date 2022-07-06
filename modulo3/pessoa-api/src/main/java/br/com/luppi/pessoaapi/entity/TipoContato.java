package br.com.luppi.pessoaapi.entity;

import java.util.Arrays;

public enum TipoContato {
    COMERCIAL(1),
    RESIDENCIAL(2);

    private Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }
    public static TipoContato ofTipo(Integer tipo){
        return Arrays.stream(TipoContato.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
