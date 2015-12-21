package avs.org.go.repository;

import android.content.Context;

import avs.org.go.db.DataBase;
import avs.org.go.dominio.Contact;

/**
 * Created by venancio.junior on 18/12/2015.
 */
public class ContactRepository extends DataBase {


    public ContactRepository(Context context) {
        super(context);
    }

    public void addContact(Contact contact){

        String sql = "INSERT INTO CONTACT(" + CONTACT_COLUMN_NAME + ", " + CONTACT_COLUMN_PHONE + ")" +
                " values (  '" + contact.getName() + "', '" + contact.getPhone() + "')";
        this.getWritableDatabase().execSQL(sql);

    }
}