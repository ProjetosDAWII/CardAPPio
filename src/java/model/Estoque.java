package model;

import java.io.Serializable;
import java.util.Date;


/**
 *
 * @author tatuapu
 */

public class Estoque implements Serializable {

    
    private Integer idEstoque;
    
    private Integer idIngrediente;
    
    private int quantidade;
    
    private Date dataFab;
    
    private Date dataVenc;
    
    private String lote;
    
    private String unidade;
    
    private Integer idProduto;
    
    private NotaFiscal notaFiscalidNotaFiscal;
    

    public Estoque() {
    }

    public Estoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Estoque(Integer idEstoque, int quantidade) {
        this.idEstoque = idEstoque;
        this.quantidade = quantidade;
    }

    public Integer getIdEstoque() {
        return idEstoque;
    }

    public void setIdEstoque(Integer idEstoque) {
        this.idEstoque = idEstoque;
    }

    public Integer getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(Integer idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDataFab() {
        return dataFab;
    }

    public void setDataFab(Date dataFab) {
        this.dataFab = dataFab;
    }

    public Date getDataVenc() {
        return dataVenc;
    }

    public void setDataVenc(Date dataVenc) {
        this.dataVenc = dataVenc;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public NotaFiscal getNotaFiscalidNotaFiscal() {
        return notaFiscalidNotaFiscal;
    }

    public void setNotaFiscalidNotaFiscal(NotaFiscal notaFiscalidNotaFiscal) {
        this.notaFiscalidNotaFiscal = notaFiscalidNotaFiscal;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstoque != null ? idEstoque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estoque)) {
            return false;
        }
        Estoque other = (Estoque) object;
        if ((this.idEstoque == null && other.idEstoque != null) || (this.idEstoque != null && !this.idEstoque.equals(other.idEstoque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Estoque[ idEstoque=" + idEstoque + " ]";
    }
    
}
