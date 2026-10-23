package com.example.appdesergio;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.SQLData;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SQLiteDatabase db;
    Button botao;
    EditText EdText;
    ListView Lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        botao=findViewById(R.id.Salvar);
        EdText=findViewById(R.id.EdText);
        Lista=findViewById(R.id.Lista);

        botao.setOnClickListener( view -> {
            String txt = EdText.getText().toString();
            ContentValues cv=new ContentValues();
            cv.put("titulo",txt);
            int status=(int) db.insert("notas",null,cv);
            String msgStatus;
            if( status > 0){
                msgStatus = "NOTA INSERIDA " +status;
            }else{
                msgStatus = "FALHA NA INSERÇÂO DA NOTA";
            }
            Toast.makeText(getApplicationContext(),msgStatus,Toast.LENGTH_LONG).show();
        });


        setup();
    }
    public void setup(){
        db=openOrCreateDatabase("Banco", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS notas ( id INTEGER PRIMARY KEY AUTOINCREMENT, titulo VARCHAR , txt VARCHAR)");
    }
    public void listarNotas(){
        Cursor cursor=db.rawQuery("SELECT * FROM notas LIMIT ?",new String[]{"100"});
        cursor.moveToFirst();
        ArrayList<String> notas = new ArrayList<>();
        while (!cursor.isAfterLast()){
            String s=cursor.getString((int)cursor.getColumnIndex("titulo"));
            notas.add(s);
            cursor.moveToNext();
        }

        ArrayList<String> adapter=new ArrayAdapter<>(
                getApplicationContext(), android.R.layout.simple_list_item_1,android.R.id.text1,notas
        );
        Lista.setAdapter(adapter);
    }

}