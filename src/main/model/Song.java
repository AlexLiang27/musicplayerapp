package model;


public class Song {

    // Represents the songs name, artist, and whether or not the song is over
    private String artist;
    private String songName;

    private String isSongOver;

    // sets the song name, artist, and if the song is over
    public Song(String artist, String songName, String isSongOver) {
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
