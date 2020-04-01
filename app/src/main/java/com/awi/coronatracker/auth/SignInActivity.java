package com.awi.coronatracker.auth;

import androidx.annotation.Nullable;

import com.awi.coronatracker.MainActivity;
import com.awi.coronatracker.settings.SettingsActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.awi.coronatracker.R;

public class SignInActivity extends AppCompatActivity {
    Button SignInButton; //Use for sign up & sign in options
    EditText SignInUsername, SignInPassword; //Use for getting user inputs to sign in

    Button SignUpAccountButton; //Use for redirect users to desire page

    private ProgressDialog loadingBar;

    String Role;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        //Sign In
//        SignInUsername = (EditText) findViewById(R.id.signin_username);
//        SignInPassword = (EditText) findViewById(R.id.signin_password);
        SignInButton = (Button) findViewById(R.id.signin_account_button);

        // Set an error if the password is less than 8 characters.
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (!isPasswordValid(passwordEditText.getText())) {
//                   // passwordTextInput.setError(getString(R.string.shr_error_password));
//                } else {
//                    passwordTextInput.setError(null); // Clear the error
//                    //((NavigationHost) getActivity()).navigateTo(new ProductGridFragment(), false); // Navigate to the next Fragment
//                }

                Intent intObj = new Intent(SignInActivity.this,MainActivity.class);
                startActivity(intObj);

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
}
