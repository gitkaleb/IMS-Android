package com.gcme.ims.Services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.gcme.ims.MainActivity;
import com.gcme.ims.models.devotional;
import com.gcme.ims.models.news;
import com.gcme.ims.models.prayers;
import com.gcme.ims.models.testimonies;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bengeos on 1/18/17.
 */

public class SyncService extends Service{
    private static String TAG = "SyncService";
    private FirebaseDatabase firebaseDatabase;
    public static DatabaseReference NewsRef,TestimoniesRef,PrayersRef,DevotionalRef;
    private Context myContext;
    private FirebaseAuth myAuth;

    public static List<news> newsArray;
    public static List<prayers> prayersArray;
    public static List<testimonies> testimoniesArray;
    public static List<devotional> devotionalArray;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myContext = this;
        Log.i(TAG,"Sync Service Created");
        StartSyncing();
    }

    public SyncService() {
        newsArray = new ArrayList<news>();
        prayersArray = new ArrayList<prayers>();
        testimoniesArray = new ArrayList<testimonies>();
        devotionalArray = new ArrayList<devotional>();
        firebaseDatabase = FirebaseDatabase.getInstance();
        NewsRef = firebaseDatabase.getReference("global-news");
        TestimoniesRef = firebaseDatabase.getReference("testimony");
        PrayersRef = firebaseDatabase.getReference("prayer");
        DevotionalRef = firebaseDatabase.getReference("Devotional ");

    }
    public static List<news> getNews() {
        return newsArray;
    }
    public static List<testimonies> getTestimonies() {
        return testimoniesArray;
    }
    public static List<devotional> getresources() { return devotionalArray;
    }
    public static List<prayers> getPrayers() {
        return prayersArray;
    }

    public void StartSyncing(){
        myAuth = FirebaseAuth.getInstance();
        FirebaseUser user = myAuth.getCurrentUser();
        if(user !=null){

            SyncNews();
            SyncPrayers();
            SyncResources();
            SyncTestimonies();
            Log.d(TAG, "Already Signed in User:" + user.getUid());
        }else {
            Log.d(TAG, "Trying to Sign in Again");
            myAuth.signInWithEmailAndPassword("eecmyims1@gmail.com","hacktaton").addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        SyncNews();
                        SyncPrayers();
                        SyncResources();
                        SyncTestimonies();
                        Log.d(TAG, "Successfully Signed in: "+task.getResult().getUser().getUid());
                    }else {
                        Log.d(TAG, "Sign in Failed : "+task.getException());
                    }
                }
            });
        }

    }

    private void SyncNews() {
        NewsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                news newsarray = dataSnapshot.getValue(news.class);
                newsArray.add(newsarray);
//                try{
//                    Log.d(TAG, "newsArray:-> " + dataSnapshot.getKey());
//                    news newsarray = dataSnapshot.getValue(news.class);
//
//                    for(int i = 0;i<newsArray.size();i++){
//
//                            newsArray.remove(i);
//
//                    }
//                    if(newsarray.getNewsdetail() != null && newsarray.getNewsimg() != null && newsarray.getNewstitle() != null && newsarray.getId() != 0){
//                        newsArray.add(newsarray);
//                        Log.d(TAG, "News: Added: " + dataSnapshot.getChildren());
//                        MainActivity.update_by_Sync();
//                    }else {
//                        Log.i(TAG,"Invalid Format: "+dataSnapshot.getKey());
//                    }
//                }catch (Exception e){
//
//                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                try{
                    Log.d(TAG, "News:-> " + dataSnapshot.getKey());
                    news newsarray = dataSnapshot.getValue(news.class);

//                    App.myDatabase.addNewAlbum(album);
                    for(int i = 0;i<newsArray.size();i++){


                            newsArray.get(i).setId(newsarray.getId());
                            newsArray.get(i).setNewsdetail(newsarray.getNewsdetail());
                            newsArray.get(i).setNewsimg(newsarray.getNewsimg());
                            newsArray.get(i).setNewstitle(newsarray.getNewstitle());

                    }
                    Log.d(TAG, "News: Added: " + dataSnapshot.getChildren());
                }catch (Exception e){

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                try{
                    Log.d(TAG, "News Removing " + dataSnapshot.getKey());
                    news newsarray = dataSnapshot.getValue(news.class);
                    for(int i = 0;i<newsArray.size();i++){

                            newsArray.remove(i);

                    }
//                    Album oldAlbum = App.myDatabase.getAlbumBySerID(album.getSerID());
                    Log.d(TAG, "News: Removed: " + newsarray.getId());
//                    if(oldAlbum != null){
//                        App.myDatabase.deleteByID(Database.Table_Albums,oldAlbum.getID());
//                    }

                }catch (Exception e){

                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void SyncPrayers() {
        PrayersRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                try{
//                    Log.d(TAG, "newsArray:-> " + dataSnapshot.getKey());
                    prayers prayersarray = dataSnapshot.getValue(prayers.class);
                    prayersArray.add(prayersarray);

//                    for(int i = 0;i<newsArray.size();i++){
//
//                            prayersArray.remove(i);
//
//                    }
//                    if(prayersarray.getPrayertitle() != null && prayersarray.getPrayerdetail() != null && prayersarray.getId() != 0){
//                        prayersArray.add(prayersarray);
                        Log.d(TAG, "Prayer: Added: " + dataSnapshot.getChildren());
                        MainActivity.update_by_Sync();
//                    }else {
//                        Log.i(TAG,"Invalid Format: "+dataSnapshot.getKey());
//                    }
//                }catch (Exception e){

//                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                try{
                    Log.d(TAG, "Album:-> " + dataSnapshot.getKey());
                    prayers prayersarray = dataSnapshot.getValue(prayers.class);

//                    App.myDatabase.addNewAlbum(album);
                    for(int i = 0;i<prayersArray.size();i++){

                            prayersArray.get(i).setPrayertitle(prayersarray.getPrayertitle());
                            prayersArray.get(i).setPrayerdetail(prayersarray.getPrayerdetail());


                    }
                    Log.d(TAG, "Prayers: Added: " + dataSnapshot.getChildren());
                }catch (Exception e){

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                try{
                    Log.d(TAG, "Album Removing " + dataSnapshot.getKey());
                    prayers prayersarray = dataSnapshot.getValue(prayers.class);
                    for(int i = 0;i<prayersArray.size();i++){

                            prayersArray.remove(i);

                    }
//                    Album oldAlbum = App.myDatabase.getAlbumBySerID(album.getSerID());
                    Log.d(TAG, "Prayers: Removed: " + prayersarray.getId());
//                    if(oldAlbum != null){
//                        App.myDatabase.deleteByID(Database.Table_Albums,oldAlbum.getID());
//                    }

                }catch (Exception e){

                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void SyncResources() {
        DevotionalRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                devotional devotionalarray = dataSnapshot.getValue(devotional.class);
                devotionalArray.add(devotionalarray);

//                try{
//                    Log.d(TAG, "resourcesArray:-> " + dataSnapshot.getKey());
//                    devotional resourcesarray = dataSnapshot.getValue(devotional.class);
//                    resourcesArray.add(resourcesarray);
//                    for(int i = 0;i<newsArray.size();i++){
//
//                            resourcesArray.remove(i);
//
//                    }
//                    if(resourcesarray.getId() != 0 && resourcesarray.getResourcedetail() != null && resourcesarray.getResourceimg() != null && resourcesarray.getResourcetitle() != null){
//                        resourcesArray.add(resourcesarray);
//                        Log.d(TAG, "Album: Added: " + dataSnapshot.getChildren());
//                        MainActivity.update_by_Sync();
//                    }else {
//                        Log.i(TAG,"Invalid Format: "+dataSnapshot.getKey());
//                    }
//                }catch (Exception e){
//
//                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                try{
                    Log.d(TAG, "Devotional:-> " + dataSnapshot.getKey());
                    devotional devotional = dataSnapshot.getValue(devotional.class);

                    for(int i = 0;i<devotionalArray.size();i++){


                        devotionalArray.get(i).setId(devotional.getId());
                        devotionalArray.get(i).setDevotionaltitle(devotional.getDevotionaltitle());
                        devotionalArray.get(i).setDevotionaldetail(devotional.getDevotionaldetail());
                        devotionalArray.get(i).setDevotionalimg(devotional.getDevotionalimg());
                        }

                    Log.d(TAG, "Devotional: Added: " + dataSnapshot.getChildren());
                }catch (Exception e){

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                try{
                    Log.d(TAG, "Devotional Removing " + dataSnapshot.getKey());
                    devotional devotionalarray = dataSnapshot.getValue(devotional.class);
                    for(int i = 0;i<devotionalArray.size();i++){

                        devotionalArray.remove(i);
                    }
//                    Album oldAlbum = App.myDatabase.getAlbumBySerID(album.getSerID());
                    Log.d(TAG, "Devotional: Removed: " + devotionalarray.getId());
//                    if(oldAlbum != null){
//                        App.myDatabase.deleteByID(Database.Table_Albums,oldAlbum.getID());
//                    }

                }catch (Exception e){

                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void SyncTestimonies() {
        TestimoniesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                try{
//                    Log.d(TAG, "testimoniesArray:-> " + dataSnapshot.getKey());
                    testimonies testimoniesarray = dataSnapshot.getValue(testimonies.class);
                    testimoniesArray.add(testimoniesarray);

//
//                    for(int i = 0;i<testimoniesArray.size();i++){
//
//                            testimoniesArray.remove(i);
//
//                    }
//                    if(testimoniesarray.getId() != 0 && testimoniesarray.getTestimonydetail() != null && testimoniesarray.getTestimonyimg() != null && testimoniesarray.getTestimonytitle() != null){
//                        testimoniesArray.add(testimoniesarray);
//                        Log.d(TAG, "testimonies: Added: " + dataSnapshot.getChildren());
//                        MainActivity.update_by_Sync();
//                    }else {
//                        Log.i(TAG,"Invalid Format: "+dataSnapshot.getKey());
//                    }
//                }catch (Exception e){
//
//                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                try{
                    Log.d(TAG, "testimonies:-> " + dataSnapshot.getKey());
                    testimonies testimoniesarray = dataSnapshot.getValue(testimonies.class);
                    for(int i = 0;i<testimoniesArray.size();i++){

                            testimoniesArray.get(i).setId(testimoniesarray.getId());
                            testimoniesArray.get(i).setTestimonydetail(testimoniesarray.getTestimonydetail());
                            testimoniesArray.get(i).setTestimonyimg(testimoniesarray.getTestimonyimg());
                            testimoniesArray.get(i).setTestimonytitle(testimoniesarray.getTestimonytitle());


                    }
                    Log.d(TAG, "testimonies: Added: " + dataSnapshot.getChildren());
                }catch (Exception e){

                }
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                try{
                    Log.d(TAG, "Album Removing " + dataSnapshot.getKey());
                    testimonies testimoniesarray = dataSnapshot.getValue(testimonies.class);

                    for(int i = 0;i<testimoniesArray.size();i++){

                            testimoniesArray.remove(i);

                    }
//                    Album oldAlbum = App.myDatabase.getAlbumBySerID(album.getSerID());
                    Log.d(TAG, "testimonies: Removed: " + testimoniesarray.getId());
//                    if(oldAlbum != null){
//                        App.myDatabase.deleteByID(Database.Table_Albums,oldAlbum.getID());
//                    }

                }catch (Exception e){

                }
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }



}
