/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package worldCities;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author RamazanFırat
 */
public class worldCities extends javax.swing.JFrame {

    /**
     * Creates new form worldCities
     */
    DefaultTableModel model;//tabloyu bağlıyoruz
    public worldCities() {
        initComponents();
       populateTable();
        
    }
    public void populateTable(){
         model = (DefaultTableModel) tblCities.getModel();
        try {
            ArrayList<City> cities = getCities();
            for(City city: cities){
                Object[] row = {city.getId(),city.getName(),city.getCountryId(),city.getLastUpdate()};
                model.addRow(row);
            }
            
        } catch (Exception e) {
            
        }
    }
    public ArrayList<City> getCities() throws SQLException{
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        //veri tabanına gönderilen sorgu statement ile yapılır
        Statement statement = null;
        //ResultSet veri tabanından dönen değer
        ResultSet resultSet = null;
         ArrayList<City> cities = null;
        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from city");
            cities = new ArrayList<City>();
          while(resultSet.next()){
              cities.add(new City(resultSet.getInt("city_id"),
                      resultSet.getString("city"),resultSet.getInt("country_id"),
                      resultSet.getString("last_update")));
          }
          
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }finally{
            statement.close();
            connection.close();
        }
        return cities;
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblCities = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        lblCityName = new javax.swing.JLabel();
        lblCityCountryCode = new javax.swing.JLabel();
        lblCityLastUpdate = new javax.swing.JLabel();
        lblAddCity = new javax.swing.JLabel();
        txtCityName = new javax.swing.JTextField();
        txtCountryCode = new javax.swing.JTextField();
        txtCityLastUpdate = new javax.swing.JTextField();
        btnAddCity = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblCities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "name", "countryCode", "lastUpdate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCities);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblSearch.setText("Search :");

        lblCityName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCityName.setText("Name              :");

        lblCityCountryCode.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCityCountryCode.setText("Country Code  :");

        lblCityLastUpdate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCityLastUpdate.setText("Last Update     :");

        lblAddCity.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblAddCity.setText("Insert New City");

        txtCityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCityNameActionPerformed(evt);
            }
        });

        btnAddCity.setBackground(new java.awt.Color(153, 255, 102));
        btnAddCity.setText("Add City");
        btnAddCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCityCountryCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCityName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCountryCode, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnAddCity)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblCityLastUpdate)
                            .addGap(18, 18, 18)
                            .addComponent(txtCityLastUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblAddCity))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblAddCity, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCityName)
                    .addComponent(txtCityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCityCountryCode)
                    .addComponent(txtCountryCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCityLastUpdate)
                    .addComponent(txtCityLastUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddCity, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String searchKey = txtSearch.getText();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(model);
        //burada girilen filtreye uygun olan tablo öğelerini seçmek için tablerowsorter nesnesine
        //tablomuzu temsil eden model elementini parametre verdik
        tblCities.setRowSorter(sorter);
        //tablomuza bir rowSorter öğesi kullanacağını söyledik ve tablerowsorter nesnesini set ettik
        sorter.setRowFilter(RowFilter.regexFilter(searchKey));
        //tablerowsorter öğemiz ne tür bir filtreleme yapacak onu seçiyoruz regex yazılan değerle eşleşeni se
        //çer
        
        
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtCityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCityNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCityNameActionPerformed

    private void btnAddCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCityActionPerformed
        Connection conn = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement statement = null;
       
       String CityName = txtCityName.getText();
       String countryCode = txtCountryCode.getText();
       String lastUpdate = txtCityLastUpdate.getText();
       
        try {
            
            conn = dbHelper.getConnection();
            String sql = "INSERT INTO city (city, country_id, last_update) VALUES (?, ?, ?)";
            statement = conn.prepareStatement(sql);
            //parametreler ? ile gösterildi ve oraya setString metodu ile değerler aktarılır
            statement.setString(1, CityName+" f");
            statement.setInt(2, Integer.parseInt(countryCode));
            statement.setString(3, lastUpdate);
            int result = statement.executeUpdate();
            
        } catch (SQLException e) {
            dbHelper.showErrorMessage(e);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally{
            try {
                statement.close();
                conn.close();
            } catch (SQLException ex) {
               
            }
        }
        populateTable();
    }//GEN-LAST:event_btnAddCityActionPerformed

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
            java.util.logging.Logger.getLogger(worldCities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(worldCities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(worldCities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(worldCities.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new worldCities().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCity;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddCity;
    private javax.swing.JLabel lblCityCountryCode;
    private javax.swing.JLabel lblCityLastUpdate;
    private javax.swing.JLabel lblCityName;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JTable tblCities;
    private javax.swing.JTextField txtCityLastUpdate;
    private javax.swing.JTextField txtCityName;
    private javax.swing.JTextField txtCountryCode;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
