package com.br.ucsal.lamis;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by alan on 16/06/17.
 */

public class BancoUtil extends SQLiteOpenHelper {

    public static BancoUtil instancia;


    public static BancoUtil getInstance(Context context){
        if(instancia == null){
            instancia = new BancoUtil(context);
        }
        return instancia;
    }

    private BancoUtil(Context context){
        super(context, "Lamis" , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE LA_LAMIS(LAMI_ID INTEGER PRIMARY KEY," +
                "   HM-1          INT      NOT NULL," +
                "   CLASSIFICACAO   INT     ," +
                "   GENERO        TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        switch (oldVersion){
            case 1 :  db.execSQL("ALTER");
                db.execSQL("ALTER");
            case 2 :  db.execSQL("ALTER");

        }

    }

}
