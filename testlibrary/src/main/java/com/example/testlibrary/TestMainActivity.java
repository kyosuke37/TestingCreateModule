package com.example.testlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.testlibrary.dialog.CustomDialog;

public class TestMainActivity extends AppCompatActivity {

    Button btn_cek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_main);

        btn_cek = findViewById(R.id.btn_cek);
        btn_cek.setOnClickListener(v -> {
            CustomDialog customDialog = new CustomDialog(this, "Test yang dilakukan untuk pengecekkan library.");
            customDialog.show();

            customDialog.setCustomDialogButtonInterface(() -> {
                TestToastLibrary.testToast(getApplicationContext(), "Berhasil Lakukan connect library.");
            });
        });

    }
}