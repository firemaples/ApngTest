package net.ellerton.japng.android.api;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;

import net.ellerton.japng.argb8888.Argb8888Bitmap;
import net.ellerton.japng.argb8888.Argb8888Processor;
import net.ellerton.japng.error.PngException;
import net.ellerton.japng.reader.DefaultPngChunkReader;
import net.ellerton.japng.reader.PngReadHelper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Convenience functions to load PNGs for Android.
 */
public class PngAndroid {
    public static Bitmap toBitmap(Argb8888Bitmap src) {
        int offset = 0;
        int stride = src.width;
        return Bitmap.createBitmap(src.getPixelArray(), offset, stride, src.width, src.height, Bitmap.Config.ARGB_8888);
    }

    public static void loadImage(ImageView imageView, String path) {
        new JApngAndroidLoadTask(imageView, path).execute();
    }

    public static Drawable readDrawable(Context context, InputStream is) throws PngException {
        Argb8888Processor<Drawable> processor = new Argb8888Processor<Drawable>(new PngViewBuilder(context));
        return PngReadHelper.read(is, new DefaultPngChunkReader<Drawable>(processor));
    }

    public static Drawable readDrawable(Context context, int id) throws PngException, IOException {
        //Bitmap image = BitmapFactory.decodeResource(context.getResources(), resourceId);

        final TypedValue value = new TypedValue();
        InputStream is = null;
        try {
            return readDrawable(context, context.getResources().openRawResource(id, value));
//            Argb8888Processor<Drawable> processor = new Argb8888Processor<Drawable>(new PngViewBuilder(context));
//            return PngReadHelper.read(is, new DefaultPngChunkReader<Drawable>(processor));

        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                // ignore
            }
        }
//        try (InputStream is = context.getResources().openRawResource(id, value)) {
//            Argb8888Processor<Drawable> processor = new Argb8888Processor<Drawable>(new PngViewBuilder(context));
//            return PngReadHelper.read(is, new DefaultPngChunkReader<Drawable>(processor));
//              return readDrawable(context, is);
//        }
    }

    private static class JApngAndroidLoadTask extends AsyncTask<Void, Void, Drawable> {
        private Context context;
        private ImageView imageView;
        private String path;

        public JApngAndroidLoadTask(ImageView imageView, String path) {
            this.context = imageView.getContext();
            this.imageView = imageView;
            this.path = path;
        }

        @Override
        protected Drawable doInBackground(Void... voids) {
            Log.i("Test", "Do load image:" + path);
            InputStream inputStream = null;
            try {
                inputStream = context.getAssets().open(path.replace("assets://", ""));
                Drawable drawable = PngAndroid.readDrawable(context, inputStream);
                return drawable;
            } catch (Throwable e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(Drawable drawable) {
            super.onPostExecute(drawable);

            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                if (drawable instanceof AnimationDrawable) {
                    AnimationDrawable animationDrawable = (AnimationDrawable) drawable;
                    animationDrawable.setOneShot(false);
                    animationDrawable.start();
                }
            }
        }
    }
}
