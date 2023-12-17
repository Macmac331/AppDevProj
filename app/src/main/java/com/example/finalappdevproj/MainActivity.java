package com.example.finalappdevproj;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    int num1 = 0;
    int num2 = 0;
    private String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit;
        edit = findViewById(R.id.name);
        Button btn = findViewById(R.id.submitName);
        btn.setOnClickListener(view -> {

            if(!TextUtils.isEmpty(edit.getText())){
                userName = edit.getText().toString();

                openHomeActivity();
                Toast.makeText(MainActivity.this, "Welcome " + userName, Toast.LENGTH_SHORT).show();

            }
            else{
                Toast.makeText(MainActivity.this, "Please enter valid input", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void openHomeActivity(){
        Intent intent = new Intent(this, Home.class);
        intent.putExtra("USER_NAME", userName);
        startActivity(intent);
    }

    protected void onStart(){
        super.onStart();
        num1 += 2;
        num2 += 2;
        Toast.makeText(MainActivity.this, "Welcome Back!", Toast.LENGTH_LONG).show();
    }
}