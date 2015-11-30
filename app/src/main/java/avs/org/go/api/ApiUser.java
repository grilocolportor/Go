package avs.org.go.api;

import avs.org.go.dominio.Country;
import avs.org.go.dominio.User;
import avs.org.go.dominio.UserWrapRequest;
import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by venancio.junior on 26/11/2015.
 */
public interface ApiUser {

    /*@POST("package/ctrl/CtrlUser.php")
    Call<User> saveUser(@Body UserWrapRequest wrapRequest);*/


    @FormUrlEncoded
    @POST("package/ctrl/CtrlCar.php")
    Call<User> saveUser( @Field("method") String method, @Field("user") String userJson);

    @FormUrlEncoded
    @POST("package/ctrl/CtrlUser.php")
    Call<User> getUser(@Field("method") String method);
}