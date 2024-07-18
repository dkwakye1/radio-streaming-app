package com.example.dan.expressradio;

import android.media.MediaPlayer;

import java.io.IOException;

public class MyStationsPlayer {



    MediaPlayer player = new MediaPlayer();


    public void stopPlaying() {
        if (player.isPlaying()) {
            player.stop();
            player.reset();

        }
    }

    public void initializeMediaPlayer(String stationUrl) {
        try {
            player.reset();
            player.setDataSource(stationUrl);
            player.prepareAsync();

            player.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                public void onPrepared(MediaPlayer player) {
                    player.start();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


