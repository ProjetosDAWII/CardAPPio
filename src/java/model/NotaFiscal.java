package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 * @author tatuapu
 */

public class NotaFiscal implements Serializable {

    
    private Integer idNotaFiscal;
    private String tpNF;
    private Date data;

    public NotaFiscal() {
    }

    public NotaFiscal(Integer idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public NotaFiscal(Integer idNotaFiscal, String tpNF) {
        this.idNotaFiscal = idNotaFiscal;
        this.tpNF = tpNF;
    }

    public Integer getIdNotaFiscal() {
        return idNotaFiscal;
    }

    public void setIdNotaFiscal(Integer idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    public String getTpNF() {
        return tpNF;
    }

    public void setTpNF(String tpNF) {
        this.tpNF = tpNF;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotaFiscal != null ? idNotaFiscal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotaFiscal)) {
            return false;
        }
        NotaFiscal other = (NotaFiscal) object;
        if ((this.idNotaFiscal == null && other.idNotaFiscal != null) || (this.idNotaFiscal != null && !this.idNotaFiscal.equals(other.idNotaFiscal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.NotaFiscal[ idNotaFiscal=" + idNotaFiscal + " ]";
    }
    
}
