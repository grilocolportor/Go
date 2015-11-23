package avs.org.go.repository;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import avs.org.go.db.DataBase;
import avs.org.go.dominio.Country;
import avs.org.go.dominio.User;

/**
 * Created by venancio.junior on 23/11/2015.
 */
public class CountryRespository extends DataBase {

    public CountryRespository(Context context){
        super(context);
    }

    public void addCountry(Country country){
        String sql = "INSERT INTO " + COUNTRY_TABLE  + " (" + COUNTRY_COLUMN_CODE + ", " + COUNTRY_COLUMN_NAME + ", " +
                    COUNTRY_COLUMN_PHONE_MIN + ", " + COUNTRY_COLUMN_PHONE_MAX + ")" +
                " values (  '" + country.getCountry_id() + "', '" + country.getLong_name() + "', '" +
                country.getPhone_min() + "', '" + country.getPhone_max() + "' )";
        this.getWritableDatabase().execSQL(sql);
    }

    public List<Country> getCountry() {

        List<Country> countryList = new ArrayList<>();

        String[] columns = {COUNTRY_COLUMN_CODE, COUNTRY_COLUMN_NAME, COUNTRY_COLUMN_PHONE_MIN, COUNTRY_COLUMN_PHONE_MAX};

        Cursor cursor = this.getReadableDatabase().query(COUNTRY_TABLE, columns, null, null, null, null, null);

        if(cursor.getCount()!=0) {
            while (cursor.moveToNext()) {
                Country c = new Country();
               // c.setCountry_id(Integer.parseInt(cursor.getColumnName(cursor.getColumnIndex(COUNTRY_COLUMN_CODE))));
                c.setShort_name(cursor.getColumnName(cursor.getColumnIndex(COUNTRY_COLUMN_NAME)));
                c.setPhone_min(cursor.getColumnName(cursor.getColumnIndex(COUNTRY_COLUMN_PHONE_MIN)));
                c.setPhone_max(cursor.getColumnName(cursor.getColumnIndex(COUNTRY_COLUMN_PHONE_MAX)));
                countryList.add(c);
            }
        }

        return countryList;

    }



}
