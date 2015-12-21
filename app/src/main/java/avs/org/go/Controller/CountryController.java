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
import avs.org.go.repository.CountryRespository;
import avs.org.go.repository.UserRepository;
import avs.org.go.util.Constantes;
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
    public static final String API = Constantes.URL_JOB;

    private ApiCountry countryAPI;


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

        Call<Country> call = countryAPI.getCountry("one-country", device.getCountryCodeSim() );
        call.enqueue(new Callback<Country>() {
            @Override
            public void onResponse(Response<Country> response, Retrofit retrofit) {

                Country c = response.body();

                TextView lblCountry = (TextView) activity.findViewById(R.id.lblCountry);
                TextView lblCode = (TextView) activity.findViewById(R.id.lblCountryCode);
                lblCountry.setText(c.getShort_name() );
                lblCode.setText(c.getCalling_code());
                Log.i(TAG, "Country: " + c.getShort_name() + " +" + c.getCalling_code());


                CountryRespository countryRepository = new CountryRespository(context);
                countryRepository.addCountry(c);


            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Error ONE COUNTRY: " + t.getMessage());
            }
        });

    }

}
