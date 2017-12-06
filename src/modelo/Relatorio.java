package modelo;

import java.util.Date;

public class Relatorio {
    
    private String nome;
    private Date dataInicio;
    private Date dataFinal;
    private String tipo;
    private FuncionarioLogado funcionarioSolicitante;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public FuncionarioLogado getFuncionarioSolicitante() {
        return funcionarioSolicitante;
    }

    public void setFuncionarioSolicitante(FuncionarioLogado funcionarioSolicitante) {
        this.funcionarioSolicitante = funcionarioSolicitante;
    }
    
}
