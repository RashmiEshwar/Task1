/*package signup.com.loginsignup;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class SignupCursorAdapter extends CursorAdapter {
    public SignupCursorAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {

        return LayoutInflater.from(context).inflate(
                R.layout.contacts_list_item,viewGroup,false );
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        String contactName = cursor.getString(
                cursor.getColumnIndex(DatabaseHelper.COLUMN_FNAME));
        String contactEmail = cursor.getString(
                cursor.getColumnIndex(DatabaseHelper.COLUMN_EMAIL));
        TextView nameTextView = (TextView) view.findViewById(R.id.FirstnameTextView);
        TextView phoneTextView = (TextView) view.findViewById(R.id.EmailTextView);
        nameTextView.setText(contactName);
        phoneTextView.setText(contactEmail);

    }
}

*/