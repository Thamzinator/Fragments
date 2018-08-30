package com.example.tcssi.fragments;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.example.tcssi.fragments.R;
import java.util.HashMap;
import java.util.Map;

public class ProfileEditActivity extends AppCompatActivity {

    private EditText mName;
    private EditText mSurname;
    private EditText mAddress;
    private EditText mBirthday;
    private Button mSaveBtn;

    private FirebaseFirestore mFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_edit);

        mName = findViewById(R.id.input_name);
        mSurname = findViewById(R.id.input_surname);
        mAddress = findViewById(R.id.input_address);
        mBirthday = findViewById(R.id.input_birthday);
        mSaveBtn = findViewById(R.id.save_changes);

        mFirestore = FirebaseFirestore.getInstance();

        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mName.getText().toString();
                String surname = mSurname.getText().toString();
                String address = mAddress.getText().toString();
                String birthday = mBirthday.getText().toString();

                Map<String, String> userMap = new HashMap<>();

                userMap.put("name", name);
                userMap.put("surname", surname);
                userMap.put("address", address);
                userMap.put("birthday", birthday);

                mFirestore.collection("users").add(userMap).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {

                        Toast.makeText(ProfileEditActivity.this, "Username Added", Toast.LENGTH_LONG).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(ProfileEditActivity.this, "Error saving", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}

