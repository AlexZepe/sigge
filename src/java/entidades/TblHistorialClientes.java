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
@Table(name = "tbl_historial_clientes")
@NamedQueries({
    @NamedQuery(name = "TblHistorialClientes.findAll", query = "SELECT t FROM TblHistorialClientes t"),
    @NamedQuery(name = "TblHistorialClientes.findByIdhistorial", query = "SELECT t FROM TblHistorialClientes t WHERE t.idhistorial = :idhistorial"),
    @NamedQuery(name = "TblHistorialClientes.findByIdcliente", query = "SELECT t FROM TblHistorialClientes t WHERE t.idcliente = :idcliente"),
    @NamedQuery(name = "TblHistorialClientes.findByFechaultimaem", query = "SELECT t FROM TblHistorialClientes t WHERE t.fechaultimaem = :fechaultimaem")})
public class TblHistorialClientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idhistorial")
    private Integer idhistorial;
    @Size(max = 10)
    @Column(name = "idcliente")
    private String idcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaultimaem")
    @Temporal(TemporalType.DATE)
    private Date fechaultimaem;

    public TblHistorialClientes() {
    }

    public TblHistorialClientes(Integer idhistorial) {
        this.idhistorial = idhistorial;
    }

    public TblHistorialClientes(Integer idhistorial, Date fechaultimaem) {
        this.idhistorial = idhistorial;
        this.fechaultimaem = fechaultimaem;
    }

    public Integer getIdhistorial() {
        return idhistorial;
    }

    public void setIdhistorial(Integer idhistorial) {
        this.idhistorial = idhistorial;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public Date getFechaultimaem() {
        return fechaultimaem;
    }

    public void setFechaultimaem(Date fechaultimaem) {
        this.fechaultimaem = fechaultimaem;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhistorial != null ? idhistorial.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHistorialClientes)) {
            return false;
        }
        TblHistorialClientes other = (TblHistorialClientes) object;
        if ((this.idhistorial == null && other.idhistorial != null) || (this.idhistorial != null && !this.idhistorial.equals(other.idhistorial))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TblHistorialClientes[ idhistorial=" + idhistorial + " ]";
    }
    
}
