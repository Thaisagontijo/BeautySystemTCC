
package br.com.tcc.DomainModel;

import java.util.Objects;

/**
 *
 * @author Thaisa
 */
public class Servico {
    private int idServico;
    private String nome;
    private float valor;
    private String descicao;

    public Servico() {
        this.idServico = 0;
        this.nome = "";
        this.valor = 0;
        this.descicao = "";
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescicao() {
        return descicao;
    }

    public void setDescicao(String descicao) {
        this.descicao = descicao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idServico;
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Float.floatToIntBits(this.valor);
        hash = 29 * hash + Objects.hashCode(this.descicao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Servico other = (Servico) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descicao, other.descicao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
    
    
}
