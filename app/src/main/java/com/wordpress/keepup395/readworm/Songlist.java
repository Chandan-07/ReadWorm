package com.wordpress.keepup395.readworm;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Songlist extends AppCompatActivity {
    Button play1,play2,play3,play4,play5,play6,play7,pause1,pause2,pause3,pause4,pause5,pause6,pause7;
    MediaPlayer music0,music1,music2,music3;
    int pause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songlist);
        play1= (Button)findViewById(R.id.play1);
        play2= (Button)findViewById(R.id.play2);
        play3= (Button)findViewById(R.id.play3);
        play4= (Button)findViewById(R.id.play4);
        play5= (Button)findViewById(R.id.play5);
        play6= (Button)findViewById(R.id.play6);
        play7= (Button)findViewById(R.id.play7);
        pause1= (Button)findViewById(R.id.pause1);
        pause2= (Button)findViewById(R.id.pause2);
        pause3= (Button)findViewById(R.id.pause3);
        pause4= (Button)findViewById(R.id.pause4);
        pause5= (Button)findViewById(R.id.pause5);
        pause6= (Button)findViewById(R.id.pause6);
        pause7= (Button)findViewById(R.id.pause7);
        /*music0= MediaPlayer.create(this,R.raw.obk);
        music1=MediaPlayer.create(this,R.raw.songmp3);
        music2=MediaPlayer.create(this,R.raw.thh);
        super.onDestroy();
        if(music0 == null && !music0.isPlaying())
            music0.start();
        super.onDestroy();*/





    }
    public void play(View view){

        if(!music0.isPlaying())
        {
            music0.seekTo(pause);
            music0.start();
            music0.isLooping();
        }
        else if(music1.isPlaying())
        {
            music1.stop();
            music0.start();
        }


    }
    public void pause(View view){
        music0.pause();
        pause=music0.getCurrentPosition();
    }
    public  void  play2(View view){
        if(music0.isPlaying())
        {
            music0.stop();
            music1.start();
        }
        else
            music1.start();
    }
    public void pause1(View view){

        music1.stop();
    }
}


