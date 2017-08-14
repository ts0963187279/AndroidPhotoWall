package com.walton.android.photowall.listener;

import android.view.View;

import com.walton.android.photowall.view.ItemView;

/**
 * Created by waltonmis on 2017/8/4.
 */

public class DefaultItemDoubleClickListener implements View.OnClickListener{
    @Override
    public void onClick(View v) {
        ItemView view = (ItemView)v;
        view.setChecked(!view.isChecked());
        view.getSelectModData().adapterNotify();
    }
}