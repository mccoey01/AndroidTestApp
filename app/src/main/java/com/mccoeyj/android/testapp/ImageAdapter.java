package com.mccoeyj.android.testapp;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by John on 8/19/2015.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    int mGalleryItemBackground;
    File[] images;
    File[] files;

    public ImageAdapter(Context c, int folderID) {
        mContext = c;

        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        files = storageDir.listFiles();
        images = files[folderID].listFiles();
    }

    public int getCount() {
        return images.length;
    }

    public Object getItem(int position) {
        return images[position].getAbsolutePath();
    }

    public long getItemId(int position) {
        return position;
    }

    public String getAlbumName(int folderID) {
        return files[folderID].getName();
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 100));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 10, 5, 10);
        } else {
            imageView = (ImageView) convertView;
        }
        imageView.setImageBitmap(BitmapFactory.decodeFile(images[position].getAbsolutePath()));
        return imageView;
    }
}