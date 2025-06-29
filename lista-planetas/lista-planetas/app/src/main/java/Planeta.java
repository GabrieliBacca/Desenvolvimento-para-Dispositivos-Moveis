package com.ifsc.contaclick;

import java.io.Serializable;

public class Planeta implements Serializable {
    private String nome;
    private Integer foto;


    public Planeta(String nome, Integer foto) {
        this.nome = nome;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {
        this.foto = foto;
    }
}
