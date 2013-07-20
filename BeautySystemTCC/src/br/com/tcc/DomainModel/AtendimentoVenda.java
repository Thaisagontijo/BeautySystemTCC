
package br.com.tcc.DomainModel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Thaisa
 */
public class AtendimentoVenda {
    private int idAtendimentoVenda;
    private Date dataAtendimentoVenda;
    private Funcionario funcionario;
    private Cliente cliente;
    private FormaPagemento formaPagamento;
    private List<ItemVenda>listaDeItens;
    private List<Servico>listaDeServicos;
    private float valorTotal;

    public AtendimentoVenda() {
        this.idAtendimentoVenda = 0;
        this.dataAtendimentoVenda = new Date();
        this.funcionario = new Funcionario();
        this.cliente = new Cliente();
        this.formaPagamento = new FormaPagemento();
        this.listaDeItens = new LinkedList<>();
        this.listaDeServicos = new LinkedList<>();
        this.valorTotal = 0;
    }

    public int getIdAtendimentoVenda() {
        return idAtendimentoVenda;
    }

    public void setIdAtendimentoVenda(int idAtendimentoVenda) {
        this.idAtendimentoVenda = idAtendimentoVenda;
    }

    public Date getDataAtendimentoVenda() {
        return dataAtendimentoVenda;
    }

    public void setDataAtendimentoVenda(Date dataAtendimentoVenda) {
        this.dataAtendimentoVenda = dataAtendimentoVenda;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public FormaPagemento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagemento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public List<ItemVenda> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<ItemVenda> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public List<Servico> getListaDeServicos() {
        return listaDeServicos;
    }

    public void setListaDeServicos(List<Servico> listaDeServicos) {
        this.listaDeServicos = listaDeServicos;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public void addItemVenda(ItemVenda i){
        if(!this.listaDeItens.contains(i)){
            this.listaDeItens.add(i);
            this.valorTotal += i.getQtd() * i.getProduto().getValorUnidadeVenda();
        }
    }
    
    public void removeItemVenda(ItemVenda i){
        if(this.listaDeItens.contains(i)){
            this.listaDeItens.remove(i);
            this.valorTotal -= i.getQtd() * i.getProduto().getValorUnidadeVenda();
        }
    }
    
    public void addServicoPrestado(Servico s){
        if(!this.listaDeServicos.contains(s)){
            this.listaDeServicos.add(s);
            this.valorTotal += s.getValor();
        }
    }
    
    public void removeServicoPrestado(Servico s){
        if(this.listaDeServicos.contains(s)){
            this.listaDeServicos.remove(s);
            this.valorTotal -= s.getValor();
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.idAtendimentoVenda;
        hash = 11 * hash + Objects.hashCode(this.dataAtendimentoVenda);
        hash = 11 * hash + Objects.hashCode(this.funcionario);
        hash = 11 * hash + Objects.hashCode(this.cliente);
        hash = 11 * hash + Objects.hashCode(this.formaPagamento);
        hash = 11 * hash + Objects.hashCode(this.listaDeItens);
        hash = 11 * hash + Objects.hashCode(this.listaDeServicos);
        hash = 11 * hash + Float.floatToIntBits(this.valorTotal);
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
        final AtendimentoVenda other = (AtendimentoVenda) obj;
        if (!Objects.equals(this.dataAtendimentoVenda, other.dataAtendimentoVenda)) {
            return false;
        }
        if (!Objects.equals(this.funcionario, other.funcionario)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.listaDeItens, other.listaDeItens)) {
            return false;
        }
        if (!Objects.equals(this.listaDeServicos, other.listaDeServicos)) {
            return false;
        }
        if (Float.floatToIntBits(this.valorTotal) != Float.floatToIntBits(other.valorTotal)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dataAtendimentoVenda.toString();
    }
 
    
}
