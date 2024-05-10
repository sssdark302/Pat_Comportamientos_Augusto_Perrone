package Modelo_Vista_Controlador.src.Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Vista extends JFrame {
    private JTextArea textAreaInput = new JTextArea();
    private JTextArea textAreaOutput = new JTextArea();
    private JButton btnAnalyze = new JButton("Analizar");
    private JButton btnClear = new JButton("Limpiar");

    public Vista() {
        setTitle("Analizador Léxico");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        textAreaInput.setLineWrap(true);
        JScrollPane scrollPaneInput = new JScrollPane(textAreaInput);

        textAreaOutput.setLineWrap(true);
        textAreaOutput.setEditable(false);
        JScrollPane scrollPaneOutput = new JScrollPane(textAreaOutput);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnAnalyze);
        buttonPanel.add(btnClear);

        add(scrollPaneInput, BorderLayout.CENTER);
        add(scrollPaneOutput, BorderLayout.SOUTH);
        add(buttonPanel, BorderLayout.NORTH);

    }

    public void addAnalyzeListener(ActionListener listener) {
        btnAnalyze.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        btnClear.addActionListener(listener);
    }

    public String getInputText() {
        return textAreaInput.getText();
    }

    public JTextArea getTextAreaInput() {
        return textAreaInput;
    }

    public void setTextAreaInput(JTextArea textAreaInput) {
        this.textAreaInput = textAreaInput;
    }

    public JTextArea getTextAreaOutput() {
        return textAreaOutput;
    }

    public void setTextAreaOutput(JTextArea textAreaOutput) {
        this.textAreaOutput = textAreaOutput;
    }

    public JButton getBtnAnalyze() {
        return btnAnalyze;
    }

    public void setBtnAnalyze(JButton btnAnalyze) {
        this.btnAnalyze = btnAnalyze;
    }

    public JButton getBtnClear() {
        return btnClear;
    }

    public void setBtnClear(JButton btnClear) {
        this.btnClear = btnClear;
    }

    public void setOutputText(String text) {
        textAreaOutput.setText(text);
    }
}