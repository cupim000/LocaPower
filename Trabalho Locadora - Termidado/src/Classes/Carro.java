package Classes;
import controle.ConexaoBancodeDados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Carro extends Veiculo {
     ConexaoBancodeDados conex = new ConexaoBancodeDados();
     
     private String cambio;
     private String portas;

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public String getPortas() {
        return portas;
    }

    public void setPortas(String portas) {
        this.portas = portas;
    }
     
    //Métodos       
    @Override
    public void salvar (){
        conex.conexao();
        try {
            
            PreparedStatement pst = conex.con.prepareStatement("insert into carro(fabricante,modelo,ano,cor,combustivel,cambio,placa,quilometragem,potencia,portas,preco,status) values(?,?,?,?,?,?,?,?,?,?,?,?)");
            
            pst.setString(1, this.getFabricante());
            pst.setString(2, this.getModelo());
            pst.setString(3, this.getAno());
            pst.setString(4, this.getCor());
            pst.setString(5, this.getCombustivel());
            pst.setString(6, this.getCambio());
            pst.setString(7, this.getPlaca());
            pst.setString(8, this.getQuilometragem());
            pst.setString(9, this.getPotencia());
            pst.setString(10, this.getPortas());
            pst.setString(11, this.getPreco());
            pst.setString(12, this.getStatus());
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
        conex.executaSql("select *from carro where modelo like'%" + this.getPesquisa() + "%'");
        try {
            conex.rs.first();
            this.setFabricante(conex.rs.getString("fabricante"));
            this.setModelo(conex.rs.getString("modelo"));
            this.setAno(conex.rs.getString("ano"));
            this.setCor(conex.rs.getString("cor"));
            this.setCombustivel(conex.rs.getString("combustivel"));
            this.setCambio(conex.rs.getString("cambio"));
            this.setPlaca(conex.rs.getString("placa"));
            this.setQuilometragem(conex.rs.getString("quilometragem"));
            this.setPotencia(conex.rs.getString("potencia"));
            this.setPortas(conex.rs.getString("portas"));
            this.setPreco(conex.rs.getString("preco"));
            this.setCodigo(conex.rs.getInt("id_car"));
            this.setStatus(conex.rs.getString("status"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Carro não cadastrado!");
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
            PreparedStatement pst = conex.con.prepareStatement("update carro set fabricante=?,modelo=?,ano=?,cor=?,combustivel=?,cambio=?,placa=?,quilometragem=?,potencia=?,portas=?,preco=? where id_car=?");
            pst.setString(1, this.getFabricante());
            pst.setString(2, this.getModelo());
            pst.setString(3, this.getAno());
            pst.setString(4, this.getCor());
            pst.setString(5, this.getCombustivel());
            pst.setString(6, this.getCambio());
            pst.setString(7, this.getPlaca());
            pst.setString(8, this.getQuilometragem());
            pst.setString(9, this.getPotencia());
            pst.setString(10, this.getPortas());
            pst.setString(11, this.getPreco());
            pst.setInt(12, this.getCodigo());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Erro na alteração dos dados!/nErro:" + ex.getMessage());
        }
        conex.desconecta();
    }
    
    public void excluir(){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from carro where id_car=?");
            pst.setInt(1, this.getCodigo());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados:\n" + ex.getMessage());
        }
        conex.desconecta();
    }
}
