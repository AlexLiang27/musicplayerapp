// WATCHED THIS VIDEO https://www.youtube.com/watch?v=3q4f6I5zi2w TO LEARN HOW TO PLAY AUDIO IN JAVA


package model;


import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.io.IOException;
import java.io.InputStream;

//This class represents the outputted audio
public class Audio {
    private AudioStream audio;

    //Creates an AudioStream
    public Audio() {
        audio = null;
    }



    //MODIFIES: this
    //EFFECTS: creates a new AudioStream \\ java lib
    public void setCurrentAudioStream(InputStream audioFile) throws IOException {
        audio = new AudioStream(audioFile);
    }

    //MODIFIES: this
    //EFFECTS: plays the audio
    public void playCurrentSong()  {
        AudioPlayer.player.start(audio);
    }

    //MODIFIES: this
    //EFFECTS: pauses the audio
    public void pauseCurrentSong() {
        AudioPlayer.player.stop(audio);
    }

    //EFFECTS: checks to makes sure audio is still alive
    public boolean isSongAlive() {
        return AudioPlayer.player.isAlive();
    }
}
