package fr.esir.knx;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

/**
 * Created by Nicolas on 13/02/2015.
 */
public class AsynchKNX extends AsyncTask<CaliConnection, Void, Boolean> {

    @Override
    protected Boolean doInBackground(CaliConnection... params) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        CaliConnection cc = params[0];
        if (cc.connectToEIBD())
            return true;
        else
            return false;
    }

    @Override
    protected void onPostExecute(Boolean bool){
        if(bool)
            Log.w("KNX State", "connected");
        else Log.w("KNX State", "disconnected");
    }
}
