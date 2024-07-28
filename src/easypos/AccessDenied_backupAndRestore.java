/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easypos;

//import com.dfc.www.public_access.user_frontend.User_Home;
//import com.fsc.zone.com.db.SendAttachmentInEmail;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author deepalsuranga
 */
public class AccessDenied_backupAndRestore extends javax.swing.JFrame {

    /**
     * Creates new form AccessDenied_backupAndRestore
     */
    private static String property_host, property_port;
//    private static String property_Backup = System.getProperty("user.home") + "\\" + "MASTER_BACKUP_PATH";
    private static final String property_Backup = "C:\\DCS\\MASTER_BACKUP\\";
    private static String property_database, property_user, property_password;

    public AccessDenied_backupAndRestore() {
        initComponents();

        try {

            // load a properties file
            property_host = DBB.ip;
            property_port = DBB.port;

//            property_Backup = System.getProperty("user.home") + "\\" + "MASTER_BACKUP_PATH";

            tf_pathsetText.setText("");
            tf_pathsetText.setText(property_Backup);
            File f=new File(property_Backup);
            f.mkdirs();
            
            property_database = DBB.dbName;
            property_user = DBB.un;
            property_password = DBB.pw;

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            md_create_BASICPATHFOLDER();
            md_loadBACKUP();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // md_loadDaabaseisHave();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_backupview = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        lb_output = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        bt_backup = new javax.swing.JButton();
        tf_pathsetText = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(61, 61, 61));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));

        tb_backupview.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Backup", "Date", "Time", "Size"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_backupview.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_backupviewMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_backupview);
        if (tb_backupview.getColumnModel().getColumnCount() > 0) {
            tb_backupview.getColumnModel().getColumn(0).setMinWidth(300);
            tb_backupview.getColumnModel().getColumn(1).setMinWidth(50);
            tb_backupview.getColumnModel().getColumn(2).setMinWidth(50);
            tb_backupview.getColumnModel().getColumn(3).setMinWidth(50);
        }

        jPanel4.setBackground(new java.awt.Color(0, 153, 255));

        lb_output.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 18)); // NOI18N
        lb_output.setForeground(java.awt.SystemColor.controlLtHighlight);
        lb_output.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_output.setText("Welcome to Backup & Restore System");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_output, javax.swing.GroupLayout.PREFERRED_SIZE, 849, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lb_output, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manual Backups:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        bt_backup.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_backup.setText("Backup");
        bt_backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_backupActionPerformed(evt);
            }
        });

        tf_pathsetText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf_pathsetTextMouseClicked(evt);
            }
        });
        tf_pathsetText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pathsetTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tf_pathsetText, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(bt_backup, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_pathsetText, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(bt_backup, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addContainerGap())
        );

        jButton2.setText("Refresh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 153, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Developer Area | Developer Access only!");

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-home-24.png"))); // NOI18N
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 362, Short.MAX_VALUE)
                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
            .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bt_backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_backupActionPerformed

        md_createBackup("Developer");
        try {
            md_loadBACKUP();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_bt_backupActionPerformed

    private void tf_pathsetTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pathsetTextActionPerformed


    }//GEN-LAST:event_tf_pathsetTextActionPerformed

    private void tf_pathsetTextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf_pathsetTextMouseClicked

        tf_pathsetText.setText(getBackUpPath());

    }//GEN-LAST:event_tf_pathsetTextMouseClicked
    String subSequence;
    private void tb_backupviewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_backupviewMouseClicked

        String Codes = (String) tb_backupview.getValueAt(tb_backupview.getSelectedRow(), 0);
        subSequence = (String) Codes.subSequence(Codes.indexOf("[") + 1, Codes.indexOf("]"));
        System.out.println(subSequence);


    }//GEN-LAST:event_tb_backupviewMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        md_loadBACKUP();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        new Dashboard_001().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton17ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AccessDenied_backupAndRestore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AccessDenied_backupAndRestore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AccessDenied_backupAndRestore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AccessDenied_backupAndRestore.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AccessDenied_backupAndRestore().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bt_backup;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_output;
    public static javax.swing.JTable tb_backupview;
    private javax.swing.JTextField tf_pathsetText;
    // End of variables declaration//GEN-END:variables

    private void md_loadDaabaseisHave() {
//FSC_Creation\System_Backup
        try {

            String property_BackupPath = System.getProperty("user.home") + "\\" + "OneDrive\\" + "MASTER_BACKUP_PATH";
            File files = new File(property_BackupPath);
            if (!files.exists()) {
                if (files.mkdirs()) {
                    System.out.println("SUCCESSFULLY: CREATED MASTER BACKUP PATH DIRECTORIES!");
                } else {
                    System.out.println("FAILED: CREATED MASTER BACKUP PATH DIRECTORIES!");
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(AccessDenied_backupAndRestore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    Thread trd_1;

    private void md_create_BASICPATHFOLDER() {

        try {

            File BASICPATHFOLDERS = new File(System.getProperty("user.home") + "\\" + "OneDrive\\" + "MASTER_BACKUP_PATH");
            if (!BASICPATHFOLDERS.exists()) {
                if (BASICPATHFOLDERS.mkdirs()) {
                    trd_1 = new Thread(() -> {
                        lb_output.setText("");
                        lb_output.setText("SUCCESSFULLY: BASE PATH FOLDER & MASTER BACKUP PATH DIRECTORIES CREATED!");
                    });

                    trd_1.start();
                    System.out.println("SUCCESSFULLY: CREATED BASICPATHFOLDER & MASTER BACKUP PATH DIRECTORIES!");

                } else {
                    trd_1 = new Thread(() -> {
                        lb_output.setText("");
                        lb_output.setForeground(Color.RED);
                        lb_output.setText("FAILED: BASE PATH FOLDER & MASTER BACKUP PATH DIRECTORIES CREATED!");
                    });

                    trd_1.start();
                    System.out.println("FAILED: CREATED BASICPATHFOLDER & MASTER BACKUP PATH DIRECTORIES!");
                }

            } else {
                trd_1 = new Thread(() -> {

                    lb_output.setText("FAILED: ALREADY EXISTS!");
                });

                trd_1.start();

            }

            //inputStream = new FileInputStream("C:\\FSC_Technology\\System_Backup");
        } catch (Exception ex) {
            Logger.getLogger(AccessDenied_backupAndRestore.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String getBackUpPath() {

        String backUpPath = "";
        JFileChooser fc = null;
        if (fc == null) {
            fc = new JFileChooser();
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fc.setAcceptAllFileFilterUsed(false);
        }
        int returnVal = fc.showDialog(null, "Open");
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            backUpPath = file.getAbsolutePath();
        }
        return backUpPath;
    }

    private void md_loadBACKUP() {

        DefaultTableModel dtm = (DefaultTableModel) tb_backupview.getModel();
        dtm.setRowCount(0);
        FilenameFilter sqlFilter = (File file, String name) -> {
            return name.endsWith(".zip"); // filters files whose extension is .mp3
        };

        String dirPath = property_Backup;
        File dir = new File(dirPath);
        File[] files = dir.listFiles(sqlFilter);

        if (files.length == 0) {
            Vector v = new Vector();
            v.add("There is no BACKUP files".toUpperCase());
            dtm.addRow(v);
            System.out.println("There is no sql files");
        } else {
            int i = 0;
            for (File aFile : files) {
                i++;
                Vector v = new Vector();
                String part = aFile.getName();
                String[] split = part.split("-");
                String s = split[3];
                String s2 = split[4];
                String[] datePart = s.split("%");
                String[] datePart2 = s.split("~");
                //v.add("Backup_Data-" + i + "(" + part.replaceAll(".zip", "") + ")");
                v.add("Backup_Data-" + i + "[" + part + "]");
//dd-MM-yyyy%hh~mm~ss
                v.add(datePart[0] + "-" + datePart[1] + "-" + datePart[2]);
                v.add(s2.replaceAll(".zip", "").replaceAll("~", ":"));

                double bytes = aFile.length();
                double kilobytes = (bytes / 1024);
                long roundDouble = Math.round(kilobytes);
                v.add(+kilobytes + "~(" + roundDouble + "KB)");
                dtm.addRow(v);
            }
        }

    }
    String nameGEN;

    public String md_createBackup(String typeuser) {

        try {

            String host = property_host;
            String port = property_port;
            //String backuppath = tf_pathsetText.getText();
            String backuppath = property_Backup;
            String Database = property_database;
            String Password = property_password;
            String user = property_user;

            System.out.println("H:" + host);

            System.out.println("H:" + backuppath);
            System.out.println("H:" + Database);

            Backup b = new Backup();
            Date d = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd%MM%yyyy-hh~mm~ss");
            String date = sdf.format(d);
            System.out.println(date);
            try {

                byte[] data = b.getData(host, port, user, Password, Database).getBytes();
                System.out.println("$$" + property_Backup+ "\\" + "BACKUP(" + typeuser + ")-" + Database.toUpperCase() + "-DC-" + date + ".zip");
                File filedst = new File(property_Backup+ "\\" + "BACKUP(" + typeuser + ")-" + Database.toUpperCase() + "-DC-" + date + ".zip");

                nameGEN = "BACKUP(" + typeuser + ")-" + Database.toUpperCase() + "-DC-" + date + ".zip";

                FileOutputStream dest = new FileOutputStream(filedst);
                ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(dest));
                zip.setMethod(ZipOutputStream.DEFLATED);
                zip.setLevel(Deflater.BEST_COMPRESSION);
                zip.putNextEntry(new ZipEntry("BACKUP_DATA_" + Database.toUpperCase() + ".sql"));
                zip.write(data);
                zip.close();
                dest.close();
                JOptionPane.showMessageDialog(null, "HAVE A NICE DAY! \n Back Up Successfully." + "\n" + "For Database: " + Database, "Database BackUp Wizard", JOptionPane.INFORMATION_MESSAGE);

            } catch (IOException | HeadlessException ex) {
                JOptionPane.showMessageDialog(null, "IT'S OK! You can try again! \nBack Up Failed." + "\n" + "For Database: " + Database, "Database BackUp Wizard", JOptionPane.INFORMATION_MESSAGE);
                ex.printStackTrace();
            }

        } catch (HeadlessException ex) {
            Logger.getLogger(AccessDenied_backupAndRestore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nameGEN;
    }

}
