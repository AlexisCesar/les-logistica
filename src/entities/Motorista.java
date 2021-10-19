/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Objects;

/**
 *
 * @author ADM
 */
public class Motorista {
    
    private Integer id;
    private String nome;
    private Character categoriaCnh;
    
    public Motorista(){
        
    }

    public Motorista(Integer id, String nome, Character categoriaCnh) {
        this.id = id;
        this.nome = nome;
        this.categoriaCnh = categoriaCnh;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getCategoriaCnh() {
        return categoriaCnh;
    }

    public void setCategoriaCnh(Character categoriaCnh) {
        this.categoriaCnh = categoriaCnh;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Motorista other = (Motorista) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Motorista{" + "id=" + id + ", nome=" + nome + ", categoriaCnh=" + categoriaCnh + '}';
    }
    
}
