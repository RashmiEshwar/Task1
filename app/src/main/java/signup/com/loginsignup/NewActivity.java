package signup.com.loginsignup;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class NewActivity extends AppCompatActivity {
    private String fetchAllcontact;
    private String ListView;
    // private LoginSignupDbAdapter dbHelper;
    //private SimpleCursorAdapter dataAdapter;
    DatabaseHelper db;
    SQLiteDatabase sqlLiteDatabase;
    private String displayList;
    private String Insertcontact;
    ListView listview;
    Cursor cursor;
    ListAdapter listAdapter;
Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_new);
        b2 = (Button) findViewById(R.id.button2);
        b2.setOnClickListener(new View.OnClickListener() {

            // Setting Positive "Yes" But

            @Override
            public void onClick(View v) {
                showContact(v);

            }
        });





/*
        Cursor cursor = dbHelper.fetchAllcontact();
        dbHelper = new DatabaseHelper(NewActivity.this);
        displayList();
    }

    public void displayList(){
        db.InsertValues();
        Cursor cursor=db.GetAllData();
        String from [] = new String[]{db.colName};
        int to [] = new int[] {R.id.textView1};
        dataAdapter = new SimpleCursorAdapter(this, R.layout.row_item, cursor, from, to, 0);
        db.close();

        ListView lv = getListView();
        lv.setAdapter(dataAdapter);
    }
}
    Series Navi

        // The desired columns to be bound


*/


/*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_main);*/
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Logout:
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }


    public void showContact(View view) {
        Intent intent = new Intent(getApplicationContext(), Data_list_Activity.class);
        startActivity(intent);
    }
}
  /*  public void displayList() {
        Contact c=new Contact();
        db.insertcontact(c);
        Cursor cursor = db.fetchAllcontact();
        String from[] = new String[]{db.COLUMN_FNAME, db.COLUMN_EMAIL};
        int to[] = new int[]{R.id.textView1, R.id.textView2};
        dataAdapter = new SimpleCursorAdapter(this, R.layout.layout, cursor, from, to, 0);
        db.close();

        ListView lv = getListView();
        lv.setAdapter(dataAdapter);
    }*/




