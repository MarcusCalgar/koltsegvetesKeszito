package pkg43_koltsegvetes.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Kiadas;
import pkg43_koltsegvetes.model.Penztarca;
import pkg43_koltsegvetes.model.Tranzakcio;

public class UjModositKiadasDialog extends javax.swing.JDialog {

    private boolean ok;
    private Integer modositandoKiadasID;
    private List<Penztarca> penztarcaLista;

    public UjModositKiadasDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public UjModositKiadasDialog(java.awt.Frame parent, boolean modal, List<Penztarca> penztarcaLista) {
        super(parent, modal);
        this.penztarcaLista = penztarcaLista;
        initComponents();
        this.getContentPane().setBackground(new Color(212, 232, 255));
        SwingUtilities.getRootPane(btOK).setDefaultButton(btOK);
        comboBoxFeltolt();
        inputVerifierBeallit();
        this.setTitle("Új kiadás felvitele");
    }

    public UjModositKiadasDialog(java.awt.Frame parent, Tranzakcio kiadasElem, List<Penztarca> penztarcaLista) {
        super(parent);
        this.setModal(true);
        this.penztarcaLista = penztarcaLista;
        initComponents();
        this.getContentPane().setBackground(new Color(212, 232, 255));
        SwingUtilities.getRootPane(btOK).setDefaultButton(btOK);
        comboBoxFeltolt();
        inputVerifierBeallit();
        this.setTitle("Kiadás módosítása");
        modositandoKiadasAdatokBetolt(kiadasElem);
    }

    public boolean isOk() {
        return ok;
    }

