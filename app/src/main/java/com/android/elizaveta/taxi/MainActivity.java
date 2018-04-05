package com.android.elizaveta.taxi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button butRegistration;
    private EditText etName, etSurname, etTelephone;
    private SharedPreferences sPref;
    private static final String TAG = "myLogs";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("etName", etName.getText().toString());
        outState.putString("etSurname", etSurname.getText().toString());
        outState.putString("etTelephone", etTelephone.getText().toString());

    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        etName.setText(savedInstanceState.getString("etName"));
        etSurname.setText(savedInstanceState.getString("etSurname"));
        etTelephone.setText(savedInstanceState.getString("etTelephone"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Main activity onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butRegistration = (Button) findViewById(R.id.button);
        etName = (EditText) findViewById(R.id.editTextName);
        etSurname = (EditText) findViewById(R.id.editTextSurname);
        etTelephone = (EditText) findViewById(R.id.editTextTelephone);
        sPref = getPreferences(MODE_PRIVATE);
        String savedName = sPref.getString("Name", "");
        String savedSurname = sPref.getString("Surname", "");
        String savedTelephone = sPref.getString("Telephone", "");
        etName.setText(savedName);
        etSurname.setText(savedSurname);
        etTelephone.setText(savedTelephone);
        Toast.makeText(this, "Data loaded", Toast.LENGTH_SHORT).show();
        if (!etName.equals("") && !etSurname.equals("") && !etTelephone.equals("")) {
            butRegistration.setText("LOG IN");
        }
        etName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etName.getText().toString().equals(sPref.getString("Name", etName.getText().toString()))) {
                    butRegistration.setText("REGISTRATION");
                }
                else {
                    butRegistration.setText("LOG IN");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etSurname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etSurname.getText().toString().equals(sPref.getString("Surname", etSurname.getText().toString()))) {
                    butRegistration.setText("REGISTRATION");
                }
                else {
                    butRegistration.setText("LOG IN");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        etTelephone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!etTelephone.getText().toString().equals(sPref.getString("Telephone", etTelephone.getText().toString()))) {
                    butRegistration.setText("REGISTRATION");
                }
                else {
                    butRegistration.setText("LOG IN");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        butRegistration.setOnClickListener(this);
        etName.setOnClickListener(this);
        etSurname.setOnClickListener(this);
        etTelephone.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button:
                if (etName.getText().toString().equals("") || etSurname.getText().toString().equals("") || etTelephone.getText().toString().equals("")) {
                    Toast.makeText(this, "Not enough information for registration", Toast.LENGTH_SHORT).show();

                }
                else {
                    Intent intent = new Intent(this, SecondActivity.class);
                    intent.putExtra("Name", etName.getText().toString());
                    intent.putExtra("Surname", etSurname.getText().toString());
                    intent.putExtra("Telephone", etTelephone.getText().toString());
                    startActivity(intent);
                }

        }

    }

    @Override
    protected void onStart(){
        Log.i(TAG, "Main activity onStart");
        super.onStart();
    }

    @Override
    protected void onResume(){
        Log.i(TAG, "Main activity onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "Main activity onRestart");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "Main activity onStop");
        super.onStop();
    }


    @Override
    protected void onDestroy() {
        Log.i(TAG, "Main activity onDestroy");
        super.onDestroy();
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putString("Name", etName.getText().toString());
        editor.putString("Surname", etSurname.getText().toString());
        editor.putString("Telephone", etTelephone.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();


    }
}
