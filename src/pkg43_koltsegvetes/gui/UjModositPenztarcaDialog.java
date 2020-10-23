package pkg43_koltsegvetes.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Penztarca;

public class UjModositPenztarcaDialog extends javax.swing.JDialog {

    private boolean ok;
    private boolean isModositas = false;
    private String modositandoPenztarcaNeve;
    private Integer modositandoPenztarcaId;
    private List<Penztarca> penztarcaLista;

    public UjModositPenztarcaDialog(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public UjModositPenztarcaDialog(java.awt.Dialog parent, boolean modal, List<Penztarca> penztarcaLista) {
        super(parent, modal);
        this.penztarcaLista = penztarcaLista;
        setTitle("Új pénztárca felvitele");
        initComponents();
        this.getContentPane().setBackground(new Color(212, 232, 255));
        SwingUtilities.getRootPane(btOK).setDefaultButton(btOK);
        inputVerifierBeallit();
    }

    public UjModositPenztarcaDialog(java.awt.Dialog parent, boolean modal, Penztarca tarca, List<Penztarca> penztarcaLista) {
        super(parent, modal);
        this.penztarcaLista = penztarcaLista;
        isModositas = true;
        setTitle("Pénztárca módosítása");
        initComponents();
        this.getContentPane().setBackground(new Color(212, 232, 255));
        SwingUtilities.getRootPane(btOK).setDefaultButton(btOK);
        inputVerifierBeallit();
        modositandoAdatokBetolt(tarca);
        this.modositandoPenztarcaNeve = tarca.getNev();
        this.modositandoPenztarcaId = tarca.getId();
    }

    public Penztarca getPenztarca() throws NullPointerException, NumberFormatException, IllegalArgumentException {
        try {
            String nev = tfNev.getText();
            String tipus = cbPenztarcaTipus.getSelectedItem().toString();
            int osszeg = Integer.parseInt(tfOsszeg.getText());
            return new Penztarca(modositandoPenztarcaId ,nev, tipus, osszeg);
        } catch (IllegalArgumentException ex) {
            throw ex;
        }
    }
    
    public boolean isOk() {
        return ok;
    }

    private void modositandoAdatokBetolt(Penztarca tarca) {
        tfNev.setText(tarca.getNev());
        cbPenztarcaTipus.setSelectedItem(tarca.getTipus());
        tfOsszeg.setText(tarca.getOsszeg() + "");
    }

    private void inputVerifierBeallit() {
        Penztarca ellenorzo = new Penztarca();
        tfNev.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String nev = ((JTextField) input).getText();
                try {
                    ellenorzo.nevEllenorzo(nev);
                    return true;
                } catch (KoltsegvetesException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Megadott név hiba!", JOptionPane.OK_OPTION);
                    return false;
                }
            }
        });
        tfOsszeg.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String osszeg = ((JTextField) input).getText();
                try {
                    ellenorzo.osszegEllenorzo(osszeg);
                    return true;
                } catch (KoltsegvetesException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Megadott összeg hiba!", JOptionPane.OK_OPTION);
                    return false;
                }
            }
        });
    }

    private boolean nevEgyezesEllenorzo() {
        List<Penztarca> ellenorzoLista = new ArrayList<>();
        penztarcaLista.forEach((tarca) -> {
            ellenorzoLista.add(tarca);
        });
        if (isModositas) {
            int torlendo = -1;
            for (int i = 0; i < ellenorzoLista.size(); i++) {
                if (ellenorzoLista.get(i).getNev().equals(modositandoPenztarcaNeve)) {
                    torlendo = i;
                }
            }
            if (torlendo != -1) {
                ellenorzoLista.remove(torlendo);
            }
        }
        for (Penztarca tarca : ellenorzoLista) {
            if (tarca.getNev().equals(tfNev.getText())) {
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cimLabel = new javax.swing.JLabel();
        nevLabel = new javax.swing.JLabel();
        tipusLabel = new javax.swing.JLabel();
        osszegLabel = new javax.swing.JLabel();
        tfNev = new javax.swing.JTextField();
        tfOsszeg = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        btMegsem = new javax.swing.JButton();
        cbPenztarcaTipus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cimLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cimLabel.setText("Pénztárca");

        nevLabel.setText("Név");

        tipusLabel.setText("Típus");

        osszegLabel.setText("Összeg");

        tfNev.setNextFocusableComponent(cbPenztarcaTipus);

        tfOsszeg.setNextFocusableComponent(btOK);

        btOK.setText("OK");
        btOK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btOK.setNextFocusableComponent(btMegsem);
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btMegsem.setText("Mégsem");
        btMegsem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btMegsem.setNextFocusableComponent(tfNev);
        btMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegsemActionPerformed(evt);
            }
        });

        cbPenztarcaTipus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Készpénz", "Bankkártya", "Vendéglátás zseb", "Szállás zseb", "Szabadidő zseb", "Megtakarítási számla" }));
        cbPenztarcaTipus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbPenztarcaTipus.setNextFocusableComponent(tfOsszeg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nevLabel)
                    .addComponent(tipusLabel)
                    .addComponent(osszegLabel))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNev)
                    .addComponent(tfOsszeg)
                    .addComponent(cbPenztarcaTipus, 0, 162, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMegsem))
                .addGap(26, 26, 26))
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(cimLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btMegsem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cimLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nevLabel)
                            .addComponent(tfNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tipusLabel)
                            .addComponent(cbPenztarcaTipus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(osszegLabel)
                            .addComponent(tfOsszeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        if (nevEgyezesEllenorzo()) {
            JOptionPane.showMessageDialog(rootPane, "Nem lehet két azonos nevű pénztárca!", "Elnevezés hiba!", JOptionPane.OK_OPTION);
        } else {
            this.ok = true;
            setVisible(false);
        }
    }//GEN-LAST:event_btOKActionPerformed

    private void btMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMegsemActionPerformed
        this.ok = false;
        setVisible(false);
    }//GEN-LAST:event_btMegsemActionPerformed

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
            java.util.logging.Logger.getLogger(UjModositPenztarcaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UjModositPenztarcaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UjModositPenztarcaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UjModositPenztarcaDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UjModositPenztarcaDialog dialog = new UjModositPenztarcaDialog(new javax.swing.JDialog(), true);
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
    private javax.swing.JButton btOK;
    private javax.swing.JComboBox<String> cbPenztarcaTipus;
    private javax.swing.JLabel cimLabel;
    private javax.swing.JLabel nevLabel;
    private javax.swing.JLabel osszegLabel;
    private javax.swing.JTextField tfNev;
    private javax.swing.JTextField tfOsszeg;
    private javax.swing.JLabel tipusLabel;
    // End of variables declaration//GEN-END:variables
}
