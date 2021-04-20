/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import Classes.ModeloTabela;
import Classes.Moto;
import controle.ConexaoBancodeDados;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CadastroMoto extends javax.swing.JFrame {
    
     ConexaoBancodeDados conex = new ConexaoBancodeDados();
     Moto moto = new Moto();
     private int flag = 0;

 
    public CadastroMoto() {
        initComponents();
        preencherTabela("select *from moto order by modelo");
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldFabricante = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldCor = new javax.swing.JTextField();
        jTextFieldQuilometragem = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonNova = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMotos = new javax.swing.JTable();
        jButtonPesquisa = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jFormattedTextAno = new javax.swing.JFormattedTextField();
        jFormattedPlaca = new javax.swing.JFormattedTextField();
        jComboBoxCombustivel = new javax.swing.JComboBox<>();
        jTextFieldPotencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jLabel11.setText("jLabel11");

        jLabel12.setText("jLabel12");

        jLabel13.setText("jLabel13");

        jLabel14.setText("jLabel14");

        jLabel15.setText("jLabel15");

        jLabel16.setText("jLabel16");

        jLabel17.setText("jLabel17");

        jButton6.setText("jButton6");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Fabricante:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Modelo:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Ano de Fabricação:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Cor:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Combustível:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Número da Placa:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Quilometragem(km):");

        jTextFieldFabricante.setEnabled(false);

        jTextFieldModelo.setEnabled(false);

        jTextFieldCor.setEnabled(false);

        jTextFieldQuilometragem.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Potência(cc):");

        jButtonCancelar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonEditar.setText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonNova.setText("Novo");
        jButtonNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovaActionPerformed(evt);
            }
        });

        jButtonExcluir.setText("Excluir");
        jButtonExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirActionPerformed(evt);
            }
        });

        jButtonSalvar.setText("Salvar");
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jTableMotos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableMotos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMotosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMotos);

        jButtonPesquisa.setText("Pesquisar");
        jButtonPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisaActionPerformed(evt);
            }
        });

        try {
            jFormattedTextAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextAno.setEnabled(false);

        jFormattedPlaca.setEnabled(false);

        jComboBoxCombustivel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBoxCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Álcool", "Flex" }));
        jComboBoxCombustivel.setEnabled(false);

        jTextFieldPotencia.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Preço:");

        jTextFieldPreco.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel18.setText("ID:");

        jTextFieldCode.setEnabled(false);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel19.setText("Status:");

        jTextFieldStatus.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldFabricante, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(jTextFieldCor)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBoxCombustivel, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextAno))))
                            .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonNova, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPreco)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel19)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonPesquisa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 727, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBoxCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNova)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonPesquisa)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("CADASTRO DE MOTOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(314, 314, 314)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(878, 673));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ablitarCampos(boolean aux){
        //Bloqueando/Liberando Campos e Botões
        jTextFieldFabricante.setEnabled(aux);
        jTextFieldModelo.setEnabled(aux);
        jFormattedTextAno.setEnabled(aux);
        jTextFieldCor.setEnabled(aux);
        jComboBoxCombustivel.setEnabled(aux);
        jTextFieldPotencia.setEnabled(aux);
        jFormattedPlaca.setEnabled(aux);        
        jTextFieldQuilometragem.setEnabled(aux);
        jTextFieldPreco.setEnabled(aux);
        
    }
    
    private void limparCampos(){
        //Limpa os compos digitados
        jTextFieldFabricante.setText("");
        jTextFieldModelo.setText("");
        jFormattedTextAno.setText("");
        jTextFieldCor.setText("");
        jTextFieldPotencia.setText("");
        jFormattedPlaca.setText("");
        jTextFieldQuilometragem.setText("");
        jTextFieldPreco.setText("");
    }
    
    private boolean pesquisarMoto(String nome){
        boolean aux;
        moto.setPesquisa(nome);
        aux = moto.buscar();
        if (!aux) {
            return false;
        }
        jTextFieldFabricante.setText(String.valueOf(moto.getFabricante()));
        jTextFieldModelo.setText(String.valueOf(moto.getModelo() ));
        jFormattedTextAno.setText(String.valueOf(moto.getAno()));
        jTextFieldPotencia.setText(String.valueOf(moto.getPotencia()));
        jFormattedPlaca.setText(String.valueOf(moto.getPlaca()));
        jTextFieldQuilometragem.setText(String.valueOf(moto.getQuilometragem()));
        jComboBoxCombustivel.setSelectedItem(String.valueOf(moto.getCombustivel()));
        jTextFieldPreco.setText(String.valueOf(moto.getPreco()));
        jTextFieldCor.setText(String.valueOf(moto.getCor()));
        jTextFieldCode.setText(String.valueOf(moto.getCodigo()));
        jTextFieldStatus.setText(String.valueOf(moto.getStatus()));
       
        
        ablitarCampos(false);
        
        //Modificando botões
        jButtonEditar.setEnabled(true);
        jButtonNova.setEnabled(true);
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonExcluir.setEnabled(true);
        
        return true;
    }
    
    private void preencherTabela(String sql){
        ArrayList dadosMoto = new ArrayList();
        String [] colunas = new String [] {"ID","Fabricante","Modelo","Ano","Cor","Combustível","Potência","Placa","Quilometragem", "Preço (R$)","Status"};
        conex.conexao();
        conex.executaSql(sql);
        
        try {
            conex.rs.first();
            do{
                dadosMoto.add(new Object[] {conex.rs.getInt("id_mot"),conex.rs.getString("fabricante"),conex.rs.getString("modelo"),conex.rs.getString("ano"),conex.rs.getString("cor"),conex.rs.getString("combustivel"),conex.rs.getString("potencia"),conex.rs.getString("placa"),conex.rs.getString("quilometragem"), conex.rs.getString("preco"),conex.rs.getString("status")});
            }while(conex.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane,"Busque por um nova Moto para preencher a tabela.");
            return;
        }
        ModeloTabela modelo = new ModeloTabela(dadosMoto, colunas);
        jTableMotos.setModel(modelo);
        
        //Tamanho das colunas na tabela
      
        jTableMotos.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableMotos.getColumnModel().getColumn(0).setResizable(false);
        jTableMotos.getColumnModel().getColumn(1).setPreferredWidth(110);
        jTableMotos.getColumnModel().getColumn(1).setResizable(false);
        jTableMotos.getColumnModel().getColumn(2).setPreferredWidth(110);
        jTableMotos.getColumnModel().getColumn(2).setResizable(false);
        jTableMotos.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTableMotos.getColumnModel().getColumn(3).setResizable(false);
        jTableMotos.getColumnModel().getColumn(4).setPreferredWidth(110);
        jTableMotos.getColumnModel().getColumn(4).setResizable(false);
        jTableMotos.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTableMotos.getColumnModel().getColumn(5).setResizable(false);
        jTableMotos.getColumnModel().getColumn(6).setPreferredWidth(90);
        jTableMotos.getColumnModel().getColumn(6).setResizable(false);
        jTableMotos.getColumnModel().getColumn(7).setPreferredWidth(90);
        jTableMotos.getColumnModel().getColumn(7).setResizable(false);
        jTableMotos.getColumnModel().getColumn(8).setPreferredWidth(110);
        jTableMotos.getColumnModel().getColumn(8).setResizable(false);
        jTableMotos.getColumnModel().getColumn(9).setPreferredWidth(110);
        jTableMotos.getColumnModel().getColumn(9).setResizable(false);
        jTableMotos.getColumnModel().getColumn(10).setPreferredWidth(110);
        jTableMotos.getColumnModel().getColumn(10).setResizable(false);


        
        jTableMotos.getTableHeader().setReorderingAllowed(false);
        jTableMotos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableMotos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conex.desconecta();
    }
    
    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
         //Altera modo de salvar
        flag = 2;
        
        ablitarCampos(true);
        
        //Modificando botões
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonNova.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        jButtonPesquisa.setEnabled(false);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(jTextFieldFabricante.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Fabricante da moto para continuar!");
            jTextFieldFabricante.requestFocus();
        }else if("  /  /    ".equals(jFormattedTextAno.getText())){
            JOptionPane.showMessageDialog(null, "Preencha o Modelo da Moto para continuar!");
            jFormattedTextAno.requestFocus();
        }else if(jFormattedTextAno.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o ano de fabricação da Moto para continuar!");
            jFormattedTextAno.requestFocus();
        }else if(jTextFieldCor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a cor da Moto para continuar!");
            jTextFieldCor.requestFocus();
        }else if(jTextFieldPotencia.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a Potência para continuar!");
            jTextFieldPotencia.requestFocus();
        }else if(jFormattedPlaca.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a Placa da Moto para continuar!");
            jFormattedPlaca.requestFocus();
        }else if(jTextFieldQuilometragem.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a quilometragem da Moto para continuar!");
            jTextFieldQuilometragem.requestFocus();
        }else if(jTextFieldPreco.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o preço de locação da Moto para continuar!");
            jTextFieldPreco.requestFocus();
        
        }else{
            
            moto.setFabricante(jTextFieldFabricante.getText());
            moto.setModelo(jTextFieldModelo.getText());
            moto.setAno(jFormattedTextAno.getText());
            moto.setCor(jTextFieldCor.getText());
            moto.setCombustivel(jComboBoxCombustivel.getSelectedItem().toString());
            moto.setPotencia(jTextFieldPotencia.getText());
            moto.setPlaca(jFormattedPlaca.getText());
            moto.setQuilometragem(jTextFieldQuilometragem.getText());
            moto.setPreco(jTextFieldPreco.getText());
            
            
            if(flag == 1){
                moto.setStatus("Disponível");
                moto.salvar();
            }else{
                moto.setCodigo(Integer.parseInt(jTextFieldCode.getText()));
                moto.editar();
            }


            limparCampos();
            ablitarCampos(false);

            //Modifica botões
            jButtonSalvar.setEnabled(false);
            jButtonNova.setEnabled(true);
            jButtonCancelar.setEnabled(false);
            jButtonPesquisa.setEnabled(true);
            jTextFieldPesquisa.setEnabled(true);
            
            preencherTabela("select *from moto order by modelo");

        }
                             
    }//GEN-LAST:event_jButtonSalvarActionPerformed

    private void jButtonNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovaActionPerformed
        //Altera modo de salvar
        flag = 1;
        
        limparCampos();
        ablitarCampos(true);
        
        //Modificando botões
        jButtonCancelar.setEnabled(true);
        jButtonSalvar.setEnabled(true);
        jButtonNova.setEnabled(false);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisa.setEnabled(false);
        jButtonPesquisa.setEnabled(false);
    }//GEN-LAST:event_jButtonNovaActionPerformed

    private void jButtonPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisaActionPerformed
        boolean encontrado;
        String nome = jTextFieldPesquisa.getText();
        encontrado = pesquisarMoto(nome);
        if(!encontrado){
            limparCampos();
        }
        
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        
        preencherTabela("select *from moto where modelo like'%" + moto.getPesquisa() + "%'");
        
    }//GEN-LAST:event_jButtonPesquisaActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        //Bloqueando Campos 
        ablitarCampos(false);
        limparCampos();
        
        //Modificando Botões
        jButtonCancelar.setEnabled(false);
        jButtonSalvar.setEnabled(false);
        jButtonNova.setEnabled(true);
        jButtonEditar.setEnabled(false);
        jButtonExcluir.setEnabled(false);
        jTextFieldPesquisa.setEnabled(true);
        jButtonPesquisa.setEnabled(true);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        int resposta = 0;
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?");
        if (resposta == JOptionPane.YES_OPTION){
            moto.setCodigo(Integer.parseInt(jTextFieldCode.getText()));
            moto.excluir();
        }
        
        limparCampos();
        preencherTabela("select *from moto order by modelo");
        
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableMotosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMotosMouseClicked
        String nome = (String) jTableMotos.getValueAt(jTableMotos.getSelectedRow(), 2);
        pesquisarMoto(nome);
    }//GEN-LAST:event_jTableMotosMouseClicked

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
            java.util.logging.Logger.getLogger(CadastroMoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroMoto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNova;
    private javax.swing.JButton jButtonPesquisa;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCombustivel;
    private javax.swing.JFormattedTextField jFormattedPlaca;
    private javax.swing.JFormattedTextField jFormattedTextAno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMotos;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldCor;
    private javax.swing.JTextField jTextFieldFabricante;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldPotencia;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQuilometragem;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
