package com.example.appdesergio;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    int posicao = 0;
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        /**
        Button b=findViewById(R.id.Button);
        TextView tv=findViewById(R.id.TextView);
        EditText edmin= findViewById(R.id.edmin);
        EditText edmax= findViewById(R.id.edmax);

        b.setOnClickListener(view -> {
            //contador = (int)(Math.random() *100);

            String minStr =edmin.getText().toString();
            String maxStr =edmax.getText().toString();

            if (minStr.isEmpty()){
                edmin.setError("Informe o valor mínimo");
                return;
            }
            if (maxStr.isEmpty()){
                edmax.setError("Informe o valor máximo");
                return;
            }

            int max =Integer.parseInt(maxStr);
            int min =Integer.parseInt(minStr);

            Random random= new Random();
            int valor = (random.nextInt(max-min)) + min;

            tv.setText(Integer.toString(valor));

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("valor",valor);

            startActivity(intent);
         });
        **/

        Integer[] imagens = new Integer[]{R.drawable.perfil,R.drawable.abaixopeso,R.drawable.normal,R.drawable.obesidade1,R.drawable.obesidade2,,
                R.drawable.obesidade3,R.drawable.sobrepeso};
        Button botaoVoltar,botaoAvancar;
        botaoVoltar = findViewById(R.id.btnAnterior);
        botaoAvancar = findViewById(R.id.btnAvancar);
        ImageView imageView = findViewById(R.id.imageView)

        botaoAvancar.setOnClickListener(view -> {
            posicao++;
            imageView.setImageResource(imagens[posicao]);


        });


    }

}