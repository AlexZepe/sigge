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
@Table(name = "tb_cliente")
@NamedQueries({
    @NamedQuery(name = "TbCliente.findAll", query = "SELECT t FROM TbCliente t"),
    @NamedQuery(name = "TbCliente.findByIdcliente", query = "SELECT t FROM TbCliente t WHERE t.idcliente = :idcliente"),
    @NamedQuery(name = "TbCliente.findByPrimernombre", query = "SELECT t FROM TbCliente t WHERE t.primernombre = :primernombre"),
    @NamedQuery(name = "TbCliente.findByDireccion", query = "SELECT t FROM TbCliente t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "TbCliente.findByTelefono", query = "SELECT t FROM TbCliente t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "TbCliente.findByCorreo", query = "SELECT t FROM TbCliente t WHERE t.correo = :correo"),
    @NamedQuery(name = "TbCliente.findByEstado", query = "SELECT t FROM TbCliente t WHERE t.estado = :estado")})
public class TbCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcliente")
    private Integer idcliente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "primernombre")
    private String primernombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @Column(name = "estado")
    private Boolean estado;

    public TbCliente() {
    }

    public TbCliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public TbCliente(Integer idcliente, String primernombre, String direccion, int telefono, String correo) {
        this.idcliente = idcliente;
        this.primernombre = primernombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Integer getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Integer idcliente) {
        this.idcliente = idcliente;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcliente != null ? idcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbCliente)) {
            return false;
        }
        TbCliente other = (TbCliente) object;
        if ((this.idcliente == null && other.idcliente != null) || (this.idcliente != null && !this.idcliente.equals(other.idcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbCliente[ idcliente=" + idcliente + " ]";
    }
    
}
