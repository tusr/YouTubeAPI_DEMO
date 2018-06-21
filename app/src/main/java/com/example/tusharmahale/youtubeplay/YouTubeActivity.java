package com.example.tusharmahale.youtubeplay;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
public  final String API_KEY = ""; //Generate your API key on google developer console
public  final String YOUTUBE_VIDEOID="bwTAsOOnXic";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout constraintLayout=(ConstraintLayout)(getLayoutInflater().inflate(R.layout.activity_you_tube,null));
        setContentView(constraintLayout);
        YouTubePlayerView playerView = new YouTubePlayerView(this);
        playerView.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        constraintLayout.addView(playerView);
        playerView.initialize(API_KEY,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Toast.makeText(this,"YT player initialized successfully",Toast.LENGTH_SHORT).show();
    youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);
    youTubePlayer.setPlaybackEventListener(playbackEventListener);
        if(!wasRestored)
    {
        youTubePlayer.cueVideo(YOUTUBE_VIDEOID);
    }



    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
final int REQUEST_CODE = 1;
if(youTubeInitializationResult.isUserRecoverableError())
{
    youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE);
}
else{
    String errorMessagge = String.format("There was a error in initializing youtube player (%1$s)",youTubeInitializationResult.toString());
    Toast.makeText(this,errorMessagge,Toast.LENGTH_SHORT).show();
}
    }
    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YouTubeActivity.this,"Video is playing",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {
            Toast.makeText(YouTubeActivity.this,"Video is paused",Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onStopped() {
            Toast.makeText(YouTubeActivity.this,"Video is stopped",Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
    private YouTubePlayer.PlayerStateChangeListener  playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {
Toast.makeText(YouTubeActivity.this,"Ad started",Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YouTubeActivity.this,"Video started",Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onVideoEnded() {
            Toast.makeText(YouTubeActivity.this,"Video Ended",Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };
}
