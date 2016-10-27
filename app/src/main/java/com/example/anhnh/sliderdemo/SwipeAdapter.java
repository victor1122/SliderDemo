package com.example.anhnh.sliderdemo;

/**
 * Created by anhnh on 10/27/2016.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SwipeAdapter extends PagerAdapter {
    private int[] imageSrc = {R.drawable.usa, R.drawable.vn, R.drawable.eng, R.drawable.jap, R.drawable.korea};
    private String[] enName = {"U.S.A", "Vietnam", "England", "Japan", "Korea"};
    private String[] japName = {"アメリカ", "ベトナム", "イギリス", "日本", "かんこく"};
    private Context context;
    private LayoutInflater layoutInflater;

    public SwipeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageSrc.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==(LinearLayout)object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = layoutInflater.inflate(R.layout.swipe_layout, container,false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.image_view);
        TextView textView = (TextView) itemView.findViewById(R.id.text_view);
        imageView.setImageResource(imageSrc[position]);
        textView.setText(enName[position]+"\n"+japName[position]);
        container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}
