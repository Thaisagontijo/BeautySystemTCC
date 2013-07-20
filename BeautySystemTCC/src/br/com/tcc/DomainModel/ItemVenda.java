
package br.com.tcc.DomainModel;

import java.util.Objects;

/**
 *
 * @author Thaisa
 */
public class ItemVenda {
    private int idItemVenda;
    private int qtd;
    private Produto produto;

    public ItemVenda() {
        this.idItemVenda = 0;
        this.qtd = 0;
        this.produto = new Produto();
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idItemVenda;
        hash = 37 * hash + this.qtd;
        hash = 37 * hash + Objects.hashCode(this.produto);
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
        final ItemVenda other = (ItemVenda) obj;
        if (this.qtd != other.qtd) {
            return false;
        }
        if (!Objects.equals(this.produto, other.produto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return produto.toString();
    }
    
    
    
    
}
