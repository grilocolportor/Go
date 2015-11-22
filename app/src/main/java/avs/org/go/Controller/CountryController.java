package avs.org.go.Controller;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import avs.org.go.R;
import avs.org.go.api.ApiCountry;
import avs.org.go.dominio.Country;
import avs.org.go.dominio.Device;
import avs.org.go.dominio.User;
import avs.org.go.repository.UserRepository;
import avs.org.go.util.CountryDeserializer;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by venancio.junior on 29/10/2015.
 */
public class CountryController {

    public static final String TAG = "LOG";
    public static final String API = "http://192.168.1.9:88/GoWebService/";

    private ApiCountry countryAPI;

    private String countryShortName;
    private Country country;

    private Context context;

    public CountryController(Context context){

        this.context = context;
    }

    public void findCountry(Device device, final Activity activity) {


        Gson gson = new GsonBuilder().registerTypeAdapter(Country.class, new CountryDeserializer()).create();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        countryAPI = retrofit.create(ApiCountry.class);

        // ApiCountry countryAPI = new RestAdapter.Builder();

        Call<Country> call = countryAPI.getCountry("one-country");
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Response<Country> response, Retrofit retrofit) {
                Country c = response.body();
                setCountry(c);
                // if (c != null) {
                // country.setShort_name(c.getShort_name());
                TextView lblCountry = (TextView) activity.findViewById(R.id.lblCountry);
                lblCountry.setText(country.getShort_name() + " +" + c.getCalling_code());
                countryShortName = country.getShort_name();
                Log.i(TAG, "Country1: " + c.getShort_name() + " +" + c.getCalling_code());

                User user = new User();
                user.setCountryCode(c.getCalling_code());
                user.setCountryName(c.getShort_name());
                UserRepository userRepository = new UserRepository(context);
                userRepository.addUser(user);

                //tvData.setText(Html.fromHtml( "Model: "+c.getName()+"<br>Brand: "+c.getBrand().getName()+"<br>Engine: "+c.getEngine().getStrength() ) );
                //  }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Error ONE COUNTRY: " + t.getMessage());
            }
        });
    }



    public Country getCountry(){
        return country;
    }

    public void setCountry(Country c){
        this.country = c;
    }

    public String getCountryShortName(){
        return this.countryShortName;
    }

}
