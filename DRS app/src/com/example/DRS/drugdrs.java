package com.example.DRS;

import Library.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;


public class drugdrs extends Activity {
    /**
     * Called when the activity is first created.
     *
     */

    DrawView view1;
    Canvas canvas = new Canvas();

    LinearLayout mainLayout;

    Button disadd;
    Button prevadd;
    Button alleradd;
    int disbutcnt = 0;
    int prevbutcnt = 0;
    int allerbutcnt = 0;
    LinearLayout disll;
    LinearLayout prevll;
    LinearLayout alerll;
    AlertDialog d1,d2,d3;
    static List<String> sendlist;


    static int default_value1 = 0,default_value2 = 0, default_value3 = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        mainLayout = (LinearLayout)findViewById(R.id.mainlayo);
        EditText patientname = (EditText) findViewById(R.id.name);
        disll = (LinearLayout) findViewById(R.id.disLL);
        prevll = (LinearLayout) findViewById(R.id.prevLL);
       alerll = (LinearLayout) findViewById(R.id.alerLL);
        disadd = (Button) findViewById(R.id.displus);
        prevadd = (Button) findViewById(R.id.prevplus);
        alleradd = (Button) findViewById(R.id.allerplus);
       // Button submit = (Button) findViewById(R.id.submit);


