package com.casasmap.sharedpreferencesthing;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mUsername;
    EditText mPassword;
    TextView mShowData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsername = (EditText)findViewById(R.id.et_username);
        mPassword = (EditText)findViewById(R.id.et_password);
        mShowData = (TextView)findViewById(R.id.tv_show_data);
    }

    public void onClickSaveData(View view) {
        //MODE PRIVATE so that only this app can hold this data. File name for this sharePreference things is userInfo
        SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        // and editor is need to 'edit': write, modify data into the sharefprefence file
       SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("username", mUsername.getText().toString());
        editor.putString("password", mPassword.getText().toString());
        //to creat the shareprefennce file we 'apply'
        editor.apply();
        //lets display a message indicting we saved the info
        Toast.makeText(this, "Savd carajo", Toast.LENGTH_SHORT).show();
        //reseting input fields....
        mUsername.getText().clear();
        mPassword.getText().clear();

    }

    public void onClickShowData(View view) {
        SharedPreferences sharePref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        //Lets pull data from the reference object: sharePref
        String name = sharePref.getString("username", "");
        String pass = sharePref.getString("password", "");
        mShowData.setText(name + " " + pass);
        Toast.makeText(this, "There is your data motherfucker", Toast.LENGTH_SHORT).show();
    }
}
