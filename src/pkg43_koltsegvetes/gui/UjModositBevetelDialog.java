package pkg43_koltsegvetes.gui;

import java.awt.Color;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Bevetel;
import pkg43_koltsegvetes.model.Penztarca;
import pkg43_koltsegvetes.model.Tranzakcio;

public class UjModositBevetelDialog extends javax.swing.JDialog {

    private boolean ok;
    private Integer modositandoBevetelID;
    private List<Penztarca> penztarcaLista;
    private List<Bevetel> bevetelekLista;
    DefaultComboBoxModel<String> bevetelMegnevezesekModel = new DefaultComboBoxModel<>();

    public UjModositBevetelDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public UjModositBevetelDialog(java.awt.Frame parent, boolean modal, List<Penztarca> penztarcaLista, List<Bevetel> bevetelekLista) {
        super(parent, modal);
        this.penztarcaLista = penztarcaLista;
        this.bevetelekLista = bevetelekLista;
        initComponents();
        dialogInicializalas();
        this.setTitle("Új bevétel felvitele");

    }

    public UjModositBevetelDialog(java.awt.Frame parent, Tranzakcio bevetelElem, List<Penztarca> penztarcaLista, List<Bevetel> bevetelekLista) {
        super(parent);
        this.setModal(true);
        this.penztarcaLista = penztarcaLista;
        this.bevetelekLista = bevetelekLista;
        initComponents();
        dialogInicializalas();
        this.setTitle("Bevétel módosítása");
        modositandoBevetelAdatokBeallit(bevetelElem);

    }

    private void dialogInicializalas() {
        this.getContentPane().setBackground(new Color(212, 232, 255));
        SwingUtilities.getRootPane(btOK).setDefaultButton(btOK);
        penztarcaValasztoFeltolt(penztarcaLista);
        inputVerifierBeallit();
        bevetelMegnevezesekModelFeltolt();
        cbBevetelMegnevezesek.setModel(bevetelMegnevezesekModel);
    }

    private void bevetelMegnevezesekModelFeltolt() {
        for (Bevetel bevetel : bevetelekLista) {
            bevetelMegnevezesekModel.addElement(bevetel.getMegnevezes());
        }
    }

    public boolean isOk() {
        return ok;
    }

    private void modositandoBevetelAdatokBeallit(Tranzakcio bevetelElem) {
        Bevetel bevetel = (Bevetel) bevetelElem;
        modositandoBevetelID = bevetel.getId();
        jxDatumValaszto.setDate(Date.from(bevetel.getDatum().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        cbBevetelMegnevezesek.setSelectedItem(bevetel.getMegnevezes());
        cbPenztarcak.setSelectedItem(bevetel.getErintettPenztarca().getNev());
        tfOsszeg.setText(bevetel.getOsszeg() + "");
    }

    private void inputVerifierBeallit() {
        Bevetel ellenorzo = new Bevetel();
        cbBevetelMegnevezesek.setInputVerifier(new InputVerifier() {
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

    public Bevetel getBevetel() {
        LocalDate datum = LocalDate.from(jxDatumValaszto.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        String megnevezes = cbBevetelMegnevezesek.getSelectedItem().toString();
        Penztarca penztarca = penztarcaKeres(cbPenztarcak.getSelectedItem().toString());
        int osszeg = Integer.parseInt(tfOsszeg.getText());
        return new Bevetel(modositandoBevetelID, datum, megnevezes, penztarca, osszeg);
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

        jLabel1 = new javax.swing.JLabel();
        btOK = new javax.swing.JButton();
        btMegsem = new javax.swing.JButton();
        lbIdopont = new javax.swing.JLabel();
        lbPenztarca = new javax.swing.JLabel();
        lbOsszeg = new javax.swing.JLabel();
        tfOsszeg = new javax.swing.JTextField();
        lbBevetel = new javax.swing.JLabel();
        cbPenztarcak = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jxDatumValaszto = new org.jdesktop.swingx.JXDatePicker();
        cbBevetelMegnevezesek = new javax.swing.JComboBox<>();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        btMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegsemActionPerformed(evt);
            }
        });

        lbIdopont.setText("Időpont");

        lbPenztarca.setText("Pénztárca");

        lbOsszeg.setText("Összeg");

        tfOsszeg.setNextFocusableComponent(btOK);

        lbBevetel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBevetel.setText("Bevétel");

        cbPenztarcak.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbPenztarcak.setNextFocusableComponent(tfOsszeg);

        jLabel2.setText("Megnevezés");

        cbBevetelMegnevezesek.setEditable(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbPenztarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(lbIdopont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbOsszeg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfOsszeg)
                    .addComponent(cbPenztarcak, javax.swing.GroupLayout.Alignment.TRAILING, 0, 127, Short.MAX_VALUE)
                    .addComponent(jxDatumValaszto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbBevetelMegnevezesek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btMegsem, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOK, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbBevetel)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbBevetel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbIdopont, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jxDatumValaszto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbBevetelMegnevezesek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPenztarca, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPenztarcak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOK))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbOsszeg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfOsszeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMegsem))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMegsemActionPerformed
        this.ok = false;
        setVisible(false);
    }//GEN-LAST:event_btMegsemActionPerformed

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        try {
            getBevetel();
            this.ok = true;
            setVisible(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Minden mezőt ki kell tölteni!", "Hiba!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btOKActionPerformed

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
            java.util.logging.Logger.getLogger(UjModositBevetelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UjModositBevetelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UjModositBevetelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UjModositBevetelDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UjModositBevetelDialog dialog = new UjModositBevetelDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbBevetelMegnevezesek;
    private javax.swing.JComboBox<String> cbPenztarcak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private org.jdesktop.swingx.JXDatePicker jxDatumValaszto;
    private javax.swing.JLabel lbBevetel;
    private javax.swing.JLabel lbIdopont;
    private javax.swing.JLabel lbOsszeg;
    private javax.swing.JLabel lbPenztarca;
    private javax.swing.JTextField tfOsszeg;
    // End of variables declaration//GEN-END:variables
}
