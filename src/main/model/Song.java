package model;


import exception.SetSongException;
import org.json.JSONObject;
import persistence.Writable;

public class Song implements Writable {

    // Represents the songs name, artist, and whether or not the song is over
    // THIS IS THE X BEING ADDED INTO Y
    private String artist;
    private String songName;
    private boolean isSongOver;


    //EFFECTS: sets the song name, artist, and whether or not if the song is over
    public Song(String artist, String songName, boolean isSongOver) throws SetSongException {
        if (artist.length() <= 0 || songName.length() <= 0) {
            throw new SetSongException();
        }
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


    //used method from jsondemo
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("artist", artist);
        json.put("songName", songName);
        json.put("isSongOver", isSongOver);
        return json;
    }


}
