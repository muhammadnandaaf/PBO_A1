package src;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class riwayatFrame extends JFrame {
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);
    public JTable table;
    public DefaultTableModel model;
    
    public void initialize(User user){
        //button back
        JButton btnBack = new JButton("Back");
        btnBack.setFont(mainfont);
        btnBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                profileUser ProfileUser = new profileUser();
                ProfileUser.initialize(user);
                dispose(); 
            }
        });

        model = new DefaultTableModel();
        table = new JTable(model);
        add(new JScrollPane(table));
        final String DB_URL = "jdbc:mysql://localhost:3306/dbpbo";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            String sqlRiwayat = "SELECT tbperhiasan.kodePerhiasan, tbperhiasan.namaPerhiasan, tbperhiasan.jenisPerhiasan, tbpesanan.idPesanan, tbpesanan.jumlahPesanan, tbpesanan.totalHarga, tbbayar.idTransaksi, tbbayar.totalBayar FROM tbperhiasan JOIN tbpesanan ON tbperhiasan.kodePerhiasan=tbpesanan.perhiasanId JOIN tbbayar ON tbpesanan.idPesanan=tbbayar.pesananId ";
            ResultSet rsRiwayat = statement.executeQuery(sqlRiwayat);
            ResultSetMetaData metaData = rsRiwayat.getMetaData();
            int columnCount = metaData.getColumnCount();
            //tambahkan kolom
            for(int i = 1; i <= columnCount; i++){
                String columnName = metaData.getColumnName(i);
                model.addColumn(columnName);
            }
            //tambahkan baris
            while (rsRiwayat.next()) {
                Object[] row = new Object[columnCount];
                for(int i = 1; i <= columnCount; i++){
                    row[i-1] = rsRiwayat.getObject(i);
                }
                model.addRow(row);
            } 
            rsRiwayat.close();
            statement.close();
            conn.close();
            
        } catch (Exception e) {
            System.out.println("Failed to Call Function");
        }

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnBack);

        //deklar frame
        add(buttonsPanel, BorderLayout.SOUTH);
        setTitle("Riwayat Transaksi Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(900,600);
        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
