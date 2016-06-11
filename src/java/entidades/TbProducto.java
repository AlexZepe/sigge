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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aspire e 14
 */
@Entity
@Table(name = "tb_producto")
@NamedQueries({
    @NamedQuery(name = "TbProducto.findAll", query = "SELECT t FROM TbProducto t"),
    @NamedQuery(name = "TbProducto.findByIdproducto", query = "SELECT t FROM TbProducto t WHERE t.idproducto = :idproducto"),
    @NamedQuery(name = "TbProducto.findByNombre", query = "SELECT t FROM TbProducto t WHERE t.nombre = :nombre")})
public class TbProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "idproveedor", referencedColumnName = "idproveedor")
    @ManyToOne
    private TbProveedor idproveedor;
    @OneToMany(mappedBy = "idproducto")
    private List<TbEmbarque> tbEmbarqueList;

    public TbProducto() {
    }

    public TbProducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public TbProducto(Integer idproducto, String nombre) {
        this.idproducto = idproducto;
        this.nombre = nombre;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TbProveedor getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(TbProveedor idproveedor) {
        this.idproveedor = idproveedor;
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
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProducto)) {
            return false;
        }
        TbProducto other = (TbProducto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbProducto[ idproducto=" + idproducto + " ]";
    }
    
}
