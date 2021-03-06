
package cms.ado;

import ado.*;
import base.ConnectionDAO;
import base.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;
import model.Produto;

/**
 *
 * @author tatuapu
 */
public class ProdutoADO implements DAO {

    @Override
    public void atualizar(Object ob) throws Exception {
        
    }
    
    public Integer atualiza(Produto p) throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = ConnectionDAO.getConnection();
            String sql = "UPDATE produto SET ";
            if(p.getProdutoNm()!=null){
                sql+= "produtoNm=?";
            }else if(p.getProdutoDesc()!=null){
                if(sql.contains("produtoNm")) sql+= ", ";
                sql += "produtoDesc=?";
            }
            sql += " WHERE idProduto=?";
            ps = conn.prepareStatement(sql);
            
            int cont=1;
            if(p.getProdutoNm()!=null){
                ps.setString(cont, p.getProdutoNm());
                cont++;
            }else if(p.getProdutoDesc()!=null){
                ps.setString(cont, p.getProdutoDesc());
                cont++;
            }
            ps.setInt(cont, p.getIdProduto());
            
            return ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }

    public Integer excluir(Produto p) throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            conn = ConnectionDAO.getConnection();
            String sql = "DELETE produto WHERE idProduto=?";
            
            ps.setInt(1,  p.getIdProduto());
            
            return ps.executeUpdate();

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps);
        }
    }
    
    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listaTodos() throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        List<Produto> lista = new ArrayList<>();
        try {
            conn = ConnectionDAO.getConnection();
            ps = conn.prepareStatement("SELECT * FROM produto ORDER BY produtoNm");
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Produto(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }

        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            ConnectionDAO.closeConnection(conn, ps, rs);
        }
        return lista;
    }

    @Override
    public List procura(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void salvar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
