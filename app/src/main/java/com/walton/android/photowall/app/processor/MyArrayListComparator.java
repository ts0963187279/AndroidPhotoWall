package com.walton.android.photowall.app.processor;

import android.net.Uri;

import java.util.Comparator;

/**
 * Created by waltonmis on 2017/8/9.
 */

public class MyArrayListComparator implements Comparator<Uri> {
    @Override
    public int compare(Uri uri1, Uri uri2) {
        int result = uri2.compareTo(uri1);
        return result;
    }
}