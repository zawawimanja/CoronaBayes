package com.awi.coronatracker.auth;

import androidx.annotation.Nullable;

import com.awi.coronatracker.MainActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.awi.coronatracker.R;

import java.net.URL;

public class SignInActivity extends AppCompatActivity {
    Button SignInButton; //Use for sign up & sign in options
    EditText SignInUsername, SignInPassword; //Use for getting user inputs to sign in

    Button SignUpButton; //Use for redirect users to desire page

    private ProgressDialog loadingBar;

    String Role;
    Button LogInButton, RegisterButton ;
    EditText Email, Password ;
    String EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    String UserName;
    URL url;
    public static final String UserEmail = "";
    public static final String userName="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //Sign In
//        SignInUsername = (EditText) findViewById(R.id.signin_username);
//        SignInPassword = (EditText) findViewById(R.id.signin_password);
        SignInButton = (Button) findViewById(R.id.signin_button);
        SignUpButton = (Button) findViewById(R.id.signup_button);

        Email = (EditText)findViewById(R.id.signin_username);
        Password = (EditText)findViewById(R.id.signin_password);

        sqLiteHelper = new SQLiteHelper(this);

//        // Set an error if the password is less than 8 characters.
//        SignInButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (!isPasswordValid(passwordEditText.getText())) {
////                   // passwordTextInput.setError(getString(R.string.shr_error_password));
////                } else {
////                    passwordTextInput.setError(null); // Clear the error
////                    //((NavigationHost) getActivity()).navigateTo(new ProductGridFragment(), false); // Navigate to the next Fragment
////                }
//
//                Intent intObj = new Intent(SignInActivity.this,MainActivity.class);
//                startActivity(intObj);
//
//            }
//        });


        //Adding click listener to log in button.
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling EditText is empty or no method.
                CheckEditTextStatus();

                // Calling login method.
                LoginFunction();


            }
        });

        // Adding click listener to register button.
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent = new Intent(SignInActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });


    }

    /*
       In reality, this will have more complex logic including, but not limited to, actual
       authentication of the username and password.
    */
    private boolean isPasswordValid(@Nullable Editable text) {
        return text != null && text.length() >= 8;
    }

    // Login function starts from here.
    public void LoginFunction(){

        if(EditTextEmptyHolder) {

            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {

                    cursor.moveToFirst();

                    // Storing Password associated with entered email.
                    TempPassword = cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_3_Password));
                    UserName=cursor.getString(cursor.getColumnIndex(SQLiteHelper.Table_Column_1_Name));

                    // Closing cursor.
                    cursor.close();
                }
            }

            // Calling method to check final result ..
            CheckFinalResult();

        }
        else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(SignInActivity.this,"Please Enter UserName or Password.",Toast.LENGTH_LONG).show();

        }

    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();

        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult(){

        if(TempPassword.equalsIgnoreCase(PasswordHolder))
        {

            Toast.makeText(SignInActivity.this,"Login Successfully",Toast.LENGTH_LONG).show();

            // Going to Dashboard activity after login success message.
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);

            // Sending Email to Dashboard Activity using intent.
            intent.putExtra(userName,UserName );

            startActivity(intent);


        }
        else {

            Toast.makeText(SignInActivity.this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();

        }
        TempPassword = "NOT_FOUND" ;

    }




}
