
package br.com.tcc.DomainModel;

import java.util.Objects;

/**
 *
 * @author Thaisa
 */
public class Produto {
    private int idProduto;
    private String nome;
    private int qtdEstoque;
    private float valorUnidadeVenda;
    private float valorUnidadeCompra;
    private String descricao;

    public Produto() {
        this.idProduto = 0;
        this.nome = "";
        this.qtdEstoque = 0;
        this.valorUnidadeVenda = 0;
        this.valorUnidadeCompra = 0;
        this.descricao = "";
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public float getValorUnidadeVenda() {
        return valorUnidadeVenda;
    }

    public void setValorUnidadeVenda(float valorUnidadeVenda) {
        this.valorUnidadeVenda = valorUnidadeVenda;
    }

    public float getValorUnidadeCompra() {
        return valorUnidadeCompra;
    }

    public void setValorUnidadeCompra(float valorUnidadeCompra) {
        this.valorUnidadeCompra = valorUnidadeCompra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idProduto;
        hash = 41 * hash + Objects.hashCode(this.nome);
        hash = 41 * hash + this.qtdEstoque;
        hash = 41 * hash + Float.floatToIntBits(this.valorUnidadeVenda);
        hash = 41 * hash + Float.floatToIntBits(this.valorUnidadeCompra);
        hash = 41 * hash + Objects.hashCode(this.descricao);
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
        final Produto other = (Produto) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
