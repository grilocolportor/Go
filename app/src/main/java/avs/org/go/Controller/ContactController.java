package avs.org.go.Controller;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import avs.org.go.api.ApiContact;
import avs.org.go.dominio.Contact;
import avs.org.go.repository.ContactRepository;
import avs.org.go.util.Constantes;
import avs.org.go.util.ContactDeserializer;
import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by venancio.junior on 18/12/2015.
 */
public class ContactController {

    public static final String TAG = "LOG";
    public static final String API = Constantes.URL_JOB;

    private ApiContact contactApi;
    private Context context;

    public ContactController(Context context){
        this.context = context;
    }

    public void findRemoteContact(List<Contact> contactList){
        for(Contact contact : contactList){
            findContact(contact);
        }
    }

    public void findContacts(List<Contact> contact) {

        Gson gson = new GsonBuilder().registerTypeAdapter(Contact.class,new ContactDeserializer() ).create();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        contactApi = retrofit.create(ApiContact.class);

        Call<Contact> call = contactApi.getContact("save-contacts", new Gson().toJson(contact));
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Response<Contact> response, Retrofit retrofit) {}
            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Error SAVE CONTACTS: " + t.getMessage());
            }
        });
    }


    public void findContact(Contact contact) {

        Gson gson = new GsonBuilder().registerTypeAdapter(Contact.class, new ContactDeserializer()).create();

        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(API)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        contactApi = retrofit.create(ApiContact.class);

        Call<Contact> call = contactApi.getContact("one-contact", contact.getPhone());
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Response<Contact> response, Retrofit retrofit) {

                Contact c = response.body();

                if(c.getPhone()!=null &&  !c.getPhone().isEmpty()){
                    ContactRepository cr = new ContactRepository(context);
                    cr.addContact(c);
                }




            }

            @Override
            public void onFailure(Throwable t) {
                Log.i(TAG, "Error ONE CONTACT: " + t.getMessage());
            }
        });

    }


}
