package io.github.firemaples.apngtest;

import android.os.Bundle;
import android.widget.ImageView;

import net.ellerton.japng.android.api.PngAndroid;

/**
 * Created by louis1chen on 21/03/2017.
 */

public class JApngAndroidActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("JApng-Android");
    }

    @Override
    protected Class<?> getActivityClass() {
        return JApngAndroidActivity.class;
    }

    @Override
    protected void load(ImageView image, String path) {
        super.load(image, path);
        PngAndroid.loadImage(image, path);
    }


}
