/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import Classes.Cliente;
import controle.ConexaoBancodeDados;
import Classes.ModeloTabela;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author ABRAAO
 */
public class CadastroCliente extends javax.swing.JFrame {
    
        Cliente client = new Cliente();
        ConexaoBancodeDados conex = new ConexaoBancodeDados();
        private  int flag = 0;
        
    public CadastroCliente() {
        initComponents();
        preencherTabela("select *from cliente order by nome");
    }

    private void ablitarCampos(boolean aux){
        //Bloqueando/Liberando Campos e Botões
        jTextFieldNome.setEnabled(aux);
        jFormattedTextFieldNascimento.setEnabled(aux);
        jTextFieldRua.setEnabled(aux);
        jTextFieldNumero.setEnabled(aux);
        jTextFieldCep.setEnabled(aux);
        jTextFieldComplemento.setEnabled(aux);
        jTextFieldBairro.setEnabled(aux);        
        jFormattedTextCpf.setEnabled(aux);
        jComboBoxSexo.setEnabled(aux);
        jFormattedTextTelefone.setEnabled(aux);
        jTextFieldEmail.setEnabled(aux);
       
    }
    
    private void limparCampos(){
        //Limpa os compos digitados
        jTextFieldNome.setText("");
        jFormattedTextFieldNascimento.setText("");
        jTextFieldRua.setText("");
        jTextFieldNumero.setText("");
        jTextFieldCep.setText("");
        jTextFieldComplemento.setText("");
        jTextFieldBairro.setText("");
        jFormattedTextCpf.setText("");
        jFormattedTextTelefone.setText("");
        jTextFieldEmail.setText("");
        jTextId.setText("");
        
    }
    
