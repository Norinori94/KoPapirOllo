package com.example.nori.kpaproll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView ImageView_ember, ImageView_robot;
    private TextView TextView_szam_ember, TextView_szam_robot, TextView_erosseg, TextView_vegeredmeny;
    private Button Button_ko, Button_papir, Button_ollo;

    private Random r = new Random();

    private int szam_ember = 0;
    private int szam_robot = 0;
    private int valasztas_ember, valasztas_robot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Button_ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valasztas_ember = 0;
                valasztas_robot = r.nextInt(3);
                ImageView_ember.setBackgroundResource(R.drawable.rock);

                robot();
                eredmeny();

                TextView_szam_ember.setText(""+ szam_ember);
                TextView_szam_robot.setText(""+ szam_robot);
            }
        });

        Button_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valasztas_ember = 1;
                valasztas_robot = r.nextInt(3);
                ImageView_ember.setBackgroundResource(R.drawable.paper);

                robot();
                eredmeny();

                TextView_szam_ember.setText(""+ szam_ember);
                TextView_szam_robot.setText(""+ szam_robot);
            }
        });

        Button_ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valasztas_ember = 2;
                valasztas_robot = r.nextInt(3);
                ImageView_ember.setBackgroundResource(R.drawable.scissors);

                robot();
                eredmeny();

                TextView_szam_ember.setText(""+ szam_ember);
                TextView_szam_robot.setText(""+ szam_robot);
            }
        });

    }

    public void init(){
        ImageView_robot = (ImageView) findViewById(R.id.ImageView_robot);
        ImageView_ember = (ImageView) findViewById(R.id.ImageView_ember);

        Button_ko = (Button) findViewById(R.id.Button_ko);
        Button_papir = (Button) findViewById(R.id.Button_papir);
        Button_ollo = (Button) findViewById(R.id.Button_ollo);

        TextView_szam_ember = (TextView) findViewById(R.id.TextView_szam_ember);
        TextView_szam_robot = (TextView) findViewById(R.id.TextView_szam_robot);
        TextView_erosseg = (TextView) findViewById(R.id.TextView_erosseg);
        TextView_vegeredmeny = (TextView) findViewById(R.id.TextView_vegeredmeny);
    }

    public void robot(){
        if (valasztas_robot == 0){
            ImageView_robot.setBackgroundResource(R.drawable.rock);
        }

        if (valasztas_robot == 1){
            ImageView_robot.setBackgroundResource(R.drawable.paper);
        }

        if (valasztas_robot == 2){
            ImageView_robot.setBackgroundResource(R.drawable.scissors);
        }
    }

    public void eredmeny(){
        if (valasztas_ember == 0 && valasztas_robot == 0){
            TextView_erosseg.setText("Döntetlen.");
            TextView_vegeredmeny.setText("Senki nem nyert!");
        }

        if (valasztas_ember == 0 && valasztas_robot == 1){
            TextView_erosseg.setText("A papír erősebb, mint a kő.");
            TextView_vegeredmeny.setText("A robot nyert!");
            szam_robot ++;
        }

        if (valasztas_ember == 0 && valasztas_robot == 2){
            TextView_erosseg.setText("A kő erősebb, mint az olló.");
            TextView_vegeredmeny.setText("Te nyertél!");
            szam_ember++;
        }

        if (valasztas_ember == 1 && valasztas_robot == 0){
            TextView_erosseg.setText("A papír erősebb, mint a kő.");
            TextView_vegeredmeny.setText("Te nyertél!");
            szam_ember++;
        }

        if (valasztas_ember == 1 && valasztas_robot == 1){
            TextView_erosseg.setText("Döntetlen.");
            TextView_vegeredmeny.setText("Senki nem nyert!");
        }

        if (valasztas_ember == 1 && valasztas_robot == 2){
            TextView_erosseg.setText("Az olló erősebb, mint a papír.");
            TextView_vegeredmeny.setText("A robot nyert!");
            szam_robot ++;
        }

        if (valasztas_ember == 2 && valasztas_robot == 0){
            TextView_erosseg.setText("A kő erősebb, mint az olló.");
            TextView_vegeredmeny.setText("A robot nyert!");
            szam_robot ++;
        }

        if (valasztas_ember == 2 && valasztas_robot == 1){
            TextView_erosseg.setText("Az olló erősebb, mint a papír.");
            TextView_vegeredmeny.setText("Te nyertél!");
            szam_ember++;
        }

        if (valasztas_ember == 2 && valasztas_robot == 2){
            TextView_erosseg.setText("Döntetlen.");
            TextView_vegeredmeny.setText("Senki nem nyert!");
        }
    }
}
