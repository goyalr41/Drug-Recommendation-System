package com.example.DRS;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: hp
 * Date: 24/11/13
 * Time: 5:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class DrugInfo extends Activity {


    int Description = 0;
    int Food = 0;
    int Toxicity = 0;
    int Indication = 0;
    int SideEffect = 0;
    int DrugInt = 0;
    int DiseaseCure = 0;
    Button showDis, showFood, showindi, showside, showtoxi, showdrugint, showdiscur;
    static List<String> drugresult;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.druginfo);
        final SearchView search = (SearchView)findViewById(R.id.search);
        //search.setSubmitButtonEnabled(true)  ;
        ImageView back = (ImageView)findViewById(R.id.back1);
        back.setImageResource(R.drawable.ic_action_previous_item);
        showDis = (Button) (findViewById(R.id.showdesplus));
        showFood = (Button) (findViewById(R.id.showfoodplus));
       showtoxi = (Button) (findViewById(R.id.showtoxiplus));
        showindi = (Button) (findViewById(R.id.showindiplus));
        showside = (Button) (findViewById(R.id.showsideplus));
       showdrugint = (Button) (findViewById(R.id.showdrugintplus));
       showdiscur = (Button) (findViewById(R.id.showdiscurplus));

        List temporary = new ArrayList<String>();
        for(int i = 0; i < 7; i++) {
              temporary.add("Please Search First");
        }
        drugresult = temporary;
        back.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View view) {
               finish();
            }
        });

        String query = getIntent().getStringExtra("DrugName");
        if(query.compareTo("Patient") != 0) {
             search.setQuery(query,true);
             launchRingDialog(query);
        }

        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query != null) {
                    cleardata();
                    //search.setQuery(query,true);
                    //search.setQueryHint("dgjdhgkj");
                    launchRingDialog(query);
                    return true;
                }
                return false;
            }

            public boolean onQueryTextChange(String newText) {
                // ...
                return true;
            }
        });


        showDis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Description == 0) {
                showDis.setBackgroundResource(R.drawable.minus_sign);
               addTextView(R.id.Description,drugresult.get(0));
                    Description = 1;
            }  else {
                    showDis.setBackgroundResource(R.drawable.plus_sign);
                    final LinearLayout ll = (LinearLayout) findViewById(R.id.Description);
                    ll.removeViewAt(ll.getChildCount()-1);
                    Description = 0;
                }
            }
        });


        showFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Food == 0) {
                    showFood.setBackgroundResource(R.drawable.minus_sign);
                    addTextView(R.id.FoodInt,drugresult.get(1));
                    Food = 1;
                }  else {
                    showFood.setBackgroundResource(R.drawable.plus_sign);
                    final LinearLayout ll = (LinearLayout) findViewById(R.id.FoodInt);
                    ll.removeViewAt(ll.getChildCount()-1);
                    Food = 0;
                }
            }
        });


        showtoxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Toxicity == 0) {
                    showtoxi.setBackgroundResource(R.drawable.minus_sign);
                    addTextView(R.id.Toxicity,drugresult.get(2));
                    Toxicity = 1;
                }  else {
                    showtoxi.setBackgroundResource(R.drawable.plus_sign);
                    final LinearLayout ll = (LinearLayout) findViewById(R.id.Toxicity);
                    ll.removeViewAt(ll.getChildCount()-1);
                    Toxicity = 0;
                }
            }
        });


        showindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Indication == 0) {
                    showindi.setBackgroundResource(R.drawable.minus_sign);
                    addTextView(R.id.Indication,drugresult.get(3));
                    Indication = 1;
                }  else {
                    showindi.setBackgroundResource(R.drawable.plus_sign);
                    final LinearLayout ll = (LinearLayout) findViewById(R.id.Indication);
                    ll.removeViewAt(ll.getChildCount()-1);
                    Indication = 0;
                }
            }
        });


        showside.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(SideEffect == 0) {
                    showside.setBackgroundResource(R.drawable.minus_sign);
                    addTextView(R.id.SideEffect,drugresult.get(4));
                    SideEffect = 1;
                }  else {
                    showside.setBackgroundResource(R.drawable.plus_sign);
                    final LinearLayout ll = (LinearLayout) findViewById(R.id.SideEffect);
                    ll.removeViewAt(ll.getChildCount()-1);
                    SideEffect = 0;
                }
            }
        });


        showdrugint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DrugInt == 0) {
                    showdrugint.setBackgroundResource(R.drawable.minus_sign);
                    addTextView(R.id.DrugInt,drugresult.get(5));
                    DrugInt = 1;
                }  else {
                    showdrugint.setBackgroundResource(R.drawable.plus_sign);
                    final LinearLayout ll = (LinearLayout) findViewById(R.id.DrugInt);
                    ll.removeViewAt(ll.getChildCount()-1);
                    DrugInt = 0;
                }
            }
        });


        showdiscur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(DiseaseCure == 0) {
                    showdiscur.setBackgroundResource(R.drawable.minus_sign);
                    addTextView(R.id.Pharmacology,drugresult.get(6));
                    DiseaseCure = 1;
                }  else {
                    showdiscur.setBackgroundResource(R.drawable.plus_sign);
                    final LinearLayout ll = (LinearLayout) findViewById(R.id.Pharmacology);
                    ll.removeViewAt(ll.getChildCount()-1);
                    DiseaseCure = 0;
                }
            }
        });


    }

    public void cleardata() {
        LinearLayout ll;
        if(Description == 1) {
        showDis.setBackgroundResource(R.drawable.plus_sign);
        ll = (LinearLayout) findViewById(R.id.Description);
        ll.removeViewAt(ll.getChildCount()-1);
        Description = 0;
        }

        if(Food == 1) {
        showFood.setBackgroundResource(R.drawable.plus_sign);
        ll = (LinearLayout) findViewById(R.id.FoodInt);
        ll.removeViewAt(ll.getChildCount()-1);
        Food = 0;
        }

        if(Toxicity == 1) {
        showtoxi.setBackgroundResource(R.drawable.plus_sign);
        ll = (LinearLayout) findViewById(R.id.Toxicity);
        ll.removeViewAt(ll.getChildCount()-1);
        Toxicity = 0;
        }

        if(Indication == 1) {
        showindi.setBackgroundResource(R.drawable.plus_sign);
        ll = (LinearLayout) findViewById(R.id.Indication);
        ll.removeViewAt(ll.getChildCount()-1);
        Indication = 0;
        }

        if(SideEffect == 1) {
        showside.setBackgroundResource(R.drawable.plus_sign);
        ll = (LinearLayout) findViewById(R.id.SideEffect);
        ll.removeViewAt(ll.getChildCount()-1);
        SideEffect = 0;
        }

        if(DrugInt == 1) {
        showdrugint.setBackgroundResource(R.drawable.plus_sign);
        ll = (LinearLayout) findViewById(R.id.DrugInt);
        ll.removeViewAt(ll.getChildCount()-1);
        DrugInt = 0;
        }

        if(DiseaseCure == 1 )  {
        showdiscur.setBackgroundResource(R.drawable.plus_sign);
        ll = (LinearLayout) findViewById(R.id.Pharmacology);
        ll.removeViewAt(ll.getChildCount()-1);
        DiseaseCure = 0;
        }



    }

    private void addTextView(int id, String text) {
        // TODO Auto-generated method stub

        final LinearLayout ll = (LinearLayout) findViewById(id);
        LinearLayout nwdis = new LinearLayout(this);
        TextView et = new TextView(this);
        et.setText(Html.fromHtml(text));
        //int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 290, getResources().getDisplayMetrics());
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        int mar = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5 , getResources().getDisplayMetrics());
        //int mar1 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 0 , getResources().getDisplayMetrics());
        p.setMargins(mar,mar,mar,mar);
        et.setLayoutParams(p);
       // et.setTextSize(10);
        et.setTextColor(Color.BLACK);
        //et.setTag(11 + disbutcnt);

        nwdis.addView(et);


        ll.addView(nwdis);
       // b.setTag((ll.getChildCount()-1));
       // int i = (Integer) b.getTag();

        //oast.makeText(this, i , Toast.LENGTH_LONG).show();
    }

    public void launchRingDialog(final String query) {
        final ProgressDialog ringProgressDialog = ProgressDialog.show(DrugInfo.this, "Please wait ...", "Getting Information ...", true);
        ringProgressDialog.setCancelable(true);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    List l = new ArrayList<String>();
                    l.add(query);
                    ClientDrugSearch cds = new ClientDrugSearch();
                    cds.connectnow(l);

                } catch (Exception e) {

                }
                ringProgressDialog.dismiss();
            }
        }).start();
    }



}
