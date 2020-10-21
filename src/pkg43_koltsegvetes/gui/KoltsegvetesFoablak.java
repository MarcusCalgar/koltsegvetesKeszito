package pkg43_koltsegvetes.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import pkg43_koltsegvetes.comparator.*;
import pkg43_koltsegvetes.dao.impl.*;
import pkg43_koltsegvetes.exception.KoltsegvetesException;
import pkg43_koltsegvetes.model.*;

public class KoltsegvetesFoablak extends javax.swing.JFrame {

    private Connection kapcsolat;
    private int penztarcaTablaOszlopSzam = 3;
    private int bevetelekTablaOszlopSzam = 4;
    private int kiadasokTablaOszlopSzam = 6;
    private PenztarcaDAO_JDBC penztarcaIrany;
    private BevetelDAO_JDBC bevetelIrany;
    private KiadasDAO_JDBC kiadasIrany;
    private List<Penztarca> penztarcakLista = new ArrayList<>();
    private List<Bevetel> bevetelekLista = new ArrayList<>();
    private List<Kiadas> kiadasokLista = new ArrayList<>();
    private Tranzakcio kijeloltTranzakcio;
    private DecimalFormat szamFormazo = new DecimalFormat("###,### Ft");

    public KoltsegvetesFoablak() {
        initComponents();
        try {
            kapcsolat = DriverManager.getConnection("jdbc:mysql://localhost:3306/koltsegvetes_test?useSSL=false", "root", "1234");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Adatbázis kapcsolat hiba!", JOptionPane.OK_OPTION);
        }
        try {
            penztarcaIrany = new PenztarcaDAO_JDBC(kapcsolat);
            penztarcakLista = penztarcaIrany.osszesBetolt();
            bevetelIrany = new BevetelDAO_JDBC(kapcsolat, penztarcakLista);
            bevetelekLista = bevetelIrany.osszesBetolt();
            kiadasIrany = new KiadasDAO_JDBC(kapcsolat, penztarcakLista);
            kiadasokLista = kiadasIrany.osszesBetolt();
        } catch (KoltsegvetesException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis kapcsolat hiba!", JOptionPane.OK_OPTION);
        }
        setBevetelTablaFejlecActionListener();
        tablazatokFeltolt();
        osszegzoMezokBeallit();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        lbPenztarcak = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        penztarcakTable = new javax.swing.JTable();
        lbFoablakCim = new javax.swing.JLabel();
        lbBevetelek = new javax.swing.JLabel();
        btUjBevetel = new javax.swing.JButton();
        btUjKiadas = new javax.swing.JButton();
        btModosit = new javax.swing.JButton();
        btTorol = new javax.swing.JButton();
        bevetelekTablaTarolo = new javax.swing.JScrollPane();
        bevetelekTabla = new javax.swing.JTable();
        kiadasokTablaTarolo = new javax.swing.JScrollPane();
        kiadasokTabla = new javax.swing.JTable();
        lbKiadasok = new javax.swing.JLabel();
        btKilepes = new javax.swing.JButton();
        btAtvezetes = new javax.swing.JButton();
        lbOsszesMegtakaritas = new javax.swing.JLabel();
        tfOsszesMegtakaritas = new javax.swing.JTextField();
        lbOsszesVagyon = new javax.swing.JLabel();
        tfOsszesVagyon = new javax.swing.JTextField();
        lbOsszesVagyon1 = new javax.swing.JLabel();
        tfOsszesPenz = new javax.swing.JTextField();
        lbOsszesSzepKartya = new javax.swing.JLabel();
        tfOsszesSzepKartya = new javax.swing.JTextField();
        lbOsszesBevetel = new javax.swing.JLabel();
        tfOsszesBevetel = new javax.swing.JTextField();
        lbOsszesKiadas = new javax.swing.JLabel();
        tfOsszesKiadas = new javax.swing.JTextField();
        lbOsszesRezsi = new javax.swing.JLabel();
        tfOsszesRezsi = new javax.swing.JTextField();
        lbOsszesElelmiszer = new javax.swing.JLabel();
        tfOsszesElelmiszer = new javax.swing.JTextField();
        lbOsszesEtkezes = new javax.swing.JLabel();
        tfOsszesEtkezes = new javax.swing.JTextField();
        lbOsszesKozlekedes = new javax.swing.JLabel();
        tfOsszesKozlekedes = new javax.swing.JTextField();
        lbOsszesEgeszseg = new javax.swing.JLabel();
        tfOsszesEgeszseg = new javax.swing.JTextField();
        lbOsszesEgyeb = new javax.swing.JLabel();
        tfOsszesEgyeb = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        penztarcaKezelesMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem5.setText("jMenuItem5");

        jMenuItem6.setText("jMenuItem6");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Családi Költségvetés Tervező");

        lbPenztarcak.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbPenztarcak.setText("Pénztárcák");

        penztarcakTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Név", "Típus", "Összeg"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(penztarcakTable);

        lbFoablakCim.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbFoablakCim.setText("Családi Költségvetés Tervező");

        lbBevetelek.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbBevetelek.setText("Bevételek");

        btUjBevetel.setText("Új bevétel");
        btUjBevetel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUjBevetelActionPerformed(evt);
            }
        });

        btUjKiadas.setText("Új kiadás");
        btUjKiadas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btUjKiadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUjKiadasActionPerformed(evt);
            }
        });

        btModosit.setText("Módosítás");
        btModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModositActionPerformed(evt);
            }
        });

        btTorol.setText("Törlés");
        btTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTorolActionPerformed(evt);
            }
        });

        bevetelekTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dátum", "Pénztárca", "Megnevezés", "Összeg"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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
        bevetelekTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bevetelekTablaMouseClicked(evt);
            }
        });
        bevetelekTablaTarolo.setViewportView(bevetelekTabla);

        kiadasokTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dátum", "Pénztárca", "Megnevezés", "Kategória", "Vásárlás helye", "Összeg"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        kiadasokTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kiadasokTablaMouseClicked(evt);
            }
        });
        kiadasokTablaTarolo.setViewportView(kiadasokTabla);

        lbKiadasok.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbKiadasok.setText("Kiadások");

        btKilepes.setText("Kilépés");
        btKilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKilepesActionPerformed(evt);
            }
        });

        btAtvezetes.setText("Átvezetés");
        btAtvezetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtvezetesActionPerformed(evt);
            }
        });

        lbOsszesMegtakaritas.setText("Összes Megtakarítás");
        lbOsszesMegtakaritas.setPreferredSize(new java.awt.Dimension(100, 15));

        tfOsszesMegtakaritas.setEditable(false);
        tfOsszesMegtakaritas.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesVagyon.setText("Összes Vagyon");
        lbOsszesVagyon.setPreferredSize(new java.awt.Dimension(100, 15));

        tfOsszesVagyon.setEditable(false);
        tfOsszesVagyon.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesVagyon1.setText("Összes Pénz");
        lbOsszesVagyon1.setPreferredSize(new java.awt.Dimension(100, 15));

        tfOsszesPenz.setEditable(false);
        tfOsszesPenz.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesSzepKartya.setText("Összes Szép Kártya");
        lbOsszesSzepKartya.setPreferredSize(new java.awt.Dimension(100, 15));

        tfOsszesSzepKartya.setEditable(false);
        tfOsszesSzepKartya.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesBevetel.setText("Összes bevétel");

        tfOsszesBevetel.setEditable(false);
        tfOsszesBevetel.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesKiadas.setText("Összes Kiadás");

        tfOsszesKiadas.setEditable(false);
        tfOsszesKiadas.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesRezsi.setText("Összes Rezsi");

        tfOsszesRezsi.setEditable(false);
        tfOsszesRezsi.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesElelmiszer.setText("Összes Élelmiszer");

        tfOsszesElelmiszer.setEditable(false);
        tfOsszesElelmiszer.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesEtkezes.setText("Összes Étkezés");

        tfOsszesEtkezes.setEditable(false);
        tfOsszesEtkezes.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesKozlekedes.setText("Összes Közlekedés");

        tfOsszesKozlekedes.setEditable(false);
        tfOsszesKozlekedes.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesEgeszseg.setText("Összes Egészség");

        tfOsszesEgeszseg.setEditable(false);
        tfOsszesEgeszseg.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesEgyeb.setText("Összes Egyéb");

        tfOsszesEgyeb.setEditable(false);
        tfOsszesEgyeb.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        jMenu1.setText("Pénztárcák");

        penztarcaKezelesMenuItem.setText("Kezelés");
        penztarcaKezelesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penztarcaKezelesMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(penztarcaKezelesMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Rendezések");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lbPenztarcak, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(219, 219, 219)
                        .addComponent(lbBevetelek)
                        .addGap(290, 290, 290)
                        .addComponent(lbKiadasok))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(lbFoablakCim)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbOsszesMegtakaritas, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                            .addComponent(lbOsszesVagyon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfOsszesPenz, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfOsszesMegtakaritas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bevetelekTablaTarolo, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbOsszesBevetel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(tfOsszesBevetel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 65, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbOsszesRezsi)
                                            .addComponent(lbOsszesEtkezes)
                                            .addComponent(lbOsszesEgeszseg))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfOsszesRezsi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfOsszesEtkezes, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfOsszesEgeszseg, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(81, 81, 81)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbOsszesKozlekedes)
                                            .addComponent(lbOsszesElelmiszer))
                                        .addGap(17, 17, 17)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfOsszesElelmiszer)
                                            .addComponent(tfOsszesKozlekedes)
                                            .addComponent(tfOsszesEgyeb, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)))
                                    .addComponent(kiadasokTablaTarolo, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lbOsszesEgyeb))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbOsszesKiadas)
                                                .addGap(18, 18, 18))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(lbOsszesVagyon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfOsszesVagyon, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addComponent(tfOsszesKiadas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(186, 186, 186)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btUjBevetel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btUjKiadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btModosit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btKilepes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btAtvezetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(btTorol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbOsszesSzepKartya, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfOsszesSzepKartya, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbFoablakCim)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbPenztarcak, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbBevetelek)
                    .addComponent(lbKiadasok))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btUjBevetel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btUjKiadas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btModosit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btAtvezetes, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btTorol, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbOsszesSzepKartya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfOsszesSzepKartya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btKilepes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbOsszesVagyon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfOsszesVagyon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(kiadasokTablaTarolo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                            .addComponent(bevetelekTablaTarolo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbOsszesMegtakaritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesMegtakaritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbOsszesBevetel)
                                    .addComponent(tfOsszesBevetel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbOsszesElelmiszer)
                                    .addComponent(tfOsszesElelmiszer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbOsszesVagyon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesPenz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(105, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbOsszesKozlekedes)
                                            .addComponent(tfOsszesKozlekedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbOsszesEgyeb)
                                            .addComponent(tfOsszesEgyeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbOsszesEgeszseg)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(tfOsszesRezsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbOsszesRezsi))
                                            .addGap(23, 23, 23)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(tfOsszesEtkezes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbOsszesEtkezes))
                                            .addGap(18, 18, 18)
                                            .addComponent(tfOsszesEgeszseg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbOsszesKiadas)
                                    .addComponent(tfOsszesKiadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void penztarcaKezelesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penztarcaKezelesMenuItemActionPerformed
        PenztarcaKezeloDialog penztarcaKezelo = new PenztarcaKezeloDialog(this, true, penztarcakLista, penztarcaIrany);
        penztarcaKezelo.setVisible(true);
        if (penztarcaKezelo.isOk()) {
            penztarcakLista = penztarcaKezelo.getPenztarcaLista();
            tablaFeltolt(penztarcakTable, penztarcakLista);
            osszegzoMezokBeallit();
        }
    }//GEN-LAST:event_penztarcaKezelesMenuItemActionPerformed

    private void btModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModositActionPerformed
        int kijeloltSorSzama;
        if (bevetelekTabla.getSelectedRow() != -1 || kiadasokTabla.getSelectedRow() != -1) {
            if (bevetelekTabla.getSelectedRow() != -1) {
                kijeloltSorSzama = bevetelekTabla.getSelectedRow();
                kijeloltTranzakcio = bevetelekLista.get(kijeloltSorSzama);
                UjModositBevetelDialog bevetelModosit = new UjModositBevetelDialog(this, kijeloltTranzakcio, penztarcakLista);
                bevetelModosit.setVisible(true);
                if (bevetelModosit.isOk()) {
                    bevetelekLista.remove(kijeloltSorSzama);
                    bevetelekLista.add(kijeloltSorSzama, bevetelModosit.getBevetel());
                    bevetelAdatbazisbaMent(bevetelModosit.getBevetel());
                    penztarcaOsszegModositasBevetelEseten(bevetelModosit.getBevetel());
                    penztarcaAdatbazisbaMent(kijeloltTranzakcio.getErintettPenztarca());
                    penztarcaAdatbazisbaMent(bevetelModosit.getBevetel().getErintettPenztarca());
                }
            } else if (kiadasokTabla.getSelectedRow() != -1) {
                kijeloltSorSzama = kiadasokTabla.getSelectedRow();
                kijeloltTranzakcio = kiadasokLista.get(kijeloltSorSzama);
                UjModositKiadasDialog kiadasModosit = new UjModositKiadasDialog(this, kijeloltTranzakcio, penztarcakLista);
                kiadasModosit.setVisible(true);
                if (kiadasModosit.isOk()) {
                    kiadasokLista.remove(kijeloltSorSzama);
                    kiadasokLista.add(kijeloltSorSzama, kiadasModosit.getKiadas());
                    kiadasAdatbazisbaMent(kiadasModosit.getKiadas());
                    penztarcaOsszegModositasKiadasEseten(kiadasModosit.getKiadas());
                    penztarcaAdatbazisbaMent(kijeloltTranzakcio.getErintettPenztarca());
                    penztarcaAdatbazisbaMent(kiadasModosit.getKiadas().getErintettPenztarca());
                }
            }
            tablazatokFeltolt();
            osszegzoMezokBeallit();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Előbb jelölj ki vagy egy bevételt, vagy kiadást!", "Módosítás hiba!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btModositActionPerformed

    private void btUjBevetelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUjBevetelActionPerformed
        UjModositBevetelDialog ujBevetel = new UjModositBevetelDialog(this, true, penztarcakLista);
        ujBevetel.setVisible(true);
        if (ujBevetel.isOk()) {
            bevetelekLista.add(ujBevetel.getBevetel());
            bevetelHozzaadasaPenztarcahoz(ujBevetel.getBevetel());
            tablaFeltolt(bevetelekTabla, bevetelekLista);
            tablaFeltolt(penztarcakTable, penztarcakLista);
            bevetelAdatbazisbaMent(ujBevetel.getBevetel());
            penztarcaAdatbazisbaMent(ujBevetel.getBevetel().getErintettPenztarca());
            try {
                bevetelekLista = bevetelIrany.osszesBetolt();
            } catch (KoltsegvetesException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis kapcsolat hiba!", JOptionPane.OK_OPTION);
            }
            osszesBevetelMezoBeallit();
        }
    }//GEN-LAST:event_btUjBevetelActionPerformed

    private void btUjKiadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUjKiadasActionPerformed
        UjModositKiadasDialog ujKiadas = new UjModositKiadasDialog(this, true, penztarcakLista);
        ujKiadas.setVisible(true);
        if (ujKiadas.isOk()) {
            kiadasokLista.add(ujKiadas.getKiadas());
            kiadasLevonasaPenztarcabol(ujKiadas.getKiadas());
            tablaFeltolt(kiadasokTabla, kiadasokLista);
            tablaFeltolt(penztarcakTable, penztarcakLista);
            kiadasAdatbazisbaMent(ujKiadas.getKiadas());
            penztarcaAdatbazisbaMent(ujKiadas.getKiadas().getErintettPenztarca());
            try {
                kiadasokLista = kiadasIrany.osszesBetolt();
            } catch (KoltsegvetesException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Adatbázis kapcsolat hiba!", JOptionPane.OK_OPTION);
            }
            osszegzoMezokBeallit();
        }
    }//GEN-LAST:event_btUjKiadasActionPerformed

    private void btKilepesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKilepesActionPerformed
        try {
            penztarcaIrany.lezar();
            bevetelIrany.lezar();
            kiadasIrany.lezar();
            kapcsolat.close();
            System.exit(0);
        } catch (SQLException | KoltsegvetesException e) {
            System.err.println("Hiba történt az adatbáziskapcsolatban! Üzenet: " + e.getMessage());
        }
    }//GEN-LAST:event_btKilepesActionPerformed

    private void btTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTorolActionPerformed
        int kijeloltSorSzama;
        if (bevetelekTabla.getSelectedRow() != -1 || kiadasokTabla.getSelectedRow() != -1) {
            if (bevetelekTabla.getSelectedRow() != -1) {
                kijeloltSorSzama = bevetelekTabla.getSelectedRow();
                kijeloltTranzakcio = bevetelekLista.get(kijeloltSorSzama);
                if (JOptionPane.showConfirmDialog(rootPane, "Biztosan törölni szeretnéd a kiválasztott bevételt?", "Törlés megerősítése", JOptionPane.YES_NO_OPTION) == 0) {
                    penztarcaOsszegModositasBevetelTorlesEseten((Bevetel) kijeloltTranzakcio);
                    bevetelekLista.remove(bevetelekTabla.getSelectedRow());
                    try {
                        bevetelIrany.torol(kijeloltTranzakcio.getId());
                    } catch (KoltsegvetesException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Sajnos nem sikerült törölni a kijelölt tételt!", "Törlés hiba!", JOptionPane.OK_OPTION);
                    }
                    penztarcaAdatbazisbaMent(kijeloltTranzakcio.getErintettPenztarca());
                }
            } else if (kiadasokTabla.getSelectedRow() != -1) {
                kijeloltSorSzama = kiadasokTabla.getSelectedRow();
                kijeloltTranzakcio = kiadasokLista.get(kijeloltSorSzama);
                if (JOptionPane.showConfirmDialog(rootPane, "Biztosan törölni szeretnéd a kiválasztott kiadást?", "Törlés megerősítése", JOptionPane.YES_NO_OPTION) == 0) {
                    penztarcaOsszegModositasKiadasTorlesEseten((Kiadas) kijeloltTranzakcio);
                    kiadasokLista.remove(kiadasokTabla.getSelectedRow());
                    try {
                        kiadasIrany.torol(kijeloltTranzakcio.getId());
                    } catch (KoltsegvetesException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Sajnos nem sikerült törölni a kijelölt tételt!", "Törlés hiba!", JOptionPane.OK_OPTION);
                    }
                    penztarcaAdatbazisbaMent(kijeloltTranzakcio.getErintettPenztarca());
                }
            }
            tablazatokFeltolt();
            osszegzoMezokBeallit();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Előbb jelölj ki vagy egy bevételt, vagy kiadást!", "Törlés hiba!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btTorolActionPerformed

    private void btAtvezetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtvezetesActionPerformed
        AtvezetesDialog atvezetes = new AtvezetesDialog(this, true, penztarcakLista);
        atvezetes.setVisible(true);
        if (atvezetes.isOk()) {
            atvezetesVegrehajt(atvezetes);
            tablaFeltolt(penztarcakTable, penztarcakLista);
            penztarcaAdatbazisbaMent(penztarcaKeres(atvezetes.getForrasTarcaNev()));
            penztarcaAdatbazisbaMent(penztarcaKeres(atvezetes.getCelTarcaNev()));
        }
    }//GEN-LAST:event_btAtvezetesActionPerformed

    private void bevetelekTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bevetelekTablaMouseClicked
        kiadasokTabla.clearSelection();
    }//GEN-LAST:event_bevetelekTablaMouseClicked

    private void kiadasokTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kiadasokTablaMouseClicked
        bevetelekTabla.clearSelection();
    }//GEN-LAST:event_kiadasokTablaMouseClicked

    private void tablazatokFeltolt() {
        tablaFeltolt(kiadasokTabla, kiadasokLista);
        tablaFeltolt(bevetelekTabla, bevetelekLista);
        tablaFeltolt(penztarcakTable, penztarcakLista);
    }

    private void osszegzoMezokBeallit() {
        osszesMegtakaritasBeallit();
        osszesPenzBeallit();
        osszesSzepKartyaBeallit();
        osszesVagyonBeallit();
        osszesBevetelMezoBeallit();
        osszesKiadasTipusMezokBeallit();
    }

    //Action listener a bevételek táblához
    private void setBevetelTablaFejlecActionListener() {
        bevetelekTabla.getTableHeader().addMouseListener(new MouseAdapter() {
            DatumComparator datumComp = new DatumComparator();
            PenztarcaComparator tarcaComp = new PenztarcaComparator();
            MegnevezesComparator megnevezesComp = new MegnevezesComparator();
            OsszegComparator osszegComp = new OsszegComparator();

            @Override
            public void mouseClicked(MouseEvent e) {
                int oszlopSzama = bevetelekTabla.columnAtPoint(e.getPoint());
                switch (oszlopSzama) {
                    case 0:
                        bevetelekLista.sort(datumComp);
                        datumComp.setForditott(!datumComp.getForditott());
                        break;
                    case 1:
                        bevetelekLista.sort(tarcaComp);
                        tarcaComp.setForditott(!tarcaComp.getForditott());
                        break;
                    case 2:
                        bevetelekLista.sort(megnevezesComp);
                        megnevezesComp.setForditott(!megnevezesComp.getForditott());
                        break;
                    case 3:
                        bevetelekLista.sort(osszegComp);
                        osszegComp.setForditott(!osszegComp.getForditott());
                        break;
                    default:
                        break;
                }
                tablaFeltolt(bevetelekTabla, bevetelekLista);
            }
        });
    }

    private void osszesKiadasTipusMezokBeallit() {
        int rezsiOsszeg = 0, elelmiszerOsszeg = 0, etkezesOsszeg = 0, kozlekedesOsszeg = 0, egeszsegOsszeg = 0, egyebOsszeg = 0;
        for (Kiadas kiadas : kiadasokLista) {
            switch (kiadas.getKategoria()) {
                case "Rezsi":
                    rezsiOsszeg += kiadas.getOsszeg();
                    break;
                case "Élelmiszer":
                    elelmiszerOsszeg += kiadas.getOsszeg();
                    break;
                case "Étkezés":
                    etkezesOsszeg += kiadas.getOsszeg();
                    break;
                case "Közlekedés":
                    kozlekedesOsszeg += kiadas.getOsszeg();
                    break;
                case "Egészség":
                    egeszsegOsszeg += kiadas.getOsszeg();
                    break;
                case "Egyéb":
                    egyebOsszeg += kiadas.getOsszeg();
                    break;
                default:
                    break;
            }
        }
        mezoBeallit(tfOsszesRezsi, rezsiOsszeg);
        mezoBeallit(tfOsszesElelmiszer, elelmiszerOsszeg);
        mezoBeallit(tfOsszesEtkezes, etkezesOsszeg);
        mezoBeallit(tfOsszesKozlekedes, kozlekedesOsszeg);
        mezoBeallit(tfOsszesEgeszseg, egeszsegOsszeg);
        mezoBeallit(tfOsszesEgyeb, egyebOsszeg);
        mezoBeallit(tfOsszesKiadas, rezsiOsszeg
                + elelmiszerOsszeg
                + etkezesOsszeg
                + kozlekedesOsszeg
                + egeszsegOsszeg
                + egyebOsszeg);
    }

    private void osszesBevetelMezoBeallit() {
        int osszeg = 0;
        for (Bevetel bevetel : bevetelekLista) {
            osszeg += bevetel.getOsszeg();
        }
        mezoBeallit(tfOsszesBevetel, osszeg);
    }

    private void osszesMegtakaritasBeallit() {
        int osszeg = 0;
        for (Penztarca tarca : penztarcakLista) {
            if ("Megtakarítási számla".equals(tarca.getTipus())) {
                osszeg += tarca.getOsszeg();
            }
        }
        mezoBeallit(tfOsszesMegtakaritas, osszeg);
    }

    // Az érték azért tér vissza, mert az osszesVagyonBeallit() - nak kell.
    private int osszesPenzBeallit() {
        int osszeg = 0;
        for (Penztarca tarca : penztarcakLista) {
            if ("Készpénz".equals(tarca.getTipus()) || "Bankkártya".equals(tarca.getTipus())) {
                osszeg += tarca.getOsszeg();
            }
        }
        mezoBeallit(tfOsszesPenz, osszeg);
        return osszeg;
    }

    // Az érték azért tér vissza, mert az osszesVagyonBeallit() - nak kell.
    private int osszesSzepKartyaBeallit() {
        int osszeg = 0;
        for (Penztarca tarca : penztarcakLista) {
            if (tarca.getTipus().contains("zseb")) {
                osszeg += tarca.getOsszeg();
            }
        }
        mezoBeallit(tfOsszesSzepKartya, osszeg);
        return osszeg;
    }

    // Ez a metódus használja az összes pénzt és szép kártyát kalkuláló metódust, azok ezért adják vissza az értéküket.
    private void osszesVagyonBeallit() {
        mezoBeallit(tfOsszesVagyon, osszesPenzBeallit() + osszesSzepKartyaBeallit());
    }

    private void mezoBeallit(JTextField tf, int osszeg) {
        tf.setText(szamFormazo.format(osszeg) + "");
    }

    private void penztarcaAdatbazisbaMent(Penztarca penztarca) {
        try {
            penztarcaIrany.elment(penztarca);
        } catch (KoltsegvetesException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Hiba a pénztárcák mentése közben!", JOptionPane.OK_OPTION);
        }
    }

    private void bevetelAdatbazisbaMent(Bevetel bevetel) {
        try {
            bevetelIrany.elment(bevetel);
        } catch (KoltsegvetesException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Hiba a bevételek mentése közben!", JOptionPane.OK_OPTION);
        }
    }

    private void kiadasAdatbazisbaMent(Kiadas kiadas) {
        try {
            kiadasIrany.elment(kiadas);
        } catch (KoltsegvetesException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Hiba a kiadások mentése közben!", JOptionPane.OK_OPTION);
        }
    }

    private void atvezetesVegrehajt(AtvezetesDialog atvezetes) {
        penztarcaKeres(atvezetes.getForrasTarcaNev()).setOsszeg(penztarcaKeres(atvezetes.getForrasTarcaNev()).getOsszeg() - atvezetes.getAtvezetettOsszeg());
        penztarcaKeres(atvezetes.getCelTarcaNev()).setOsszeg(penztarcaKeres(atvezetes.getCelTarcaNev()).getOsszeg() + atvezetes.getAtvezetettOsszeg());
    }

    private void penztarcaOsszegModositasKiadasEseten(Kiadas modositottKiadas) {
        Kiadas eredetiKiadas = (Kiadas) kijeloltTranzakcio;
        for (Penztarca tarca : penztarcakLista) {
            if (tarca.getNev().equals(eredetiKiadas.getErintettPenztarca().getNev())) {
                tarca.setOsszeg(tarca.getOsszeg() + eredetiKiadas.getOsszeg());
            }
            if (tarca.getNev().equals(modositottKiadas.getErintettPenztarca().getNev())) {
                tarca.setOsszeg(tarca.getOsszeg() - modositottKiadas.getOsszeg());
            }
        }
    }

    private void kiadasLevonasaPenztarcabol(Kiadas kiadas) {
        for (Penztarca tarca : penztarcakLista) {
            if (tarca.getNev().equals(kiadas.getErintettPenztarca().getNev())) {
                tarca.setOsszeg(tarca.getOsszeg() - kiadas.getOsszeg());
            }
        }
    }

    private void penztarcaOsszegModositasKiadasTorlesEseten(Kiadas toroltKiadas) {
        for (Penztarca tarca : penztarcakLista) {
            if (tarca.getNev().equals(toroltKiadas.getErintettPenztarca().getNev())) {
                tarca.setOsszeg(tarca.getOsszeg() + toroltKiadas.getOsszeg());
            }
        }
    }

    private void penztarcaOsszegModositasBevetelEseten(Bevetel modositottBevetel) {
        Bevetel eredetiBevetel = (Bevetel) kijeloltTranzakcio;
        for (Penztarca tarca : penztarcakLista) {
            if (tarca.getNev().equals(eredetiBevetel.getErintettPenztarca().getNev())) {
                tarca.setOsszeg(tarca.getOsszeg() - eredetiBevetel.getOsszeg());
            }
            if (tarca.getNev().equals(modositottBevetel.getErintettPenztarca().getNev())) {
                tarca.setOsszeg(tarca.getOsszeg() + modositottBevetel.getOsszeg());
            }
        }
    }

    private void penztarcaOsszegModositasBevetelTorlesEseten(Bevetel toroltBevetel) {
        for (Penztarca tarca : penztarcakLista) {
            if (tarca.getNev().equals(toroltBevetel.getErintettPenztarca().getNev())) {
                tarca.setOsszeg(tarca.getOsszeg() - toroltBevetel.getOsszeg());
            }
        }
    }

    private void bevetelHozzaadasaPenztarcahoz(Bevetel bevetel) {
        for (Penztarca tarca : penztarcakLista) {
            if (tarca.getNev().equals(bevetel.getErintettPenztarca().getNev())) {
                tarca.setOsszeg(tarca.getOsszeg() + bevetel.getOsszeg());
            }
        }
    }

    private Object[] sorKeszit(Object elem) {
        if (elem instanceof Penztarca) {
            Object[] ujSor = new Object[penztarcaTablaOszlopSzam];
            Penztarca tarca = (Penztarca) elem;
            ujSor[0] = tarca.getNev();
            ujSor[1] = tarca.getTipus();
            ujSor[2] = szamFormazo.format(tarca.getOsszeg());
            return ujSor;
        } else if (elem instanceof Bevetel) {
            Object[] ujSor = new Object[bevetelekTablaOszlopSzam];
            Bevetel bevetel = (Bevetel) elem;
            ujSor[0] = bevetel.getDatum();
            ujSor[1] = bevetel.getErintettPenztarca().getNev();
            ujSor[2] = bevetel.getMegnevezes();
            ujSor[3] = bevetel.getOsszeg();
            return ujSor;
        } else {
            Object[] ujSor = new Object[kiadasokTablaOszlopSzam];
            Kiadas kiadas = (Kiadas) elem;
            ujSor[0] = kiadas.getDatum();
            ujSor[1] = kiadas.getErintettPenztarca().getNev();
            ujSor[2] = kiadas.getMegnevezes();
            ujSor[3] = kiadas.getKategoria();
            ujSor[4] = kiadas.getKiadasHely();
            ujSor[5] = kiadas.getOsszeg();
            return ujSor;
        }
    }

    private void tablaFeltolt(JTable tabla, List<? extends Object> lista) {
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

    private Penztarca penztarcaKeres(String nev) {
        for (Penztarca tarca : penztarcakLista) {
            if (tarca.getNev().equals(nev)) {
                return tarca;
            }
        }
        return null;
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
            java.util.logging.Logger.getLogger(KoltsegvetesFoablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KoltsegvetesFoablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KoltsegvetesFoablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KoltsegvetesFoablak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KoltsegvetesFoablak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bevetelekTabla;
    private javax.swing.JScrollPane bevetelekTablaTarolo;
    private javax.swing.JButton btAtvezetes;
    private javax.swing.JButton btKilepes;
    private javax.swing.JButton btModosit;
    private javax.swing.JButton btTorol;
    private javax.swing.JButton btUjBevetel;
    private javax.swing.JButton btUjKiadas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable kiadasokTabla;
    private javax.swing.JScrollPane kiadasokTablaTarolo;
    private javax.swing.JLabel lbBevetelek;
    private javax.swing.JLabel lbFoablakCim;
    private javax.swing.JLabel lbKiadasok;
    private javax.swing.JLabel lbOsszesBevetel;
    private javax.swing.JLabel lbOsszesEgeszseg;
    private javax.swing.JLabel lbOsszesEgyeb;
    private javax.swing.JLabel lbOsszesElelmiszer;
    private javax.swing.JLabel lbOsszesEtkezes;
    private javax.swing.JLabel lbOsszesKiadas;
    private javax.swing.JLabel lbOsszesKozlekedes;
    private javax.swing.JLabel lbOsszesMegtakaritas;
    private javax.swing.JLabel lbOsszesRezsi;
    private javax.swing.JLabel lbOsszesSzepKartya;
    private javax.swing.JLabel lbOsszesVagyon;
    private javax.swing.JLabel lbOsszesVagyon1;
    private javax.swing.JLabel lbPenztarcak;
    private javax.swing.JMenuItem penztarcaKezelesMenuItem;
    private javax.swing.JTable penztarcakTable;
    private javax.swing.JTextField tfOsszesBevetel;
    private javax.swing.JTextField tfOsszesEgeszseg;
    private javax.swing.JTextField tfOsszesEgyeb;
    private javax.swing.JTextField tfOsszesElelmiszer;
    private javax.swing.JTextField tfOsszesEtkezes;
    private javax.swing.JTextField tfOsszesKiadas;
    private javax.swing.JTextField tfOsszesKozlekedes;
    private javax.swing.JTextField tfOsszesMegtakaritas;
    private javax.swing.JTextField tfOsszesPenz;
    private javax.swing.JTextField tfOsszesRezsi;
    private javax.swing.JTextField tfOsszesSzepKartya;
    private javax.swing.JTextField tfOsszesVagyon;
    // End of variables declaration//GEN-END:variables
}
