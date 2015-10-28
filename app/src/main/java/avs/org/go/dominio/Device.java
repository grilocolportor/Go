package avs.org.go.dominio;

/**
 * Created by venancio.junior on 28/10/2015.
 */
public class Device {

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

    public String getCountryCodeSim() {
        return countryCodeSim;
    }

    public void setCountryCodeSim(String countryCodeSim) {
        this.countryCodeSim = countryCodeSim;
    }

    private String phone;
    private String imei;
    private String serialSim;
    private String countryCodeSim;


}
