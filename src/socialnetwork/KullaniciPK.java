/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socialnetwork;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Fahrettin
 */
@Embeddable
public class KullaniciPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Basic(optional = false)
    @Column(name = "KULLANICIADI")
    private String kullaniciadi;

    public KullaniciPK() {
    }

    public KullaniciPK(int id, String kullaniciadi) {
        this.id = id;
        this.kullaniciadi = kullaniciadi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullaniciadi() {
        return kullaniciadi;
    }

    public void setKullaniciadi(String kullaniciadi) {
        this.kullaniciadi = kullaniciadi;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (kullaniciadi != null ? kullaniciadi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KullaniciPK)) {
            return false;
        }
        KullaniciPK other = (KullaniciPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.kullaniciadi == null && other.kullaniciadi != null) || (this.kullaniciadi != null && !this.kullaniciadi.equals(other.kullaniciadi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "socialnetwork.KullaniciPK[ id=" + id + ", kullaniciadi=" + kullaniciadi + " ]";
    }
    
}
