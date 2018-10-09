package cms.ado;

import base.DAO;
import cms.model.Login;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tatuapu
 */
public class LoginADO implements DAO {

    @Override
    public void atualizar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listaTodos() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List procura(Object ob) throws Exception {
        Login login = (Login) ob;
        List<Login> ll = new ArrayList();
        if(login.getEmail().equals("email@email.com") & login.getPassword().equals("123")){
            login.setKey(10);
            ll.add(login);
        }            
        return ll;
    }

    @Override
    public void salvar(Object ob) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
