package com.example.databasepersistance;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private DBHelper dbHelper;
    private Button submit;
    private EditText etRegUsername,etRegPassword,etRegEmail,etRegAddress
            ,etRegFullName,etRegSchool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etRegUsername = findViewById(R.id.regUsername);
        etRegPassword = findViewById(R.id.regPassword);
        etRegEmail = findViewById(R.id.regEmail);
        etRegAddress = findViewById(R.id.regAddress);
        etRegFullName = findViewById(R.id.regFullName);
        etRegSchool = findViewById(R.id.regSchool);
        submit = findViewById(R.id.btnSave);
        dbHelper = new DBHelper(this);
    }

    public void insert(View view) {
        String username = etRegUsername.getText().toString();
        String password = etRegPassword.getText().toString();
        String email = etRegEmail.getText().toString();
        String address = etRegAddress.getText().toString();
        String fullName = etRegFullName.getText().toString();
        String school = etRegSchool.getText().toString();

        Boolean checkInsertData = dbHelper.insertUserData(username,password,email,fullName,school,address,"","");
        if(checkInsertData == true){
            Toast.makeText(Register.this, "Account berhasil dibuat", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Register.this, "Isi semua data dengan lengkap", Toast.LENGTH_SHORT).show();
        }
    }

}