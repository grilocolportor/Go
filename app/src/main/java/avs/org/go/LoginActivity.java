package avs.org.go;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import avs.org.go.Controller.CountryController;
import avs.org.go.dominio.Country;
import avs.org.go.dominio.Device;


public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LOGIN";

    private EditText txtPhone;

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
            txtPhone = (EditText) findViewById(R.id.txtPhone);

            this.txtPhone.setText(device.getPhone());

            CountryController cc = new CountryController(this);
            cc.findCountry(device, this);
            //Country country = cc.getCountry();

            Log.i(TAG, "Country: " + cc.getCountryShortName());

           // TextView lblCountry = (TextView) findViewById(R.id.lblCountry);
           // lblCountry.setText(country.getShort_name());


        }else{

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_avancar:
                Intent i  = new Intent(this, LoginPhotoActivity.class);
                startActivity(i);
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
