package signup.com.loginsignup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Data_list_Activity extends AppCompatActivity {
    private String fetchAllcontact;
    private String ListView;
    // private LoginSignupDbAdapter dbHelper;
    //private SimpleCursorAdapter dataAdapter;
    DatabaseHelper db;
    SQLiteDatabase sqlLiteDatabase;
    private String displayList;
    private String Insertcontact;
    android.widget.ListView listview;
    Cursor cursor;
    android.widget.ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        listview=(ListView)findViewById(R.id.list1);
        db= new DatabaseHelper(getApplicationContext());
        sqlLiteDatabase = db.getReadableDatabase();
        cursor = db.fetchAllcontact();
        listAdapter=new signup.com.loginsignup.ListAdapter(getApplicationContext(),R.layout.layout);
        listview.setAdapter(listAdapter);
        if (cursor.moveToFirst()) {
            do {
                String name1, email;
                name1 = cursor.getString(0);
                email = cursor.getString(1);
                Contact c = new Contact();
                c.getFname();
                c.getEmail();
            }
            while (cursor.moveToFirst());

        }
    }}



