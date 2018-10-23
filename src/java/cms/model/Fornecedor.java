
package cms.model;

import model.*;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author tatuapu
 */

public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idFornecedor;
    
    private String fornecedorNm;
    
    private String fornecedorEnd;
    
    private String fornecedorTel;
    
    private List<Ingrediente> ingredienteList;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getFornecedorNm() {
        return fornecedorNm;
    }

    public void setFornecedorNm(String fornecedorNm) {
        this.fornecedorNm = fornecedorNm;
    }

    public String getFornecedorEnd() {
        return fornecedorEnd;
    }

    public void setFornecedorEnd(String fornecedorEnd) {
        this.fornecedorEnd = fornecedorEnd;
    }

    public String getFornecedorTel() {
        return fornecedorTel;
    }

    public void setFornecedorTel(String fornecedorTel) {
        this.fornecedorTel = fornecedorTel;
    }

    public List<Ingrediente> getIngredienteList() {
        return ingredienteList;
    }

    public void setIngredienteList(List<Ingrediente> ingredienteList) {
        this.ingredienteList = ingredienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFornecedor != null ? idFornecedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.idFornecedor == null && other.idFornecedor != null) || (this.idFornecedor != null && !this.idFornecedor.equals(other.idFornecedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fornecedor[ idFornecedor=" + idFornecedor + " ]";
    }
    
}
