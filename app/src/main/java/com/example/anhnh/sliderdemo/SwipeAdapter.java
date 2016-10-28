package com.example.anhnh.sliderdemo;

/**
 * Created by anhnh on 10/27/2016.
 */

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SwipeAdapter extends PagerAdapter {
    private TypedArray image;
    private String[] enName;
    private String[] japName;
    private Context context;
    private LayoutInflater layoutInflater;

    public SwipeAdapter(Context context, String[] array) {
        this.enName = array;
        this.context = context;
    }

    @Override
    public int getCount() {
        return enName.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(LinearLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.swipe_layout, container,false);
        image = itemView.getResources().obtainTypedArray(R.array.country_flag);
//        enName = itemView.getResources().getStringArray(R.array.eng_name);
        japName = itemView.getResources().getStringArray(R.array.jap_name);
        //set layout
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
        TextView textView = (TextView) itemView.findViewById(R.id.text_view);
        //set data every slide
        System.out.println("Position: "+position);
        imageView.setImageResource(image.getResourceId(position,-1));
        textView.setText(enName[position]+"\n"+japName[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
