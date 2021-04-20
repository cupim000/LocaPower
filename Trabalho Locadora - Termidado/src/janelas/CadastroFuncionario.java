/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package janelas;

import Classes.Funcionario;
import Classes.ModeloTabela;
import controle.ConexaoBancodeDados;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;


/**
 *
 * @author ABRAAO
 */
public class CadastroFuncionario extends javax.swing.JFrame {

    ConexaoBancodeDados conex = new ConexaoBancodeDados();
    Funcionario func = new Funcionario();
    private int flag = 0;
    
    public CadastroFuncionario() {
        initComponents();
        preencherTabela("select *from funcionario order by nome");
    }
    
    private void ablitarCampos(boolean aux){
        //Bloqueando/Liberando Campos e Botões
        jTextFieldNome.setEnabled(aux);
        jFormattedTextFieldData.setEnabled(aux);
        jTextFieldRua.setEnabled(aux);
        jTextFieldNumero.setEnabled(aux);
        jTextFieldCep.setEnabled(aux);
        jTextFieldComplemento.setEnabled(aux);
        jTextFieldBairro.setEnabled(aux);        
        jFormattedTextFieldCPF.setEnabled(aux);
        jComboBoxSexo.setEnabled(aux);
        jFormattedTextFieldCelular.setEnabled(aux);
        jTextFieldEmail.setEnabled(aux);
        jTextFieldSalario.setEnabled(aux);
        jTextFieldFuncao.setEnabled(aux);
    }
    
    private void limparCampos(){
        //Limpa os compos digitados
        jTextFieldNome.setText("");
        jFormattedTextFieldData.setText("");
        jTextFieldRua.setText("");
        jTextFieldNumero.setText("");
        jTextFieldCep.setText("");
        jTextFieldComplemento.setText("");
        jTextFieldBairro.setText("");
        jFormattedTextFieldCPF.setText("");
        jFormattedTextFieldCelular.setText("");
        jTextFieldEmail.setText("");
        jTextFieldSalario.setText("");
        jTextFieldFuncao.setText("");
        jTextFieldCode.setText("");
    }
    
    private boolean pesquisarFuncionario(String nome){
        boolean aux;
        func.setPesquisa(nome);
        aux = func.buscar();
        if (!aux) {
            return false;
        }
        jTextFieldNome.setText(String.valueOf(func.getNome()));
        jFormattedTextFieldData.setText(String.valueOf(func.getDataNascimento() ));
        jTextFieldRua.setText(String.valueOf(func.getRua()));
        jTextFieldNumero.setText(String.valueOf(func.getNumero()));
        jTextFieldCep.setText(String.valueOf(func.getCep()));
        jTextFieldComplemento.setText(String.valueOf(func.getComplemento()));
        jTextFieldBairro.setText(String.valueOf(func.getBairro()));
        jFormattedTextFieldCPF.setText(String.valueOf(func.getCpf()));
        jComboBoxSexo.setSelectedItem(String.valueOf(func.getSexo()));
        jFormattedTextFieldCelular.setText(String.valueOf(func.getTelefone()));
        jTextFieldEmail.setText(String.valueOf(func.getEmail()));
        jTextFieldSalario.setText(String.valueOf(func.getSalario()));
        jTextFieldFuncao.setText(String.valueOf(func.getFuncao()));
        jTextFieldCode.setText(String.valueOf(func.getCodigo()));
       
        
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
        ArrayList dadosfunc = new ArrayList();
        String [] colunas = new String [] {"ID","Nome","Nascimento","CPF","Sexo","Telefone","Email","Salário","Função"};
        conex.conexao();
        conex.executaSql(sql);
        
        try {
            conex.rs.first();
            do{
                dadosfunc.add(new Object[] {conex.rs.getInt("id"),conex.rs.getString("nome"),conex.rs.getString("nascimento"),conex.rs.getString("cpf"),conex.rs.getString("sexo"),conex.rs.getString("telefone"),conex.rs.getString("email"),conex.rs.getInt("salario"),conex.rs.getString("funcao")});
            }while(conex.rs.next());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane,"Busque por um novo funcionário para preencher a tabela.");
        }
        ModeloTabela modelo = new ModeloTabela(dadosfunc, colunas);
        jTableFuncionarios.setModel(modelo);
        
