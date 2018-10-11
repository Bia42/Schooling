/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author Beatriz Oliveira
 */
public class Atividade {
    
    private int id;
    private String nome;
    private int nivel;
    private String texto;
    private String resposta;

    public Atividade(int id, String nome, int nivel, String texto, String resposta) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.texto = texto;
        this.resposta = resposta;
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

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + this.nivel;
        hash = 97 * hash + Objects.hashCode(this.texto);
        hash = 97 * hash + Objects.hashCode(this.resposta);
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
        final Atividade other = (Atividade) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nivel != other.nivel) {
            return false;
        }
        if (this.resposta != other.resposta) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atividade{" + "id=" + id + ", nome=" + nome + ", nivel=" + nivel + ", texto=" + texto + ", resposta=" + resposta + '}';
    }
    
    
    
}
