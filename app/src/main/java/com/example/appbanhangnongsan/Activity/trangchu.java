package com.example.appbanhangnongsan.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.example.appbanhangnongsan.Adapter.CategoryAdapter;
import com.example.appbanhangnongsan.Adapter.FlippreAdapter;
import com.example.appbanhangnongsan.Model.CategoryDomain;
import com.example.appbanhangnongsan.Model.Flipper;
import com.example.appbanhangnongsan.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class trangchu extends AppCompatActivity {

    ViewPager viewPager;
    CircleIndicator circleIndicator;
    FlippreAdapter flippreAdapter;

    private List<Flipper> mlistflipper;

    private Timer timer;

    private     RecyclerView.Adapter adapter,adapter2;
    private  RecyclerView recyclerViewCategoriesList,recyclerViewpopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        viewPager =(ViewPager) findViewById(R.id.ViewPager);
        circleIndicator =(CircleIndicator) findViewById(R.id.CircleIndicator);

        mlistflipper = getlistadapter();
        flippreAdapter= new FlippreAdapter(this,mlistflipper);

        recyclerViewCategories();


        viewPager.setAdapter(flippreAdapter);

        circleIndicator.setViewPager(viewPager);

        flippreAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

    }
    private List<Flipper> getlistadapter(){

        List<Flipper> list = new ArrayList<>();
        list.add(new Flipper(R.drawable.img_quangcao));
        list.add(new Flipper(R.drawable.img_quangcao1));
        list.add(new Flipper(R.drawable.img_quangcao2));
        list.add(new Flipper(R.drawable.img_quangcao3));
        list.add(new Flipper(R.drawable.img_quangcao4));
        return list;
    }
    private void autoImages(){
        if (mlistflipper == null|| mlistflipper.isEmpty() || viewPager==null){
            return;
        }

        if (timer == null){
            timer = new Timer();
        }

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentitem = viewPager.getCurrentItem();
                        int totalitem = mlistflipper.size() - 1;

                        if (currentitem<totalitem){
                            currentitem++;
                            viewPager.setCurrentItem(currentitem);
                        }
                        else {
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        },500,3000);
    }

    private void recyclerViewCategories() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewCategoriesList = findViewById(R.id.RecyclerView);
        recyclerViewCategoriesList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categorylist = new ArrayList<>();
        categorylist.add(new CategoryDomain("Pizza",R.drawable.category_trangchu));
        categorylist.add(new CategoryDomain("Pizza",R.drawable.category_trangchu));
        categorylist.add(new CategoryDomain("Pizza",R.drawable.category_trangchu));
        categorylist.add(new CategoryDomain("Pizza",R.drawable.category_trangchu));
        categorylist.add(new CategoryDomain("Pizza",R.drawable.category_trangchu));

        adapter =new CategoryAdapter(categorylist);
        recyclerViewCategoriesList.setAdapter(adapter);


    }
}