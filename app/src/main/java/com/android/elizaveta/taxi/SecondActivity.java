package com.android.elizaveta.taxi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonSetPath, buttonCall;
    private TextView tvNameSurname, tvTelephone, tvPath;
    private static final String TAG = "myLogs";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tvNameSurname", tvNameSurname.getText().toString());
        outState.putString("tvTelephone", tvTelephone.getText().toString());
        outState.putString("tvPath", tvPath.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        tvNameSurname.setText(savedInstanceState.getString("tvNameSurname"));
        tvTelephone.setText(savedInstanceState.getString("tvTelephone"));
        tvPath.setText(savedInstanceState.getString("tvPath"));
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "Second activity onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        buttonSetPath = (Button) findViewById(R.id.buttonSetPath);
        buttonCall = (Button) findViewById(R.id.buttonCall);
        tvNameSurname = (TextView) findViewById(R.id.textViewNameSurname);
        tvTelephone = (TextView) findViewById(R.id.textViewPhone);
        tvPath = (TextView) findViewById(R.id.textViewPath);

        buttonSetPath.setOnClickListener(this);
        buttonCall.setOnClickListener(this);
        tvNameSurname.setOnClickListener(this);
        tvTelephone.setOnClickListener(this);
        tvPath.setOnClickListener(this);
        buttonCall.setEnabled(false);


        Intent intent = getIntent();
        tvNameSurname.setText(intent.getStringExtra("Name") + " " + intent.getStringExtra("Surname"));
        tvTelephone.setText(intent.getStringExtra("Telephone"));

    }

    @Override
    public void onClick (View v){


        switch(v.getId()){
            case R.id.buttonSetPath:
                Intent intent = new Intent("android.intent.action.ThirdActivity");
                startActivityForResult(intent, 3);
                break;
            case R.id.buttonCall:
                Toast.makeText(this, "Taxi will arrive in 5 minutes", Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    protected void onStart() {
        Log.i(TAG, "Second activity onStart");
        super.onStart();
    }
    @Override
    protected void onResume(){
        Log.i(TAG, "Second activity onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "Second activity onRestart");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "Second activity onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "Second activity onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (data == null) {
            return;
        }
        String streetFrom = data.getStringExtra("StreetFrom");
        String houseFrom = data.getStringExtra("HouseFrom");
        String flatFrom = data.getStringExtra("FlatFrom");
        String streetTo  = data.getStringExtra("StreetTo");
        String houseTo = data.getStringExtra("HouseTo");
        String flatTo = data.getStringExtra("FlatTo");
        if (streetFrom.equals("") || houseFrom.equals("") || flatFrom.equals("") || streetTo.equals("") || houseTo.equals("") || flatTo.equals("")) {
            Toast.makeText(this, "Not enough information about your location", Toast.LENGTH_SHORT).show();
        }
        else {
            tvPath.setText("Taxi will arrive at " + data.getStringExtra("StreetFrom") + ", " + data.getStringExtra("HouseFrom")
                    + ", " + data.getStringExtra("FlatFrom") + " in 5 minutes and take you to " + data.getStringExtra("StreetTo") + ", "
                    + data.getStringExtra("HouseTo") + ", " + data.getStringExtra("FlatTo") + ". If you are agree click CALL TAXI");
            buttonCall.setEnabled(true);
        }

    }
}
