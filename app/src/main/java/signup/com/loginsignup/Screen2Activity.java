package signup.com.loginsignup;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Screen2Activity extends AppCompatActivity {
private String screen2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("your title");
        alertDialog.setMessage("redBus.in is India's largest online bus ticketing platform, trusted by over 6 million Indians. With a sale of over 10,00,00,000 Bus tickets via web, mobile, and our bus agents, redBus stands at the top of the game in bus ticketing. redBus.in operates on over 84000 routes and is associated with 2300 reputed bus operators. Try the redBus experience today.\";");


        alertDialog.show();
    }
}
