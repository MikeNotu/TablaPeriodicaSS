package com.d4c.elementosquimicos;

import android.content.ContentValues;

public class Elemento
{
    private String SIMBOLO;
    private String ELEMENTO;
    private String NUMERO_ATOMICO;
    private String MASA_ATOMICA ;
    private String ELECTRO_MAGNETIVIDAD ;
    private String GRUPO_O_FAMILIA ;
    private String VALENCIA ;
    private String BLOQUE ;
    private String CARACTERISTICAS ;

    public Elemento(String SIMBOLO, String ELEMENTO, String NUMERO_ATOMICO, String MASA_ATOMICA, String ELECTRO_MAGNETIVIDAD,
                    String GRUPO_O_FAMILIA, String VALENCIA, String BLOQUE, String CARACTERISTICAS)
    {
        this.SIMBOLO = SIMBOLO;
        this.ELEMENTO = ELEMENTO;
        this.NUMERO_ATOMICO = NUMERO_ATOMICO;
        this.MASA_ATOMICA = MASA_ATOMICA;
        this.ELECTRO_MAGNETIVIDAD = ELECTRO_MAGNETIVIDAD;
        this.GRUPO_O_FAMILIA = GRUPO_O_FAMILIA;
        this.VALENCIA = VALENCIA;
        this.BLOQUE = BLOQUE;
        this.CARACTERISTICAS = CARACTERISTICAS;
    }

    public String getSIMBOLO() {
        return SIMBOLO;
    }

    public String getELEMENTO() {
        return ELEMENTO;
    }

    public String getNUMERO_ATOMICO() {
        return NUMERO_ATOMICO;
    }

    public String getMASA_ATOMICA() {
        return MASA_ATOMICA;
    }

    public String getELECTRO_MAGNETIVIDAD() {
        return ELECTRO_MAGNETIVIDAD;
    }

    public String getGRUPO_O_FAMILIA() {
        return GRUPO_O_FAMILIA;
    }

    public String getVALENCIA() {
        return VALENCIA;
    }

    public String getBLOQUE() {
        return BLOQUE;
    }

    public String getCARACTERISTICAS()
    {
        return CARACTERISTICAS;
    }
    public ContentValues toContentValues()
    {
        ContentValues cv = new ContentValues();

        cv.put(Elemento_SQLITE_FORMATO.SIMBOLO, SIMBOLO);
        cv.put(Elemento_SQLITE_FORMATO.ELEMENTO, ELEMENTO);
        cv.put(Elemento_SQLITE_FORMATO.NUMERO_ATOMICO, NUMERO_ATOMICO);
        cv.put(Elemento_SQLITE_FORMATO.MASA_ATOMICA,MASA_ATOMICA);
        cv.put(Elemento_SQLITE_FORMATO.ELECTRO_MAGNETIVIDAD, ELECTRO_MAGNETIVIDAD);
        cv.put(Elemento_SQLITE_FORMATO.GRUPO_O_FAMILIA, GRUPO_O_FAMILIA);
        cv.put(Elemento_SQLITE_FORMATO.VALENCIA, VALENCIA);
        cv.put(Elemento_SQLITE_FORMATO.BLOQUE, BLOQUE);
        cv.put(Elemento_SQLITE_FORMATO.CARACTERISTICAS, CARACTERISTICAS);


        return cv;
    }
}
