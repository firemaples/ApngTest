package io.github.firemaples.apngtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.List;

//https://github.com/sahasbhop/apng-view  //Very lag

//https://github.com/aellerton/japng_android //looks good, but load slowly
//https://github.com/kris520/ApngDrawable    //looks not good, but smooth and load quickly with cache
public abstract class MainActivity extends AppCompatActivity {

    private ImageView iv_image1, iv_image2, iv_image3, iv_image4, iv_image5, iv_image6, iv_image7, iv_image8;

    //            "https://www.buddydo.us/t3/MTU2Mzcw182d.png",
    //            "https://www.buddydo.us/t3/MTU2Mzcz9ce4.png",
    private List<String> apngUrlList = Arrays.asList(
//            "https://www.buddydo.us/t3/MTU2MzY3df5a.png",
//            "https://www.buddydo.us/t3/MTU2MzY5776f.png",
//            "https://www.buddydo.us/t3/MTU2Mzcx0a84.png",
//            "https://www.buddydo.us/t3/MTU2Mzcy502b.png",
//            "https://www.buddydo.us/t3/MTU2Mzc0e89a.png",
//            "https://www.buddydo.us/t3/MTU2Mzc17b11.png"


//            "https://www.buddydo.us/t3/MTU2Mzc2b4a3.png"
//            "https://www.buddydo.us/t3/MTU2MzY481bb.gif"
//            "http://img12.deviantart.net/65e4/i/2013/003/6/6/png_floating_terrain_by_moonglowlilly-d5qb58m.png"

            "assets://apng/line.png",
            "assets://apng/line1.png",
            "assets://apng/line2.png",
            "assets://apng/line3.png",
            "assets://apng/line4.png",
            "assets://apng/line5.png",
            "assets://apng/gingerboy01.png",
            "assets://apng/gingerboy02.png"


//            "assets://apng/apng_file.png",
//            "assets://apng/firefox.png",
//            "assets://apng/elephant.png",
//            "assets://apng/fly_police.png",
//            "assets://apng/horse.png"
    );

//    private List<ImageView> imageViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        findViewById(R.id.bt_switch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(getActivityClass());
            }
        });

        findViewById(R.id.bt_switch).setVisibility(View.GONE);

        iv_image1 = (ImageView) findViewById(R.id.iv_image1);
        iv_image2 = (ImageView) findViewById(R.id.iv_image2);
        iv_image3 = (ImageView) findViewById(R.id.iv_image3);
        iv_image4 = (ImageView) findViewById(R.id.iv_image4);
        iv_image5 = (ImageView) findViewById(R.id.iv_image5);
        iv_image6 = (ImageView) findViewById(R.id.iv_image6);
        iv_image7 = (ImageView) findViewById(R.id.iv_image7);
        iv_image8 = (ImageView) findViewById(R.id.iv_image8);

//        imageViewList.add(iv_image1);
//        imageViewList.add(iv_image2);
//        imageViewList.add(iv_image3);
//        imageViewList.add(iv_image4);
//        imageViewList.add(iv_image5);

        if (apngUrlList.size() >= 7) {
            load(iv_image7, apngUrlList.get(6));
        }
        if (apngUrlList.size() >= 8) {
            load(iv_image8, apngUrlList.get(7));
        }
        if (apngUrlList.size() >= 1) {
            load(iv_image1, apngUrlList.get(0));
        }
        if (apngUrlList.size() >= 2) {
            load(iv_image2, apngUrlList.get(1));
        }
        if (apngUrlList.size() >= 3) {
            load(iv_image3, apngUrlList.get(2));
        }
        if (apngUrlList.size() >= 4) {
            load(iv_image4, apngUrlList.get(3));
        }
        if (apngUrlList.size() >= 5) {
            load(iv_image5, apngUrlList.get(4));
        }
        if (apngUrlList.size() >= 6) {
            load(iv_image6, apngUrlList.get(5));
        }
    }

    protected void init() {
    }

    protected abstract Class<?> getActivityClass();

    protected void startActivity(Class<?> className) {
        Intent intent = new Intent(this, className);
        startActivity(intent);
        finish();
    }

    protected void load(ImageView image, String path) {
        Log.i("Test", "load image: " + path);
    }
}
