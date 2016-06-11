/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author aspire e 14
 */
@Entity
@Table(name = "tb_embarque")
@NamedQueries({
    @NamedQuery(name = "TbEmbarque.findAll", query = "SELECT t FROM TbEmbarque t"),
    @NamedQuery(name = "TbEmbarque.findByIdembarque", query = "SELECT t FROM TbEmbarque t WHERE t.idembarque = :idembarque"),
    @NamedQuery(name = "TbEmbarque.findByNcontenedor", query = "SELECT t FROM TbEmbarque t WHERE t.ncontenedor = :ncontenedor"),
    @NamedQuery(name = "TbEmbarque.findByPesokgs", query = "SELECT t FROM TbEmbarque t WHERE t.pesokgs = :pesokgs"),
    @NamedQuery(name = "TbEmbarque.findByVolumenmc", query = "SELECT t FROM TbEmbarque t WHERE t.volumenmc = :volumenmc"),
    @NamedQuery(name = "TbEmbarque.findByDescripcion", query = "SELECT t FROM TbEmbarque t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TbEmbarque.findByTipoembarque", query = "SELECT t FROM TbEmbarque t WHERE t.tipoembarque = :tipoembarque"),
    @NamedQuery(name = "TbEmbarque.findByFechasalida", query = "SELECT t FROM TbEmbarque t WHERE t.fechasalida = :fechasalida")})
public class TbEmbarque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idembarque")
    private Integer idembarque;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "ncontenedor")
    private String ncontenedor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pesokgs")
    private double pesokgs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "volumenmc")
    private double volumenmc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipoembarque")
    private String tipoembarque;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechasalida")
    @Temporal(TemporalType.DATE)
    private Date fechasalida;
    @JoinColumn(name = "idpais", referencedColumnName = "idpais")
    @ManyToOne
    private TbPais idpais;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne
    private TbProducto idproducto;
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")
    @ManyToOne
    private TblFactura idfactura;

    public TbEmbarque() {
    }

    public TbEmbarque(Integer idembarque) {
        this.idembarque = idembarque;
    }

    public TbEmbarque(Integer idembarque, String ncontenedor, double pesokgs, double volumenmc, String descripcion, String tipoembarque, Date fechasalida) {
        this.idembarque = idembarque;
        this.ncontenedor = ncontenedor;
        this.pesokgs = pesokgs;
        this.volumenmc = volumenmc;
        this.descripcion = descripcion;
        this.tipoembarque = tipoembarque;
        this.fechasalida = fechasalida;
    }

    public Integer getIdembarque() {
        return idembarque;
    }

    public void setIdembarque(Integer idembarque) {
        this.idembarque = idembarque;
    }

    public String getNcontenedor() {
        return ncontenedor;
    }

    public void setNcontenedor(String ncontenedor) {
        this.ncontenedor = ncontenedor;
    }

    public double getPesokgs() {
        return pesokgs;
    }

    public void setPesokgs(double pesokgs) {
        this.pesokgs = pesokgs;
    }

    public double getVolumenmc() {
        return volumenmc;
    }

    public void setVolumenmc(double volumenmc) {
        this.volumenmc = volumenmc;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoembarque() {
        return tipoembarque;
    }

    public void setTipoembarque(String tipoembarque) {
        this.tipoembarque = tipoembarque;
    }

    public Date getFechasalida() {
        return fechasalida;
    }

    public void setFechasalida(Date fechasalida) {
        this.fechasalida = fechasalida;
    }

    public TbPais getIdpais() {
        return idpais;
    }

    public void setIdpais(TbPais idpais) {
        this.idpais = idpais;
    }

    public TbProducto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(TbProducto idproducto) {
        this.idproducto = idproducto;
    }

    public TblFactura getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(TblFactura idfactura) {
        this.idfactura = idfactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idembarque != null ? idembarque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbEmbarque)) {
            return false;
        }
        TbEmbarque other = (TbEmbarque) object;
        if ((this.idembarque == null && other.idembarque != null) || (this.idembarque != null && !this.idembarque.equals(other.idembarque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TbEmbarque[ idembarque=" + idembarque + " ]";
    }
    
}
