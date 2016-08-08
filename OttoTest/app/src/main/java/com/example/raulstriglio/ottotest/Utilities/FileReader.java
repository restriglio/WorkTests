package com.example.raulstriglio.ottotest.Utilities;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by raul.striglio on 29/07/16.
 */
public class FileReader {

    static final String JSON_FILE_NAME = "info.json";
    static final String IMG_FILE_NAME = "info.json";
    static final String ENCODING = "UTF-8";

    public static String loadJSONFromAsset(Context context) {

        String json = null;

        try {

            InputStream is = context.getAssets().open(JSON_FILE_NAME);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, ENCODING);


        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }
}
