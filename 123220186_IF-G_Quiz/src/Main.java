/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class guiMenu extends JFrame implements ActionListener{
    JLabel lbUsername, lbPassword;
    JTextField tfUsername, tfPassword;
    JButton btnLogin;
    JButton btnKeluar;
    
    guiMenu(){
        setTitle("HALAMAN LOGIN");
        lbUsername = new JLabel("Username    : ");
        tfUsername = new JTextField(5);
        lbPassword = new JLabel("Password   : ");
        tfPassword = new JTextField(5);
        btnLogin = new JButton("Login");
        btnKeluar = new JButton("Exit");
        
        setLayout(new GridLayout(3,1));
        add(lbUsername);
        add(tfUsername);
        add(lbPassword);
        add(tfPassword);
        add(btnLogin);
        btnLogin.addActionListener(this);
        add(btnKeluar);
        btnKeluar.addActionListener(this);
        
        setSize(350,200);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnLogin){
            JOptionPane.showMessageDialog(null, "Login");
            this.dispose();
            new guiLogin();
        }else if(e.getSource() == btnKeluar){
            this.dispose();
        }
    }
}

class guiLogin extends JFrame implements ActionListener{
    JLabel lbNama, lbNim, lbTugas, lbQuiz;
    JRadioButton prak, teori;
    JTextField tfNama, tfNim, tfTugas, tfQuiz;
    JButton btnHasil;
    
    guiLogin(){
        setTitle("HALAMAN INPUT NILAI");
        lbNama = new JLabel("Nama   : ");
        tfNama = new JTextField(5);
        lbNim = new JLabel("NIM : ");
        tfNim = new JTextField(5);
        prak = new JRadioButton("Kelas Praktikum");
        teori = new JRadioButton("Kelas Teori");
        lbTugas = new JLabel("Nilai Tugas   : ");
        tfTugas = new JTextField(5);
        lbQuiz = new JLabel("Nilai Quiz : ");
        tfQuiz = new JTextField(5);
        btnHasil = new JButton("Hasil");
        
        setLayout(new GridLayout(6,2));
        add(lbNama);
        add(tfNama);
        add(lbNim);
        add(tfNim);
        add(prak);
        prak.setHorizontalAlignment(JRadioButton.CENTER);
        add(teori);
        teori.setHorizontalAlignment(JRadioButton.CENTER);
        add(lbTugas);
        add(tfTugas);
        add(lbQuiz);
        add(tfQuiz);
        add(btnHasil);
        btnHasil.addActionListener(this);
        
        setSize(500,200);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == btnHasil){
            this.dispose();
            new guiHasil(tfNama.getText(), tfNim.getText(), prak.getText(), teori.getText(), tfTugas.getText(), tfQuiz.getText());
        }
    }
    
    class guiHasil extends JFrame implements ActionListener{
        JLabel lbLulus, lbTotal;
        JTextField tfLulus, tfTotal;
        JButton btnLogout;
        
        guiHasil(String na, String ni, String pr, String te, String t, String q){
            setTitle("TRANSKRIP NILAI");
            lbNama = new JLabel();
            lbNim = new JLabel();
            prak = new JRadioButton();
            teori = new JRadioButton();
            
            tfNama = new JTextField(5);
            tfNim = new JTextField(5);
            tfLulus = new JTextField();
            tfTotal = new JTextField();
            btnLogout = new JButton("Logout");
            
            double total = (Integer.parseInt(t)*0.3) + (Integer.parseInt(q)*0.7);
            
            setLayout(new GridLayout(7,2));
            add(lbNama);
            add(tfNama);
            tfNama.setText(na);
            add(lbNim);
            add(tfNim);
            tfNim.setText(ni);
            add(prak);
            prak.setText(pr);
            add(teori);
            teori.setText(te);
            add(lbTugas);
            add(tfTugas);
            tfTugas.setText(t);
            add(lbQuiz);
            add(tfQuiz);
            tfQuiz.setText(q);
            add(btnLogout);
            btnLogout.addActionListener(this);
            
            add(tfTotal);
            tfTotal.setText(String.valueOf((total)));
            add(tfLulus);
            if(total >= 85){
                lbLulus.setText("Pass");
            }else{
                lbLulus.setText("Not Pass");
            }
            
            setSize(500,300);
            setVisible(true);
            setLocationRelativeTo(null);
        }
        @Override
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == btnLogout){
                this.dispose();
            }
        }
    }
}

public class Main {
    public static void main(String[] args){
        new guiMenu();
    }
}
