package com.haqqnuru.musicalstractureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class HighLifeActivity extends AppCompatActivity {

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
        musical.add(new Music(R.drawable.guitorboy, getResources().getString(R.string.victor),
                getResources().getString(R.string.guitor_boy), getResources().getString(R.string.greatest_hits)));
        musical.add(new Music(R.drawable.ghanafreedom, getResources().getString(R.string.et_mensah),
                getResources().getString(R.string.ghana_freedom), getResources().getString(R.string.day_by_day)));
        musical.add(new Music(R.drawable.sweetmother, getResources().getString(R.string.prince),
                getResources().getString(R.string.sweet_mother), getResources().getString(R.string.sweet_mother)));
        musical.add(new Music(R.drawable.yedeaba, getResources().getString(R.string.dr_k),
                getResources().getString(R.string.yede), getResources().getString(R.string.yako)));
        musical.add(new Music(R.drawable.mensa, getResources().getString(R.string.bisa),
                getResources().getString(R.string.mensa), getResources().getString(R.string.break_through)));
        musical.add(new Music(R.drawable.onantefo, getResources().getString(R.string.yamoah),
                getResources().getString(R.string.onantefo), getResources().getString(R.string.saman)));
        musical.add(new Music(R.drawable.sikaye, getResources().getString(R.string.pat),
                getResources().getString(R.string.sika), getResources().getString(R.string.money)));
        musical.add(new Music(R.drawable.akoote, getResources().getString(R.string.george),
                getResources().getString(R.string.akoo), getResources().getString(R.string.odo_color)));
        musical.add(new Music(R.drawable.akwankwa, getResources().getString(R.string.lee),
                getResources().getString(R.string.akwankwa), getResources().getString(R.string.feel_so_good)));
        musical.add(new Music(R.drawable.ironboy, getResources().getString(R.string.amakye_dede),
                getResources().getString(R.string.odo_da), getResources().getString(R.string.iron_boy)));

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

                // passing the selected music to PlayerActivity
                Intent playerIntent = new Intent(HighLifeActivity.this, PlayerActivity.class);
                playerIntent.putExtra(INTENT_KEY_IMAGE, musicImage);
                playerIntent.putExtra(INTENT_KEY_ARTIST, musicArtist);
                playerIntent.putExtra(INTENT_KEY_SONG, musicSong);
                playerIntent.putExtra(INTENT_KEY_ALBUM, musicAlbum);
                startActivity(playerIntent);

            }
        });
    }
}