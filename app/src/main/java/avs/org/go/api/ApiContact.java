package avs.org.go.api;

import avs.org.go.dominio.Contact;
import avs.org.go.dominio.Country;
import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by venancio.junior on 18/12/2015.
 */
public interface ApiContact {

    @FormUrlEncoded
    @POST("package/ctrl/CtrlCountry.php")
    Call<Contact> getContact( @Field("method") String method, @Field("phone") String codContact);

}
