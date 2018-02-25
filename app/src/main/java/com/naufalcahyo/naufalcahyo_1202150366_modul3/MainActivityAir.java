package com.naufalcahyo.naufalcahyo_1202150366_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;

public class MainActivityAir extends AppCompatActivity {

    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Merk> mMerksData;
    private MerksAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_air);

        //Initialize the RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Get the appropriate column count
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Set the Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Initialize the ArrayList that will contain the data
        mMerksData = new ArrayList<>();

        //Initialize the adapter and set it ot the RecyclerView
        mAdapter = new MerksAdapter(this, mMerksData);
        mRecyclerView.setAdapter(mAdapter);

        //Get the data
        initializeData();

        // If there is more than one column, disable swipe to dismiss
        int swipeDirs;
        if(gridColumnCount > 1){
            swipeDirs = 0;
        } else {
            swipeDirs = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT;
        }

    }

    private void initializeData() {
        //Get the resources from the XML file
        String[] merksList = getResources().getStringArray(R.array.nama_merek);
        String[] merksInfo = getResources().getStringArray(R.array.info_merek);
        TypedArray merksImageResources = getResources().obtainTypedArray(R.array.gambar_merek);
        //Clear the existing data (to avoid duplication)
        mMerksData.clear();


        //Create the ArrayList of Sports objects containing the titles,
        // images and information about each sport
        for(int i=0; i<merksList.length; i++){
            mMerksData.add(new Merk(merksList[i], merksInfo[i],
                    merksImageResources.getResourceId(i,0)));
        }

        //Recycle the typed array
        merksImageResources.recycle();

        //Notify the adapter of the change
        mAdapter.notifyDataSetChanged();
    }
}
