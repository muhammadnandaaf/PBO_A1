package src;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import com.formdev.flatlaf.FlatDarkLaf;

public class loginForm extends JFrame{
    final private Font mainfont = new Font("Geneva", Font.BOLD, 20);
    aksesAdmin admin = new aksesAdmin("admin", "admin", "admin123");
    JTextField tfUsername;
    JPasswordField pfPassword;

    public void initialize() {
        //label Form
        JLabel lbLoginForm = new JLabel("Login Form",SwingConstants.CENTER);
        lbLoginForm.setFont(mainfont);

        //form username
        JLabel lbUsername = new JLabel("Username");
        lbUsername.setFont(mainfont);
        tfUsername = new JTextField();
        tfUsername.setFont(mainfont);

        //form password
        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainfont);
        pfPassword = new JPasswordField();
        pfPassword.setFont(mainfont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0,1,10,10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

        //button login
        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(mainfont);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Username = tfUsername.getText();
                String Password = String.valueOf(pfPassword.getPassword());

                User user = getAuthenticatedUser(Username,Password);
                
                if (tfUsername.getText().equals(admin.getUsernameAdmin()) && String.valueOf(pfPassword.getPassword()).equals(admin.getPasswordAdmin()) ) {
                    adminFrame AdminFrame = new adminFrame();
                    AdminFrame.initialize();
                    dispose();
                }
                else if (user != null){
                    Mainframe mainframe = new Mainframe();
                    mainframe.initialize(user);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(loginForm.this, 
                    "Username atau Password Salah Bro!", 
                    "Try again", 
                    JOptionPane.ERROR_MESSAGE);
                }
            }  
        });

        //button regis
        JButton btnRegis = new JButton("Regis");
        btnRegis.setFont(mainfont);
        btnRegis.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                regisForm RegisForm = new regisForm();
                RegisForm.initialize();
                dispose();
            }
        });

        //button exit
        JButton btnExit = new JButton("Exit");
        btnExit.setFont(mainfont);
        btnExit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            } 
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1,2,10,0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        buttonsPanel.add(btnLogin);
        buttonsPanel.add(btnExit);
        buttonsPanel.add(btnRegis);

        //Deklar Frame
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);
        setTitle("Login Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400,500);
        setMinimumSize(new Dimension(350,450));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private User getAuthenticatedUser(String username, String password){
        User user = null;

        final String DB_URL = "jdbc:mysql://localhost:3306/dbpbo";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String sql = "SELECT * FROM tbuser WHERE username=? AND password=?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultset = preparedStatement.executeQuery();

            if (resultset.next()){
                user = new User();
                user.idUser = resultset.getInt("idUser");
                user.username = resultset.getString("username");
                user.email = resultset.getString("email");
                user.phone = resultset.getString("phone");
                user.address = resultset.getString("address");
                user.password = resultset.getString("password");
            }
            preparedStatement.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Database Connection Failed");
        }
    return user;  
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        loginForm LoginForm = new loginForm();
        LoginForm.initialize();

    }   
}
