package ui;

// used TellerApp from example as a guideline for the console application

import model.Audio;
import model.Playlist;
import model.Song;
import persistence.JsonReader;
import persistence.JsonWriter;
import model.SongReader;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


// Spotify application
public class SpotifyApp extends JFrame implements ActionListener {

    private static final String JSON_STORE = "./data/playlist.json";
    private Playlist myPlaylist;
    private Playlist myLiked;
    private Song mySong1;
    private Song mySong2;
    private Song mySong3;
    private Song mySong4;
    private Song mySong5;
    private Song mySong6;
    private Song mySong7;
    private Song mySong8;
    private Song mySong9;
    private Song mySong10;
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private Audio currentAudio;



    //phase 3 jswing
    private JLabel currentSong;
    private JLabel currentArtist;
    private JMenuBar saveLoadBar;
    private JMenu file;
    private JMenuItem viewQueue;
    private JMenuItem load;
    private JMenuItem save;
    private JMenu addSongs;
    private JMenuItem firstSong;
    private JMenuItem secondSong;
    private JMenuItem thirdSong;
    private JMenuItem fourthSong;
    private JMenuItem fifthSong;


    //EFFECTS: runs the Spotify application
    public SpotifyApp() throws FileNotFoundException {
        super("Spotify");
        myPlaylist = new Playlist("My Playlist");
        currentAudio = new Audio();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(13, 13, 13, 13));
        setLayout(new FlowLayout());
        currentSong = new JLabel("Welcome to Spotify!");
        currentArtist = new JLabel("Add song to the playlist and load it!");

        add(currentSong);
        add(currentArtist);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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
        } else if (command.equals("save")) {
            savePlaylist();
        } else if (command.equals("load")) {
            loadPlaylist();
        } else {
            System.out.println("Selection not valid...");
        }
    }


    //MODIFIES: this
    //EFFECTS: initializes songs and playlist
    private void init() {

        currentAudio = new Audio();
        myPlaylist = new Playlist("mine");
        myLiked = new Playlist("liked");
        mySong1 = new Song("ILLENIUM", "Nightlight", true);
        mySong2 = new Song("ARMNHMR", "Here With Me", true);
        mySong3 = new Song("Dabin", "Rings & Roses", true);
        mySong4 = new Song("ILLENIUM", "Crawl Outta Love", true);
        mySong5 = new Song("Nurko", "Better Off Lonely", true);
        mySong6 = new Song("Dabin", "Alive", true);
        mySong7 = new Song("Fairlane", "Enough", true);
        mySong8 = new Song("Last Heroes", "Found Us", true);
        mySong9 = new Song("Last Heroes", "Love Like Us", true);
        mySong10 = new Song("Wooli", "Oxygen", true);


    }

    //EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from: ");
        System.out.println("\ta -> add songs to playlist");
        System.out.println("\tp -> play the song");
        System.out.println("\to -> pause the song");
        System.out.println("\tk -> skip the song");
        System.out.println("\tr -> remove song from playlist");
        System.out.println("\ts -> shuffle playlist");
        System.out.println("\tl -> repeat the song");
        System.out.println("\tq -> quit the program");
        System.out.println("\tsave -> save playlist");
        System.out.println("\tload -> load playlist");
    }

    //MODIFIES: this
    //EFFECTS: adds songs to the playlist
    private void add() {

        myPlaylist.addSongToPlaylist(mySong1);
        myPlaylist.addSongToPlaylist(mySong2);
        myPlaylist.addSongToPlaylist(mySong3);
        myPlaylist.addSongToPlaylist(mySong4);
        myPlaylist.addSongToPlaylist(mySong5);
        myPlaylist.addSongToPlaylist(mySong6);
        myPlaylist.addSongToPlaylist(mySong7);
        myPlaylist.addSongToPlaylist(mySong8);
        myPlaylist.addSongToPlaylist(mySong9);
        myPlaylist.addSongToPlaylist(mySong10);
        System.out.println("Songs added");


    }

    //MODIFIES: this
    //EFFECTS: skips the current song to the next
    private void skip() {
        try {
            myPlaylist.skipSong();
            currentAudio.pauseCurrentSong();
            currentAudio.setCurrentAudioStream(SongReader.readSong("./data/" + myPlaylist.getCurrentSong().getSongName()
                    + ".wav"));
            currentAudio.playCurrentSong();
            System.out.println("Song skipped");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You haven't loaded a playlist",
                    "Playlist is empty error", JOptionPane.ERROR_MESSAGE);
        }

    }

    //MODIFIES: this
    //EFFECTS: shuffles the playlist
    private void shuffle() {
        try {
            myPlaylist.shufflePlaylist();

            currentAudio.pauseCurrentSong();
            currentAudio.setCurrentAudioStream(SongReader.readSong("./data/" + myPlaylist.getCurrentSong().getSongName()
                    + ".wav"));
            currentAudio.playCurrentSong();
            System.out.println("Shuffling playlist");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You haven't loaded a playlist",
                    "Playlist is empty error", JOptionPane.ERROR_MESSAGE);

        }
    }

    //MODIFIES: this
    //EFFECTS: removes the song from the playlist
    private void remove() {
        myPlaylist.removeSong(myPlaylist.getCurrentSong());
        System.out.println("Removed current song");

    }

    //MODIFIES: this
    //EFFECTS: loops the song to the start
    private void loop() {
        try {
            currentAudio.pauseCurrentSong();
            currentAudio.setCurrentAudioStream(SongReader.readSong("./data/" + myPlaylist.getCurrentSong().getSongName()
                    + ".wav"));
            currentAudio.playCurrentSong();
            System.out.println("Repeating song");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You haven't loaded a playlist",
                    "Playlist is empty error", JOptionPane.ERROR_MESSAGE);
        }
    }


    //MODIFIES: this
    //EFFECTS: pauses the current song
    private void pause() {
        currentAudio.pauseCurrentSong();
        System.out.println("Paused " + myPlaylist.getCurrentSong().getSongName() + " - "
                + myPlaylist.getCurrentSong().getArtist());

    }

    //MODIFIES: this
    //EFFECTS: plays the current song
    private void play() {
        try {

            currentAudio.playCurrentSong();
            System.out.println("Playing " + myPlaylist.getCurrentSong().getSongName() + " - "
                    + myPlaylist.getCurrentSong().getArtist());
        } catch (Exception e) {
            System.err.println("You forgot to load a playlist!");
        }

    }


    // used method and modelled from the jsondemo
    // EFFECTS: saves the playlist to file
    private void savePlaylist() {
        try {
            jsonWriter.open();
            jsonWriter.write(myPlaylist);
            jsonWriter.close();
            System.out.println("Saved Playlist" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    //used method and modelled from the jsondemo
    // MODIFIES: this
    // EFFECTS: loads the playlist from file
    private void loadPlaylist() {
        try {

            myPlaylist = jsonReader.read();
            System.out.println("Loaded playlist" + " from " + JSON_STORE);
            currentAudio.setCurrentAudioStream(SongReader.readSong("./data/" + myPlaylist.getCurrentSong().getSongName()
                    + ".wav"));
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    public void actionPerformed(ActionEvent e) {

    }
}







