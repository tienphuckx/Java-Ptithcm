/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import lib.DatabaseHander;
import static lib.DatabaseHander.conn;
import lib.ImgHandle;
import model.Product;


public class MainUI extends javax.swing.JFrame {

    private String imgPath = "";
    private String SQL_INSERT = "INSERT INTO products (name, price, add_date, img) VALUES (?,?,?,?)";
    private String SQL_UPDATE_WITHOUT_IMG = "UPDATE products SET name = ?, price = ?, add_date = ? WHERE id = ?";
    private String SQL_UPDATE_WITH_IMG = "UPDATE products SET name = ?, price = ?, add_date = ?, img = ? WHERE id = ?";
    private String SQL_DELETE_PRODUCT = "DELETE FROM products WHERE id = ?";
    private String SQL_QUERY_PRODUCT_LIST = "SELECT * FROM products";
    
    int pointer = 0;
    /**
     * Creates new form MainUI
     */
    public MainUI() {
        initComponents();
        showProductListIntoJTable();
        this.setLocationRelativeTo(null);
        
    }
    
    /*CHECK INPUT FIELD BEFO CLICK INSERT*/
    public boolean checkInputs()
    {
        if(jTextFieldName.getText() == null
                || jTextFieldPrice.getText() ==null
                || jDateChooserAddDate.getDate() == null)
        {
            return false;
        }else{
            try
            {
                Float.parseFloat(jTextFieldPrice.getText());
                return true;
            }
            catch(Exception e)
            {
                return false;
            }
        }
        
    }
    
    /*SHOW ALL PRODUCTS INTO THE JTABLE
        1. All the products --> Arraylist
        2. Arraylist        --> JTable
    */
    public ArrayList<Product> getProductList()
    {
        ArrayList <Product> productList = new ArrayList<Product>();
        Product product;        
        try {
            Connection conn     = DatabaseHander.getConnection();
            Statement st        = null;
            ResultSet rs        = null;
            st                  = conn.createStatement();
            rs = st.executeQuery(SQL_QUERY_PRODUCT_LIST);
            while(rs.next())
            {
                product = new Product(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        Float.parseFloat(rs.getString("price")), 
                        rs.getString("add_date"), 
                        rs.getBytes("img"));
                productList.add(product);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return productList;
    }
    
    /*2. ARRAYLIST --> JTABLE*/
    public void showProductListIntoJTable()
    {
        ArrayList<Product> arrListProduct = getProductList();
        DefaultTableModel model = (DefaultTableModel)jTableProductList.getModel();
        model.setRowCount(0);
        Object[] row = new Object[4];
        for(int i = 0; i < arrListProduct.size(); i++)
        {
            row[0] = arrListProduct.get(i).getId();
            row[1] = arrListProduct.get(i).getName();
            row[2] = arrListProduct.get(i).getPrice();
            row[3] = arrListProduct.get(i).getAddDate();
            model.addRow(row);
        }
    }
    
    public void showProductDetailByClick(int index)
    {
        jTextFieldID.setText(Integer.toString(getProductList().get(index).getId()));
        jTextFieldName.setText(getProductList().get(index).getName());
        jTextFieldPrice.setText(Float.toString(getProductList().get(index).getPrice()));
        Date addDate = null;
        try {
            addDate = new SimpleDateFormat("yyy-MM-dd").parse((String)getProductList().get(index).getAddDate());
            jDateChooserAddDate.setDate(addDate);
        } catch (ParseException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabelImg.setIcon(ImgHandle.reSizeImg(null, getProductList().get(index).getPicture(), jLabelImg));
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
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldID = new javax.swing.JTextField();
        jTextFieldPrice = new javax.swing.JTextField();
        jTextFieldName = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProductList = new javax.swing.JTable();
        jDateChooserAddDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabelImg = new javax.swing.JLabel();
        jButtonChooiseImg = new javax.swing.JButton();
        jButtonInsert = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonPrevious = new javax.swing.JButton();
        jButtonFirst = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jButtonLast = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Add Date");

        jTextFieldID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTextFieldPrice.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jTextFieldName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jTableProductList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Price", "Add date"
            }
        ));
        jTableProductList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProductListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableProductList);

        jDateChooserAddDate.setDateFormatString("yyyy-MM-dd");
        jDateChooserAddDate.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Image");

        jLabelImg.setOpaque(true);

