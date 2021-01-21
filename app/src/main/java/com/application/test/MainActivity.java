package com.application.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.application.test.models.LoginDetails;

public class MainActivity extends AppCompatActivity {

    private String s1 = "mydata";
    TextView text;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        s1 = sh.getString("AccessToken", "");

        logout = findViewById(R.id.logout);

        if (s1.equals("")){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            finish();
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                SharedPreferences.Editor myEdit = sharedPreferences.edit();
                myEdit.putString("AccessToken", "");
                myEdit.commit();
            }
        });

        text = findViewById(R.id.text);
        String response = getIntent().getStringExtra("response");
        text.setText(response);
    }
}