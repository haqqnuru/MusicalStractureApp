package com.haqqnuru.musicalstractureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MusicAdopter extends ArrayAdapter<Music> {

    public MusicAdopter(@NonNull Context context, ArrayList<Music> music) {
        super(context, 0, music);
    }

    // gets and positions the view to be populated on list_music.xml
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listMusicView = convertView;
        if (listMusicView == null) {
            listMusicView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_music, parent, false);
        }

        // Get the Music object located at this position in the list
        Music currentMusic = getItem(position);

        // Find the ImageView(listViewImage) in the list_music.xml layout
        ImageView mImage = listMusicView.findViewById(R.id.listViewImage);
        // Get the image from the current Music object and set image on the name mImage
        if (currentMusic == null) throw new AssertionError();
        mImage.setImageResource(currentMusic.getImage());

        // Find the TextView(artistListView) in the list_music.xml layout
        TextView mArtist = listMusicView.findViewById(R.id.artistListView);
        // Get the artistName from the current Music object and set text on the name mArtist
        mArtist.setText(currentMusic.getArtistName());

        // Find the TextView(songListView) in the list_music.xml layout
        TextView mSong = listMusicView.findViewById(R.id.songListView);
        // Get the songName from the current Music object and set text on the name mSong
        mSong.setText(currentMusic.getSongName());

        // Find the TextView(albumListView) in the list_music.xml layout
        TextView mAlbum = listMusicView.findViewById(R.id.albumListView);
        // Get the albumName from the current Music object and set text on the name mAlbum
        mAlbum.setText(currentMusic.getAlbumName());

        // setting different row colors to list view (
        if (position % 2 == 0) {
            listMusicView.setBackgroundResource(R.color.beige);
        } else {
            listMusicView.setBackgroundResource(R.color.beige_light);
        }

        // Returns the whole list_music layout containing 3 TextViews and an ImageView
        // so that it can be shown in the ListView
        return listMusicView;
    }
}
