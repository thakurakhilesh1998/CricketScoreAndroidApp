package com.example.cricketscorekeeper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    Spinner spinner;
    Button btnSelect,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btne,btnout,btnReset;
    TextView tvScoreA,tvBallsA,tvScoreB,tvBallsB;
    ScrollView parentLayout;
    int position=0;
    String team="";
    int scoretemaA=0;
    int getScoretemaB=0;
    int outA=0;
    int outB=0;
    int ballsA=0;
    int getBallsB=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIds();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.teams, R.layout.test);
        adapter.setDropDownViewResource(R.layout.test);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        btnSelect.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btne.setOnClickListener(this);
        btnout.setOnClickListener(this);
        btnReset.setOnClickListener(this);
    }


    private void findIds() {
        //spinnner ids
        spinner=findViewById(R.id.spinner);

        //buttons id
        btnSelect=findViewById(R.id.btnSelect);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btne=findViewById(R.id.btne);
        btnout=findViewById(R.id.btnout);
        btnReset=findViewById(R.id.btnReset);

        //textview ids
        tvScoreA=findViewById(R.id.tvScoreA);
        tvScoreB=findViewById(R.id.tvScoreB);
        tvBallsA=findViewById(R.id.tvBallsA);
        tvBallsB=findViewById(R.id.tvBallsB);

        //layout
        parentLayout=findViewById(R.id.parentLayout);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        position=i;
        team =adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnSelect:
                onSelectTeam();
                break;
            case R.id.btn0:
                setScore(0);
                break;
            case R.id.btn1:
                setScore(1);
                break;
            case R.id.btn2:
                setScore(2);
                break;
            case R.id.btn3:
                setScore(3);
                break;
            case R.id.btn4:
                setScore(4);
                break;
            case R.id.btn5:
                setScore(5);
                break;
            case R.id.btn6:
                setScore(6);
                break;
            case R.id.btne:
                setScore(8);
                break;
            case R.id.btnout:
                setScore(-1);
                break;
            case R.id.btnReset:
                onReset();
        }

    }

    private void onReset() {
        scoretemaA=0;
        getScoretemaB=0;
        outA=0;
        outB=0;
        ballsA=0;
        getBallsB=0;
        tvBallsA.setText("No ball bowled yet");
        tvBallsB.setText("No Ball bowled yet");
        tvScoreA.setText("No score");
        tvScoreB.setText("No score");
    }

    void onSelectTeam()
    {
        if(position==0)
        {
            Snackbar snackbar = Snackbar.make(parentLayout, "Please Select Team", Snackbar.LENGTH_LONG);
            snackbar.show();
        }
    }

    void setScore(int score)
    {
        if(position==1)
        {
            if(score>=0)
            {
                if(score==8)
                {
                    scoretemaA++;
                }
                else
                {
                    scoretemaA+=score;
                    ballsA++;
                }
            }
            else
                {
                outA++;
            }
            tvScoreA.setText(scoretemaA+"/"+outA);
            tvBallsA.setText(String.valueOf(ballsA));
        }
        else if(position==2)
        {
            if(score>=0)
            {
                if(score==8)
                {
                    getScoretemaB++;
                }
                else {
                    getScoretemaB += score;
                    getBallsB++;
                }
            }
            else
            {
                outB++;
            }
            tvScoreB.setText(getScoretemaB+"/"+outB);
            tvBallsB.setText(String.valueOf(getBallsB));
        }
    }
}
