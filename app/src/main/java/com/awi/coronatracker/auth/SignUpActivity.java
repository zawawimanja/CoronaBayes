package com.awi.coronatracker.auth;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.awi.coronatracker.R;



public class SignUpActivity extends AppCompatActivity {
    Button SignUpButton; //Use for sign up & sign in options
    EditText SignUpUsername, SignUpEmail, SignUpPassword; //Use for getting user inputs to sign up

    Button SignInAccountButton; //Use for redirect users to desire page

    String Role = "Student";

    private ProgressDialog loadingBar;
    //public static boolean NameHolder;
    EditText email, password, name ;
    Button Register;
    String NameHolder, EmailHolder, PasswordHolder;
    Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    String SQLiteDataBaseQueryHolder ;
    SQLiteHelper sqLiteHelper;
    Cursor cursor;
    String F_Result = "Not_Found";

//    FirebaseDatabase database;
//    DatabaseReference users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        loadingBar = new ProgressDialog(this);

        //Sign Up
        name = (EditText)findViewById(R.id.signup_username);
        email = (EditText) findViewById(R.id.signup_email);
        password = (EditText) findViewById(R.id.signup_password);


        SignUpButton = (Button) findViewById(R.id.signup_button);

        //Others
        SignInAccountButton = (Button) findViewById(R.id.signin_account_button);

        //Firebase
//        database = FirebaseDatabase.getInstance();
//        users = database.getReference("Users");
        // Adding click listener to register button.
        SignUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Creating SQLite database if dose n't exists
                SQLiteDataBaseBuild();

                // Creating SQLite table if dose n't exists.
                SQLiteTableBuild();

                // Checking EditText is empty or Not.
                CheckEditTextStatus();

                // Method to check Email is already exists or not.
            //    CheckingEmailAlreadyExistsOrNot();
                //Sending confirmation email.
               // Confirm();

                // Empty EditText After done inserting process.
                EmptyEditTextAfterDataInsert();



            }
        });


        SignInAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendUserToSignInActivity();
            }
        });

//        ForgetPasswordButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignUpActivity.this, ForgetPasswordActivity.class));
//            }
//        });
    }

//    private void SignUpAccount() {
//        final User user = new User(SignUpUsername.getText().toString().trim(),
//        SignUpEmail.getText().toString().trim(),
//        SignUpPassword.getText().toString().trim(), Role);
//
//        Boolean valid = true;
//
//        if (TextUtils.isEmpty(SignUpUsername.getText().toString().trim()))
//        {
//            Toast.makeText(this, "Please fill in your username!", Toast.LENGTH_SHORT).show();
//            valid = false;
//        }
//        if (TextUtils.isEmpty(SignUpEmail.getText().toString().trim()))
//        {
//            Toast.makeText(this, "Please fill in your email address!", Toast.LENGTH_SHORT).show();
//            valid = false;
//        }
////        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
////        if (!email.matches(emailPattern ))
////        {
////            Toast.makeText(this, "Please use a valid email address!", Toast.LENGTH_SHORT).show();
////            valid = false;
////        }
//        if (TextUtils.isEmpty(SignUpPassword.getText().toString().trim()))
//        {
//            Toast.makeText(this, "Please fill in your password!", Toast.LENGTH_SHORT).show();
//            valid = false;
//        }
////        String upperCaseChars = "(.*[A-Z].*)";
////        if (!password.matches(upperCaseChars ))
////        {
////            Toast.makeText(this, "Password should contain at least one upper case alphabet!", Toast.LENGTH_SHORT).show();
////            valid = false;
////        }
////        String lowerCaseChars = "(.*[a-z].*)";
////        if (!password.matches(lowerCaseChars ))
////        {
////            Toast.makeText(this, "Password should contain at least one lower case alphabet!", Toast.LENGTH_SHORT).show();
////            valid = false;
////        }
////        if (password.length() > 32 || password.length() < 8)
////        {
////            Toast.makeText(this, "Password should be more than 8 and less than 32 characters in length!", Toast.LENGTH_SHORT).show();
////            valid = false;
////        }
////        String numbers = "(.*[0-9].*)";
////        if (!password.matches(numbers ))
////        {
////            Toast.makeText(this, "Password should contain at least one number!", Toast.LENGTH_SHORT).show();
////            valid = false;
////        }
////        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
////        if (!password.matches(specialChars ))
////        {
////            Toast.makeText(this, "Password should contain at least one special character!", Toast.LENGTH_SHORT).show();
////            valid = false;
////        }
//        if(valid)
//        {
//            loadingBar.setTitle("Creating New Account");
//            loadingBar.setMessage("Please wait while your account is processing...");
//            loadingBar.show();
//            loadingBar.setCanceledOnTouchOutside(true);
//
//            users.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                    if (dataSnapshot.child(user.getUsername()).exists()){
//                        Toast.makeText(SignUpActivity.this, "Username already exist!", Toast.LENGTH_SHORT).show();
//                        loadingBar.dismiss();
//                    }
//                    else{
//                        users.child(user.getUsername()).setValue(user);
//                        Toast.makeText(SignUpActivity.this, "Sign up successfully!", Toast.LENGTH_SHORT).show();
//                        SendUserToSignInActivity();
//                        loadingBar.dismiss();
//                    }
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//        }
//    }

