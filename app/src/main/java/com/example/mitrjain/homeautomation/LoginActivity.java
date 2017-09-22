package com.example.mitrjain.homeautomation;

import android.app.LoaderManager.LoaderCallbacks;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {
    EditText mEmailView, mPasswordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.username_field);
        mPasswordView = (EditText) findViewById(R.id.password_field);

        Button Login_button = (Button) findViewById(R.id.login_button);

        Login_button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEmailView.getText().toString().trim().length() == 0) {
                    mEmailView.setError("Username missing");
                    mEmailView.requestFocus();
                }
//                if(android.util.Patterns.EMAIL_ADDRESS.matcher(mEmailView.getText().toString().trim()).matches()){
//                    mEmailView.setError("Username missing");
//                    mEmailView.requestFocus();
//                }

                if (mPasswordView.getText().toString().trim().length() == 0) {
                    mPasswordView.setError("Password missing");
                    mPasswordView.requestFocus();
                } else {
                    attemptLogin(mEmailView.getText().toString());
                }
            }
        });

    }

    private void attemptLogin(String username) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
