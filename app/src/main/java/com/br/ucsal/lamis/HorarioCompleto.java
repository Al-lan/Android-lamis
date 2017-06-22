package com.br.ucsal.lamis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.br.ucsal.lamis.model.Lami;

public class HorarioCompleto extends AppCompatActivity {

    public static Lami lami;
    private static int pointer;
    private static int max = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horario_completo);

        int id = getIntent().getIntExtra("id", 0);

        //<isso vai ser uma consulta
        lami = new Lami(id, 0, new  int [][] {{1,1,0,0,0,0,1,1},{1,0,1,0,1,1,1,1},{1,0,1,0,1,1,1,1}});
        //isso vai ser uma consulta>
        
        TextView titulo = (TextView) findViewById(R.id.titulo);

        pointer = MainActivity.dia;

        titulo.setText(lami.toString());

        construir();
    }


    public void construir(){

        int [][] dia = lami.getHorarios();

        for (int i = 0; i < 8; i++){

            int idView = getResources().getIdentifier("H"+(i+1), "id", getPackageName());
            View view = findViewById(idView);

            if(dia[pointer][i] == 0){
                view.setBackgroundColor(this.getResources().getColor(R.color.verde));
            }else{
                view.setBackgroundColor(this.getResources().getColor(R.color.vermelho));
            }
        }
    }


    public void proximo(View v){
        pointer++;

       if(pointer > max ) {
           pointer = 0;
       }
       construir();
    }


    public void anterior(View v){
        pointer--;

        if(pointer < 0 ){
            pointer = max;
        }
        construir();
    }
}
