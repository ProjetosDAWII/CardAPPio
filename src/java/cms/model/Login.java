package cms.model;

/**
 *
 * @author tatuapu
 */
public class Login {
    private final String email;
    private final String password;
    private Integer key;
    private String nmUsuario;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    public Login(String email, String password, Integer key) {
        this.email = email;
        this.password = password;
        this.key = key;
    }
    public Login(String email, String password, Integer key, String nmUsuario) {
        this.email = email;
        this.password = password;
        this.key = key;
        this.nmUsuario = nmUsuario;
    }
    public void setNmUsuario(String nmUsuario){
        this.nmUsuario = nmUsuario;
    }
    public String getNmUsuario(){
        return this.nmUsuario;
    } 
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the key
     */
    public Integer getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(Integer key) {
        this.key = key;
    }
    
}
