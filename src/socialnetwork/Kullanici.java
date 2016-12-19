/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socialnetwork;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fahrettin
 */
@Entity
@Table(name = "KULLANICI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kullanici.findAll", query = "SELECT k FROM Kullanici k"),
    @NamedQuery(name = "Kullanici.findById", query = "SELECT k FROM Kullanici k WHERE k.kullaniciPK.id = :id"),
    @NamedQuery(name = "Kullanici.findByKullaniciadi", query = "SELECT k FROM Kullanici k WHERE k.kullaniciPK.kullaniciadi = :kullaniciadi"),
    @NamedQuery(name = "Kullanici.findByAdi", query = "SELECT k FROM Kullanici k WHERE k.adi = :adi"),
    @NamedQuery(name = "Kullanici.findBySoyadi", query = "SELECT k FROM Kullanici k WHERE k.soyadi = :soyadi"),
    @NamedQuery(name = "Kullanici.findByCinsiyet", query = "SELECT k FROM Kullanici k WHERE k.cinsiyet = :cinsiyet"),
    @NamedQuery(name = "Kullanici.findBySifre", query = "SELECT k FROM Kullanici k WHERE k.sifre = :sifre"),
    @NamedQuery(name = "Kullanici.findByDogumtarihi", query = "SELECT k FROM Kullanici k WHERE k.dogumtarihi = :dogumtarihi"),
    @NamedQuery(name = "Kullanici.findByEposta", query = "SELECT k FROM Kullanici k WHERE k.eposta = :eposta"),
    @NamedQuery(name = "Kullanici.findByProfilresmi", query = "SELECT k FROM Kullanici k WHERE k.profilresmi = :profilresmi"),
    @NamedQuery(name = "Kullanici.findByUlke", query = "SELECT k FROM Kullanici k WHERE k.ulke = :ulke")})
public class Kullanici implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected KullaniciPK kullaniciPK;
    @Column(name = "ADI")
    private String adi;
    @Column(name = "SOYADI")
    private String soyadi;
    @Column(name = "CINSIYET")
    private Boolean cinsiyet;
    @Column(name = "SIFRE")
    private String sifre;
    @Column(name = "DOGUMTARIHI")
    @Temporal(TemporalType.DATE)
    private Date dogumtarihi;
    @Column(name = "EPOSTA")
    private String eposta;
    @Column(name = "PROFILRESMI")
    private String profilresmi;
    @Column(name = "ULKE")
    private String ulke;

    public Kullanici() {
    }

    public Kullanici(KullaniciPK kullaniciPK) {
        this.kullaniciPK = kullaniciPK;
    }

    public Kullanici(int id, String kullaniciadi) {
        this.kullaniciPK = new KullaniciPK(id, kullaniciadi);
    }

    public KullaniciPK getKullaniciPK() {
        return kullaniciPK;
    }

    public void setKullaniciPK(KullaniciPK kullaniciPK) {
        this.kullaniciPK = kullaniciPK;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public Boolean getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Boolean cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Date getDogumtarihi() {
        return dogumtarihi;
    }

    public void setDogumtarihi(Date dogumtarihi) {
        this.dogumtarihi = dogumtarihi;
    }

    public String getEposta() {
        return eposta;
    }

    public void setEposta(String eposta) {
        this.eposta = eposta;
    }

    public String getProfilresmi() {
        return profilresmi;
    }

    public void setProfilresmi(String profilresmi) {
        this.profilresmi = profilresmi;
    }

    public String getUlke() {
        return ulke;
    }

    public void setUlke(String ulke) {
        this.ulke = ulke;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kullaniciPK != null ? kullaniciPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kullanici)) {
            return false;
        }
        Kullanici other = (Kullanici) object;
        if ((this.kullaniciPK == null && other.kullaniciPK != null) || (this.kullaniciPK != null && !this.kullaniciPK.equals(other.kullaniciPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "socialnetwork.Kullanici[ kullaniciPK=" + kullaniciPK + " ]";
    }
    
}
