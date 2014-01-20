package com.example.DRS;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;


public class Welcome extends Activity implements Animation.AnimationListener {
    /**
     * Called when the activity is first created.
     *
     */
    RelativeLayout mainLayout;
    Button disadd;
    Button prevadd;
    Button alleradd;
    int disbutcnt = 0;
    int prevbutcnt = 0;
    int allerbutcnt = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        TextView todrs = (TextView) findViewById(R.id.todrs);
        Button doc = (Button) findViewById(R.id.doctor);
        doc.setVisibility(View.GONE);
        todrs.setVisibility(View.GONE);

        TextView welcome = (TextView) findViewById(R.id.welcome);

        Typeface tf1 = Typeface.createFromAsset(getAssets(),
                "Fonts/HARNGTON.TTF");


        Typeface tf2 = Typeface.createFromAsset(getAssets(),
                "Fonts/BUBBLE.ttf");
        welcome.setTypeface(tf2);
        todrs.setTypeface(tf1);

        Button patient = (Button) findViewById(R.id.patient);
        patient.setVisibility(View.GONE);

        mainLayout = (RelativeLayout)findViewById(R.id.welcomelay);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);

        animation.setAnimationListener(this);


        View animatedView = findViewById(R.id.welcome);

       // animatedView.startAnimation(animation);




        todrs.setVisibility(View.VISIBLE);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.animation1);

        //animation1.setAnimationListener(this);


        View animatedView1 = findViewById(R.id.todrs);

        //animatedView1.startAnimation(animation1);

        Animation animation2 = AnimationUtils.loadAnimation(this, R.anim.animation2);

        //animation2.setAnimationListener(this);
        View animatedView2 = findViewById(R.id.doctorimg);

        //animatedView2.startAnimation(animation2);

        Animation animation3 = AnimationUtils.loadAnimation(this, R.anim.animation3);

        //animation3.setAnimationListener(this);
        doc.setVisibility(View.VISIBLE);
        View animatedView3 = findViewById(R.id.doctor);

        //animatedView3.startAnimation(animation3);

        Animation animation4 = AnimationUtils.loadAnimation(this, R.anim.animation4);
        patient.setVisibility(View.VISIBLE);
       // animation4.setAnimationListener(this);
        View animatedView4 = findViewById(R.id.patient);

        //animatedView4.startAnimation(animation4);



       //welcome.animate();

        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ourIntent   = new Intent(Welcome.this, drugdrs.class);
                startActivity(ourIntent);
            }
        });

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ourIntent   = new Intent(Welcome.this, DrugInfo.class);
                ourIntent.putExtra("DrugName","Patient");
                startActivity(ourIntent);
            }
        });



    }
    void anim() {

    }


    @Override
    public void onAnimationStart(Animation animation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
