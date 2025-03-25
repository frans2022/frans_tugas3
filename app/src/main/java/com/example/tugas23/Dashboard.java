package com.example.tugas23;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    // Fungsi untuk kembali ke halaman sebelumnya
    public void kembaliHalaman(View view) {
        finish(); // Menutup activity dan kembali ke halaman sebelumnya
    }

    // Fungsi untuk menutup semua activity dan keluar dari aplikasi
    public void tutupHalaman(View view) {
        finishAffinity(); // Menutup semua activity
    }
}
