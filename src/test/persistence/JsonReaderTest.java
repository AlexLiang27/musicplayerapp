package persistence;


import exception.SetSongException;
import model.Song;
import model.Playlist;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


//CITATION: USED JSONDEMO/MODELLED AFTER THE GIVEN EXAMPLE IN PHASE 2
class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Playlist pl = reader.read();
            fail("IOException expected");
        } catch (IOException | SetSongException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPlaylist() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPlaylist.json");
        try {
            Playlist pl = reader.read();
            assertEquals(0, pl.size());
        } catch (IOException | SetSongException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderPlaylist() {
        JsonReader reader = new JsonReader("./data/testReaderPlaylist.json");
        try {
            Playlist pl = reader.read();
            assertEquals(2, pl.size());
            checkSong("ILLENIUM", "Nightlight", true, pl.getSongInPlaylist(0));
            checkSong("Nurko", "Better Off Lonely", true, pl.getSongInPlaylist(1));
        } catch (IOException | SetSongException e) {
            fail("Couldn't read from file");
        }
    }
}