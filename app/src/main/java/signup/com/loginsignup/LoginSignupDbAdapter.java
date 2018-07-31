/*package signup.com.loginsignup;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class LoginSignupDbAdapter{
private String fetchAllcontact;
private String insertcontact;
    public static final String COLUMN_ID="id";
    public static final String COLUMN_FNAME="fname";
    public  static final String COLUMN_LNAME="lname";
    public  static final String COLUMN_EMAIL="email";
    public static final String COLUMN_PASS="pass";


        //public static final String KEY_REGION = "region";

        private static final String TAG = "LoginSignupAdapter";
        private DatabaseHelper mDbHelper;
        private SQLiteDatabase mDb;

        private static final String DATABASE_NAME = "contacts.db";
        public static final String SQLITE_TABLE = "contacts";
        private static final int DATABASE_VERSION = 1;
        private final Context mCtx;

        public static final String DATABASE_CREATE =
                "CREATE TABLE if not exists " + SQLITE_TABLE + " (" +
                        COLUMN_ID + " integer PRIMARY KEY autoincrement," +
                        COLUMN_FNAME + "," +
                        COLUMN_LNAME + "," +
                        COLUMN_PASS + "," +
                        " UNIQUE (" + COLUMN_ID +"));";
    public LoginSignupDbAdapter(Context ctx) {
        this.mCtx = ctx;
    }

    public LoginSignupDbAdapter open() throws SQLException {
        mDbHelper = new DatabaseHelper(mCtx);
        mDb = mDbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        if (mDbHelper != null) {
            mDbHelper.close();
        }
    }
    public Cursor fetchAllcontact() {



            Cursor mCursor = mDb.query(SQLITE_TABLE, new String[]{
                            COLUMN_FNAME, COLUMN_EMAIL, COLUMN_PASS},
                    null, null, null, null, null);

            if (mCursor != null) {
                mCursor.moveToFirst();
            }
            return mCursor;
        }






    }




*/