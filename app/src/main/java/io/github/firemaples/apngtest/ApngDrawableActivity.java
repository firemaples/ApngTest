//package io.github.firemaples.apngtest;
//
//import android.graphics.drawable.Drawable;
//import android.os.Bundle;
//import android.widget.ImageView;
//
//import com.kris520.apngdrawable.ApngDrawable;
//import com.kris520.apngdrawable.ApngImageLoadingListener;
//import com.kris520.apngdrawable.ApngLoader;
//import com.kris520.apngdrawable.ApngPlayListener;
//
///**
// * Created by louis1chen on 21/03/2017.
// */
//
//public class ApngDrawableActivity extends MainActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setTitle("Apng-Drawable");
//    }
//
//    @Override
//    protected void init() {
//        super.init();
//        ApngLoader.init(this);
//    }
//
//    @Override
//    protected Class<?> getActivityClass() {
//        return JApngAndroidActivity.class;
//    }
//
//    @Override
//    protected void load(ImageView image, String path) {
//        super.load(image, path);
//        ApngLoader.loadImage(path, image, apngImageLoadingListener);
//    }
//
//    private ApngPlayListener apngPlayListener = new ApngPlayListener() {
//        @Override
//        public void onAnimationStart(ApngDrawable drawable) {
//
//        }
//
//        @Override
//        public void onAnimationEnd(ApngDrawable drawable) {
//
//        }
//
//        @Override
//        public void onAnimationRepeat(ApngDrawable drawable) {
//
//        }
//    };
//
//    private ApngImageLoadingListener apngImageLoadingListener = new ApngImageLoadingListener(apngPlayListener) {
//
//        @Override
//        public void onLoadingComplete(String imageUri, ImageView imageView, Drawable loadedImage) {
//            super.onLoadingComplete(imageUri, imageView, loadedImage);
//            ((ApngDrawable) loadedImage).setNumPlays(999);
//        }
//    };
//}
