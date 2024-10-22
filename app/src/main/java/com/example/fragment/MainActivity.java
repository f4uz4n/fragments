package com.example.fragment;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Button;

import com.example.fragment.fragments.OneFragment;
import com.example.fragment.fragments.TwoFragment;


public class MainActivity extends AppCompatActivity {

    // Deklarasi Komponen
    Button btnFg1, btnFg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inisialisasi Komponen
        btnFg1 = findViewById(R.id.btn_fg1);
        btnFg2 = findViewById(R.id.btn_fg2);

        // Cara ngasih tampilan fragment kedalam frameLayout
        getSupportFragmentManager().beginTransaction().replace(R.id.frl_result, new OneFragment()).commit();

        btnFg1.setOnClickListener( view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frl_result, new OneFragment()).commit();
        });

        btnFg2.setOnClickListener( view -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.frl_result, new TwoFragment()).commit();
        });
    }
}