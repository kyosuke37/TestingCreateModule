package com.example.testingcreatemodule;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.testlibrary.TestMainActivity;

public class TestingMainActivity extends AppCompatActivity {

    Button btn_cek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TestToastLibrary.testToast(getApplicationContext(), "Berhasil");
        btn_cek = findViewById(R.id.btn_cek);
        btn_cek.setOnClickListener(v -> {
            Intent intent = new Intent(TestingMainActivity.this, TestMainActivity.class);
            startActivity(intent);
        });

    }

}