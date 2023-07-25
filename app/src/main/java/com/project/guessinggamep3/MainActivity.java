package com.project.guessinggamep3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private RadioButton radio1,radio2,radio3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button=findViewById(R.id.startbutton);
        radio1=findViewById(R.id.radioButton1);
        radio2=findViewById(R.id.radioButton2);
        radio3=findViewById(R.id.radioButton3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,gameactivity.class);
                if(!radio1.isChecked() && !radio2.isChecked() && !radio3.isChecked())
                {
                    Snackbar.make(v,"Please select a number of digit",Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if(radio1.isChecked())
                    {
                        intent.putExtra("two" ,true);
                    }
                    if(radio2.isChecked())
                    {
                        intent.putExtra("three",true);
                    }
                    if(radio3.isChecked())
                    {
                        intent.putExtra("four",true);
                    }
                    startActivity(intent);
                }
            }
        });

    }
}