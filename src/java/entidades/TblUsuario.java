/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aspire e 14
 */
@Entity
@Table(name = "tbl_usuario")
@NamedQueries({
    @NamedQuery(name = "TblUsuario.findAll", query = "SELECT t FROM TblUsuario t"),
    @NamedQuery(name = "TblUsuario.findByIdusuario", query = "SELECT t FROM TblUsuario t WHERE t.idusuario = :idusuario"),
    @NamedQuery(name = "TblUsuario.findByNombre", query = "SELECT t FROM TblUsuario t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblUsuario.findByPassword", query = "SELECT t FROM TblUsuario t WHERE t.password = :password")})
public class TblUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idusuario")
    private Integer idusuario;
    @Size(max = 25)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "idrol", referencedColumnName = "idrol")
    @ManyToOne
    private TblRol idrol;

    public TblUsuario() {
    }

    public TblUsuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public TblUsuario(Integer idusuario, String password) {
        this.idusuario = idusuario;
        this.password = password;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TblRol getIdrol() {
        return idrol;
    }

    public void setIdrol(TblRol idrol) {
        this.idrol = idrol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idusuario != null ? idusuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblUsuario)) {
            return false;
        }
        TblUsuario other = (TblUsuario) object;
        if ((this.idusuario == null && other.idusuario != null) || (this.idusuario != null && !this.idusuario.equals(other.idusuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TblUsuario[ idusuario=" + idusuario + " ]";
    }
    
}
