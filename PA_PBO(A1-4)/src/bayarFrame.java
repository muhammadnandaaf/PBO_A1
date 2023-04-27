package src;

import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class bayarFrame extends JFrame{
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);
    public JTextField tfidPesanan;
    public JTextField tftotalBayar;

    public void initialize(User user){
        JLabel lbbayarFrame = new JLabel("Order Form",SwingConstants.CENTER);
        lbbayarFrame.setFont(mainfont);
        //form id Pesanan
        JLabel lbidPesanan = new JLabel("Id Pesanan");
        lbidPesanan.setFont(mainfont);
        tfidPesanan = new JTextField();
        tfidPesanan.setFont(mainfont);
         //form total bayaran
         JLabel lbtotalBayar = new JLabel("Jumlah Pesanan");
         lbtotalBayar.setFont(mainfont);
         tftotalBayar = new JTextField();
         tftotalBayar.setFont(mainfont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbbayarFrame);
        formPanel.add(lbidPesanan);
        formPanel.add(tfidPesanan);
        formPanel.add(lbtotalBayar);
        formPanel.add(tftotalBayar);

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

        //button bayar pesanan
        JButton btnBayar = new JButton("Bayar");
        btnBayar.setFont(mainfont);
        btnBayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idPesanan = tfidPesanan.getText();
                Integer intidPesanan = Integer.parseInt(idPesanan);
                String totalBayar = tftotalBayar.getText();
                Integer intTotalBayar = Integer.parseInt(totalBayar);
                final String DB_URL = "jdbc:mysql://localhost:3306/dbpbo";
                final String USERNAME = "root";
                final String PASSWORD = "";
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    //ambil id pesanan apakah ada atau tidak
                    String sqlCheck = "SELECT * FROM tbpesanan WHERE idPesanan = '"+intidPesanan+"' ";
                    PreparedStatement statement = conn.prepareStatement(sqlCheck);
                    ResultSet resultCheck = statement.executeQuery();
                    if(resultCheck.next()){
                        //ambil kolom harga di tabel pesanan
                        String sqlHarga = "SELECT totalHarga FROM tbpesanan WHERE idPesanan = '"+intidPesanan+"' ";
                        PreparedStatement statementsqlHarga = conn.prepareStatement(sqlHarga);
                        ResultSet resultHarga = statementsqlHarga.executeQuery();
                        if(resultHarga.next()){
                            Integer totalHarga = resultHarga.getInt("totalHarga");
                            // JOptionPane.showMessageDialog(null, "Total Harga = " + totalHarga);
                            if(intTotalBayar >= totalHarga){
                                // JOptionPane.showMessageDialog(null, "Harga Yang Dibayar = "+intTotalBayar+"\nidUser = "+user.idUser+"\nidPesanan = "+intidPesanan);

                                String sqlBayar = "INSERT INTO tbbayar (pesananId,userId,totalBayar) VALUES (?,?,?)";
                                PreparedStatement preparedStatementBayar = conn.prepareStatement(sqlBayar);
                                preparedStatementBayar.setInt(1, intidPesanan);
                                preparedStatementBayar.setInt(2, user.idUser);
                                preparedStatementBayar.setInt(3, intTotalBayar);

                                int rowsInserted = preparedStatementBayar.executeUpdate();
                                if (rowsInserted > 0) {
                                    JOptionPane.showMessageDialog(null, "Perhiasan Berhasil Dibayar");
                                    pesananFrame PesananFrame = new pesananFrame();
                                    PesananFrame.initialize(user);
                                    dispose();
                                }else{
                                    JOptionPane.showMessageDialog(null, "Perhiasan Gagal Dibayar");
                                }
                            }else{
                                JOptionPane.showMessageDialog(null, "Bayar Sesuai Harga");
                            }
                        }else{
                            JOptionPane.showMessageDialog(null, "Harga Tidak Ada");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "ID Pesanan Tidak Ada");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Failed to Call Function");
                }
            }
        });

        //add panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnBack);
        buttonsPanel.add(btnBayar);
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
