package avs.org.go;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import avs.org.go.dominio.Device;
import avs.org.go.util.Internet;

public class LoginActivity extends AppCompatActivity {

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
        }else{

        }


    }
}
