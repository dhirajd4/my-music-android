package com.example.vivek.music;

import
rt com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView songList;
    String[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songList=(ListView)findViewById(R.id.songListView);
        runtimePermisssion();		//first permit it

    }

    public void runtimePermisssion(){
    android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.k
                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();
    }

    public ArrayList<File> findsong(File file){
        ArrayList<File>arrayList=new ArrayList<>();
        File[] files=file.listFiles();
        for(File singleFile:files){
            if(singleFile.isDirectory()&&!singleFile.isHidden()){
                arrayList.addAll(f
                arumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
impo
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                            display();
                    }

indsong(singleFile));
            }vironment.getExternalStorageDirectory());
        items=new String[mysong.size()];
        for(int i=0;i<mysong.size();i++){
            items[i]=mysong.get(i).getName().toString().replace(".mp3","").replace(".wav","");

        }
        ArrayAdapter<String> myAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,items);
        songList.setAdapter(myAdapter);
        songList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItem
            
            else{
                if(singleFile.getName().endsWith(".mp3")||singleFile.getName().endsWith(".wav")){
                    arrayList.add(singleFile);
                }
            }
        }
        return arrayList;
    }

    void display(){
        final ArrayList<File> mysong=findsong(EnClick(AdapterView<?> parent, View view, int position, long id) {
                String songname=songList.getItemAtPosition(position).toString();
                startActivity(new Intent(getApplicationContext(),player.class).putExtra("songs",mysong).putExtra("songname",songname).putExtra("pos",position));
            }
        });



    }
}
