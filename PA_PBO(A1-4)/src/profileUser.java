package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class profileUser extends JFrame {
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);

    public void initialize(User user) {
        JLabel lbProfileForm = new JLabel("Profile Form",SwingConstants.CENTER);
        lbProfileForm.setFont(mainfont);
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(0, 2, 5, 5));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        infoPanel.add(new JLabel("ID User"));
        String kodeUser = Integer.toString(user.idUser);
        infoPanel.add(new JLabel(kodeUser));
        infoPanel.add(new JLabel("Name"));
        infoPanel.add(new JLabel(user.username));
        infoPanel.add(new JLabel("Email"));
        infoPanel.add(new JLabel(user.email));
        infoPanel.add(new JLabel("Phone"));
        infoPanel.add(new JLabel(user.phone));
        infoPanel.add(new JLabel("Address"));
        infoPanel.add(new JLabel(user.address));


        Component[] labels = infoPanel.getComponents();
        
        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(new Font("Geneva", Font.BOLD, 20));
        }
        add(infoPanel, BorderLayout.NORTH);

        //button back
        JButton btnBack = new JButton("Back");
        btnBack.setFont(mainfont);
        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Mainframe mainframe = new Mainframe();
                mainframe.initialize(user);
                dispose();
            }
        });
        //button riwayat
        JButton btnRiwayat = new JButton("Riwayat");
        btnRiwayat.setFont(mainfont);
        btnRiwayat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riwayatFrame RiwayatFrame = new riwayatFrame();
                RiwayatFrame.initialize(user);
                dispose();
            }
        });
        //button pesanan
        JButton btnPesanan = new JButton("Pesanan");
        btnPesanan.setFont(mainfont);
        btnPesanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesananFrame PesananFrame = new pesananFrame();
                PesananFrame.initialize(user);
                dispose();
            }
        });
        //button log out
        JButton btnlogOut = new JButton("Log Out");
        btnlogOut.setFont(mainfont);
        btnlogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginForm LoginForm = new loginForm();
                LoginForm.initialize();
                dispose();   
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnBack);
        buttonsPanel.add(btnPesanan);
        buttonsPanel.add(btnRiwayat);
        buttonsPanel.add(btnlogOut);

        setTitle("Profile User");
        add(buttonsPanel, BorderLayout.SOUTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
