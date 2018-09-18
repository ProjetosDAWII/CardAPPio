/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author tatuapu
 */
@Embeddable
public class IngredienteHasProdutoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "produto_idProduto")
    private int produtoidProduto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estoque_idEstoque")
    private int estoqueidEstoque;

    public IngredienteHasProdutoPK() {
    }

    public IngredienteHasProdutoPK(int produtoidProduto, int estoqueidEstoque) {
        this.produtoidProduto = produtoidProduto;
        this.estoqueidEstoque = estoqueidEstoque;
    }

    public int getProdutoidProduto() {
        return produtoidProduto;
    }

    public void setProdutoidProduto(int produtoidProduto) {
        this.produtoidProduto = produtoidProduto;
    }

    public int getEstoqueidEstoque() {
        return estoqueidEstoque;
    }

    public void setEstoqueidEstoque(int estoqueidEstoque) {
        this.estoqueidEstoque = estoqueidEstoque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) produtoidProduto;
        hash += (int) estoqueidEstoque;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngredienteHasProdutoPK)) {
            return false;
        }
        IngredienteHasProdutoPK other = (IngredienteHasProdutoPK) object;
        if (this.produtoidProduto != other.produtoidProduto) {
            return false;
        }
        if (this.estoqueidEstoque != other.estoqueidEstoque) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.IngredienteHasProdutoPK[ produtoidProduto=" + produtoidProduto + ", estoqueidEstoque=" + estoqueidEstoque + " ]";
    }
    
}
