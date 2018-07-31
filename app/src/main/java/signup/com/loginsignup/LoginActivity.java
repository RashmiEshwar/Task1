package signup.com.loginsignup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper helper = new DatabaseHelper(this);
    private EditText a3, u;
    private TextView email,Password;
Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        b = (Button) findViewById(R.id.Login);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Password = (TextView) findViewById(R.id.text_l2);
                email = (TextView) findViewById(R.id.txt_l1);

                if (view.getId() == R.id.Login) {
                    a3 = (EditText) findViewById(R.id.text1);
                    String str = a3.getText().toString();
                    EditText b3 = (EditText) findViewById(R.id.text2);
                    String pass = b3.getText().toString();
                    String password = helper.searchPass(str);
                    //Log.v("Pass",pass);
                    Log.v("Password",password);
                    Log.v("Pass",pass);
                    if (pass.equals(password)) {
                        Intent i = new Intent(LoginActivity.this, NewActivity.class);
                        i.putExtra("Username", str);
                        startActivity(i);

                    } else {
                        Toast.makeText(LoginActivity.this, "UnSuccessfull", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });
       /* a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (view.getId() == a3.getId()) {
                    a3.setCursorVisible(true);
                }
            }

        });*/

}}




