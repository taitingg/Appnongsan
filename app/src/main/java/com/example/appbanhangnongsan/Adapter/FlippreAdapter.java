package com.example.appbanhangnongsan.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.appbanhangnongsan.Model.Flipper;
import com.example.appbanhangnongsan.R;

import java.util.List;

public class FlippreAdapter extends PagerAdapter {
    private Context context;
    private List<Flipper>mlistflipper;

    public FlippreAdapter(Context context, List<Flipper> mlistflipper) {
        this.context = context;
        this.mlistflipper = mlistflipper;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((View) object);

    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.flipper_quangcao,container,false);
        ImageView imgflipper_quangcao =view.findViewById(R.id.img_flipper);

        Flipper flipper = mlistflipper.get(position);
        if (flipper !=null){
            Glide.with(context).load(flipper.getRescouceid()).into(imgflipper_quangcao);
        }
        container.addView(view);

        return view;
    }

    @Override
    public int getCount() {
        if (mlistflipper != null){
            return mlistflipper.size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
