package com.walton.android.photowall.model;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;


import com.google.gdata.client.photos.PicasawebService;
import com.walton.android.photowall.processer.Observable;
import com.walton.android.photowall.processer.Observer;
import com.walton.android.photowall.processer.PhotoWallAdapter;

import java.net.URL;
import java.util.ArrayList;

import static android.content.Context.ACCOUNT_SERVICE;

/**
 * Created by waltonmis on 2017/8/29.
 */

public class GooglePhotosData implements Observable{
    private final int PICK_ACCOUNT_REQUEST = 1;
    private final int REQUEST_AUTHENTICATE = 2;
    private static final String API_PREFIX
            = "https://picasaweb.google.com/data/feed/api/user/";
    private PicasawebService picasawebService;
    private AccountManager accountManager;
    private Account[] list;
    private String selectedAccountName;
    private Account selectedAccount;
    private ImageView picture;
    private Activity activity;
    private String authToken;
    private ArrayList<URL> photoUrls;
    private boolean isUrlGet = false;
    private ArrayList<Observer> observers;
    private PhotoWallAdapter photoWallAdapter;
    private RecyclerView recyclerView;
    private Toolbar selectModToolBar;
    private Toolbar viewModToolBar;
    public GooglePhotosData(Activity activity){
        this.activity = activity;
        accountManager = (AccountManager)activity.getSystemService(ACCOUNT_SERVICE);
        list = accountManager.getAccounts();
        photoUrls = new ArrayList<>();
        observers = new ArrayList<>();
    }
    public Toolbar getSelectModToolBar(){return selectModToolBar; }
    public Toolbar getViewModToolBar(){return viewModToolBar; }
    public RecyclerView getRecyclerView(){return recyclerView; }
    public PhotoWallAdapter getPhotoWallAdapter(){
        return photoWallAdapter;
    }
    public String getApiPrefix(){
        return API_PREFIX;
    }
    public ImageView getPicture(){
        return picture;
    }
    public Account getSelectedAccount(){
        return selectedAccount;
    }
    public String getSelectedAccountName(){
        return selectedAccountName;
    }
    public Account[] getList(){
        return list;
    }
    public AccountManager getAccountManager(){
        return accountManager;
    }
    public PicasawebService getPicasawebService(){
        return picasawebService;
    }
    public String getAuthToken(){
        return authToken;
    }
    public int getPICK_ACCOUNT_REQUEST(){
        return PICK_ACCOUNT_REQUEST;
    }
    public int getREQUEST_AUTHENTICATE(){
        return REQUEST_AUTHENTICATE;
    }
    public Activity getActivity(){
        return activity;
    }
    public ArrayList<URL> getPhotoUrls(){
        return photoUrls;
    }
    public void setPicture(ImageView picture){
        this.picture = picture;
    }
    public void setSelectedAccount(Account selectedAccount){
        this.selectedAccount = selectedAccount;
    }
    public void setSelectedAccountName(String selectedAccountName){
        this.selectedAccountName = selectedAccountName;
    }
    public void setList(Account[] list){
        this.list = list;
    }
    public void setAccountManager(AccountManager accountManager){
        this.accountManager = accountManager;
    }
    public void setPicasawebService(PicasawebService picasawebService){
        this.picasawebService = picasawebService;
    }
    public void setAuthToken(String authToken){
        this.authToken = authToken;
    }
    public void setPhotoUrls(ArrayList<URL> photoUrls){
        this.photoUrls = photoUrls;
        isUrlGet = true;
        notifyObserver();
    }
    public void setPhotoWallAdapter(PhotoWallAdapter photoWallAdapter){
        this.photoWallAdapter = photoWallAdapter;
    }
    public void setRecyclerView(RecyclerView recyclerView){
        this.recyclerView = recyclerView;
    }
    public void setSelectModToolBar(Toolbar selectModToolBar){
        this.selectModToolBar = selectModToolBar;
    }
    public void setViewModToolBar(Toolbar viewModToolBar){
        this.viewModToolBar = viewModToolBar;
    }
    public boolean isGet(){
        return isUrlGet;
    }
    @Override
    public void register(Observer observer) {
        System.out.println("add observer : " + observer);
        observers.add(observer);
    }

    @Override
    public void unRegister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for(Observer observer : observers){
            System.out.println("notify : " + observer);
            observer.updateUrl(photoUrls);
        }
    }
}