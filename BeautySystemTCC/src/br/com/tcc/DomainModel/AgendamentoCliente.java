
package br.com.tcc.DomainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Thaisa
 */
public class AgendamentoCliente {
    private int idAgendamento;
    private Date dataAgendamento;
    private String observacao;

    public AgendamentoCliente() {
        this.idAgendamento = 0;
        this.dataAgendamento = new Date();
        this.observacao = "";
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public Date getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(Date dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idAgendamento;
        hash = 79 * hash + Objects.hashCode(this.dataAgendamento);
        hash = 79 * hash + Objects.hashCode(this.observacao);
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
        final AgendamentoCliente other = (AgendamentoCliente) obj;
        if (!Objects.equals(this.dataAgendamento, other.dataAgendamento)) {
            return false;
        }
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        return true;
    }
    
}
