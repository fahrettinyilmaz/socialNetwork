/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socialnetwork;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fahrettin
 */
@Entity
@Table(name = "ARKADAS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Arkadas.findAll", query = "SELECT a FROM Arkadas a"),
    @NamedQuery(name = "Arkadas.findByKullaniciid", query = "SELECT a FROM Arkadas a WHERE a.kullaniciid = :kullaniciid"),
    @NamedQuery(name = "Arkadas.findByEklenenid", query = "SELECT a FROM Arkadas a WHERE a.eklenenid = :eklenenid"),
    @NamedQuery(name = "Arkadas.findByKabul", query = "SELECT a FROM Arkadas a WHERE a.kabul = :kabul"),
    @NamedQuery(name = "Arkadas.findById", query = "SELECT a FROM Arkadas a WHERE a.id = :id")})
public class Arkadas implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "KULLANICIID")
    private int kullaniciid;
    @Basic(optional = false)
    @Column(name = "EKLENENID")
    private int eklenenid;
    @Basic(optional = false)
    @Column(name = "KABUL")
    private Boolean kabul;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    public Arkadas() {
    }

    public Arkadas(Long id) {
        this.id = id;
    }

    public Arkadas(Long id, int kullaniciid, int eklenenid, Boolean kabul) {
        this.id = id;
        this.kullaniciid = kullaniciid;
        this.eklenenid = eklenenid;
        this.kabul = kabul;
    }

    public int getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(int kullaniciid) {
        int oldKullaniciid = this.kullaniciid;
        this.kullaniciid = kullaniciid;
        changeSupport.firePropertyChange("kullaniciid", oldKullaniciid, kullaniciid);
    }

    public int getEklenenid() {
        return eklenenid;
    }

    public void setEklenenid(int eklenenid) {
        int oldEklenenid = this.eklenenid;
        this.eklenenid = eklenenid;
        changeSupport.firePropertyChange("eklenenid", oldEklenenid, eklenenid);
    }

    public Boolean getKabul() {
        return kabul;
    }

    public void setKabul(Boolean kabul) {
        Boolean oldKabul = this.kabul;
        this.kabul = kabul;
        changeSupport.firePropertyChange("kabul", oldKabul, kabul);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        Long oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Arkadas)) {
            return false;
        }
        Arkadas other = (Arkadas) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "socialnetwork.Arkadas[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
