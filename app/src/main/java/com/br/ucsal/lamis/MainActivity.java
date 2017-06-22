package com.br.ucsal.lamis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.br.ucsal.lamis.model.Lami;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ListView listLami;
    public static List<Lami> lamis = new ArrayList<>();

    public static int dia;
    public static int aula;
    public static int periodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //<isso vai ser uma consulta
        Lami lami  = new Lami(1,1);
        Lami lami1 = new Lami(2,0);

        lamis.add(lami);
        lamis.add(lami1); 

        dia = 0;
        aula = 0;
        periodo = 0;
        //isso vai ser uma consulta>

        listLami = (ListView) findViewById(R.id.list_lami);
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lamis);
        ArrayAdapter adapter = new LamiAdapter(this, R.layout.lami, lamis);
        listLami.setAdapter(adapter);


        listLami.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(MainActivity.this, HorarioCompleto.class);
                it.putExtra("id", lamis.get(position).getIdLami());
                startActivity(it);

                return false ;
            }
        });


    }
}
