/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import com.bulenkov.darcula.DarculaLaf;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import org.jdesktop.xswingx.PromptSupport;

/**
 *
 * @author Kevin
 */
public class GUIPart extends JFrame {

        public GUIPart() {
                super("By Kevin Mwenda");
                initComponents();
                setResizable(false);
                setSize(505, 230);
                setLocationRelativeTo(null);
                time();
        }

        //<editor-fold defaultstate="collapsed" desc="private initComponents() method">
        private void initComponents() {
                panel = new JPanel();
                panel.setOpaque(false);
                FlowLayout layout = new FlowLayout();
                layout.setAlignment(FlowLayout.LEADING);
                layout.setHgap(25);
                layout.setVgap(25);
                panel.setLayout(layout);
                setDefaultCloseOperation(EXIT_ON_CLOSE);

                lblInput = new JLabel();
                lblInput.setForeground(Color.WHITE);
                lblInput.setFont(new Font("courier new", 4, 16));
                lblInput.setText(" Input Field");

                txtInput = new JTextField();
                txtInput.setForeground(Color.WHITE);
                txtInput.setFont(new Font("courier new", 4, 16));
                txtInput.setText("");
                txtInput.setColumns(30);
                PromptSupport.setPrompt("Input Text Here", txtInput);
                PromptSupport.setForeground(Color.GRAY, txtInput);
                PromptSupport.setFontStyle(4, txtInput);
                PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, txtInput);
                txtInput.addKeyListener(new KeyAdapter() {
                        @Override
                        public void keyReleased(KeyEvent e) {
                                Main.Main temp = new Main.Main(txtInput.getText());
                                String output = temp.reverseString();
                                txtOutput.setText(output);
                                txtOutput.setCaretPosition(0);
                        }
                });

                lblOutput = new JLabel();
                lblOutput.setForeground(Color.WHITE);
                lblOutput.setFont(new Font("courier new", 4, 16));
                lblOutput.setText("Output Field");

                txtOutput = new JTextField();
                txtOutput.setEnabled(false);
                txtOutput.setForeground(Color.WHITE);
                txtOutput.setFont(new Font("courier new", 4, 16));
                txtOutput.setText("");
                txtOutput.setColumns(30);
                PromptSupport.setPrompt("Text Appears Here", txtOutput);
                PromptSupport.setForeground(Color.GRAY, txtOutput);
                PromptSupport.setFontStyle(4, txtOutput);
                PromptSupport.setFocusBehavior(PromptSupport.FocusBehavior.SHOW_PROMPT, txtOutput);

                time = new JLabel();
                time.setForeground(Color.WHITE);
                time.setFont(new Font("DigifaceWide", 4, 24));
                time.setHorizontalAlignment(JLabel.CENTER);
                time.setBounds(25, 130, 455, 50);

                panel.add(lblInput);
                panel.add(txtInput);
                panel.add(lblOutput);
                panel.add(txtOutput);
                panel.setBounds(0, 0, 505, 130);
                getContentPane().add(panel);
                getContentPane().add(time);
                setLayout(null);
        }
        //</editor-fold>

        private void time() {
                new Thread() {
                        @Override
                        public void run() {
                                while (true) {
                                        String timeString = "";
                                        timeString += Calendar.getInstance().get(Calendar.DAY_OF_MONTH) + "/";
                                        timeString += Calendar.getInstance().get(Calendar.MONTH) + 1 + "/";
                                        timeString += Calendar.getInstance().get(Calendar.YEAR) + "   ";
                                        timeString += Calendar.getInstance().get(Calendar.HOUR) + " : ";
                                        timeString += Calendar.getInstance().get(Calendar.MINUTE) + " : ";
                                        timeString += Calendar.getInstance().get(Calendar.SECOND);
                                        time.setText(timeString);
                                }
                        }
                }.start();
        }

        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
                try {
                        UIManager.setLookAndFeel(new DarculaLaf());
                } catch (UnsupportedLookAndFeelException ulaf) {
                }

                new GUIPart().setVisible(true);
        }
        
        //<editor-fold defaultstate="collapsed" desc="Variable Declaration">
        private JLabel lblInput;
        private JLabel lblOutput;
        public JTextField txtInput;
        public JTextField txtOutput;
        private JLabel time;
        private JPanel panel;
        //</editor-fold>
}
