package com.example.mitrjain.homeautomation;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mit on 29/9/17.
 */

public class customAdapter extends  RecyclerView.Adapter<customAdapter.MyViewHolder> {
    static int Counter =0;

    public ArrayList<customAdapterImageButton> srcimg;

    /**
     * View holder class
     * */
    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageButton img;
        public MyViewHolder(View view) {
            super(view);
           img = (ImageButton) view.findViewById(R.id.ImgButton);
        }
    }




    public customAdapter(ArrayList<customAdapterImageButton> srcimg) {
        this.srcimg = srcimg;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Counter++;
        customAdapterImageButton imgbutton = srcimg.get(position);
        holder.img.setBackground(imgbutton.src);
        holder.img.setTag(Counter);
        if(Counter==3)
            Counter=0;



    }

    @Override
    public int getItemCount() {
        return srcimg.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_view_item ,parent, false);
        return new MyViewHolder(v);
    }
}