        jButtonChooiseImg.setText("Chooise imgage");
        jButtonChooiseImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooiseImgActionPerformed(evt);
            }
        });

        jButtonInsert.setBackground(new java.awt.Color(51, 255, 51));
        jButtonInsert.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInsert.setText("Insert");
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jButtonUpdate.setBackground(new java.awt.Color(0, 0, 255));
        jButtonUpdate.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setBackground(new java.awt.Color(255, 0, 0));
        jButtonDelete.setForeground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonPrevious.setBackground(new java.awt.Color(51, 51, 51));
        jButtonPrevious.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPrevious.setText("< Previous");
        jButtonPrevious.setPreferredSize(new java.awt.Dimension(80, 23));
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });

        jButtonFirst.setBackground(new java.awt.Color(0, 0, 0));
        jButtonFirst.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFirst.setText("First");
        jButtonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFirstActionPerformed(evt);
            }
        });

        jButtonNext.setBackground(new java.awt.Color(51, 51, 51));
        jButtonNext.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNext.setText("Next >");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });

        jButtonLast.setBackground(new java.awt.Color(0, 0, 0));
        jButtonLast.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLast.setText("Last");
        jButtonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLastActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jButtonInsert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldName)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jDateChooserAddDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                            .addComponent(jButtonChooiseImg, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldPrice, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonNext, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(jButtonLast, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jDateChooserAddDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelImg, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonInsert)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonUpdate)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonDelete))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonChooiseImg)
                    .addComponent(jButtonFirst)
                    .addComponent(jButtonPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNext)
                    .addComponent(jButtonLast))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed

    private void jButtonChooiseImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooiseImgActionPerformed
        try {
            DatabaseHander.getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(conn == null){
            JOptionPane.showMessageDialog(null, "Failed to Connect to database");
        }
        
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*images", "jpg", "png");
        jFileChooser.addChoosableFileFilter(fnef);
        int result = jFileChooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile   = jFileChooser.getSelectedFile();
            String path         = selectedFile.getAbsolutePath();
            jLabelImg.setIcon(ImgHandle.reSizeImg(path, null, jLabelImg));
            imgPath = path;
        }else{
            JOptionPane.showMessageDialog(null, "No image selected!");
        }
    }//GEN-LAST:event_jButtonChooiseImgActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        if(checkInputs()
                && imgPath != null)
        {
            try {
                /*DO INSERT TO DATABASE
                   "INSERT INTO products (name, price, add_date, img) VALUES (?,?,?,?)"
                */
                Connection conn = DatabaseHander.getConnection();
                PreparedStatement ps = conn.prepareStatement(SQL_INSERT);
                ps.setString(1, jTextFieldName.getText());
                ps.setString(2, jTextFieldPrice.getText());
                
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
                String day = simpleDateFormat.format(jDateChooserAddDate.getDate());
                ;
                ps.setString(3, day);
                
                InputStream img = new FileInputStream(new File(imgPath));
                ps.setBlob(4, img);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Insert successfully!");
                showProductListIntoJTable();
            } catch (Exception ex) {
//                JOptionPane.showMessageDialog(null, ex.getMessage());
                JOptionPane.showMessageDialog(null, "Insert failed!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "One or more field are Empty!");
        }            
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        /* UPDATE */
        if(checkInputs() && jTextFieldID != null)
        {
            try {
                PreparedStatement ps = null;
                Connection conn = DatabaseHander.getConnection();
                
                /*UPDATE WITHOUT IMG*/
                if(imgPath == null)
                {
                    ps = conn.prepareStatement(SQL_UPDATE_WITHOUT_IMG);
                    ps.setString(1, jTextFieldName.getText());
                    ps.setString(2, jTextFieldPrice.getText());
                    
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
                    String day = simpleDateFormat.format(jDateChooserAddDate.getDate());
                    
                    ps.setString(3, day);
                    
                    ps.setInt(4, Integer.parseInt(jTextFieldID.getText()));
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Updated successfully!");
                    showProductListIntoJTable();
                }else{
                    /*UPDATE WITH IMG*/
                    
                
                    ps = conn.prepareStatement(SQL_UPDATE_WITH_IMG);
                    ps.setString(1, jTextFieldName.getText());
                    ps.setString(2, jTextFieldPrice.getText());
                    
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd");
                    String day = simpleDateFormat.format(jDateChooserAddDate.getDate());
                                        
                    ps.setString(3, day);
                    
                    InputStream img = new FileInputStream(new File(imgPath));
                    ps.setBlob(4, img);
                    
                    ps.setInt(5, Integer.parseInt(jTextFieldID.getText()));
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Updated successfully!");
                    showProductListIntoJTable();
                }
                /*UPDATE WITH IMG*/
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "Some fields are empty!");
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        /*DELETE ELEMENT*/
        if(!jTextFieldID.equals(""))
        {
//            SQL_DELETE_PRODUCT
            
            try {
                PreparedStatement ps = null;
                Connection conn = DatabaseHander.getConnection();
                ps = conn.prepareStatement(SQL_DELETE_PRODUCT);
                ps.setInt(1, Integer.parseInt(jTextFieldID.getText()));
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deleted successfully!");
                showProductListIntoJTable();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Delete fail!");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Delete fail! No product ID to delete.");
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    private void jTableProductListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProductListMouseClicked
        
        int index = jTableProductList.getSelectedRow();
        showProductDetailByClick(index);
        
    }//GEN-LAST:event_jTableProductListMouseClicked

    private void jButtonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFirstActionPerformed
       pointer = 0;
       showProductDetailByClick(pointer);
    }//GEN-LAST:event_jButtonFirstActionPerformed

    private void jButtonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLastActionPerformed
        pointer = getProductList().size() - 1;
        showProductDetailByClick(pointer);
    }//GEN-LAST:event_jButtonLastActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        pointer++;
        if(pointer >= getProductList().size())
        {
            pointer = getProductList().size() - 1;
        }
        showProductDetailByClick(pointer);
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        pointer--;
        if(pointer < 0)
        {
            pointer = 0;
        }
        showProductDetailByClick(pointer);
    }//GEN-LAST:event_jButtonPreviousActionPerformed

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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonChooiseImg;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonFirst;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonLast;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButtonUpdate;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooserAddDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelImg;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProductList;
    private javax.swing.JTextField jTextFieldID;
    private javax.swing.JTextField jTextFieldName;
    private javax.swing.JTextField jTextFieldPrice;
    // End of variables declaration//GEN-END:variables
}
