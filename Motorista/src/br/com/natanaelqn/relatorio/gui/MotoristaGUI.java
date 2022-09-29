package br.com.natanaelqn.relatorio.gui;

import br.com.natanaelqn.relatorio.dao.CarroDAO;
import br.com.natanaelqn.relatorio.dao.MotoristaDAO;
import br.com.natanaelqn.relatorio.dao.RelatorioDAO;
import br.com.natanaelqn.relatorio.database.RelatorioBD;
import br.com.natanaelqn.relatorio.entity.Carro;
import br.com.natanaelqn.relatorio.entity.Diretor;
import br.com.natanaelqn.relatorio.entity.Motorista;
import br.com.natanaelqn.relatorio.entity.Relatorio;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MotoristaGUI extends javax.swing.JFrame {

    public static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Motorista motoristaLogado = null;
    Diretor diretorLogado = null;

    public MotoristaGUI() throws ParseException {
        //RelatorioBD.inicializarBD();
        initComponents();
        //atualizaRelatoriosRecebidos();
        //atualizaRelatoriosEnviados();
        popularCombos();

    }

    /*private void atualizaRelatoriosRecebidos() throws ParseException {
        String[] camposRelatorio = {"Id", "IdMotorista", "IdCarro.", "Data do Serviço", "Data do Envio", "Km Percorrido", "Novas Avarias", "Relato"};
        List<Relatorio> relatorios = RelatorioDAO.selecionarTodos();
        String[][] dadosRelatorios;
        dadosRelatorios = new String[relatorios.size()][8];
        int posicao = 0;
        for (Relatorio relatorio : relatorios) {
            String[] umRelatorio = new String[8];
            umRelatorio[0] = String.valueOf(relatorio.getId());
            umRelatorio[1] = String.valueOf(relatorio.getMotorista().getId());
            umRelatorio[2] = String.valueOf(relatorio.getCarro().getId());
            umRelatorio[3] = String.valueOf(relatorio.getDataDoServico());
            umRelatorio[4] = String.valueOf(relatorio.getDataDoEnvio());
            umRelatorio[5] = String.valueOf(relatorio.getKm_percorrido());
            umRelatorio[6] = relatorio.getAvariaNoServico();
            umRelatorio[7] = relatorio.getRelato();
            dadosRelatorios[posicao++] = umRelatorio;
        }
        DefaultTableModel modeloRel = new DefaultTableModel(
                dadosRelatorios, camposRelatorio);
        jtRelatoriosRecebidos.setModel(modeloRel);
    }*/
    private void atualizaRelatoriosEnviados() throws ParseException {
        String[] camposRelatorio = {"Id", "IdMotorista", "IdCarro.", "Data do Serviço", "Data do Envio", "Km Percorrido", "Novas Avarias", "Relato"};
        List<Relatorio> relatorios = RelatorioDAO.selecionarRelatoriosPorMotorista(motoristaLogado);
        String[][] dadosRelatorios;
        dadosRelatorios = new String[relatorios.size()][8];
        int posicao = 0;
        for (Relatorio relatorio : relatorios) {
            String[] umRelatorio = new String[8];
            umRelatorio[0] = String.valueOf(relatorio.getId());
            umRelatorio[1] = String.valueOf(relatorio.getMotorista().getId());
            umRelatorio[2] = String.valueOf(relatorio.getCarro().getId());
            umRelatorio[3] = String.valueOf(relatorio.getDataDoServico());
            umRelatorio[4] = String.valueOf(relatorio.getDataDoEnvio());
            umRelatorio[5] = String.valueOf(relatorio.getKm_percorrido());
            umRelatorio[6] = relatorio.getAvariaNoServico();
            umRelatorio[7] = relatorio.getRelato();
            dadosRelatorios[posicao++] = umRelatorio;
        }
        DefaultTableModel modeloRel = new DefaultTableModel(
                dadosRelatorios, camposRelatorio);
        jtRelatoriosEnviados.setModel(modeloRel);
    }

    private void limpaRelatoriosEnviados() throws ParseException {
        String[] camposRelatorio = {"Id", "IdMotorista", "IdCarro.", "Data do Serviço", "Data do Envio", "Km Percorrido", "Novas Avarias", "Relato"};
        List<Relatorio> relatorios = RelatorioDAO.selecionarTodos();
        String[][] dadosRelatorios;
        dadosRelatorios = new String[relatorios.size()][8];
        int posicao = 0;
        for (Relatorio relatorio : relatorios) {
            String[] umRelatorio = new String[8];
            umRelatorio[0] = "";
            umRelatorio[1] = "";
            umRelatorio[2] = "";
            umRelatorio[3] = "";
            umRelatorio[4] = "";
            umRelatorio[5] = "";
            umRelatorio[6] = "";
            umRelatorio[7] = "";
            dadosRelatorios[posicao++] = umRelatorio;
        }
        DefaultTableModel modeloRel = new DefaultTableModel(
                dadosRelatorios, camposRelatorio);
        jtRelatoriosEnviados.setModel(modeloRel);
    }

    private void popularCombos() {
        cCarro.removeAllItems();
        List<Carro> carros = CarroDAO.selecionarTodos();
        for (Carro carro : carros) {
            cCarro.addItem(carro.getPlaca());
        }
    }

    private void desabilitaAbas() {
    }

    private void habilitaAbas() {
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jpLogin = new javax.swing.JPanel();
        tSenha = new javax.swing.JPasswordField();
        tUsuario = new javax.swing.JTextField();
        jUsuario = new javax.swing.JLabel();
        jSenha = new javax.swing.JLabel();
        jEntrar = new javax.swing.JButton();
        jFechar = new javax.swing.JButton();
        lUsuarioLogado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jpNovoRelatorio = new javax.swing.JPanel();
        jCarro = new javax.swing.JLabel();
        jRelato = new javax.swing.JLabel();
        jNovoRelatorio = new javax.swing.JLabel();
        cCarro = new javax.swing.JComboBox<>();
        jNome = new javax.swing.JLabel();
        jMatricula = new javax.swing.JLabel();
        tNome = new javax.swing.JTextField();
        jMarca = new javax.swing.JLabel();
        tMarca = new javax.swing.JTextField();
        jModelo = new javax.swing.JLabel();
        tModelo = new javax.swing.JTextField();
        jKmAtual = new javax.swing.JLabel();
        tKmAnterior = new javax.swing.JTextField();
        jDataServico = new javax.swing.JLabel();
        jDataEnvio = new javax.swing.JLabel();
        jKmPercorrido = new javax.swing.JLabel();
        tKmPercorrido = new javax.swing.JTextField();
        spRelato = new javax.swing.JScrollPane();
        tRelato = new javax.swing.JTextArea();
        tMatricula = new javax.swing.JTextField();
        jCancelar = new javax.swing.JButton();
        jSalvar = new javax.swing.JButton();
        tDataServico = new javax.swing.JFormattedTextField();
        tDataEnvio = new javax.swing.JFormattedTextField();
        jAvariado = new javax.swing.JLabel();
        tAvariado = new javax.swing.JTextField();
        jNovasAvarias = new javax.swing.JLabel();
        cNovasAvarias = new javax.swing.JComboBox<>();
        jpRelatoriosEnviador = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtRelatoriosEnviados = new javax.swing.JTable();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MotoristaGUI");
        setLocation(new java.awt.Point(2, 2));

        jTabbedPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane1MouseClicked(evt);
            }
        });

        jUsuario.setText("Usuário");

        jSenha.setText("Senha");

        jEntrar.setText("Entrar");
        jEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEntrarActionPerformed(evt);
            }
        });

        jFechar.setText("Sair");
        jFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFecharActionPerformed(evt);
            }
        });

        lUsuarioLogado.setText("Nenhum Login Ativo ");

        jLabel1.setText("Motorista");

        jLabel2.setText("motorista");

        jLabel3.setText("123456");

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                .addContainerGap(297, Short.MAX_VALUE)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jUsuario)
                    .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                            .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpLoginLayout.createSequentialGroup()
                                    .addComponent(jEntrar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jFechar))
                                .addComponent(jSenha)
                                .addComponent(tSenha)
                                .addComponent(tUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lUsuarioLogado))
                            .addGap(46, 46, 46)
                            .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)))
                        .addGroup(jpLoginLayout.createSequentialGroup()
                            .addGap(85, 85, 85)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(200, 200, 200))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(lUsuarioLogado)
                .addGap(18, 18, 18)
                .addComponent(jUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEntrar)
                    .addComponent(jFechar))
                .addContainerGap(177, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", jpLogin);

        jpNovoRelatorio.setPreferredSize(new java.awt.Dimension(794, 480));

        jCarro.setText("Placa");

        jRelato.setText("Relato");

        jNovoRelatorio.setText("Novo Relatório");

        cCarro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cCarroItemStateChanged(evt);
            }
        });
        cCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cCarroActionPerformed(evt);
            }
        });

        jNome.setText("Nome ");

        jMatricula.setText("Matricula");

        tNome.setEditable(false);
        tNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tNomeActionPerformed(evt);
            }
        });

        jMarca.setText("Marca");

        tMarca.setEditable(false);

        jModelo.setText("Modelo");

        tModelo.setEditable(false);

        jKmAtual.setText("Km Inicial");

        tKmAnterior.setEditable(false);

        jDataServico.setText("Data do Servico");

        jDataEnvio.setText("Data do Envio");

        jKmPercorrido.setText("Km Final");

        tRelato.setColumns(20);
        tRelato.setRows(5);
        spRelato.setViewportView(tRelato);

        tMatricula.setEditable(false);

        jCancelar.setText("Cancelar");
        jCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCancelarActionPerformed(evt);
            }
        });

        jSalvar.setText("Enviar");
        jSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSalvarActionPerformed(evt);
            }
        });

        tDataServico.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        tDataEnvio.setEditable(false);
        tDataEnvio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));

        jAvariado.setText("Situação");

        tAvariado.setEditable(false);

        jNovasAvarias.setText("Nova(s) Avaria(s)");

        cNovasAvarias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NÃO", "SIM", " " }));
        cNovasAvarias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cNovasAvariasItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jpNovoRelatorioLayout = new javax.swing.GroupLayout(jpNovoRelatorio);
        jpNovoRelatorio.setLayout(jpNovoRelatorioLayout);
        jpNovoRelatorioLayout.setHorizontalGroup(
            jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spRelato)
                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                        .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                .addGap(336, 336, 336)
                                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                        .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jModelo)
                                            .addComponent(tModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jAvariado)
                                            .addComponent(tAvariado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                        .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jDataServico, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tDataServico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDataEnvio)
                                            .addComponent(tDataEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jNovoRelatorio)
                            .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jKmAtual)
                                    .addComponent(tKmAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jKmPercorrido)
                                    .addComponent(tKmPercorrido, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jNovasAvarias)
                                    .addComponent(cNovasAvarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jRelato))
                        .addContainerGap(174, Short.MAX_VALUE))
                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(jCancelar)
                        .addGap(28, 28, 28))
                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                        .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCarro)
                                    .addComponent(cCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jMarca))
                                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(tMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jNome))
                                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jMatricula))
                                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(tMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpNovoRelatorioLayout.setVerticalGroup(
            jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jNovoRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                        .addComponent(jNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tDataServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tDataEnvio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                        .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jMatricula)
                            .addComponent(jDataServico)
                            .addComponent(jDataEnvio))
                        .addGap(28, 28, 28)))
                .addGap(18, 18, 18)
                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpNovoRelatorioLayout.createSequentialGroup()
                        .addComponent(jCarro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNovoRelatorioLayout.createSequentialGroup()
                        .addComponent(jMarca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNovoRelatorioLayout.createSequentialGroup()
                        .addComponent(jModelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNovoRelatorioLayout.createSequentialGroup()
                        .addComponent(jAvariado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tAvariado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNovoRelatorioLayout.createSequentialGroup()
                        .addComponent(jKmAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tKmAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNovoRelatorioLayout.createSequentialGroup()
                        .addComponent(jKmPercorrido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tKmPercorrido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpNovoRelatorioLayout.createSequentialGroup()
                        .addComponent(jNovasAvarias)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cNovasAvarias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jRelato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spRelato, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jpNovoRelatorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCancelar)
                    .addComponent(jSalvar))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Novo Relatório ", jpNovoRelatorio);

        jpRelatoriosEnviador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpRelatoriosEnviadorMouseClicked(evt);
            }
        });

        jtRelatoriosEnviados.setModel(new javax.swing.table.DefaultTableModel(
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
        jtRelatoriosEnviados.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane2.setViewportView(jtRelatoriosEnviados);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpRelatoriosEnviadorLayout = new javax.swing.GroupLayout(jpRelatoriosEnviador);
        jpRelatoriosEnviador.setLayout(jpRelatoriosEnviadorLayout);
        jpRelatoriosEnviadorLayout.setHorizontalGroup(
            jpRelatoriosEnviadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 794, Short.MAX_VALUE)
        );
        jpRelatoriosEnviadorLayout.setVerticalGroup(
            jpRelatoriosEnviadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRelatoriosEnviadorLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Relatorios Enviados", jpRelatoriosEnviador);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cCarroActionPerformed

    private void tNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tNomeActionPerformed

    private void cCarroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cCarroItemStateChanged
        Carro carro = CarroDAO.selecionarCarroPorPlaca(cCarro.getSelectedItem().toString());
        tMarca.setText(carro.getMarca());
        tModelo.setText(carro.getModelo());
        tKmAnterior.setText(String.valueOf(carro.getKm_atual()));
        if (carro.getAvariado().equalsIgnoreCase("Sim")) {
            tAvariado.setText("Levar a Oficina");
            cNovasAvarias.setEnabled(false);
            tKmPercorrido.setEnabled(false);
            tRelato.setEnabled(false);
            jSalvar.setEnabled(false);
        } else {
            tAvariado.setText("Pronto");
            cNovasAvarias.setEnabled(true);
            tKmPercorrido.setEnabled(true);
            tRelato.setEnabled(true);
            jSalvar.setEnabled(true);
        }
    }//GEN-LAST:event_cCarroItemStateChanged

    private void jSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSalvarActionPerformed
        try {
            int kmPercorrido = 0;
            LocalDate dataDoServico;
            LocalDate dataDoEnvio;
            Motorista motorista = MotoristaDAO.selecionarMotoristaPorNome(motoristaLogado.getNome());
            Carro carro = CarroDAO.selecionarCarroPorPlaca(cCarro.getSelectedItem().toString());
            dataDoServico = LocalDate.parse(tDataServico.getText(), formato);
            dataDoEnvio = LocalDate.parse(tDataEnvio.getText(), formato);
            String avariaNoServico;
            if (cNovasAvarias.getSelectedItem().toString().equalsIgnoreCase("SIM")) {
                avariaNoServico = "Sim";
                carro.setAvariado(avariaNoServico);
            } else {
                avariaNoServico = "Não";
            }
            try {
                kmPercorrido = Integer.parseInt(tKmPercorrido.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Dado inválido no campo 'Km Final'!");
            }
            String relato = tRelato.getText();
            Relatorio relatorio = new Relatorio(motorista, carro, dataDoServico, dataDoEnvio, kmPercorrido, avariaNoServico, relato);
            RelatorioDAO.inserir(relatorio);
            JOptionPane.showMessageDialog(null, "Relatorio enviado!");
            carro.setKm_atual(carro.getKm_atual() + kmPercorrido);
            carro.setAvaria(relato);
            CarroDAO.alterar(carro);
            cCarro.setSelectedIndex(0);
            tKmPercorrido.setText("");
            atualizaRelatoriosEnviados();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro inesperado, tente novamente! " + e);
        }
    }//GEN-LAST:event_jSalvarActionPerformed

    private void cNovasAvariasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cNovasAvariasItemStateChanged
        //
    }//GEN-LAST:event_cNovasAvariasItemStateChanged

    private void jCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCancelarActionPerformed
        cCarro.setSelectedIndex(0);
        tKmPercorrido.setText("");
    }//GEN-LAST:event_jCancelarActionPerformed

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        //Não implementado
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntrarActionPerformed
        try {
            String senha = new String(tSenha.getPassword());
            motoristaLogado = MotoristaDAO.selecionarMotoristaPorLogin(tUsuario.getText(), senha);
            JOptionPane.showMessageDialog(null, motoristaLogado.getNome() + ", Bem Vindo!");
            lUsuarioLogado.setText("Usuário " + motoristaLogado.getNome() + " ativo");
            tNome.setText(motoristaLogado.getNome());
            tMatricula.setText(motoristaLogado.getMatricula());
            tDataEnvio.setText(LocalDate.now().format(formato));
            tDataServico.setText(LocalDate.now().format(formato));
            tUsuario.setEnabled(false);
            tSenha.setEnabled(false);
            jEntrar.setEnabled(false);
            try {
                atualizaRelatoriosEnviados();
                //atualizaRelatoriosRecebidos();
            } catch (ParseException ex) {
                Logger.getLogger(MotoristaGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login não efetuado!");
            tUsuario.setText("");
            tSenha.setText("");
        }
    }//GEN-LAST:event_jEntrarActionPerformed

    private void jFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFecharActionPerformed
        tNome.setText("");
        tMatricula.setText("");
        tDataEnvio.setText("");
        tDataServico.setText("");
        tUsuario.setEnabled(true);
        tSenha.setEnabled(true);
        jEntrar.setEnabled(true);
        tUsuario.setText("");
        tSenha.setText("");
        try {
            limpaRelatoriosEnviados();
        } catch (ParseException ex) {
            Logger.getLogger(MotoristaGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        lUsuarioLogado.setText("Nenhum Login Ativo");

    }//GEN-LAST:event_jFecharActionPerformed

    private void jpRelatoriosEnviadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRelatoriosEnviadorMouseClicked
        /*try {
            atualizaRelatoriosRecebidos();
        } catch (ParseException ex) {
            Logger.getLogger(RelatorioMotoristaView.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_jpRelatoriosEnviadorMouseClicked

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
            java.util.logging.Logger.getLogger(MotoristaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MotoristaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MotoristaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MotoristaGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MotoristaGUI().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(MotoristaGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cCarro;
    private javax.swing.JComboBox<String> cNovasAvarias;
    private javax.swing.JLabel jAvariado;
    private javax.swing.JButton jCancelar;
    private javax.swing.JLabel jCarro;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jDataEnvio;
    private javax.swing.JLabel jDataServico;
    private javax.swing.JButton jEntrar;
    private javax.swing.JButton jFechar;
    private javax.swing.JLabel jKmAtual;
    private javax.swing.JLabel jKmPercorrido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jMarca;
    private javax.swing.JLabel jMatricula;
    private javax.swing.JLabel jModelo;
    private javax.swing.JLabel jNome;
    private javax.swing.JLabel jNovasAvarias;
    private javax.swing.JLabel jNovoRelatorio;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jRelato;
    private javax.swing.JButton jSalvar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jSenha;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jUsuario;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPanel jpNovoRelatorio;
    private javax.swing.JPanel jpRelatoriosEnviador;
    private javax.swing.JTable jtRelatoriosEnviados;
    private javax.swing.JLabel lUsuarioLogado;
    private javax.swing.JScrollPane spRelato;
    private javax.swing.JTextField tAvariado;
    private javax.swing.JFormattedTextField tDataEnvio;
    private javax.swing.JFormattedTextField tDataServico;
    private javax.swing.JTextField tKmAnterior;
    private javax.swing.JTextField tKmPercorrido;
    private javax.swing.JTextField tMarca;
    private javax.swing.JTextField tMatricula;
    private javax.swing.JTextField tModelo;
    private javax.swing.JTextField tNome;
    private javax.swing.JTextArea tRelato;
    private javax.swing.JPasswordField tSenha;
    private javax.swing.JTextField tUsuario;
    // End of variables declaration//GEN-END:variables
}
