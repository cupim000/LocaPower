/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.*;
import javax.swing.JOptionPane;

 
public class ConexaoBancodeDados {
    public Statement stm;  //Realizar pesquisa no banco de dados
    public ResultSet rs;  //Armazenar resultado da pesquisa
    public Connection con;  //Conexao com banco de dados
    private final String driver = "org.postgreesql.Driver";  //Identificar serviço
    private final String caminho = "jdbc:postgresql://localhost:5432/LocafacilVeiculos";  //Onde banco de dados esta alocado
    private final String usuario = "postgres";  //Usuário banco de dados
    private final String senha = "a01d02b03";  //Senha bano de dados
    
    public void conexao(){ //Metodo que realiza a conexao com o banco de dados
        
        try {
            System.setProperty("jdbc.Drivers", driver);  //Setar a propriedade do driver de conexao
            this.con = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null,"Conexao efetuada com sucesso!"); 
    
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao se conectar com o banco de dados:\n"+ex.getMessage() );
        }
    }
    
    public void executaSql(String sql){
        try {
            this.stm = this.con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            this.rs = this.stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao execultar sql:\n"+ex.getMessage() );
        }
    }
    
    public void desconecta (){ // Metodo que realiza a desconecção com o banco de dados
        try {
            this.con.close();
             //JOptionPane.showMessageDialog(null,"Banco de dados Desconectado com Sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao fechar conexao com banco de dados:\n"+ex.getMessage());
        }
    }
}
