package com.example.appbanhangnongsan.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.appbanhangnongsan.Model.CategoryDomain;
import com.example.appbanhangnongsan.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<CategoryDomain> categoryDomains;
    public CategoryAdapter(ArrayList<CategoryDomain>categoryDomains){
        this.categoryDomains = categoryDomains;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_cat,parent,false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.categoryname.setText(categoryDomains.get(position).getTitle());
    int picurl = 0;
    switch (position){
        case 0:
            picurl =R.drawable.category_trangchu;
            break;
        case 1:
            picurl =R.drawable.category_trangchu;
            break;
        case 2:
            picurl =R.drawable.category_trangchu;
            break;
        case 3:
            picurl =R.drawable.category_trangchu;
            break;
        case 4:
            picurl =R.drawable.category_trangchu;
            break;
    }
    int drawbleReourceId = holder.itemView.getContext().getResources().getIdentifier(String.valueOf(picurl),"Drawble",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawbleReourceId).into(holder.categoryimg);
    }

    @Override
    public int getItemCount() {
        return categoryDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView categoryname;
        ImageView categoryimg;
        ConstraintLayout mainlayout;
        public ViewHolder (@NonNull View itemview){
            super(itemview);
            categoryname = itemview.findViewById(R.id.categoryname);
            categoryimg = itemview.findViewById(R.id.categoryimg);
            mainlayout =itemview.findViewById(R.id.mainlayout);
        }
    }
}
