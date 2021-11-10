package com.example.databasepersistance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity implements View.OnClickListener {

    private Button btnRegister,btnLogin;
    private EditText userName,password;
    private DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);
        userName = findViewById(R.id.edt_userName);
        password = findViewById(R.id.edt_password);
        db = new DBHelper(this);

        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_register) {
            Intent intent = new Intent(SignIn.this, Register.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.btn_login){
            if (userName.equals("")||password.equals("")){
                Toast.makeText(SignIn.this, "insert your data", Toast.LENGTH_SHORT).show();
            }
            else{
                Boolean checkUser = db.checkUserUsername(userName.getText().toString());
                Boolean checkPass = db.checkUserPass(password.getText().toString());
                if (checkUser == true && checkPass == true){
                    startActivity(new Intent(SignIn.this,Initial.class));
                }else{
                    Toast.makeText(SignIn.this, "username atau password anda salah", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}