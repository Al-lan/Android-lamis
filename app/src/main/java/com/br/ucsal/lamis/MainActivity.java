package com.br.ucsal.lamis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static ListView listLami;
    public static List<Lami> lamis = new ArrayList<>();

    public static int aula;
    public static int periodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lami lami  = new Lami(1,new int[][]{{0,1,0,0},{0,1,0,1}});
        Lami lami1 = new Lami(2,new int[][]{{1,1,0,0},{0,1,0,1}});

        lamis.add(lami);
        lamis.add(lami1);
        aula = 0;
        periodo = 0;
        //

        listLami = (ListView) findViewById(R.id.list_lami);
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lamis);
        ArrayAdapter adapter = new LamiAdapter(this, R.layout.lami, lamis);
        listLami.setAdapter(adapter);

    }
}
