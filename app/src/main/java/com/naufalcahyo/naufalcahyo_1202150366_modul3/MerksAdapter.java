package com.naufalcahyo.naufalcahyo_1202150366_modul3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by Naufal Cahyo on 2/24/2018.
 */

class MerksAdapter extends RecyclerView.Adapter<MerksAdapter.MerksViewHolder> {

    //Member variables
    private GradientDrawable mGradientDrawable;
    private ArrayList<Merk> mMerksData;
    private Context mContext;

    MerksAdapter(Context context, ArrayList<Merk> merkData) {
        this.mMerksData = merkData;
        this.mContext = context;

        //Prepare gray placeholder
        mGradientDrawable = new GradientDrawable();
        mGradientDrawable.setColor(Color.GRAY);

        //Make the placeholder same size as the images
        Drawable drawable = ContextCompat.getDrawable
                (mContext, R.drawable.amidis);
        if (drawable != null) {
            mGradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }


    @Override
    public MerksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MerksViewHolder(mContext, LayoutInflater.from(mContext).
                inflate(R.layout.activity_list_air, parent, false), mGradientDrawable);
    }

    @Override
    public void onBindViewHolder(MerksViewHolder holder, int position) {
        //Get the current sport
        Merk currentMerk = mMerksData.get(position);

        //Bind the data to the views
        holder.bindTo(currentMerk);
    }

    @Override
    public int getItemCount() {
        return mMerksData.size();
    }

    static class MerksViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        //Member Variables for the holder data
        private TextView mTitleText;
        private TextView mInfoText;
        private ImageView mSportsImage;
        private Context mContext;
        private Merk mCurrentMerk;
        private GradientDrawable mGradientDrawable;

        /**
         * Constructor for the SportsViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file
         */
        MerksViewHolder(Context context, View itemView, GradientDrawable gradientDrawable) {
            super(itemView);

            //Initialize the views
            mTitleText = (TextView) itemView.findViewById(R.id.title);
            mInfoText = (TextView) itemView.findViewById(R.id.subTitle);
            mSportsImage = (ImageView) itemView.findViewById(R.id.merksImage);

            mContext = context;
            mGradientDrawable = gradientDrawable;

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }

        void bindTo(Merk currentSport){
            //Populate the textviews with data
            mTitleText.setText(currentSport.getTitle());
            mInfoText.setText(currentSport.getInfo());

            //Get the current sport
            mCurrentMerk = currentSport;



            //Load the images into the ImageView using the Glide library
            Glide.with(mContext).load(currentSport.
                    getImageResource()).placeholder(mGradientDrawable).into(mSportsImage);
        }


        @Override
        public void onClick(View view) {

            //Set up the detail intent
            Intent detailIntent = Merk.starter(mContext, mCurrentMerk.getTitle(),
                    mCurrentMerk.getImageResource());


            //Start the detail activity
            mContext.startActivity(detailIntent);
        }
    }
}

