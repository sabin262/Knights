package com.venomxc45.androidtest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private TextView profile;
    private Button logout,save;
    private EditText name;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this,Login.class));
        }
        databaseReference = FirebaseDatabase.getInstance().getReference();
        save = (Button)findViewById(R.id.btnSave);
        name = (EditText)findViewById(R.id.editName);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInfo();
            }
        });
        FirebaseUser user = firebaseAuth.getCurrentUser();

        profile = (TextView)findViewById(R.id.txtProfile);
        profile.setText("Welcome "+user.getEmail());
        logout = (Button)findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(ProfileActivity.this,Login.class));
            }
        });
    }
    public void saveUserInfo(){
        String a = name.getText().toString().trim();
        UserInfo userInfo = new UserInfo(a);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child(user.getUid()).setValue(userInfo);
        Toast.makeText(this,"Info Saved",Toast.LENGTH_LONG).show();
    }
}
