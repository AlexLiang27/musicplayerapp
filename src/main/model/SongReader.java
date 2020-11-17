package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

// reads the music file in the data package
public class SongReader {


    //EFFECTS: returns the audio with given filepath
    public static InputStream readSong(String filepath) throws FileNotFoundException {
        InputStream
        music = new FileInputStream(new File(filepath));
        return music;
    }

}