        //Tamanho das colunas na tabela
      
        jTableFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableFuncionarios.getColumnModel().getColumn(0).setResizable(false);
        jTableFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(210);
        jTableFuncionarios.getColumnModel().getColumn(1).setResizable(false);
        jTableFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableFuncionarios.getColumnModel().getColumn(2).setResizable(false);
        jTableFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(110);
        jTableFuncionarios.getColumnModel().getColumn(3).setResizable(false);
        jTableFuncionarios.getColumnModel().getColumn(4).setPreferredWidth(50);
        jTableFuncionarios.getColumnModel().getColumn(4).setResizable(false);
        jTableFuncionarios.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTableFuncionarios.getColumnModel().getColumn(5).setResizable(false);
        jTableFuncionarios.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTableFuncionarios.getColumnModel().getColumn(6).setResizable(false);
        jTableFuncionarios.getColumnModel().getColumn(7).setPreferredWidth(60);
        jTableFuncionarios.getColumnModel().getColumn(7).setResizable(false);
        jTableFuncionarios.getColumnModel().getColumn(8).setPreferredWidth(110);
        jTableFuncionarios.getColumnModel().getColumn(8).setResizable(false);

        
        jTableFuncionarios.getTableHeader().setReorderingAllowed(false);
        jTableFuncionarios.setAutoResizeMode(jTableFuncionarios.AUTO_RESIZE_OFF);
        jTableFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldEmail = new javax.swing.JTextField();
        jButtonCancelar = new javax.swing.JButton();
        jButtonNovo = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonExcluir = new javax.swing.JButton();
        jButtonSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldSalario = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();
        jButtonPesquisar = new javax.swing.JButton();
        jTextFieldPesquisar = new javax.swing.JTextField();
        jComboBoxSexo = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextFieldData = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCPF = new javax.swing.JFormattedTextField();
        jFormattedTextFieldCelular = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Nome:");

        jTextFieldNome.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Celular:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("Data de Nascimento:");

        jLabel7.setText("CPF:");

        jLabel8.setText("Plano de Saúde:");

        jTextFieldEmail.setEnabled(false);

        jButtonCancelar.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonNovo.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jButtonNovo.setText("Novo");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
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

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setText("Sexo:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setText("CRM:");

        jTextFieldSalario.setEnabled(false);

        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableFuncionarios);

