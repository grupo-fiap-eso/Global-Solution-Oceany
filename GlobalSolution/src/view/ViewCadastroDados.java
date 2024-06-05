package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import dao.CadastroDadosDAO;
import model.CadastroDados;

public class ViewCadastroDados extends JFrame implements ActionListener {
    
    private static final long serialVersionUID = 1L;

    private JLabel lblResponsavel;
    private JLabel lblTemperatura;
    private JLabel lblPh;
    private JLabel lblSalinidade;
    private JLabel lblNivelNutriente;
    private JLabel lblDate;

    private JTextField txtResponsavel;
    private JTextField txtTemperatura;
    private JTextField txtPh;
    private JTextField txtSalinidade;
    private JTextField txtNivelNutriente;
    private JTextField txtDate;

    private JButton btnInserir;

    private JPanel pnlFormulario;
    private JPanel pnlBotoes;

    private CadastroDados cadastro;
    private CadastroDadosDAO dao;

    public ViewCadastroDados() {
        super("Cadastrar Dados de Cadastro");
        this.setLayout(new BorderLayout());
        this.setSize(400, 300);

        pnlBotoes = new JPanel(new FlowLayout());
        pnlFormulario = new JPanel(new GridBagLayout());

        GridBagConstraints posicoes = new GridBagConstraints();
        posicoes.insets = new Insets(3, 3, 3, 3);
        posicoes.anchor = GridBagConstraints.LINE_START;
        
        posicoes.gridx = 0;
        posicoes.gridy = 0;
        lblResponsavel = new JLabel("Responsável:");
        pnlFormulario.add(lblResponsavel, posicoes);
        
        posicoes.gridy = 1;
        lblTemperatura = new JLabel("Temperatura:");
        pnlFormulario.add(lblTemperatura, posicoes);
        
        posicoes.gridy = 2;
        lblPh = new JLabel("pH:");
        pnlFormulario.add(lblPh, posicoes);
        
        posicoes.gridy = 3;
        lblSalinidade = new JLabel("Salinidade:");
        pnlFormulario.add(lblSalinidade, posicoes);
        
        posicoes.gridy = 4;
        lblNivelNutriente = new JLabel("Nível de Nutriente:");
        pnlFormulario.add(lblNivelNutriente, posicoes);
        
        posicoes.gridy = 5;
        lblDate = new JLabel("Data:");
        pnlFormulario.add(lblDate, posicoes);

        posicoes.anchor = GridBagConstraints.LINE_END;
        posicoes.gridx = 1;
        posicoes.gridy = 0;
        txtResponsavel = new JTextField(10);
        pnlFormulario.add(txtResponsavel, posicoes);
        
        posicoes.gridy = 1;
        txtTemperatura = new JTextField(10);
        pnlFormulario.add(txtTemperatura, posicoes);
        
        posicoes.gridy = 2;
        txtPh = new JTextField(10);
        pnlFormulario.add(txtPh, posicoes);
        
        posicoes.gridy = 3;
        txtSalinidade = new JTextField(10);
        pnlFormulario.add(txtSalinidade, posicoes);
        
        posicoes.gridy = 4;
        txtNivelNutriente = new JTextField(10);
        pnlFormulario.add(txtNivelNutriente, posicoes);
        
        posicoes.gridy = 5;
        txtDate = new JTextField(10);
        pnlFormulario.add(txtDate, posicoes);

        btnInserir = new JButton("Inserir");
        btnInserir.addActionListener(this);
        pnlBotoes.add(btnInserir);

        add(pnlFormulario, BorderLayout.CENTER);
        add(pnlBotoes, BorderLayout.SOUTH);

        cadastro = new CadastroDados();
        dao = new CadastroDadosDAO();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            if (evento.getSource() == btnInserir) {
                if (txtResponsavel.getText().isEmpty() || txtTemperatura.getText().isEmpty() || txtPh.getText().isEmpty() || txtSalinidade.getText().isEmpty() || txtNivelNutriente.getText().isEmpty() || txtDate.getText().isEmpty()) {
                    // Notificar o usuário que os campos não podem estar vazios
                    return;
                }
                cadastro.setResponsavel(txtResponsavel.getText());
                cadastro.setTemperatura(Double.parseDouble(txtTemperatura.getText()));
                cadastro.setpH(Double.parseDouble(txtPh.getText()));
                cadastro.setSalinidade(Double.parseDouble(txtSalinidade.getText()));
                cadastro.setNivelNutriente(Double.parseDouble(txtNivelNutriente.getText()));
                cadastro.setDate(txtDate.getText());
                dao.inserir(cadastro);
                limparCampos();
            }
        } catch (NumberFormatException e) {
            // Notificar o usuário que os valores de temperatura, pH, salinidade e nível de nutriente devem ser números válidos
        } catch (Exception e) {
            // Notificar o usuário sobre qualquer erro
        }
    }

    private void limparCampos() {
        txtResponsavel.setText("");
        txtTemperatura.setText("");
        txtPh.setText("");
        txtSalinidade.setText("");
        txtNivelNutriente.setText("");
        txtDate.setText("");
    }


    public static void main(String[] args) {
        ViewCadastroDados janela = new ViewCadastroDados();
        janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
        janela.setVisible(true);
    }
}