    private boolean pesquisarCliente(String nome){
        boolean aux;
        client.setPesquisa(nome);
        aux = client.buscar();
        if(!aux){
            return false;
        }
        jTextFieldNome.setText(String.valueOf(client.getNome()));
        jFormattedTextFieldNascimento.setText(String.valueOf(client.getDataNascimento()));
        jTextFieldRua.setText(String.valueOf(client.getRua()));
        jTextFieldNumero.setText(String.valueOf(client.getNumero()));
        jTextFieldCep.setText(String.valueOf(client.getCep()));
        jTextFieldComplemento.setText(String.valueOf(client.getComplemento()));
        jTextFieldBairro.setText(String.valueOf(client.getBairro()));
        jFormattedTextCpf.setText(String.valueOf(client.getCpf()));
        jFormattedTextTelefone.setText(String.valueOf(client.getTelefone()));
        jTextFieldEmail.setText(String.valueOf(client.getEmail()));
        jComboBoxSexo.setSelectedItem(String.valueOf(client.getSexo()));
        jTextId.setText(String.valueOf(String.valueOf(client.getCodigo())));    
                 
        ablitarCampos(false);
        
        //Modificando botões
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        
        return true;
    }
    
    
    private void preencherTabela(String sql){
        
        ArrayList dadoscli = new ArrayList();
        String [] colunas = new String [] {"ID","Nome","Nascimento","CPF","Sexo","Telefone","Email"};
        conex.conexao();
        conex.executaSql(sql);
        
        try {
            conex.rs.first();
            do{
                dadoscli.add(new Object[] {conex.rs.getInt("id_client"),conex.rs.getString("nome"),conex.rs.getString("nascimento"),conex.rs.getString("cpf"),conex.rs.getString("sexo"),conex.rs.getString("telefone"),conex.rs.getString("email")});
            }while(conex.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane,"Busque por um novo cliente para preencher a tabela.");
        }
        ModeloTabela modelo = new ModeloTabela(dadoscli, colunas);
        jTableClientes.setModel(modelo);
        
        //Tamanho das colunas na tabela
      
        jTableClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableClientes.getColumnModel().getColumn(0).setResizable(false);
        jTableClientes.getColumnModel().getColumn(1).setPreferredWidth(185);
        jTableClientes.getColumnModel().getColumn(1).setResizable(false);
        jTableClientes.getColumnModel().getColumn(2).setPreferredWidth(90);
        jTableClientes.getColumnModel().getColumn(2).setResizable(false);
        jTableClientes.getColumnModel().getColumn(3).setPreferredWidth(120);
        jTableClientes.getColumnModel().getColumn(3).setResizable(false);
        jTableClientes.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTableClientes.getColumnModel().getColumn(4).setResizable(false);
        jTableClientes.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTableClientes.getColumnModel().getColumn(5).setResizable(false);
        jTableClientes.getColumnModel().getColumn(6).setPreferredWidth(180);
        jTableClientes.getColumnModel().getColumn(6).setResizable(false);
        
        jTableClientes.getTableHeader().setReorderingAllowed(false);
        jTableClientes.setAutoResizeMode(jTableClientes.AUTO_RESIZE_OFF);
        jTableClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conex.desconecta();
    }
        
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jComboBoxSexo = new javax.swing.JComboBox<>();
        jFormattedTextCpf = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jButtonNovo = new javax.swing.JButton();
        jFormattedTextFieldNascimento = new javax.swing.JFormattedTextField();
        jFormattedTextTelefone = new javax.swing.JFormattedTextField();
        jTextId = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldRua = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldCep = new javax.swing.JTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldEmail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Data de Nascimento:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("CPF:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Sexo:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Celular:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("E-mail:");

        jButtonCancelar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonSalvar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        jButtonEditar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonExcluir.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonExcluir.setText("Excluir");
        jButtonExcluir.setEnabled(false);
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonPesquisar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));

        try {
            jFormattedTextCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextCpf.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("ID:");

        jButtonNovo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldNascimento.setEnabled(false);

        try {
            jFormattedTextTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextTelefone.setEnabled(false);

        jTextId.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Endereço"));

        jLabel5.setText("Rua:");

        jLabel10.setText("Número:");

        jLabel11.setText("CEP:");

        jLabel12.setText("Complemento:");

        jLabel13.setText("Bairro:");

        jTextFieldRua.setEnabled(false);

        jTextFieldBairro.setEnabled(false);

        jTextFieldNumero.setEnabled(false);

        jTextFieldCep.setEnabled(false);

        jTextFieldComplemento.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldRua)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldComplemento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTextFieldNome.setEnabled(false);

        jTextFieldEmail.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldEmail)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(9, 9, 9)
                                .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextFieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisar)))))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jFormattedTextFieldNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)
                        .addComponent(jTextId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jFormattedTextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jFormattedTextTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalvar)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisar)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("CADASTRO DE CLIENTES");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(942, 624));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        
        //Bloqueando Campos 
        ablitarCampos(false);
        limparCampos();
        
        //Modificando Botões
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonNovo.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisar.setEnabled(true);
        jButtonPesquisar.setEnabled(true);
        
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(jTextFieldNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Nome do cliente para continuar!");
            jTextFieldNome.requestFocus();
        }else if("  /  /    ".equals(jFormattedTextFieldNascimento.getText())){
            JOptionPane.showMessageDialog(null, "Preencha a Data de Nascimento do cliente para continuar!");
            jFormattedTextFieldNascimento.requestFocus();
        }else if(jTextFieldRua.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Rua do funcionário para continuar!");
            jTextFieldRua.requestFocus();
        }else if(jTextFieldNumero.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Número do funcionário para continuar!");
            jTextFieldNumero.requestFocus();
        }else if(jTextFieldCep.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o CEP do funcionário para continuar!");
            jTextFieldCep.requestFocus();
        }else if(jTextFieldBairro.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Bairro do funcionário para continuar!");
            jTextFieldBairro.requestFocus();
        }else if("   .   .   -  ".equals(jFormattedTextCpf.getText())){
            JOptionPane.showMessageDialog(null, "Preencha o CPF do cliente para continuar!");
            jFormattedTextCpf.requestFocus();
        }else if("(  )      -    ".equals(jFormattedTextTelefone.getText())){
            JOptionPane.showMessageDialog(null, "Preencha o Celular do cliente para continuar!");
            jFormattedTextTelefone.requestFocus();
        }else if(jTextFieldEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Email do cliente para continuar!");
            jTextFieldEmail.requestFocus();
        
        }else{
            
            client.setNome(jTextFieldNome.getText());
            client.setDataNascimento(jFormattedTextFieldNascimento.getText());
            client.setRua(jTextFieldRua.getText());
            client.setNumero(jTextFieldNumero.getText());
            client.setCep(jTextFieldCep.getText());
            client.setComplemento(jTextFieldComplemento.getText());
            client.setBairro(jTextFieldBairro.getText());
            client.setCpf(jFormattedTextCpf.getText());
            client.setSexo(jComboBoxSexo.getSelectedItem().toString());
            client.setTelefone(jFormattedTextTelefone.getText());
            client.setEmail(jTextFieldEmail.getText());
            
            
            
            if(flag == 1){
                //Salvando no banco de dados
                client.salvar();
            }else{
                client.setCodigo(Integer.parseInt(jTextId.getText()));
                client.editar();
            }


            limparCampos();
            ablitarCampos(false);

            //Modifica botões
            jButtonSalvar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jButtonCancelar.setEnabled(false);
            jTextFieldPesquisar.setEnabled(true);
            jTextFieldPesquisar.setEnabled(true);
            
            preencherTabela("select *from cliente order by nome");

        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        
        boolean encontrado;
        String nome = jTextFieldPesquisar.getText();
        encontrado = pesquisarCliente(nome);
        if(!encontrado){
            limparCampos();
        }
        
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        
        preencherTabela("select *from cliente where nome like'%" + client.getPesquisa() + "%'");
        
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?");
        if (resposta == JOptionPane.YES_OPTION){
            client.setCodigo(Integer.parseInt(jTextId.getText()));
            client.excluir();
        }
        
        limparCampos();
        preencherTabela("select *from cliente order by nome");
        
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        //Altera modo de salvar
        flag = 1;
        
        limparCampos();
        ablitarCampos(true);
        
        //Modificando botões
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisar.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
        
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        
        String nome = (String) jTableClientes.getValueAt(jTableClientes.getSelectedRow(), 1);
        pesquisarCliente(nome);
            
    }//GEN-LAST:event_jTableClientesMouseClicked

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
                
        //Altera modo de salvar
        flag = 2;
        
        ablitarCampos(true);
        
        //Modificando botões
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonNovo.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisar.setEnabled(false);
        jButtonPesquisar.setEnabled(false);
        
    }//GEN-LAST:event_jButtonEditarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new CadastroCliente().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxSexo;
    private javax.swing.JFormattedTextField jFormattedTextCpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldNascimento;
    private javax.swing.JFormattedTextField jFormattedTextTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCep;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JTextField jTextId;
    // End of variables declaration//GEN-END:variables

}
