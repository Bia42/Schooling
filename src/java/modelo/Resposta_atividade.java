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
public class Resposta_atividade {
    private int id;
    private int atividade_id;
    private String resposta;
    private int espcaco;

    public Resposta_atividade(int id, int atividade_id, String resposta, int espcaco) {
        this.id = id;
        this.atividade_id = atividade_id;
        this.resposta = resposta;
        this.espcaco = espcaco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAtividade_id() {
        return atividade_id;
    }

    public void setAtividade_id(int atividade_id) {
        this.atividade_id = atividade_id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getEspcaco() {
        return espcaco;
    }

    public void setEspcaco(int espcaco) {
        this.espcaco = espcaco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.id;
        hash = 37 * hash + this.atividade_id;
        hash = 37 * hash + Objects.hashCode(this.resposta);
        hash = 37 * hash + this.espcaco;
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
        final Resposta_atividade other = (Resposta_atividade) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.atividade_id != other.atividade_id) {
            return false;
        }
        if (this.espcaco != other.espcaco) {
            return false;
        }
        if (!Objects.equals(this.resposta, other.resposta)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Resposta_atividade{" + "id=" + id + ", atividade_id=" + atividade_id + ", resposta=" + resposta + ", espcaco=" + espcaco + '}';
    }
    
}
