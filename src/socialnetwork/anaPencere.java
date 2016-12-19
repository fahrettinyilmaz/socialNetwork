/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import static socialnetwork.kayitPanel.scaleImage;

/**
 *
 * @author Fahrettin
 */
public class anaPencere extends javax.swing.JFrame {

    /**
     * Creates new form anaPencere
     */
    int kullaniciID;

    public anaPencere() throws SQLException {
        kullaniciID = Integer.parseInt(loginPanel.kullaniciId);
        initComponents();
        initProfile();
        kisiIstekleri();
        gonderiDoldur();
        profilGonderiDoldur();
        arkadaslistdoldur();
        txt_durum.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            public void update() {
                lbl_charKalan.setText(txt_durum.getText().length() + "/230");
            }
        });
        
        
        


        lst_arkadaslar.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                
                if (!arg0.getValueIsAdjusting()) {
                    System.out.println(lst_arkadaslar.getSelectedValue().toString());
mesajList.clear();
                    try {
                        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworkdb?useSSL=false", "root", "5353");
                        Statement s1 = c1.createStatement();
                        ResultSet rs = s1.executeQuery("select * from mesajlar where alanid=" + kullaniciID + " and gonderenid=" + aList.get(lst_arkadaslar.getSelectedIndex()).id);
                        listModel = new DefaultListModel();
                        lst_mesajlar.setModel(listModel);
 
                        while (rs.next()) {
                            MesajlarClass m=new MesajlarClass();
                            m.id=Integer.parseInt(rs.getString("ID"));
                            m.gonderen=Integer.parseInt(rs.getString("GONDERENID"));
                            m.alan=Integer.parseInt(rs.getString("ALANID"));
                            m.mesaj=rs.getString("MESAJ");
                            mesajList.add(m);
                            listModel.addElement(rs.getString("mesajkonu"));
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        });
        lst_mesajlar.addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    System.out.println(lst_arkadaslar.getSelectedValue().toString());

                    try {
                        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworkdb?useSSL=false", "root", "5353");
                        Statement s1 = c1.createStatement();
                        int msgid=mesajList.get(lst_mesajlar.getSelectedIndex()).id+1;
                        ResultSet rs = s1.executeQuery("select * from mesajlar where id=" +msgid) ;
                        listModel = new DefaultListModel();
                        lst_mesajlar.setModel(listModel);

                        while (rs.next()) {
                            listModel.addElement(rs.getString("mesaj"));
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }

        });
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        socialNetworkPUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory("socialNetworkPU").createEntityManager();
        arkadasQuery = java.beans.Beans.isDesignTime() ? null : socialNetworkPUEntityManager.createQuery("SELECT a FROM Arkadas a");
        arkadasList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : arkadasQuery.getResultList();
        tp_sayfalar = new javax.swing.JTabbedPane();
        pnl_anaSayfa = new javax.swing.JPanel();
        lbl_resim = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        pnl_taniyorList = new javax.swing.JPanel();
        lbl_hosgeldiniz = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_durum = new javax.swing.JTextArea();
        myJScrollPane = new javax.swing.JScrollPane();
        pnl_gonderiler = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lbl_kAdiID = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        pnl_isteklerList = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_paylas = new javax.swing.JButton();
        lbl_charKalan = new javax.swing.JLabel();
        btn_yenile1 = new javax.swing.JButton();
        pnl_profil = new javax.swing.JPanel();
        myJScrollPane1 = new javax.swing.JScrollPane();
        pnl_profilGonderiler = new javax.swing.JPanel();
        lbl_resim1 = new javax.swing.JLabel();
        lbl_hosgeldiniz1 = new javax.swing.JLabel();
        lbl_kAdiID1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_yenile = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_cinsiyet = new javax.swing.JLabel();
        lbl_yas = new javax.swing.JLabel();
        lbl_ulke = new javax.swing.JLabel();
        btn_duzenle = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbl_mail = new javax.swing.JLabel();
        pnl_arkadaslar = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        pnl_aramaSonucList = new javax.swing.JPanel();
        btn_ara = new javax.swing.JButton();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txt_ara = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        myJScrollPane2 = new javax.swing.JScrollPane();
        pnl_arkadasGonderi = new javax.swing.JPanel();
        cmb_arkadaslar = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbl_yas1 = new javax.swing.JLabel();
        lbl_ulke1 = new javax.swing.JLabel();
        lbl_cinsiyet1 = new javax.swing.JLabel();
        lbl_mail1 = new javax.swing.JLabel();
        btn_arkadaslarimdanCikar = new javax.swing.JButton();
        pnl_mesajlar = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        lst_arkadaslar = new javax.swing.JList();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_mesajlar = new javax.swing.JList();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cmb_arkadaslar1 = new javax.swing.JComboBox();
        jTextArea2 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jTextArea3 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(939, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        tp_sayfalar.setMinimumSize(new java.awt.Dimension(990, 700));

        pnl_anaSayfa.setLayout(null);

        lbl_resim.setText("profilResmi");
        lbl_resim.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnl_anaSayfa.add(lbl_resim);
        lbl_resim.setBounds(23, 13, 140, 140);

        pnl_taniyorList.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_taniyorListLayout = new javax.swing.GroupLayout(pnl_taniyorList);
        pnl_taniyorList.setLayout(pnl_taniyorListLayout);
        pnl_taniyorListLayout.setHorizontalGroup(
            pnl_taniyorListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        pnl_taniyorListLayout.setVerticalGroup(
            pnl_taniyorListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 171, Short.MAX_VALUE)
        );

        jScrollPane3.setViewportView(pnl_taniyorList);

        pnl_anaSayfa.add(jScrollPane3);
        jScrollPane3.setBounds(600, 220, 320, 101);

        lbl_hosgeldiniz.setText("İsim Soyisim, Hoşgeldiniz!");
        pnl_anaSayfa.add(lbl_hosgeldiniz);
        lbl_hosgeldiniz.setBounds(181, 21, 180, 16);

        jLabel1.setText("Durum :");
        pnl_anaSayfa.add(jLabel1);
        jLabel1.setBounds(581, 13, 47, 16);

        txt_durum.setColumns(20);
        txt_durum.setLineWrap(true);
        txt_durum.setRows(5);
        jScrollPane2.setViewportView(txt_durum);

        pnl_anaSayfa.add(jScrollPane2);
        jScrollPane2.setBounds(640, 10, 260, 100);

        myJScrollPane.setHorizontalScrollBar(null);

        pnl_gonderiler.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_gonderilerLayout = new javax.swing.GroupLayout(pnl_gonderiler);
        pnl_gonderiler.setLayout(pnl_gonderilerLayout);
        pnl_gonderilerLayout.setHorizontalGroup(
            pnl_gonderilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        pnl_gonderilerLayout.setVerticalGroup(
            pnl_gonderilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        myJScrollPane.setViewportView(pnl_gonderiler);

        pnl_anaSayfa.add(myJScrollPane);
        myJScrollPane.setBounds(20, 190, 570, 400);

        jLabel2.setText("Tanıyor Olabileceğiniz Kişiler :");
        pnl_anaSayfa.add(jLabel2);
        jLabel2.setBounds(600, 190, 190, 16);

        lbl_kAdiID.setForeground(new java.awt.Color(204, 204, 255));
        lbl_kAdiID.setText("kullanici adi / id ");
        pnl_anaSayfa.add(lbl_kAdiID);
        lbl_kAdiID.setBounds(181, 50, 93, 16);

        jLabel3.setText("Arkadaşlık İstekleri :");
        pnl_anaSayfa.add(jLabel3);
        jLabel3.setBounds(600, 350, 116, 16);

        pnl_isteklerList.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_isteklerListLayout = new javax.swing.GroupLayout(pnl_isteklerList);
        pnl_isteklerList.setLayout(pnl_isteklerListLayout);
        pnl_isteklerListLayout.setHorizontalGroup(
            pnl_isteklerListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 356, Short.MAX_VALUE)
        );
        pnl_isteklerListLayout.setVerticalGroup(
            pnl_isteklerListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 180, Short.MAX_VALUE)
        );

        jScrollPane6.setViewportView(pnl_isteklerList);

        pnl_anaSayfa.add(jScrollPane6);
        jScrollPane6.setBounds(600, 390, 320, 110);

        jLabel5.setFont(new java.awt.Font("Georgia", 3, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 255));
        jLabel5.setText("Created By f-yilmaz");
        pnl_anaSayfa.add(jLabel5);
        jLabel5.setBounds(650, 540, 250, 40);

        btn_paylas.setText("Paylaş");
        btn_paylas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paylasActionPerformed(evt);
            }
        });
        pnl_anaSayfa.add(btn_paylas);
        btn_paylas.setBounds(820, 120, 80, 25);

        lbl_charKalan.setText("0/230");
        pnl_anaSayfa.add(lbl_charKalan);
        lbl_charKalan.setBounds(640, 110, 70, 16);

        btn_yenile1.setText("yenile");
        btn_yenile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yenile1ActionPerformed(evt);
            }
        });
        pnl_anaSayfa.add(btn_yenile1);
        btn_yenile1.setBounds(470, 165, 120, 20);

        tp_sayfalar.addTab("Anasayfa", pnl_anaSayfa);

        myJScrollPane1.setHorizontalScrollBar(null);

        pnl_profilGonderiler.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_profilGonderilerLayout = new javax.swing.GroupLayout(pnl_profilGonderiler);
        pnl_profilGonderiler.setLayout(pnl_profilGonderilerLayout);
        pnl_profilGonderilerLayout.setHorizontalGroup(
            pnl_profilGonderilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        pnl_profilGonderilerLayout.setVerticalGroup(
            pnl_profilGonderilerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        myJScrollPane1.setViewportView(pnl_profilGonderiler);

        lbl_resim1.setText("profilResmi");
        lbl_resim1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbl_hosgeldiniz1.setText("İsim Soyisim, Hoşgeldiniz!");

        lbl_kAdiID1.setForeground(new java.awt.Color(204, 204, 255));
        lbl_kAdiID1.setText("kullanici adi / id ");

        jLabel4.setText("Doğum Tarihi");

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Fahrettin\\Desktop\\large_edit-find-replace.png")); // NOI18N
        jLabel7.setText("jLabel7");

        btn_yenile.setText("yenile");
        btn_yenile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_yenileActionPerformed(evt);
            }
        });

        jLabel6.setText("Cinsiyet");

        jLabel8.setText("Ülke");

        jLabel9.setText(":");

        jLabel10.setText(":");

        jLabel11.setText(":");

        lbl_cinsiyet.setText("---");

        lbl_yas.setText("---");

        lbl_ulke.setText("---");

        btn_duzenle.setText("Bilgileri Düzenle");
        btn_duzenle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_duzenleActionPerformed(evt);
            }
        });

        jLabel12.setText("E-posta adresi");

        jLabel13.setText(":");

        lbl_mail.setText("---");

        javax.swing.GroupLayout pnl_profilLayout = new javax.swing.GroupLayout(pnl_profil);
        pnl_profil.setLayout(pnl_profilLayout);
        pnl_profilLayout.setHorizontalGroup(
            pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_profilLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_resim1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_hosgeldiniz1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_kAdiID1))
                .addGap(229, 229, 229)
                .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_profilLayout.createSequentialGroup()
                        .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnl_profilLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_ulke, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnl_profilLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_yas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(pnl_profilLayout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_cinsiyet, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnl_profilLayout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_mail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(btn_duzenle, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(pnl_profilLayout.createSequentialGroup()
                .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_profilLayout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(btn_yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_profilLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(myJScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnl_profilLayout.setVerticalGroup(
            pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_profilLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_resim1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_profilLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_hosgeldiniz1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9)
                            .addComponent(lbl_yas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_kAdiID1)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(lbl_ulke))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel11)
                            .addComponent(lbl_cinsiyet))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(lbl_mail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_duzenle)))
                .addGap(62, 62, 62)
                .addComponent(btn_yenile, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(pnl_profilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myJScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_profilLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        tp_sayfalar.addTab("Profil", pnl_profil);

        pnl_arkadaslar.setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Arkadaş Ekleme"));
        jPanel1.setLayout(null);

        jScrollPane5.setHorizontalScrollBar(null);

        pnl_aramaSonucList.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_aramaSonucListLayout = new javax.swing.GroupLayout(pnl_aramaSonucList);
        pnl_aramaSonucList.setLayout(pnl_aramaSonucListLayout);
        pnl_aramaSonucListLayout.setHorizontalGroup(
            pnl_aramaSonucListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 657, Short.MAX_VALUE)
        );
        pnl_aramaSonucListLayout.setVerticalGroup(
            pnl_aramaSonucListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );

        jScrollPane5.setViewportView(pnl_aramaSonucList);

        jPanel1.add(jScrollPane5);
        jScrollPane5.setBounds(10, 370, 320, 200);

        btn_ara.setText("Ara!");
        btn_ara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_araActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ara);
        btn_ara.setBounds(20, 250, 57, 25);

        jTextArea1.setBackground(javax.swing.UIManager.getDefaults().getColor("Label.background"));
        jTextArea1.setColumns(60);
        jTextArea1.setFont(new java.awt.Font("Constantia", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Sorgulamayı arayacağınız kişinin ad, soyadı ile    yapabilirsiniz. Ancak bu işlem birden fazla kayıt  döndürebilir. Arayacağınız kişinin e-mail adresinibiliyorsanız daha net sonuç elde edebilirsiniz.");
        jPanel1.add(jTextArea1);
        jTextArea1.setBounds(14, 30, 310, 80);

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\Fahrettin\\Documents\\NetBeansProjects\\socialNetwork\\Friend_Search-128.png")); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(200, 120, 130, 190);
        jPanel1.add(txt_ara);
        txt_ara.setBounds(20, 190, 170, 30);

        jLabel24.setText("E-mail/ Ad Soyad");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(20, 170, 120, 16);

        pnl_arkadaslar.add(jPanel1);
        jPanel1.setBounds(10, 10, 340, 590);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Arkadaşlar"));
        jPanel2.setLayout(null);

        myJScrollPane2.setHorizontalScrollBar(null);

        pnl_arkadasGonderi.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_arkadasGonderiLayout = new javax.swing.GroupLayout(pnl_arkadasGonderi);
        pnl_arkadasGonderi.setLayout(pnl_arkadasGonderiLayout);
        pnl_arkadasGonderiLayout.setHorizontalGroup(
            pnl_arkadasGonderiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
        );
        pnl_arkadasGonderiLayout.setVerticalGroup(
            pnl_arkadasGonderiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 468, Short.MAX_VALUE)
        );

        myJScrollPane2.setViewportView(pnl_arkadasGonderi);

        jPanel2.add(myJScrollPane2);
        myJScrollPane2.setBounds(10, 170, 570, 400);

        cmb_arkadaslar.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seçiniz" }));
        cmb_arkadaslar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_arkadaslarActionPerformed(evt);
            }
        });
        jPanel2.add(cmb_arkadaslar);
        cmb_arkadaslar.setBounds(110, 30, 180, 22);

        jLabel15.setText("Arkadaşlarınız :");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(10, 30, 100, 16);

        jLabel16.setText("Doğum Tarihi");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(305, 10, 77, 16);

        jLabel17.setText("Ülke");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(305, 33, 24, 16);

        jLabel18.setText("Cinsiyet");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(305, 56, 60, 16);

        jLabel19.setText("E-posta adresi");
        jPanel2.add(jLabel19);
        jLabel19.setBounds(305, 79, 82, 16);

        jLabel20.setText(":");
        jPanel2.add(jLabel20);
        jLabel20.setBounds(405, 79, 5, 16);

        jLabel21.setText(":");
        jPanel2.add(jLabel21);
        jLabel21.setBounds(405, 56, 5, 16);

        jLabel22.setText(":");
        jPanel2.add(jLabel22);
        jLabel22.setBounds(405, 33, 5, 16);

        jLabel23.setText(":");
        jPanel2.add(jLabel23);
        jLabel23.setBounds(405, 10, 5, 16);

        lbl_yas1.setText("---");
        jPanel2.add(lbl_yas1);
        lbl_yas1.setBounds(417, 10, 157, 16);

        lbl_ulke1.setText("---");
        jPanel2.add(lbl_ulke1);
        lbl_ulke1.setBounds(417, 33, 157, 16);

        lbl_cinsiyet1.setText("---");
        jPanel2.add(lbl_cinsiyet1);
        lbl_cinsiyet1.setBounds(417, 56, 157, 16);

        lbl_mail1.setText("---");
        jPanel2.add(lbl_mail1);
        lbl_mail1.setBounds(417, 79, 157, 16);

        btn_arkadaslarimdanCikar.setText("Arkadaşlarımdan Çıkar");
        btn_arkadaslarimdanCikar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_arkadaslarimdanCikarActionPerformed(evt);
            }
        });
        jPanel2.add(btn_arkadaslarimdanCikar);
        btn_arkadaslarimdanCikar.setBounds(310, 100, 260, 25);

        pnl_arkadaslar.add(jPanel2);
        jPanel2.setBounds(350, 10, 578, 583);

        tp_sayfalar.addTab("Arkadaşlar", pnl_arkadaslar);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Arkadaşlar"));

        lst_arkadaslar.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Seçiniz..." };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane7.setViewportView(lst_arkadaslar);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Gelen Mesajlar"));

        jScrollPane1.setViewportView(lst_mesajlar);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Mesaj Gönder"));

        jLabel25.setText("Kime");

        jLabel26.setText("Mesaj");

        jLabel27.setText(":");

        jLabel28.setText(":");

        cmb_arkadaslar1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seçiniz" }));
        cmb_arkadaslar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_arkadaslar1ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);

        jButton1.setText("Gönder");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel27)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_arkadaslar1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton1)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel28)
                            .addGap(17, 17, 17)
                            .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27)
                    .addComponent(cmb_arkadaslar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel26)
                        .addComponent(jLabel28))
                    .addComponent(jTextArea2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Mesaj Oku"));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextArea3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnl_mesajlarLayout = new javax.swing.GroupLayout(pnl_mesajlar);
        pnl_mesajlar.setLayout(pnl_mesajlarLayout);
        pnl_mesajlarLayout.setHorizontalGroup(
            pnl_mesajlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mesajlarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_mesajlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnl_mesajlarLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnl_mesajlarLayout.setVerticalGroup(
            pnl_mesajlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_mesajlarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_mesajlarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tp_sayfalar.addTab("Mesajlar", pnl_mesajlar);

        getContentPane().add(tp_sayfalar);
        tp_sayfalar.setBounds(0, 0, 940, 640);

        jMenu1.setText("Kullanıcı");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem1.setText("Profili Düzenle");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Kullanıcı Değiştir");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Çıkış");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents
List<MesajlarClass> mesajList=new ArrayList<>();
    public void yenile() throws SQLException {
        cmb_arkadaslar.removeAll();
        initProfile();
        gonderiDoldur();
        taniyorOlabilir();
        kisiIstekleri();
        profilGonderiDoldur();
        arkadaslistdoldur();
    }

    private void initProfile() throws SQLException {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("socialNetworkPU");
        String profilResmi = null;
        String kullaniciAdi = null;
        String adi = null;
        String soyAdi = null;
        String dt = null;
        String ulke = null;
        String cinsiyet = null;
        String email = null;
        EntityManager em = emf.createEntityManager();
        //Query qk = em.createQuery("select c.sifre from Kullanici c where c.kullaniciPK.kullaniciadi=:kadi");
        Query q = em.createQuery("select c from Kullanici c where c.kullaniciPK.id=:kullaniciidno");
        q.setParameter("kullaniciidno", kullaniciID);
        List<Kullanici> klist = q.getResultList();
        for (Kullanici k : klist) {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = k.getDogumtarihi();
            dt = dateFormat.format(date);
            ulke = k.getUlke();
            if (k.getCinsiyet()) {
                cinsiyet = "Erkek";
            } else {
                cinsiyet = "Kadın";
            }
            email = k.getEposta();
            profilResmi = k.getProfilresmi();
            kullaniciAdi = k.getKullaniciPK().getKullaniciadi();
            adi = k.getAdi();
            soyAdi = k.getSoyadi();
        }
        lbl_cinsiyet.setText(cinsiyet);
        lbl_mail.setText(email);
        lbl_ulke.setText(ulke);
        lbl_yas.setText(dt);

        lbl_kAdiID.setText(kullaniciAdi + " / ID=" + kullaniciID);
        lbl_kAdiID1.setText(kullaniciAdi + " / ID=" + kullaniciID);
        lbl_hosgeldiniz.setText(adi + " " + soyAdi + " , Hoşgeldiniz.");
        lbl_hosgeldiniz1.setText(adi + " " + soyAdi);
        String url;
        if ("no-image.png".equals(profilResmi)) {
            url = "photos" + File.separator + "no-image.png";
        } else {
            url = "photos" + File.separator + kullaniciAdi + File.separator + profilResmi;
        }
        System.out.println(url);
        File fs = new File(url);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(fs);
        } catch (IOException ex) {
            Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
        }
        ImageIcon icon = new ImageIcon(url);
        lbl_resim.setIcon(new ImageIcon(scaleImage(bi, BufferedImage.TYPE_INT_RGB, lbl_resim.getWidth(), lbl_resim.getHeight())));
        lbl_resim1.setIcon(new ImageIcon(scaleImage(bi, BufferedImage.TYPE_INT_RGB, lbl_resim.getWidth(), lbl_resim.getHeight())));
        //icon.getImage().flush();
        //lbl_resim.setIcon(icon);
        //  lbl_resim.setIcon(new ImageIcon(ImageIO.read(new File(fs))));

        //}
        taniyorOlabilir();
        em.close();
        emf.close();

    }

    void taniyorOlabilir() throws SQLException {
        pnl_taniyorList.removeAll();
        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworkdb?useSSL=false", "root", "5353");
        Statement s1 = c1.createStatement();
        Statement s2 = c1.createStatement();
        ResultSet rs = s1.executeQuery("SELECT DISTINCT EKLENENID FROM ARKADAS WHERE KULLANICIID IN(SELECT EKLENENID FROM ARKADAS WHERE  KULLANICIID=" + kullaniciID + ") AND EKLENENID NOT IN (SELECT EKLENENID FROM ARKADAS WHERE KULLANICIID=" + kullaniciID + ") AND EKLENENID<>" + kullaniciID);
        //pnl_taniyor pt=new pnl_taniyor();
        int kisiID;
        int sayac = 0;
        boolean bl = false;
        String ad, soyad, resim, ulke, kAdi;
        while (rs.next()) {
            System.out.println("devam");
            kisiID = Integer.parseInt(rs.getString("EKLENENID"));
            ResultSet rsKisiBilgiler = s2.executeQuery("Select * from Kullanici where ID=" + kisiID);
            rsKisiBilgiler.next();
            ad = rsKisiBilgiler.getString("ADI");
            soyad = rsKisiBilgiler.getString("SOYADI");
            resim = rsKisiBilgiler.getString("PROFILRESMI");
            ulke = rsKisiBilgiler.getString("ULKE");
            kAdi = rsKisiBilgiler.getString("KULLANICIADI");
            System.out.println(ad + soyad);

            Pnl_taniyorOlabilecek j = new Pnl_taniyorOlabilecek(ad, soyad, kAdi, resim, ulke, kullaniciID, kisiID);
            // pnl_taniyorList.setLayout(new java.awt.GridLayout(2, 1));
            j.setSize(345, 200);
            j.setVisible(true);
            pnl_taniyorList.add(j);
            sayac++;
            bl = true;

        }
        if (!bl) {
            Pnl_durum n = new Pnl_durum("Tanıyor olabileceğiniz kimse bulunamadı");
            n.setSize(345, 200);

            n.setVisible(true);
            pnl_taniyorList.add(n);
        }

        pnl_taniyorList.setLayout(new java.awt.GridLayout(sayac, 1));

        pack();
    }

    void kisiIstekleri() throws SQLException {
        pnl_isteklerList.removeAll();
        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworkdb?useSSL=false", "root", "5353");
        Statement s1 = c1.createStatement();
        Statement s2 = c1.createStatement();
        ResultSet rs = s1.executeQuery("select eklenenid from arkadas where kabul=false and kullaniciid=" + kullaniciID);
        //pnl_taniyor pt=new pnl_taniyor();
        int kisiID;
        int sayac = 0;
        boolean bl = false;
        String ad, soyad, resim, ulke, kAdi;
        while (rs.next()) {
            bl = true;
            System.out.println("devam");
            kisiID = Integer.parseInt(rs.getString("EKLENENID"));
            System.out.println(kisiID);
            ResultSet rsKisiBilgiler = s2.executeQuery("Select * from Kullanici where ID=" + kisiID);
            rsKisiBilgiler.next();
            ad = rsKisiBilgiler.getString("ADI");
            soyad = rsKisiBilgiler.getString("SOYADI");
            resim = rsKisiBilgiler.getString("PROFILRESMI");
            ulke = rsKisiBilgiler.getString("ULKE");
            kAdi = rsKisiBilgiler.getString("KULLANICIADI");
            System.out.println(ad + soyad);

            Pnl_istekler j = new Pnl_istekler(ad, soyad, kAdi, resim, ulke, kullaniciID, kisiID);
            pnl_isteklerList.setLayout(new java.awt.GridLayout(2, 1));
            j.kullaniciid = kullaniciID;
            j.arkadasid = kisiID;
            j.setSize(345, 200);
            j.setVisible(true);
            pnl_isteklerList.add(j);
            sayac++;

        }
        if (!bl) {
            Pnl_durum n = new Pnl_durum("Herhangi bir arkadaşlık isteğiniz bulunmuyor");
            n.setSize(345, 200);
            n.setVisible(true);
            pnl_isteklerList.add(n);
        }

        // pack();
        pnl_isteklerList.setLayout(new java.awt.GridLayout(sayac, 1));

        pack();
    }

    void gonderiDoldur() throws SQLException {
        pnl_gonderiler.removeAll();
        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworkdb?useSSL=false", "root", "5353");
        Statement s1 = c1.createStatement();
        Statement s2 = c1.createStatement();
        ResultSet rs = s1.executeQuery("select KULLANICIID,metin,id from GONDERI where KULLANICIID IN(select eklenenID from arkadas where KULLANICIID=" + kullaniciID + " AND KABUL=TRUE) ORDER by ID desc");
        //pnl_taniyor pt=new pnl_taniyor();
        int kisiID;
        int sayac = 0;
        boolean bl = false;
        String ad, soyad, resim, metin, kAdi;
        while (rs.next()) {

            System.out.println("devam");
            kisiID = Integer.parseInt(rs.getString("KULLANICIID"));
            System.out.println(kisiID);
            metin = rs.getString("metin");
            ResultSet rsKisiBilgiler = s2.executeQuery("Select * from Kullanici where ID=" + kisiID);
            rsKisiBilgiler.next();
            ad = rsKisiBilgiler.getString("ADI");
            soyad = rsKisiBilgiler.getString("SOYADI");
            resim = rsKisiBilgiler.getString("PROFILRESMI");

            kAdi = rsKisiBilgiler.getString("KULLANICIADI");
            System.out.println(ad + soyad);

            Pnl_gonderiler j = new Pnl_gonderiler(metin, ad, soyad, resim, kAdi);

            j.setSize(560, 117);
            j.setVisible(true);
            pnl_gonderiler.add(j);
            sayac++;

        }
        pnl_gonderiler.setLayout(new java.awt.GridLayout(sayac, 1));

        pack();

    }

    DefaultListModel<Object> listModel;

    List<Arkadaslar> aList = new ArrayList<>();

    void arkadaslistdoldur() {
        cmb_arkadaslar.removeAll();
        cmb_arkadaslar1.removeAll();
        try {
          //select * from arkadas where KULLANICIID=1 and EKLENENID not in  (select KULLANICIID from ARKADAS where EKLENENID=1 AND KABUL=FALSE)

            // TODO code application logic here
            Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworkdb?useSSL=false", "root", "5353");
            Statement s1 = c1.createStatement();
            ResultSet rs = s1.executeQuery("select * from KULLANICI where ID in (select EKLENENID from arkadas where KULLANICIID=" + kullaniciID + " and EKLENENID not in  (select KULLANICIID from ARKADAS where EKLENENID=" + kullaniciID + " AND KABUL=FALSE))");
            listModel = new DefaultListModel();
            lst_arkadaslar.setModel(listModel);
            while (rs.next()) {
                Arkadaslar a = new Arkadaslar();
                a.adi = rs.getString("adi");
                a.soyadi = rs.getString("soyadi");
                a.id = Integer.parseInt(rs.getString("id"));
                aList.add(a);
                cmb_arkadaslar.addItem(a.adi + " " + a.soyadi);
                cmb_arkadaslar1.addItem(a.adi + " " + a.soyadi);

                listModel.addElement(a.adi + " " + a.soyadi);

            }

        } catch (SQLException ex) {
            Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    void profilGonderiDoldur() throws SQLException {
        pnl_profilGonderiler.removeAll();
        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworkdb?useSSL=false", "root", "5353");
        Statement s1 = c1.createStatement();
        Statement s2 = c1.createStatement();
        ResultSet rs = s1.executeQuery("select metin,id from GONDERI where KULLANICIID=" + kullaniciID + " order by ID desc");
        int kisiID;
        int sayac = 0;
        long metinid = 0;
        boolean bl = false;
        String ad, soyad, resim, metin, kAdi;
        while (rs.next()) {

            System.out.println("devam");
            kisiID = kullaniciID;
            System.out.println(kisiID);
            metin = rs.getString("metin");
            metinid = Long.parseLong(rs.getString("id"));
            System.out.println(metinid + "---" + metin);
            ResultSet rsKisiBilgiler = s2.executeQuery("Select * from Kullanici where ID=" + kisiID);
            rsKisiBilgiler.next();

            ad = rsKisiBilgiler.getString("ADI");
            soyad = rsKisiBilgiler.getString("SOYADI");
            resim = rsKisiBilgiler.getString("PROFILRESMI");

            kAdi = rsKisiBilgiler.getString("KULLANICIADI");
            System.out.println(ad + soyad);

            Pnl_gonderiDuzenle j = new Pnl_gonderiDuzenle(metin, ad, soyad, resim, kAdi);
            j.idno = metinid;
            j.setSize(560, 117);
            j.setVisible(true);
            pnl_profilGonderiler.add(j);
            sayac++;

        }
        pnl_profilGonderiler.setLayout(new java.awt.GridLayout(sayac, 1));

        pack();

    }

    void arkadasProfilGonderiDoldur(int arkadasID) throws SQLException {
        pnl_arkadasGonderi.removeAll();
        Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworkdb?useSSL=false", "root", "5353");
        Statement s1 = c1.createStatement();
        Statement s2 = c1.createStatement();
        ResultSet rs = s1.executeQuery("select KULLANICIID,metin,id from GONDERI where KULLANICIID=" + arkadasID);
        //pnl_taniyor pt=new pnl_taniyor();
        int kisiID;
        int sayac = 0;
        boolean bl = false;
        String ad, soyad, resim, metin, kAdi, cinsiyet;
        while (rs.next()) {

            System.out.println("devam");
            kisiID = Integer.parseInt(rs.getString("KULLANICIID"));
            System.out.println(kisiID);
            metin = rs.getString("metin");
            ResultSet rsKisiBilgiler = s2.executeQuery("Select * from Kullanici where ID=" + kisiID);
            rsKisiBilgiler.next();
            ad = rsKisiBilgiler.getString("ADI");
            soyad = rsKisiBilgiler.getString("SOYADI");
            resim = rsKisiBilgiler.getString("PROFILRESMI");
            lbl_mail1.setText(rsKisiBilgiler.getString("EPOSTA"));
            lbl_yas1.setText(rsKisiBilgiler.getString("DOGUMTARIHI"));
            if (rsKisiBilgiler.getBoolean(5)) {
                cinsiyet = "Erkek";
            } else {
                cinsiyet = "Kadın";
            }
            ;
            lbl_cinsiyet1.setText(cinsiyet);
            lbl_ulke1.setText(rsKisiBilgiler.getString("ULKE"));
            kAdi = rsKisiBilgiler.getString("KULLANICIADI");
            System.out.println(ad + soyad);

            Pnl_gonderiler j = new Pnl_gonderiler(metin, ad, soyad, resim, kAdi);

            j.setSize(560, 117);
            j.setVisible(true);
            pnl_arkadasGonderi.add(j);
            sayac++;

        }
        pnl_arkadasGonderi.setLayout(new java.awt.GridLayout(sayac, 1));

        pack();
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cmb_arkadaslar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_arkadaslar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_arkadaslar1ActionPerformed

    private void btn_arkadaslarimdanCikarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_arkadaslarimdanCikarActionPerformed
        try {
            // TODO add your handling code here:
            if (cmb_arkadaslar.getSelectedIndex() != 0) {
                Arkadas a = new Arkadas();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("socialNetworkPU");
                EntityManager em = emf.createEntityManager();

                Query q = em.createQuery("delete from Arkadas c where c.kullaniciid=:id1 AND c.eklenenid=:id2");
                Query q1 = em.createQuery("delete from Arkadas c where c.kullaniciid=:id1 AND c.eklenenid=:id2");
                q.setParameter("id1", kullaniciID);
                q.setParameter("id2", aList.get(cmb_arkadaslar.getSelectedIndex() - 1).id);
                q1.setParameter("id1", aList.get(cmb_arkadaslar.getSelectedIndex() - 1).id);
                q1.setParameter("id2", kullaniciID);

                em.getTransaction().begin();
                q.executeUpdate();
                q1.executeUpdate();
                em.getTransaction().commit();
                em.close();
                emf.close();

                yenile();
            } else {

                JOptionPane.showMessageDialog(null, "Herhangi bir arkadaş seçilmedi.", "Geçersiz İşlem", 0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_arkadaslarimdanCikarActionPerformed

    private void cmb_arkadaslarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_arkadaslarActionPerformed
        // TODO add your handling code here:
        pnl_arkadasGonderi.removeAll();
        pnl_arkadasGonderi.revalidate();
        pnl_arkadasGonderi.repaint();

        if (cmb_arkadaslar.getSelectedIndex() != 0) {

            try {
                System.out.println(aList.get(cmb_arkadaslar.getSelectedIndex() - 1).adi);;

                arkadasProfilGonderiDoldur(aList.get(cmb_arkadaslar.getSelectedIndex() - 1).id);
            } catch (SQLException ex) {
                Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_cmb_arkadaslarActionPerformed

    private void btn_araActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_araActionPerformed
        try {
            pnl_aramaSonucList.removeAll();
            // TODO add your handling code here:
            boolean bl = false;
            int sayac = 0;
            emailKontrol ek = new emailKontrol();
            ResultSet rs1;
            Connection c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/socialnetworkdb?useSSL=false", "root", "5353");
            Statement s1 = c1.createStatement();
            Statement s2 = c1.createStatement();
            String eposta, adi, soyadi;
            if (txt_ara.getText() != "") {

                if (ek.validate(txt_ara.getText())) {

                    eposta = txt_ara.getText();

                    rs1 = s1.executeQuery("select * from kullanici where id not in(select EKLENENID from arkadas where KULLANICIID=" + kullaniciID + " and kabul=TRUE) and  EPOSTA='" + eposta + "'");
                } else {
                    adi = txt_ara.getText().split(" ")[0];
                    soyadi = txt_ara.getText().split(" ")[1];
                    rs1 = s1.executeQuery("select * from kullanici where id not in(select EKLENENID from arkadas where KULLANICIID=" + kullaniciID + " and kabul=TRUE) and  adi='" + adi + "' and soyadi='" + soyadi + "'");

                }
                //     select profilresmi,ulke,adi,soyadi,EPOSTA from kullanici where id not in(select EKLENENID from arkadas where KULLANICIID=1 and kabul=false) and ((adi='Fahrdfsfstin' and soyadi='YILdsfsdfMAZ') OR EPOSTA='f-yilmaz-@hotmail.com');

                int kisiID;

                String ad, soyad, resim, ulke, kAdi;
                while (rs1.next()) {
                    System.out.println("devam");
                    kisiID = rs1.getInt("ID");
                    ad = rs1.getString("ADI");
                    soyad = rs1.getString("SOYADI");
                    resim = rs1.getString("PROFILRESMI");
                    ulke = rs1.getString("ULKE");
                    kAdi = rs1.getString("KULLANICIADI");
                    System.out.println("asdasdasdasdad");

                    Pnl_taniyorOlabilecek j = new Pnl_taniyorOlabilecek(ad, soyad, kAdi, resim, ulke, kullaniciID, kisiID);
                    // pnl_taniyorList.setLayout(new java.awt.GridLayout(2, 1));
                    j.arkadasid = kisiID;
                    j.kullaniciid = kullaniciID;
                    j.setSize(345, 200);
                    j.setVisible(true);
                    pnl_aramaSonucList.add(j);
                    sayac++;
                    bl = true;

                }
            } else {
                JOptionPane.showMessageDialog(null, "Arama yapmak için aramak istediğiniz kişinin ad soyad veya email adreisini giriniz.", "Bilgi girilmedi!", 0);
            }
            if (!bl) {
                Pnl_durum n = new Pnl_durum("Girmiş olduğunuz bilgilerle bir kayıt bulunamadı.");
                n.setSize(345, 200);

                n.setVisible(true);
                pnl_aramaSonucList.add(n);
            }

            pnl_aramaSonucList.setLayout(new java.awt.GridLayout(sayac, 1));

            pack();

        } catch (SQLException ex) {
            Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_araActionPerformed

    private void btn_yenileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yenileActionPerformed
        try {
            // TODO add your handling code here:
            yenile();
        } catch (SQLException ex) {
            Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_yenileActionPerformed

    private void btn_yenile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_yenile1ActionPerformed
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            yenile();
        } catch (SQLException ex) {
            Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_yenile1ActionPerformed

    private void btn_paylasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paylasActionPerformed
        // TODO add your handling code here:
        if (txt_durum.getText().length() <= 230) {

            if ("".equals(txt_durum.getText())) {
                JOptionPane.showMessageDialog(null, "Herhangi birşey girilmedi", "Boş Durum", 0);
            } else {
                long id = 1;
                Gonderi g = new Gonderi();
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("socialNetworkPU");
                EntityManager em = emf.createEntityManager();
                Query qMaxId = em.createQuery("select MAX(c.id) from Gonderi c");
                try {
                    id = Integer.parseInt(qMaxId.getSingleResult().toString()) + 1;
                } catch (Exception e) {
                }
                
                g.setId(id);
                g.setKullaniciid(kullaniciID);
                g.setMetin(txt_durum.getText());
                g.setYt(false);
                em.getTransaction().begin();
                em.persist(g);
                em.getTransaction().commit();

                JOptionPane.showMessageDialog(null, "Paylaşımınız başarıyla gerçekleşti!", "İşlem Tamamlandı", 1);

                em.close();
                emf.close();
                txt_durum.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Max izin verilen karakter sayısını aştınız.", "Karakter Aşımı", 0);
        }
    }//GEN-LAST:event_btn_paylasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        super.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        super.dispose();
        new loginPanel().setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void btn_duzenleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_duzenleActionPerformed
        // TODO add your handling code here:
        new profilDuzenle().setVisible(true);
    }//GEN-LAST:event_btn_duzenleActionPerformed

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
            java.util.logging.Logger.getLogger(anaPencere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(anaPencere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(anaPencere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(anaPencere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new anaPencere().setVisible(true);

                } catch (SQLException ex) {
                    Logger.getLogger(anaPencere.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.util.List<socialnetwork.Arkadas> arkadasList;
    private javax.persistence.Query arkadasQuery;
    private javax.swing.JButton btn_ara;
    private javax.swing.JButton btn_arkadaslarimdanCikar;
    private javax.swing.JButton btn_duzenle;
    private javax.swing.JButton btn_paylas;
    private javax.swing.JButton btn_yenile;
    private javax.swing.JButton btn_yenile1;
    private javax.swing.JComboBox cmb_arkadaslar;
    private javax.swing.JComboBox cmb_arkadaslar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JLabel lbl_charKalan;
    private javax.swing.JLabel lbl_cinsiyet;
    private javax.swing.JLabel lbl_cinsiyet1;
    private javax.swing.JLabel lbl_hosgeldiniz;
    private javax.swing.JLabel lbl_hosgeldiniz1;
    private javax.swing.JLabel lbl_kAdiID;
    private javax.swing.JLabel lbl_kAdiID1;
    private javax.swing.JLabel lbl_mail;
    private javax.swing.JLabel lbl_mail1;
    private javax.swing.JLabel lbl_resim;
    private javax.swing.JLabel lbl_resim1;
    private javax.swing.JLabel lbl_ulke;
    private javax.swing.JLabel lbl_ulke1;
    private javax.swing.JLabel lbl_yas;
    private javax.swing.JLabel lbl_yas1;
    private javax.swing.JList lst_arkadaslar;
    private javax.swing.JList lst_mesajlar;
    public javax.swing.JScrollPane myJScrollPane;
    public javax.swing.JScrollPane myJScrollPane1;
    public javax.swing.JScrollPane myJScrollPane2;
    private javax.swing.JPanel pnl_anaSayfa;
    private javax.swing.JPanel pnl_aramaSonucList;
    public javax.swing.JPanel pnl_arkadasGonderi;
    private javax.swing.JPanel pnl_arkadaslar;
    public javax.swing.JPanel pnl_gonderiler;
    private javax.swing.JPanel pnl_isteklerList;
    private javax.swing.JPanel pnl_mesajlar;
    private javax.swing.JPanel pnl_profil;
    public javax.swing.JPanel pnl_profilGonderiler;
    private javax.swing.JPanel pnl_taniyorList;
    private javax.persistence.EntityManager socialNetworkPUEntityManager;
    private javax.swing.JTabbedPane tp_sayfalar;
    private javax.swing.JTextField txt_ara;
    private javax.swing.JTextArea txt_durum;
    // End of variables declaration//GEN-END:variables
}
