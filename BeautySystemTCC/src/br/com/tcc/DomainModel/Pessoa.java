
package br.com.tcc.DomainModel;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Thaisa
 */
public class Pessoa {
    private int idPessoa;
    private String nome;
    private Date dataNascimento;
    private int cpf;
    private String rua;
    private String bairro;
    private int numero;
    private String complemento;
    private String telefone;

    public Pessoa() {
        this.idPessoa = 0;
        this.nome = "";
        this.dataNascimento = new Date();
        this.cpf = 0;
        this.rua = "";
        this.bairro = "";
        this.numero = 0;
        this.complemento = "";
        this.telefone = "";
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idPessoa;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + Objects.hashCode(this.dataNascimento);
        hash = 37 * hash + this.cpf;
        hash = 37 * hash + Objects.hashCode(this.rua);
        hash = 37 * hash + Objects.hashCode(this.bairro);
        hash = 37 * hash + this.numero;
        hash = 37 * hash + Objects.hashCode(this.complemento);
        hash = 37 * hash + Objects.hashCode(this.telefone);
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
        final Pessoa other = (Pessoa) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.dataNascimento, other.dataNascimento)) {
            return false;
        }
        if (this.cpf != other.cpf) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
   
}
