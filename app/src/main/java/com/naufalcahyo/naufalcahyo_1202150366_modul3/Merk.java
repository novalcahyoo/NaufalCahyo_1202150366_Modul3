package com.naufalcahyo.naufalcahyo_1202150366_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by Naufal Cahyo on 2/24/2018.
 */

class Merk {
    private final String merkAir;
    private final String detailMerk;
    private final int imageResource;

    static final String TITLE_KEY = "Merk";
    static final String IMAGE_KEY = "Gambar";

    public Merk(String merkAir, String detailMerk, int imageResource) {
        this.merkAir = merkAir;
        this.detailMerk = detailMerk;
        this.imageResource = imageResource;
    }

    String getTitle() {

        return merkAir;
    }
    String getInfo() {

        return detailMerk;
    }

    public int getImageResource() {
        return imageResource;
    }

    static Intent starter(Context context, String merk, @DrawableRes int imageResId) {
        Intent detailIntent = new Intent(context, DetailMerk.class);
        detailIntent.putExtra(TITLE_KEY, merk);
        detailIntent.putExtra(IMAGE_KEY, imageResId);
        return detailIntent;
    }
}
