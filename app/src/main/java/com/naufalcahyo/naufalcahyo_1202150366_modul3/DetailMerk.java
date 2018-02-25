package com.naufalcahyo.naufalcahyo_1202150366_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailMerk extends AppCompatActivity implements View.OnClickListener {

    private int count = 0;
    private int mLiter = 20; //Member variables for holding the score
    private TextView mLiterText;  //Member variable for score TextView
    static final String STATE_LITER = "Volume Botol "; //Tag to be used as the key in OnSavedInstanceState

    private ImageView bateraiLv;
    private ImageView btnMinus;
    private ImageView btnPlus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_merk);

        //Initialize the views
        TextView sportsTitle = (TextView)findViewById(R.id.titleDetail);
        ImageView sportsImage = (ImageView)findViewById(R.id.merksImageDetail);

        //Get the drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Merk.IMAGE_KEY, 0));

        //Create a placeholder gray scrim while the image loads
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Make it the same size as the image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set the text from the Intent extra
        sportsTitle.setText(getIntent().getStringExtra(Merk.TITLE_KEY));

        //Load the image using the glide library and the Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Merk.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(sportsImage);

        initView();

        //Restores the scores if there is savedInstanceState
        if (savedInstanceState != null) {
            mLiter = savedInstanceState.getInt(STATE_LITER);
            //Set the score text views
            mLiterText.setText(String.valueOf(mLiter));
        }
    }

    public void initView(){
        bateraiLv = (ImageView) findViewById(R.id.gbrBaterai);
        btnMinus = (ImageView) findViewById(R.id.kurangiAir);
        btnPlus = (ImageView) findViewById(R.id.tambahAir);
        mLiterText = (TextView) findViewById(R.id.liter);

        btnMinus.setOnClickListener(this);
        btnPlus.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tambahAir:

                if ( count < 6){
                    count++;
                    bateraiLv.setImageLevel(count);
                    mLiter++;
                    mLiterText.setText(String.valueOf(mLiter));
                }else if (count >= 6) {
                    bateraiLv.setImageLevel(count);
                    mLiterText.setText(String.valueOf(mLiter));
                    Toast.makeText(this, "Air sudah penuh",
                            Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.kurangiAir:

                if (count > 0){
                    count--;
                    bateraiLv.setImageLevel(count);
                    mLiter--;
                    mLiterText.setText(String.valueOf(mLiter));
                }else if (count <= 0){
                    bateraiLv.setImageLevel(count);
                    mLiterText.setText(String.valueOf(mLiter));
                    Toast.makeText(this, "Air tinggal dikit",
                            Toast.LENGTH_SHORT).show();
                }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //Save the scores
        outState.putInt(STATE_LITER, mLiter);
        super.onSaveInstanceState(outState);
    }
}
