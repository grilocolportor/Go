package avs.org.go.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by venancio.junior on 04/01/2016.
 */
public class BroadcastServico extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("Script", "onReceive()");
        intent = new Intent("INICIANDO_SERVICE");
        context.startService(intent);
    }
}