//    private void SendUserToMainActivity() {
//        Intent mainIntent = new Intent(SignUpActivity.this, AdminHomeActivity.class);
//        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(mainIntent);
//        finish();
//    }

    private void SendUserToSignInActivity() {
        Intent signinIntent = new Intent(SignUpActivity.this, SignInActivity.class);
        startActivity(signinIntent);
    }

    public void Confirm(){

    }

    // SQLite database build method.
    public void SQLiteDataBaseBuild(){

        sqLiteDatabaseObj = openOrCreateDatabase(SQLiteHelper.DATABASE_NAME, Context.MODE_PRIVATE, null);

    }

    // SQLite table build method.
    public void SQLiteTableBuild() {

        sqLiteDatabaseObj.execSQL("CREATE TABLE IF NOT EXISTS " + SQLiteHelper.TABLE_NAME + "(" + SQLiteHelper.Table_Column_ID + " PRIMARY KEY AUTOINCREMENT NOT NULL, " + SQLiteHelper.Table_Column_1_Name + " VARCHAR, " + SQLiteHelper.Table_Column_2_Email + " VARCHAR, " + SQLiteHelper.Table_Column_3_Password + " VARCHAR);");

    }

    // Insert data into SQLite database method.
    public void InsertDataIntoSQLiteDatabase(){

        // If editText is not empty then this block will executed.
        if(EditTextEmptyHolder == true)
        {

            // SQLite query to insert data into table.
            SQLiteDataBaseQueryHolder = "INSERT INTO "+SQLiteHelper.TABLE_NAME+" (name,email,password) VALUES('"+NameHolder+"', '"+EmailHolder+"', '"+PasswordHolder+"');";

            // Executing query.
            sqLiteDatabaseObj.execSQL(SQLiteDataBaseQueryHolder);

            // Closing SQLite database object.
            sqLiteDatabaseObj.close();

            // Printing toast message after done inserting.
            Toast.makeText(SignUpActivity.this,"User Registered Successfully", Toast.LENGTH_LONG).show();

        }
        // This block will execute if any of the registration EditText is empty.
        else {

            // Printing toast message if any of EditText is empty.
            Toast.makeText(SignUpActivity.this,"Please Fill All The Required Fields.", Toast.LENGTH_LONG).show();

        }

    }

    // Empty edittext after done inserting process method.
    public void EmptyEditTextAfterDataInsert(){

        name.getText().clear();

        email.getText().clear();

        password.getText().clear();

    }

    // Method to check EditText is empty or Not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        NameHolder = name.getText().toString() ;
        EmailHolder = email.getText().toString();
        PasswordHolder= password.getText().toString();

        if(TextUtils.isEmpty(NameHolder) || TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking Email is already exists or not.
//    public void CheckingEmailAlreadyExistsOrNot(){
//
//        // Opening SQLite database write permission.
//        sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();
//
//        // Adding search email query to cursor.
//        cursor = sqLiteDatabaseObj.query(SQLiteHelper.TABLE_NAME, null, " " + SQLiteHelper.Table_Column_2_Email + "=?", new String[]{EmailHolder}, null, null, null);
//
//        while (cursor.moveToNext()) {
//
//            if (cursor.isFirst()) {
//
//                cursor.moveToFirst();
//
//                // If Email is already exists then Result variable value set as Email Found.
//                F_Result = "Email Found";
//
//                // Closing cursor.
//                cursor.close();
//            }
//        }
//
//        // Calling method to check final result and insert data into SQLite database.
//        CheckFinalResult();
//
//    }


    // Checking result
    public void CheckFinalResult(){

        // Checking whether email is already exists or not.
        if(F_Result.equalsIgnoreCase("Email Found"))
        {

            // If email is exists then toast msg will display.
            Toast.makeText(SignUpActivity.this,"Email Already Exists",Toast.LENGTH_LONG).show();

        }
        else {

            // If email already dose n't exists then user registration details will entered to SQLite database.
            InsertDataIntoSQLiteDatabase();

        }

        F_Result = "Not_Found" ;

    }
}