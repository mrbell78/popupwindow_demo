package com.example.viewpagerwithfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private int Count_infat=0;
    private int Count_kids=0;
    private int Count_gardian=0;
    private int Count_socks=0;

    private ImageButton btn_minus_infant;
    private ImageButton  btn_minus_kids;
    private ImageButton  btn_minus_gardian;
    private ImageButton  btn_minus_socks;

    private ImageButton btn_add_infant;
    private ImageButton btn_add_kids;
    private ImageButton btn_add_gardian;
    private ImageButton btn_add_socks;


    private TextView tv_minus_infat;
    private TextView tv_minus_kids;
    private TextView tv_minus_gardian;
    private TextView tv_minus_socks;


    private TextView[] indexes;
    private ViewPager mViewpager;
    private Viewpageradapter viewpageradapter;
    private LinearLayout dotlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //viewpager event

        mViewpager=findViewById(R.id.sampleviewpager);
        viewpageradapter=new Viewpageradapter(this);
        mViewpager.setAdapter(viewpageradapter);
        dotlayout=findViewById(R.id.dot);

        addDotindicator(0);
        mViewpager.addOnPageChangeListener(viewlistener);

        Timer timer =  new Timer();

        timer.scheduleAtFixedRate(new Mytimertask(),2500,3000);

        //button event
        btn_minus_infant=findViewById(R.id.btn_minus_infant);
        btn_minus_kids=findViewById(R.id.btn_minus_kids);
        btn_minus_gardian=findViewById(R.id.btn_minus_gardian);
        btn_minus_socks=findViewById(R.id.btn_minus_soks);


        btn_add_infant=findViewById(R.id.btn_add_infant);
        btn_add_kids=findViewById(R.id.btn_add_kids);
        btn_add_gardian=findViewById(R.id.btn_add_gardian);
        btn_add_socks=findViewById(R.id.btn_add_socks);



        btn_minus_infant.setOnClickListener(this);
        btn_minus_kids.setOnClickListener(this);
        btn_minus_gardian.setOnClickListener(this);
        btn_minus_socks.setOnClickListener(this);


        btn_add_infant.setOnClickListener(this);
        btn_add_kids.setOnClickListener(this);
        btn_add_gardian.setOnClickListener(this);
        btn_add_socks.setOnClickListener(this);

        //Textview event


        tv_minus_infat=findViewById(R.id.tv_count_infant);
        tv_minus_kids=findViewById(R.id.tv_count_kids);
        tv_minus_gardian=findViewById(R.id.tv_count_gardian);
        tv_minus_socks=findViewById(R.id.tv_count_socks);


/*
        btn_add_infant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv_minus_infat.setText(Integer.toString(Count_infat++));

            }
        });*/


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_minus_infant:
                 if(Count_infat>0){
                    Count_infat--;
                    tv_minus_infat.setText(Integer.toString(Count_infat));
                }else {
                     Count_gardian=0;
                     //tv_minus_infat.setText(Integer.toString(Count_infat));
                 }
                 break;
            case R.id.btn_minus_kids:
                if(Count_kids>0){
                    Count_kids--;
                    tv_minus_kids.setText(Integer.toString(Count_kids));
                }else {
                    Count_gardian=0;
                    //tv_minus_kids.setText(Integer.toString(Count_kids));
                }
                break;

            case R.id.btn_minus_gardian:
                if(Count_gardian>0){
                    Count_gardian--;
                    tv_minus_gardian.setText(Integer.toString(Count_gardian));
                }else {
                    Count_gardian=0;
                    //tv_minus_gardian.setText(Integer.toString(Count_gardian));
                }
                break;

            case R.id.btn_minus_soks:
                if(Count_socks>0){
                    Count_socks--;
                    tv_minus_socks.setText(Integer.toString(Count_socks));
                }else {
                    Count_gardian=0;
                    //tv_minus_socks.setText(Integer.toString(Count_socks));
                }

                break;

            case R.id.btn_add_infant:
                Count_infat++;
                tv_minus_infat.setText(Integer.toString(Count_infat));
                break;
            case R.id.btn_add_kids:
                tv_minus_kids.setText(Integer.toString(Count_kids));
                Count_kids++;
                break;

            case R.id.btn_add_gardian:
                Count_gardian++;
                tv_minus_gardian.setText(Integer.toString(Count_gardian));

                break;
            case R.id.btn_add_socks:
                Count_socks++;
                tv_minus_socks.setText(Integer.toString(Count_socks));
                break;
                default:
                    Toast.makeText(this, "everything works fine", Toast.LENGTH_SHORT).show();
        }
    }

    private void addDotindicator(int position) {

        indexes=new TextView[7];

        dotlayout.removeAllViews();
        for(int i=0; i<indexes.length;i++){
            indexes[i]=new TextView(this);
            indexes[i].setText(Html.fromHtml("&#8226"));
            indexes[i].setTextSize(35);
            indexes[i].setTextColor(getResources().getColor(R.color.transparentWhite));
            dotlayout.addView(indexes[i]);
        }
        if(indexes.length>0){
            indexes[position].setTextColor(Color.BLACK);
        }


    }

    ViewPager.OnPageChangeListener viewlistener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


        }

        @Override
        public void onPageSelected(int position) {

            addDotindicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public class Mytimertask extends TimerTask {

        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(mViewpager.getCurrentItem()==0){
                        mViewpager.setCurrentItem(1);
                    }else if(mViewpager.getCurrentItem()==1)
                        mViewpager.setCurrentItem(2);
                    else if(mViewpager.getCurrentItem()==2)
                        mViewpager.setCurrentItem(3);
                    else if(mViewpager.getCurrentItem()==3)
                        mViewpager.setCurrentItem(4);
                    else if(mViewpager.getCurrentItem()==4)
                        mViewpager.setCurrentItem(5);
                    else if(mViewpager.getCurrentItem()==5)
                        mViewpager.setCurrentItem(6);

                    else if(mViewpager.getCurrentItem()==6)
                    {
                        SystemClock.sleep(100);
                        mViewpager.setCurrentItem(0,true);
                    }



                    /*if(mViewpager.getCurrentItem()==6){
                        mViewpager.setCurrentItem(0,true);
                    }*/
                }
            });
        }
    }
}
