package com.br.carrilho.silva.pernambucosat.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "pais")
    private List<Uf> uf;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Uf> getUf() {
        return uf;
    }

    public void setUf(List<Uf> uf) {
        this.uf = uf;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", uf=" + uf +
                '}';
    }
}
