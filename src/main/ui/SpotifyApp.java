package ui;

// used TellerApp from example as a guideline for the console application

//https://www.youtube.com/watch?v=vUD5Mo2jjHs&feature=youtu.be for learning some of java swing



import model.Audio;
import model.Playlist;
import model.Song;
import persistence.JsonReader;
import persistence.JsonWriter;
import model.SongFileRead;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;




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
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private Audio currentAudio;


    //phase 3 jswing/ui

    private JFrame window;
    private JLabel label1;
    private JLabel label2;
    private JMenuItem songMenu1;
    private JMenuItem songMenu2;
    private JMenuItem songMenu3;
    private JMenuItem songMenu4;
    private JMenuItem songMenu5;
    private JMenuItem songMenu6;
    private JMenuItem songMenu7;
    private JMenuItem songMenu8;
    private JMenuItem songMenu9;
    private JMenuItem songMenu10;
    private JMenuBar barMenu;
    private JMenu fileMenu;
    private JMenu addSongsMenu;
    private JMenu viewPlaylist;
    private JMenuItem loadMenu;
    private JMenuItem saveMenu;

    private ImageIcon logo;
    private JLabel icon;


    //EFFECTS: runs the Spotify application
    public SpotifyApp() throws FileNotFoundException {
        init();

        window = new JFrame("Spotify");
        window.setPreferredSize(new Dimension(360, 300));
        window.setDefaultCloseOperation(window.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.white);
        window.setLayout(new FlowLayout());
        label1 = new JLabel("Welcome to Spotify 2.0!");
        label2 = new JLabel("Add some songs and load them in!");

        createButtons();
        createMenu();
        window.add(label1);
        window.add(label2);
        createLogo();



        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setResizable(false);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

    }


    //MODIFIES: this
    //EFFECTS: creates the spotify logo :)

    private void createLogo() {
        logo = new ImageIcon("./data/icon1@2x.png");
        Image image = logo.getImage();
        Image modifiedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        logo = new ImageIcon(modifiedImage);
        icon = new JLabel("");
        icon.setIcon(logo);
        window.add(icon);
    }

    //MODIFIES: this
    //EFFECTS: creates the buttons to make the basic music player functions work
    private void createButtons() {
        JButton play = new JButton("Play");
        play.setActionCommand("play");
        play.addActionListener(this);

        JButton pause = new JButton("Pause");
        pause.setActionCommand("pause");
        pause.addActionListener(this);

        JButton skip = new JButton("Skip");
        skip.setActionCommand("skip");
        skip.addActionListener(this);

        JButton loop = new JButton("Loop");
        loop.setActionCommand("loop");
        loop.addActionListener(this);

        JButton shuffle = new JButton("Shuffle");
        shuffle.setActionCommand("shuffle");
        shuffle.addActionListener(this);

        window.add(shuffle);
        window.add(play);
        window.add(pause);
        window.add(skip);
        window.add(loop);

    }





    //MODIFIES: this
    //EFFECTS: creates the menu bar at the top (file and add)
    private void createMenu() {
        barMenu = new JMenuBar();
        fileMenu = new JMenu("File");
        barMenu.add(fileMenu);
        loadMenu = new JMenuItem("Load");
        loadMenu.setActionCommand("load");
        loadMenu.addActionListener(this);
        saveMenu = new JMenuItem("Save");
        saveMenu.setActionCommand("save");
        saveMenu.addActionListener(this);
        addSongsMenu = new JMenu("Add");
        fileMenu.add(loadMenu);
        fileMenu.add(saveMenu);
        barMenu.add(addSongsMenu);
        barMenu.add(viewPlaylist);
        createSongsToAdd();
        createMoreSongsToAdd();
        window.setJMenuBar(barMenu);

    }


    //MODIFIES: this
    //EFFECTS: creates all the songs you can add to the playlist
    private void createSongsToAdd() {
        songMenu1 = new JMenuItem(mySong1.getSongName());
        songMenu1.setActionCommand("song1");
        songMenu1.addActionListener(this);

        songMenu2 = new JMenuItem(mySong2.getSongName());
        songMenu2.setActionCommand("song2");
        songMenu2.addActionListener(this);

        songMenu3 = new JMenuItem(mySong3.getSongName());
        songMenu3.setActionCommand("song3");
        songMenu3.addActionListener(this);

        songMenu4 = new JMenuItem(mySong4.getSongName());
        songMenu4.setActionCommand("song4");
        songMenu4.addActionListener(this);

        songMenu5 = new JMenuItem(mySong5.getSongName());
        songMenu5.setActionCommand("song5");
        songMenu5.addActionListener(this);

        addSongsMenu.add(songMenu1);
        addSongsMenu.add(songMenu2);
        addSongsMenu.add(songMenu3);
        addSongsMenu.add(songMenu4);
        addSongsMenu.add(songMenu5);


    }

    //MODIFIES: this
    //EFFECTS: creates songs you can add to the playlist // continued because code would be too long
    private void createMoreSongsToAdd() {
        songMenu6 = new JMenuItem(mySong6.getSongName());
        songMenu6.setActionCommand("song6");
        songMenu6.addActionListener(this);

        songMenu7 = new JMenuItem(mySong7.getSongName());
        songMenu7.setActionCommand("song7");
        songMenu7.addActionListener(this);

        songMenu8 = new JMenuItem(mySong8.getSongName());
        songMenu8.setActionCommand("song8");
        songMenu8.addActionListener(this);

        songMenu9 = new JMenuItem(mySong9.getSongName());
        songMenu9.setActionCommand("song9");
        songMenu9.addActionListener(this);

        songMenu10 = new JMenuItem(mySong10.getSongName());
        songMenu10.setActionCommand("song10");
        songMenu10.addActionListener(this);

        addSongsMenu.add(songMenu6);
        addSongsMenu.add(songMenu7);
        addSongsMenu.add(songMenu8);
        addSongsMenu.add(songMenu9);
        addSongsMenu.add(songMenu10);


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




    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("play")) {
            play();
        } else if (e.getActionCommand().equals("pause")) {
            pause();
        } else if (e.getActionCommand().equals("skip")) {
            skip();
        } else if (e.getActionCommand().equals("loop")) {
            loop();
        } else if (e.getActionCommand().equals("shuffle")) {
            shuffle();
        } else if (e.getActionCommand().equals("save")) {
            savePlaylist();
        } else if (e.getActionCommand().equals("load")) {
            loadPlaylist();
        } else {
            addSongsActionPerformed(e);
            addMoreSongsActionPerformed(e);
        }
    }





    public void addSongsActionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("song1")) {
            myPlaylist.addSongToPlaylist(mySong1);
            label1.setText(mySong1.getSongName());
            label2.setText("has been added to your playlist");
        } else if (e.getActionCommand().equals("song2")) {
            myPlaylist.addSongToPlaylist(mySong2);
            label1.setText(mySong2.getSongName());
            label2.setText("has been added to your playlist");
        } else if (e.getActionCommand().equals("song3")) {
            myPlaylist.addSongToPlaylist(mySong3);
            label1.setText(mySong3.getSongName());
            label2.setText("has been added to your playlist");
        } else if (e.getActionCommand().equals("song4")) {
            myPlaylist.addSongToPlaylist(mySong4);
            label1.setText(mySong4.getSongName());
            label2.setText("has been added to your playlist");
        } else if (e.getActionCommand().equals("song5")) {
            myPlaylist.addSongToPlaylist(mySong5);
            label1.setText(mySong5.getSongName());
            label2.setText("has been added to your playlist");
        }
    }


    public void addMoreSongsActionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("song6")) {
            myPlaylist.addSongToPlaylist(mySong6);
            label1.setText(mySong6.getSongName());
            label2.setText("has been added to your playlist");
        } else if (e.getActionCommand().equals("song7")) {
            myPlaylist.addSongToPlaylist(mySong7);
            label1.setText(mySong7.getSongName());
            label2.setText("has been added to your playlist");
        } else if (e.getActionCommand().equals("song8")) {
            myPlaylist.addSongToPlaylist(mySong8);
            label1.setText(mySong8.getSongName());
            label2.setText("has been added to your playlist");
        } else if (e.getActionCommand().equals("song9")) {
            myPlaylist.addSongToPlaylist(mySong9);
            label1.setText(mySong9.getSongName());
            label2.setText("has been added to your playlist");
        } else if (e.getActionCommand().equals("song10")) {
            myPlaylist.addSongToPlaylist(mySong10);
            label1.setText(mySong10.getSongName());
            label2.setText("has been added to your playlist");
        }
    }


    //MODIFIES: this
    //EFFECTS: skips the current song to the next
    private void skip() {
        try {
            myPlaylist.skipSong();
            currentAudio.pauseCurrentSong();
            currentAudio.setCurrentAudioStream(SongFileRead.readFile("./data/"
                    + myPlaylist.getCurrentSong().getSongName() + ".wav"));
            currentAudio.playCurrentSong();
            label1.setText("Skipped song and now playing: " + myPlaylist.getCurrentSong().getSongName());
            label2.setText("by: " + myPlaylist.getCurrentSong().getArtist());
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
            currentAudio.setCurrentAudioStream(SongFileRead.readFile("./data/"
                    + myPlaylist.getCurrentSong().getSongName() + ".wav"));
            currentAudio.playCurrentSong();
            label1.setText("Now playing: " + myPlaylist.getCurrentSong().getSongName());
            label2.setText("by: " + myPlaylist.getCurrentSong().getArtist());
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
            currentAudio.setCurrentAudioStream(SongFileRead.readFile("./data/"
                    + myPlaylist.getCurrentSong().getSongName() + ".wav"));
            currentAudio.playCurrentSong();
            label1.setText("Looping: " + myPlaylist.getCurrentSong().getSongName());
            label2.setText("by: " + myPlaylist.getCurrentSong().getArtist());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You haven't loaded a playlist",
                    "Playlist is empty error", JOptionPane.ERROR_MESSAGE);
        }
    }


    //MODIFIES: this
    //EFFECTS: pauses the current song
    private void pause() {
        currentAudio.pauseCurrentSong();
        label1.setText("Paused: " + myPlaylist.getCurrentSong().getSongName());
        label2.setText("BY: " + myPlaylist.getCurrentSong().getArtist());

    }

    //MODIFIES: this
    //EFFECTS: plays the current song
    private void play() {
        try {

            currentAudio.playCurrentSong();
            label1.setText("Now playing: " + myPlaylist.getCurrentSong().getSongName());
            label2.setText("by: " + myPlaylist.getCurrentSong().getArtist());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "You have not loaded in a playlist",
                    "Empty Playlist Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    // used method and modelled from the jsondemo
    // EFFECTS: saves the playlist to file
    private void savePlaylist() {
        try {
            jsonWriter.open();
            jsonWriter.write(myPlaylist);
            jsonWriter.close();
            label1.setText("You have saved your playlist!");
            label2.setText("");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Not Found",
                    "File Not Found Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //used method and modelled from the jsondemo given in phase 2
    // MODIFIES: this
    // EFFECTS: loads the playlist from file
    private void loadPlaylist() {
        try {

            myPlaylist = jsonReader.read();
            label1.setText("Your playlist has now been loaded!");
            label2.setText("");
            currentAudio.setCurrentAudioStream(SongFileRead.readFile("./data/"
                    + myPlaylist.getCurrentSong().getSongName() + ".wav"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File Not Found",
                    "File Not Found Error", JOptionPane.ERROR_MESSAGE);
        }
    }


}






