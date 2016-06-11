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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aspire e 14
 */
@Entity
@Table(name = "tb_proveedor")
@NamedQueries({
    @NamedQuery(name = "TbProveedor.findAll", query = "SELECT t FROM TbProveedor t"),
    @NamedQuery(name = "TbProveedor.findByIdproveedor", query = "SELECT t FROM TbProveedor t WHERE t.idproveedor = :idproveedor"),
    @NamedQuery(name = "TbProveedor.findByNombre", query = "SELECT t FROM TbProveedor t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TbProveedor.findByTelefono", query = "SELECT t FROM TbProveedor t WHERE t.telefono = :telefono")})
public class TbProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproveedor")
    private Integer idproveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono")
    private String telefono;
    @OneToMany(mappedBy = "idproveedor")
    private List<TbProducto> tbProductoList;

    public TbProveedor() {
    }

    public TbProveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public TbProveedor(Integer idproveedor, String nombre, String telefono) {
        this.idproveedor = idproveedor;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<TbProducto> getTbProductoList() {
        return tbProductoList;
    }

    public void setTbProductoList(List<TbProducto> tbProductoList) {
        this.tbProductoList = tbProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproveedor != null ? idproveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProveedor)) {
            return false;
        }
        TbProveedor other = (TbProveedor) object;
        if ((this.idproveedor == null && other.idproveedor != null) || (this.idproveedor != null && !this.idproveedor.equals(other.idproveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbProveedor[ idproveedor=" + idproveedor + " ]";
    }
    
}
