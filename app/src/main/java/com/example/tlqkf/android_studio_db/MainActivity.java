package com.example.tlqkf.android_studio_db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    java_database F_DB;
    Button DB_O,DB_I,DB_S,DB_U,DB_D;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB_D = (Button)findViewById(R.id.DB_D);
        DB_I = (Button)findViewById(R.id.DB_I);
        DB_O = (Button)findViewById(R.id.DB_O);
        DB_S = (Button)findViewById(R.id.DB_S);
        DB_U = (Button)findViewById(R.id.DB_U);
        DB_D.setOnClickListener(this);
        DB_I.setOnClickListener(this);
        DB_O.setOnClickListener(this);
        DB_S.setOnClickListener(this);
        DB_U.setOnClickListener(this);
        F_DB = new java_database(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.DB_O:
                F_DB.open();
                break;
            case R.id.DB_I:
                F_DB.insert(20,"01012345678","seoul","F_DB");
                break;
            case R.id.DB_S:
                Cursor all_cursor = F_DB.AllRows();
                all_cursor.moveToFirst();
                if(all_cursor.getCount()==0){
                    Log.d("DB_T","비어있음");
                    return;
                }else{
                    Log.d("DB_T","ID="+ all_cursor.getString(all_cursor.getColumnIndex("ID")));
                    Log.d("DB_T","AGE="+ all_cursor.getString(all_cursor.getColumnIndex("AGE")));
                    Log.d("DB_T","PHONE="+ all_cursor.getString(all_cursor.getColumnIndex("PHONE")));
                    Log.d("DB_T","ADDR="+ all_cursor.getString(all_cursor.getColumnIndex("ADDR")));
                    Log.d("DB_T","NAME="+ all_cursor.getString(all_cursor.getColumnIndex("NAME")));
                }
                break;
            case R.id.DB_U:
                F_DB.update("1",30,"01011112222","busan","rigga");
                break;
            case R.id.DB_D:
                F_DB.deleteAll();
                break;
        }
    }
}
