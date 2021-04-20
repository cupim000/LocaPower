package Classes;

import java.util.Date;

public abstract class Locacoes {
    //Atributos
    private int locacaoCod, codCliente;
    private String cliente, observacoes, placa, preco, dias, valor, situacao;
    private Date dataInicio, dataTermino;
    
    //Métodos

    public abstract void salvar();
    
    public abstract void buscarCliente();
    
    public abstract void alterarStatus(boolean flag);
    
    public abstract void alterarLocacao(boolean flag);
    
    public abstract void excluir();
            
    //Gets e Setes
    public int getLocacaoCod() {
        return locacaoCod;
    }

    public void setLocacaoCod(int locacaoCod) {
        this.locacaoCod = locacaoCod;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
        this.dataTermino = dataTermino;
    }
    

}



    