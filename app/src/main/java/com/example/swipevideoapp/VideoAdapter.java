package com.example.swipevideoapp;


import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.VideoViewHolder>{

    /**
     *
     * @param videoItems
     */
    public VideoAdapter(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    private List<VideoItem> videoItems;

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VideoViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_video, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        holder.setVideoData(videoItems.get(position));
    }

    @Override
    public int getItemCount() {
        return videoItems.size();
    }

    static class VideoViewHolder extends RecyclerView.ViewHolder{
        TextView textVideoTitle1, textVideoDescription1;
        VideoView videoView;
        ProgressBar progressBar;

        /**
         * Takes the video, title, and description and loads them into the video holder.
         * @param itemView is the overlay viewer
         */
            public VideoViewHolder(@NonNull View itemView) {
                super(itemView);
                videoView = itemView.findViewById(R.id.videoView);
                textVideoTitle1 = itemView.findViewById(R.id.textVideoTitle);
                textVideoDescription1 = itemView.findViewById(R.id.textVideoDescription);
                progressBar = itemView.findViewById(R.id.videoProgressBar);
            }

        /**
         *Prepares the videos to load before you scroll down so that the next video
         * automatically plays when scrolled to. Then it plays the video automatically.
         * @param videoItem is the video from the URL
         */

            void setVideoData(VideoItem videoItem){
                textVideoTitle1.setText(videoItem.videoTitle); //sets text equal to video Title
                textVideoDescription1.setText(videoItem.videoDescription); //sets text to video Description
                videoView.setVideoPath(videoItem.videoURL); //places video in view from URL

                /**
                 * Automatically prepare next video so next video can automatically play when swiped to
                 */
                videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                    @Override
                    public void onPrepared(MediaPlayer mediaPlayer) {
                        progressBar.setVisibility(View.GONE); //progess bar disapears when playing video
                        mediaPlayer.start();

                        float videoRatio = mediaPlayer.getVideoWidth() / (float) mediaPlayer.getVideoHeight();
                        float screenRatio = videoView.getWidth() / (float) videoView.getHeight();

                        float scale = videoRatio / screenRatio;
                        if (scale >= 1f) {
                            videoView.setScaleX(scale);
                        } else {
                            videoView.setScaleY(1f / scale);
                        }
                    }
                });
                /**
                 * Make sure to start playing video
                 */
                    videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });



            }


    }
}
