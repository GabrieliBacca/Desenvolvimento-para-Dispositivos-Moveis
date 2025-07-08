package com.ifsc.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button salvar;
    TextView texto;
    ListView listView;
    ArrayList<Nota> notas = new ArrayList<Nota>();
    Integer id;

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

        salvar = findViewById(R.id.salvar);
        texto = findViewById(R.id.texto);
        listView = findViewById(R.id.view);

        db = openOrCreateDatabase("notas", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS NOTAS (" +
                "ID INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "TEXTO TEXT)");

        salvar.setOnClickListener(b ->{
            if (id!=null){
                atualizaNota(id, texto.getText().toString());
            } else {
                insereNota(texto.getText().toString());
            }

            texto.setText("");
            id = null;
            loadNotas();
        });

        listView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            deletarNota(notas.get(i).getId());

            loadNotas();

            return false;
        });

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Nota nota = notas.get(i);

            texto.setText(nota.getTexto());
            id = nota.getId();

        });

        loadNotas();
    }

    void loadNotas(){
        notas.clear();

        Cursor cursor = db.rawQuery("SELECT * FROM notas", null);
        cursor.moveToFirst();

        int cId = cursor.getColumnIndex("ID");
        int cTexto = cursor.getColumnIndex("TEXTO");
        while (!cursor.isAfterLast()){
            notas.add(new Nota(cursor.getInt(cId), cursor.getString(cTexto)));
            cursor.moveToNext();
        }

        AdapterNota adapter = new AdapterNota(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                notas);

        listView.setAdapter(adapter);

        cursor.close();
    }

    Long insereNota(String insert){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TEXTO", insert);

        return db.insert("notas", null, contentValues);
    }

    void atualizaNota(int id, String update){
        ContentValues contentValues = new ContentValues();
        contentValues.put("TEXTO", update);

        db.update("notas", contentValues, "id=?", new String[]{Integer.toString(id)});
    }

    void deletarNota(int delete){
        db.delete("notas", "ID = ?", new String[] {Integer.toString(delete)});
    }
}