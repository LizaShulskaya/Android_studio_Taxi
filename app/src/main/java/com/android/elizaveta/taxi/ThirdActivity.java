package com.android.elizaveta.taxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonOk;
    private EditText etStreetTo, etHouseTo, etFlatTo, etStreetFrom, etHouseFrom, etFlatFrom;
    private static final String TAG = "myLogs";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("etStreetTo", etStreetTo.getText().toString());
        outState.putString("etHouseTo", etHouseTo.getText().toString());
        outState.putString("etFlatTo", etFlatTo.getText().toString());
        outState.putString("etStreetFrom", etStreetFrom.getText().toString());
        outState.putString("etHouseFrom", etHouseFrom.getText().toString());
        outState.putString("etFlatFrom", etFlatFrom.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        etStreetTo.setText(savedInstanceState.getString("etStreetTo"));
        etHouseTo.setText(savedInstanceState.getString("etHouseTo"));
        etFlatTo.setText(savedInstanceState.getString("etFlatTo"));
        etStreetFrom.setText(savedInstanceState.getString("etStreetFrom"));
        etHouseFrom.setText(savedInstanceState.getString("etHouseFrom"));
        etFlatFrom.setText(savedInstanceState.getString("etFlatFrom"));
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Third activity onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        etStreetTo = (EditText) findViewById(R.id.editTextStreetTo);
        etHouseTo = (EditText) findViewById(R.id.editTextHouseTo);
        etFlatTo = (EditText) findViewById(R.id.editTextFlatTo);
        etStreetFrom = (EditText) findViewById(R.id.editTextStreetFrom);
        etHouseFrom = (EditText) findViewById(R.id.editTextHouseFrom);
        etFlatFrom = (EditText) findViewById(R.id.editTextFlatFrom);
        buttonOk = (Button) findViewById(R.id.button2);


        etStreetTo.setOnClickListener(this);
        etHouseTo.setOnClickListener(this);
        etFlatTo.setOnClickListener(this);
        etStreetFrom.setOnClickListener(this);
        etHouseFrom.setOnClickListener(this);
        etFlatFrom.setOnClickListener(this);
        buttonOk.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button2:

                Intent intent = new Intent();
                intent.putExtra("StreetFrom", etStreetFrom.getText().toString());
                intent.putExtra("HouseFrom", etHouseFrom.getText().toString());
                intent.putExtra("FlatFrom", etFlatFrom.getText().toString());
                intent.putExtra("StreetTo", etStreetTo.getText().toString());
                intent.putExtra("HouseTo", etHouseTo.getText().toString());
                intent.putExtra("FlatTo", etFlatTo.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
        }
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "Third activity onStart");
        super.onStart();
    }
    @Override
    protected void onResume(){
        Log.i(TAG, "Third activity onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "Third activity onRestart");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "Third activity onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "Third activity onDestroy");
        super.onDestroy();
    }
}
