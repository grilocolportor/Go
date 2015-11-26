package avs.org.go.dominio;

/**
 * Created by venancio.junior on 27/10/2015.
 */
public class User {

    private String phone;
    private String countryCode;
    private String imei;
    private String serialSim;
    private String nome;
    private String email;
    private String imagePath;
    private String countryName;
    private String phone_min;
    private String phone_max;

    public String getPhone_max() {
        return phone_max;
    }

    public void setPhone_max(String phone_max) {
        this.phone_max = phone_max;
    }

    public String getPhone_min() {
        return phone_min;
    }

    public void setPhone_min(String phone_min) {
        this.phone_min = phone_min;
    }


    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
