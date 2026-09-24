package Interface;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class JanelaInicial extends javax.swing.JFrame {

    private Usabilidade.ControleFinanceiro controle;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(JanelaInicial.class.getName()); //add pelo netbeans
    private CardLayout cardLayout;

    private Usabilidade.LancamentoRepository repositorio = new Usabilidade.LancamentoRepository();

    public JanelaInicial() {
        initComponents();

        aplicarMascaraData(receitaInputData); // Aplicando máscara para data no Lançamento de receitas
        aplicarMascaraData(despesaInputData); // Aplicando máscara para data no Lançamento de despesas

        aplicarMascaraValor(receitaInputValor); // Aplicando máscara para valor no Lançamento de receitas
        aplicarMascaraValor(despesaInputValor); // Aplicando máscara para valor no Lançamento de despesas

        // Criando lista das categorias de receita e despesa - Campo Choice da interface
        categoriaChoice.add("Salário");
        categoriaChoice.add("Décimo terceiro");
        categoriaChoice.add("Férias");
        categoriaChoice.add("Outras receitas");

        // Categorias de despesa
        despesaCategoriaChoice.add("Alimentação");
        despesaCategoriaChoice.add("Transporte");
        despesaCategoriaChoice.add("Residência");
        despesaCategoriaChoice.add("Saúde");
        despesaCategoriaChoice.add("Educação");
        despesaCategoriaChoice.add("Entretenimento");
        despesaCategoriaChoice.add("Outras despesas");

        cardLayout = (CardLayout) centralPanel.getLayout();
    }

    /**
     * Aplica uma máscara de formato ##/##/#### no campo de data, forçando o
     * usuário a digitar a data no formato dd/MM/yyyy, com "_" como
     * "placeholder".
     *
     * "setAllowsInvalid(false)": impede que o usuário digite caracteres não
     * numéricos. "setOverwriteMode(true)": ao digitar, substitui o caractere na
     * posição atual em vez de inserir.
     *
     * @param campo
     */
    private void aplicarMascaraData(javax.swing.JFormattedTextField campo) {
        try {
            javax.swing.text.MaskFormatter mascara = new javax.swing.text.MaskFormatter("##/##/####");
            mascara.setPlaceholderCharacter('_');
            mascara.setAllowsInvalid(false);  // não aceita caractere inválido
            mascara.setOverwriteMode(true);   // sobrescreve ao digitar, não insere
            mascara.install(campo);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Configura o campo de valor para aceitar apenas números no formato
     * monetário.
     *
     * "setMinimum(0.0)": não aceita valores negativos. "campo.setValue(0.0)":
     * exibe 0,00 quando o campo é carregado.
     *
     * @param campo
     */
    private void aplicarMascaraValor(javax.swing.JFormattedTextField campo) {
        javax.swing.text.NumberFormatter formatter = new javax.swing.text.NumberFormatter(
                new java.text.DecimalFormat("#,##0.00")
        );
        formatter.setMinimum(0.0);
        formatter.setAllowsInvalid(false);
        formatter.setOverwriteMode(false);
        campo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(formatter));
        campo.setValue(0.0); // Exibe 0,00 ao abrir
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloPrincipal = new javax.swing.JLabel();
        PainelLateral = new javax.swing.JPanel();
        IncluirReceitas = new javax.swing.JButton();
        IncluirDespesas = new javax.swing.JButton();
        ConsultaSaldoAtual = new javax.swing.JButton();
        ConsultarSaldoTotal = new javax.swing.JButton();
        ListarReceitas = new javax.swing.JButton();
        ListarDespesas = new javax.swing.JButton();
        ListarLancamentos = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        centralPanel = new javax.swing.JPanel();
        inicial = new javax.swing.JPanel();
        imagem = new javax.swing.JLabel();
        incluirDespesa = new javax.swing.JPanel();
        despesaTitulo = new javax.swing.JLabel();
        despesaDescricao = new javax.swing.JLabel();
        despesaInputDescricao = new javax.swing.JTextField();
        despesaValor = new javax.swing.JLabel();
        despesaInputValor = new javax.swing.JFormattedTextField();
        despesaData = new javax.swing.JLabel();
        despesaInputData = new javax.swing.JFormattedTextField();
        despesaCategoria = new javax.swing.JLabel();
        despesaCategoriaChoice = new java.awt.Choice();
        despesaSalvar = new javax.swing.JButton();
        incluirReceita = new javax.swing.JPanel();
        receitaTitulo = new javax.swing.JLabel();
        receitaDescricao = new javax.swing.JLabel();
        receitaInputDescricao = new javax.swing.JTextField();
        receitaValor = new javax.swing.JLabel();
        receitaInputValor = new javax.swing.JFormattedTextField();
        receitaCategoria = new javax.swing.JLabel();
        categoriaChoice = new java.awt.Choice();
        receitaSalvar = new javax.swing.JButton();
        receitaData = new javax.swing.JLabel();
        receitaInputData = new javax.swing.JFormattedTextField();
        consultaSaldoAtual = new javax.swing.JPanel();
        saldoAtualTitulo = new javax.swing.JLabel();
        saldoAtualValor = new javax.swing.JLabel();
        saldoAtualConsulta = new javax.swing.JButton();
        consultaSaldoTotal = new javax.swing.JPanel();
        saldoTotalTitulo = new javax.swing.JLabel();
        saldoTotalValor = new javax.swing.JLabel();
        saldoTotalConsulta = new javax.swing.JButton();
        listarReceitas = new javax.swing.JPanel();
        listarReceitasTitulo = new javax.swing.JLabel();
        receitasScroll = new javax.swing.JScrollPane();
        tabelaReceitas = new javax.swing.JTable();
        listarDespesas = new javax.swing.JPanel();
        listarDespesasTitulo = new javax.swing.JLabel();
        despesasScrol = new javax.swing.JScrollPane();
        tabelaDespesas = new javax.swing.JTable();
        listarLancamentos = new javax.swing.JPanel();
        listarLancamentosTitulo = new javax.swing.JLabel();
        listarLancamentosScroll = new javax.swing.JScrollPane();
        listarLancamentosTabela = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        tituloPrincipal.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        tituloPrincipal.setForeground(new java.awt.Color(0, 51, 102));
        tituloPrincipal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloPrincipal.setText("Controle Financeiro");
        tituloPrincipal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        PainelLateral.setBackground(new java.awt.Color(0, 102, 153));
        PainelLateral.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        IncluirReceitas.setText("Incluir receitas");
        IncluirReceitas.setToolTipText("");
        IncluirReceitas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IncluirReceitas.addActionListener(this::IncluirReceitasActionPerformed);

        IncluirDespesas.setText("Incluir despesas");
        IncluirDespesas.setToolTipText("");
        IncluirDespesas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        IncluirDespesas.addActionListener(this::IncluirDespesasActionPerformed);

        ConsultaSaldoAtual.setText("Consultar saldo atual");
        ConsultaSaldoAtual.setToolTipText("");
        ConsultaSaldoAtual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ConsultaSaldoAtual.addActionListener(this::ConsultaSaldoAtualActionPerformed);

        ConsultarSaldoTotal.setText("Consultar saldo total");
        ConsultarSaldoTotal.setToolTipText("");
        ConsultarSaldoTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ConsultarSaldoTotal.addActionListener(this::ConsultarSaldoTotalActionPerformed);

        ListarReceitas.setText("Listar receitas");
        ListarReceitas.setToolTipText("");
        ListarReceitas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListarReceitas.addActionListener(this::ListarReceitasActionPerformed);

        ListarDespesas.setText("Listar despesas");
        ListarDespesas.setToolTipText("");
        ListarDespesas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListarDespesas.addActionListener(this::ListarDespesasActionPerformed);

        ListarLancamentos.setText("Listar lançamentos");
        ListarLancamentos.setToolTipText("");
        ListarLancamentos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        ListarLancamentos.addActionListener(this::ListarLancamentosActionPerformed);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Menu");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout PainelLateralLayout = new javax.swing.GroupLayout(PainelLateral);
        PainelLateral.setLayout(PainelLateralLayout);
        PainelLateralLayout.setHorizontalGroup(
            PainelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLateralLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(PainelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ListarLancamentos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IncluirDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsultarSaldoTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ListarReceitas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ListarDespesas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(IncluirReceitas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsultaSaldoAtual, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLateralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );
        PainelLateralLayout.setVerticalGroup(
            PainelLateralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLateralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(IncluirDespesas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IncluirReceitas)
                .addGap(12, 12, 12)
                .addComponent(ConsultaSaldoAtual)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ConsultarSaldoTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ListarReceitas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ListarDespesas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ListarLancamentos)
                .addGap(118, 118, 118))
        );

        centralPanel.setLayout(new java.awt.CardLayout());

        imagem.setIcon(new javax.swing.ImageIcon("C:\\Users\\maisa\\OneDrive\\Imagens\\image-removebg-preview.png")); // NOI18N

        javax.swing.GroupLayout inicialLayout = new javax.swing.GroupLayout(inicial);
        inicial.setLayout(inicialLayout);
        inicialLayout.setHorizontalGroup(
            inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicialLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addComponent(imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(97, Short.MAX_VALUE))
        );
        inicialLayout.setVerticalGroup(
            inicialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inicialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 386, Short.MAX_VALUE)
                .addContainerGap())
        );

        centralPanel.add(inicial, "card4");

        incluirDespesa.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        despesaTitulo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        despesaTitulo.setForeground(new java.awt.Color(0, 51, 102));
        despesaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        despesaTitulo.setText("Incluir despesas");
        despesaTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        despesaDescricao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        despesaDescricao.setText("Descrição:");

        despesaValor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        despesaValor.setText("Valor:");

        despesaInputValor.addActionListener(this::despesaInputValorActionPerformed);

        despesaData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        despesaData.setText("Data:");

        despesaInputData.addActionListener(this::despesaInputDataActionPerformed);

        despesaCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        despesaCategoria.setText("Categoria");

        despesaSalvar.setBackground(new java.awt.Color(204, 255, 204));
        despesaSalvar.setText("Salvar");
        despesaSalvar.addActionListener(this::despesaSalvarActionPerformed);

        javax.swing.GroupLayout incluirDespesaLayout = new javax.swing.GroupLayout(incluirDespesa);
        incluirDespesa.setLayout(incluirDespesaLayout);
        incluirDespesaLayout.setHorizontalGroup(
            incluirDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(despesaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .addGroup(incluirDespesaLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(despesaInputValor, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(incluirDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(incluirDespesaLayout.createSequentialGroup()
                    .addGap(45, 45, 45)
                    .addGroup(incluirDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(incluirDespesaLayout.createSequentialGroup()
                            .addComponent(despesaDescricao)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(incluirDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(despesaInputDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(incluirDespesaLayout.createSequentialGroup()
                                    .addComponent(despesaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(137, 137, 137)
                                    .addComponent(despesaData)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(despesaInputData, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(despesaCategoria)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(despesaCategoriaChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(incluirDespesaLayout.createSequentialGroup()
                            .addGap(280, 280, 280)
                            .addComponent(despesaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(45, Short.MAX_VALUE)))
        );
        incluirDespesaLayout.setVerticalGroup(
            incluirDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incluirDespesaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(despesaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(93, 93, 93)
                .addComponent(despesaInputValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
            .addGroup(incluirDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(incluirDespesaLayout.createSequentialGroup()
                    .addGap(100, 100, 100)
                    .addGroup(incluirDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(despesaDescricao)
                        .addComponent(despesaInputDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(40, 40, 40)
                    .addGroup(incluirDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(incluirDespesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(despesaValor)
                            .addComponent(despesaData)
                            .addComponent(despesaInputData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(despesaCategoria))
                        .addComponent(despesaCategoriaChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(52, 52, 52)
                    .addComponent(despesaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );

        centralPanel.add(incluirDespesa, "card3");

        incluirReceita.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        receitaTitulo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        receitaTitulo.setForeground(new java.awt.Color(0, 51, 102));
        receitaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receitaTitulo.setText("Incluir receitas");
        receitaTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        receitaDescricao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        receitaDescricao.setText("Descrição:");

        receitaValor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        receitaValor.setText("Valor:");

        receitaInputValor.addActionListener(this::receitaInputValorActionPerformed);

        receitaCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        receitaCategoria.setText("Categoria");

        receitaSalvar.setBackground(new java.awt.Color(204, 255, 204));
        receitaSalvar.setText("Salvar");
        receitaSalvar.addActionListener(this::receitaSalvarActionPerformed);

        receitaData.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        receitaData.setText("Data:");

        receitaInputData.addActionListener(this::receitaInputDataActionPerformed);

        javax.swing.GroupLayout incluirReceitaLayout = new javax.swing.GroupLayout(incluirReceita);
        incluirReceita.setLayout(incluirReceitaLayout);
        incluirReceitaLayout.setHorizontalGroup(
            incluirReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(receitaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(incluirReceitaLayout.createSequentialGroup()
                .addGroup(incluirReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(incluirReceitaLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(receitaDescricao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(incluirReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(receitaInputDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(incluirReceitaLayout.createSequentialGroup()
                                .addComponent(receitaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receitaInputValor, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(receitaData)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(receitaInputData, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(receitaCategoria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoriaChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(incluirReceitaLayout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addComponent(receitaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        incluirReceitaLayout.setVerticalGroup(
            incluirReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(incluirReceitaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(receitaTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(incluirReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(receitaDescricao)
                    .addComponent(receitaInputDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(incluirReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(incluirReceitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(receitaValor)
                        .addComponent(receitaData)
                        .addComponent(receitaInputData, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(receitaCategoria)
                        .addComponent(receitaInputValor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(categoriaChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addComponent(receitaSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        centralPanel.add(incluirReceita, "card2");

        consultaSaldoAtual.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        saldoAtualTitulo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        saldoAtualTitulo.setForeground(new java.awt.Color(0, 51, 102));
        saldoAtualTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoAtualTitulo.setText("Consultar saldo atual");
        saldoAtualTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        saldoAtualValor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saldoAtualValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoAtualValor.setText("Saldo");
        saldoAtualValor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        saldoAtualConsulta.setBackground(new java.awt.Color(204, 255, 204));
        saldoAtualConsulta.setText("Consultar saldo atual");
        saldoAtualConsulta.addActionListener(this::saldoAtualConsultaActionPerformed);

        javax.swing.GroupLayout consultaSaldoAtualLayout = new javax.swing.GroupLayout(consultaSaldoAtual);
        consultaSaldoAtual.setLayout(consultaSaldoAtualLayout);
        consultaSaldoAtualLayout.setHorizontalGroup(
            consultaSaldoAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saldoAtualTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .addGroup(consultaSaldoAtualLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(saldoAtualValor, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaSaldoAtualLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saldoAtualConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290))
        );
        consultaSaldoAtualLayout.setVerticalGroup(
            consultaSaldoAtualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultaSaldoAtualLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(saldoAtualTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(saldoAtualValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoAtualConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        centralPanel.add(consultaSaldoAtual, "card5");

        consultaSaldoTotal.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        saldoTotalTitulo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        saldoTotalTitulo.setForeground(new java.awt.Color(0, 51, 102));
        saldoTotalTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoTotalTitulo.setText("Consultar saldo total");
        saldoTotalTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        saldoTotalValor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        saldoTotalValor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saldoTotalValor.setText("Saldo");
        saldoTotalValor.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        saldoTotalConsulta.setBackground(new java.awt.Color(204, 255, 204));
        saldoTotalConsulta.setText("Consultar saldo total");
        saldoTotalConsulta.addActionListener(this::saldoTotalConsultaActionPerformed);

        javax.swing.GroupLayout consultaSaldoTotalLayout = new javax.swing.GroupLayout(consultaSaldoTotal);
        consultaSaldoTotal.setLayout(consultaSaldoTotalLayout);
        consultaSaldoTotalLayout.setHorizontalGroup(
            consultaSaldoTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(saldoTotalTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .addGroup(consultaSaldoTotalLayout.createSequentialGroup()
                .addGap(258, 258, 258)
                .addComponent(saldoTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, consultaSaldoTotalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(saldoTotalConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(302, 302, 302))
        );
        consultaSaldoTotalLayout.setVerticalGroup(
            consultaSaldoTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(consultaSaldoTotalLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(saldoTotalTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(saldoTotalValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saldoTotalConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        centralPanel.add(consultaSaldoTotal, "card6");

        listarReceitas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        listarReceitasTitulo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        listarReceitasTitulo.setForeground(new java.awt.Color(0, 51, 102));
        listarReceitasTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listarReceitasTitulo.setText("Listar receitas");
        listarReceitasTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabelaReceitas.setModel(new javax.swing.table.DefaultTableModel(
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
        receitasScroll.setViewportView(tabelaReceitas);

        javax.swing.GroupLayout listarReceitasLayout = new javax.swing.GroupLayout(listarReceitas);
        listarReceitas.setLayout(listarReceitasLayout);
        listarReceitasLayout.setHorizontalGroup(
            listarReceitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listarReceitasTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .addGroup(listarReceitasLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(receitasScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        listarReceitasLayout.setVerticalGroup(
            listarReceitasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listarReceitasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(listarReceitasTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(receitasScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        centralPanel.add(listarReceitas, "card7");

        listarDespesas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        listarDespesasTitulo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        listarDespesasTitulo.setForeground(new java.awt.Color(0, 51, 102));
        listarDespesasTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listarDespesasTitulo.setText("Listar despesas");
        listarDespesasTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tabelaDespesas.setModel(new javax.swing.table.DefaultTableModel(
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
        despesasScrol.setViewportView(tabelaDespesas);

        javax.swing.GroupLayout listarDespesasLayout = new javax.swing.GroupLayout(listarDespesas);
        listarDespesas.setLayout(listarDespesasLayout);
        listarDespesasLayout.setHorizontalGroup(
            listarDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listarDespesasTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .addGroup(listarDespesasLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(despesasScrol, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        listarDespesasLayout.setVerticalGroup(
            listarDespesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listarDespesasLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(listarDespesasTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(despesasScrol, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        centralPanel.add(listarDespesas, "card8");

        listarLancamentos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        listarLancamentosTitulo.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        listarLancamentosTitulo.setForeground(new java.awt.Color(0, 51, 102));
        listarLancamentosTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        listarLancamentosTitulo.setText("Extrato detalhado");
        listarLancamentosTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        listarLancamentosScroll.setToolTipText("");

        listarLancamentosTabela.setModel(new javax.swing.table.DefaultTableModel(
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
        listarLancamentosScroll.setViewportView(listarLancamentosTabela);

        javax.swing.GroupLayout listarLancamentosLayout = new javax.swing.GroupLayout(listarLancamentos);
        listarLancamentos.setLayout(listarLancamentosLayout);
        listarLancamentosLayout.setHorizontalGroup(
            listarLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listarLancamentosTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
            .addGroup(listarLancamentosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(listarLancamentosScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        listarLancamentosLayout.setVerticalGroup(
            listarLancamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listarLancamentosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(listarLancamentosTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listarLancamentosScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );

        centralPanel.add(listarLancamentos, "card9");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(centralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(PainelLateral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(24, 24, 24)
                    .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(264, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(centralPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
            .addComponent(PainelLateral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(tituloPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(417, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IncluirReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncluirReceitasActionPerformed
        cardLayout.show(centralPanel, "card2");
    }//GEN-LAST:event_IncluirReceitasActionPerformed

    private void IncluirDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IncluirDespesasActionPerformed
        cardLayout.show(centralPanel, "card3");
    }//GEN-LAST:event_IncluirDespesasActionPerformed

    private void ConsultaSaldoAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultaSaldoAtualActionPerformed
        cardLayout.show(centralPanel, "card5");
    }//GEN-LAST:event_ConsultaSaldoAtualActionPerformed

    private void ConsultarSaldoTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarSaldoTotalActionPerformed
        cardLayout.show(centralPanel, "card6");
    }//GEN-LAST:event_ConsultarSaldoTotalActionPerformed

    private void ListarReceitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarReceitasActionPerformed
        cardLayout.show(centralPanel, "card7");

        controle = repositorio.carregarParaControle();

        String[] colunas = {"Descrição", "Valor", "Data", "Categoria"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(colunas, 0);

        java.text.NumberFormat fmt = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("pt", "BR"));

        for (Usabilidade.Receita r : controle.receitas()) {
            String valor = fmt.format(r.getValor());
            String data = r.getData().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String categoria = r.getCategoria().toString(); // usa o toString() do enum

            modelo.addRow(new Object[]{r.getDescricao(), valor, data, categoria});
        }

        tabelaReceitas.setModel(modelo);
    }//GEN-LAST:event_ListarReceitasActionPerformed

    private void ListarDespesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarDespesasActionPerformed
        cardLayout.show(centralPanel, "card8");

        controle = repositorio.carregarParaControle();

        String[] colunas = {"Descrição", "Valor", "Data", "Categoria"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(colunas, 0);

        java.text.NumberFormat fmt = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("pt", "BR"));

        for (Usabilidade.Despesa r : controle.despesas()) {
            String valor = fmt.format(r.getValor());
            String data = r.getData().format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            String categoria = r.getCategoria().toString(); // usa o toString() do enum

            modelo.addRow(new Object[]{r.getDescricao(), valor, data, categoria});
        }

        tabelaDespesas.setModel(modelo);
    }//GEN-LAST:event_ListarDespesasActionPerformed

    private void ListarLancamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListarLancamentosActionPerformed

        cardLayout.show(centralPanel, "card9");

        controle = repositorio.carregarParaControle();

        String[] colunas = {"Data", "Tipo", "Categoria", "Descrição", "Valor", "Saldo"};
        javax.swing.table.DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(colunas, 0);

        java.text.NumberFormat fmt = java.text.NumberFormat.getCurrencyInstance(new java.util.Locale("pt", "BR"));
        java.time.format.DateTimeFormatter dtf = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");

        ArrayList<Usabilidade.Lancamento> extrato = controle.ordenarExtrato();

        for (int i = 0; i < extrato.size(); i++) {
            Usabilidade.Lancamento l = extrato.get(i);

            String data = l.getData().format(dtf);
            String descricao = l.getDescricao();
            String valor = fmt.format(l.getValor());
            String saldo = fmt.format(controle.saldoAcumuladoAte(i));

            // Determina tipo
            String tipo;
            if (l.getTipo() == Usabilidade.Tipo.RECEITA) {
                tipo = "Receita";
            } else {
                tipo = "Despesa";
            }

            // Determina categoria
            String categoria;
            if (l instanceof Usabilidade.Receita) {
                Usabilidade.Receita r = (Usabilidade.Receita) l;
                categoria = r.getCategoria().toString();
            } else {
                Usabilidade.Despesa d = (Usabilidade.Despesa) l;
                categoria = d.getCategoria().toString();
            }

            modelo.addRow(new Object[]{data, tipo, categoria, descricao, valor, saldo});
        }

        listarLancamentosTabela.setModel(modelo);
    }//GEN-LAST:event_ListarLancamentosActionPerformed

    private void receitaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receitaSalvarActionPerformed
        //Método para inclusão de receitas - Atrleado ao botão "Salvar"

        String descricao = receitaInputDescricao.getText().trim();
        String valorStr = receitaInputValor.getText()
                .replace(".", "") // remove separador de milhar
                .replace(",", ".") // vírgula decimal → ponto
                .trim();
        String data = receitaInputData.getText();
        String categoria = categoriaChoice.getSelectedItem();

        // Validações da interface
        if (descricao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha a descrição!");
            return;
        }
        if (valorStr.isEmpty() || valorStr.equals(".")) {
            JOptionPane.showMessageDialog(this, "Preencha o valor!");
            return;
        }
        if (data.contains("_")) {
            JOptionPane.showMessageDialog(this, "Preencha a data corretamente!");
            return;
        }

        try {
            double valor = Double.parseDouble(valorStr);

            Usabilidade.CategoriaReceita cat
                    = Usabilidade.CategoriaReceita.fromDescricao(
                            categoriaChoice.getSelectedItem()
                    );

            java.time.LocalDate dataConvertida = java.time.LocalDate.parse(
                    data, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")
            );

            Usabilidade.Receita receita = new Usabilidade.Receita(
                    descricao, valor, dataConvertida, cat
            );

            repositorio.salvar("RECEITA", descricao, valor, data, cat.name());
            JOptionPane.showMessageDialog(this, "Receita salva com sucesso!");

            // Limpa os campos
            receitaInputDescricao.setText("");
            receitaInputValor.setValue(0.0);
            receitaInputData.setText("");
            aplicarMascaraData(receitaInputData);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido! Use apenas números.");
        } catch (java.time.format.DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida! Informe uma data válida.");
        } catch (IllegalArgumentException e) {
            // Captura exceções do backend (Lancamento, ControleFinanceiro)
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        }

    }//GEN-LAST:event_receitaSalvarActionPerformed

    private void receitaInputDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receitaInputDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receitaInputDataActionPerformed

    private void despesaInputDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despesaInputDataActionPerformed

    }//GEN-LAST:event_despesaInputDataActionPerformed

    private void despesaSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despesaSalvarActionPerformed
        //Método para inclusão de receitas - Atrleado ao botão "Salvar"
        
        String descricao = despesaInputDescricao.getText().trim();
        String valorStr = despesaInputValor.getText()
                .replace(".", "")
                .replace(",", ".")
                .trim();
        String data = despesaInputData.getText();
        String categoria = despesaCategoriaChoice.getSelectedItem();

        // Validações da interface
        if (descricao.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha a descrição!");
            return;
        }
        if (valorStr.isEmpty() || valorStr.equals(".")) {
            JOptionPane.showMessageDialog(this, "Preencha o valor!");
            return;
        }
        if (data.contains("_")) {
            JOptionPane.showMessageDialog(this, "Preencha a data corretamente!");
            return;
        }

        try {
            double valor = Double.parseDouble(valorStr);

            // Instancia a receita — se os dados forem inválidos, o construtor lança exceção
            Usabilidade.CategoriaDespesa cat
                    = Usabilidade.CategoriaDespesa.fromDescricao(
                            despesaCategoriaChoice.getSelectedItem()
                    );

            java.time.LocalDate dataConvertida = java.time.LocalDate.parse(
                    data, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy")
            );

            Usabilidade.Despesa despesa = new Usabilidade.Despesa(
                    descricao, valor, dataConvertida, cat
            );

            // Os dados são válidos, será salva no CSV
            repositorio.salvar("DESPESA", descricao, valor, data, cat.name());
            JOptionPane.showMessageDialog(this, "Despesa salva com sucesso!");

            // Limpa os campos
            despesaInputDescricao.setText("");
            despesaInputValor.setValue(0.0);
            despesaInputData.setText("");
            aplicarMascaraData(despesaInputData);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido! Use apenas números.");
        } catch (java.time.format.DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida! Use o formato dd/MM/aaaa.");
        } catch (IllegalArgumentException e) {
            // Captura exceções do backend (Lancamento, ControleFinanceiro)
            JOptionPane.showMessageDialog(this, e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro inesperado: " + e.getMessage());
        }
    }//GEN-LAST:event_despesaSalvarActionPerformed

    private void saldoAtualConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoAtualConsultaActionPerformed
        controle = repositorio.carregarParaControle();
        double saldo = controle.saldoAtual();
        saldoAtualValor.setText(String.format("Saldo atual: R$ %.2f", saldo));
    }//GEN-LAST:event_saldoAtualConsultaActionPerformed

    private void despesaInputValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_despesaInputValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_despesaInputValorActionPerformed

    private void receitaInputValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_receitaInputValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_receitaInputValorActionPerformed

    private void saldoTotalConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saldoTotalConsultaActionPerformed
        controle = repositorio.carregarParaControle();
        double saldo = controle.saldoTotal();
        saldoTotalValor.setText(String.format("Saldo total: R$ %.2f", saldo));
    }//GEN-LAST:event_saldoTotalConsultaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new JanelaInicial().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConsultaSaldoAtual;
    private javax.swing.JButton ConsultarSaldoTotal;
    private javax.swing.JButton IncluirDespesas;
    private javax.swing.JButton IncluirReceitas;
    private javax.swing.JButton ListarDespesas;
    private javax.swing.JButton ListarLancamentos;
    private javax.swing.JButton ListarReceitas;
    private javax.swing.JPanel PainelLateral;
    private java.awt.Choice categoriaChoice;
    private javax.swing.JPanel centralPanel;
    private javax.swing.JPanel consultaSaldoAtual;
    private javax.swing.JPanel consultaSaldoTotal;
    private javax.swing.JLabel despesaCategoria;
    private java.awt.Choice despesaCategoriaChoice;
    private javax.swing.JLabel despesaData;
    private javax.swing.JLabel despesaDescricao;
    private javax.swing.JFormattedTextField despesaInputData;
    private javax.swing.JTextField despesaInputDescricao;
    private javax.swing.JFormattedTextField despesaInputValor;
    private javax.swing.JButton despesaSalvar;
    private javax.swing.JLabel despesaTitulo;
    private javax.swing.JLabel despesaValor;
    private javax.swing.JScrollPane despesasScrol;
    private javax.swing.JLabel imagem;
    private javax.swing.JPanel incluirDespesa;
    private javax.swing.JPanel incluirReceita;
    private javax.swing.JPanel inicial;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel listarDespesas;
    private javax.swing.JLabel listarDespesasTitulo;
    private javax.swing.JPanel listarLancamentos;
    private javax.swing.JScrollPane listarLancamentosScroll;
    private javax.swing.JTable listarLancamentosTabela;
    private javax.swing.JLabel listarLancamentosTitulo;
    private javax.swing.JPanel listarReceitas;
    private javax.swing.JLabel listarReceitasTitulo;
    private javax.swing.JLabel receitaCategoria;
    private javax.swing.JLabel receitaData;
    private javax.swing.JLabel receitaDescricao;
    private javax.swing.JFormattedTextField receitaInputData;
    private javax.swing.JTextField receitaInputDescricao;
    private javax.swing.JFormattedTextField receitaInputValor;
    private javax.swing.JButton receitaSalvar;
    private javax.swing.JLabel receitaTitulo;
    private javax.swing.JLabel receitaValor;
    private javax.swing.JScrollPane receitasScroll;
    private javax.swing.JButton saldoAtualConsulta;
    private javax.swing.JLabel saldoAtualTitulo;
    private javax.swing.JLabel saldoAtualValor;
    private javax.swing.JButton saldoTotalConsulta;
    private javax.swing.JLabel saldoTotalTitulo;
    private javax.swing.JLabel saldoTotalValor;
    private javax.swing.JTable tabelaDespesas;
    private javax.swing.JTable tabelaReceitas;
    private javax.swing.JLabel tituloPrincipal;
    // End of variables declaration//GEN-END:variables
}
