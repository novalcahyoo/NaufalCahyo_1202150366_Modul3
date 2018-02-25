package com.naufalcahyo.naufalcahyo_1202150366_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText uname, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        uname = (EditText) findViewById(R.id.editTextUname);
        pass = (EditText) findViewById(R.id.editTextPassword);
    }

    public void Login(View view) {
        String unamee = uname.getText().toString();
        String passw = pass.getText().toString();

        if (unamee.isEmpty()|| passw.isEmpty() ){
            Toast.makeText(this,"Silahkan lengkapi dahulu " +
                    "username dan passwor anda",Toast.LENGTH_SHORT).show();
        }else if (unamee.equals("EAD") && passw.equals("MOBILE")) {
            //menjalankan intent dan pindah ke MainMenu
            Toast.makeText(this,"Selamat datang " + unamee ,Toast.LENGTH_SHORT).show();
            startActivity(new Intent(Login.this, MainActivityAir.class));
        } else {
            Toast.makeText(this,"Username/Password salah "  ,Toast.LENGTH_SHORT).show();
        }
    }
}
