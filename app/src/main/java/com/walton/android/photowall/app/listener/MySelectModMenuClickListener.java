/*
 * Copyright (C) 2017 RS Wong <ts0963187279@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.walton.android.photowall.app.listener;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.walton.android.photowall.app.R;
import com.walton.android.photowall.processor.PhotoWallAdapter;

/**
 * Created by waltonmis on 2017/8/9.
 */

public class MySelectModMenuClickListener implements Toolbar.OnMenuItemClickListener {
    private PhotoWallAdapter photoWallAdapter;
    public MySelectModMenuClickListener(PhotoWallAdapter photoWallAdapter){
        this.photoWallAdapter = photoWallAdapter;
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_delete:
                photoWallAdapter.removeItem();
                return true;
           }
           return false;
    }
}
