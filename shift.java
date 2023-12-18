/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import net.sf.jasperreports.engine.design.JRDesignParameter;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;


/**
 *
 * @author ACER
 */
public class shift extends javax.swing.JFrame {
public Statement st;
public ResultSet rs;
public DefaultTableModel tabModel;
Connection cn = view.koneksi.Koneksi();


    /**
     * Creates new form shift
     */
    public shift() {
        initComponents();
        judul();
        tampilData("");
    }

    public void reset() {
nip.setText("");
nama.setText("");
divisi.setSelectedItem("");
bulan.setSelectedItem("");
minggu.setSelectedItem("");
shift.setSelectedItem("");
}
    public void judul() {
Object[] judul = {
"No","NIP", "Nama", "Divisi", "Bulan", "Minggu", "Shift"
};
tabModel = new DefaultTableModel(null, judul);
tbshift.setModel(tabModel);
}
    
public void tampilData(String where) {
    try {
        st = cn.createStatement();
        tabModel.getDataVector().removeAllElements();
        tabModel.fireTableDataChanged();
        rs = st.executeQuery("SELECT * FROM shift " + where);

        while (rs.next()) {
            Object[] data = {
                rs.getString("no"),
                rs.getString("nip"),
                rs.getString("nama"),
                rs.getString("divisi"),
                rs.getString("bulan"),
                rs.getString("minggu"),
                rs.getString("shift"),
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
    Object[] judul_kolom = {"No", "NIP", "Nama", "Divisi", "Bulan", "Minggu", "Shift"};
    tabModel = new DefaultTableModel(null, judul_kolom);
    tbshift.setModel(tabModel);

    Connection conn = (Connection) koneksi.Koneksi();
    Statement stt = conn.createStatement();
    tabModel.getDataVector().removeAllElements();

    rs = stt.executeQuery("SELECT * FROM shift WHERE nip LIKE '%" + key + "%' OR nama LIKE '%" + key + "%'");
    while (rs.next()) {
        Object[] data = {
            rs.getString("no"),
            rs.getString("nip"),
            rs.getString("nama"),
            rs.getString("divisi"),
            rs.getString("bulan"),
            rs.getString("minggu"),
            rs.getString("shift")
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

        nip = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        divisi = new javax.swing.JComboBox();
        bulan = new javax.swing.JComboBox();
        minggu = new javax.swing.JComboBox();
        shift = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbshift = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        no = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        cetak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nip.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NIP", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        nip.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nipKeyReleased(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel1.setText("DATA SHIFT KARYAWAN");

        nama.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NAMA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        nama.setEnabled(false);

        divisi.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Supporting Division", "Operation Division", "Networking Dev", "Networking Operator " }));
        divisi.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DIVISI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        divisi.setEnabled(false);

        bulan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli ", "Agustus", "September", "Oktober ", "November", "Desember" }));
        bulan.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BULAN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        minggu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
        minggu.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MINGGU", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        shift.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pagi (07.00-15.00)", "Normal (09.00-17.00)", "Siang (15.00-23.00)", "Malam (23.00-07.00)" }));
        shift.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "SHIFT", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N

        tbshift.setModel(new javax.swing.table.DefaultTableModel(
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
        tbshift.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbshiftMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbshift);

        simpan.setText("SIMPAN");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

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

        search.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "search data", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 1, 12))); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        no.setEnabled(false);

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

        cetak.setText("CETAK");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(nip, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(jLabel1))
                        .addComponent(nama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(shift, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(minggu, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(divisi, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edit)
                        .addGap(7, 7, 7)
                        .addComponent(jButton2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cetak))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(divisi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bulan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(minggu, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(shift, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpan)
                            .addComponent(hapus)
                            .addComponent(edit)
                            .addComponent(jButton2)
                            .addComponent(cetak)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
  try {
    // Validate that required fields are not empty
    if (nama.getText().isEmpty() || divisi.getSelectedItem() == null
            || bulan.getSelectedItem() == null || minggu.getSelectedItem() == null || shift.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(null, "Harap lengkapi semua kolom sebelum menyimpan.");
    } else {
        st = cn.createStatement();
        st.executeUpdate("INSERT INTO shift (nip, nama, divisi, bulan, minggu, shift) VALUES ('" + nip.getText() + "','"
                + nama.getText() + "','"
                + divisi.getSelectedItem() + "','"
                + bulan.getSelectedItem() + "','"
                + minggu.getSelectedItem() + "','"   
                + shift.getSelectedItem() + "')");
        
        tampilData("");
        JOptionPane.showMessageDialog(null, "Simpan Berhasil");
        
        // Clear the form fields
        nip.setText("");
        nama.setText("");
        divisi.setSelectedItem("");
        bulan.setSelectedItem("");
        minggu.setSelectedItem("");
        shift.setSelectedItem("");
    }
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
                st.executeUpdate("DELETE FROM shift WHERE no='"
                    + tabModel.getValueAt(tbshift.getSelectedRow(), 0) + "'");
                tampilData("");
                reset();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void tbshiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbshiftMouseClicked
        // TODO add your handling code here:
        no.setText(tbshift.getValueAt(tbshift.getSelectedRow(), 0).toString());
          nip.setText(tbshift.getValueAt(tbshift.getSelectedRow(), 1).toString());
nama.setText(tbshift.getValueAt(tbshift.getSelectedRow(), 2).toString());
divisi.setSelectedItem(tbshift.getValueAt(tbshift.getSelectedRow(), 3).toString());
bulan.setSelectedItem(tbshift.getValueAt(tbshift.getSelectedRow(), 4).toString());
minggu.setSelectedItem(tbshift.getValueAt(tbshift.getSelectedRow(), 5).toString());
shift.setSelectedItem(tbshift.getValueAt(tbshift.getSelectedRow(), 6).toString());
    }//GEN-LAST:event_tbshiftMouseClicked

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:\
       if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
        // Jika tombol Enter ditekan, lakukan pencarian
        cariData(search.getText());
    }
    }//GEN-LAST:event_searchKeyReleased

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
      try{
        // Periksa apakah ada baris yang dipilih dalam tabel
        if (tbshift.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Pilih baris yang ingin diedit.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Jika tidak ada baris yang dipilih, hentikan proses edit
        }

        int jawab = JOptionPane.showConfirmDialog(null, "Ingin menyimpan perubahan?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (jawab == 0) {
            st = cn.createStatement();
            String no = tbshift.getValueAt(tbshift.getSelectedRow(), 0).toString(); // Ambil nilai no dari baris terpilih
            String newNip = nip.getText();
            String newNama = nama.getText();
            String newDivisi = divisi.getSelectedItem().toString();
            String newBulan = bulan.getSelectedItem().toString();
            String newMinggu = minggu.getSelectedItem().toString();
            String newShift = shift.getSelectedItem().toString();

            // Gunakan nilai baru untuk mengupdate data
            st.executeUpdate("UPDATE shift SET nip='" + newNip + "', nama='" + newNama + "', divisi='" + newDivisi + "',"
                    + " bulan='" + newBulan + "', minggu='" + newMinggu + "', shift='" + newShift + "' WHERE no='" + no + "'");

            JOptionPane.showMessageDialog(null, "Perubahan berhasil disimpan.");

            // Refresh tampilan tabel
            tampilData("");
            reset(); // Clear the form fields
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_editActionPerformed

    private void nipKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nipKeyReleased
        // TODO add your handling code here:
    try {
        String inputNip = nip.getText().trim();
        if (!inputNip.isEmpty()) {
            st = cn.createStatement();
            ResultSet result = st.executeQuery("SELECT nama, divisi FROM biodata WHERE nip='" + inputNip + "'");

            if (result.next()) {
                // Jika NIP ditemukan, isi otomatis field nama dan divisi
                nama.setText(result.getString("nama"));
                divisi.setSelectedItem(result.getString("divisi"));
            } else {
                // Jika NIP tidak ditemukan, kosongkan field nama dan divisi
                nama.setText("");
                divisi.setSelectedItem(null);
            }
        } else {
            // Jika NIP kosong, kosongkan juga field nama dan divisi
            nama.setText("");
            divisi.setSelectedItem(null);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }//GEN-LAST:event_nipKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
        this.dispose();
        new menu().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
     try {
JasperDesign jdesign =
JRXmlLoader.load("D:\\NetBeansProjects\\kerjaprojek3\\src\\view\\shift.jrxml"); 
String query = "select * from shift";
JRDesignQuery updateQuery = new JRDesignQuery();
updateQuery.setText(query);
jdesign.setQuery(updateQuery);

JasperReport jreport =
JasperCompileManager.compileReport(jdesign);
JasperPrint jprint =
JasperFillManager.fillReport(jreport, null, cn);
JasperViewer.viewReport(jprint,
rootPaneCheckingEnabled, Locale.FRENCH);
} catch(Exception e) {
e.printStackTrace();
}
    }//GEN-LAST:event_cetakActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        nip.setText("");
        nama.setText(""); 
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
            java.util.logging.Logger.getLogger(shift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(shift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(shift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(shift.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new shift().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox bulan;
    private javax.swing.JButton cetak;
    private javax.swing.JComboBox divisi;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox minggu;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nip;
    private javax.swing.JTextField no;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox shift;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tbshift;
    // End of variables declaration//GEN-END:variables
}
