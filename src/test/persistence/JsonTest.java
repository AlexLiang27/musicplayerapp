package persistence;

import model.Song;

import static org.junit.jupiter.api.Assertions.assertEquals;

//MODELLED AFTER PHASE 2 EXAMPLE GIVEN

public class JsonTest {
    protected void checkSong(String artist, String songName, boolean isSongOver, Song song) {
        assertEquals(artist, song.getArtist());
        assertEquals(songName, song.getSongName());
        assertEquals(isSongOver, song.getIsSongOver());


    }

}
