
package Classes;

import controle.ConexaoBancodeDados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Moto extends Veiculo {
    ConexaoBancodeDados conex = new ConexaoBancodeDados();
    
    //Métodos       
    @Override
    public void salvar (){
        conex.conexao();
        try {
            
            PreparedStatement pst = conex.con.prepareStatement("insert into moto(fabricante,modelo,ano,cor,combustivel,potencia,placa,quilometragem,preco,status) values(?,?,?,?,?,?,?,?,?,?)");
            
            pst.setString(1, this.getFabricante());
            pst.setString(2, this.getModelo());
            pst.setString(3, this.getAno());
            pst.setString(4, this.getCor());
            pst.setString(5, this.getCombustivel());
            pst.setString(6, this.getPotencia());
            pst.setString(7, this.getPlaca());
            pst.setString(8, this.getQuilometragem());
            pst.setString(9, this.getPreco());
            pst.setString(10, this.getStatus());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir dados!/nErro:" + ex.getMessage());
        }
        conex.desconecta();
    }
    
    @Override
    public boolean buscar(){
        conex.conexao();
        conex.executaSql("select *from moto where modelo like'%" + this.getPesquisa() + "%'");
        try {
            conex.rs.first();
            this.setFabricante(conex.rs.getString("fabricante"));
            this.setModelo(conex.rs.getString("modelo"));
            this.setAno(conex.rs.getString("ano"));
            this.setCor(conex.rs.getString("cor"));
            this.setCombustivel(conex.rs.getString("combustivel"));
            this.setPotencia(conex.rs.getString("potencia"));
            this.setPlaca(conex.rs.getString("placa"));
            this.setQuilometragem(conex.rs.getString("quilometragem"));
            this.setPreco(conex.rs.getString("preco"));
            this.setCodigo(conex.rs.getInt("id_mot"));
            this.setStatus("status");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Moto não cadastrada!");
            conex.desconecta();
            return false;
        }
        
        conex.desconecta();
        return true;
    }
    
    @Override
    public void editar(){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update moto set fabricante=?,modelo=?,ano=?,cor=?,combustivel=?,potencia=?,placa=?,quilometragem=?,preco=? where id_mot=?");
            pst.setString(1, this.getFabricante());
            pst.setString(2, this.getModelo());
            pst.setString(3, this.getAno());
            pst.setString(4, this.getCor());
            pst.setString(5, this.getCombustivel());
            pst.setString(6, this.getPotencia());
            pst.setString(7, this.getPlaca());
            pst.setString(8, this.getQuilometragem());
            pst.setString(9, this.getPreco());
            pst.setInt(10, this.getCodigo());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!/nErro:" + ex.getMessage());
        }
        conex.desconecta();
    }
    
    public void excluir(){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from moto where id_mot=?");
            pst.setInt(1, this.getCodigo());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados:\n" + ex.getMessage());
        }
        conex.desconecta();
    }
    
    
}
