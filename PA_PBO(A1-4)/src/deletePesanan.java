package src;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class deletePesanan extends JFrame{
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);
    public JTextField tfidPesanan;
    public void initialize(User user){
        //form
        JLabel lbdeletePesanan = new JLabel("Edit Form",SwingConstants.CENTER);
        lbdeletePesanan.setFont(mainfont);
        //form kode perhiasan
        JLabel lbidPesanan = new JLabel("ID Pesanan");
        lbidPesanan.setFont(mainfont);
        tfidPesanan = new JTextField();
        tfidPesanan.setFont(mainfont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbdeletePesanan);
        formPanel.add(lbidPesanan);
        formPanel.add(tfidPesanan);

        //button back data
        JButton btnBack = new JButton("Back");
        btnBack.setFont(mainfont);
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesananFrame PesananFrame = new pesananFrame();
                PesananFrame.initialize(user);
                dispose(); 
            }
        });
        //button back data
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(mainfont);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                final String DB_URL = "jdbc:mysql://localhost:3306/dbpbo";
                final String USERNAME = "root";
                final String PASSWORD = "";
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    String deleteQuery = "DELETE FROM tbpesanan WHERE idPesanan = '"+tfidPesanan.getText()+"'";
                    PreparedStatement statement = conn.prepareStatement(deleteQuery);
                    int rowsAffected = statement.executeUpdate(deleteQuery);
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null,"Pesanan berhasil dibatalkan.");
                        pesananFrame PesananFrame = new pesananFrame();
                        PesananFrame.initialize(user);
                        dispose();
                    }else{
                        JOptionPane.showMessageDialog(null,"Data pesanan tidak ada.");
                    }conn.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Failed to Call Function");
                }
            }
        });
        //add panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnBack);
        buttonsPanel.add(btnDelete);
        //deklar frame
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);
        setTitle("Edit Data Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,500);
        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
