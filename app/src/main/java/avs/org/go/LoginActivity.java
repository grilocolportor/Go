package avs.org.go;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import avs.org.go.Controller.CountryController;
import avs.org.go.dominio.Country;
import avs.org.go.dominio.Device;


public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LOGIN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /**IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

        Internet internet = new Internet();

        registerReceiver(internet, filter);

        boolean internetStatus = internet.getStatus();**/

        boolean netWorkStatus = avs.org.go.util.System.isNetConnected(this);

        if(netWorkStatus) {

            Device device = avs.org.go.util.System.getDevice(this);

            CountryController cc = new CountryController();
            cc.findCountry(device, this);
            //Country country = cc.getCountry();

            Log.i(TAG, "Country: " + cc.getCountryShortName());

           // TextView lblCountry = (TextView) findViewById(R.id.lblCountry);
           // lblCountry.setText(country.getShort_name());


        }else{

        }


    }
}
