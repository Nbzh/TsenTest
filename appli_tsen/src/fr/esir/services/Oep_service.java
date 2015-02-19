package fr.esir.services;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.example.esir.nsoc2014.tsen.lob.interfaces.OnSearchCompleted;
import com.example.esir.nsoc2014.tsen.lob.interfaces.Prevision;
import com.example.esir.nsoc2014.tsen.lob.interfaces.Service_oep;
import fr.esir.maintasks.ConfigParams;
import fr.esir.oep.*;
import fr.esir.ressources.FilterString;

import java.io.IOException;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class Oep_service extends Service implements OnSearchCompleted, Service_oep {
    private final IBinder mBinder = new LocalBinder();
    //private AlarmManager am;
    private RepetetiveTask rt;
    private Context context = ConfigParams.context;

    private Prevision db;

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        //am = null;
        rt.getScheduler().shutdown();
        rt = null;
        return super.onUnbind(intent);
    }

    public class LocalBinder extends Binder {
        public Oep_service getService() {
            return Oep_service.this;
        }
    }

    public boolean initialize() {
        SharedPreferences sh = context.getSharedPreferences("APPLI_TSEN", Context.MODE_PRIVATE);
        //oep alarm manager
        //create new calendar instance
        Log.w("predictinitalarm", "ok");

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 1);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        long howMany = c.getTimeInMillis() - System.currentTimeMillis();
        Log.w("DELAY", sh.getLong("DELAY", howMany) + "");
        rt = new RepetetiveTask(sh.getLong("DELAY", howMany), RepetetiveTask.ACTION_PREDICT);
        //long firstDelay =
         /*am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        //create a pending intent to be called at midnight
        Intent sixI = new Intent(this, PredictBroadcastReceiver.class);
        PendingIntent sixAMPI = PendingIntent.getBroadcast(this, 0, sixI, PendingIntent.FLAG_UPDATE_CURRENT);
        //schedule time for pending intent, and set the interval to day so that this event will repeat at the selected time every day
        am.setRepeating(AlarmManager.RTC_WAKEUP, sixAMCalendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, sixAMPI);*/
        return true;
    }

    private void broadcastUpdate(final String action) {
        final Intent intent = new Intent(action);
        sendBroadcast(intent);
    }

    private void broadcastUpdate(final String action, String key, Bundle data) {
        final Intent intent = new Intent(action);
        intent.putExtra(key, data);
        sendBroadcast(intent);
    }

    public void weatherSearch() throws IOException {
        Log.w("weathersearch", "OK");
        AsynchWeather task = new AsynchWeather(this);
        // System.out.println(retSrc);
        task.execute();
    }

    public void predict() {
        AsynchDB asynbd = new AsynchDB(this);
        asynbd.execute();
    }

    @Override
    public void onSearchCompleted(boolean o) {
        if (o) {
            try {
                predict();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else
            Log.e("OEP", "No WeatherForecast");
    }

    @Override
    public void onSearchCompleted(ResultSet o) {
        try {
            db.predictNext(o);
            Bundle extras = new Bundle();
            extras.putSerializable("HashMap", db.getHashmap());
            broadcastUpdate(FilterString.OEP_DATA_STUDENTS_OF_DAY, "Data", extras);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSearchCompleted(String weath) {
        db.getWeatherForecast().searchDone(weath);
    }

    @Override
    public void onSearchCompleted() {
        Log.w("oep", "onsearchcomleted");
        Bundle extras = new Bundle();
        extras.putSerializable("List", (Serializable) db.getList());
        broadcastUpdate(FilterString.OEP_DATA_CONSIGNES_OF_DAY, "Data", extras);
    }

    public void startPrediction() throws IOException {
        db = new DatabaseRegression(this);
        weatherSearch();
    }
}
