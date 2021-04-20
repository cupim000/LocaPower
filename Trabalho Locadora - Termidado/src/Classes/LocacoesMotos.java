package Classes;

import controle.ConexaoBancodeDados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LocacoesMotos extends Locacoes {
    
    //Atributos
    private int codModeloMoto;
    private String modeloMoto;
    
    //Métodos
    ConexaoBancodeDados conex = new ConexaoBancodeDados();
    ConexaoBancodeDados conexCliente = new ConexaoBancodeDados();
    ConexaoBancodeDados conexModMoto = new ConexaoBancodeDados();
    
    @Override
    public void salvar(){
        
        buscarCliente();
        buscarModeloMoto();
        
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into locacao_moto (id_cliente,id_moto,data_inicio,data_termino,observacoes,dias,valor,situacao) values(?,?,?,?,?,?,?,?)");
            pst.setInt(1, this.getCodCliente());
            pst.setInt(2, this.getCodModeloMoto());
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
    
    public void buscarModeloMoto(){
        
       conexModMoto.conexao();
        conexModMoto.executaSql("select *from moto where modelo='" + modeloMoto + "'");
        try {
            conexModMoto.rs.first();
            this.codModeloMoto = conexModMoto.rs.getInt("id_mot");
            this.setPlaca(conexModMoto.rs.getString("placa"));
            this.setPreco(conexModMoto.rs.getString("preco"));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null,"Moto não encontrada. " + ex);
        }
        conexModMoto.desconecta();   
        
    }
    
    @Override
    public void alterarStatus(boolean flag){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update moto set status=? where id_mot=?");
            if (flag == true){
                pst.setString(1, "Disponível");
            }else{
                pst.setString(1, "Indisponível");
            }
            pst.setInt(2, this.codModeloMoto);
            pst.execute();

            //JOptionPane.showMessageDialog(null, "Locação finalizada com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!/nErro:" + ex.getMessage());
        }
        conex.desconecta();
    
    }
    
    @Override
    public void alterarLocacao(boolean flag){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update locacao_moto set situacao=? where id=?");
            if (flag == true){
                pst.setString(1, "Locado");
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
            PreparedStatement pst = conex.con.prepareStatement("delete from locacao_moto where id=?");
            pst.setInt(1, this.getLocacaoCod());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Locação excluida com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir locação:\n" + ex.getMessage());
        }
        conex.desconecta();
    }
    
    //Gets e Sets

    public int getCodModeloMoto() {
        return codModeloMoto;
    }

    public void setCodModeloMoto(int codModeloMoto) {
        this.codModeloMoto = codModeloMoto;
    }

    public String getModeloMoto() {
        return modeloMoto;
    }

    public void setModeloMoto(String modeloMoto) {
        this.modeloMoto = modeloMoto;
    }

}
