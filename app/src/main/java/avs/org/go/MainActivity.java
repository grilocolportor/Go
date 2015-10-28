package avs.org.go;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

import avs.org.go.dominio.User;
import avs.org.go.repository.UserRepository;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent;

        UserRepository userRepository = new UserRepository(this);
        List<User> userList = userRepository.getUser();
        if(userList.isEmpty()){
            intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        }else{
            intent = new Intent(this, GoActivity.class);
            startActivity(intent);
        }
    }
}
