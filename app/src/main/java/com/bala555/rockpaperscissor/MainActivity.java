package com.bala555.rockpaperscissor;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button rockButton;
    Button paperButton;
    Button scissorButton;
    ImageView com_ImageView;
    ImageView user_ImageView;
    String userValue = "", comValue = "", result = "";
    Random random;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rockButton = (Button) findViewById(R.id.rockButton);
        paperButton = (Button) findViewById(R.id.paperButton);
        scissorButton = (Button) findViewById(R.id.scissorButton);

        com_ImageView = (ImageView) findViewById(R.id.com_ImageView);
        user_ImageView = (ImageView) findViewById(R.id.user_ImageView);

        random = new Random();

        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_ImageView.setImageResource(R.drawable.rock);
                Generate();
                userValue = "rock";
                Result();
            }
        });

        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_ImageView.setImageResource(R.drawable.paper);
                Generate();
                userValue = "paper";
                Result();
            }
        });

        scissorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user_ImageView.setImageResource(R.drawable.scissor);
                Generate();
                userValue = "scissor";
                Result();
            }
        });
    }

    public void Generate() {

        num = random.nextInt(3);

        if (num == 0) {
            comValue = "rock";
            com_ImageView.setImageResource(R.drawable.rock);
        }
        if (num == 1) {
            comValue = "paper";
            com_ImageView.setImageResource(R.drawable.paper);
        } else if (num == 2) {
            comValue = "scissor";
            com_ImageView.setImageResource(R.drawable.scissor);
        }
    }

    public void Result() {

        if ((userValue.equals("rock")) && (comValue.equals("rock"))) {
            result = getString(R.string.Draw);
            Toast(result);
        } else if ((userValue.equals("paper")) && (comValue.equals("paper"))) {
            result = getString(R.string.Draw);
            Toast(result);
        } else if ((userValue.equals("scissor")) && (comValue.equals("scissor"))) {
            result = getString(R.string.Draw);
            Toast(result);
        } else if ((userValue.equals("rock")) && (comValue.equals("paper"))) {
            result = getString(R.string.Lose);
            Toast(result);
        } else if ((userValue.equals("rock")) && (comValue.equals("scissor"))) {
            result = getString(R.string.Win);
            Toast(result);
        } else if ((userValue.equals("scissor")) && (comValue.equals("paper"))) {
            result = getString(R.string.Win);
            Toast(result);
        } else if ((userValue.equals("scissor")) && (comValue.equals("rock"))) {
            result = getString(R.string.Lose);
            Toast(result);
        } else if ((userValue.equals("paper")) && (comValue.equals("scissor"))) {
            result = getString(R.string.Lose);
            Toast(result);
        } else if ((userValue.equals("paper")) && (comValue.equals("rock"))) {
            result = getString(R.string.Win);
            Toast(result);
        }
    }

    public void Toast(String string) {
        Toast.makeText(getApplicationContext(), string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setCancelable(false).setMessage("Do you want to close the app");

        alert.setPositiveButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alert.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog dailog = alert.create();
        dailog.show();
    }


}
