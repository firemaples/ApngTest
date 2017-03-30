package io.github.firemaples.apngtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.github.sahasbhop.apngview.ApngImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApngViewListActivity extends AppCompatActivity {

    private List<String> stickerList = new ArrayList<>(Arrays.asList(
            "assets://apng/line.png",
            "assets://apng/line1.png",
            "assets://apng/line2.png",
            "assets://apng/line3.png",
            "assets://apng/line4.png",
            "assets://apng/line5.png",
            "assets://apng/gingerboy01.png",
            "assets://apng/gingerboy02.png"
    ));

    private MyListAdapter adapter = new MyListAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apng_view_list);

        ListView lv_list = (ListView) findViewById(R.id.lv_list);
        lv_list.setAdapter(adapter);
    }

    private class MyListAdapter extends BaseAdapter {
        private ApngImageLoader apngImageLoader;
        private ApngImageLoader.ApngConfig apngConfig;

        public MyListAdapter() {
            apngImageLoader = ApngImageLoader.getInstance();
            apngConfig = new ApngImageLoader.ApngConfig(999, true, false, true);
        }

        @Override
        public int getCount() {
            return stickerList.size();
        }

        @Override
        public Object getItem(int i) {
            return stickerList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        private class ViewHolder {
            private ImageView iv_image;

            public ViewHolder(View rootView) {
                iv_image = (ImageView) rootView.findViewById(R.id.iv_image);
            }
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (view == null) {
                view = LayoutInflater.from(ApngViewListActivity.this).inflate(R.layout.item_list, viewGroup, false);
                holder = new ViewHolder(view);
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            String path = (String) getItem(i);
            apngImageLoader.displayApng(path, holder.iv_image, apngConfig);

            return view;
        }
    }
}
