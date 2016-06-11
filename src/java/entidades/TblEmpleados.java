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
@Table(name = "tbl_empleados")
@NamedQueries({
    @NamedQuery(name = "TblEmpleados.findAll", query = "SELECT t FROM TblEmpleados t"),
    @NamedQuery(name = "TblEmpleados.findByIdempleado", query = "SELECT t FROM TblEmpleados t WHERE t.idempleado = :idempleado"),
    @NamedQuery(name = "TblEmpleados.findByNombre", query = "SELECT t FROM TblEmpleados t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TblEmpleados.findByNumerodui", query = "SELECT t FROM TblEmpleados t WHERE t.numerodui = :numerodui"),
    @NamedQuery(name = "TblEmpleados.findByTelefono", query = "SELECT t FROM TblEmpleados t WHERE t.telefono = :telefono"),
    @NamedQuery(name = "TblEmpleados.findByCorreo", query = "SELECT t FROM TblEmpleados t WHERE t.correo = :correo"),
    @NamedQuery(name = "TblEmpleados.findByPuesto", query = "SELECT t FROM TblEmpleados t WHERE t.puesto = :puesto"),
    @NamedQuery(name = "TblEmpleados.findBySalario", query = "SELECT t FROM TblEmpleados t WHERE t.salario = :salario"),
    @NamedQuery(name = "TblEmpleados.findByFechaingreso", query = "SELECT t FROM TblEmpleados t WHERE t.fechaingreso = :fechaingreso")})
public class TblEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idempleado")
    private Integer idempleado;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numerodui")
    private String numerodui;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "puesto")
    private String puesto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salario")
    private double salario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaingreso")
    @Temporal(TemporalType.DATE)
    private Date fechaingreso;
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")
    @ManyToOne
    private TblFactura idfactura;

    public TblEmpleados() {
    }

    public TblEmpleados(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public TblEmpleados(Integer idempleado, String numerodui, String telefono, String correo, String puesto, double salario, Date fechaingreso) {
        this.idempleado = idempleado;
        this.numerodui = numerodui;
        this.telefono = telefono;
        this.correo = correo;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaingreso = fechaingreso;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumerodui() {
        return numerodui;
    }

    public void setNumerodui(String numerodui) {
        this.numerodui = numerodui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getFechaingreso() {
        return fechaingreso;
    }

    public void setFechaingreso(Date fechaingreso) {
        this.fechaingreso = fechaingreso;
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
        hash += (idempleado != null ? idempleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmpleados)) {
            return false;
        }
        TblEmpleados other = (TblEmpleados) object;
        if ((this.idempleado == null && other.idempleado != null) || (this.idempleado != null && !this.idempleado.equals(other.idempleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.TblEmpleados[ idempleado=" + idempleado + " ]";
    }
    
}
