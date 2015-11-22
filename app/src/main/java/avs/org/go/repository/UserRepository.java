package avs.org.go.repository;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import avs.org.go.db.DataBase;
import avs.org.go.dominio.User;


/**
 * Created by venancio.junior on 27/10/2015.
 */
public class UserRepository extends DataBase {


    public UserRepository(Context context) {
        super(context);
    }

    public List<User> getUser(){

        List<User> userList = new ArrayList<>();

        String[] columns = {USER_COLUMN_COUNTRY_CODE, USER_COLUMN_COUNTRY_NAME, USER_COLUMN_EMAIL,
                USER_COLUMN_IMAGE_PATH, USER_COLUMN_IMEI, USER_COLUMN_NOME, USER_COLUMN_PHONE, USER_COLUMN_SERIAL_SIM};

        Cursor cursor = this.getReadableDatabase().query(TABLE_NAME, columns, null, null, null, null, null);

        while(cursor.moveToNext()){
            User u = new User();
            userList.add(u);
        }

        return userList;

    }

    public void addUser(User user){
        String sql = "INSERT INTO USER(" + USER_COLUMN_COUNTRY_CODE + ", " + USER_COLUMN_COUNTRY_NAME + ")" +
                " values (  '" + user.getCountryCode() + "', '" + user.getCountryName() + "')";
        this.getWritableDatabase().execSQL(sql);
    }

}
