package signup.com.loginsignup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class NewContact extends AppCompatActivity {
    DatabaseHelper db;
    SQLiteDatabase sqlLiteDatabase;
    private String viewContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        db=new DatabaseHelper(this);
    }
    public void viewContact(View view){
Cursor isretrived=db.fetchAllcontact();
    if(isretrived.equals(true)){
        Toast.makeText(this, "retrived", Toast.LENGTH_SHORT).show();}
    else{
            Toast.makeText(this, "not retrived", Toast.LENGTH_SHORT).show();
        }


    }
}
