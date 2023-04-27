package src;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

public class regisForm extends JFrame{
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);
    JTextField tfUsername;
    JTextField tfEmail;
    JTextField tfPhone;
    JTextField tfAddress;
    JPasswordField pfPassword;
    
    public void initialize() {
        //label form
        JLabel lbRegisForm = new JLabel("Registrasi Form",SwingConstants.CENTER);
        lbRegisForm.setFont(mainfont);
        //form username
        JLabel lbUsername = new JLabel("Username");
        lbUsername.setFont(mainfont);
        tfUsername = new JTextField();
        tfUsername.setFont(mainfont);
        //form email
        JLabel lbEmail= new JLabel("Email");
        lbEmail.setFont(mainfont);
        tfEmail = new JTextField();
        tfEmail.setFont(mainfont);
        //form phone
        JLabel lbPhone = new JLabel("Phone Number");
        lbPhone.setFont(mainfont);
        tfPhone = new JTextField();
        tfPhone.setFont(mainfont);
        //form address
        JLabel lbAddress = new JLabel("Address");
        lbAddress.setFont(mainfont);
        tfAddress = new JTextField();
        tfAddress.setFont(mainfont);
        //form password
        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainfont);
        pfPassword = new JPasswordField();
        pfPassword.setFont(mainfont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbRegisForm);
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPhone);
        formPanel.add(tfPhone);
        formPanel.add(lbAddress);
        formPanel.add(tfAddress);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        //button simpan
        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setFont(mainfont);
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = tfUsername.getText();
                String Email = tfEmail.getText();
                String Phone = tfPhone.getText();
                String Address = tfAddress.getText();
                String Password = String.valueOf(pfPassword.getPassword());
                final String DB_URL = "jdbc:mysql://localhost:3306/dbpbo";
                final String USERNAME = "root";
                final String PASSWORD = "";
                try {
                    Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
                    String sql = "INSERT INTO tbuser (username,email,phone,address,password) VALUES (?,?,?,?,?)";
                    PreparedStatement preparedStatement = conn.prepareStatement(sql);
                    preparedStatement.setString(1, Username);
                    preparedStatement.setString(2, Email);
                    preparedStatement.setString(3, Phone);
                    preparedStatement.setString(4, Address);
                    preparedStatement.setString(5, Password);
                    int rowsInserted = preparedStatement.executeUpdate();
                    if (rowsInserted > 0) {
                        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
                    }
                    conn.close();
                    //balik ke halaman login
                } catch (Exception ex) {
                    System.out.println("Database Connection Failed");
                }
                loginForm LoginForm = new loginForm();
                LoginForm.initialize();
                dispose();          
            }
        });

        //button back
        JButton btnBack = new JButton("Back");
        btnBack.setFont(mainfont);
        btnBack.addActionListener(new ActionListener() {

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
        buttonsPanel.add(btnSimpan);
        buttonsPanel.add(btnBack);

        //deklar frame
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);
        setTitle("Registrasi Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,800);
        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
