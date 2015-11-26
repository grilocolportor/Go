package avs.org.go.Controller;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import avs.org.go.api.ApiUser;
import avs.org.go.dominio.Country;
import avs.org.go.dominio.Device;
import avs.org.go.dominio.User;
import avs.org.go.dominio.UserWrapRequest;
import avs.org.go.repository.UserRepository;
import avs.org.go.util.Constantes;
import avs.org.go.util.CountryDeserializer;
import avs.org.go.util.UserDeserializer;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by venancio.junior on 26/11/2015.
 */
public class UserController {

    public static final String TAG = "LOG";
    public static final String API = Constantes.URL_JOB;

    private ApiUser userAPI;


    private Context context;

    public UserController(Context context){

        this.context = context;
    }

    public void findUser(Device device, final Activity activity) {

        Gson gson = new GsonBuilder().registerTypeAdapter(User.class, new UserDeserializer()).create();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        userAPI = retrofit.create(ApiUser.class);

        Call<User> call = userAPI.getUser("one-user");
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {

                User u = response.body();

                /*TextView lblCountry = (TextView) activity.findViewById(R.id.lblCountry);
                lblCountry.setText(c.getShort_name() + " +" + c.getCalling_code());

                Log.i(TAG, "Country1: " + c.getShort_name() + " +" + c.getCalling_code());*/


                UserRepository userRepository = new UserRepository(context);
                userRepository.addUser(u);


            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Error ONE USER: " + t.getMessage());
            }
        });

    }

    public void saveUser(User user){

        UserWrapRequest userWrapRequest = new UserWrapRequest( "save-car", user );

        Call<User> call = userAPI.saveUser(userWrapRequest);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Error SAVE USER: " + t.getMessage());
            }
        });


    }

}
