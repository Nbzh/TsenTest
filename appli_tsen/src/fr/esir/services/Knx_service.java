package fr.esir.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import fr.esir.knx.AsynchKNX;
import fr.esir.knx.CaliConnection;
import fr.esir.ressources.FilterString;
import knx.Reference;
import knx.Service_knx;

public class Knx_service extends Service implements Service_knx {
    private final IBinder mBinder = new LocalBinder();
    CaliConnection cc = new CaliConnection(this);

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        System.out.println("UNBIND");
        closeConnectionKnx();
        return super.onUnbind(intent);
    }

    public void closeConnectionKnx(){
        cc.CloseConnection();
    }

    public class LocalBinder extends Binder {
        public Knx_service getService() {
            return Knx_service.this;
        }
    }

    public boolean initialize() {
        AsynchKNX aknx = new AsynchKNX();
        aknx.execute(cc);
        return true;
    }

    private void broadcastUpdate(final String action) {
        final Intent intent = new Intent(action);
        sendBroadcast(intent);
    }

    public void sendDisplayData(String add, String data){
        final Intent intent = new Intent(FilterString.RECEIVE_DATA_KNX);
        intent.putExtra("DATA",data);
        intent.putExtra("ADDRESS",add);
        sendBroadcast(intent);
    }
}
