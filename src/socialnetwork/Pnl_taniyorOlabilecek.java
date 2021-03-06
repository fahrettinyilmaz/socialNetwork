/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socialnetwork;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static socialnetwork.kayitPanel.scaleImage;

/**
 *
 * @author Fahrettin
 */
public class Pnl_taniyorOlabilecek extends javax.swing.JPanel {

    String profilresmi;
    String adi;
    String soyadi;
    String ulkesi;
    int kullaniciid;
    int arkadasid;
    String kullaniciAdi;
static long id;//ilk kullanıcı için
    /**
     * Creates new form NewJPanel
     *
     * @param ad
     * @param soyad
     * @param fUsername
     * @param img
     * @param ulke
     * @param eklenenID
     * @param userid
     */
    public Pnl_taniyorOlabilecek(String ad, String soyad, String fUsername, String img, String ulke, int userid, int eklenenID) {
        initComponents();
        //jButton1.setText(a);
        adi = ad;
        soyadi = soyad;
        profilresmi = img;
        ulkesi = ulke;
        
        kullaniciAdi = fUsername;

        //-Resim
        String url;
        if ("no-image.png".equals(profilresmi)) {
            url = "photos" + File.separator + "no-image.png";
        } else {
            url = "photos" + File.separator + kullaniciAdi + File.separator + profilresmi;
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
        //RESİM EKLEME TAMAM

        lbl_adSoyad.setText(adi + " " + soyadi);
        lbl_ulke.setText(ulkesi);

    }

    public static void btnclickEkle(int eklenen, int ekleyen, boolean kbl) {
        Arkadas a = new Arkadas();
        id = 1;//ilk kullanıcı için
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("socialNetworkPU");
        EntityManager em = emf.createEntityManager();
        Query qMaxId = em.createQuery("select MAX(c.id) from Arkadas c");
        
        try {
            id = Integer.parseInt(qMaxId.getSingleResult().toString()) + 1;
        } catch (Exception e) {
        }
        
        a.setId(id);
        a.setEklenenid(eklenen);
        a.setKullaniciid(ekleyen);
        a.setKabul(kbl);
        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    public  void btnclickSil() {
        Arkadas a = new Arkadas();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("socialNetworkPU");
        EntityManager em = emf.createEntityManager();
        
         Query q = em.createQuery("delete from Arkadas c where c.kullaniciid=:id1 AND c.eklenenid=:id2");
 Query q1 = em.createQuery("delete from Arkadas c where c.kullaniciid=:id1 AND c.eklenenid=:id2");
        q.setParameter("id1", kullaniciid);
        q.setParameter("id2", arkadasid);
          q1.setParameter("id1", arkadasid);
          q1.setParameter("id2", kullaniciid);
        
        
       
        em.getTransaction().begin();
q.executeUpdate();
q1.executeUpdate();
        em.getTransaction().commit();
        em.close();
        emf.close();

    }

    Pnl_taniyorOlabilecek(String ad, String soyad, String kullaniciAdi, String ulke, int kullaniciID, int kisiID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_istekGonder = new javax.swing.JToggleButton();
        lbl_ulke = new javax.swing.JLabel();
        lbl_adSoyad = new javax.swing.JLabel();
        lbl_resim = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(300, 100));
        setLayout(null);

        btn_istekGonder.setText("Arkadaş Olma İsteği Gönder");
        btn_istekGonder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_istekGonderActionPerformed(evt);
            }
        });
        add(btn_istekGonder);
        btn_istekGonder.setBounds(90, 70, 200, 20);

        lbl_ulke.setText("Ülke Adı:");
        add(lbl_ulke);
        lbl_ulke.setBounds(90, 40, 51, 16);

        lbl_adSoyad.setText("AD SOYAD");
        add(lbl_adSoyad);
        lbl_adSoyad.setBounds(90, 10, 157, 16);

        lbl_resim.setBackground(new java.awt.Color(255, 255, 255));
        lbl_resim.setText("jLabel2");
        add(lbl_resim);
        lbl_resim.setBounds(10, 10, 70, 70);
    }// </editor-fold>//GEN-END:initComponents
boolean aktif = false;
    private void btn_istekGonderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_istekGonderActionPerformed
        // TODO add your handling code here:
        System.out.println("123");
        if (!aktif) {
            btn_istekGonder.setText("İsteği İptal Et");
            btnclickEkle(arkadasid, kullaniciid, true);
            //ARKADASLIK OLDUGUN DAN KARSILIKLI
            btnclickEkle(kullaniciid, arkadasid, false);

            aktif = true;

        } else {
            btn_istekGonder.setText("Arkadaş İsteği Gönder");
            btnclickSil();
            System.out.println("aaaa");
            aktif = false;
        }


    }//GEN-LAST:event_btn_istekGonderActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btn_istekGonder;
    private javax.swing.JLabel lbl_adSoyad;
    private javax.swing.JLabel lbl_resim;
    private javax.swing.JLabel lbl_ulke;
    // End of variables declaration//GEN-END:variables
}
