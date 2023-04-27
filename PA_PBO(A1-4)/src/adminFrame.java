package src;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class adminFrame extends JFrame{
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);
    private JTable table;
    private DefaultTableModel model;

    public void initialize() {
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

        //button add data
        JButton btnAdd = new JButton("Add");
        btnAdd.setFont(mainfont);
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFrame AddFrame = new addFrame();
                AddFrame.initialize();
                dispose(); 
            }    
        });
        //button edit data
        JButton btnEdit = new JButton("Edit");
        btnEdit.setFont(mainfont);
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editFrame EditFrame = new editFrame();
                EditFrame.initialize();
                dispose(); 
            }    
        });
        //button delete data
        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(mainfont);
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteForm DeleteForm = new deleteForm();
                DeleteForm.initialize();
                dispose(); 
            }    
        });
        //button Log Out data
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


        //add panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnAdd);
        buttonsPanel.add(btnEdit);
        buttonsPanel.add(btnDelete);
        buttonsPanel.add(btnlogOut);
        
        //deklar frame
        add(buttonsPanel, BorderLayout.SOUTH);
        setTitle("Administrator Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(900,600);
        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
    } 
}
