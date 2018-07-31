package signup.com.loginsignup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "contacts.db";
    public static final String TABLE_NAME = "contacts";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FNAME = "fname";
    public static final String COLUMN_LNAME = "lname";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_PASS = "pass";

    SQLiteDatabase db;
    public static final String[] ALL_COLUMNS =
            {COLUMN_ID, COLUMN_FNAME, COLUMN_EMAIL, COLUMN_PASS};


    private static final String TABLE_CREATE = "create table if not exists " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + " fname text not null, lname text not null, email text not null,pass text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;
    }

    public String searchPass(String estr) {
        db = this.getReadableDatabase();
        String query = "select email,pass from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "not found";
        if (cursor.moveToFirst()) {
            do {
                a = cursor.getString(0);
                Log.v("Email a", a);
                if (a.equals(estr)) {
                    b = cursor.getString(1);

                    break;
                }
            }
            while (cursor.moveToNext());
        }
        return b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        this.onCreate(db);
    }


    public Cursor fetchAllcontact() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select * from " + TABLE_NAME;
        Cursor c = db.rawQuery(query, null);
        return c;
    }

        /*(SQLITE_TABLE, new String[]{KEY_ROWID,
                KEY_CODE, KEY_NAME, KEY_CONTINENT, KEY_REGION},
                null, null, null, null, null);


        if (c.moveToFirst()) {
            do {
                // Passing values

                String column2 = c.getString(1);
                String column4 = c.getString(3);
                // Do something Here with values
                while (c.moveToNext()) ;
            }
            c.close();
        }*/

       /* Cursor mCursor = db.query(Cursor.contacts, new String[]{
                            COLUMN_FNAME, COLUMN_EMAIL, COLUMN_PASS},
                    null, null, null, null, null);

            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }
*/

    public void insertcontact(Contact c) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //String query = "select * from contacts";
        //Cursor cursor = db.rawQuery(query,null);
        //int count = cursor.getCount();
        //values.put(COLUMN_ID,count);

        if (c.getEmail() != null) {
            Log.v("insertcontact", c.getEmail());
        }
        values.put(COLUMN_FNAME, c.getFname());
        values.put(COLUMN_LNAME, c.getLname());
        values.put(COLUMN_EMAIL, c.getEmail());
        values.put(COLUMN_PASS, c.getPass());
        db.insert("contacts", null, values);
      /*  if(id>=0)
        {

        }
        else{
            Log.v("DBhelper","Error in entering data");
        }*/
        db.close();
        //cursor.close();

    }


}