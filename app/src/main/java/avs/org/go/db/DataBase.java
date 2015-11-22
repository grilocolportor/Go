package avs.org.go.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by venancio.junior on 27/10/2015.
 */
public class DataBase extends SQLiteOpenHelper {

    private static final String DATA_BASE_NAME = "Go";
    private static final int DATA_BASE_VERSION = 1;

    public static final String TABLE_NAME = "USER";
    public static final String USER_COLUMN_PHONE = "PHONE";
    public static final String USER_COLUMN_COUNTRY_CODE = "COUNTRY_CODE";
    public static final String USER_COLUMN_COUNTRY_NAME = "COUNTRY_NAME";
    public static final String USER_COLUMN_IMEI = "IMEI";
    public static final String USER_COLUMN_SERIAL_SIM = "SERIAL_SIM";
    public static final String USER_COLUMN_NOME = "NOME";
    public static final String USER_COLUMN_EMAIL = "EMAIL";
    public static final String USER_COLUMN_IMAGE_PATH = "IMAGE_PATH";
    private static final String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_NAME + " (" +
            USER_COLUMN_PHONE + " VARCHAR(20), " +
            USER_COLUMN_COUNTRY_CODE + " VARCHAR(4), " +
            USER_COLUMN_COUNTRY_NAME + " VARCHAR(50), " +
            USER_COLUMN_IMEI + " VARCHAR(50), " +
            USER_COLUMN_SERIAL_SIM + " VARCHAR(50), " +
            USER_COLUMN_NOME  + " VARCHAR(50), " +
            USER_COLUMN_EMAIL + " VARCHAR(50), " +
            USER_COLUMN_IMAGE_PATH + " VARCHAR(50))";

    public DataBase(Context context) {
        super(context, DATA_BASE_NAME, null, DATA_BASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE ID EXISTS " + TABLE_NAME) ;
        onCreate(db);
    }
}
