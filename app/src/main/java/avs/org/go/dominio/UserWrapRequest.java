package avs.org.go.dominio;

/**
 * Created by venancio.junior on 26/11/2015.
 */
public class UserWrapRequest {
    private String method;
    private User user;

    public UserWrapRequest(String method, User user) {
        this.method = method;
        this.user = user;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
