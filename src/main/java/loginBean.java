
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author amrkamran
 */
@ManagedBean
@RequestScoped
public class loginBean {
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
        // Check the username and password
        if (username.equals("admin") && password.equals("password")) {
            return "success";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR,
                "Invalid username or password",
                "Please try again"));
            return null;
        }
    }
}


