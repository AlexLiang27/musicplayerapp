package ui;

// used TellerApp from example as a guideline for the console application

import model.Playlist;
import model.Song;


import java.util.Scanner;


// Spotify application
public class SpotifyApp {

    private Playlist myPlaylist;
    private Playlist myLiked;
    private Song mySong1;
    private Song mySong2;
    private Song mySong3;
    private Song mySong4;
    private Song mySong5;
    private Scanner input;

    //EFFECTS: runs the Spotify application
    public SpotifyApp() {
        runSpotify();
    }


    //MODIFIES: this
    //EFFECTS: processes user input
    private void runSpotify() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nGoodbye!");
    }

    //MODIFIES: this
    //EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("p")) {
            play();
        } else if (command.equals("o")) {
            pause();
        } else if (command.equals("l")) {
            loop();
        } else if (command.equals("a")) {
            add();
        } else if (command.equals("k")) {
            skip();
        } else if (command.equals("s")) {
            shuffle();
        } else if (command.equals("r")) {
            remove();
        } else {
            System.out.println("Selection not valid...");
        }
    }


    //MODIFIES: this
    //EFFECTS: initializes songs and playlist
    private void init() {
        myPlaylist = new Playlist();
        myLiked = new Playlist();
        mySong1 = new Song("ILLENIUM", "Nightlight", true);
        mySong2 = new Song("ARMNHMR", "Here With Me", true);
        mySong3 = new Song("Dabin", "Rings & Roses", true);
        mySong4 = new Song("ILLENIUM", "Crawl Outta Love", true);
        mySong5 = new Song("Nurko", "Better Off Lonely", true);


    }

    //EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from: (MUST ADD SONGS FIRST TIME RUNNING PROGRAM)");
        System.out.println("\ta -> add songs to playlist");
        System.out.println("\tp -> play the song");
        System.out.println("\to -> pause the song");
        System.out.println("\tk -> skip the song");
        System.out.println("\tr -> remove song from playlist");
        System.out.println("\ts -> shuffle playlist");
        System.out.println("\tl -> repeat the song");
        System.out.println("\tq -> quit the program");
    }

    //MODIFIES: this
    //EFFECTS: adds songs to the playlist
    private void add() {

        myPlaylist.addSongToPlaylist(mySong1);
        myPlaylist.addSongToPlaylist(mySong2);
        myPlaylist.addSongToPlaylist(mySong3);
        myPlaylist.addSongToPlaylist(mySong4);
        myPlaylist.addSongToPlaylist(mySong5);
        System.out.println("Songs added");


    }

    //MODIFIES: this
    //EFFECTS: skips the current song to the next
    private void skip() {
        myPlaylist.skipSong();
        System.out.println("Song skipped");


    }

    //MODIFIES: this
    //EFFECTS: shuffles the playlist
    private void shuffle() {
        myPlaylist.shufflePlaylist();
        System.out.println("Shuffling playlist");


    }

    //MODIFIES: this
    //EFFECTS: removes the song from the playlist
    private void remove() {
        myPlaylist.removeSong(myPlaylist.getCurrentSong());
        System.out.println("Removed current song");

    }

    //loops the song
    private void loop() {
        System.out.println("Repeating song");
    }


    //MODIFIES: this
    //EFFECTS: pauses the current song
    private void pause() {
        System.out.println("Paused " + myPlaylist.getCurrentSong().getSongName() + " - "
                + myPlaylist.getCurrentSong().getArtist());

    }

    //MODIFIES: this
    //EFFECTS: plays the current song
    private void play() {
        System.out.println("Playing " + myPlaylist.getCurrentSong().getSongName() + " - "
                + myPlaylist.getCurrentSong().getArtist());


    }

}







