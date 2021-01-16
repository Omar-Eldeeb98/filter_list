package com.example.filter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<SpaceCraft> spaceCrafts = new ArrayList<>();
     ListView lv;
     SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        // presents Views
        lv= (ListView) findViewById( R.id.lv );
        sv = (SearchView) findViewById( R.id.sv);

        //populate data
        fillData();



        //adapter
           final ArrayAdapter<SpaceCraft> adapter = new ArrayAdapter<>( MainActivity.this , android.R.layout.simple_list_item_1 , spaceCrafts);
            lv.setAdapter( adapter );

            // events
        sv.setOnQueryTextListener( new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // filter
                adapter.getFilter().filter(newText);
                return false;
            }
        } );

        lv.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText( MainActivity.this,adapter.getItem( position ).getName() , Toast.LENGTH_SHORT  ).show();
            }
        } );

    }

    private void fillData() {

        spaceCrafts.add( new SpaceCraft( "Omar" ) );
        spaceCrafts.add( new SpaceCraft( "kok" ) );
        spaceCrafts.add( new SpaceCraft( "yasser" ) );


    }
}
