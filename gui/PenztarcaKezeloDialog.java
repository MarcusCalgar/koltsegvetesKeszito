package pkg43_koltsegvetes.gui;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import pkg43_koltsegvetes.model.Penztarca;
import pkg43_koltsegvetes.dao.impl.PenztarcaDAO_JDBC;
import pkg43_koltsegvetes.exception.KoltsegvetesException;

public class PenztarcaKezeloDialog extends javax.swing.JDialog {

    private int oszlopokSzama = 3;
    private Penztarca kijeloltPenztarca;
    private List<Penztarca> penztarcaLista;
    private boolean ok;
    private PenztarcaDAO_JDBC penztarcaIrany;

    public PenztarcaKezeloDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public PenztarcaKezeloDialog(java.awt.Frame parent, boolean modal, List<Penztarca> penztarcaLista, PenztarcaDAO_JDBC penztarcaIrany) {
        super(parent, modal);
        initComponents();
        SwingUtilities.getRootPane(btOK).setDefaultButton(btOK);
        setTitle("Pénztárcák kezelése");
        this.penztarcaIrany = penztarcaIrany;
        this.penztarcaLista = penztarcaLista;
        tablaFeltolt(penztarcakTable, penztarcaLista);
    }

    public List<Penztarca> getPenztarcaLista() {
        return penztarcaLista;
    }

    public boolean isOk() {
        return ok;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btUjPenztarca = new javax.swing.JButton();
        btModositas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        penztarcakTable = new javax.swing.JTable();
        btOK = new javax.swing.JButton();
        btMegsem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Pénztárcák Kezelése");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Elérhető Pénztárcák");

        btUjPenztarca.setText("Új pénztárca");
        btUjPenztarca.setNextFocusableComponent(btModositas);
        btUjPenztarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUjPenztarcaActionPerformed(evt);
            }
        });

        btModositas.setText("Módosítás");
        btModositas.setNextFocusableComponent(btOK);
        btModositas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModositasActionPerformed(evt);
            }
        });

        penztarcakTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Név", "Típus", "Összeg"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(penztarcakTable);

        btOK.setText("OK");
        btOK.setNextFocusableComponent(btMegsem);
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btMegsem.setText("Mégsem");
        btMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegsemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btUjPenztarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btModositas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btMegsem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btUjPenztarca)
                        .addGap(18, 18, 18)
                        .addComponent(btModositas)
                        .addGap(59, 59, 59)
                        .addComponent(btOK)
                        .addGap(18, 18, 18)
                        .addComponent(btMegsem))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btUjPenztarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUjPenztarcaActionPerformed
        UjModositPenztarcaDialog penztarcaKezeloAblak = new UjModositPenztarcaDialog(this, true, penztarcaLista);
        penztarcaKezeloAblak.setVisible(true);
        if (penztarcaKezeloAblak.isOk()) {
            penztarcaLista.add(penztarcaKezeloAblak.getPenztarca());
            penztarcaAdatbazisbaMent(penztarcaKezeloAblak.getPenztarca());
            tablaFeltolt(penztarcakTable, penztarcaLista);
            try {
                penztarcaLista = penztarcaIrany.osszesBetolt();
            } catch (KoltsegvetesException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis kapcsolat hiba!", JOptionPane.OK_OPTION);
            }
        }
    }//GEN-LAST:event_btUjPenztarcaActionPerformed

    private void btModositasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModositasActionPerformed
        int kijeloltSorSzama = penztarcakTable.getSelectedRow();
        if (penztarcakTable.getSelectedRow() != -1) {
            kijeloltPenztarca = penztarcaLista.get(kijeloltSorSzama);
            UjModositPenztarcaDialog penztarcaKezeloAblak = new UjModositPenztarcaDialog(this, true, kijeloltPenztarca, penztarcaLista);
            penztarcaKezeloAblak.setVisible(true);
            if (penztarcaKezeloAblak.isOk()) {                
                penztarcaLista.remove(kijeloltSorSzama);                
                penztarcaLista.add(kijeloltSorSzama, penztarcaKezeloAblak.getPenztarca());
                penztarcaAdatbazisbaMent(kijeloltPenztarca);
                penztarcaAdatbazisbaMent(penztarcaKezeloAblak.getPenztarca());
                tablaFeltolt(penztarcakTable, penztarcaLista);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Előbb jelölj ki egy pénztárcát!", "Módosítás hiba!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btModositasActionPerformed

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        this.ok = true;
        setVisible(false);
    }//GEN-LAST:event_btOKActionPerformed

    private void btMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMegsemActionPerformed
        this.ok = false;
        setVisible(false);
    }//GEN-LAST:event_btMegsemActionPerformed

    private void penztarcaAdatbazisbaMent(Penztarca penztarca) {
        try {
            penztarcaIrany.elment(penztarca);
        } catch (KoltsegvetesException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Hiba a pénztárca mentése közben!", JOptionPane.OK_OPTION);
        }
    }
    
    private Object[] sorKeszit(Penztarca tarca) {
        Object[] ujSor = new Object[oszlopokSzama];
        ujSor[0] = tarca.getNev();
        ujSor[1] = tarca.getTipus();
        ujSor[2] = tarca.getOsszeg();
        return ujSor;
    }

    private void tablaFeltolt(JTable tabla, List<Penztarca> lista) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        if (model.getRowCount() > 0) {
            model.setRowCount(0);
        }
        lista.forEach((elem) -> {
            model.insertRow(model.getRowCount(), sorKeszit(elem));
        });
        tabla.setFillsViewportHeight(true);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
    
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
            java.util.logging.Logger.getLogger(PenztarcaKezeloDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PenztarcaKezeloDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PenztarcaKezeloDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PenztarcaKezeloDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PenztarcaKezeloDialog dialog = new PenztarcaKezeloDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btMegsem;
    private javax.swing.JButton btModositas;
    private javax.swing.JButton btOK;
    private javax.swing.JButton btUjPenztarca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable penztarcakTable;
    // End of variables declaration//GEN-END:variables
}
