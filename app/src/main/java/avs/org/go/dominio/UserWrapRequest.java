package avs.org.go.dominio;

/**
 * Created by venancio.junior on 26/11/2015.
 */
public class UserWrapRequest {
    private String method;
    private User user;


    public UserWrapRequest() {}

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

    public User getCar() {
        return user;
    }

    public void setCar(User user) {
        this.user = user;
    }
}
