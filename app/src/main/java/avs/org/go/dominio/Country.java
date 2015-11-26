package avs.org.go.dominio;

/**
 * Created by venancio.junior on 29/10/2015.
 */
public class Country {

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }

    public String getLong_name() {
        return long_name;
    }

    public void setLong_name(String long_name) {
        this.long_name = long_name;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    public String getNumcode() {
        return numcode;
    }

    public void setNumcode(String numcode) {
        this.numcode = numcode;
    }

    public String getUn_memmber() {
        return un_memmber;
    }

    public void setUn_memmber(String un_memmber) {
        this.un_memmber = un_memmber;
    }

    public String getCalling_code() {
        return calling_code;
    }

    public void setCalling_code(String calling_code) {
        this.calling_code = calling_code;
    }

    public String getCctld() {
        return cctld;
    }

    public void setCctld(String cctld) {
        this.cctld = cctld;
    }

    public String getPhone_min() {
        return phone_size_min;
    }

    public void setPhone_min(String phone_size_min) {
        this.phone_size_min = phone_size_min;
    }

    public String getPhone_max() {
        return phone_size_max;
    }

    public void setPhone_max(String phone_size_max) {
        this.phone_size_max = phone_size_max;
    }

    private int country_id;
    private String iso2;
    private String short_name;
    private String long_name;
    private String iso3;
    private String numcode;
    private String un_memmber;
    private String calling_code;
    private String cctld;
    private String phone_size_min;
    private String phone_size_max;


}
