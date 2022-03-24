package com.example.firebaseexample;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText edt_veri,ededt_veri_goster;
    Button btn_gonder,btn_verigoster;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mesaj = database.getReference("Mesaj"); //Mesaj databsemin ismi


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_veri=findViewById(R.id.edt_veri);
        ededt_veri_goster=findViewById(R.id.edt_veri_goster);

        btn_gonder=findViewById(R.id.btn_verigonder);
        btn_verigoster=findViewById(R.id.btn_verigoster);

       btn_gonder.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String veri=edt_veri.getText().toString();
               mesaj.setValue(veri);
           }
       });

       btn_verigoster.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
// Read from the database
               mesaj.addValueEventListener(new ValueEventListener() {
                   @Override
                   public void onDataChange(DataSnapshot dataSnapshot) {
                       // This method is called once with the initial value and again
                       // whenever data at this location is updated.
                       String gelenveri = dataSnapshot.getValue(String.class);
                       ededt_veri_goster.setText(gelenveri);
                   }



                   @Override
                   public void onCancelled(DatabaseError error) {
                       // Failed to read value

                   }
               });

           }
       });
    }
}