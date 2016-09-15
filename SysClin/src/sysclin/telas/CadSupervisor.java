package sysclin.telas;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sysclin.supervisor.Supervisor;
import sysclin.supervisor.SupervisorDAO;
import sysclin.util.Util;

public class CadSupervisor extends javax.swing.JDialog {

    Supervisor supervisor = new Supervisor();
    SupervisorDAO supervisordao = new SupervisorDAO();

    public CadSupervisor(java.awt.Frame parent, boolean modal, Supervisor supervisor) {
        super(parent, modal);
        initComponents();
        this.supervisor = supervisor;
        atualizaCampos();
        this.setIconImage(new ImageIcon(getClass().getResource("/sysclin/imagens/logobrancop.jpg")).getImage());
        this.setTitle("Sysclin - Cadastro de supervisor");
    }

    public void limparCampos() {
        tflogin.setText("");
        tfsenha.setText("");
        tfbairro.setText("");
        tfnome.setText("");
        tfcpf.setText("");
        tfrg.setText("");
        tfconfirma.setText("");
        tfcidade.setSelectedIndex(0);
        tfemail.setText("");
        tfnasc.setText("");
        tfRadiofeminino.setSelected(false);
        tfRadioMasculino.setSelected(false);
        tfendereco.setText("");
        tfestado.setSelectedIndex(0);
        tfnumero.setText("");
        tfcomplemento.setText("");
        tftelefone.setText("");
        supervisor = new Supervisor();
    }

    /**
     este metodo aualizara os campos
     */
    public void atualizaCampos() {
        tfnome.setText(this.supervisor.getNome());
        //duvida
        tfRadiofeminino.setSelected(this.supervisor.getSexo());

        tfbairro.setText(this.supervisor.getBairro());
        tfcidade.setSelectedItem(this.supervisor.getCidade());
        tfcomplemento.setText(this.supervisor.getComplemento());
        //duvida
        tfconfirma.setText(this.supervisor.getSenha());
        //duvida
        tfcpf.setText(this.supervisor.getCpf());

        tfemail.setText(this.supervisor.getEmail());
        tfendereco.setText(this.supervisor.getEndereco());
        //
        tfestado.setSelectedItem(this.supervisor.getEstado());
        //
        tfnasc.setText(this.supervisor.getDataNascimento());

        tflogin.setText(this.supervisor.getLogin());
        //
        tfnumero.setText(this.supervisor.getEnderecoNumero());
        //
        tfRadioMasculino.setSelected(this.supervisor.getSexo());
        tfrg.setText(this.supervisor.getRg());
        tfsenha.setText(this.supervisor.getSenha());
        tftelefone.setText(this.supervisor.getTelefone());
    }

