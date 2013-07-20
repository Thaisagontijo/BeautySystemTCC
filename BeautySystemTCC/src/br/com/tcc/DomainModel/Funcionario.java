
package br.com.tcc.DomainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Thaisa
 */
public class Funcionario extends Pessoa{
    private int idFuncionario;
    private Date dataAdmissao;
    private float salario;
    private Funcao funcao;

    public Funcionario() {
        this.idFuncionario = 0;
        this.dataAdmissao = new Date();
        this.salario = 0;
        this.funcao = new Funcao();
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Funcao getFuncao() {
        return funcao;
    }

    public void setFuncao(Funcao funcao) {
        this.funcao = funcao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idFuncionario;
        hash = 97 * hash + Objects.hashCode(this.dataAdmissao);
        hash = 97 * hash + Float.floatToIntBits(this.salario);
        hash = 97 * hash + Objects.hashCode(this.funcao);
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
        final Funcionario other = (Funcionario) obj;
        if (!Objects.equals(this.dataAdmissao, other.dataAdmissao)) {
            return false;
        }
        if (!Objects.equals(this.funcao, other.funcao)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return toString();
    }
    
 
    
}
