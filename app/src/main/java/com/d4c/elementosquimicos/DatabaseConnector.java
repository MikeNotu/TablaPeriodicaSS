package com.d4c.elementosquimicos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseConnector extends SQLiteOpenHelper
{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "elementosquimicos.db";
    public DatabaseConnector(Context contexto)
    {
        super(contexto, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        sqLiteDatabase.execSQL("CREATE TABLE " + Elemento_SQLITE_FORMATO.TABLE_NAME + " ("
                + Elemento_SQLITE_FORMATO._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Elemento_SQLITE_FORMATO.SIMBOLO + " TEXT NOT NULL,"
                + Elemento_SQLITE_FORMATO.ELEMENTO + " TEXT NOT NULL,"
                + Elemento_SQLITE_FORMATO.NUMERO_ATOMICO + " TEXT NOT NULL,"
                + Elemento_SQLITE_FORMATO.MASA_ATOMICA + " TEXT NOT NULL,"
                + Elemento_SQLITE_FORMATO.ELECTRO_MAGNETIVIDAD + " TEXT,"
                + Elemento_SQLITE_FORMATO.GRUPO_O_FAMILIA+ " TEXT,"
                + Elemento_SQLITE_FORMATO.VALENCIA + " TEXT,"
                + Elemento_SQLITE_FORMATO.BLOQUE + " TEXT,"
                + Elemento_SQLITE_FORMATO.CARACTERISTICAS + " TEXT,"
                + "UNIQUE (" + Elemento_SQLITE_FORMATO.SIMBOLO+ "))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }


    public long CrearElemento(Elemento elemento)
    {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert(Elemento_SQLITE_FORMATO.TABLE_NAME,null,elemento.toContentValues());
    }

    public Cursor query (String table,String[] columns, String selection, String[] selectionArgs, String groupBy, String having,String orderBy)
    {
        return getReadableDatabase().query(table,columns,selection,selectionArgs,groupBy,having,orderBy);
    }


    public void DropTable(String Table)
    {
        getWritableDatabase().execSQL("delete from " + Table);
    }


}
