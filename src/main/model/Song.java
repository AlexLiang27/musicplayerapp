package model;


public class Song {

    // Represents the songs name, artist, and whether or not the song is over
    private String songName;
    private String artist;
    private String isSongOver;

    // sets the song name, artist, and if the song is over
    public Song(String songName, String artist, String isSongOver) {
        this.songName = songName;
        this.artist = artist;
        this.isSongOver = isSongOver;
    }

    public String getSongName() {
        return songName;
    }


    public String getArtist() {
        return artist;
    }

    public String getIsSongOver() {
        return isSongOver;
    }


    public boolean checkIsSongOver() {
        return isSongOver.equals("true");

    }


    public void setIsSongOver(String isSongOver) {
        this.isSongOver = isSongOver;


    }







}
