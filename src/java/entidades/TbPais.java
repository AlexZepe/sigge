/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author aspire e 14
 */
@Entity
@Table(name = "tb_pais")
@NamedQueries({
    @NamedQuery(name = "TbPais.findAll", query = "SELECT t FROM TbPais t"),
    @NamedQuery(name = "TbPais.findByIdpais", query = "SELECT t FROM TbPais t WHERE t.idpais = :idpais"),
    @NamedQuery(name = "TbPais.findByNombre", query = "SELECT t FROM TbPais t WHERE t.nombre = :nombre")})
public class TbPais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpais")
    private Integer idpais;
    @Size(max = 50)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(mappedBy = "idpais")
    private List<TbEmbarque> tbEmbarqueList;

    public TbPais() {
    }

    public TbPais(Integer idpais) {
        this.idpais = idpais;
    }

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<TbEmbarque> getTbEmbarqueList() {
        return tbEmbarqueList;
    }

    public void setTbEmbarqueList(List<TbEmbarque> tbEmbarqueList) {
        this.tbEmbarqueList = tbEmbarqueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpais != null ? idpais.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbPais)) {
            return false;
        }
        TbPais other = (TbPais) object;
        if ((this.idpais == null && other.idpais != null) || (this.idpais != null && !this.idpais.equals(other.idpais))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbPais[ idpais=" + idpais + " ]";
    }
    
}
