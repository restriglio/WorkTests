package com.example.raulstriglio.ottotest.Utilities;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by raul.striglio on 29/07/16.
 */
public class FileReader {

    public static String loadJSONFromAsset(Context context) {
        String json = null;
        try {

            InputStream is =  context.getAssets().open("info.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

    public static Drawable loadImageFromAssets(Context context){
        try {
            // get input stream
            InputStream ims = context.getAssets().open("avatar.jpg");
            // load image as Drawable
            Drawable d = Drawable.createFromStream(ims, null);

            return d;
        }
        catch(IOException ex) {
            return null;
        }
    }

}
