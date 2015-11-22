package avs.org.go.api;

import avs.org.go.dominio.Country;
import retrofit.Call;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by venancio.junior on 30/10/2015.
 */
public interface ApiCountry {

    @FormUrlEncoded
    @POST("package/ctrl/CtrlCountry.php")
    Call<Country> getCountry( @Field("method") String method);

}
