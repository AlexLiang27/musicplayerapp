package model;

import java.util.ArrayList;
import java.util.Collections;

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


    //EFFECT: returns the song in the playlist with given index
    public Song getSongInPlaylist(int index) {
        return playList.get(index);
    }

    //MODIFIES: this
    //EFFECT: returns the index + 1 (so the position) of the song in the playlist
    public int getSongPosition(Song song) {
        return playList.indexOf(song) + 1;
    }


    //USER STORY (multiple y's into x)
    //MODIFIES: this
    //EFFECT: adds a song to the array/playlist
    public void addSongToPlaylist(Song song) {
        playList.add(song);
    }


    //USER STORY
    //REQUIRES: playList.size() >= 2
    //MODIFIES: this
    //EFFECT: skips the song to the next song in the playlist and moves the skipped song to the end of the list
    public boolean skipSong() {
        if (playList.size() >= 2) {
            Song temp = playList.get(0);
            playList.get(0).setIsSongOver("true");
            playList.remove(0);
            playList.add(temp);
        }
        return false;
    }

    //USER STORY
    //learned to shuffle a list https://www.geeksforgeeks.org/shuffle-or-randomize-a-list-in-java/
    //REQUIRES: playList.size() >= 1
    //MODIFIES: this
    //EFFECT: shuffles the list of songs in the playlist
    public boolean shufflePlaylist() {
        if (playList.size() >= 1) {
            Collections.shuffle(playList);
        }
        return false;
    }


    //USER STORY
    //REQUIRES: playList.size() >= 1
    //MODIFIES: this
    //EFFECT: removes the song from the playlist
    public boolean removeSong(Song song) {
        if (playList.size() >= 1) {
            playList.remove(song);
        }
        return false;
    }
}



