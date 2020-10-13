package model;


public class Song {

    // Represents the songs name, artist, and whether or not the song is over
    private String artist;
    private String songName;
    private boolean isSongOver;


    // sets the song name, artist, and whether or not if the song is over
    public Song(String artist, String songName, boolean isSongOver) {
        this.artist = artist;
        this.songName = songName;
        this.isSongOver = isSongOver;

    }


    public String getArtist() {
        return artist;
    }

    public String getSongName() {
        return songName;
    }

    public boolean getIsSongOver() {
        return isSongOver;
    }


    public boolean checkIsSongOver() {
        return isSongOver == true;

    }


    public void setIsSongOver(boolean isSongOver) {
        this.isSongOver = isSongOver;

    }


}
