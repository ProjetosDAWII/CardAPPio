package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author tatuapu
 */

public class Categoria implements Serializable {

    private Integer idCategoria;
    
    private String categoriaNm;
    
    private String categoriaDesc;
    
    public Categoria() {
    }

    public Categoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Categoria(Integer idCategoria, String categoriaNm) {
        this.idCategoria = idCategoria;
        this.categoriaNm = categoriaNm;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCategoriaNm() {
        return categoriaNm;
    }

    public void setCategoriaNm(String categoriaNm) {
        this.categoriaNm = categoriaNm;
    }

    public String getCategoriaDesc() {
        return categoriaDesc;
    }

    public void setCategoriaDesc(String categoriaDesc) {
        this.categoriaDesc = categoriaDesc;
    }

    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCategoria == null && other.idCategoria != null) || (this.idCategoria != null && !this.idCategoria.equals(other.idCategoria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Categoria[ idCategoria=" + idCategoria + " ]";
    }
    
}
