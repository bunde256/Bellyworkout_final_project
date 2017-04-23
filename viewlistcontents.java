package com.ema.ema.bellyworkout;


import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EMMA on 4/23/2017.
 */

public class viewlistcontents extends AppCompatActivity {
   DatabaseHelper  myDB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);
        ListView listView=(ListView)findViewById(R.id.listview);

        myDB=new DatabaseHelper(this);


        ArrayList<String> theList=new ArrayList<>();
        Cursor data=myDB.getListContents();


        if(data.getCount()==0){
            Toast.makeText(viewlistcontents.this,"empty database!",Toast.LENGTH_LONG).show();

        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);

            }
        }
    }



    }



