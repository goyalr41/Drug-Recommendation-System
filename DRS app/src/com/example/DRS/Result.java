package com.example.DRS;

import Library.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 24/11/13
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Result extends Activity {
    TextView[] drugname = new TextView[5];
    TextView drugname1;
    Button[] resultbutt = new Button[5];
    LinearLayout[] linearlay = new LinearLayout[5];
    List<String> mylist = new ArrayList<String>();
    static List<String> semanticresult;
    static List<String> miningresult;
    List<String> list2;
    String[] semanticresul = new String[3];

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        launchRingDialog();
        //showsemantic();


        Button semantic = (Button)findViewById(R.id.semantic);
        Button mining = (Button)findViewById(R.id.mining);
        final TextView buttonup1 = (TextView)findViewById(R.id.button1up);
        final TextView buttonup2 = (TextView)findViewById(R.id.button2up);

        final ActionBar actionBar = (ActionBar) findViewById(R.id.actionbar);
        actionBar.setTitle("DRS");
        //actionBar.addAction(new CancelAction());
        //actionBar.addAction(new NewAction());
        actionBar.setHomeAction(new HomeAction1());


        drugname[0] = (TextView)findViewById(R.id.drugname1);
        drugname[1] = (TextView)findViewById(R.id.drugname2);
        drugname[2] = (TextView)findViewById(R.id.drugname3);
        drugname[3]= (TextView)findViewById(R.id.drugname4);
        drugname[4] = (TextView)findViewById(R.id.drugname5);
        drugname1 = (TextView) findViewById(R.id.drugname1);

        resultbutt[0] = (Button)findViewById(R.id.resultbutt1);
        resultbutt[1] = (Button)findViewById(R.id.resultbutt2);
        resultbutt[2] = (Button)findViewById(R.id.resultbutt3);
        resultbutt[3] = (Button)findViewById(R.id.resultbutt4);
        resultbutt[4] = (Button)findViewById(R.id.resultbutt5);

        linearlay[0] = (LinearLayout)findViewById(R.id.linearlay1);
        linearlay[0].setVisibility(View.GONE);
        linearlay[1] = (LinearLayout)findViewById(R.id.linearlay2);
        linearlay[1].setVisibility(View.GONE);
        linearlay[2] = (LinearLayout)findViewById(R.id.linearlay3);
        linearlay[2].setVisibility(View.GONE);
        linearlay[3] = (LinearLayout)findViewById(R.id.linearlay4);
        linearlay[3].setVisibility(View.GONE);
        linearlay[4] = (LinearLayout)findViewById(R.id.linearlay5);
        linearlay[4].setVisibility(View.GONE);

        /*semanticresult = new ArrayList <String>();
        //semanticresult.add("No Result Found");

        miningresult = new ArrayList<String>();
        miningresult.add("No Result Found");  */

        /*mylist.add("Raman");
        mylist.add("Shyam");
        mylist.add("ghhh");
        mylist.add("totp");
       Result.semanticresult = mylist;  */
        //showsemantic();

        semanticresul[0] = "Raman";
        semanticresul[1] = "gdgvdg";
        semanticresul[2] = "fdgdgdh";



        semantic.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View view) {
                   buttonup1.setBackgroundColor(Color.rgb(15,85,136));
                   buttonup2.setBackgroundColor(Color.rgb(136,16,16));
                   showsemantic();
           }
        });


        mining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonup2.setBackgroundColor(Color.rgb(15, 85, 136));
                buttonup1.setBackgroundColor(Color.rgb(136, 16, 16));
                showmining();
            }
        });
    }

    private void setminingdata() {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void setsemanticdata() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void launchRingDialog() {
        //toast2();
        //drugname[1].setTextColor(Color.WHITE);
       // drugname[1].setTextSize(20);
        //drugname1.setText("Raman");
        final ProgressDialog ringProgressDialog = ProgressDialog.show(Result.this, "Please wait ...", "Getting Results ...", true);
        ringProgressDialog.setCancelable(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Here you should write your time consuming task...
                    // Let the progress ring for 10 seconds...


                    ClientSemQuery1 c = new ClientSemQuery1();
                    c.connectnow(drugdrs.sendlist);
                    //semanticresult = semanticresul;
                    Iterator it = semanticresult.iterator();
                    list2 = semanticresult;
                    int i = 0;
                    while(it.hasNext()) {
                        System.out.println("Majaa aa gya"  + it.next().toString());

                    }
                    System.out.println("kkkkkkkk");

                    System.out.println("kjgnekjgnrjkn");
                    //toast2();

                    //Thread.sleep(10000);
                } catch (Exception e) {

                }
                ringProgressDialog.dismiss();
            }
        }).start();
    }

    private void showsemantic() {
       // toast1();
       linearlay[0].setVisibility(View.GONE);
        linearlay[1].setVisibility(View.GONE);
        linearlay[2].setVisibility(View.GONE);
        linearlay[3].setVisibility(View.GONE);
        linearlay[4].setVisibility(View.GONE);

       // if(!ClientSemQuery.semanticresult.isEmpty()) {
            Iterator it = list2.iterator();
            int i = 0;
            while(it.hasNext()){
                   linearlay[i].setVisibility(View.VISIBLE);

                  drugname[i].setTextColor(Color.WHITE);
                   drugname[i].setTextSize(20);
                final String ghj = it.next().toString();
                System.out.println("Aa rhi h fffff" + ghj);
                drugname[i].setText(ghj);
                if(ghj.compareTo("No Result Found") != 0) {
                   resultbutt[i].setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent ourIntent = new Intent(Result.this, DrugInfo.class);
                           ourIntent.putExtra("DrugName",ghj);
                           startActivity(ourIntent);
                       }
                   });
                }
                   i++;

            }
     //   }
        toast2();
    }
    private void showmining() {

        linearlay[0].setVisibility(View.GONE);
        linearlay[1].setVisibility(View.GONE);
        linearlay[2].setVisibility(View.GONE);
        linearlay[3].setVisibility(View.GONE);
        linearlay[4].setVisibility(View.GONE);

        if(!Result.miningresult.isEmpty()) {
            final Iterator it = miningresult.iterator();
            int i = 0;
            while(it.hasNext()){
                linearlay[i].setVisibility(View.VISIBLE);
                final String ghj =  it.next().toString();
                drugname[i].setText(ghj);
                if(ghj.compareTo("No Result Found") != 0) {
                resultbutt[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent ourIntent = new Intent(Result.this, DrugInfo.class);
                        ourIntent.putExtra("DrugName",ghj) ;
                        startActivity(ourIntent);
                    }
                });
                }
                i++;

            }
        }

        //To change body of created methods use File | Settings | File Templates.
    }
    private class HomeAction1 extends ActionBar.AbstractAction {

        public HomeAction1() {
            super(R.drawable.ic_action_previous_item);
        }

        @Override
        public void performAction(View view) {
            Result.semanticresult.clear();
            Result.miningresult.clear();

            finish();
        }

    }

    void toast1() {
       // Toast.makeText(this, ClientSemQuery.semanticresult.size(), Toast.LENGTH_LONG).show();

    }
    void toast2(){
       // final Iterator it = Result.semanticresult.iterator();
        int i = 0;
       /* while(it.hasNext()){
               Toast.makeText(this, it.next().toString(), Toast.LENGTH_LONG).show();
        }  */
    }

}

