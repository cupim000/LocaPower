package Classes;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTabela extends AbstractTableModel {
    
    //Atributos
    private ArrayList linhas = null;
    private String[] colunas = null;
    
    //Construtor
    public ModeloTabela(ArrayList lin, String[] col){
        setLinhas(lin);
        setColunas(col);
    }
    
    //Métodos
    
    //Conta número de colunas
    @Override
    public int getColumnCount(){
        return this.colunas.length;
    }
    
    //Conta número de linhas
    @Override
    public int getRowCount(){
        return this.linhas.size();
    }
    
    //Retorna o valor da coluna
    @Override
    public String getColumnName(int numCol){
        return this.colunas[numCol];
    }
    
    //Adiciona as linhas na tabela
    @Override
    public Object getValueAt(int numLin, int numCol){
        Object[] linha = (Object[])getLinhas().get(numLin);
        return linha[numCol];
    }
    
    //Gets e Sets

    public ArrayList getLinhas() {
        return this.linhas;
    }

    public void setLinhas(ArrayList linhas) {
        this.linhas = linhas;
    }

    public String[] getColunas() {
        return this.colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
}
