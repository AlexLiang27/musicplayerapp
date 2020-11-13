// WATCHED THIS VIDEO https://www.youtube.com/watch?v=3q4f6I5zi2w TO LEARN HOW TO PLAY AUDIO IN JAVA


package model;

import org.json.JSONObject;
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
    //EFFECTS: creates a new AudioStream
    public void setCurrentAudioStream(InputStream music) throws IOException {
        audio = new AudioStream(music);
    }

    //MODIFIES: this
    //EFFECTS: plays the current audio
    public void playCurrentSong()  {
        AudioPlayer.player.start(audio);
    }

    //MODIFIES: this
    //EFFECTS: pauses the current audio
    public void pauseCurrentSong() {
        AudioPlayer.player.stop(audio);
    }

    //EFFECTS: checks to makes sure audio is still alive
    public boolean isSongAlive() {
        return AudioPlayer.player.isAlive();
    }
}
