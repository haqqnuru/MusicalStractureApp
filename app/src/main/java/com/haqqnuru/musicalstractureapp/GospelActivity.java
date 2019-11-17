package com.haqqnuru.musicalstractureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class GospelActivity extends AppCompatActivity {

    // declaring intent keys as global String constant
    private static final String INTENT_KEY_IMAGE = "image";
    private static final String INTENT_KEY_ARTIST = "artist";
    private static final String INTENT_KEY_SONG = "song";
    private static final String INTENT_KEY_ALBUM = "album";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_list);

        // creating the Music array list
        ArrayList<Music> musical = new ArrayList<>();

        // adding data to the array
        musical.add(new Music(R.drawable.aseda, getResources().getString(R.string.ohemaa),
                getResources().getString(R.string.aseda), getResources().getString(R.string.wobeye)));
        musical.add(new Music(R.drawable.bonooni, getResources().getString(R.string.joe),
                getResources().getString(R.string.bonoo), getResources().getString(R.string.god_of)));
        musical.add(new Music(R.drawable.life, getResources().getString(R.string.bernice),
                getResources().getString(R.string.life_is_short), getResources().getString(R.string.life)));
        musical.add(new Music(R.drawable.ankamatete, getResources().getString(R.string.tagoe),
                getResources().getString(R.string.anka), getResources().getString(R.string.jesus)));
        musical.add(new Music(R.drawable.afeatome, getResources().getString(R.string.stella),
                getResources().getString(R.string.afe), getResources().getString(R.string.worship)));
        musical.add(new Music(R.drawable.nojuju, getResources().getString(R.string.preachers),
                getResources().getString(R.string.no_juju), getResources().getString(R.string.fearless)));
        musical.add(new Music(R.drawable.domhene, getResources().getString(R.string.comfort),
                getResources().getString(R.string.dom_hene), getResources().getString(R.string.ghana_gospel)));

        // ArrayAdopter
        MusicAdopter Adapter =
                new MusicAdopter(this, musical);

        // calling the listView variable
        ListView listView = findViewById(R.id.musicList);

        // setting adopter to the listView
        listView.setAdapter(Adapter);

        // setting onItemClickListener to the listView so as to pass an intent to
        // playerActivity when an item is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //get the selected music
                Music selectedMusic = (Music) adapterView.getItemAtPosition(i);

                int musicImage = selectedMusic.getImage();
                String musicArtist = selectedMusic.getArtistName();
                String musicSong = selectedMusic.getSongName();
                String musicAlbum = selectedMusic.getAlbumName();

                // passing the selected music from GospelActivity to PlayerActivity
                Intent playerIntent = new Intent(GospelActivity.this, PlayerActivity.class);
                playerIntent.putExtra(INTENT_KEY_IMAGE, musicImage);
                playerIntent.putExtra(INTENT_KEY_ARTIST, musicArtist);
                playerIntent.putExtra(INTENT_KEY_SONG, musicSong);
                playerIntent.putExtra(INTENT_KEY_ALBUM, musicAlbum);
                startActivity(playerIntent);
            }
        });
    }
}
