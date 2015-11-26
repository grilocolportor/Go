package avs.org.go;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.List;

import avs.org.go.Controller.CountryController;
import avs.org.go.dominio.Country;
import avs.org.go.dominio.Device;
import avs.org.go.dominio.User;
import avs.org.go.repository.CountryRespository;
import avs.org.go.repository.UserRepository;


public class LoginActivity extends AppCompatActivity {

    public static final String TAG = "LOGIN";

    private EditText txtPhone;
    private EditText txtNome;
    private EditText txtEmail;

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
            txtNome = (EditText) findViewById(R.id.txtName);
            txtEmail = (EditText) findViewById(R.id.txtEmail);

            this.txtPhone.setText(device.getPhone());

            CountryController cc = new CountryController(this);
            cc.findCountry(device, this);
            //Country country = cc.getCountry();

          //  Log.i(TAG, "Country: " + cc.);

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

                String mensagem = validateField();
                if(mensagem==null){



                    Intent i = new Intent(this, LoginPhotoActivity.class);
                    startActivity(i);
                    this.finish();
                    return true;
                }else{
                    avs.org.go.util.System s = new avs.org.go.util.System();
                    s.showToast(this, mensagem);
                }
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private String validateField(){
        CountryRespository countryRepository = new CountryRespository(this);
        List<Country> countryList = countryRepository.getCountry();
        int min = 0;
        int max = 0;
        if(!countryList.isEmpty()) {
           min =  Integer.parseInt(countryList.get(0).getPhone_min());
           max = Integer.parseInt(countryList.get(0).getPhone_max());
        }
        if (this.txtPhone.getText() == null || this.txtPhone.getText().toString().isEmpty()) {
            return "Informe o numero do telefone!!";
        } else if (this.txtPhone.getText().length() <  min ||
                    this.txtPhone.getText().length() > max) {
            return "O tamanho do número não parece esta correto para sua região";
        } else if (this.txtNome.getText() == null || this.txtNome.getText().toString().isEmpty()) {
            return "Informe um nome!";
        } else {
            return null;
        }

    }
}
