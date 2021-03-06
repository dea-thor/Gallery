package com.example.gallery;



import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>{
     Context mcontext;
    private List<Photo> mExampleList;
    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public CardView mcardview;



        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.imageViewGallery);
            mcardview = itemView.findViewById(R.id.cardView);

        }
    }
    public ExampleAdapter(List<Photo> exampleList , Context context)
    {
        mcontext = context;
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview,viewGroup,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;

    }

    @Override
    public void onBindViewHolder(ExampleViewHolder exampleViewHolder, int i) {
        Photo currentItem = mExampleList.get(i);

        Glide.with(mcontext).load(currentItem.getUrlS()).into(exampleViewHolder.mImageView);

        exampleViewHolder.mcardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(mcontext,Image.class);
                intent.putExtra("Url",currentItem.getUrlS());
                mcontext.startActivity(intent);
            }
        });

        exampleViewHolder.mcardview.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mcontext,"pressed",Toast.LENGTH_LONG).show();
                return true;
            }
        });






    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
