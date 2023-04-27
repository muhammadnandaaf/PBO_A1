// package fileSampah;
// INI SALAH SEMUA!!!!!!!!!!!!!!!!!!!!!!!!!!!!


// import java.awt.*;
// import javax.swing.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.sql.*;

// public class editForm extends JFrame{
//     editFrame ambilEdit = new editFrame(); 

//     final private Font mainfont = new Font("Segoe Print", Font.BOLD, 18);
//     JTextField tfkodePerhiasan;
//     JTextField tfnamaPerhiasan;
//     JTextField tfjenisPerhiasan;
//     JTextField tfBerat;
//     JTextField tfHarga;
//     public void initialize(){
//         //form
//         JLabel lbEditForm = new JLabel("Edit Data Form",SwingConstants.CENTER);
//         lbEditForm.setFont(mainfont);
//         //form kode perhiasan
//         JLabel lbkodePerhiasan = new JLabel("Kode Perhiasan");
//         lbkodePerhiasan.setFont(mainfont);
//         tfkodePerhiasan = new JTextField();
//         tfkodePerhiasan.setFont(mainfont);
//         //form nama perhiasan
//         JLabel lbnamaPerhiasan = new JLabel("Nama Perhiasan");
//         lbnamaPerhiasan.setFont(mainfont);
//         tfnamaPerhiasan = new JTextField();
//         tfnamaPerhiasan.setFont(mainfont);
//         //form jenis perhiasan
//         JLabel lbjenisPerhiasan = new JLabel("Jenis Perhiasan");
//         lbjenisPerhiasan.setFont(mainfont);
//         tfjenisPerhiasan = new JTextField();
//         tfjenisPerhiasan.setFont(mainfont);
//         //form berat
//         JLabel lbBerat = new JLabel("Berat Perhiasan");
//         lbBerat.setFont(mainfont);
//         tfBerat = new JTextField();
//         tfBerat.setFont(mainfont);
//         //form harga
//         JLabel lbHarga = new JLabel("Harga Perhiasan");
//         lbHarga.setFont(mainfont);
//         tfHarga = new JTextField();
//         tfHarga.setFont(mainfont);

//         JPanel formPanel = new JPanel();
//         formPanel.setLayout(new GridLayout(0,1,10,10));
//         formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
//         formPanel.add(lbEditForm);
//         formPanel.add(lbkodePerhiasan);
//         formPanel.add(tfkodePerhiasan);
//         formPanel.add(lbnamaPerhiasan);
//         formPanel.add(tfnamaPerhiasan);
//         formPanel.add(lbjenisPerhiasan);
//         formPanel.add(tfjenisPerhiasan);
//         formPanel.add(lbBerat);
//         formPanel.add(tfBerat);
//         formPanel.add(lbHarga);
//         formPanel.add(tfHarga);

        

//         //button Edit data
//         JButton btnEdit = new JButton("Edit");
//         btnEdit.setFont(mainfont);
//         btnEdit.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 String kodePerhiasan = tfkodePerhiasan.getText();
//                 String namaPerhiasan = tfnamaPerhiasan.getText();
//                 String jenisPerhiasan = tfjenisPerhiasan.getText();
//                 String berat = tfBerat.getText();
//                 Integer intHarga = Integer.parseInt(tfHarga.getText());
//                 if (namaPerhiasan.isEmpty()||jenisPerhiasan.isEmpty()||berat.isEmpty()){
//                     JOptionPane.showMessageDialog(null,"Isi Data Yang Kosong");
//                 }
//                 else{
//                     final String DB_URL = "jdbc:mysql://localhost:3306/dbpbo";
//                     final String USERNAME = "root";
//                     final String PASSWORD = "";
//                     try {       
//                         Connection connect = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//                         String Updatesql = "UPDATE tbperhiasan SET kodePerhiasan=?, namaPerhiasan=?, jenisPerhiasan=?, berat=?, harga=? WHERE kodePerhiasan= '"+kodePerhiasan+"' ";
//                         PreparedStatement preparedStatement = connect.prepareStatement(Updatesql);
//                         try {
//                             preparedStatement.setString(1, kodePerhiasan);
//                             preparedStatement.setString(2, namaPerhiasan);
//                             preparedStatement.setString(3, jenisPerhiasan);
//                             preparedStatement.setString(4, berat);
//                             preparedStatement.setInt(5, intHarga);
//                             preparedStatement.setString(6, kodePerhiasan);
//                             int rowsInserted = preparedStatement.executeUpdate();
//                             if (rowsInserted > 0) {
//                                 JOptionPane.showMessageDialog(null, "Data Berhasil Diubah");
//                                 adminFrame AdminFrame = new adminFrame();
//                                 AdminFrame.initialize();
//                                 dispose();
//                             }
//                             connect.close();
//                         } catch (Exception ex) {
//                             JOptionPane.showMessageDialog(null, "Failed to Call Function");
//                         }
//                     } catch (Exception ex) {
//                         JOptionPane.showMessageDialog(null, "Failed to Call Function 2");
//                     }
                    
//                 }  
//             }
//         });
//         //button back data
//         JButton btnBack = new JButton("Back");
//         btnBack.setFont(mainfont);
//         btnBack.addActionListener(new ActionListener() {
//             @Override
//             public void actionPerformed(ActionEvent e) {
//                 adminFrame AdminFrame = new adminFrame();
//                 AdminFrame.initialize();
//                 dispose();  
//             }
//         });
//         //add panel
//         JPanel buttonsPanel = new JPanel();
//         buttonsPanel.setLayout(new GridLayout(1,2,10,0));
//         buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
//         buttonsPanel.add(btnEdit);
//         buttonsPanel.add(btnBack);
        
//         //deklar frame
//         add(formPanel, BorderLayout.NORTH);
//         add(buttonsPanel, BorderLayout.SOUTH);
//         setTitle("Edit Data Form");
//         setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//         setSize(600,800);
//         setMinimumSize(new Dimension(350,450));

//         setLocationRelativeTo(null);
//         setVisible(true);
//     }
// }