    private void cadastrar() {
        String login = tflogin.getText().trim();
        String senha = tfsenha.getText().trim();
        String nome = tfnome.getText().trim();
        String cpf = tfcpf.getText().trim();
        String rg = tfrg.getText().trim();
        String nasc = tfnasc.getText().trim();
        char sexo;

        if (tfRadioMasculino.isSelected()) {
            sexo = 'M';
        } else {
            sexo = 'F';
        }

        String email = tfemail.getText().trim();
        String celular = tftelefone.getText().trim();
        String endereco = tfendereco.getText().trim();
        String bairro = tfbairro.getText().trim();
        String complemento = tfcomplemento.getText().trim();
        String estado = tfestado.getSelectedItem().toString();
        String cidade = tfcidade.getSelectedItem().toString();
        String numero = tfnumero.getText().trim();

        if (!Util.chkVazio(login)) {
            JOptionPane.showMessageDialog(null, "O campo login e obrigatório");
        } else if (!Util.chkVazio(nome)) {
            JOptionPane.showMessageDialog(null, "O campo nome e obrigatório");
        } else if (!Util.chkVazio(senha)) {
            JOptionPane.showMessageDialog(null, "O campo senha e obrigatório");
        } else if (!senha.equals(tfconfirma.getText().trim())) {
            JOptionPane.showMessageDialog(null, "As senhas não coincidem");
        } else if (!Util.chkVazio(cpf)) {
            JOptionPane.showMessageDialog(null, "O campo cpf e obrigatório");
        } else if (!Util.CPF(Util.formatarCPF(String.valueOf(cpf)))) {
            JOptionPane.showMessageDialog(null, "O Cpf e inválido");
        } else if (Util.chkVazio(numero) && !Util.isIntegerValid(numero)) {
            JOptionPane.showMessageDialog(null, "O número de endereço e inválido");
        } else {
            supervisor.setNome(nome);
            supervisor.setLogin(login);
            supervisor.setCidade(cidade);
            supervisor.setCpf(Util.sanitizeLong(Util.formatarCPF(cpf)));
            supervisor.setDataNascimento(Util.formatData(nasc));
            supervisor.setSenha(Util.md5(senha));
            supervisor.setEstado(estado);
            supervisor.setSexo(sexo);
            supervisor.setTelefone(celular);
            supervisor.setEnderecoNumero(Util.sanitizeInt(numero));
            supervisor.setEndereco(endereco);
            supervisor.setComplemento(complemento);
            supervisor.setBairro(bairro);
            supervisor.setRg(rg);
            supervisor.setEmail(email);
            if (supervisor.getId() == 0) {

                supervisordao.adicionar(supervisor);
                //estou limpando a variavel declarando uma nova instancia
                supervisor = new Supervisor();
                atualizaCampos();
            } else {
                supervisordao.atualizar(supervisor);
                this.dispose();
            }
            //supervisordao.salvar(supervisor);
            // btLimparActionPerformed(null);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfRadiofeminino = new javax.swing.JRadioButton();
        tfRadioMasculino = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        tflogin = new javax.swing.JTextField();
        tfnome = new javax.swing.JTextField();
        tfnasc = new javax.swing.JFormattedTextField();
        tfcpf = new javax.swing.JFormattedTextField();
        tfrg = new javax.swing.JFormattedTextField();
        tfconfirma = new javax.swing.JPasswordField();
        tfsenha = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tftelefone = new javax.swing.JFormattedTextField();
        tfendereco = new javax.swing.JTextField();
        tfcomplemento = new javax.swing.JTextField();
        tfbairro = new javax.swing.JTextField();
        tfestado = new javax.swing.JComboBox();
        tfcidade = new javax.swing.JComboBox();
        tfnumero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfemail = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        jPanel1.setBackground(new java.awt.Color(35, 110, 230));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sysclin/imagens/logobrancop.jpg"))); // NOI18N

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(35, 110, 231));
        jLabel22.setText("Cadastro de Supervisor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(65, 65, 65)
                .addComponent(jLabel22)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addContainerGap())
        );

