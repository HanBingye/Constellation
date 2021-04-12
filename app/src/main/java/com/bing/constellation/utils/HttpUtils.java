package com.bing.constellation.utils;

import java.net.URLEncoder;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtils {


    public static String getPairUrl(String man, String woman) {
        man = man.replace("座", "");
        woman = woman.replace("座", "");
        try {
            man = URLEncoder.encode(man, "UTF-8");
            woman = URLEncoder.encode(woman, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = "http://apis.juhe.cn/xzpd/query?men="+man+"&women="+woman+"&key=aab7f23b9a6149ef03e1b8136e38b640";//key=aab7f23b9a6149ef03e1b8136e38b640

        return url;

    }

    public static String getFortuneUrl(String name) {
        try {
            name = URLEncoder.encode(name, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url = "http://web.juhe.cn:8080/constellation/getAll?consName="+name+"&type=year&key=37654c72ae968cedc1f7f173181eb019";
        return url;
    }

    public static void sendOkHttp(String url, okhttp3.Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(callback);
    }

}
