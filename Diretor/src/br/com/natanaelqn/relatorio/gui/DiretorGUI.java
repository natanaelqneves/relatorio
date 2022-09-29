package br.com.natanaelqn.relatorio.gui;

import br.com.natanaelqn.relatorio.gui.carro.AdicionarVeiculo;
import br.com.natanaelqn.relatorio.gui.carro.RemoverVeiculo;
import br.com.natanaelqn.relatorio.gui.carro.AlterarVeiculo;
import br.com.natanaelqn.relatorio.dao.CarroDAO;
import br.com.natanaelqn.relatorio.dao.DiretorDAO;
import br.com.natanaelqn.relatorio.dao.MotoristaDAO;
import br.com.natanaelqn.relatorio.dao.RelatorioDAO;
import br.com.natanaelqn.relatorio.database.RelatorioBD;
import br.com.natanaelqn.relatorio.entity.Carro;
import br.com.natanaelqn.relatorio.entity.Diretor;
import br.com.natanaelqn.relatorio.entity.Motorista;
import br.com.natanaelqn.relatorio.entity.Relatorio;
import java.text.ParseException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DiretorGUI extends javax.swing.JFrame {

    public static final DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Diretor usuarioLogado = null;


    public DiretorGUI() throws ParseException {
        //RelatorioBD.inicializarBD();
        initComponents();
        //atualizaRelatoriosRecebidos();
        //atualizaRelatoriosEnviados(); 
    }

    private void atualizaRelatoriosRecebidos() throws ParseException {
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
    }
    
    private void limpaRelatoriosRecebidos() throws ParseException{
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
        jtRelatoriosRecebidos.setModel(modeloRel);
    }
    
    private void popularCombos() {
        cCarro.removeAllItems();
        List<Carro> carros = CarroDAO.selecionarTodos();
        for (Carro carro : carros) {
            cCarro.addItem(carro.getPlaca());
        }
        cbMotorista.removeAllItems();
        List<Motorista> motoristas = MotoristaDAO.selecionarTodos();
        for (Motorista motorista : motoristas) {
            cbMotorista.addItem(motorista.getNome());
        }
    }
    
    private void limpaCombos() {
        cCarro.removeAllItems();
        List<Carro> carros = CarroDAO.selecionarTodos();
        for (Carro carro : carros) {
            cCarro.addItem("");
        }
        cbMotorista.removeAllItems();
        List<Motorista> motoristas = MotoristaDAO.selecionarTodos();
        for (Motorista motorista : motoristas) {
            cbMotorista.addItem("");
        }
    }
    
    /*private void atualizaRelatoriosEnviados() throws ParseException {
        String[] camposRelatorio = {"Id", "IdMotorista", "IdCarro.", "Data do Serviço", "Data do Envio", "Km Percorrido", "Novas Avarias", "Relato"};
        List<Relatorio> relatorios = RelatorioDAO.selecionarRelatoriosPorMotorista(usuarioLogado);
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

    private void popularCombos() {
        cCarro.removeAllItems();
        List<Carro> carros = CarroDAO.selecionarTodos();
        for (Carro carro : carros) {
            cCarro.addItem(carro.getPlaca());
        }
    }*/

    
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
        jLabel2 = new javax.swing.JLabel();
        jpRelatoriosRecebidos = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtRelatoriosRecebidos = new javax.swing.JTable();
        jAtualizar = new javax.swing.JButton();
        jpGerenciar = new javax.swing.JPanel();
        cCarro = new javax.swing.JComboBox<>();
        jCarro = new javax.swing.JLabel();
        jMarca = new javax.swing.JLabel();
        tMarca = new javax.swing.JTextField();
        tModelo = new javax.swing.JTextField();
        jModelo = new javax.swing.JLabel();
        jAvariado = new javax.swing.JLabel();
        tAvariado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jNovoCarro = new javax.swing.JButton();
        jAlterarCarro = new javax.swing.JButton();
        jRemoverCarro = new javax.swing.JButton();
        tMatricula = new javax.swing.JTextField();
        jMarca1 = new javax.swing.JLabel();
        cbMotorista = new javax.swing.JComboBox<>();
        lNomeMotorista = new javax.swing.JLabel();
        jMotorista = new javax.swing.JLabel();
        jAdicionarMotorista = new javax.swing.JButton();
        jAlterarMotorista = new javax.swing.JButton();
        jRemoverMotorista = new javax.swing.JButton();
        tKmAtual = new javax.swing.JTextField();
        jKmAtual = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DiretorGUI");
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

        jLabel2.setText("Diretor");

        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                .addContainerGap(298, Short.MAX_VALUE)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addComponent(jEntrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFechar))
                    .addComponent(jSenha)
                    .addComponent(tSenha)
                    .addComponent(tUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUsuario)
                    .addComponent(lUsuarioLogado))
                .addGap(296, 296, 296))
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(372, 372, 372)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(lUsuarioLogado)
                .addGap(18, 18, 18)
                .addComponent(jUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jEntrar)
                    .addComponent(jFechar))
                .addContainerGap(183, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Login", jpLogin);

        jpRelatoriosRecebidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpRelatoriosRecebidosMouseClicked(evt);
            }
        });

        jtRelatoriosRecebidos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtRelatoriosRecebidos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(jtRelatoriosRecebidos);

        jAtualizar.setText("Atualizar");
        jAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jAtualizar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jAtualizar)
                .addGap(0, 132, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpRelatoriosRecebidosLayout = new javax.swing.GroupLayout(jpRelatoriosRecebidos);
        jpRelatoriosRecebidos.setLayout(jpRelatoriosRecebidosLayout);
        jpRelatoriosRecebidosLayout.setHorizontalGroup(
            jpRelatoriosRecebidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 794, Short.MAX_VALUE)
        );
        jpRelatoriosRecebidosLayout.setVerticalGroup(
            jpRelatoriosRecebidosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Relatorios Recebidos", jpRelatoriosRecebidos);

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

        jCarro.setText("Placa");

        jMarca.setText("Marca");

        tMarca.setEditable(false);

        tModelo.setEditable(false);

        jModelo.setText("Modelo");

        jAvariado.setText("Situação");

        tAvariado.setEditable(false);

        jLabel1.setText("Veiculo");

        jNovoCarro.setText("Adicionar");
        jNovoCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNovoCarroActionPerformed(evt);
            }
        });

        jAlterarCarro.setText("Alterar");
        jAlterarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarCarroActionPerformed(evt);
            }
        });

        jRemoverCarro.setText("Remover");
        jRemoverCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRemoverCarroActionPerformed(evt);
            }
        });

        tMatricula.setEditable(false);

        jMarca1.setText("Matricula");

        cbMotorista.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbMotoristaItemStateChanged(evt);
            }
        });
        cbMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbMotoristaActionPerformed(evt);
            }
        });

        lNomeMotorista.setText("Nome");

        jMotorista.setText("Motorista");

        jAdicionarMotorista.setText("Adicionar");

        jAlterarMotorista.setText("Alterar");
        jAlterarMotorista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAlterarMotoristaActionPerformed(evt);
            }
        });

        jRemoverMotorista.setText("Remover");

        tKmAtual.setEditable(false);

        jKmAtual.setText("Km Atual");

        javax.swing.GroupLayout jpGerenciarLayout = new javax.swing.GroupLayout(jpGerenciar);
        jpGerenciar.setLayout(jpGerenciarLayout);
        jpGerenciarLayout.setHorizontalGroup(
            jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGerenciarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpGerenciarLayout.createSequentialGroup()
                        .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCarro)
                            .addComponent(cCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpGerenciarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jMarca))
                            .addGroup(jpGerenciarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel1)
                    .addGroup(jpGerenciarLayout.createSequentialGroup()
                        .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lNomeMotorista)
                            .addComponent(cbMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpGerenciarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jMarca1))
                            .addGroup(jpGerenciarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jMotorista)
                    .addGroup(jpGerenciarLayout.createSequentialGroup()
                        .addComponent(jNovoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jAlterarCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpGerenciarLayout.createSequentialGroup()
                                .addGap(92, 92, 92)
                                .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jModelo)
                                    .addComponent(tModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jAvariado)
                                    .addComponent(tAvariado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jKmAtual)
                                    .addComponent(tKmAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jpGerenciarLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jRemoverCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jpGerenciarLayout.createSequentialGroup()
                        .addComponent(jAdicionarMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jAlterarMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jRemoverMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jpGerenciarLayout.setVerticalGroup(
            jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpGerenciarLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jpGerenciarLayout.createSequentialGroup()
                            .addComponent(jCarro)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGerenciarLayout.createSequentialGroup()
                            .addComponent(jMarca)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGerenciarLayout.createSequentialGroup()
                            .addComponent(jModelo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGerenciarLayout.createSequentialGroup()
                            .addComponent(jAvariado)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tAvariado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpGerenciarLayout.createSequentialGroup()
                        .addComponent(jKmAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tKmAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNovoCarro)
                    .addComponent(jAlterarCarro)
                    .addComponent(jRemoverCarro))
                .addGap(37, 37, 37)
                .addComponent(jMotorista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpGerenciarLayout.createSequentialGroup()
                        .addComponent(lNomeMotorista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbMotorista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGerenciarLayout.createSequentialGroup()
                        .addComponent(jMarca1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpGerenciarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAdicionarMotorista)
                    .addComponent(jAlterarMotorista)
                    .addComponent(jRemoverMotorista))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Gerenciar", jpGerenciar);

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
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane1MouseClicked
        /*try {
            atualizaRelatoriosEnviados();
            atualizaRelatoriosRecebidos();
        } catch (ParseException ex) {
            Logger.getLogger(DiretorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_jTabbedPane1MouseClicked

    private void jEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEntrarActionPerformed
        tUsuario.setEnabled(false);
        tSenha.setEnabled(false);
        jEntrar.setEnabled(false);
        try {
            String senha = new String(tSenha.getPassword());
            usuarioLogado = DiretorDAO.selecionarDiretorPorLogin(tUsuario.getText(), senha);
            JOptionPane.showMessageDialog(null, usuarioLogado.getNome() + ", Bem Vindo!");
            lUsuarioLogado.setText("Usuário " + usuarioLogado.getNome() + " ativo");
            atualizaRelatoriosRecebidos();
            popularCombos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Login não efetuado!");
            tUsuario.setText("");
            tSenha.setText("");
        }
    }//GEN-LAST:event_jEntrarActionPerformed

    private void jFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFecharActionPerformed
        tUsuario.setEnabled(true);
        tSenha.setEnabled(true);
        jEntrar.setEnabled(true);
        tUsuario.setText("");
        tSenha.setText("");
        lUsuarioLogado.setText("Nenhum Login Ativo");
        try {
            limpaRelatoriosRecebidos();
            limpaCombos();
            tMarca.setText("");
            tModelo.setText("");
            tAvariado.setText("");
            tKmAtual.setText("");
            tMatricula.setText("");
        } catch (ParseException ex) {
            Logger.getLogger(DiretorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jFecharActionPerformed

    private void jpRelatoriosRecebidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRelatoriosRecebidosMouseClicked
        try {
            atualizaRelatoriosRecebidos();
        } catch (ParseException ex) {
            Logger.getLogger(DiretorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jpRelatoriosRecebidosMouseClicked

    private void jAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAtualizarActionPerformed
        try {
            atualizaRelatoriosRecebidos();
        } catch (ParseException ex) {
            Logger.getLogger(DiretorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jAtualizarActionPerformed

    private void cCarroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cCarroItemStateChanged
        Carro carro = CarroDAO.selecionarCarroPorPlaca(cCarro.getSelectedItem().toString());
        tMarca.setText(carro.getMarca());
        tModelo.setText(carro.getModelo());
        tKmAtual.setText(String.valueOf(carro.getKm_atual()));
        if (carro.getAvariado().equalsIgnoreCase("Sim")) {
            tAvariado.setText("Levar a Oficina");
        } else {
            tAvariado.setText("Pronto");
        }
    }//GEN-LAST:event_cCarroItemStateChanged

    private void cCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cCarroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cCarroActionPerformed

    private void cbMotoristaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbMotoristaItemStateChanged
        Motorista motorista = MotoristaDAO.selecionarMotoristaPorNome(cbMotorista.getSelectedItem().toString());
        tMatricula.setText(motorista.getMatricula());
        
    }//GEN-LAST:event_cbMotoristaItemStateChanged

    private void cbMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbMotoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbMotoristaActionPerformed

    private void jAlterarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarCarroActionPerformed
        AlterarVeiculo alterar = new AlterarVeiculo();
        alterar.setVisible(true);
    }//GEN-LAST:event_jAlterarCarroActionPerformed

    private void jAlterarMotoristaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAlterarMotoristaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAlterarMotoristaActionPerformed

    private void jNovoCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNovoCarroActionPerformed
        AdicionarVeiculo inserir = new AdicionarVeiculo();
        inserir.setVisible(true);
    }//GEN-LAST:event_jNovoCarroActionPerformed

    private void jRemoverCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRemoverCarroActionPerformed
        try {
            RemoverVeiculo remover = new RemoverVeiculo();
            remover.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(DiretorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jRemoverCarroActionPerformed

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
            java.util.logging.Logger.getLogger(DiretorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiretorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiretorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiretorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DiretorGUI().setVisible(true);
                } catch (ParseException ex) {
                    Logger.getLogger(DiretorGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cCarro;
    private javax.swing.JComboBox<String> cbMotorista;
    private javax.swing.JButton jAdicionarMotorista;
    private javax.swing.JButton jAlterarCarro;
    private javax.swing.JButton jAlterarMotorista;
    private javax.swing.JButton jAtualizar;
    private javax.swing.JLabel jAvariado;
    private javax.swing.JLabel jCarro;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JButton jEntrar;
    private javax.swing.JButton jFechar;
    private javax.swing.JLabel jKmAtual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jMarca;
    private javax.swing.JLabel jMarca1;
    private javax.swing.JLabel jModelo;
    private javax.swing.JLabel jMotorista;
    private javax.swing.JButton jNovoCarro;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JButton jRemoverCarro;
    private javax.swing.JButton jRemoverMotorista;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jSenha;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel jUsuario;
    private javax.swing.JPanel jpGerenciar;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPanel jpRelatoriosRecebidos;
    private javax.swing.JTable jtRelatoriosRecebidos;
    private javax.swing.JLabel lNomeMotorista;
    private javax.swing.JLabel lUsuarioLogado;
    private javax.swing.JTextField tAvariado;
    private javax.swing.JTextField tKmAtual;
    private javax.swing.JTextField tMarca;
    private javax.swing.JTextField tMatricula;
    private javax.swing.JTextField tModelo;
    private javax.swing.JPasswordField tSenha;
    private javax.swing.JTextField tUsuario;
    // End of variables declaration//GEN-END:variables
}
