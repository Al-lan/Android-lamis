package com.br.ucsal.lamis;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.br.ucsal.lamis.model.Lami;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 15/06/17.
 */

public class LamiAdapter extends ArrayAdapter<Lami> {

    private Context context;
    private int resource;
    private List<Lami> lamis = new ArrayList<>();

    public LamiAdapter(@NonNull Context context, @LayoutRes int resource, List<Lami> lamis) {
        super(context, resource, lamis);
        this.context = context;
        this.resource = resource;
        this.lamis = lamis;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Lami lami = lamis.get(position);
        LayoutInflater inflater = (LayoutInflater) LayoutInflater.from(context);
        View itemLami = inflater.inflate(resource, parent, false);

        TextView nome = (TextView) itemLami.findViewById(R.id.lami_nome);
        TextView info = (TextView) itemLami.findViewById(R.id.lami_info);

        int aula = MainActivity.aula;
        int periodo = MainActivity.periodo;

        nome.setText(lami.toString());
        nome.setTextColor(context.getResources().getColor(R.color.branco));

        if(lami.getSituacaoAtual() == 0 ) {
            itemLami.setBackgroundColor(context.getResources().getColor(R.color.verde));
            info.setText("Livre");
        }
        else{
            itemLami.setBackgroundColor(context.getResources().getColor(R.color.vermelho));
            info.setText("Ocupado");
        }

        info.setTextColor(context.getResources().getColor(R.color.branco));

        return itemLami;

    }

}
