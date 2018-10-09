package cms.model;

/**
 *
 * @author tatuapu
 */
public class Login {
    private final String email;
    private final String password;
    private Integer key;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public Login(String email, String password, Integer key) {
        this.email = email;
        this.password = password;
        this.key = key;
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
