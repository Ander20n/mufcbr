package com.example.anderson.mufcbr.infra.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "dbmufcbr";
    private static final int DATABASE_VERSION = 1;
    private Context context;

    //TABELA USUARIOS
    protected static final String TABELA_USUARIO = "usuario";
    protected static final String ID = "id";
    protected static final String USUARIO_EMAIL = "email";
    protected static final String SENHA = "senha";
    protected static final String ATIVO = "ativo";

    //TABELA PESSOAS
    protected static final String TABELA_PESSOA = "pessoa";
    protected static final String PESSOA_NOME = "nome";
    protected static final String PESSOA_USER_ID = "id_usuario";
    protected static final String PESSOA_DATANASC = "nascimento";
    protected static final String PESSOA_ESTADO = "estado";
    protected static final String PESSOA_CIDADE = "cidade";

    public DataBase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE usuario(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "email text NOT NULL, " +
                "senha text NOT NULL, " +
                "ativo text NOT NULL); ");

        db.execSQL("CREATE TABLE pessoa(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nome text NOT NULL, " +
                "id_usuario text NOT NULL, " +
                "nascimento text NOT NULL, " +
                "estado text NOT NULL, " +
                "cidade text NOT NULL); ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE usuario;");
        db.execSQL("DROP TABLE pessoa;");
        onCreate(db);
    }
}
