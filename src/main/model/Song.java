package model;


public class Song {

    // Represents the songs name, artist, and whether or not the song is over
    private String artist;
    private String songName;
    private boolean isSongOver;


    //EFFECTS: sets the song name, artist, and whether or not if the song is over
    public Song(String artist, String songName, boolean isSongOver) {
        this.artist = artist;
        this.songName = songName;
        this.isSongOver = isSongOver;

    }

    //EFFECTS: gets the current songs artist
    public String getArtist() {
        return artist;
    }

    //EFFECTS: gets the current songs name
    public String getSongName() {
        return songName;
    }

    //EFFECTS: gets true or false whether or not the song is over
    public boolean getIsSongOver() {
        return isSongOver;
    }


    //EFFECTS: return true if the song is over, otherwise return false
    public boolean checkIsSongOver() {
        return isSongOver == true;

    }

    //MODIFIES: this
    //EFFECTS: sets the song to over
    public void setIsSongOver(boolean isSongOver) {
        this.isSongOver = isSongOver;

    }


}
