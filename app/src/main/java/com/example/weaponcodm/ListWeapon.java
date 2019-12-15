package com.example.weaponcodm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListWeapon extends AppCompatActivity {

    RecyclerView recyclerview;
    ArrayList<Profile> list;
    MyAdapter myAdapter;
    SearchView searchview2;
    ImageView back;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_weapon);
        recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        searchview2 = findViewById(R.id.searchview2);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abc = new Intent(ListWeapon.this,HomeAct.class);
                startActivity(abc);
            }
        });

        Bundle bundle = getIntent().getExtras();
        final String jenis_ticket_baru = bundle.getString("jenis_senjata");

        reference = FirebaseDatabase.getInstance().getReference().child("Weapon").child(jenis_ticket_baru);

    }

    @Override
    protected void onStart() {
        super.onStart();

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (reference != null)
                {
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists())
                            {
                                list = new ArrayList<>();
                                for (DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){
                                    Profile p = dataSnapshot1.getValue(Profile.class);
                                    list.add(p);
                                }
                                MyAdapter myAdapter = new MyAdapter(ListWeapon.this,list);
                                recyclerview.setAdapter(myAdapter);
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(ListWeapon.this, "",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        if (searchview2 != null ){
            searchview2.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String s) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    search(s);
                    return false;
                }
            });
        }

    }

    private void search(String str){
        ArrayList<Profile> myList = new ArrayList<>();
        for (Profile object : list)
        {
            if (object.getNama().toLowerCase().contains(str.toLowerCase()))
            {
                myList.add(object);
            }
        }
        MyAdapter myAdapter = new MyAdapter(ListWeapon.this,myList);
        recyclerview.setAdapter(myAdapter);
    }


}
