package com.example.tanmoy.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText et1,et2;
Button b1;
int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.b1);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                buttonSet();
            }
        });
    }

    private void buttonSet()
    {
        String email=et1.getText().toString();
        String pass=et2.getText().toString();

        if(email.equalsIgnoreCase("Joy")&& pass.equalsIgnoreCase("12345"))
        {
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            count++;
            if(count==3)
            {
                b1.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Please wait for 8 sec...",Toast.LENGTH_LONG).show();
                b1.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        b1.setEnabled(true);
                    }
                },8000);
                count=0;
            }
        }
    }
}
