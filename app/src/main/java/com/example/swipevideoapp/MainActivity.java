package com.example.swipevideoapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        final ViewPager2 videoViewPager = findViewById(R.id.videosViewPager);
//First video
        List<VideoItem> videoItems = new ArrayList<>();
        VideoItem videoCelebration = new VideoItem();
        videoCelebration.videoURL = "https://res.cloudinary.com/se2guuzm/video/upload/v1791768835/v12044gd0000cilkkvjc77ufmq9rco8g.mp4";
        videoCelebration.videoTitle = "Multnomah Falls";
        videoCelebration.videoDescription = "The tallest waterfall in Oregon and most visited in the PNW";
        videoItems.add(videoCelebration);
//Second video
        VideoItem videoCelebration2 = new VideoItem();
        videoCelebration2.videoURL = "https://res.cloudinary.com/se2guuzm/video/upload/v1791768721/v09044690000buom2kb121048vd2nr90.mp4";
        videoCelebration2.videoTitle = "Beautiful Fall Colors";
        videoCelebration2.videoDescription = "Take an adventure outside at Gene Coulon Memorial Beach Park";
        videoItems.add(videoCelebration2);
//Third video
        VideoItem videoCelebration3 = new VideoItem();
        videoCelebration3.videoURL = "https://res.cloudinary.com/se2guuzm/video/upload/v1791768899/v12044gd0000crphkqfog65ia0k353c0.mp4";
        videoCelebration3.videoTitle = "Spooky Drinks";
        videoCelebration3.videoDescription = "Try a scary cocktail";
        videoItems.add(videoCelebration3);

 //Fourth video
        VideoItem videoCelebration4 = new VideoItem();
        videoCelebration4.videoURL = "https://res.cloudinary.com/se2guuzm/video/upload/v1792302946/v12044gd0000ce1da53c77ufcc08r4ig.mp4";
        videoCelebration4.videoTitle = "Sunsets on the Water";
        videoCelebration4.videoDescription = "Ending the day like this...";
        videoItems.add(videoCelebration4);

//Fifth video
        VideoItem videoCelebration5 = new VideoItem();
        videoCelebration5.videoURL = "https://res.cloudinary.com/se2guuzm/video/upload/v1792302945/v09044fa0000bv63p6ti87k6mv10o930.mp4";
        videoCelebration5.videoTitle = "Frosty and Frozen";
        videoCelebration5.videoDescription = "There is a chill in the air";
        videoItems.add(videoCelebration5);

//Sixth video
        VideoItem videoCelebration6 = new VideoItem();
        videoCelebration6.videoURL = "https://res.cloudinary.com/se2guuzm/video/upload/v1792302945/v12044gd0000cin3h5rc77u39a54bccg.mp4";
        videoCelebration6.videoTitle = "Portland Rose Garden";
        videoCelebration6.videoDescription = "The all colors are beautiful.";
        videoItems.add(videoCelebration6);

        videoViewPager.setAdapter(new VideoAdapter(videoItems));
    }
}