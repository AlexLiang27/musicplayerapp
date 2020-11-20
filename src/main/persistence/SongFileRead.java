package persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

// reads the music file in the data package
// learned through https://www.programiz.com/java-programming/inputstream
public class SongFileRead {

    //EFFECTS: returns the audio with given filepath
    public static InputStream readFile(String filepath) throws FileNotFoundException {
        InputStream audioFile = new FileInputStream(new File(filepath));
        return audioFile;
    }

}
