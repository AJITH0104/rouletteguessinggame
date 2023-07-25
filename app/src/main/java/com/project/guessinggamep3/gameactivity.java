package com.project.guessinggamep3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class gameactivity extends AppCompatActivity {


    private TextView textviewlast,textright,texthint;
    private Button buttonconfirm;
    private EditText editguess;
    Boolean twodigits,threedigits,fourdigits;

    Random r =new Random();
    int random,remryt=10;
    ArrayList<Integer> guesslist=new ArrayList<>();
    int userattempts=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameactivity);

        textviewlast=findViewById(R.id.textViewlast);
        texthint=findViewById(R.id.textviewhint);
        textright=findViewById(R.id.textViewright);
        buttonconfirm=findViewById(R.id.confirm);
        editguess=findViewById(R.id.editTextNumberguest);

        twodigits=getIntent().getBooleanExtra("two",false);
        threedigits=getIntent().getBooleanExtra("three",false);
        fourdigits=getIntent().getBooleanExtra("four",false);

        if(twodigits)
            random=r.nextInt(90)+10;
        if(threedigits)
            random=r.nextInt(900)+100;
        if(fourdigits)
            random=r.nextInt(9000)+1000;

        buttonconfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String guess=editguess.getText().toString();
                if(guess.equals(""))
                    Toast.makeText(gameactivity.this,"Please enter a guess",Toast.LENGTH_LONG).show();
                else
                {
                    texthint.setVisibility(View.VISIBLE);
                    textright.setVisibility(View.VISIBLE);
                    textviewlast.setVisibility(View.VISIBLE);
                    remryt--;
                    userattempts--;
                    int userguess=Integer.parseInt(guess);
                    guesslist.add(userguess);
                    textviewlast.setText("your last guess"+guess);
                    textright.setText("your remaining right"+remryt);

                    if(random==userguess) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(gameactivity.this);
                        builder.setTitle("Number guessing game");
                        builder.setCancelable(false);
                        builder.setMessage("Congrats my guess was  "+random+"\n\n you know my number in "+userattempts+"attempts .\n\n your guess :"+guesslist+"\n\nwanna play again?");
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent=new Intent(gameactivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });
                        builder.create().show();

                    }
                    if(random< userguess) {
                        texthint.setText("Decrease your guess");
                    }
                    if(random>userguess) {
                        texthint.setText("Increase your guess");
                    }
                    if(remryt==0)
                    {
                        AlertDialog.Builder builder = new AlertDialog.Builder(gameactivity.this);
                        builder.setTitle("Number guessing game");
                        builder.setCancelable(false);
                        builder.setMessage("Sorry your right to guess is over \n\n my guess was"+random
                                +".\n\n your guess :"+guesslist+"\n\nwanna play again?");
                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent intent=new Intent(gameactivity.this,MainActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        });
                        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        });
                        builder.create().show();
                    }
                    editguess.setText("");


                }
            }
        });


    }
}