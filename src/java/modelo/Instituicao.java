/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;

/**
 *
 * @author Beatriz Oliveira
 */
public class Instituicao {
    
    private int id;
    private String nome;
    private int pais_id;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + this.pais_id;
        hash = 29 * hash + this.estado_id;
        hash = 29 * hash + this.cidade_id;
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
        final Instituicao other = (Instituicao) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.pais_id != other.pais_id) {
            return false;
        }
        if (this.estado_id != other.estado_id) {
            return false;
        }
        if (this.cidade_id != other.cidade_id) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }
    private int estado_id;
    private int cidade_id;

    @Override
    public String toString() {
        return "Instituicao{" + "id=" + id + ", nome=" + nome + ", pais_id=" + pais_id + ", estado_id=" + estado_id + ", cidade_id=" + cidade_id + '}';
    }

    public Instituicao(String nome, int pais_id, int estado_id, int cidade_id) {
        this.nome = nome;
        this.pais_id = pais_id;
        this.estado_id = estado_id;
        this.cidade_id = cidade_id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPais_id() {
        return pais_id;
    }

    public void setPais_id(int pais_id) {
        this.pais_id = pais_id;
    }

    public int getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(int estado_id) {
        this.estado_id = estado_id;
    }

    public int getCidade_id() {
        return cidade_id;
    }

    public void setCidade_id(int cidade_id) {
        this.cidade_id = cidade_id;
    }


   
    
}
