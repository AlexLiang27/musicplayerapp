package model;

import java.util.ArrayList;

// playlist is a list with the songs

public class Playlist {

    private ArrayList<Song> playList;

    // constructs an empty playlist
    public Playlist() {
        playList = new ArrayList<>();
    }

    //REQUIRES: playList.size() >= 1
    //MODIFIES: this
    //EFFECT: gets the current song in position 0 of the array
    public Song getCurrentSong() {
        if (playList.size() >= 1) {
            return playList.get(0);
        }
        return null;
    }

    //EFFECT: returns the playlist
    public ArrayList<Song> getPlayList() {
        return playList;
    }

    //EFFECT: returns the song in the playlist with given index
    public Song getSongInPlaylist(int index) {
        return playList.get(index);
    }


    //MODIFIES: this
    //EFFECT: adds a song to the array/playlist
    public void addSong(Song song) {
        playList.add(song);
    }

    //REQUIRES: playList.size() >= 2
    //MODIFIES: this
    //EFFECT: skips the song to the next song in the playlist and moves the skipped song to the end of the list
    public void skipSong() {
        if (playList.size() >= 2) {
            Song temp = playList.get(0);
            playList.get(0).setIsSongOver("true");
            playList.remove(0);
            playList.add((playList.size()-1), temp);
        }


    }

    //MODIFIES: this
    //EFFECT: returns the index+1 (position) of the song in the playlist
    public int getSongPosition(Song song) {
       return playList.indexOf(song)+1;
    }











}



