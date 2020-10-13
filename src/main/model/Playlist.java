package model;

import java.util.ArrayList;
import java.util.Collections;

// playlist is a list of songs

public class Playlist {

    private ArrayList<Song> playList;

    // constructs an empty playlist
    public Playlist() {
        playList = new ArrayList<>();
    }


    //MODIFIES: this
    //EFFECT: gets the current song in position 0 of the list
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
    //EFFECT: adds a song to the playlist
    public void addSongToPlaylist(Song song) {
        playList.add(song);
    }


    //USER STORY
    //MODIFIES: this
    //EFFECT: skips the song to the next song in the playlist and moves the skipped song to the end of the list
    //        and returns true, otherwise false
    public boolean skipSong() {
        if (playList.size() >= 2) {
            Song temp = playList.get(0);
            playList.get(0).setIsSongOver(true);
            playList.remove(0);
            playList.add(temp);
            return true;
        }
        return false;
    }

    //USER STORY
    //learned to shuffle a list https://www.geeksforgeeks.org/shuffle-or-randomize-a-list-in-java/
    //MODIFIES: this
    //EFFECT: shuffles the list of songs in the playlist and returns true, otherwise false
    public boolean shufflePlaylist() {
        if (playList.size() >= 1) {
            Collections.shuffle(playList);
            return true;
        }
        return false;
    }


    //USER STORY
    //MODIFIES: this
    //EFFECT: removes the song from the playlist and returns true, otherwise false
    public boolean removeSong(Song song) {
        if (playList.size() >= 1) {
            playList.remove(song);
            return true;
        }
        return false;
    }
}



