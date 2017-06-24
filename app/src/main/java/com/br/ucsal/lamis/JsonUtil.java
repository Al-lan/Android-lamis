package com.br.ucsal.lamis;

import android.util.Log;

import com.br.ucsal.lamis.model.Lami;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alan on 22/06/17.
 */

public class JsonUtil {

    private static List<Lami> lamis = new ArrayList<>();
    private static Gson gson = new Gson();


    public static void initLamis(){


        Lami lami = new Lami(1,0);
        Lami lami1 = new Lami(2,1);
        Lami lami2 = new Lami(3,0);
        Lami lami3 = new Lami(4,0);
        Lami lami4 = new Lami(5,1);
        Lami lami5 = new Lami(6,1);
        Lami lami6 = new Lami(7,0);

        lamis.add(lami);
        lamis.add(lami1);
        lamis.add(lami2);
        lamis.add(lami3);
        lamis.add(lami4);
        lamis.add(lami5);
        lamis.add(lami6);

        int [][] hLami = new int [][]{{0,0,1,1,0,1,1,0},{1,1,1,1,0,0,1,1},{0,0,0,0,0,1,1,0}};
        int [][] hLami1 = new int [][]{{1,1,1,1,0,0,1,1},{1,0,1,0,0,0,1,1},{1,0,0,1,0,1,1,1}};
        int [][] hLami2 = new int [][]{{0,0,0,1,0,1,1,1},{0,1,1,0,1,0,0,0},{0,0,0,0,0,1,0,1}};
        int [][] hLami3 = new int [][]{{0,1,0,0,1,1,1,0},{1,0,1,1,1,1,0,0},{0,1,0,1,0,0,1,0}};
        int [][] hLami4 = new int [][]{{1,1,1,1,1,1,1,1},{0,1,0,1,0,0,0,1},{0,1,0,0,0,1,1,0}};
        int [][] hLami5 = new int [][]{{1,1,1,0,1,0,1,0},{0,1,1,1,0,1,1,1},{1,0,0,1,0,0,0,1}};
        int [][] hLami6 = new int [][]{{0,0,1,0,0,1,1,0},{1,0,0,1,1,0,1,0},{0,1,0,0,0,0,1,0}};

        lami.setHorarios(hLami);
        lami1.setHorarios(hLami1);
        lami2.setHorarios(hLami2);
        lami3.setHorarios(hLami3);
        lami4.setHorarios(hLami4);
        lami5.setHorarios(hLami5);
        lami6.setHorarios(hLami6);

    }

    public static String parteServerTodos(int dia, int periodo ){

        List<Lami> lamisMin = new ArrayList<>();

        for (Lami lami : lamis) {
            lamisMin.add(new Lami(lami.getIdLami(),lami.getHorarios()[dia][periodo]));
        }

        return gson.toJson(lamisMin);

    }

    public static List<Lami> getTodos(int dia, int periodo ){

        String jsonMin = parteServerTodos(dia, periodo);

        Type tipo = new TypeToken<ArrayList<Lami>>(){}.getType();
        List<Lami> lamis = gson.fromJson(jsonMin, tipo);

        return lamis;
    }

    public static String parteServerUnico(int id){
        return gson.toJson(lamis.get(id-1));
    }

    public static Lami getLami(int id){
        Lami lami = gson.fromJson(parteServerUnico(id), Lami.class);
        return lami;
    }
}
