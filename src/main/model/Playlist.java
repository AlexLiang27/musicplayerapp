package model;

import java.util.ArrayList;

// playlist is a list with the songs

public class Playlist {

    private ArrayList<Song> playList;

    // constructs an empty playlist
    public Playlist() {
        playList = new ArrayList<>();
    }


    //EFFECT: gets the current song in position 0 of the array
    public Song getCurrentSong() {
        if (playList.size() >= 1) {
            return playList.get(0);
        }
        return null;
    }


    public ArrayList<Song> getPlayList() {
        return playList;
    }

    //EFFECT: returns the song in the playlist with given index
    public Song getSongInPlaylist(int index) {
        return playList.get(index);
    }


    //EFFECT: adds a song to the array/playlist
    public void addSong(Song song) {
        playList.add(song);
    }









}



