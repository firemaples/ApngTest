package net.ellerton.japng.android.api;

import android.graphics.drawable.Drawable;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

/**
 * Created by louis1chen on 23/03/2017.
 */

public class ApngCache {
    private static HashMap<String, String> cacheMap = new HashMap<>();

    public static void putContent(String key, ApngCacheModel apngCacheModel) {
        String jsonString = getGson().toJson(apngCacheModel);
        cacheMap.put(key, jsonString);
    }

    public static ApngCacheModel getContent(String key) {
        if (!cacheMap.containsKey(key)) {
            return null;
        }
        String jsonString = cacheMap.get(key);
        ApngCacheModel apngCacheModel = getGson().fromJson(jsonString, ApngCacheModel.class);
        return apngCacheModel;
    }

    private static Gson getGson() {
        return new Gson();
    }

    static class ApngCacheModel {
        List<ApngFrame> frameList;
    }

    static class ApngFrame {
        Drawable drawable;
        int duration;
    }
}
