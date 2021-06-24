package com.d4c.elementosquimicos;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
{

        DatabaseConnector db = new DatabaseConnector(this);
        @Override
        protected void onCreate (Bundle savedInstanceState)
        {
            try

            {
                super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

                db.DropTable(Elemento_SQLITE_FORMATO.TABLE_NAME);

                RellenaTabla();


                Cursor c = db.query(Elemento_SQLITE_FORMATO.TABLE_NAME, null, null, null, null, null, null);
                String conta = "";

                while (c.moveToNext())
                {
                    conta =   conta.concat(  c.getString(c.getColumnIndex(Elemento_SQLITE_FORMATO.SIMBOLO)));



                    Log.i("HOLA" , c.getString(c.getColumnIndex(Elemento_SQLITE_FORMATO.SIMBOLO)) + " " +
                                             c.getString(c.getColumnIndex(Elemento_SQLITE_FORMATO.ELEMENTO)) + " " +
                                             c.getString(c.getColumnIndex(Elemento_SQLITE_FORMATO.NUMERO_ATOMICO)) + " " +
                                             c.getString(c.getColumnIndex(Elemento_SQLITE_FORMATO.MASA_ATOMICA)) + " " +
                                              c.getString(c.getColumnIndex(Elemento_SQLITE_FORMATO.ELECTRO_MAGNETIVIDAD)));
                }

            }catch(Exception e)
            {
                e.printStackTrace();
            }

        }



        private boolean RellenaTabla()
        {

         //   db.DropTable(Elemento_SQLITE_FORMATO.TABLE_NAME);

            try
            {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(
                        getResources().getIdentifier("elementosquimicos",
                                "raw", getPackageName()))));
                String str ;
                StringBuffer sb = new StringBuffer();
                while ((str = bufferedReader.readLine())!=null)
                {
                    String[] arr = str.split(",");
                    db.CrearElemento(new Elemento(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8]));

                    ((TextView) findViewById(R.id.sql)).setText(arr[1]);

                }

            }
                catch (Exception e)
            {
                e.printStackTrace();
                return false;
            }
            return true;
        }


}
