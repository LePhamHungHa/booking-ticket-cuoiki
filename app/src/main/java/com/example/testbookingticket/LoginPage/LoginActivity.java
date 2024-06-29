package com.example.testbookingticket.LoginPage;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.testbookingticket.ComboPageActivity;
import com.example.testbookingticket.MainActivity;
import com.example.testbookingticket.PayPageMainActivity;
import com.example.testbookingticket.R;
import com.example.testbookingticket.SignupPage.SignUpActivity;

public class LoginActivity extends AppCompatActivity {
    private LoginViewModel loginViewModel;
    private Button btn, btn_noaccount;
    private EditText ed1, ed2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        ed1 = findViewById(R.id.username);
        ed2 = findViewById(R.id.password);
        btn = findViewById(R.id.btnSubmit);
        btn_noaccount = findViewById(R.id.btn_noaccount);

        btn.setOnClickListener(v -> {
            String username = ed1.getText().toString().trim();
            String password = ed2.getText().toString().trim();
            LoginResquest loginResquest = new LoginResquest(username, password);
            loginViewModel.login(loginResquest);

            // Observe here, after calling register
            loginViewModel.getData().observe(this, new Observer<LoginResponse>() {
                @Override
                public void onChanged(LoginResponse loginResponse) {
                    Log.d("SignUpActivity", "Observer triggered. UserBody: " + loginResponse);
                    if (loginResponse != null) {
                        Toast.makeText(LoginActivity.this, "Registration successful", Toast.LENGTH_SHORT).show();
                        Log.d("SignUpActivity", "Showing success toast");
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                        Log.d("SignUpActivity", "Showing failure toast");
                    }
                }
            });
        });
        btn_noaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }
}