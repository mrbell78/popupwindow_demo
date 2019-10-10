package com.example.viewpagerwithfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Viewpageradapter extends PagerAdapter {




    Context context;
    LayoutInflater layoutInflater;

    public Viewpageradapter(Context context) {
        this.context = context;
    }

    public int[]allimage={
            R.drawable.babu1,
            R.drawable.babu2,
            R.drawable.babu3,
            R.drawable.babu4,
            R.drawable.babu5,
            R.drawable.babu6,
            R.drawable.babu7
    };


    @Override
    public int getCount() {
        return allimage.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view== object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {


        layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        View view = layoutInflater.inflate(R.layout.sliderlayout,container,false);
        ImageView imageView=view.findViewById(R.id.slid_image);



        imageView.setImageResource(allimage[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout) object);

    }
}
