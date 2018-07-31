package signup.com.loginsignup;

import android.util.Log;

public class Contact {
    String name1, name2, email, pass1;

    public void setFname(String name1) {
        this.name1 = name1;
    }

    public String getFname() {
        return this.name1;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        Log.v("Email", email);
        this.email = email;
    }


    public void setLname(String lname) {
        this.name2 = lname;
    }

    public String getLname() {
        return this.name2;
    }

    public void setPass(String pass1) {
        this.pass1 = pass1;
    }

    public String getPass() {
        return this.pass1;
    }




}