        jButtonPesquisar.setText("Pesquisar");
        jButtonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPesquisarActionPerformed(evt);
            }
        });

        jComboBoxSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        jComboBoxSexo.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel11.setText("Função:");

        try {
            jFormattedTextFieldData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldData.setEnabled(false);

        try {
            jFormattedTextFieldCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCPF.setEnabled(false);

        try {
            jFormattedTextFieldCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFormattedTextFieldCelular.setEnabled(false);

        jLabel18.setText("Cartão SUS:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Médico", "Paciente", " " }));

        jLabel12.setText("Especialidade: ");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clínico Geral", "Cardiologista", "Pediatra", "Ortopedista", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldEmail)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(20, 20, 20)
                                .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButtonExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jButtonPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addGap(31, 31, 31))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(jButtonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jFormattedTextFieldData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jFormattedTextFieldCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFormattedTextFieldCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jLabel3)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCancelar)
                    .addComponent(jButtonExcluir)
                    .addComponent(jButtonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSalvar)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("CADASTRO DE MÉDICOS/PACIENTES");

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1026, 1026, 1026)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(227, 227, 227)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(347, 347, 347))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );

        setSize(new java.awt.Dimension(1105, 611));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalvarActionPerformed
        if(jTextFieldNome.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Nome do funcionário para continuar!");
            jTextFieldNome.requestFocus();
        }else if("  /  /    ".equals(jFormattedTextFieldData.getText())){
            JOptionPane.showMessageDialog(null, "Preencha a Data de Nascimento do funcionário para continuar!");
            jFormattedTextFieldData.requestFocus();
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
        }else if("   .   .   -  ".equals(jFormattedTextFieldCPF.getText())){
            JOptionPane.showMessageDialog(null, "Preencha o CPF do funcionário para continuar!");
            jFormattedTextFieldCPF.requestFocus();
        }else if("(  )      -    ".equals(jFormattedTextFieldCelular.getText())){
            JOptionPane.showMessageDialog(null, "Preencha o Celular do funcionário para continuar!");
            jFormattedTextFieldCelular.requestFocus();
        }else if(jTextFieldEmail.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Email do funcionário para continuar!");
            jTextFieldEmail.requestFocus();
        }else if(jTextFieldSalario.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha o Salário do funcionário para continuar!");
            jTextFieldSalario.requestFocus();
        }else if(jTextFieldFuncao.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Preencha a Função do funcionário para continuar!");
            jTextFieldFuncao.requestFocus();
        }else{
            
            func.setNome(jTextFieldNome.getText());
            func.setDataNascimento(jFormattedTextFieldData.getText());
            func.setRua(jTextFieldRua.getText());
            func.setNumero(jTextFieldNumero.getText());
            func.setCep(jTextFieldCep.getText());
            func.setComplemento(jTextFieldComplemento.getText());
            func.setBairro(jTextFieldBairro.getText());
            func.setCpf(jFormattedTextFieldCPF.getText());
            func.setSexo(jComboBoxSexo.getSelectedItem().toString());
            func.setTelefone(jFormattedTextFieldCelular.getText());
            func.setEmail(jTextFieldEmail.getText());
            func.setSalario(Integer.parseInt(jTextFieldSalario.getText()));
            func.setFuncao(jTextFieldFuncao.getText());
            
            if(flag == 1){
                //Salvando no banco de dados
                func.salvar();
            }else{
                func.setCodigo(Integer.parseInt(jTextFieldCode.getText()));
                func.editar();
            }


            limparCampos();
            ablitarCampos(false);

            //Modifica botões
            jButtonSalvar.setEnabled(false);
            jButtonNovo.setEnabled(true);
            jButtonCancelar.setEnabled(false);
            jTextFieldPesquisar.setEnabled(true);
            jButtonPesquisar.setEnabled(true);
            
            preencherTabela("select *from funcionario order by nome");

        }
    }//GEN-LAST:event_jButtonSalvarActionPerformed

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

    private void jButtonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPesquisarActionPerformed

        boolean encontrado;
        String nome = jTextFieldPesquisar.getText();
        encontrado = pesquisarFuncionario(nome);
        if(!encontrado){
            limparCampos();
        }
       
        
        jButtonEditar.setEnabled(true);
        jButtonExcluir.setEnabled(true);
        
        preencherTabela("select *from funcionario where nome like'%" + func.getPesquisa() + "%'");
        
        
    }//GEN-LAST:event_jButtonPesquisarActionPerformed

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
            func.setCodigo(Integer.parseInt(jTextFieldCode.getText()));
            func.excluir();
        }
        
        limparCampos();
        preencherTabela("select *from funcionario order by nome");
        
        jButtonExcluir.setEnabled(false);
        jButtonEditar.setEnabled(false);
        
    }//GEN-LAST:event_jButtonExcluirActionPerformed

    private void jTableFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionariosMouseClicked
        
            String nome = (String) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 1);
            pesquisarFuncionario(nome);
        
    }//GEN-LAST:event_jTableFuncionariosMouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroFuncionario().setVisible(true);
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
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBoxSexo;
    private javax.swing.JFormattedTextField jFormattedTextFieldCPF;
    private javax.swing.JFormattedTextField jFormattedTextFieldCelular;
    private javax.swing.JFormattedTextField jFormattedTextFieldData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableFuncionarios;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPesquisar;
    private javax.swing.JTextField jTextFieldSalario;
    // End of variables declaration//GEN-END:variables
}
