package model;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.IOException;
import java.io.InputStream;

public class Controller {

    private AudioStream audio;

    // constructs an audiostream (java lib)
    public Controller() {
        audio = null;
    }

    //MODIFIES: this
    //EFFECTS: creates a new audiostream
    public void setAudioAsSong(InputStream music) throws IOException {
        audio = new AudioStream(music);
    }

    //MODIFIES: this
    //EFFECTS: plays the audio
    public void playSong()  {
        AudioPlayer.player.start(audio);
    }

    //MODIFIES: this
    //EFFECTS: pauses the audio
    public void pauseSong() {
        AudioPlayer.player.stop(audio);
    }



}
