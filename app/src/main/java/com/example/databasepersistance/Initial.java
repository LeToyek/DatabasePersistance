package com.example.databasepersistance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Initial extends AppCompatActivity implements View.OnClickListener {

    private EditText namaFile,catatan;
    private Button btnSimpan;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        namaFile = findViewById(R.id.edt_nama_file);
        catatan = findViewById(R.id.edt_catatan);
        btnSimpan = findViewById(R.id.btn_simpan_catatan);
        dbHelper = new DBHelper(this);

        btnSimpan.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btn_simpan_catatan){
            if (namaFile.getText().toString().equals("")){
                Toast.makeText(Initial.this, "Masukkan nama file", Toast.LENGTH_SHORT).show();
            }
            else if(catatan.getText().toString().equals("")){
                Toast.makeText(Initial.this, "Isi catatan", Toast.LENGTH_SHORT).show();
            }
            else if(namaFile.getText().toString().equals("") && catatan.getText().toString().equals("")){
                Toast.makeText(Initial.this, "Isi nama file dan catatan", Toast.LENGTH_SHORT).show();
            }else{
                boolean checkSaveData = dbHelper.simpanCatatan(namaFile.getText().toString(),catatan.getText().toString());
                if (checkSaveData == true){
                    Toast.makeText(Initial.this, "Catatan berhasil ditambahkan", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(Initial.this, "Catatan gagal ditambahkan", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}