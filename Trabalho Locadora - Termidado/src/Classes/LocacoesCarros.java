package Classes;

import controle.ConexaoBancodeDados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LocacoesCarros extends Locacoes {
    
    //Atributos
    private int codModeloCarro;
    private String modeloCarro;
    
    //Métodos
    ConexaoBancodeDados conex = new ConexaoBancodeDados();
    ConexaoBancodeDados conexCliente = new ConexaoBancodeDados();
    ConexaoBancodeDados conexModCarro = new ConexaoBancodeDados();
    
    @Override
    public void salvar(){
        
        buscarCliente();
        buscarModeloCarro();
        
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into locacao_carro(id_cliente,id_carro,data_inicio,data_termino,observacoes,dias,valor,situacao) values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, this.getCodCliente());
            pst.setInt(2, this.getCodModeloCarro());
            pst.setDate(3, new java.sql.Date(this.getDataInicio().getTime()));
            pst.setDate(4, new java.sql.Date(this.getDataTermino().getTime()));
            pst.setString(5, this.getObservacoes());
            pst.setString(6, this.getDias());
            pst.setString(7, this.getValor());
            pst.setString(8, this.getSituacao());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Locação realizada com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar Locação. " + ex);
        }
        
        alterarStatus(false);
        
        conex.desconecta();
        
        
    }
    
    @Override
    public void buscarCliente(){
        
        conexCliente.conexao();
        conexCliente.executaSql("select *from cliente where nome='" + this.getCliente() + "'");
        try {
            conexCliente.rs.first();
            this.setCodCliente(conexCliente.rs.getInt("id_client"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Cliente não encontrado. " + ex);
        }
        conexCliente.desconecta();
        
    }
    
    public void buscarModeloCarro(){
        
       conexModCarro.conexao();
        conexModCarro.executaSql("select *from carro where modelo='" + modeloCarro + "'");
        try {
            conexModCarro.rs.first();
            this.codModeloCarro = conexModCarro.rs.getInt("id_car");
            this.setPlaca(conexModCarro.rs.getString("placa"));
            this.setPreco(conexModCarro.rs.getString("preco"));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Carro não encontrado!");
        }
        conexModCarro.desconecta();   
        
    }
    
    @Override
    public void alterarStatus(boolean flag){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update carro set status=? where id_car=?");
            if (flag == true){
                pst.setString(1, "Disponível");
            }else{
                pst.setString(1, "Indisponível");
            }
            pst.setInt(2, this.codModeloCarro);
            pst.execute();

            //JOptionPane.showMessageDialog(null, "Locação finalizada com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Erro na alteração dos dados!/nErro:" + ex.getMessage());
        }
        conex.desconecta();
    
    }
    
    @Override
    public void alterarLocacao(boolean flag){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update locacao_carro set situacao=? where id=?");
            if (flag == true){
                pst.setString(1, "Finalizada");
            }else{
                pst.setString(1, "Finalizada");
            }
            pst.setInt(2, this.getLocacaoCod());
            pst.execute();

            //JOptionPane.showMessageDialog(null, "Locação finalizada com sucesso!");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!/nErro:" + ex.getMessage());
        }
        conex.desconecta();
    
    }
    
    @Override
    public void excluir(){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from locacao_carro where id=?");
            pst.setInt(1, this.getLocacaoCod());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Locação excluida com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir locação:\n" + ex.getMessage());
        }
        conex.desconecta();
    }
    
    
    //Gets e Sets
    public int getCodModeloCarro() {
        return codModeloCarro;
    }

    public void setCodModeloCarro(int codModeloCarro) {
        this.codModeloCarro = codModeloCarro;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

}
