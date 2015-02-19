package fr.esir.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Nicolas on 13/02/2015.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String TABLE_TEMP_IN = "tempIn";
    public static final String TABLE_TEMP_OU = "tempOu";
    public static final String TABLE_HUM_IN = "humIn";
    public static final String TABLE_HUM_OU = "humOu";
    public static final String TABLE_LUM_OU = "lumOu";
    public static final String TABLE_CO2_IN = "co2In";
    public static final String TABLE_USER_VOTE = "userVote";

    public static final String COLUMN_TIME = "timestamp";
    public static final String COLUMN_DATA = "data";
    public static final String COLUMN_USER = "userId";
    public static final String COLUMN_HUM_IN = "humIn";
    public static final String COLUMN_HUM_OU = "humOu";
    public static final String COLUMN_LUM_OU = "lumOu";
    public static final String COLUMN_TEMP_OU = "tempOu";
    public static final String COLUMN_TEMP_IN = "tempIn";

    private static final String DATABASE_NAME = "knxData.db";
    private static final int DATABASE_VERSION = 1;

    public MySQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String DATABASE_CREATE_TEMP_IN = "create table "
            + TABLE_TEMP_IN + "(" + COLUMN_TIME
            + " BIGINT primary key, " + COLUMN_DATA
            + " TEXT not null);";

    private static final String DATABASE_CREATE_TEMP_OU = "create table "
            + TABLE_TEMP_OU + "(" + COLUMN_TIME
            + " BIGINT primary key, " + COLUMN_DATA
            + " TEXT not null);";

    private static final String DATABASE_CREATE_HUM_IN = "create table "
            + TABLE_HUM_IN + "(" + COLUMN_TIME
            + " BIGINT primary key, " + COLUMN_DATA
            + " TEXT not null);";

    private static final String DATABASE_CREATE_HUM_OU = "create table "
            + TABLE_HUM_OU + "(" + COLUMN_TIME
            + " BIGINT primary key, " + COLUMN_DATA
            + " TEXT not null);";

    private static final String DATABASE_CREATE_LUM_OU = "create table "
            + TABLE_LUM_OU + "(" + COLUMN_TIME
            + " BIGINT primary key, " + COLUMN_DATA
            + " TEXT not null);";

    private static final String DATABASE_CREATE_CO2 = "create table "
            + TABLE_CO2_IN + "(" + COLUMN_TIME
            + " BIGINT primary key, " + COLUMN_DATA
            + " TEXT not null);";

    private static final String DATABASE_CREATE_USER_VOTE = "create table "
            + TABLE_USER_VOTE + "(" + COLUMN_DATA
            + " TEXT not null, " + COLUMN_USER
            + "TEXT not null, " + COLUMN_HUM_IN
            + "TEXT not null, " + COLUMN_HUM_OU
            + "TEXT not null, " + COLUMN_TEMP_IN
            + "TEXT not null, " + COLUMN_TEMP_OU
            + "TEXT not null, " + COLUMN_LUM_OU
            + "TEXT not null);";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_TEMP_IN);
        db.execSQL(DATABASE_CREATE_TEMP_OU);
        db.execSQL(DATABASE_CREATE_HUM_IN);
        db.execSQL(DATABASE_CREATE_HUM_OU);
        db.execSQL(DATABASE_CREATE_LUM_OU);
        db.execSQL(DATABASE_CREATE_CO2);
        db.execSQL(DATABASE_CREATE_USER_VOTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEMP_IN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEMP_OU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HUM_IN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HUM_OU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LUM_OU);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CO2_IN);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER_VOTE);
        onCreate(db);
    }
}
