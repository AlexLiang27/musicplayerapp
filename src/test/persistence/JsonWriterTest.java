package persistence;

import exception.SetSongException;
import model.Playlist;
import model.Song;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


// MODELLED/USED THE JSONDEMO (EXAMPLE IN PHASE 2) FOR THIS CLASS
class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            Playlist pl = new Playlist("playlist");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptyPlaylist() {
        try {
            Playlist pl = new Playlist("playlist");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPlaylist.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPlaylist.json");
            pl = reader.read();
            assertEquals("playlist", pl.getName());


            assertEquals(0, pl.size());
        } catch (IOException | SetSongException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterPlaylist() throws SetSongException {
        try {
            Playlist pl = new Playlist("playlist");
            pl.addSongToPlaylist(new Song("ILLENIUM", "Nightlight", true));
            pl.addSongToPlaylist(new Song("Nurko", "Better Off Lonely", true));
            JsonWriter writer = new JsonWriter("./data/testWriterPlaylist.json");
            writer.open();
            writer.write(pl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterPlaylist.json");
            pl = reader.read();
            assertEquals("playlist", pl.getName());


            assertEquals(2, pl.size());
            checkSong("ILLENIUM", "Nightlight", true, pl.getSongInPlaylist(0));
            checkSong("Nurko", "Better Off Lonely", true, pl.getSongInPlaylist(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}