    private void modositandoKiadasAdatokBetolt(Tranzakcio kiadasElem) {
        Kiadas kiadas = (Kiadas) kiadasElem;
        modositandoKiadasID = kiadas.getId();
        jxDatumValaszto.setDate(Date.from(kiadas.getDatum().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        tfMegnevezes.setText(kiadas.getMegnevezes());
        cbPenztarcak.setSelectedItem(kiadas.getErintettPenztarca().getNev());
        cbKategoria.setSelectedItem(kiadas.getKategoria());
        cbVasarlasHelye.setSelectedItem(kiadas.getKiadasHely());
        tfOsszeg.setText(kiadas.getOsszeg() + "");
    }

    private void inputVerifierBeallit() {
        Kiadas ellenorzo = new Kiadas();
        tfMegnevezes.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String megnevezes = ((JTextField) input).getText();
                try {
                    ellenorzo.megnevezesEllenorzo(megnevezes);
                    return true;
                } catch (KoltsegvetesException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Megadott megnevezés hiba!", JOptionPane.OK_OPTION);
                    return false;
                }
            }
        });
        cbKategoria.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String kategoria = ((JComboBox<String>) input).getSelectedItem().toString();
                try {
                    ellenorzo.kategoriaEllenorzo(kategoria);
                    return true;
                } catch (KoltsegvetesException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Megadott kategória hiba!", JOptionPane.OK_OPTION);
                    return false;
                }
            }
        });
        cbVasarlasHelye.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String kiadasHely = ((JComboBox<String>) input).getSelectedItem().toString();
                try {
                    ellenorzo.kiadasHelyEllenorzo(kiadasHely);
                    return true;
                } catch (KoltsegvetesException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Megadott kiadási hely hiba!", JOptionPane.OK_OPTION);
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

    private void comboBoxFeltolt() {
        penztarcaValasztoFeltolt(penztarcaLista);
        szerkeszthetoComboBoxKeszit(cbKategoria);
        szerkeszthetoComboBoxKeszit(cbVasarlasHelye);
    }

    private void szerkeszthetoComboBoxKeszit(JComboBox<String> box) {
        box.setEditable(true);
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("comboBoxEdited".equals(e.getActionCommand())) {
                    box.addItem(box.getSelectedItem().toString());
                }
            }
        });
    }

    public Kiadas getKiadas() {
        LocalDate datum = LocalDate.from(jxDatumValaszto.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        String megnevezes = tfMegnevezes.getText();
        Penztarca penztarca = penztarcaKeres(cbPenztarcak.getSelectedItem().toString());
        String kategoria = cbKategoria.getSelectedItem().toString();
        String vasarlasHelye = cbVasarlasHelye.getSelectedItem().toString();
        int osszeg = Integer.parseInt(tfOsszeg.getText());
        return new Kiadas(modositandoKiadasID, datum, megnevezes, penztarca, kategoria, vasarlasHelye, osszeg);
    }

    private void penztarcaValasztoFeltolt(List<Penztarca> penztarcaLista) {
        String[] penztarcaNevek = new String[penztarcaLista.size()];
        for (int i = 0; i < penztarcaNevek.length; i++) {
            penztarcaNevek[i] = penztarcaLista.get(i).getNev();
        }
        cbPenztarcak.setModel(new DefaultComboBoxModel<>(penztarcaNevek));
    }

    private Penztarca penztarcaKeres(String nev) {
        for (Penztarca tarca : penztarcaLista) {
            if (tarca.getNev().equals(nev)) {
                return tarca;
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbVasarlasHelye = new javax.swing.JLabel();
        lbErintettPenztarca = new javax.swing.JLabel();
        lbOsszeg = new javax.swing.JLabel();
        tfOsszeg = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        btMegsem = new javax.swing.JButton();
        lbKiadas = new javax.swing.JLabel();
        lbKategoria = new javax.swing.JLabel();
        lbIdopont = new javax.swing.JLabel();
        cbKategoria = new javax.swing.JComboBox<>();
        cbPenztarcak = new javax.swing.JComboBox<>();
        jxDatumValaszto = new org.jdesktop.swingx.JXDatePicker();
        lbMegnevezes = new javax.swing.JLabel();
        tfMegnevezes = new javax.swing.JTextField();
        cbVasarlasHelye = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbVasarlasHelye.setText("Vásárlás helye");

        lbErintettPenztarca.setText("Érintett pénztárca");

        lbOsszeg.setText("Összeg");

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
        btMegsem.setNextFocusableComponent(jxDatumValaszto);
        btMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegsemActionPerformed(evt);
            }
        });

        lbKiadas.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbKiadas.setText("Kiadás");

        lbKategoria.setText("Kategória");

        lbIdopont.setText("Időpont");

        cbKategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rezsi", "Élelmiszer", "Étkezés", "Egészség", "Közlekedés", "Egyéb" }));
        cbKategoria.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbKategoria.setNextFocusableComponent(cbVasarlasHelye);

        cbPenztarcak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbPenztarcak.setNextFocusableComponent(cbKategoria);

        jxDatumValaszto.setNextFocusableComponent(tfMegnevezes);

        lbMegnevezes.setText("Megnevezés");

        tfMegnevezes.setNextFocusableComponent(cbPenztarcak);

        cbVasarlasHelye.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Egyéb" }));
        cbVasarlasHelye.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbVasarlasHelye.setNextFocusableComponent(tfOsszeg);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbIdopont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbErintettPenztarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbMegnevezes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbKategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbVasarlasHelye, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbOsszeg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfMegnevezes)
                    .addComponent(jxDatumValaszto, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(cbPenztarcak, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbKategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbVasarlasHelye, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfOsszeg))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMegsem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbKiadas)
                .addGap(158, 158, 158))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbKiadas)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdopont)
                    .addComponent(jxDatumValaszto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMegnevezes)
                    .addComponent(tfMegnevezes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbErintettPenztarca)
                    .addComponent(cbPenztarcak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbKategoria)
                    .addComponent(cbKategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbVasarlasHelye)
                    .addComponent(btOK)
                    .addComponent(cbVasarlasHelye, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbOsszeg)
                    .addComponent(tfOsszeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMegsem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        try {
            getKiadas();
            this.ok = true;
            setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Minden mezőt ki kell tölteni!", "Hiba!", JOptionPane.OK_OPTION);
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
            java.util.logging.Logger.getLogger(UjModositKiadasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UjModositKiadasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UjModositKiadasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UjModositKiadasDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UjModositKiadasDialog dialog = new UjModositKiadasDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbKategoria;
    private javax.swing.JComboBox<String> cbPenztarcak;
    private javax.swing.JComboBox<String> cbVasarlasHelye;
    private org.jdesktop.swingx.JXDatePicker jxDatumValaszto;
    private javax.swing.JLabel lbErintettPenztarca;
    private javax.swing.JLabel lbIdopont;
    private javax.swing.JLabel lbKategoria;
    private javax.swing.JLabel lbKiadas;
    private javax.swing.JLabel lbMegnevezes;
    private javax.swing.JLabel lbOsszeg;
    private javax.swing.JLabel lbVasarlasHelye;
    private javax.swing.JTextField tfMegnevezes;
    private javax.swing.JTextField tfOsszeg;
    // End of variables declaration//GEN-END:variables
}
