package avs.org.go.Controller;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import avs.org.go.api.ApiCountry;
import avs.org.go.dominio.Country;
import avs.org.go.dominio.Device;
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
    public static final String API = "http://192.168.25.221:8888/retrofit-example/";

    private ApiCountry countryAPI;

    public CountryController(){

        Gson gson = new GsonBuilder().registerTypeAdapter(Country.class, new CountryDeserializer()).create();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        countryAPI = retrofit.create(ApiCountry.class);
    }

    public Country getCountry(Device device) {

        final Country[] country = {new Country()};

        Call<Country> call = countryAPI.getCountry("one-country",device.getCountryCodeSim());
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Response<Country> response, Retrofit retrofit) {
                country[0] = response.body();
                if (country[0] != null) {
                    //tvData.setText(Html.fromHtml( "Model: "+c.getName()+"<br>Brand: "+c.getBrand().getName()+"<br>Engine: "+c.getEngine().getStrength() ) );
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Error ONE COUNTRY: " + t.getMessage());
            }
        });

        return country[0];
    }

}
