package com.walton.android.photowall.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;

import com.walton.android.photowall.processer.GalleryAdapter;
import com.walton.android.photowall.processer.PathFileConverter;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import start.android.library.R;

/**
 * Created by waltonmis on 2017/7/19.
 */

public class ShowImageActivity extends AppCompatActivity {
    private String GET_EXTRA_IMAGELIST_KEY = "ImageListPath";
    private String GET_EXTRA_POSITION_KEY = "position";
    private RecyclerView recyclerView;
    private int position;
    private ArrayList<String> ImageListPath;
    private ArrayList<File> ImageList;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.showimage_layout);
        Intent intent = this.getIntent();
        ImageListPath = intent.getStringArrayListExtra(GET_EXTRA_IMAGELIST_KEY);
        position = intent.getIntExtra(GET_EXTRA_POSITION_KEY,1);

        recyclerView = (RecyclerView)findViewById(R.id.Gallery);
        recyclerView.setHasFixedSize(true);
        final RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        layoutManager.setAutoMeasureEnabled(false);
        recyclerView.setLayoutManager(layoutManager);
        ImageList = new PathFileConverter().getFile(ImageListPath);
        GalleryAdapter galleryAdapter = new GalleryAdapter(this,ImageList,layoutManager);
        recyclerView.setAdapter(galleryAdapter);
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
        layoutManager.scrollToPosition(position);
    }
}