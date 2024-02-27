package com.example.testlibrary;

import android.content.Context;
import android.widget.Toast;

public class TestToastLibrary {

    public static void testToast(Context c, String pesan){
        if(pesan == null || "".equals(pesan)){
            pesan = "Harap masukkan pesan anda";
        }

        Toast.makeText(c, pesan, Toast.LENGTH_SHORT).show();
    }

}
