package com.walton.android.photowall;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.walton.android.photowall.listener.ZoomRecyclerViewOnTouchListener;
import com.walton.android.photowall.processer.CreateFileTreeMap;
import com.walton.android.photowall.processer.MyAdapter;
import com.walton.android.photowall.processer.SearchFile;

import java.io.File;
import java.util.TreeMap;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.imagegallery);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),4);
        ((GridLayoutManager)layoutManager).setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return position==0 ? 4:1;
            }
        });
        recyclerView.setLayoutManager(layoutManager);

        SearchFile searchFile = new SearchFile();
        File[] ImageList = searchFile.getImageList();
        CreateFileTreeMap createFileTreeMap = new CreateFileTreeMap(ImageList);
        TreeMap<String,File[]> FileTreeMap = createFileTreeMap.GetTreeMap();

        FragmentManager fragmentManager = getSupportFragmentManager();

        MyAdapter adapter = new MyAdapter(getApplicationContext(), FileTreeMap , ImageList.length , recyclerView);
        //MyAdapter adapter = new MyAdapter(getApplicationContext(), ImageList, fragmentManager, recyclerView);
        recyclerView.setAdapter(adapter);
        ZoomRecyclerViewOnTouchListener zoomRecyclerViewOnTouchListener = new ZoomRecyclerViewOnTouchListener(getApplicationContext(), recyclerView, adapter);
        zoomRecyclerViewOnTouchListener.setTitlePosition(adapter.getTitleposition());
        recyclerView.setOnTouchListener(zoomRecyclerViewOnTouchListener);
    }
}
