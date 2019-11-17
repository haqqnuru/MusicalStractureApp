package com.haqqnuru.musicalstractureapp;

// contains the image, artist name, song name and album name
public class Music {

    // variables for Music
    private int mImage;
    private String mArtistName;
    private String mSongName;
    private String mAlbumName;

    // constractors for Music
    public Music(int mImage, String mArtistName, String mSongName, String mAlbumName) {
        this.mImage = mImage;
        this.mArtistName = mArtistName;
        this.mSongName = mSongName;
        this.mAlbumName = mAlbumName;
    }

    // get image
    public int getImage() {
        return mImage;
    }

    // get artist name
    public String getArtistName() {
        return mArtistName;
    }

    // get songe name
    public String getSongName() {
        return mSongName;
    }

    // get album name
    public String getAlbumName() {
        return mAlbumName;
    }
}
