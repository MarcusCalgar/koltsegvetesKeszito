package pkg43_koltsegvetes.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import pkg43_filter.*;
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
    private List<Bevetel> megszurtBevetelLista = new ArrayList<>();
    private List<Kiadas> kiadasokLista = new ArrayList<>();
    private List<Kiadas> megszurtKiadasokLista = new ArrayList<>();
    private Tranzakcio kijeloltTranzakcio;
    private DecimalFormat szamFormazo = new DecimalFormat("###,### Ft");
    private Month mutatandoHonap = LocalDate.now().getMonth();
    private Comparator aktualisKiadasRendezes;
    
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
        this.getContentPane().setBackground(new Color(212, 232, 255));
        szuresBeallit();
        tablazatFejlecMutatoBeallit();
        tablazatRendezesiLehetosegekBeallit();
        tablazatokFeltolt();
        osszegzoMezokBeallit();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        lbPenztarcak = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        penztarcakTabla = new javax.swing.JTable();
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
        tfOsszesEtkezes = new javax.swing.JTextField();
        lbOsszesKozlekedes = new javax.swing.JLabel();
        tfOsszesKozlekedes = new javax.swing.JTextField();
        lbOsszesEgeszseg = new javax.swing.JLabel();
        tfOsszesEgeszseg = new javax.swing.JTextField();
        lbOsszesEgyeb = new javax.swing.JLabel();
        tfOsszesEgyeb = new javax.swing.JTextField();
        lbOsszesEtkezes = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        penztarcaKezelesMenuItem = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        miJanuar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        miFebruar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        miMarcius = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        miAprilis = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        miMajus = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        miJunius = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        miJulius = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        miAugusztus = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        miSzeptember = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        miOktober = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        miNovember = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        miDecember = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Családi Költségvetés Tervező");

        lbPenztarcak.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbPenztarcak.setText("Pénztárcák");

        penztarcakTabla.setBackground(new java.awt.Color(255, 255, 204));
        penztarcakTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        penztarcakTabla.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(penztarcakTabla);

        lbFoablakCim.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        lbFoablakCim.setText("Családi Költségvetés Tervező");

        lbBevetelek.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbBevetelek.setText("Bevételek");

        btUjBevetel.setText("Új bevétel");
        btUjBevetel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUjBevetel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUjBevetelActionPerformed(evt);
            }
        });

        btUjKiadas.setText("Új kiadás");
        btUjKiadas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btUjKiadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btUjKiadasActionPerformed(evt);
            }
        });

        btModosit.setText("Módosítás");
        btModosit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btModosit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModositActionPerformed(evt);
            }
        });

        btTorol.setText("Törlés");
        btTorol.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTorolActionPerformed(evt);
            }
        });

        bevetelekTabla.setBackground(new java.awt.Color(255, 255, 204));
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

        kiadasokTabla.setBackground(new java.awt.Color(255, 255, 204));
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

        lbKiadasok.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbKiadasok.setText("Kiadások");

        btKilepes.setText("Kilépés");
        btKilepes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btKilepes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKilepesActionPerformed(evt);
            }
        });

        btAtvezetes.setText("Átvezetés");
        btAtvezetes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        tfOsszesEtkezes.setEditable(false);
        tfOsszesEtkezes.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesKozlekedes.setText("Összes Közlekedés");

        tfOsszesKozlekedes.setEditable(false);
        tfOsszesKozlekedes.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesEgeszseg.setText("Összes Egészség");

        tfOsszesEgeszseg.setEditable(false);
        tfOsszesEgeszseg.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesEgyeb.setText("Összes Egyéb Kat.");

        tfOsszesEgyeb.setEditable(false);
        tfOsszesEgyeb.setHorizontalAlignment(javax.swing.JTextField.TRAILING);

        lbOsszesEtkezes.setText("Összes Étkezés");

        jMenu1.setText("Pénztárcák");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        penztarcaKezelesMenuItem.setText("Kezelés");
        penztarcaKezelesMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penztarcaKezelesMenuItemActionPerformed(evt);
            }
        });
        jMenu1.add(penztarcaKezelesMenuItem);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Nézet");

        jMenu4.setText("Hónap");

        miJanuar.setText("Január");
        miJanuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miJanuarActionPerformed(evt);
            }
        });
        jMenu4.add(miJanuar);
        jMenu4.add(jSeparator2);

        miFebruar.setText("Február");
        miFebruar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miFebruarActionPerformed(evt);
            }
        });
        jMenu4.add(miFebruar);
        jMenu4.add(jSeparator1);

        miMarcius.setText("Március");
        miMarcius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMarciusActionPerformed(evt);
            }
        });
        jMenu4.add(miMarcius);
        jMenu4.add(jSeparator3);

        miAprilis.setText("Április");
        miAprilis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAprilisActionPerformed(evt);
            }
        });
        jMenu4.add(miAprilis);
        jMenu4.add(jSeparator4);

        miMajus.setText("Május");
        miMajus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miMajusActionPerformed(evt);
            }
        });
        jMenu4.add(miMajus);
        jMenu4.add(jSeparator5);

        miJunius.setText("Június");
        miJunius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miJuniusActionPerformed(evt);
            }
        });
        jMenu4.add(miJunius);
        jMenu4.add(jSeparator6);

        miJulius.setText("Július");
        miJulius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miJuliusActionPerformed(evt);
            }
        });
        jMenu4.add(miJulius);
        jMenu4.add(jSeparator7);

        miAugusztus.setText("Augusztus");
        miAugusztus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAugusztusActionPerformed(evt);
            }
        });
        jMenu4.add(miAugusztus);
        jMenu4.add(jSeparator8);

        miSzeptember.setText("Szeptember");
        miSzeptember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSzeptemberActionPerformed(evt);
            }
        });
        jMenu4.add(miSzeptember);
        jMenu4.add(jSeparator9);

        miOktober.setText("Október");
        miOktober.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miOktoberActionPerformed(evt);
            }
        });
        jMenu4.add(miOktober);
        jMenu4.add(jSeparator10);

        miNovember.setText("November");
        miNovember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miNovemberActionPerformed(evt);
            }
        });
        jMenu4.add(miNovember);
        jMenu4.add(jSeparator11);

        miDecember.setText("December");
        miDecember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDecemberActionPerformed(evt);
            }
        });
        jMenu4.add(miDecember);

        jMenu2.add(jMenu4);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bevetelekTablaTarolo, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbOsszesSzepKartya, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbOsszesMegtakaritas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbOsszesVagyon1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfOsszesPenz, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesMegtakaritas, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesSzepKartya, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(93, 93, 93)
                                .addComponent(lbOsszesBevetel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfOsszesBevetel, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbOsszesRezsi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbOsszesEgeszseg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbOsszesEtkezes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfOsszesEtkezes, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesRezsi, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesEgeszseg, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbOsszesEgyeb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbOsszesKozlekedes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbOsszesElelmiszer, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfOsszesKozlekedes)
                                    .addComponent(tfOsszesElelmiszer)
                                    .addComponent(tfOsszesEgyeb)))
                            .addComponent(kiadasokTablaTarolo, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbOsszesVagyon, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfOsszesVagyon, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbOsszesKiadas)
                        .addGap(18, 18, 18)
                        .addComponent(tfOsszesKiadas, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(148, 148, 148)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btUjBevetel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btUjKiadas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btModosit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btKilepes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btAtvezetes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btTorol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(lbPenztarcak)
                .addGap(223, 223, 223)
                .addComponent(lbBevetelek)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbKiadasok)
                .addGap(354, 354, 354))
            .addGroup(layout.createSequentialGroup()
                .addGap(510, 510, 510)
                .addComponent(lbFoablakCim)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                            .addComponent(bevetelekTablaTarolo)
                            .addComponent(kiadasokTablaTarolo))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbOsszesMegtakaritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesMegtakaritas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbOsszesBevetel)
                                    .addComponent(tfOsszesBevetel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbOsszesSzepKartya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesSzepKartya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbOsszesVagyon1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesPenz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbOsszesVagyon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfOsszesVagyon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfOsszesRezsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbOsszesRezsi)
                                    .addComponent(lbOsszesElelmiszer)
                                    .addComponent(tfOsszesElelmiszer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfOsszesEtkezes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbOsszesKozlekedes)
                                    .addComponent(tfOsszesKozlekedes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbOsszesEtkezes))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbOsszesEgeszseg)
                                    .addComponent(tfOsszesEgeszseg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbOsszesEgyeb)
                                    .addComponent(tfOsszesEgyeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbOsszesKiadas)
                                    .addComponent(tfOsszesKiadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btKilepes, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void penztarcaKezelesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penztarcaKezelesMenuItemActionPerformed
        PenztarcaKezeloDialog penztarcaKezelo = new PenztarcaKezeloDialog(this, true, penztarcakLista, penztarcaIrany);
        penztarcaKezelo.setVisible(true);
        if (penztarcaKezelo.isOk()) {
            penztarcakLista = penztarcaKezelo.getPenztarcaLista();
            tablaFeltolt(penztarcakTabla, penztarcakLista);
            osszegzoMezokBeallit();
        }
    }//GEN-LAST:event_penztarcaKezelesMenuItemActionPerformed

    private void btModositActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModositActionPerformed
        int kijeloltSorSzama;
        if (bevetelekTabla.getSelectedRow() != -1 || kiadasokTabla.getSelectedRow() != -1) {
            if (bevetelekTabla.getSelectedRow() != -1) {
                kijeloltSorSzama = bevetelekTabla.getSelectedRow();
                kijeloltTranzakcio = megszurtBevetelLista.get(kijeloltSorSzama);
                UjModositBevetelDialog bevetelModosit = new UjModositBevetelDialog(this, kijeloltTranzakcio, penztarcakLista, megszurtBevetelLista);
                bevetelModosit.setVisible(true);
                if (bevetelModosit.isOk()) {
                    megszurtBevetelLista.removeIf(new tesztIdAlapjan(kijeloltTranzakcio.getId()));
                    bevetelekLista.removeIf(new tesztIdAlapjan(kijeloltTranzakcio.getId()));
                    bevetelekLista.add(kijeloltSorSzama, bevetelModosit.getBevetel());
                    megszurtBevetelLista.add(kijeloltSorSzama, bevetelModosit.getBevetel());
                    bevetelAdatbazisbaMent(bevetelModosit.getBevetel());
                    penztarcaOsszegModositasBevetelEseten(bevetelModosit.getBevetel());
                    penztarcaAdatbazisbaMent(kijeloltTranzakcio.getErintettPenztarca());
                    penztarcaAdatbazisbaMent(bevetelModosit.getBevetel().getErintettPenztarca());
                }
            } else if (kiadasokTabla.getSelectedRow() != -1) {
                kijeloltSorSzama = kiadasokTabla.getSelectedRow();
                kijeloltTranzakcio = megszurtKiadasokLista.get(kijeloltSorSzama);
                UjModositKiadasDialog kiadasModosit = new UjModositKiadasDialog(this, kijeloltTranzakcio, penztarcakLista, megszurtKiadasokLista);
                kiadasModosit.setVisible(true);
                if (kiadasModosit.isOk()) {
                    megszurtKiadasokLista.removeIf(new tesztIdAlapjan(kijeloltTranzakcio.getId()));
                    kiadasokLista.removeIf(new tesztIdAlapjan(kijeloltTranzakcio.getId()));
                    kiadasokLista.add(kijeloltTranzakcio.getId(), kiadasModosit.getKiadas());
                    megszurtKiadasokLista.add(kijeloltTranzakcio.getId(), kiadasModosit.getKiadas());
                    kiadasAdatbazisbaMent(kiadasModosit.getKiadas());
                    penztarcaOsszegModositasKiadasEseten(kiadasModosit.getKiadas());
                    penztarcaAdatbazisbaMent(kijeloltTranzakcio.getErintettPenztarca());
                    penztarcaAdatbazisbaMent(kiadasModosit.getKiadas().getErintettPenztarca());
                    kiadasokAktualisRendezesBeallit();
                }
            }
            tablazatokFeltolt();
            osszegzoMezokBeallit();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Előbb jelölj ki vagy egy bevételt, vagy kiadást!", "Módosítás hiba!", JOptionPane.OK_OPTION);
        }
    }//GEN-LAST:event_btModositActionPerformed

    private void btUjBevetelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btUjBevetelActionPerformed
        UjModositBevetelDialog ujBevetel = new UjModositBevetelDialog(this, true, penztarcakLista, bevetelekLista);
        ujBevetel.setVisible(true);
        if (ujBevetel.isOk()) {
            bevetelekLista.add(ujBevetel.getBevetel());
            szuresBeallit();
            bevetelHozzaadasaPenztarcahoz(ujBevetel.getBevetel());
            tablaFeltolt(bevetelekTabla, megszurtBevetelLista);
            tablaFeltolt(penztarcakTabla, penztarcakLista);
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
        UjModositKiadasDialog ujKiadas = new UjModositKiadasDialog(this, true, penztarcakLista, kiadasokLista);
        ujKiadas.setVisible(true);
        if (ujKiadas.isOk()) {
            kiadasokLista.add(ujKiadas.getKiadas());
            szuresBeallit();
            kiadasokAktualisRendezesBeallit();
            kiadasLevonasaPenztarcabol(ujKiadas.getKiadas());
            tablaFeltolt(kiadasokTabla, megszurtKiadasokLista);
            tablaFeltolt(penztarcakTabla, penztarcakLista);
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
                    megszurtBevetelLista.removeIf(new tesztIdAlapjan(kijeloltTranzakcio.getId()));
                    bevetelekLista.removeIf(new tesztIdAlapjan(kijeloltTranzakcio.getId()));
                    try {
                        bevetelIrany.torol(kijeloltTranzakcio.getId());
                    } catch (KoltsegvetesException ex) {
                        JOptionPane.showMessageDialog(rootPane, "Sajnos nem sikerült törölni a kijelölt tételt!", "Törlés hiba!", JOptionPane.OK_OPTION);
                    }
                    penztarcaAdatbazisbaMent(kijeloltTranzakcio.getErintettPenztarca());
                }
            } else if (kiadasokTabla.getSelectedRow() != -1) {
                kijeloltSorSzama = kiadasokTabla.getSelectedRow();
                kijeloltTranzakcio = megszurtKiadasokLista.get(kijeloltSorSzama);
                if (JOptionPane.showConfirmDialog(rootPane, "Biztosan törölni szeretnéd a kiválasztott kiadást?", "Törlés megerősítése", JOptionPane.YES_NO_OPTION) == 0) {
                    penztarcaOsszegModositasKiadasTorlesEseten((Kiadas) kijeloltTranzakcio);
                    megszurtKiadasokLista.removeIf(new tesztIdAlapjan(kijeloltTranzakcio.getId()));
                    kiadasokLista.removeIf(new tesztIdAlapjan(kijeloltTranzakcio.getId()));
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
            tablaFeltolt(penztarcakTabla, penztarcakLista);
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

    private void miJanuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miJanuarActionPerformed
        mutatandoHonap = Month.JANUARY;
        mutatottHonapValt();
        
    }//GEN-LAST:event_miJanuarActionPerformed

    private void miFebruarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miFebruarActionPerformed
        mutatandoHonap = Month.FEBRUARY;
        mutatottHonapValt();
    }//GEN-LAST:event_miFebruarActionPerformed

    private void miMarciusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMarciusActionPerformed
        mutatandoHonap = Month.MARCH;
        mutatottHonapValt();
    }//GEN-LAST:event_miMarciusActionPerformed

    private void miAprilisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAprilisActionPerformed
        mutatandoHonap = Month.APRIL;
        mutatottHonapValt();
    }//GEN-LAST:event_miAprilisActionPerformed

    private void miMajusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miMajusActionPerformed
        mutatandoHonap = Month.MAY;
        mutatottHonapValt();
    }//GEN-LAST:event_miMajusActionPerformed

    private void miJuniusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miJuniusActionPerformed
        mutatandoHonap = Month.JUNE;
        mutatottHonapValt();
    }//GEN-LAST:event_miJuniusActionPerformed

    private void miJuliusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miJuliusActionPerformed
        mutatandoHonap = Month.JULY;
        mutatottHonapValt();
    }//GEN-LAST:event_miJuliusActionPerformed

    private void miAugusztusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAugusztusActionPerformed
        mutatandoHonap = Month.AUGUST;
        mutatottHonapValt();
    }//GEN-LAST:event_miAugusztusActionPerformed

    private void miSzeptemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSzeptemberActionPerformed
        mutatandoHonap = Month.SEPTEMBER;
        mutatottHonapValt();
    }//GEN-LAST:event_miSzeptemberActionPerformed

    private void miOktoberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miOktoberActionPerformed
        mutatandoHonap = Month.OCTOBER;
        mutatottHonapValt();
    }//GEN-LAST:event_miOktoberActionPerformed

    private void miNovemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miNovemberActionPerformed
        mutatandoHonap = Month.NOVEMBER;
        mutatottHonapValt();
    }//GEN-LAST:event_miNovemberActionPerformed

    private void miDecemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDecemberActionPerformed
        mutatandoHonap = Month.DECEMBER;
        mutatottHonapValt();
    }//GEN-LAST:event_miDecemberActionPerformed
    
    private void tablazatFejlecMutatoBeallit() {
        penztarcakTabla.getTableHeader().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bevetelekTabla.getTableHeader().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        kiadasokTabla.getTableHeader().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    private void mutatottHonapValt() {
        szuresBeallit();
        osszesBevetelMezoBeallit();
        osszesKiadasTipusMezokBeallit();
        tranzakcioTablazatokFeltolt();
    }
    
    private void kiadasokAktualisRendezesBeallit() {
        megszurtKiadasokLista.sort(aktualisKiadasRendezes.reversed());
    }
    
    private void szuresBeallit() {
        megszurtKiadasokLista = kiadasokLista.stream().filter(new aktualisHonap(mutatandoHonap)).collect(Collectors.toCollection(ArrayList::new));
        megszurtBevetelLista = bevetelekLista.stream().filter(new aktualisHonap(mutatandoHonap)).collect(Collectors.toCollection(ArrayList::new));
    }
    
    private void tranzakcioTablazatokFeltolt() {
        tablaFeltolt(kiadasokTabla, megszurtKiadasokLista);
        tablaFeltolt(bevetelekTabla, megszurtBevetelLista);
    }
    
    private void tablazatokFeltolt() {
        tablaFeltolt(kiadasokTabla, megszurtKiadasokLista);
        tablaFeltolt(bevetelekTabla, megszurtBevetelLista);
        tablaFeltolt(penztarcakTabla, penztarcakLista);
    }
    
    private void osszegzoMezokBeallit() {
        osszesMegtakaritasBeallit();
        osszesPenzBeallit();
        osszesSzepKartyaBeallit();
        osszesVagyonBeallit();
        osszesBevetelMezoBeallit();
        osszesKiadasTipusMezokBeallit();
    }
    
    private void tablazatRendezesiLehetosegekBeallit() {
        setPenztarcakTablaFejlecActionListener();
        setBevetelTablaFejlecActionListener();
        setKiadasTablaFejlecActionListener();
    }
    
    private void setPenztarcakTablaFejlecActionListener(){
    penztarcakTabla.getTableHeader().addMouseListener(new MouseAdapter() {
        PenztarcaNevComparator penztarcaNevComp = new PenztarcaNevComparator();
        PenztarcaTipusComparator penztarcaTipusComp = new PenztarcaTipusComparator();
        PenztarcaOsszegComparator penztarcaOsszegComp = new PenztarcaOsszegComparator();
        
        @Override
        public void mouseClicked(MouseEvent e){
        int oszlopSzama = penztarcakTabla.columnAtPoint(e.getPoint());
        switch (oszlopSzama) {
                    case 0:
                        penztarcakLista.sort(penztarcaNevComp);
                        penztarcaNevComp.setForditott(!penztarcaNevComp.getForditott());
                        break;
                    case 1:
                        penztarcakLista.sort(penztarcaTipusComp);
                        penztarcaTipusComp.setForditott(!penztarcaTipusComp.getForditott());
                        break;
                    case 2:
                        penztarcakLista.sort(penztarcaOsszegComp);
                        penztarcaOsszegComp.setForditott(!penztarcaOsszegComp.getForditott());
                        break;                    
                    default:
                        break;
                }
                tablaFeltolt(penztarcakTabla, penztarcakLista);
        }
});
    }

    //Sorrendezési action listener a bevételek táblához
    private void setBevetelTablaFejlecActionListener() {
        bevetelekTabla.getTableHeader().addMouseListener(new MouseAdapter() {
            DatumComparator datumComp = new DatumComparator();
            TranzakcioPenztarcaComparator tarcaComp = new TranzakcioPenztarcaComparator();
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
                tablaFeltolt(bevetelekTabla, megszurtBevetelLista);
            }
        });
    }

    //Sorrendezési action listener a kivételek táblához
    private void setKiadasTablaFejlecActionListener() {
        kiadasokTabla.getTableHeader().addMouseListener(new MouseAdapter() {
            //A comparatorok azért vannak itt létrehozva és nem a switchen belül, hogy kattintásra működjön az ide-oda rendezés.
            //Különben minden kattintásra új comparator jönne létre és kétszer kellene kattintani az ellentétes irányú rendezéshez.
            DatumComparator datumComp = new DatumComparator();
            TranzakcioPenztarcaComparator tarcaComp = new TranzakcioPenztarcaComparator();
            MegnevezesComparator megnevezesComp = new MegnevezesComparator();
            OsszegComparator osszegComp = new OsszegComparator();
            KategoriaComparator kategoriaComp = new KategoriaComparator();
            VasarlasHelyComparator vasarlashelyComp = new VasarlasHelyComparator();
            
            @Override
            public void mouseClicked(MouseEvent e) {
                int oszlopSzama = kiadasokTabla.columnAtPoint(e.getPoint());
                switch (oszlopSzama) {
                    case 0:
                        aktualisKiadasRendezes = datumComp;
                        megszurtKiadasokLista.sort(datumComp);
                        datumComp.setForditott(!datumComp.getForditott());
                        break;
                    case 1:
                        aktualisKiadasRendezes = tarcaComp;
                        megszurtKiadasokLista.sort(tarcaComp);
                        tarcaComp.setForditott(!tarcaComp.getForditott());
                        break;
                    case 2:
                        aktualisKiadasRendezes = megnevezesComp;
                        megszurtKiadasokLista.sort(megnevezesComp);
                        megnevezesComp.setForditott(!megnevezesComp.getForditott());
                        break;
                    case 3:
                        aktualisKiadasRendezes = kategoriaComp;
                        megszurtKiadasokLista.sort(kategoriaComp);
                        kategoriaComp.setForditott(!kategoriaComp.getForditott());
                        break;
                    case 4:
                        aktualisKiadasRendezes = vasarlashelyComp;
                        megszurtKiadasokLista.sort(vasarlashelyComp);
                        vasarlashelyComp.setForditott(!vasarlashelyComp.getForditott());
                        break;
                    case 5:
                        aktualisKiadasRendezes = osszegComp;
                        megszurtKiadasokLista.sort(osszegComp);
                        osszegComp.setForditott(!osszegComp.getForditott());
                        break;
                    default:
                        break;
                }
                tablaFeltolt(kiadasokTabla, megszurtKiadasokLista);
            }
        });
    }
    
    private void osszesKiadasTipusMezokBeallit() {
        int rezsiOsszeg = 0, elelmiszerOsszeg = 0, etkezesOsszeg = 0, kozlekedesOsszeg = 0, egeszsegOsszeg = 0, egyebOsszeg = 0;
        for (Kiadas kiadas : megszurtKiadasokLista) {
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
                default:
                    egyebOsszeg += kiadas.getOsszeg();
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
        for (Bevetel bevetel : megszurtBevetelLista) {
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
            ujSor[3] = szamFormazo.format(bevetel.getOsszeg());
            return ujSor;
        } else {
            Object[] ujSor = new Object[kiadasokTablaOszlopSzam];
            Kiadas kiadas = (Kiadas) elem;
            ujSor[0] = kiadas.getDatum();
            ujSor[1] = kiadas.getErintettPenztarca().getNev();
            ujSor[2] = kiadas.getMegnevezes();
            ujSor[3] = kiadas.getKategoria();
            ujSor[4] = kiadas.getKiadasHely();
            ujSor[5] = szamFormazo.format(kiadas.getOsszeg());
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
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
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
    private javax.swing.JMenuItem miAprilis;
    private javax.swing.JMenuItem miAugusztus;
    private javax.swing.JMenuItem miDecember;
    private javax.swing.JMenuItem miFebruar;
    private javax.swing.JMenuItem miJanuar;
    private javax.swing.JMenuItem miJulius;
    private javax.swing.JMenuItem miJunius;
    private javax.swing.JMenuItem miMajus;
    private javax.swing.JMenuItem miMarcius;
    private javax.swing.JMenuItem miNovember;
    private javax.swing.JMenuItem miOktober;
    private javax.swing.JMenuItem miSzeptember;
    private javax.swing.JMenuItem penztarcaKezelesMenuItem;
    private javax.swing.JTable penztarcakTabla;
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
