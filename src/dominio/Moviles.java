/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Docente
 */
@Entity
@Table(name = "moviles", catalog = "pedidos", schema = "")
@NamedQueries({@NamedQuery(name = "Moviles.findAll", query = "SELECT m FROM Moviles m"), @NamedQuery(name = "Moviles.findByNromovil", query = "SELECT m FROM Moviles m WHERE m.nromovil = :nromovil"), @NamedQuery(name = "Moviles.findByObservaciones", query = "SELECT m FROM Moviles m WHERE m.observaciones = :observaciones")})
public class Moviles implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nromovil")
    private Integer nromovil;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(mappedBy = "idMovil")
    private Collection<Pedidos> pedidosCollection;

    public Moviles() {
    }

    public Moviles(Integer nromovil) {
        this.nromovil = nromovil;
    }

    public Integer getNromovil() {
        return nromovil;
    }

    public void setNromovil(Integer nromovil) {
        Integer oldNromovil = this.nromovil;
        this.nromovil = nromovil;
        changeSupport.firePropertyChange("nromovil", oldNromovil, nromovil);
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        String oldObservaciones = this.observaciones;
        this.observaciones = observaciones;
        changeSupport.firePropertyChange("observaciones", oldObservaciones, observaciones);
    }

    public Collection<Pedidos> getPedidosCollection() {
        return pedidosCollection;
    }

    public void setPedidosCollection(Collection<Pedidos> pedidosCollection) {
        this.pedidosCollection = pedidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nromovil != null ? nromovil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moviles)) {
            return false;
        }
        Moviles other = (Moviles) object;
        if ((this.nromovil == null && other.nromovil != null) || (this.nromovil != null && !this.nromovil.equals(other.nromovil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  String.valueOf(nromovil);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
