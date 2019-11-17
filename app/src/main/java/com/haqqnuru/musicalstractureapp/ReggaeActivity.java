package com.haqqnuru.musicalstractureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ReggaeActivity extends AppCompatActivity {

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
        musical.add(new Music(R.drawable.wo, getResources().getString(R.string.rasKuuku),
                getResources().getString(R.string.wo), getResources().getString(R.string.kunkunkununku)));
        musical.add(new Music(R.drawable.baafira, getResources().getString(R.string.Stonebwoy_ft),
                getResources().getString(R.string.Baafira), getResources().getString(R.string.epistles)));
        musical.add(new Music(R.drawable.rainbow, getResources().getString(R.string.samini),
                getResources().getString(R.string.rainbow), getResources().getString(R.string.untamed)));
        musical.add(new Music(R.drawable.wickedest, getResources().getString(R.string.rocky),
                getResources().getString(R.string.wicked), getResources().getString(R.string.beat)));
        musical.add(new Music(R.drawable.ghettolove, getResources().getString(R.string.stonebwoy),
                getResources().getString(R.string.ghetto), getResources().getString(R.string.grade)));
        musical.add(new Music(R.drawable.innadancehall, getResources().getString(R.string.shatta),
                getResources().getString(R.string.inna), getResources().getString(R.string.inna)));
        musical.add(new Music(R.drawable.alright, getResources().getString(R.string.akesse),
                getResources().getString(R.string.alright), getResources().getString(R.string.songs_in)));
        musical.add(new Music(R.drawable.todaytoo, getResources().getString(R.string.addi),
                getResources().getString(R.string.today), getResources().getString(R.string.today)));

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

                // passing the selected music from ReggaeActivity to PlayerActivity
                Intent playerIntent = new Intent(ReggaeActivity.this, PlayerActivity.class);
                playerIntent.putExtra(INTENT_KEY_IMAGE, musicImage);
                playerIntent.putExtra(INTENT_KEY_ARTIST, musicArtist);
                playerIntent.putExtra(INTENT_KEY_SONG, musicSong);
                playerIntent.putExtra(INTENT_KEY_ALBUM, musicAlbum);
                startActivity(playerIntent);
            }
        });
    }
}