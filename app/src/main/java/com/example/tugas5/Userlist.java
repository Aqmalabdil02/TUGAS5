package com.example.tugas5;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Userlist extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> name, quantity, price;
    DBHelper DB;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userlist);

            DB = new DBHelper(this);
            name = new ArrayList<>();
            quantity = new ArrayList<>();
            price = new ArrayList<>();
            recyclerView = findViewById(R.id.recylerview);
            adapter = new MyAdapter(this, name, quantity, price);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            displaydata();
    }

    private void displaydata() {
        Cursor cursor = DB.getdata();

        if (cursor.getCount()==0)
        {
            Toast.makeText(Userlist.this, "No Entry Exist", Toast.LENGTH_SHORT).show();
            return;
        }
        else
        {
            while (cursor.moveToNext())
            {
                name.add(cursor.getString(0));
                quantity.add(cursor.getString(1));
                price.add(cursor.getString(2));

            }
        }
    }
}