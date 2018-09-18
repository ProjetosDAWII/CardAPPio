package model;

import java.io.Serializable;


/**
 *
 * @author tatuapu
 */

public class Ingrediente implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idIngrediente;
    
    private String ingredienteNm;
    
    private String ingredienteDesc;
    
    private Fornecedor idFornecedor;

    public Ingrediente() {
    }

    public Ingrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public Ingrediente(Integer idIngrediente, String ingredienteNm) {
        this.idIngrediente = idIngrediente;
        this.ingredienteNm = ingredienteNm;
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getIngredienteNm() {
        return ingredienteNm;
    }

    public void setIngredienteNm(String ingredienteNm) {
        this.ingredienteNm = ingredienteNm;
    }

    public String getIngredienteDesc() {
        return ingredienteDesc;
    }

    public void setIngredienteDesc(String ingredienteDesc) {
        this.ingredienteDesc = ingredienteDesc;
    }

    public Fornecedor getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Fornecedor idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIngrediente != null ? idIngrediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingrediente)) {
            return false;
        }
        Ingrediente other = (Ingrediente) object;
        if ((this.idIngrediente == null && other.idIngrediente != null) || (this.idIngrediente != null && !this.idIngrediente.equals(other.idIngrediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Ingrediente[ idIngrediente=" + idIngrediente + " ]";
    }
    
}
