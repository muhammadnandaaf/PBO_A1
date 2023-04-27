package src;


import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Mainframe extends JFrame{
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);
    private JTable table;
    private DefaultTableModel model;

    public void initialize(User user){
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
            String sql = "SELECT * FROM tbperhiasan";
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

        //button profile
        JButton btnProfile = new JButton("Profile");
        btnProfile.setFont(mainfont);
        btnProfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                profileUser ProfileUser = new profileUser();
                ProfileUser.initialize(user);
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
        //button Order
        JButton btnOrder = new JButton("Order");
        btnOrder.setFont(mainfont);
        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderFrame OrderFrame = new orderFrame();
                OrderFrame.initialize(user);
                dispose();
            }
        });


        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnProfile);
        buttonsPanel.add(btnOrder);
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
}
