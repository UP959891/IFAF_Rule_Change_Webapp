import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class loginSignup implements Serializable {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        if (DBConnection.validateUser(username, password)) {
            // User is authenticated
            return "welcome";
        } else {
            // Invalid username or password
            return "fail";
        }
    }
}


