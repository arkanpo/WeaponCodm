package com.example.weaponcodm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class DetailAct extends AppCompatActivity {

    ProgressBar pb_demage,pb_firerate,pb_accuracy,pb_range,pb_movment;
    TextView txt_demage,txt_firerate,txt_accuracy,txt_range,txt_movment,nama,level,effect,type;
    ImageView image;
    LinearLayout bg_level;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        pb_demage = findViewById(R.id.pb_demage);
        pb_firerate = findViewById(R.id.pb_firerate);
        pb_accuracy = findViewById(R.id.pb_accuracy);
        pb_range = findViewById(R.id.pb_range);
        pb_movment = findViewById(R.id.pb_movment);

        txt_demage = findViewById(R.id.txt_demage);
        txt_firerate = findViewById(R.id.txt_firerate);
        txt_accuracy = findViewById(R.id.txt_accuracy);
        txt_range = findViewById(R.id.txt_range);
        txt_movment = findViewById(R.id.txt_movment);
        type = findViewById(R.id.type);

        nama = findViewById(R.id.nama);
        level = findViewById(R.id.level);
        effect = findViewById(R.id.effect);

        image = findViewById(R.id.image);
        bg_level = findViewById(R.id.bg_level);

        Bundle bundle = getIntent().getExtras();
        final String senjata = bundle.getString("nama_wisata");
        final String typex = bundle.getString("type");
        final String leveling = bundle.getString("leveling");


        if (leveling.equals("RARE")) {
            bg_level.setBackgroundResource(R.drawable.bg_lvlrare);

        }

        if (leveling.equals("COMMON")) {
            bg_level.setBackgroundResource(R.drawable.bg_lvlcommon);

        }

        if (leveling.equals("UNCOMMON")) {
            bg_level.setBackgroundResource(R.drawable.bg_lvluncommon);

        }

        if (leveling.equals("EPIC")) {
            bg_level.setBackgroundResource(R.drawable.bg_lvlepic);

        }

        reference = FirebaseDatabase.getInstance().getReference().child("Weapon").child(typex).child(senjata);
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                txt_demage.setText(dataSnapshot.child("demage").getValue().toString());
                txt_firerate.setText(dataSnapshot.child("fire_rate").getValue().toString());
                txt_accuracy.setText(dataSnapshot.child("accuracy").getValue().toString());
                txt_movment.setText(dataSnapshot.child("movment").getValue().toString());
                txt_range.setText(dataSnapshot.child("range").getValue().toString());
                nama.setText(dataSnapshot.child("nama").getValue().toString());
                level.setText(dataSnapshot.child("level").getValue().toString());
                effect.setText(dataSnapshot.child("effect").getValue().toString());
                type.setText(dataSnapshot.child("type").getValue().toString());

                Picasso.with(DetailAct.this)
                        .load(dataSnapshot.child("image")
                                .getValue().toString()).centerCrop().fit()
                        .into(image);


                String demage_pb = txt_demage.getText().toString();
                pb_demage.setProgress(Integer.parseInt(demage_pb));

                String firerate_pb = txt_firerate.getText().toString();
                pb_firerate.setProgress(Integer.parseInt(firerate_pb));

                String accuracy_pb = txt_accuracy.getText().toString();
                pb_accuracy.setProgress(Integer.parseInt(accuracy_pb));

                String movment_pb = txt_movment.getText().toString();
                pb_movment.setProgress(Integer.parseInt(movment_pb));

                String range_pb = txt_range.getText().toString();
                pb_range.setProgress(Integer.parseInt(range_pb));


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });










    }
}
