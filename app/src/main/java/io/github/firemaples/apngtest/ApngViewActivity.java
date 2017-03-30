package io.github.firemaples.apngtest;

import android.widget.ImageView;

import com.github.sahasbhop.apngview.ApngImageLoader;

/**
 * Created by louis1chen on 28/03/2017.
 */

public class ApngViewActivity extends MainActivity {
    @Override
    protected Class<?> getActivityClass() {
        return ApngViewActivity.class;
    }

    @Override
    protected void init() {
        super.init();
        ApngImageLoader.getInstance().init(getApplicationContext());
    }

    @Override
    protected void load(final ImageView image, String path) {
        super.load(image, path);
        ApngImageLoader.getInstance().displayApng(path, image, new ApngImageLoader.ApngConfig(999, true, false, true));
    }
}
