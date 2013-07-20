
package br.com.tcc.DomainModel;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Thaisa
 */
public class Cliente extends Pessoa{
    private int idCliente;
    private Date dataCadastro;
    private List<AgendamentoCliente> listaAgendamentos;

    public Cliente() {
        this.idCliente = 0;
        this.dataCadastro = new Date();
        this.listaAgendamentos = new LinkedList<>();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<AgendamentoCliente> getListaAgendamentos() {
        return listaAgendamentos;
    }

    public void setListaAgendamentos(List<AgendamentoCliente> listaAgendamentos) {
        this.listaAgendamentos = listaAgendamentos;
    }
    
    public void addAgendamento(AgendamentoCliente a ){
        if(!this.listaAgendamentos.contains(a)){
            this.listaAgendamentos.add(a);
                    
        }
    }
    
    public void removeAgendamento(AgendamentoCliente a ){
        if(this.listaAgendamentos.contains(a)){
            this.listaAgendamentos.remove(a);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idCliente;
        hash = 67 * hash + Objects.hashCode(this.dataCadastro);
        hash = 67 * hash + Objects.hashCode(this.listaAgendamentos);
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
        final Cliente other = (Cliente) obj;
        return true;
    }
    
    
    
    
}
