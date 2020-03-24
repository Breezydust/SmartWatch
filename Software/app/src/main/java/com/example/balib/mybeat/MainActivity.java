package com.example.balib.mybeat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private long backPressedTime;

    FirebaseAuth mAuth;
    EditText username, register_password;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        register_password = (EditText) findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.signin).setOnClickListener(this);
        findViewById(R.id.email_sign_up_button).setOnClickListener(this);
    }

    private void userLogin() {

        String email = username.getText().toString().trim();
        String password = register_password.getText().toString().trim();

        if (email.isEmpty()) {
            username.setError("Email is required");
            username.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            username.setError("Please enter a valid email");
            username.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            register_password.setError("Password is required");
            register_password.requestFocus();
            return;

        }
        if (password.length() < 6) {
            register_password.setError("The minimum length of the password should be 6");
            register_password.requestFocus();
            return;
        }

        // progressBar.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, home.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.email_sign_up_button:

                startActivity(new Intent(this, register.class));
                break;

               case R.id.signin:
                userLogin();
                break;
        }
    }
    @Override
    public void onBackPressed(){
        super.onBackPressed();
            if (backPressedTime + 2000 > System.currentTimeMillis()){
                super.onBackPressed();
                return;
            }else{
                Toast.makeText(getBaseContext(), "Press Back again to exit", Toast.LENGTH_SHORT).show();
            }
        backPressedTime = System.currentTimeMillis();
    }

}
