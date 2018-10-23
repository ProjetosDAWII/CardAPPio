package cms.model;

import model.*;
import java.io.Serializable;


/**
 *
 * @author tatuapu
 */

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer idProduto;
    
    private String produtoNm;
    
    private String produtoDesc;
    
    private Integer idFornecedor;
    
    private Categoria idCategoria;
    
    public Produto() {
    }

    public Produto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(Integer idProduto, String produtoNm) {
        this.idProduto = idProduto;
        this.produtoNm = produtoNm;
    }
    
    public Produto(Integer idProduto, String produtoNm, String produtoDesc){
        this.idProduto = idProduto;
        this.produtoNm = produtoNm;
        this.produtoDesc = produtoDesc;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getProdutoNm() {
        return produtoNm;
    }

    public void setProdutoNm(String produtoNm) {
        this.produtoNm = produtoNm;
    }

    public String getProdutoDesc() {
        return produtoDesc;
    }

    public void setProdutoDesc(String produtoDesc) {
        this.produtoDesc = produtoDesc;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produto[ idProduto=" + idProduto + " ]";
    }
    
}
