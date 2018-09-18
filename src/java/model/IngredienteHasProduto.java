/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author tatuapu
 */
@Entity
@Table(name = "ingrediente_has_produto")
@NamedQueries({
    @NamedQuery(name = "IngredienteHasProduto.findAll", query = "SELECT i FROM IngredienteHasProduto i")})
public class IngredienteHasProduto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IngredienteHasProdutoPK ingredienteHasProdutoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "unidade")
    private String unidade;
    @JoinColumn(name = "estoque_idEstoque", referencedColumnName = "idEstoque", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Estoque estoque;
    @JoinColumn(name = "produto_idProduto", referencedColumnName = "idProduto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produto produto;

    public IngredienteHasProduto() {
    }

    public IngredienteHasProduto(IngredienteHasProdutoPK ingredienteHasProdutoPK) {
        this.ingredienteHasProdutoPK = ingredienteHasProdutoPK;
    }

    public IngredienteHasProduto(IngredienteHasProdutoPK ingredienteHasProdutoPK, int quantidade, String unidade) {
        this.ingredienteHasProdutoPK = ingredienteHasProdutoPK;
        this.quantidade = quantidade;
        this.unidade = unidade;
    }

    public IngredienteHasProduto(int produtoidProduto, int estoqueidEstoque) {
        this.ingredienteHasProdutoPK = new IngredienteHasProdutoPK(produtoidProduto, estoqueidEstoque);
    }

    public IngredienteHasProdutoPK getIngredienteHasProdutoPK() {
        return ingredienteHasProdutoPK;
    }

    public void setIngredienteHasProdutoPK(IngredienteHasProdutoPK ingredienteHasProdutoPK) {
        this.ingredienteHasProdutoPK = ingredienteHasProdutoPK;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ingredienteHasProdutoPK != null ? ingredienteHasProdutoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngredienteHasProduto)) {
            return false;
        }
        IngredienteHasProduto other = (IngredienteHasProduto) object;
        if ((this.ingredienteHasProdutoPK == null && other.ingredienteHasProdutoPK != null) || (this.ingredienteHasProdutoPK != null && !this.ingredienteHasProdutoPK.equals(other.ingredienteHasProdutoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.IngredienteHasProduto[ ingredienteHasProdutoPK=" + ingredienteHasProdutoPK + " ]";
    }
    
}
