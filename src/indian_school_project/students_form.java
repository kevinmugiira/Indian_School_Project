/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package indian_school_project;

import com.mysql.jdbc.Connection;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevinm
 */
public class students_form extends javax.swing.JFrame {

    /**
     * Creates new form students_form
     */
    public students_form() {
        initComponents();
       // mysqlconnection(); is used to test whether connection to the database was successful
       fillTable();
    }
    
    
    public Connection mysqlconnection(){
    
        Connection dat = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            dat = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Rajesh","root","root");
            JOptionPane.showMessageDialog(null, "Database connection successful...");
            return dat;
        
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "mysql connection failed...");
            return null;
        
        }
    
    }
    
    String photoPath = "";
    public ImageIcon resetImage(String photoPath,byte[] photo){
        ImageIcon myPhoto = null;
        
        if (photoPath != null) {
            myPhoto = new ImageIcon(photoPath);
        
        } else {
            myPhoto = new ImageIcon(photo);
        
        }
         
        Image img = myPhoto.getImage();
        Image img1 = img.getScaledInstance(lbl_photo.getWidth(),lbl_photo.getHeight(),Image.SCALE_SMOOTH);
        ImageIcon ph = new ImageIcon(img1);
        return ph;
    
    }
    
    
    public ArrayList<Student_Dean> retrieve_data() {
        ArrayList<Student_Dean> al = null;
        al = new ArrayList<Student_Dean>();
        
        
        try{
            Connection conn = mysqlconnection();
            String q = "select * from student";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(q);
            
            Student_Dean stude;
            while (rs.next()){
                stude = new Student_Dean(rs.getInt(1), rs.getString(2), Float.parseFloat(rs.getString(3)), rs.getString(4), rs.getBytes(5));
                al.add(stude);
            
            }
        
        }catch(Exception e){
            System.out.println("Error in retrieve data " + e);
        
        }
        return al;
    
    }
    
    //Displaying data on the table
    public void fillTable(){
        ArrayList<Student_Dean> al = retrieve_data();
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i = 0; i < al.size(); i++) {
            row[0] = al.get(i).getId();
            row[1] = al.get(i).getName();
            row[2] = al.get(i).getFees();
            row[3] = al.get(i).getDob();
            //row[4] = al.get(i).getPhoto();
            model.addRow(row);
            
        }  
        //model.setRowCount(0);
    
    }
    
    //show item data to field
    public void showItemToField(int index){
        id_txt.setText(Integer.toString(retrieve_data().get(index).getId()));
        student_name_txt.setText(retrieve_data().get(index).getName());
        fee_txt.setText(Float.toString(retrieve_data().get(index).getFees()));
        
        
        try{
            java.util.Date doba = null;
            doba = new SimpleDateFormat("dd-MM-YYYY").parse((String)retrieve_data().get(index).getDob());
            dob.setDate(doba);
        
        
        } catch (Exception e) {
            
            System.out.println( "Error in showing the data items");
                    
                    
                    }
        lbl_photo.setIcon(resetImage(null, retrieve_data().get(index).getPhoto()));
        }
    
    
    
    
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        id_txt = new javax.swing.JTextField();
        student_name_txt = new javax.swing.JTextField();
        fee_txt = new javax.swing.JTextField();
        dob = new com.toedter.calendar.JDateChooser();
        lbl_photo = new javax.swing.JLabel();
        jButton_new = new javax.swing.JButton();
        jButton_insert = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        search_txt = new javax.swing.JTextField();
        photo_select_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(24, 146, 209));
        jPanel1.setForeground(new java.awt.Color(69, 185, 245));

        jLabel1.setBackground(new java.awt.Color(46, 8, 8));
        jLabel1.setFont(new java.awt.Font("Noto Sans", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 56, 56));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SHASHU COLLEGE OF ENGINEERING AND TECHNOLOGY");

        jLabel2.setFont(new java.awt.Font("Noto Sans", 3, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(56, 56, 56));
        jLabel2.setText("Student Information");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indian_school_project/Images/dolphin-logo1.jpg"))); // NOI18N
        jLabel3.setIconTextGap(0);

        jLabel4.setFont(new java.awt.Font("Noto Sans", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(56, 56, 56));
        jLabel4.setText("Africa, Nairobi, Kenya");

        jLabel5.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel5.setText("Id:");

        jLabel6.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel6.setText("Student Name:");

        jLabel7.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel7.setText("Fees:");

        jLabel8.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel8.setText("Date Of Birth:");

        jLabel9.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel9.setText("Photo:");

        student_name_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                student_name_txtActionPerformed(evt);
            }
        });

        dob.setDateFormatString("dd-MM-yyyy");

        lbl_photo.setBackground(new java.awt.Color(218, 218, 218));
        lbl_photo.setOpaque(true);

        jButton_new.setFont(new java.awt.Font("Noto Sans", 2, 18)); // NOI18N
        jButton_new.setForeground(new java.awt.Color(212, 88, 25));
        jButton_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indian_school_project/Images/icons8-new-copy-30.png"))); // NOI18N
        jButton_new.setText("New");
        jButton_new.setIconTextGap(15);

        jButton_insert.setFont(new java.awt.Font("Noto Sans", 2, 18)); // NOI18N
        jButton_insert.setForeground(new java.awt.Color(212, 88, 25));
        jButton_insert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indian_school_project/Images/icons8-insert-button-30.png"))); // NOI18N
        jButton_insert.setText("Insert");
        jButton_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_insertActionPerformed(evt);
            }
        });

        jButton_update.setFont(new java.awt.Font("Noto Sans", 2, 18)); // NOI18N
        jButton_update.setForeground(new java.awt.Color(212, 88, 25));
        jButton_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indian_school_project/Images/icons8-update-30.png"))); // NOI18N
        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });

        jButton_delete.setFont(new java.awt.Font("Noto Sans", 2, 18)); // NOI18N
        jButton_delete.setForeground(new java.awt.Color(212, 88, 25));
        jButton_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indian_school_project/Images/icons8-delete-bin-30.png"))); // NOI18N
        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Noto Sans", 0, 18)); // NOI18N
        jLabel10.setText("Search Student By Name:");

        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        photo_select_btn.setFont(new java.awt.Font("Noto Sans", 2, 18)); // NOI18N
        photo_select_btn.setForeground(new java.awt.Color(212, 88, 25));
        photo_select_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/indian_school_project/Images/icons8-select-user-30.png"))); // NOI18N
        photo_select_btn.setText("Select Photo");
        photo_select_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                photo_select_btnActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Student Name", "Fees", "Date Of Birth"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9))
                                    .addComponent(photo_select_btn))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbl_photo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(id_txt)
                                        .addComponent(student_name_txt)
                                        .addComponent(fee_txt)
                                        .addComponent(dob, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                                    .addComponent(jLabel10))
                                .addGap(138, 138, 138)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(67, 67, 67)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel4))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 936, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 938, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_new, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(student_name_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(fee_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton_update, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel8)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(lbl_photo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(photo_select_btn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    //for deleting a student row in the database table
    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        if(student_name_txt.getText().equals(""))  {
            JOptionPane.showMessageDialog(null, "please input the student id");
            
        }else{
        
            try{
                String qrydelete = "delete from student where id = ?";
                Connection conn = mysqlconnection();
                PreparedStatement ps = conn.prepareStatement(qrydelete);
                
                ps.setInt(1, Integer.parseInt(id_txt.getText().toString()));
                int res = ps.executeUpdate();
                
                fillTable();
                if(res >= 1){
                    JOptionPane.showMessageDialog(null, "student deleted successfully");
                
                }else{
                
                    JOptionPane.showMessageDialog(null, "student not deleted");
                }
            
            
            }
            catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void student_name_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_student_name_txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_student_name_txtActionPerformed

    
    //Selecting the photo
    private void photo_select_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_photo_select_btnActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filethis = new FileNameExtensionFilter("*.images","jpg","png");
        chooser.addChoosableFileFilter(filethis);
        int ans = chooser.showSaveDialog(null);
        
        if (ans == JFileChooser.APPROVE_OPTION) {
            File selectedPhoto = chooser.getSelectedFile();
            String path = selectedPhoto.getAbsolutePath();
            lbl_photo.setIcon(resetImage(path, null));
            this.photoPath = path;
        
        }
    }//GEN-LAST:event_photo_select_btnActionPerformed

    //saving the student records into the database
    private void jButton_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_insertActionPerformed
        if ((id_txt.getText() != null || student_name_txt.getText() != null || fee_txt.getText() != null || dob != null) && photoPath != null) {
            try {
                Connection conn = mysqlconnection();
                //String quer = "INSERT INTO student values(id,name,fees,dob,photo) values " + "(?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement("INSERT INTO student" + "(id,name,fees,dob,photo) values(?,?,?,?,?)"); 
                ps.setInt(1,Integer.parseInt(id_txt.getText()));
                ps.setString(2,student_name_txt.getText());
                ps.setFloat(3, Float.parseFloat(fee_txt.getText()));
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String dob1 = sdf.format(dob.getDate());
                ps.setString(4, dob1);
                        
                InputStream is = new FileInputStream(new File(photoPath));
                ps.setBlob(5, is);
                int res = ps.executeUpdate();
                fillTable();
                
                if(res >= 1) {
                    JOptionPane.showMessageDialog(null, res + "Number of students" + " inserted into database...");
                                  
                }else{
                    JOptionPane.showMessageDialog(null,"Inserting students failed ");
                
                }
            
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
        
                
                id_txt.setText("");
                student_name_txt.setText("");
                fee_txt.setText("");
        }
        }else{
            JOptionPane.showMessageDialog(null,"all fields are compulsary");
                
        }
    }//GEN-LAST:event_jButton_insertActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        if (id_txt != null || student_name_txt != null || fee_txt != null || dob != null) {
            
            String qry = null;
            PreparedStatement ps = null;
            Connection conn = mysqlconnection();
            
            if(photoPath == null){
            
            try {
                InputStream is = new FileInputStream(new File(photoPath));
                qry = " update student set student_name_txt = ?, fee_txt = ?, dob = ? where id = ?";
                //String quer = "INSERT INTO student values(id,name,fees,dob,photo) values " + "(?,?,?,?,?)";
                ps = conn.prepareStatement(qry); 
                
                ps.setString(1,student_name_txt.getText());
                ps.setFloat(2, Float.parseFloat(fee_txt.getText()));
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                String dob1 = sdf.format(dob.getDate());
                ps.setString(3, dob1);
                
                ps.setBlob(4, is);
                
                ps.setInt(5, Integer.parseInt(id_txt.getText()));
                        
                //InputStream is = new FileInputStream(new File(photoPath));
                //ps.setBlob(5, is);
                
                
                int res = ps.executeUpdate();
                fillTable();
                if(res >= 1) {
                    JOptionPane.showMessageDialog(null, res + "Student" + " updated successfully...");
                                  
                }else{
                    JOptionPane.showMessageDialog(null,"student update failed... ");
                
                }
            
            } catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
        
                
                id_txt.setText("");
                student_name_txt.setText("");
                fee_txt.setText("");
            }
        }else{
            JOptionPane.showMessageDialog(null,"update process failed");
            
      
                
            
            }
        }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int ind = jTable1.getSelectedRow();
        
        showItemToField(ind);
    }//GEN-LAST:event_jTable1MouseClicked

    
    
    //implementing the search field
    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        
        ArrayList<Student_Dean> al = null;
        al = new ArrayList<Student_Dean>();
        String val = search_txt.getText().toString();
        
        try{
            Connection conn = mysqlconnection();
            String sql = "select * from student where name like '%"+val+"%'";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Student_Dean stude;
            
            while (rs.next()) {
                stude = new Student_Dean(rs.getInt(1), rs.getString("student_name_txt"), Float.parseFloat(rs.getString(3)), rs.getString(4), rs.getBytes("photo"));
                al.add(stude);
                
                DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
                model.setRowCount(0);
                Object[] row = new Object[4];
                for (int i = 0; i < al.size(); i++) {
                    row[0] = al.get(i).getId();
                    row[1] = al.get(i).getName();
                    row[2] = al.get(i).getFees();
                    row[3] = al.get(i).getDob();
                    model.addRow(row);                
                
                }
            
            
            }
            
        
        
        }
        catch(Exception e) {
            System.out.println(e);
        
        
        }        
        
    }//GEN-LAST:event_search_txtKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(students_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(students_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(students_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(students_form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new students_form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField fee_txt;
    private javax.swing.JTextField id_txt;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_insert;
    private javax.swing.JButton jButton_new;
    private javax.swing.JButton jButton_update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_photo;
    private javax.swing.JButton photo_select_btn;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTextField student_name_txt;
    // End of variables declaration//GEN-END:variables
}
