package com.haqqnuru.musicalstractureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    // declaring intent keys as global String constant
    private static final String INTENT_KEY_IMAGE = "image";
    private static final String INTENT_KEY_ARTIST = "artist";
    private static final String INTENT_KEY_SONG = "song";
    private static final String INTENT_KEY_ALBUM = "album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        // stores the intent message(extras)
        Bundle playerIntent = getIntent().getExtras();

        // set image on to playerActivity
        ImageView imageView = findViewById(R.id.imagePlay);
        if (playerIntent == null) throw new AssertionError();
        int playImage = playerIntent.getInt(INTENT_KEY_IMAGE);
        imageView.setImageResource(playImage);

        // set artist name on to PlayerActivity
        TextView artistName = findViewById(R.id.artistPlay);
        String artist = playerIntent.getString(INTENT_KEY_ARTIST);
        artistName.setText(artist);

        // set song name on to PlayerActivity
        TextView songName = findViewById(R.id.songPlay);
        String song = playerIntent.getString(INTENT_KEY_SONG);
        songName.setText(song);

        // set album name on to PlayerActivity
        TextView albumName = findViewById(R.id.albumPlay);
        String album = playerIntent.getString(INTENT_KEY_ALBUM);
        albumName.setText(album);
    }
}
