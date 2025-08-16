package com.example.miprimerapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnSaludo;
    TextView tvSaludo;
    EditText etSaludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnSaludo = findViewById(R.id.btnMostrarSaludo);
        tvSaludo = findViewById(R.id.tvSaludoMostrado);
        etSaludo = findViewById(R.id.etSaludo); // Assuming R.id.etSaludo exists in activity_main.xml

        btnSaludo.setOnClickListener(v -> { // Changed View to v to avoid conflict with android.view.View
            String saludoIngresado = etSaludo.getText().toString();
            String mensaje = "Hola " + saludoIngresado + "!";
            if (saludoIngresado.isEmpty()) {
                mensaje = "Hola Mundo!"; // Default message if EditText is empty
                Toast.makeText(this, "Por favor, ingresa un nombre.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
            }
            tvSaludo.setText(mensaje);
            tvSaludo.setVisibility(View.VISIBLE);
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}