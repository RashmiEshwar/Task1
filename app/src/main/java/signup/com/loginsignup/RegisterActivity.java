package signup.com.loginsignup;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.DatePickerDialog;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {

    private static  final Pattern EMAIL_ADDRESS= Pattern.compile("[A-Za-z0-9\\+\\.\\_\\%\\-\\+]{1,256}"+"\\@"+"[A-Za-z0-9][A-Za-z0-9\\-]{0,64}" +"("+"[A-Za-z0-9][A-Za-z0-9\\-]{0,25}"+")+");



    //EditText fname,lname,email,Pass,confirmpassword;
//Button SIGNUP;
    DatabaseHelper db = new DatabaseHelper(this);
    Button b1;
    private static int RESULT_LOAD_IMAGE = 1;
    private String textMessage;
    private String cnfpass, fstr, lstr, estr, pstr, cfpstr;
    // private String date;
    private int REQUEST_CAMERA = 0, SELECT_FILE = 1;
    private Button Submit;
    DatePickerDialog datePickerDialog;
    private String userChoosenTask;
    private String setOnClickListener;
    boolean result;
    private EditText f, l, e, p, cfp, d;
    ImageView ivImage;
    TextView home;
    private String isPassValid;
    private String setCursorVisible;
    private String DownloadImageTask;
    private String Click;
    ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        result = Utility.checkPermission(RegisterActivity.this);
        b1 = (Button) findViewById(R.id.btnSelectPhoto);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        Submit = (Button) findViewById(R.id.signup);

        f = (EditText) findViewById(R.id.Firstname);
        l = (EditText) findViewById(R.id.Lastname);
        e = (EditText) findViewById(R.id.emailid);
        p = (EditText) findViewById(R.id.pass);
        cfp = (EditText) findViewById(R.id.cptext);


        b1.setOnClickListener(new View.OnClickListener() {

            // Setting Positive "Yes" But

            @Override
            public void onClick(View v) {
                selectImage();

            }
        });
        f.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (view.getId() == f.getId()) {
                    f.setCursorVisible(true);
                }
            }


        });


        TextView txt = (TextView) findViewById(R.id.home); //txt is object of TextView
        txt.setMovementMethod(LinkMovementMethod.getInstance());
        txt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });
        //Toast.makeText(getBaseContext(), "Welcome, " + fname + lname, Toast.LENGTH_LONG).show();
        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                fstr = f.getText().toString();
                lstr = l.getText().toString();
                estr = e.getText().toString();
                pstr = p.getText().toString();
                cfpstr = f.getText().toString();
                Boolean val = validate();
                Log.v("reg", val.toString());
                if (val) {
                    Contact c = new Contact();
                    c.setFname(fstr);
                    c.setLname(lstr);
                    c.setEmail(estr);
                    c.setPass(pstr);
                    Log.v("RegisterClicked", c.getEmail());
                    Toast.makeText(getBaseContext(), "Getting user", Toast.LENGTH_SHORT);
                    db.insertcontact(c);
                    Intent i = new Intent(RegisterActivity.this, NewActivity2.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getBaseContext(), "Error in sign up", Toast.LENGTH_LONG).show();
                }

            }
        });
    }

    private boolean validate() {
        boolean val = true;
        if (fstr.equals("")) {
            f.setError("First Name cant be blanked");
            f.requestFocus();
            val = false;
        } else if (lstr.equals("")) {
            l.setError("Last Name cant be blanked");
            l.requestFocus();
            val = false;
        } else if (pstr.equals("")) {
            p.setError("Password cant be blanked");
            p.requestFocus();
            val = false;
        } else if (!pstr.equals("")) {
                Boolean y = isPassValid(pstr);
                if (y.equals(false)) {
                    cfp.setError("Password should have 10 characters");
                    cfp.requestFocus();
                    val = false;
                } else
                    val = true;
        }
        else if (!estr.equals("")) {
            Boolean y1 = validateEmail();
            if (y1.equals(false)) {
                cfp.setError("Email address is too weak");
                cfp.requestFocus();
                val = false;
            } else
                val = true;
        }
        else if (!pstr.equals("((?=.*\\d)(?=.*[A-Z])(?=.*[@#$%]?)(?=.*[a-z]).{8,10})")) {

                cfp.setError("Password should contain minimum 1uppercase 1lowercase 1 numeric,1specialcharacter(Aa1$)");
                cfp.requestFocus();
                val = false;
            }
    else if (cfpstr.equals("")) {
            cfp.setError("Password cant be blanked");
            cfp.requestFocus();
            val = false;
        } else if (!pstr.equals(cfpstr)) {
            cfp.setError("Password cannot be matched");
            cfp.requestFocus();
            val = false;
        } else if (pstr.equals(cnfpass)) {
            val = true;
        } else val = true;


return val;
    }


    protected boolean isPassValid(CharSequence pass) {
        String exp = "((?=.*\\d)(?=.*[A-Z])(?=.*[@#$%]?)(?=.*[a-z]).{8,10})";

        Pattern pattern = Pattern.compile(exp);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

    private boolean validateEmail() {
        String emailInput = e.getText().toString().trim();
        if (emailInput.isEmpty()) {
            e.setError("Field cant be empty");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            e.setError("please enter a valid email address");
        } else {
            e.setError(null);
            return true;
        }
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == SELECT_FILE)
                onSelectFromGalleryResult(data);
            else if (requestCode == REQUEST_CAMERA)
                onCaptureImageResult(data);
        }
    }


    @SuppressWarnings("deprecation")
    private void onSelectFromGalleryResult(Intent data) {
        Bitmap bm = null;
        if (data != null) {
            try {
                bm = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        ivImage.setImageBitmap(bm);
    }


    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }

    private void onCaptureImageResult(Intent data) {
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        thumbnail.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
        File destination = new File(Environment.getExternalStorageDirectory(),
                System.currentTimeMillis() + ".jpg");
        FileOutputStream fo;
        try {
            destination.createNewFile();
            fo = new FileOutputStream(destination);
            fo.write(bytes.toByteArray());
            fo.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ivImage.setImageBitmap(thumbnail);
    }

    private void selectImage() {
        final CharSequence[] items = {"Take Photo", "Choose from Library",
                "URL", "Cancel"};

        //
        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(RegisterActivity.this);//final  builder = new Builder(RegisterActivity.this);
        alertDialog.setTitle("Add Photo!");

        alertDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                boolean result = Utility.checkPermission(RegisterActivity.this);

                if (items[item].equals("Take Photo")) {
                    userChoosenTask = "Take Photo";
                    if (result)
                        cameraIntent();

                } else if (items[item].equals("Choose from Library")) {
                    userChoosenTask = "Choose from Library";
                    if (result)
                        galleryIntent();

                } else if (items[item].equals("URL")) {
                    userChoosenTask = "URL";
                    if (result)
                        UrlIntent();
                    alertDialog.setMessage("Enter URL");
                    final EditText input = new EditText(RegisterActivity.this);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        alertDialog.show();
    }


    private void cameraIntent() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    private void galleryIntent() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);//
        startActivityForResult(Intent.createChooser(intent, "Select File"), SELECT_FILE);
    }

    private void UrlIntent() {
        /*Intent intent = new Intent();

        intent.setType("text");
        intent.setAction(Intent.ACTION_GET_CONTENT);//)
        startActivityForResult(Intent.createChooser(intent, "Select File"), REQUEST_GOOGLE);
/*Intent intent = new Intent(GOOGLE.ACTION_IMAGE_DOWNLOAD);
        startActivityForResult(intent, REQUEST_Google);
    }*/

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu4, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(this, MainActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}



