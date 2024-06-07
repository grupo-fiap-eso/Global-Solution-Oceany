package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import services.RelatorioDados;

public class ViewRelatorioDados {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	criarRelatorio();
            }
        });
    }

    private static void criarRelatorio() {
    	RelatorioDados relatorio = new RelatorioDados();
    	JFrame frame = new JFrame("Relatorios");

    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(400, 300);
        
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.append("Temperatura\n");
        textArea.append(relatorio.calcularMedia("temperatura"));
        textArea.append("\n\nSalinidade\n");
        textArea.append(relatorio.calcularMedia("salinidade"));
        textArea.append("\n\nPh\n");
        textArea.append(relatorio.calcularMedia("ph"));
        textArea.append("\n\nNivel de Nutrientes\n");
        textArea.append(relatorio.calcularMedia("nivel_nutrientes"));
        textArea.append("\n\nTeste\n");
        textArea.append(relatorio.calcularMedia("teste"));
        
        textArea.setAlignmentX(JLabel.CENTER_ALIGNMENT);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}