/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author ACER
 */
public class pegawai extends javax.swing.JFrame {
 public String date;
 public Statement st;
public ResultSet rs;
public DefaultTableModel tabModel;
Connection cn = view.koneksi.Koneksi();
 
    /**
     * Creates new form pegawai
     */
    public pegawai() {
        initComponents();
        judul();
        tampilData("");
    }
    
    
    public void judul() {
Object[] judul = {
"NIP", "NAMA", "JENIS KELAMIN", "DIVISI", "TANGGAL LAHIR", "ALAMAT",
};
tabModel = new DefaultTableModel(null, judul);
pegawai.setModel(tabModel);
}
     
    
    public void reset() {
nip.setText("");
nama.setText("");
jk.setSelectedItem("");
divisi.setSelectedItem("");
tanggal.setDate(null);
alamat.setText("");
}
    
public void tampilData(String where) {
    try {
        st = cn.createStatement();
        tabModel.getDataVector().removeAllElements();
        tabModel.fireTableDataChanged();
        rs = st.executeQuery("SELECT * FROM biodata " + where);

        while (rs.next()) {
            Object[] data = {
                rs.getString("nip"),
                rs.getString("nama"),
                rs.getString("jenis_kelamin"),
                rs.getString("divisi"),
                rs.getString("tgl_lahir"),
                rs.getString("alamat"),
            };
            // Inserting rows at index 0 to achieve LIFO behavior
            tabModel.insertRow(0, data);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}



    private void cariData(String key) {
        try {
    Object[] judul_kolom = {"NIP", "Nama", "Jenis Kelamin", "Divisi", "Tanggal Lahir", "Alamat"};
    tabModel = new DefaultTableModel(null, judul_kolom);
    pegawai.setModel(tabModel);

    Connection conn = (Connection) koneksi.Koneksi();
    Statement stt = conn.createStatement();
    tabModel.getDataVector().removeAllElements();

    rs = stt.executeQuery("SELECT * FROM biodata WHERE nip LIKE '%" + key + "%' OR nama LIKE '%" + key + "%'");
    while (rs.next()) {
        Object[] data = {
            rs.getString("nip"),
            rs.getString("nama"),
            rs.getString("jenis_kelamin"),
            rs.getString("divisi"),
            rs.getString("tgl_lahir"),
            rs.getString("alamat")
        };
        // Inserting rows at index 0 to achieve LIFO behavior
        tabModel.insertRow(0, data);
    }

    // Memberi tahu model bahwa data telah berubah
    tabModel.fireTableDataChanged();

} catch (Exception ex) {
    System.err.println(ex.getMessage());
}
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        nip = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jk = new javax.swing.JComboBox();
        divisi = new javax.swing.JComboBox();
        tanggal = new com.toedter.calendar.JDateChooser();
        alamat = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pegawai = new javax.swing.JTable();
        hapus = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("DATA DIRI KARYAWAN");

        nip.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NIP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        nama.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NAMA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        jk.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "LAKI-LAKI", "PEREMPUAN" }));
        jk.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "JENIS KELAMIN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        divisi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Supporting Division", "Operation Division", "Networking Dev", "Networking Operator " }));
        divisi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DIVISI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        tanggal.setDateFormatString("yyyy/MM/d");
        tanggal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalPropertyChange(evt);
            }
        });

        alamat.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ALAMAT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });

        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        pegawai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        pegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pegawaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(pegawai);

        hapus.setText("HAPUS");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        edit.setText("EDIT");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        search.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SEARCH", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\icons8-back-30.png")); // NOI18N
        jButton1.setPreferredSize(new java.awt.Dimension(30, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nama, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                .addComponent(nip)
                                .addComponent(jk, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(divisi, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(alamat, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jk, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(divisi, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpan)
                    .addComponent(hapus)
                    .addComponent(edit)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalPropertyChange
        // TODO add your handling code here:
         if(tanggal.getDate()!=null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            date = format.format(tanggal.getDate());
        }
    }//GEN-LAST:event_tanggalPropertyChange

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
       try {
    // Validate that required fields are not empty
    if (nip.getText().isEmpty() || nama.getText().isEmpty() || jk.getSelectedItem() == null
            || divisi.getSelectedItem() == null || tanggal.getDate() == null || alamat.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Harap lengkapi semua kolom sebelum menyimpan.");
    } else {
        st = cn.createStatement();
        st.executeUpdate("INSERT INTO biodata VALUES('" 
                + nip.getText() + "','"
                + nama.getText() + "','"
                + jk.getSelectedItem() + "','"
                + divisi.getSelectedItem() + "','"
                + date + "','"   
                + alamat.getText() + "')");
        
        tampilData("");
        JOptionPane.showMessageDialog(null, "Simpan Berhasil");
        
        // Clear the form fields
        nip.setText("");
        nama.setText("");
        jk.setSelectedItem("");
        divisi.setSelectedItem("");
        tanggal.setDate(null);
        alamat.setText("");
    }
} catch (SQLIntegrityConstraintViolationException e) {
    // Handle the exception for duplicate primary key (nip) here
    JOptionPane.showMessageDialog(null, "NIP sudah terdaftar. Silakan masukkan NIP yang berbeda.");
} catch (Exception e) {
    e.printStackTrace();
}

    }//GEN-LAST:event_simpanActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
          try {
            int jawab;
            if ((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data?", "konfirmasi", JOptionPane.YES_NO_OPTION)) == 0) {
                st = cn.createStatement();
                st.executeUpdate("DELETE FROM biodata WHERE nip='"
                    + tabModel.getValueAt(pegawai.getSelectedRow(), 0) + "'");
                tampilData("");
                reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
           try {
        st = cn.createStatement();
        String fnip = nip.getText(); // Ambil NIS dari input
        String fnama = nama.getText(); // Ambil Nama dari input
        String fjk = jk.getSelectedItem().toString(); // Ambil Jurusan dari input
        String fdate = date.toString();
        String fdivisi = divisi.getSelectedItem().toString(); // Ambil Jenis Kelamin dari input
        String falamat = alamat.getText(); // Ambil Alamat dari input
        
        // Gunakan perintah UPDATE dengan kondisi WHERE sesuai ID (NIS)
       st.executeUpdate("UPDATE biodata SET "
    + "nama='" + fnama + "', "
    + "jenis_kelamin='" + fjk + "', "
    + "divisi='" + fdivisi + "', "
    + "tgl_lahir='" + fdate + "', "
    + "alamat='" + falamat + "' WHERE nip='" + fnip + "'");

        
        tampilData(""); // Tampilkan data yang telah diperbarui
        JOptionPane.showMessageDialog(null, "Update Berhasil");
        reset();
    } catch (Exception e) {
        e.printStackTrace(); }
    }//GEN-LAST:event_editActionPerformed

    private void pegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pegawaiMouseClicked
        // TODO add your handling code here:
         nip.setText(pegawai.getValueAt(pegawai.getSelectedRow(), 0).toString());
nama.setText(pegawai.getValueAt(pegawai.getSelectedRow(), 1).toString());
jk.setSelectedItem(pegawai.getValueAt(pegawai.getSelectedRow(), 2).toString());
divisi.setSelectedItem(pegawai.getValueAt(pegawai.getSelectedRow(), 3).toString());
alamat.setText(pegawai.getValueAt(pegawai.getSelectedRow(), 5).toString());

try {
    String dateString = pegawai.getValueAt(pegawai.getSelectedRow(), 4).toString();
    
    // Assuming SimpleDateFormat is used for parsing the date string
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date date = dateFormat.parse(dateString);

    tanggal.setDate(date);
} catch (ParseException | NullPointerException ex) {
    // Handle the case where the date value is not a valid date
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error setting date. Please check the date format.");
}
    }//GEN-LAST:event_pegawaiMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_searchActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new menu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        nip.setText("");
        nama.setText("");
        tanggal.setDate(null);
        alamat.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JComboBox divisi;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox jk;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nip;
    private javax.swing.JTable pegawai;
    private javax.swing.JTextField search;
    private javax.swing.JButton simpan;
    private com.toedter.calendar.JDateChooser tanggal;
    // End of variables declaration//GEN-END:variables
}