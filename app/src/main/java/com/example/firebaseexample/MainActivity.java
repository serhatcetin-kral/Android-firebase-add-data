package com.example.firebaseexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText edt_veri;
    Button btn_gonder;
    FirebaseDatabase database=FirebaseDatabase.getInstance();
    DatabaseReference mesaj = database.getReference("Mesaj"); //Mesaj databsemin ismi


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_veri=findViewById(R.id.edt_veri);
        btn_gonder=findViewById(R.id.btn_verigonder);

       btn_gonder.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String veri=edt_veri.getText().toString();
               mesaj.setValue(veri);
           }
       });
    }
}