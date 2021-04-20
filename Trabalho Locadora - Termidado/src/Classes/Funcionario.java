package Classes;

import controle.ConexaoBancodeDados;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Funcionario extends Pessoa{
    
    ConexaoBancodeDados conex = new ConexaoBancodeDados();

    //Atributos
        private int salario;
        private String funcao;
        
    //Métodos
        
    @Override
    public void salvar (){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into funcionario(nome,nascimento,cpf,sexo,telefone,email,salario,funcao,rua,numero,cep,complemento,bairro) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, this.getNome());
            pst.setString(2, this.getDataNascimento());
            pst.setString(3, this.getCpf());
            pst.setString(4, this.getSexo());
            pst.setString(5, this.getTelefone());
            pst.setString(6, this.getEmail());
            pst.setInt(7, this.getSalario());
            pst.setString(8, this.getFuncao());
            pst.setString(9, this.getRua());
            pst.setString(10, this.getNumero());
            pst.setString(11, this.getCep());
            pst.setString(12, this.getComplemento());
            pst.setString(13, this.getBairro());
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
        conex.executaSql("select *from funcionario where nome like'%" + this.getPesquisa() + "%'");
        try {
            conex.rs.first();
            this.setNome(conex.rs.getString("nome"));
            this.setDataNascimento(conex.rs.getString("nascimento"));
            this.setCpf(conex.rs.getString("cpf"));
            this.setTelefone(conex.rs.getString("telefone"));
            this.setEmail(conex.rs.getString("email"));
            this.setSalario(conex.rs.getInt("salario"));
            this.setFuncao(conex.rs.getString("funcao"));
            this.setSexo(conex.rs.getString("sexo"));
            this.setCodigo(conex.rs.getInt("id"));
            this.setRua(conex.rs.getString("rua"));
            this.setNumero(conex.rs.getString("numero"));
            this.setCep(conex.rs.getString("cep"));
            this.setComplemento(conex.rs.getString("complemento"));
            this.setBairro(conex.rs.getString("bairro"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Funcionario não cadastrado!");
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
            PreparedStatement pst = conex.con.prepareStatement("update funcionario set nome=?,nascimento=?,cpf=?,sexo=?,telefone=?,email=?,salario=?,funcao=?,rua=?,numero=?,cep=?,complemento=?,bairro=? where id=?");
             pst.setString(1, this.getNome());
            pst.setString(2, this.getDataNascimento());
            pst.setString(3, this.getCpf());
            pst.setString(4, this.getSexo());
            pst.setString(5, this.getTelefone());
            pst.setString(6, this.getEmail());
            pst.setInt(7, this.getSalario());
            pst.setString(8, this.getFuncao());
            pst.setString(9, this.getRua());
            pst.setString(10, this.getNumero());
            pst.setString(11, this.getCep());
            pst.setString(12, this.getComplemento());
            pst.setString(13, this.getBairro());
            pst.setInt(14, this.getCodigo());
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
            PreparedStatement pst = conex.con.prepareStatement("delete from funcionario where id=?");
            pst.setInt(1, this.getCodigo());
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Dados excluidos com sucesso!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir dados:\n" + ex.getMessage());
        }
        conex.desconecta();
    }
        
    //Gets e Sets
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
            
}
