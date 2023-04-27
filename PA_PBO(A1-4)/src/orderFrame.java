package src;

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.io.IOException;
import java.sql.*;


public class orderFrame extends JFrame {
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);
    JTextField tfkodePerhiasan;
    JTextField tfjumlahPesanan;
    JTextField tfidUser;

    public void initialize(User user){
        //form
        JLabel lbOrderForm = new JLabel("Order Form",SwingConstants.CENTER);
        lbOrderForm.setFont(mainfont);
        //form id user
        // JLabel lbidUser = new JLabel("ID User");
        // lbidUser.setFont(mainfont);
        // tfidUser = new JTextField();
        // tfidUser.setFont(mainfont);
        //form kode perhiasan
        JLabel lbkodePerhiasan = new JLabel("Kode Perhiasan Lihat Menu");
        lbkodePerhiasan.setFont(mainfont);
        tfkodePerhiasan = new JTextField();
        tfkodePerhiasan.setFont(mainfont);
        //form jumlah pesanan
        JLabel lbjumlahPesanan = new JLabel("Jumlah Pesanan");
        lbjumlahPesanan.setFont(mainfont);
        tfjumlahPesanan = new JTextField();
        tfjumlahPesanan.setFont(mainfont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbOrderForm);
        formPanel.add(lbkodePerhiasan);
        formPanel.add(tfkodePerhiasan);
        formPanel.add(lbjumlahPesanan);
        formPanel.add(tfjumlahPesanan);
        // formPanel.add(lbidUser);
        // formPanel.add(tfidUser);

        //button back data
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
        //button pesanan
        JButton btnPesan = new JButton("Pesan");
        btnPesan.setFont(mainfont);
        btnPesan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String kodePerhiasan = tfkodePerhiasan.getText();
                String jumlahPesanan = tfjumlahPesanan.getText();
                Integer intJumlah = Integer.parseInt(jumlahPesanan);

                final String DB_URL = "jdbc:mysql://localhost:3306/dbpbo";
                final String USERNAME = "root";
                final String PASSWORD = "";
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    String sqlCheck = "SELECT * FROM tbperhiasan WHERE kodePerhiasan = '"+kodePerhiasan+"' ";
                    PreparedStatement statement = conn.prepareStatement(sqlCheck);
                    ResultSet resultCheck = statement.executeQuery();
                    if (resultCheck.next()) {
                            String hargaSql = "SELECT harga FROM tbperhiasan WHERE kodePerhiasan = '"+kodePerhiasan+"' ";
                            PreparedStatement statementHarga = conn.prepareStatement(hargaSql);
                            ResultSet resultHargaSql = statementHarga.executeQuery();
                            while (resultHargaSql.next()) {
                                Integer harga = resultHargaSql.getInt("harga");
                                Integer totalHarga = intJumlah * harga;
                                String pesananSql = "INSERT INTO tbpesanan (userId,perhiasanId,jumlahPesanan,totalHarga) VALUES (?,?,?,?)";
                                PreparedStatement preparedStatementPesan = conn.prepareStatement(pesananSql);
                                preparedStatementPesan.setInt(1, user.idUser);
                                preparedStatementPesan.setString(2, kodePerhiasan);
                                preparedStatementPesan.setInt(3, intJumlah);
                                preparedStatementPesan.setInt(4, totalHarga);
                                int rowsInserted = preparedStatementPesan.executeUpdate();
                                if (rowsInserted > 0) {
                                    JOptionPane.showMessageDialog(null, "Perhiasan Berhasil Dipesan");
                                    pesananFrame PesananFrame = new pesananFrame();
                                    PesananFrame.initialize(user);
                                    dispose();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Perhiasan Gagal Dipesan");
                                }
                            }        
                        }else{
                        JOptionPane.showMessageDialog(null, "Kode Barang Tidak Ada");
                    }
                    conn.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"Failed to Call Function");
                }
            }
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnPesan);
        buttonsPanel.add(btnBack);

        //deklar frame
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);
        setTitle("Order Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(500,600);
        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
    }
}


