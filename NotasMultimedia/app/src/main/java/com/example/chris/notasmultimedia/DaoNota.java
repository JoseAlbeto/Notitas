package com.example.chris.notasmultimedia;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by chris on 30/10/2017.
 */

public class DaoNota {

    Context contexto;
    SQLiteDatabase midb;

    public DaoNota(Context contexto){
        this.contexto = contexto;
        this.midb = new MySQLiteOpenHelper(contexto).getWritableDatabase();
    }

    public long insert(Nota n){
        ContentValues cv = new ContentValues();

        cv.put(MySQLiteOpenHelper.COLUMNS_TABLE_NOTAS[1], n.getTitulo());
        cv.put(MySQLiteOpenHelper.COLUMNS_TABLE_NOTAS[2], n.getDescripcion());
        cv.put(MySQLiteOpenHelper.COLUMNS_TABLE_NOTAS[3], n.getFecha());

        return  midb.insert(MySQLiteOpenHelper.TABLE_NOTAS,null,cv);
    }

}
