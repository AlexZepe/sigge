/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aspire e 14
 */
@Entity
@Table(name = "tbl_factura")
@NamedQueries({
    @NamedQuery(name = "TblFactura.findAll", query = "SELECT t FROM TblFactura t"),
    @NamedQuery(name = "TblFactura.findByIdfactura", query = "SELECT t FROM TblFactura t WHERE t.idfactura = :idfactura"),
    @NamedQuery(name = "TblFactura.findByIdcliente", query = "SELECT t FROM TblFactura t WHERE t.idcliente = :idcliente"),
    @NamedQuery(name = "TblFactura.findByMontocancelado", query = "SELECT t FROM TblFactura t WHERE t.montocancelado = :montocancelado"),
    @NamedQuery(name = "TblFactura.findByMontocobrar", query = "SELECT t FROM TblFactura t WHERE t.montocobrar = :montocobrar"),
    @NamedQuery(name = "TblFactura.findByFechaventa", query = "SELECT t FROM TblFactura t WHERE t.fechaventa = :fechaventa"),
    @NamedQuery(name = "TblFactura.findByEnvio", query = "SELECT t FROM TblFactura t WHERE t.envio = :envio")})
public class TblFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idfactura")
    private Integer idfactura;
    @Size(max = 10)
    @Column(name = "idcliente")
    private String idcliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "montocancelado")
    private Double montocancelado;
    @Column(name = "montocobrar")
    private Double montocobrar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaventa")
    @Temporal(TemporalType.DATE)
    private Date fechaventa;
    @Column(name = "envio")
    private Boolean envio;
    @OneToMany(mappedBy = "idfactura")
    private List<TblEmpleados> tblEmpleadosList;
    @OneToMany(mappedBy = "idfactura")
    private List<TbEmbarque> tbEmbarqueList;

    public TblFactura() {
    }

    public TblFactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public TblFactura(Integer idfactura, Date fechaventa) {
        this.idfactura = idfactura;
        this.fechaventa = fechaventa;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public Double getMontocancelado() {
        return montocancelado;
    }

    public void setMontocancelado(Double montocancelado) {
        this.montocancelado = montocancelado;
    }

    public Double getMontocobrar() {
        return montocobrar;
    }

    public void setMontocobrar(Double montocobrar) {
        this.montocobrar = montocobrar;
    }

    public Date getFechaventa() {
        return fechaventa;
    }

    public void setFechaventa(Date fechaventa) {
        this.fechaventa = fechaventa;
    }

    public Boolean getEnvio() {
        return envio;
    }

    public void setEnvio(Boolean envio) {
        this.envio = envio;
    }

    public List<TblEmpleados> getTblEmpleadosList() {
        return tblEmpleadosList;
    }

    public void setTblEmpleadosList(List<TblEmpleados> tblEmpleadosList) {
        this.tblEmpleadosList = tblEmpleadosList;
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
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblFactura)) {
            return false;
        }
        TblFactura other = (TblFactura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TblFactura[ idfactura=" + idfactura + " ]";
    }
    
}
