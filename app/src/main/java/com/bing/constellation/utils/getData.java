package com.bing.constellation.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.constellation.been.ContentInfoBeen;

public class getData {
    private static Map<String ,Bitmap> logo;
    private  static Map<String ,Bitmap> contentLogo;
    public static String getContent(Context context,String fileName){
        AssetManager am = context.getResources().getAssets();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            InputStream inputStream = am.open(fileName);
            int length=0;
            byte[] bytes=new byte[1024];
            while((length=inputStream.read(bytes))!=-1){
                baos.write(bytes,0,length);
            }
            String s = baos.toString();
            inputStream.close();
            return s;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Bitmap getBitmap(Context context,String fileName){
        Bitmap bitmap=null;
        AssetManager am = context.getResources().getAssets();
        try {
            InputStream inputStream = am.open(fileName);
            bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    public static void saveBitmapTo(Context context, ContentInfoBeen contentInfoBeen){
        logo=new HashMap<>();
        contentLogo=new HashMap<>();
        List<ContentInfoBeen.StarInfoBean> starInfoList = contentInfoBeen.getStarInfo();
        for(int i=0;i<starInfoList.size();i++){
            String logoname = starInfoList.get(i).getLogoname();
            String fileName1="logo/"+logoname+".png";
            Bitmap bitmap1 = getBitmap(context, fileName1);
            logo.put(logoname,bitmap1);
            String fileName2="contentLogo/"+logoname+".png";
            Bitmap bitmap2 = getBitmap(context, fileName2);
            contentLogo.put(logoname,bitmap2);
        }
    }

    public static Map<String, Bitmap> getLogo() {
        return logo;
    }

    public static Map<String, Bitmap> getContentLogo() {
        return contentLogo;
    }
}
