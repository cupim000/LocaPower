/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import Classes.ModeloTabela;
import Classes.Carro;
import controle.ConexaoBancodeDados;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class CadastroCarro extends javax.swing.JFrame {

    ConexaoBancodeDados conex = new ConexaoBancodeDados();
    Carro carro = new Carro();
    private int flag = 0;
     
    public CadastroCarro() {
        initComponents();
        preencherTabela("select *from carro order by modelo");
    }
    
    private void ablitarCampos(boolean aux){
        //Bloqueando/Liberando Campos e Botões
        jTextFieldFabricante.setEnabled(aux);
        jTextFieldModelo.setEnabled(aux);
        jFormattedTextFieldAno.setEnabled(aux);
        jTextFieldCor.setEnabled(aux);
        jComboBoxCombustivel.setEnabled(aux);
        jComboBoxCambio.setEnabled(aux);
        jFormattedPlaca.setEnabled(aux);        
        jTextFieldQuilometragem.setEnabled(aux);
        jTextFieldPreco.setEnabled(aux);
        jTextFieldPotencia.setEnabled(aux);
        jComboBoxPortas.setEnabled(aux);
        
    }
    
    private void limparCampos(){
        
        //Limpa os compos digitados
        jTextFieldFabricante.setText("");
        jTextFieldModelo.setText("");
        jFormattedTextFieldAno.setText("");
        jTextFieldCor.setText("");
        jFormattedPlaca.setText("");
        jTextFieldQuilometragem.setText("");
        jTextFieldPotencia.setText("");
        jTextFieldPreco.setText("");
        jTextFieldCode.setText("");
    
    }
    
    private boolean pesquisarCarro(String nome){
        boolean aux;
        carro.setPesquisa(nome);
        aux = carro.buscar();
        if (!aux) {
            return false;
        }
        jTextFieldFabricante.setText(String.valueOf(carro.getFabricante()));
        jTextFieldModelo.setText(String.valueOf(carro.getModelo() ));
        jFormattedTextFieldAno.setText(String.valueOf(carro.getAno()));
        jTextFieldCor.setText(String.valueOf(carro.getCor()));
        jComboBoxCombustivel.setSelectedItem(String.valueOf(carro.getCombustivel()));
        jFormattedPlaca.setText(String.valueOf(carro.getPlaca()));
        jComboBoxCambio.setSelectedItem(String.valueOf(carro.getCambio()));
        jTextFieldPreco.setText(String.valueOf(carro.getPreco()));
        jTextFieldQuilometragem.setText(String.valueOf(carro.getQuilometragem()));
        jTextFieldPotencia.setText(String.valueOf(carro.getPotencia()));
        jComboBoxPortas.setSelectedItem(String.valueOf(carro.getPortas()));
        jTextFieldCode.setText(String.valueOf(carro.getCodigo()));
        jTextFieldStatus.setText(String.valueOf(carro.getStatus()));
       
        
        ablitarCampos(false);
        
        //Modificando botões
        jButtonEditar.setEnabled(true);
        jButtonNovo.setEnabled(true);
        jButtonSalvar.setEnabled(false);
        jButtonCancelar.setEnabled(false);
        jButtonExcluir.setEnabled(true);
        
        return true;
    }
    
    private void preencherTabela(String sql){
        
        ArrayList dadosCarro = new ArrayList();
        String [] colunas = new String [] {"ID","Fabricante","Modelo","Ano","Cor","Combustível","Potência","Placa","Quilometragem","Câmbio","Portas", "Preço (R$)","Status"};
        conex.conexao();
        conex.executaSql(sql);
        
        try {
            conex.rs.first();
            do{
                dadosCarro.add(new Object[] {conex.rs.getInt("id_car"),conex.rs.getString("fabricante"),conex.rs.getString("modelo"),conex.rs.getString("ano"),conex.rs.getString("cor"),conex.rs.getString("combustivel"),conex.rs.getString("potencia"),conex.rs.getString("placa"),conex.rs.getString("quilometragem"),conex.rs.getString("cambio"), conex.rs.getString("portas"), conex.rs.getString("preco"),conex.rs.getString("status")});
            }while(conex.rs.next());
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(rootPane,"Busque por um novo carro para preencher a tabela.");
            return;
        }
        ModeloTabela modelo = new ModeloTabela(dadosCarro, colunas);
        jTableCarros.setModel(modelo);
        
        //Tamanho das colunas na tabela
      
        jTableCarros.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableCarros.getColumnModel().getColumn(0).setResizable(false);
        jTableCarros.getColumnModel().getColumn(1).setPreferredWidth(210);
        jTableCarros.getColumnModel().getColumn(1).setResizable(false);
        jTableCarros.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableCarros.getColumnModel().getColumn(2).setResizable(false);
        jTableCarros.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTableCarros.getColumnModel().getColumn(3).setResizable(false);
        jTableCarros.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTableCarros.getColumnModel().getColumn(4).setResizable(false);
        jTableCarros.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTableCarros.getColumnModel().getColumn(5).setResizable(false);
        jTableCarros.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTableCarros.getColumnModel().getColumn(6).setResizable(false);
        jTableCarros.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTableCarros.getColumnModel().getColumn(7).setResizable(false);
        jTableCarros.getColumnModel().getColumn(8).setPreferredWidth(110);
        jTableCarros.getColumnModel().getColumn(8).setResizable(false);
        jTableCarros.getColumnModel().getColumn(9).setPreferredWidth(110);
        jTableCarros.getColumnModel().getColumn(9).setResizable(false);
        jTableCarros.getColumnModel().getColumn(10).setPreferredWidth(110);
        jTableCarros.getColumnModel().getColumn(10).setResizable(false);
        jTableCarros.getColumnModel().getColumn(11).setPreferredWidth(110);
        jTableCarros.getColumnModel().getColumn(11).setResizable(false);
        jTableCarros.getColumnModel().getColumn(12).setPreferredWidth(110);
        jTableCarros.getColumnModel().getColumn(12).setResizable(false);

        
        jTableCarros.getTableHeader().setReorderingAllowed(false);
        jTableCarros.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTableCarros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        conex.desconecta();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldFabricante = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldCor = new javax.swing.JTextField();
        jTextFieldQuilometragem = new javax.swing.JTextField();
        jTextFieldPotencia = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableCarros = new javax.swing.JTable();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jComboBoxCambio = new javax.swing.JComboBox<>();
        jComboBoxCombustivel = new javax.swing.JComboBox<>();
        jFormattedPlaca = new javax.swing.JFormattedTextField();
        jComboBoxPortas = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldCode = new javax.swing.JTextField();
        jFormattedTextFieldAno = new javax.swing.JFormattedTextField();
        jButtonPesquisar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jTextFieldStatus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable4);

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Frabricante:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Cor:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Modelo:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Combustível:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Ano de Fabricação:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Câmbio:");

        jButtonCancelar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonEditar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonEditar.setText("Editar");
        jButtonEditar.setEnabled(false);
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonNovo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
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

        jButtonSalvar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setEnabled(false);
        jButtonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalvarActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Número da placa:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Número de portas:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel10.setText("Quilometragem (km):");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setText("Potência (cv):");

        jTextFieldFabricante.setEnabled(false);

        jTextFieldModelo.setEnabled(false);

        jTextFieldCor.setEnabled(false);

        jTextFieldQuilometragem.setEnabled(false);

        jTextFieldPotencia.setEnabled(false);

        jTableCarros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableCarros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCarrosMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableCarros);

        jComboBoxCambio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manual", "Automático" }));
        jComboBoxCambio.setEnabled(false);

        jComboBoxCombustivel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jComboBoxCombustivel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gasolina", "Álcool", "Diesel", "Flex" }));
        jComboBoxCombustivel.setEnabled(false);

        jFormattedPlaca.setEnabled(false);

        jComboBoxPortas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "3", "4" }));
        jComboBoxPortas.setEnabled(false);

        jLabel12.setText("Preço R$:");

        jTextFieldPreco.setEnabled(false);

        jLabel13.setText("ID:");

        jTextFieldCode.setEnabled(false);

        try {
            jFormattedTextFieldAno.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldAno.setEnabled(false);

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jLabel14.setText("Status:");

        jTextFieldStatus.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jFormattedPlaca))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(jTextFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(4, 4, 4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCombustivel, 0, 1, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldModelo)))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldQuilometragem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonCancelar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldStatus)))))
                .addGap(215, 215, 215))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButtonPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldPesquisar))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 729, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCombustivel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldQuilometragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPotencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFormattedPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxPortas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jTextFieldStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonEditar)
                    .addComponent(jButtonExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("CADASTRO DE CARROS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 855, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(308, 308, 308)
                        .addComponent(jLabel1)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(905, 647));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(jTextFieldFabricante.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Fabricante do Carro para continuar!");
            jTextFieldFabricante.requestFocus();
        }else if("  /  /    ".equals(jFormattedTextFieldAno.getText())){
            JOptionPane.showMessageDialog(null, "Preencha o Modelo do Carro para continuar!");
            jFormattedTextFieldAno.requestFocus();
        }else if(jTextFieldCor.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a cor do Carro para continuar!");
            jTextFieldCor.requestFocus();
        }else if(jTextFieldPotencia.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a Potência do Carro para continuar!");
            jTextFieldPotencia.requestFocus();
        }else if(jFormattedPlaca.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a Placa do Carro para continuar!");
            jFormattedPlaca.requestFocus();
        }else if(jTextFieldQuilometragem.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a quilometragem do Carro para continuar!");
            jTextFieldQuilometragem.requestFocus();
        }else if(jTextFieldPreco.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o preço de locação do Carro para continuar!");
            jTextFieldPreco.requestFocus();
        
        }else{
            
            carro.setFabricante(jTextFieldFabricante.getText());
            carro.setModelo(jTextFieldModelo.getText());
            carro.setAno(jFormattedTextFieldAno.getText());
            carro.setCor(jTextFieldCor.getText());
            carro.setCombustivel(jComboBoxCombustivel.getSelectedItem().toString());
            carro.setCambio(jComboBoxCambio.getSelectedItem().toString());
            carro.setPortas(jComboBoxPortas.getSelectedItem().toString());
            carro.setPotencia(jTextFieldPotencia.getText());
            carro.setPlaca(jFormattedPlaca.getText());
            carro.setQuilometragem(jTextFieldQuilometragem.getText());
            carro.setPreco(jTextFieldPreco.getText());
            
            if(flag == 1){
                carro.setStatus("Disponível");
                carro.salvar();
            }else{
                carro.setCodigo(Integer.parseInt(jTextFieldCode.getText()));
                carro.editar();
            }


            limparCampos();
            ablitarCampos(false);

            //Modifica botões
            jButtonSalvar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jButtonCancelar.setEnabled(false);
            jButtonPesquisar.setEnabled(true);
            jTextFieldPesquisar.setEnabled(true);
            
            preencherTabela("select *from carro order by modelo");

        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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

    private void jButtonExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirActionPerformed
        
        int resposta = 0;
        
        resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir?");
        if (resposta == JOptionPane.YES_OPTION){
            carro.setCodigo(Integer.parseInt(jTextFieldCode.getText()));
            carro.excluir();
        }
        
        limparCampos();
        preencherTabela("select *from carro order by modelo");
        
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableCarrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCarrosMouseClicked
        String nome = (String) jTableCarros.getValueAt(jTableCarros.getSelectedRow(), 2);
        pesquisarCarro(nome);
    }//GEN-LAST:event_jTableCarrosMouseClicked

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed
        
        boolean encontrado;
        String nome = jTextFieldPesquisar.getText();
        encontrado = pesquisarCarro(nome);
        if(!encontrado){
            limparCampos();
        }
        
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        
        preencherTabela("select *from carro where modelo like'%" + carro.getPesquisa() + "%'");
        
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroCarro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonExcluir;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonPesquisar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCambio;
    private javax.swing.JComboBox<String> jComboBoxCombustivel;
    private javax.swing.JComboBox<String> jComboBoxPortas;
    private javax.swing.JFormattedTextField jFormattedPlaca;
    private javax.swing.JFormattedTextField jFormattedTextFieldAno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTableCarros;
    private javax.swing.JTextField jTextFieldCode;
    private javax.swing.JTextField jTextFieldCor;
    private javax.swing.JTextField jTextFieldFabricante;
    private javax.swing.JTextField jTextFieldModelo;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldPotencia;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQuilometragem;
    private javax.swing.JTextField jTextFieldStatus;
    // End of variables declaration//GEN-END:variables
}
