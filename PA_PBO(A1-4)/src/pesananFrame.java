package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.awt.*;


public class pesananFrame extends JFrame implements fungsiPesanan{
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);
    public JTable table;
    public DefaultTableModel model;

    public void initialize(User user){
        try {
            showTablePesanan(user);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Failed to Call Function");
            //e.printStackTrace();
        }

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
        //button delete pesanan
        JButton btnDeletePesanan = new JButton("Delete");
        btnDeletePesanan.setFont(mainfont);
        btnDeletePesanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deletePesanan DeletePesanan = new deletePesanan();
                DeletePesanan.initialize(user);
                dispose();
            }
        });
        //button bayar pesanan
        JButton btnBayar = new JButton("Bayar");
        btnBayar.setFont(mainfont);
        btnBayar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bayarFrame BayarFrame = new bayarFrame();
                BayarFrame.initialize(user);
                dispose();
            }
        });

        
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnBack);
        buttonsPanel.add(btnBayar);
        buttonsPanel.add(btnDeletePesanan);
        buttonsPanel.add(btnRiwayat);
        buttonsPanel.add(btnlogOut);

        //deklar frame
        add(buttonsPanel, BorderLayout.SOUTH);
        setTitle("Menu Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(900,600);
        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void showTablePesanan(User user) throws IOException {
        //buat tabel
        model = new DefaultTableModel();
        table = new JTable(model);
        add(new JScrollPane(table));
        final String DB_URL = "jdbc:mysql://localhost:3306/dbpbo";
        final String USERNAME = "root";
        final String PASSWORD = "";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM tbpesanan WHERE userId = '"+user.idUser+"' ";
            ResultSet rs = statement.executeQuery(sql);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            //tambahkan kolom
            for(int i = 1; i <= columnCount; i++){
                String columnName = metaData.getColumnName(i);
                model.addColumn(columnName);
            }
            //tambahkan baris
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for(int i = 1; i <= columnCount; i++){
                    row[i-1] = rs.getObject(i);
                }
                model.addRow(row);
            } 
            rs.close();
            statement.close();
            conn.close(); 

        } catch (Exception e) {
            System.out.println("Failed to Call Function");
        }
    }
}
