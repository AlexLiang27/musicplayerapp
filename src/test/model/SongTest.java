package model;

// followed the AccountTest example format to guide my way through tests

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    private Song testSong1;
    private Song testSong2;
    private Song testSong3;

    @BeforeEach
    void setUp() {
        testSong1 = new Song("ILLENIUM", "Nightlight", false);
        testSong2 = new Song("ARMNHMR", "Here With Me", true);
        testSong3 = new Song("Dabin", "Rings & Roses", true);
    }

    @Test
    void testConstructor() {
        assertEquals("ILLENIUM", testSong1.getArtist());
        assertEquals("Nightlight", testSong1.getSongName());
        assertEquals(false, testSong1.getIsSongOver());

        assertEquals("ARMNHMR", testSong2.getArtist());
        assertEquals("Here With Me", testSong2.getSongName());
        assertEquals(true, testSong2.getIsSongOver());

        assertEquals("Dabin", testSong3.getArtist());
        assertEquals("Rings & Roses", testSong3.getSongName());
        assertEquals(true, testSong3.getIsSongOver());


    }


    @Test
    void testCheckIsSongOver() {
        assertFalse(testSong1.checkIsSongOver());
        assertTrue(testSong2.checkIsSongOver());
        assertTrue(testSong3.checkIsSongOver());
        testSong1.setIsSongOver(true);
        assertTrue(testSong1.checkIsSongOver());
        testSong2.setIsSongOver(false);
        assertFalse(testSong2.checkIsSongOver());
        testSong3.setIsSongOver(false);
        assertFalse(testSong3.checkIsSongOver());

    }


    @Test
    void testToJson() {

        JSONObject obj = testSong1.toJson();
        assertEquals(obj.getString("artist"), testSong1.getArtist());
        assertEquals(obj.getString("songName"), testSong1.getSongName());
        assertEquals(obj.getBoolean("isSongOver"), testSong1.getIsSongOver());
        assertEquals(JSONObject.getNames(obj).length, 3);




    }

}
