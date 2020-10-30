package persistence;

import model.Song;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JsonTest {
    protected void checkSong(String artist, String songName, boolean isSongOver, Song song){
        assertEquals(artist, song.getArtist());
        assertEquals(songName, song.getSongName());
        assertEquals(isSongOver, song.getIsSongOver());



    }

}
