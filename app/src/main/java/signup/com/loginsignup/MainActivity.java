package signup.com.loginsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {/*mplements LoaderManager.LoaderCallbacks<Cursor>{
    private SignupCursorAdapter cursorAdapter;

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;
    }

    private static final String AUTHORITY = "com.androidtutorialpoint.mycontacts";
    private static final String BASE_PATH = "contacts";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

    // Constant to identify the requested operation
    private static final int CONTACTS = 1;
    private static final int CONTACT_ID = 2;

        private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        static {
        uriMatcher.addURI(AUTHORITY,BASE_PATH, CONTACTS);
        uriMatcher.addURI(AUTHORITY,BASE_PATH + "/#",CONTACT_ID);
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
      /*  SignupCursorAdapter cursorAdapter = new SignupCursorAdapter(this, null, 0);
        ListView list = (ListView) findViewById(android.R.id.list);
        list.setAdapter(cursorAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getLoaderManager().initLoader(0, null, this);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartLoader();
            }
        });

        }



    private void restartLoader(){
        getLoaderManager().restartLoader(0,null,this);
    }



    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
      cursorAdapter.swapCursor(cursor);

    }
    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        cursorAdapter.swapCursor(null);
    }
*/

/*getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.activity_main);


*/}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            switch(item.getItemId()) {
                case R.id.Login:{
                    Intent intent = new Intent(this, LoginActivity.class);
                    this.startActivity(intent);
                    break;}
                case R.id.SignUp:{
                    // another startActivity, this is for item with id "menu_item2"
                    Intent intent1 = new Intent(this, RegisterActivity.class);
                    this.startActivity(intent1);
                    break;}
                default:
                    return super.onOptionsItemSelected(item);
            }

            return true;
        }}









