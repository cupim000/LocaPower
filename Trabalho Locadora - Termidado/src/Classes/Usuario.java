package Classes;

import controle.ConexaoBancodeDados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usuario {
    
    ConexaoBancodeDados conex = new ConexaoBancodeDados();
    
    //Atributos
    private Integer codigo;
    private String nome;
    private String tipo;
    private String senha;
    private String pesquisa;
    
    //Métodos
    public void salvar (){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into usuario(nome,senha,tipo) values(?,?,?)");
            pst.setString(1, this.getNome());
            pst.setString(2, this.getSenha());
            pst.setString(3, this.getTipo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Usuário inserido com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir usuário!/nErro:" + ex.getMessage());
        }
        conex.desconecta();
    }
    
    public boolean buscar(){
        conex.conexao();
        conex.executaSql("select *from usuario where nome like'%" + this.getPesquisa() + "%'");
        try {
            conex.rs.first();
            this.setNome(conex.rs.getString("nome"));
            this.setSenha(conex.rs.getString("senha"));
            this.setTipo(conex.rs.getString("tipo"));
            this.setCodigo(conex.rs.getInt("id"));
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");
            conex.desconecta();
            return false;
        }
        
        conex.desconecta();
        return true;
    }
    
    public void alterar(){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update usuario set nome=?,tipo=?,senha=? where id=?");
            pst.setString(1, this.getNome());
            pst.setString(2, this.getTipo());
            pst.setString(3, this.getSenha());
            pst.setInt(4, this.getCodigo());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro Erro na alteração usuário!/nErro:" + ex.getMessage());
        }
        conex.desconecta();
    }
    
    public void excluir(){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from usuario where id=?");
            pst.setInt(1, this.getCodigo());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados:\n" + ex.getMessage());
        }
        conex.desconecta();
    }
    
    //Gets e Sets
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
}
