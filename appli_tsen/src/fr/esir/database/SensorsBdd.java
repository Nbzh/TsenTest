package fr.esir.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.example.esir.nsoc2014.tsen.lob.objects.ArffGenerated;
import fr.esir.maintasks.MyActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nicolas on 14/02/2015.
 */
public class SensorsBdd {
    private MySQLiteHelper dbHelper;
    private SQLiteDatabase database;

    public SensorsBdd(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public SQLiteDatabase getBDD() {
        return database;
    }

    public long insertDataSensors(String table_name, String data) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(MySQLiteHelper.COLUMN_TIME, System.currentTimeMillis());
        values.put(MySQLiteHelper.COLUMN_DATA, data);
        //on insère l'objet dans la BDD via le ContentValues
        return database.insert(table_name, null, values);
    }

    public long insertDataVote(String user, String data, String hum_in, String hum_ou, String temp_in, String temp_ou, String lum_ou) {
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
        values.put(MySQLiteHelper.COLUMN_TIME, System.currentTimeMillis());
        if (tabVote.isEmpty())
            addInList();
        if (tabVote.contains(data))
            values.put(MySQLiteHelper.COLUMN_DATA, data);
        else
            values.put(MySQLiteHelper.COLUMN_DATA, "*");
        values.put(MySQLiteHelper.COLUMN_HUM_IN, hum_in);
        values.put(MySQLiteHelper.COLUMN_HUM_OU, hum_ou);
        values.put(MySQLiteHelper.COLUMN_TEMP_IN, temp_in);
        values.put(MySQLiteHelper.COLUMN_TEMP_OU, temp_ou);
        values.put(MySQLiteHelper.COLUMN_LUM_OU, lum_ou);
        values.put(MySQLiteHelper.COLUMN_USER, user);
        //on insère l'objet dans la BDD via le ContentValues
        return database.insert(MySQLiteHelper.TABLE_USER_VOTE, null, values);
    }

    public ArffGenerated getData4Arff(ArffGenerated arff, String user) {
        String selectQuery = "SELECT * FROM " + MySQLiteHelper.TABLE_USER_VOTE
                + " WHERE " + MySQLiteHelper.COLUMN_USER + " = " + user;
        open();
        Cursor cursor = database.rawQuery(selectQuery, null);
        int i = 0;
        if (cursor.moveToFirst()) {
            do {
                i += 1;
                double temp_in = correctValueTemp(cursor.getString(4), cursor.getString(0));
                arff.addDataCustom(Double.parseDouble(cursor.getString(3)),
                        Double.parseDouble(cursor.getString(5)), temp_in, Double.parseDouble(cursor.getString(6)));
            } while (cursor.moveToNext());
            if (i < 10)
                arff.addDataGeneric();
        } else
            arff.addDataGeneric();
        close();
        return arff;
    }

    private ArrayList tabVote = new ArrayList();

    private void addInList() {
        tabVote.add("++");
        tabVote.add("+");
        tabVote.add("*");
        tabVote.add("-");
        tabVote.add("--");
    }

    private double correctValueTemp(String value, String vote) {
        double val = Double.parseDouble(value);
        switch (vote) {
            case "++":
                val = val - 1;
                break;
            case "+":
                val = val - 0.5;
                break;
            case "-":
                val = val + 0.5;
                break;
            case "--":
                val = val + 1;
                break;
        }
        return val;
    }
}
