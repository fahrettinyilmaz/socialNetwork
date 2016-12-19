/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package socialnetwork;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fahrettin
 */
@Entity
@Table(name = "GONDERI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gonderi.findAll", query = "SELECT g FROM Gonderi g"),
    @NamedQuery(name = "Gonderi.findById", query = "SELECT g FROM Gonderi g WHERE g.id = :id"),
    @NamedQuery(name = "Gonderi.findByKullaniciid", query = "SELECT g FROM Gonderi g WHERE g.kullaniciid = :kullaniciid"),
    @NamedQuery(name = "Gonderi.findByMetin", query = "SELECT g FROM Gonderi g WHERE g.metin = :metin"),
    @NamedQuery(name = "Gonderi.findByYt", query = "SELECT g FROM Gonderi g WHERE g.yt = :yt")})
public class Gonderi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "KULLANICIID")
    private Integer kullaniciid;
    @Column(name = "METIN")
    private String metin;
    @Column(name = "YT")
    private Boolean yt;

    public Gonderi() {
    }

    public Gonderi(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getKullaniciid() {
        return kullaniciid;
    }

    public void setKullaniciid(Integer kullaniciid) {
        this.kullaniciid = kullaniciid;
    }

    public String getMetin() {
        return metin;
    }

    public void setMetin(String metin) {
        this.metin = metin;
    }

    public Boolean getYt() {
        return yt;
    }

    public void setYt(Boolean yt) {
        this.yt = yt;
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
        if (!(object instanceof Gonderi)) {
            return false;
        }
        Gonderi other = (Gonderi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "socialnetwork.Gonderi[ id=" + id + " ]";
    }
    
}
