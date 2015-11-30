package avs.org.go.dominio;

/**
 * Created by venancio.junior on 27/10/2015.
 */
public class User {

    private String phone;
    private String imei;
    private String serialSim;
    private String nome;
    private String email;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getSerialSim() {
        return serialSim;
    }

    public void setSerialSim(String serialSim) {
        this.serialSim = serialSim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
