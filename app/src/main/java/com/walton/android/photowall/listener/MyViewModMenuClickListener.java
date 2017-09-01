package com.walton.android.photowall.listener;

import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.walton.android.photowall.R;
import com.walton.android.photowall.processer.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/8/10.
 */

public class MyViewModMenuClickListener implements Toolbar.OnMenuItemClickListener {
    PhotoWallAdapter photoWallAdapter;
    public MyViewModMenuClickListener(PhotoWallAdapter photoWallAdapter){
        this.photoWallAdapter = photoWallAdapter;
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.sortByHeaderName:
                photoWallAdapter.sortHeader();
                return true;
            case R.id.sortByUri:
                photoWallAdapter.sortArrayList();
                return true;
        }
        return false;
    }
}