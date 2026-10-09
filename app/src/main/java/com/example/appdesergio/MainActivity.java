package com.example.appdesergio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> nomes;
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
        nomes = new ArrayList<String>();

        ListView lv = findViewById(R.id.Lista);
        ArrayAdapter<String> USB = new ArrayAdapter<>(getApplicationContext(), R.layout.item_da_lista , R.id.textView, nomes);
        lv.setAdapter(USB);
        lv.setOnItemClickListener((parent, view, position, id) -> {
            Toast.makeText(getApplicationContext(),nomes.get(position),Toast.LENGTH_LONG).show();

        });

        TextView Nome = findViewById(R.id.Nome);
        Button Registrar_Nome = findViewById(R.id.Enter);
        Registrar_Nome.setOnClickListener(view -> {
            nomes.add(Nome.getText().toString());
            USB.notifyDataSetChanged();
        });



    }

}