        jTabbedPane1.setForeground(new java.awt.Color(35, 110, 231));
        jTabbedPane1.setToolTipText("");
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(35, 110, 231));
        jLabel11.setText("Nome Completo:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(35, 110, 231));
        jLabel12.setText("Data Nascimento:");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(35, 110, 231));
        jLabel13.setText("Sexo:");

        tfRadiofeminino.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(tfRadiofeminino);
        tfRadiofeminino.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfRadiofeminino.setForeground(new java.awt.Color(35, 110, 231));
        tfRadiofeminino.setText("F");
        tfRadiofeminino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfRadiofemininoActionPerformed(evt);
            }
        });

        tfRadioMasculino.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(tfRadioMasculino);
        tfRadioMasculino.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tfRadioMasculino.setForeground(new java.awt.Color(35, 110, 231));
        tfRadioMasculino.setText("M");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(35, 110, 231));
        jLabel14.setText("RG:");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(35, 110, 231));
        jLabel15.setText("CPF:");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(35, 110, 231));
        jLabel17.setText("Login:");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(35, 110, 231));
        jLabel20.setText("Senha:");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(35, 110, 231));
        jLabel21.setText("Confirmar Senha:");

        tflogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfnome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfnasc.setForeground(new java.awt.Color(35, 110, 231));
        try {
            tfnasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfnasc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfnasc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfnascActionPerformed(evt);
            }
        });

        tfcpf.setForeground(new java.awt.Color(35, 110, 231));
        try {
            tfcpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfcpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfrg.setForeground(new java.awt.Color(35, 110, 231));
        tfrg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfconfirma.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfconfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfconfirmaActionPerformed(evt);
            }
        });

        tfsenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfsenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfsenhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(8, 8, 8)
                                .addComponent(tfconfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfRadioMasculino)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfRadiofeminino, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(6, 6, 6)
                                .addComponent(tfnome))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfcpf, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfrg, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(26, 26, 26)
                                .addComponent(tflogin, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfnasc, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(18, 18, 18)
                                .addComponent(tfsenha)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tfcpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(tfrg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(tfnasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tflogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfsenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfconfirma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(tfRadioMasculino)
                    .addComponent(tfRadiofeminino))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Geral", jPanel3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(35, 110, 231));
        jLabel2.setText("Telefone:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(35, 110, 231));
        jLabel5.setText("Endereço:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(35, 110, 231));
        jLabel6.setText("Nº:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(35, 110, 231));
        jLabel7.setText("Bairro:");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(35, 110, 231));
        jLabel8.setText("Complemento:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(35, 110, 231));
        jLabel9.setText("Estado:");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(35, 110, 231));
        jLabel10.setText("Cidade:");

        tftelefone.setForeground(new java.awt.Color(35, 110, 231));
        try {
            tftelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tftelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfendereco.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tfcomplemento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfcomplemento.setText(" ");

        tfbairro.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfbairro.setText(" ");

        tfestado.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfestado.setForeground(new java.awt.Color(35, 110, 231));
        tfestado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CE", "SP", "RJ" }));

        tfcidade.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfcidade.setForeground(new java.awt.Color(35, 110, 231));
        tfcidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ICÓ", "IGUATU", "JUAZEIRO DO NORTE" }));
        tfcidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfcidadeActionPerformed(evt);
            }
        });

        tfnumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(35, 110, 231));
        jLabel3.setText("Email:");

        tfemail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tfemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfemailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfbairro, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(67, 67, 67))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tftelefone)
                    .addComponent(tfemail))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(tfestado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(tfcidade, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(67, 67, 67))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(tfnumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfbairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfcomplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tftelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(tfcidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel3)
                    .addComponent(tfemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Contato", jPanel4);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(35, 110, 231));
        jButton2.setText("SALVAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(35, 110, 231));
        jButton4.setText("CANCELAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btLimpar.setBackground(new java.awt.Color(255, 255, 255));
        btLimpar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btLimpar.setForeground(new java.awt.Color(35, 110, 231));
        btLimpar.setText("LIMPAR");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(40, 40, 40)
                        .addComponent(btLimpar)
                        .addGap(37, 37, 37)
                        .addComponent(jButton2)
                        .addGap(166, 166, 166))
                    .addComponent(jTabbedPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        jTabbedPane1.getAccessibleContext().setAccessibleName("Informações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        cadastrar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        limparCampos();
    }//GEN-LAST:event_btLimparActionPerformed

    private void tfRadiofemininoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfRadiofemininoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfRadiofemininoActionPerformed

    private void tfconfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfconfirmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfconfirmaActionPerformed

    private void tfsenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfsenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfsenhaActionPerformed

    private void tfnascActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfnascActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfnascActionPerformed

    private void tfemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfemailActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tfcidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfcidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfcidadeActionPerformed

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
            java.util.logging.Logger.getLogger(CadSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadSupervisor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CadSupervisor dialog = new CadSupervisor(new javax.swing.JFrame(), true, new Supervisor());
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLimpar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton tfRadioMasculino;
    private javax.swing.JRadioButton tfRadiofeminino;
    private javax.swing.JTextField tfbairro;
    private javax.swing.JComboBox tfcidade;
    private javax.swing.JTextField tfcomplemento;
    private javax.swing.JPasswordField tfconfirma;
    private javax.swing.JFormattedTextField tfcpf;
    private javax.swing.JTextField tfemail;
    private javax.swing.JTextField tfendereco;
    private javax.swing.JComboBox tfestado;
    private javax.swing.JTextField tflogin;
    private javax.swing.JFormattedTextField tfnasc;
    private javax.swing.JTextField tfnome;
    private javax.swing.JTextField tfnumero;
    private javax.swing.JFormattedTextField tfrg;
    private javax.swing.JPasswordField tfsenha;
    private javax.swing.JFormattedTextField tftelefone;
    // End of variables declaration//GEN-END:variables
}
