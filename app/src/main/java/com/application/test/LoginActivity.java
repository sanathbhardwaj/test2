package com.application.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    ViewModel viewModel;
    Button login;
    EditText phone, password;
    ProgressBar progress_circular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        phone = findViewById(R.id.phone);
        password = findViewById(R.id.password);
        progress_circular = findViewById(R.id.progress_circular);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress_circular.setVisibility(View.VISIBLE);
                viewModel = ViewModelProviders.of(LoginActivity.this).get(ViewModel.class);
                viewModel.init(phone.getText().toString(), password.getText().toString(), "hjcshc");
                viewModel.getRepository().observe(LoginActivity.this, response -> {
                    progress_circular.setVisibility(View.GONE);
                    if (response.getAccessToken()!=null){
                        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                        SharedPreferences.Editor myEdit = sharedPreferences.edit();
                        myEdit.putString("AccessToken", response.getAccessToken());
                        myEdit.commit();
                        startActivity(new Intent(LoginActivity.this, MainActivity.class)
                                .putExtra("response", response.getMessage()));
                        finish();
                    }
                    else {
                        Toast.makeText(LoginActivity.this, "Wrong password!", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}