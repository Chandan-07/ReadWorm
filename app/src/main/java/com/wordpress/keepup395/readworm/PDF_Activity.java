package com.wordpress.keepup395.readworm;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.ScrollBar;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

import java.io.File;
public class PDF_Activity extends AppCompatActivity {
    Button button,button2;

MediaPlayer music;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_);
            button=(Button)findViewById(R.id.button);
            button2=(Button)findViewById(R.id.button2);


        //PDFVIEW SHALL DISPLAY OUR PDFS
        PDFView pdfView= (PDFView) findViewById(R.id.pdfView);
        //SCROLLBAR TO ENABLE SCROLLING
        ScrollBar scrollBar = (ScrollBar) findViewById(R.id.scrollBar);
        pdfView.setScrollBar(scrollBar);
        //VERTICAL SCROLLING
        scrollBar.setHorizontal(false);
        //SACRIFICE MEMORY FOR QUALITY
        //pdfView.useBestQuality(true)
        //UNPACK OUR DATA FROM INTENT
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent musicbutton= new Intent(PDF_Activity.this,Songlist.class);
                    startActivity(musicbutton);

                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent nature=new Intent(PDF_Activity.this,Naturesound.class);
                    startActivity(nature);
                }
            });

        Intent i=this.getIntent();
        String path=i.getExtras().getString("PATH");
        //GET THE PDF FILE
        File file=new File(path);
        if(file.canRead())
        {
            //LOAD IT
            pdfView.fromFile(file).defaultPage(1).onLoad(new OnLoadCompleteListener() {
                @Override
                public void loadComplete(int nbPages) {
                    Toast.makeText(PDF_Activity.this, String.valueOf(nbPages), Toast.LENGTH_LONG).show();
                }
            }).load();
        }



    }

public  void play4(View view){
    startService(new Intent(this, MyService.class));
}
}