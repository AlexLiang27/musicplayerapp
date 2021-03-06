package model;


// followed the AccountTest example format to guide my way through tests


import exception.SetSongException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlaylistTest {

    private Playlist testPlaylist;
    private Playlist testEmptyPlaylist;
    private Song testSongInPlaylist1;
    private Song testSongInPlaylist2;
    private Song testSongInPlaylist3;
    private Song testSongInPlaylist4;


    @BeforeEach
    void setUp() throws SetSongException {
        testPlaylist = new Playlist("liked");
        testEmptyPlaylist = new Playlist("empty");

        testSongInPlaylist1 = new Song("ILLENIUM", "Nightlight", false);
        testSongInPlaylist2 = new Song("ARMNHMR", "Here With Me", true);
        testSongInPlaylist3 = new Song("Dabin", "Rings & Roses", true);

        testSongInPlaylist4 = new Song("Nurko", "Better Off Lonely", true);

        testPlaylist.addSongToPlaylist(testSongInPlaylist1);
        testPlaylist.addSongToPlaylist(testSongInPlaylist2);
        testPlaylist.addSongToPlaylist(testSongInPlaylist3);

    }


    @Test
    void testConstructor() {
        assertEquals(testSongInPlaylist1, testPlaylist.getSongInPlaylist(0));
        assertEquals(testSongInPlaylist2, testPlaylist.getSongInPlaylist(1));
        assertEquals(testSongInPlaylist3, testPlaylist.getSongInPlaylist(2));
        assertEquals(3, testPlaylist.getPlaylist().size());


    }


    @Test
    void testGetCurrentSong() {
        assertEquals(testSongInPlaylist1, testPlaylist.getCurrentSong());
        testPlaylist.skipSong();
        assertEquals(testSongInPlaylist2, testPlaylist.getCurrentSong());
        testPlaylist.skipSong();
        assertEquals(testSongInPlaylist3, testPlaylist.getCurrentSong());
        testPlaylist.skipSong();
        assertEquals(testSongInPlaylist1, testPlaylist.getCurrentSong());

        assertFalse(testEmptyPlaylist.skipSong());
    }


    @Test
    void testAddSongToPlaylist() {
        assertEquals(1, testPlaylist.getSongPosition(testSongInPlaylist1));
        assertEquals(2, testPlaylist.getSongPosition(testSongInPlaylist2));
        assertEquals(3, testPlaylist.getSongPosition(testSongInPlaylist3));
        assertEquals(3, testPlaylist.size());
        testPlaylist.addSongToPlaylist(testSongInPlaylist4);
        assertEquals(4, testPlaylist.getSongPosition(testSongInPlaylist4));
        assertEquals(4, testPlaylist.size());

    }


    @Test
    void testShufflePlaylist() {
        Playlist testPlaylistClone = new Playlist("clone");
        testPlaylistClone.addSongToPlaylist(testSongInPlaylist1);
        testPlaylistClone.addSongToPlaylist(testSongInPlaylist2);
        testPlaylistClone.addSongToPlaylist(testSongInPlaylist3);
        testPlaylistClone.addSongToPlaylist(testSongInPlaylist4);

        testPlaylistClone.shufflePlaylist();
        assertFalse(testPlaylist.equals(testPlaylistClone));

        assertFalse(testEmptyPlaylist.shufflePlaylist());


    }


    @Test
    void testRemoveSong() {
        assertEquals(testSongInPlaylist1, testPlaylist.getCurrentSong());
        testPlaylist.removeSong(testSongInPlaylist2);
        testPlaylist.skipSong();
        assertEquals(testSongInPlaylist3, testPlaylist.getCurrentSong());

        assertFalse(testEmptyPlaylist.removeSong(testSongInPlaylist1));
    }


    @Test
    void testEmptyPlaylist() {
        assertNull(testEmptyPlaylist.getCurrentSong());
    }


    @Test
    void testJsonStuff() {
        JSONObject obj = testPlaylist.toJson();
        assertEquals(obj.get("name"), testPlaylist.getName());


    }


}
