package pkg43_koltsegvetes.gui;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.Kiadas;
import pkg43_koltsegvetes.model.Penztarca;

public class AtvezetesDialog extends javax.swing.JDialog {

    private boolean ok;
    private String forrasTarcaNev;
    private String celTarcaNev;
    private int atvezetettOsszeg;

    public AtvezetesDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public AtvezetesDialog(java.awt.Frame parent, boolean modal, List<Penztarca> penztarcaLista) {
        super(parent, modal);
        initComponents();
        penztarcaValasztoFeltolt(penztarcaLista);
        inputVerifierBeallit();
        SwingUtilities.getRootPane(btOK).setDefaultButton(btOK);
    }

    public boolean isOk() {
        return ok;
    }

    public String getForrasTarcaNev() {
        return forrasTarcaNev;
    }

    public String getCelTarcaNev() {
        return celTarcaNev;
    }

    public int getAtvezetettOsszeg() {
        return atvezetettOsszeg;
    }

    private void inputVerifierBeallit() {
        Kiadas ellenorzo = new Kiadas();
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

    private void penztarcaValasztoFeltolt(List<Penztarca> penztarcaLista) {
        String[] penztarcaNevek = new String[penztarcaLista.size()];
        for (int i = 0; i < penztarcaNevek.length; i++) {
            penztarcaNevek[i] = penztarcaLista.get(i).getNev();
        }
        cbForrasBox.setModel(new DefaultComboBoxModel<>(penztarcaNevek));
        cbCelBox.setModel(new DefaultComboBoxModel<>(penztarcaNevek));
    }

    private void atvezetesAdatokBeallit() {
        forrasTarcaNev = cbForrasBox.getSelectedItem().toString();
        celTarcaNev = cbCelBox.getSelectedItem().toString();
        atvezetettOsszeg = Integer.parseInt(tfOsszeg.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbAtvezetesCim = new javax.swing.JLabel();
        lbForras = new javax.swing.JLabel();
        lbCel = new javax.swing.JLabel();
        lbOsszeg = new javax.swing.JLabel();
        cbForrasBox = new javax.swing.JComboBox<>();
        cbCelBox = new javax.swing.JComboBox<>();
        tfOsszeg = new javax.swing.JTextField();
        btOK = new javax.swing.JButton();
        btMegsem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Átvezetés");

        lbAtvezetesCim.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbAtvezetesCim.setText("Átvezetés");

        lbForras.setText("Forrás pénztárca");

        lbCel.setText("Cél pénztárca");

        lbOsszeg.setText("Összeg");

        cbForrasBox.setNextFocusableComponent(cbCelBox);

        cbCelBox.setNextFocusableComponent(tfOsszeg);

        tfOsszeg.setNextFocusableComponent(btOK);

        btOK.setText("OK");
        btOK.setNextFocusableComponent(btMegsem);
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        btMegsem.setText("Mégsem");
        btMegsem.setNextFocusableComponent(cbForrasBox);
        btMegsem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMegsemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbForras)
                            .addComponent(lbCel)
                            .addComponent(lbOsszeg))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbForrasBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbCelBox, 0, 120, Short.MAX_VALUE)
                            .addComponent(tfOsszeg)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbAtvezetesCim)
                        .addGap(27, 27, 27)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btMegsem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btOK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbAtvezetesCim, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbForras)
                    .addComponent(cbForrasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCel)
                    .addComponent(cbCelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOK))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbOsszeg)
                    .addComponent(tfOsszeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btMegsem))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        atvezetesAdatokBeallit();
        if (!forrasTarcaNev.equals(celTarcaNev)) {
            this.ok = true;
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(rootPane, "A forrás és cél pénztárca nem egyezhet meg!", "Hiba!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btOKActionPerformed

    private void btMegsemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMegsemActionPerformed
        this.ok = false;
        setVisible(false);
    }//GEN-LAST:event_btMegsemActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AtvezetesDialog dialog = new AtvezetesDialog(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> cbCelBox;
    private javax.swing.JComboBox<String> cbForrasBox;
    private javax.swing.JLabel lbAtvezetesCim;
    private javax.swing.JLabel lbCel;
    private javax.swing.JLabel lbForras;
    private javax.swing.JLabel lbOsszeg;
    private javax.swing.JTextField tfOsszeg;
    // End of variables declaration//GEN-END:variables
}