        patientname.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {

                v.setFocusable(true);
                v.setFocusableInTouchMode(true);
                return false;
            }
        });

       final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setTitle("DRS");
        //final ActionBar.Action otherAction1 = new ActionBar.IntentAction(this, new Intent(this, Welcome.class), R.drawable.ic_action_remove);
        actionBar.addAction(new CancelAction());
        //final ActionBar.Action otherAction = new ActionBar.IntentAction(new NewAction());
       actionBar.addAction(new NewAction());

         //ActionBar.

        actionBar.setHomeAction(new HomeAction1());
       // actionBar.setDisplayHomeAsUpEnabled(true);


        final LinearLayout layout = (LinearLayout) findViewById(R.id.mainlayo);
        // layout has assigned weight = "1.0" in xml & it's a child of ScrollView
        disadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(disbutcnt < 1) {
                addEditView1();
                disbutcnt++;
                }   else {
                            toast1();
                }
            }
        });

        prevadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(prevbutcnt < 2) {
                    addEditView3();
                    prevbutcnt++;
                }   else {
                    toast2();
                }

            }
        });


        alleradd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allerbutcnt < 2) {
                    addEditView2();
                    allerbutcnt++;
                } else {
                    toast3();
                }
            }
        });

        /*submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int childcount = disll.getChildCount();
                for (int i=1; i < childcount; i++){
                    View r = disll.getChildAt(i);

                    LinearLayout temp = (LinearLayout) r;
                    View e = temp.getChildAt(0);
                    EditText et = (EditText) e;
                    et.getText();
                    et.setText("Good");
                }

                childcount = prevll.getChildCount();
                for (int i=1; i < childcount; i++){
                    View r = prevll.getChildAt(i);

                    LinearLayout temp = (LinearLayout) r;
                    View e = temp.getChildAt(0);
                    EditText et = (EditText) e;
                    et.getText();
                    et.setText("Good");
                }

                childcount = alerll.getChildCount();
                for (int i=1; i < childcount; i++){
                    View r = alerll.getChildAt(i);

                    LinearLayout temp = (LinearLayout) r;
                    View e = temp.getChildAt(0);
                    EditText et = (EditText) e;
                    et.getText();
                    et.setText("Good");
                }
            }
        });      */




    final Button btn = (Button) findViewById(R.id.sex);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            //c.show();
            final CharSequence str[] = {"MALE","FEMALE"};
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(drugdrs.this).setSingleChoiceItems(
                            str, default_value1,new  DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int position)
                        {
                            //Toast.makeText(drugdrs.this,
                                  //  "" + position,
                                   // Toast.LENGTH_SHORT).show();
                            default_value1 = position;
                            btn.setText(str[position]);
                            if(d1.isShowing())
                                d1.dismiss();
                        }
                    }).setTitle("Patient Gender");
            d1 = builder.create();
            d1.show();
        }
    });

        final Button btn1 = (Button) findViewById(R.id.smoking);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //c.show();
                final CharSequence str[] = {"YES","NO"};
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(drugdrs.this).setSingleChoiceItems(
                                str, default_value2,new  DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int position)
                            {
                                /*Toast.makeText(drugdrs.this,
                                        "" + position,
                                        Toast.LENGTH_SHORT).show();  */
                                default_value2 = position;
                                btn1.setText(str[position]);
                                if(d2.isShowing())
                                    d2.dismiss();
                            }
                        }).setTitle("Does Patient Smokes?");
                d2 = builder.create();
                d2.show();
            }
        });


        final Button btn2 = (Button) findViewById(R.id.drinking);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //c.show();
                final CharSequence str[] = {"YES","NO"};
                AlertDialog.Builder builder =
                        new AlertDialog.Builder(drugdrs.this).setSingleChoiceItems(
                                str, default_value3,new  DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int position)
                            {
                                /*Toast.makeText(drugdrs.this,
                                        "" + position,
                                        Toast.LENGTH_SHORT).show(); */
                                default_value3 = position;
                                btn2.setText(str[position]);
                                if(d3.isShowing())
                                    d3.dismiss();
                            }
                        }).setTitle("Does Patient Drinks?");
                d3 = builder.create();
                d3.show();
            }
        });

        addEditView2();
        allerbutcnt++;
        addEditView3();
        prevbutcnt++;


    }

    public void senddata() {
        List l = new ArrayList<String>();


        Button b = (Button) findViewById(R.id.sex);
        String p = b.getText().toString();
        if(p.compareTo("Gender") == 0) {
             Toast.makeText(this,"Please Specify Gender",Toast.LENGTH_LONG).show();
            return;
        }else {
           l.add(p);
        }

        EditText et = (EditText) findViewById(R.id.age);
         p = et.getText().toString();
        l.add(p);



        b = (Button) findViewById(R.id.smoking);
        p = b.getText().toString();
        if(p.compareTo("Smoking") == 0) {
            Toast.makeText(this,"Smoking - YES or NO",Toast.LENGTH_LONG).show();
            return;
        }else {
            l.add(p);
        }


         b = (Button) findViewById(R.id.drinking);
        p = b.getText().toString();
        if(p.compareTo("Drinking") == 0) {
            Toast.makeText(this,"Drinking - YES or NO",Toast.LENGTH_LONG).show();
            return;
        }else {
            l.add(p);
        }

        et = (EditText) findViewById(R.id.BMI);
         p = et.getText().toString();
        l.add(p);


        int i = 0;
        int childcount = alerll.getChildCount();
        for (i=1; i < childcount; i++){
            View r = alerll.getChildAt(i);

            LinearLayout temp = (LinearLayout) r;
            View e = temp.getChildAt(0);
            et = (EditText) e;
            et.getText();
            if(et.getText().toString().compareTo("") == 0) {
                l.add("?");
            }  else {
            l.add(et.getText().toString());
            }
        }
        if(i != 3) {
            for(int j = i; j < 3; j++) {
                l.add("?");
            }
        }

        childcount = prevll.getChildCount();
        i = 0;
        for (i=1; i < childcount; i++){
            View r = prevll.getChildAt(i);

            LinearLayout temp = (LinearLayout) r;
            View e = temp.getChildAt(0);
            et = (EditText) e;
            //et.getText();
            if(et.getText().toString().compareTo("") == 0) {
                l.add("?");
            }  else {
                l.add(et.getText().toString());
            }
        }

        if(i != 3) {
            for(int j = i; j < 3; j++) {
                l.add("?");
            }
        }

        childcount = disll.getChildCount();
        i = 0;
        for (i=1; i < childcount; i++){
            View r = disll.getChildAt(i);

            LinearLayout temp = (LinearLayout) r;
            View e = temp.getChildAt(0);
            et = (EditText) e;
            if(i == 1 && et.getText().toString().compareTo("") == 0) {
                Toast.makeText(this,"Input atleast one Disease",Toast.LENGTH_LONG).show();
                return;
            } else {
                  l.add(et.getText().toString());
            }

        }
        if(i != 3) {
            for(int j = i; j < 3; j++) {
                l.add("?");
            }
        }
        /*List<String> l1 = new ArrayList<String>();
        l1.add("hii");
        l1.add("hello");
        l1.add("hjhj");  */

        drugdrs.sendlist = l;
        Intent ourIntent   = new Intent(drugdrs.this,Result.class);
        startActivity(ourIntent);


    }



    private class NewAction extends ActionBar.AbstractAction {

        public NewAction() {
            super(R.drawable.ic_action_accept);
        }

        @Override
        public void performAction(View view) {

            senddata();


        }

    }


    private class HomeAction1 extends ActionBar.AbstractAction {

        public HomeAction1() {
            super(R.drawable.ic_action_previous_item);
        }

        @Override
        public void performAction(View view) {
          finish();
        }

    }

    private class CancelAction extends ActionBar.AbstractAction {

        public CancelAction() {
            super(R.drawable.ic_action_refresh);
        }

        @Override
        public void performAction(View view) {
            Intent ourIntent   = new Intent(drugdrs.this, drugdrs.class);
            startActivity(ourIntent);
            finish();
        }

    }

    private void addEditView1() {
        // TODO Auto-generated method stub
        /*LinearLayout li=new LinearLayout(this);
        EditText et=new EditText(this);

        li.addView(et);
        li.addView(b);
                          */


        final LinearLayout ll = (LinearLayout) findViewById(R.id.disLL);
        LinearLayout nwdis = new LinearLayout(this);
        EditText et = new EditText(this);
        Button b=new Button(this);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320 , getResources().getDisplayMetrics());
        //LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(height, ViewGroup.LayoutParams.WRAP_CONTENT);
        int hh1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30 , getResources().getDisplayMetrics());
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(height, ViewGroup.LayoutParams.WRAP_CONTENT);
        int mar = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5 , getResources().getDisplayMetrics());
        int mar1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0 , getResources().getDisplayMetrics());
        p.setMargins(mar,mar,mar1,mar);
        et.setLayoutParams(p);
        et.setTextSize(18);
        et.setHint("Input Second Disease");
        et.setHintTextColor(Color.rgb(71,71,71));
        et.setTextColor(Color.BLACK);
        et.setTag(11 + disbutcnt);
        b.setBackgroundResource(R.drawable.minus_sign);
        int h1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20 , getResources().getDisplayMetrics());
        int w1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20 , getResources().getDisplayMetrics());
        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(h1, w1);
        p1.setMargins(mar1,2+mar,mar1,0);

        b.setLayoutParams(p1);
        b.setGravity(Gravity.CENTER);
       // b.setGravity(17);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                 if(disbutcnt > 0) {
                int pos=(Integer) v.getTag();
                System.out.println(pos);
                ll.removeViewAt(ll.getChildCount()-1);
                disbutcnt--;
                 }
            }
        });
        nwdis.addView(et);
        nwdis.addView(b);

        ll.addView(nwdis);
        b.setTag((ll.getChildCount()-1));
        int i = (Integer) b.getTag();

        //oast.makeText(this, i , Toast.LENGTH_LONG).show();
    }

    private void addEditView2() {
        // TODO Auto-generated method stub
        /*LinearLayout li=new LinearLayout(this);
        EditText et=new EditText(this);

        li.addView(et);
        li.addView(b);
                          */

        final LinearLayout ll = (LinearLayout) findViewById(R.id.alerLL);
        LinearLayout nwdis = new LinearLayout(this);
        EditText et = new EditText(this);
        Button b=new Button(this);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320 , getResources().getDisplayMetrics());

        int hh1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30 , getResources().getDisplayMetrics());
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(height, ViewGroup.LayoutParams.WRAP_CONTENT);
        int mar = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5 , getResources().getDisplayMetrics());
        int mar1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0 , getResources().getDisplayMetrics());
        p.setMargins(mar,mar,mar1,mar);
        et.setLayoutParams(p);
        String h = (allerbutcnt + 1) + "";
        et.setHint("Input Allergy " + h);
        et.setTextSize(18);
        et.setHintTextColor(Color.rgb(71,71,71));
        et.setTextColor(Color.BLACK);
        b.setBackgroundResource(R.drawable.minus_sign);
        int h1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20 , getResources().getDisplayMetrics());
        int w1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20 , getResources().getDisplayMetrics());
        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(h1, w1);
        p1.setMargins(mar1,2+mar,mar1,0);
        b.setLayoutParams(p1);
        b.setGravity(Gravity.CENTER);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if(allerbutcnt > 0) {
                    int pos=(Integer) v.getTag();
                    System.out.println(pos);
                    ll.removeViewAt(ll.getChildCount()-1);
                    allerbutcnt--;
                }
            }
        });
        nwdis.addView(et);
        nwdis.addView(b);

        ll.addView(nwdis);
        b.setTag((ll.getChildCount()-1));
        int i = (Integer) b.getTag();

        //oast.makeText(this, i , Toast.LENGTH_LONG).show();
    }

    private void addEditView3() {
        // TODO Auto-generated method stub
        /*LinearLayout li=new LinearLayout(this);
        EditText et=new EditText(this);

        li.addView(et);
        li.addView(b);
                          */

        final LinearLayout ll = (LinearLayout) findViewById(R.id.prevLL);
        LinearLayout nwdis = new LinearLayout(this);
        EditText et = new EditText(this);
        Button b=new Button(this);
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320 , getResources().getDisplayMetrics());
        int hh1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30 , getResources().getDisplayMetrics());
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(height, ViewGroup.LayoutParams.WRAP_CONTENT);
        int mar = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5 , getResources().getDisplayMetrics());
        int mar1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0 , getResources().getDisplayMetrics());
        p.setMargins(mar,2+mar,mar1,mar);
        et.setLayoutParams(p);
        String h = (prevbutcnt + 1) + "";
        et.setHint("Currrent Drug " + h);
        et.setTextSize(18);
        et.setHintTextColor(Color.rgb(71,71,71));
        et.setTextColor(Color.BLACK);
        //et.setTextSize(18);
        b.setBackgroundResource(R.drawable.minus_sign);
        int h1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20 , getResources().getDisplayMetrics());
        int w1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 20 , getResources().getDisplayMetrics());
        LinearLayout.LayoutParams p1 = new LinearLayout.LayoutParams(h1, w1);
        p1.setMargins(mar1,mar,mar1,mar);
        b.setLayoutParams(p1);
        b.setGravity(Gravity.CENTER);
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if(prevbutcnt > 0) {
                    //int pos=(Integer) v.getTag();
                    //System.out.println(pos);
                    ll.removeViewAt(ll.getChildCount()-1);
                    prevbutcnt--;
                }
            }
        });
        nwdis.addView(et);
        nwdis.addView(b);

        ll.addView(nwdis);
        b.setTag((ll.getChildCount()-1));
        int i = (Integer) b.getTag();

        //oast.makeText(this, i , Toast.LENGTH_LONG).show();
    }

    void toast1(){
        Toast.makeText(this,"Sorry! CanNOt Add More Disease",Toast.LENGTH_LONG).show();
    }

    void toast2(){
        Toast.makeText(this,"Sorry! CanNOt Add More Drugs Taken",Toast.LENGTH_LONG).show();
    }

    void toast3(){
        Toast.makeText(this,"Sorry! CanNOt Add More Allergies",Toast.LENGTH_LONG).show();
    }

   /* public static Intent createIntent(Context context) {
        Intent i = new Intent(context, drugdrs.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        return i;
    }   */

    public void launchRingDialog() {
    final ProgressDialog ringProgressDialog = ProgressDialog.show(drugdrs.this, "Please wait ...", "Getting Results ...", true);
   ringProgressDialog.setCancelable(true);
    new Thread(new Runnable() {
   @Override
    public void run() {
     try {
                 // Here you should write your time consuming task...
                   // Let the progress ring for 10 seconds...
            senddata();
          //Thread.sleep(10000);
        } catch (Exception e) {

                                }
                             ringProgressDialog.dismiss();
                    }
               }).start();
        }



}
