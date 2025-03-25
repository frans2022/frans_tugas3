package com.example.tugas23;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnPesan;
    TextView txtForgotPassword, txtRegisterR;
    TextInputEditText etUsername, etPassword;

    // Data login (bisa diganti database nanti)
    private final String correctUsername = "admin";
    private final String correctPassword = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inisialisasi komponen UI
        btnLogin = findViewById(R.id.btnLogin);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtRegisterR = findViewById(R.id.txtRegister); // Tambahkan ini
        btnPesan = findViewById(R.id.btnPesan);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);

        // Event untuk tombol login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });

        // Event untuk tombol lupa password
        txtForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        // Event untuk tombol pesan
        btnPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });

        // Event untuk tombol daftar (buka register)
        txtRegisterR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukaRegister();
            }
        });
    }

    // Fungsi untuk login
    private void login() {
        String username = etUsername.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (username.isEmpty()) {
            etUsername.setError("Username tidak boleh kosong");
            return;
        }

        if (password.isEmpty()) {
            etPassword.setError("Password tidak boleh kosong");
            return;
        }

        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Dashboard.class);
            startActivity(intent);
            finish(); // Menutup MainActivity agar tidak bisa kembali dengan tombol back
        } else {
            Toast.makeText(this, "Username atau Password salah!", Toast.LENGTH_SHORT).show();
        }
    }

    // Fungsi untuk membuka halaman register
    private void bukaRegister() {
        Intent intent = new Intent(this, register.class);
        startActivity(intent);
    }

    // Metode untuk mengirim pesan ke aplikasi lain
    private void sendMessage() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Halo, ini pesan dari aplikasi saya!");

        // Menampilkan pilihan aplikasi untuk mengirim pesan
        startActivity(Intent.createChooser(intent, "Pilih aplikasi untuk mengirim pesan"));
    }
}
