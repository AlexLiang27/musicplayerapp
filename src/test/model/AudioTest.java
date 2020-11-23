package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.SongFileRead;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

// test for my audio class specifically the play and pause methods. indirectly tested isSongAlive
public class AudioTest {
    private Audio testAudio;

    @BeforeEach
    void setUp() {
        testAudio = new Audio();
    }


    @Test
    void testPlayAndPause() {
        try {
            testAudio.setCurrentAudioStream(SongFileRead.readFile("./data/Enough.wav"));
            testAudio.playCurrentSong();
            assertTrue(testAudio.isSongAlive());
            testAudio.pauseCurrentSong();
            assertTrue(testAudio.isSongAlive());


        } catch (IOException e) {
            fail("Should not have thrown exception");
        }
        try {

            testAudio.setCurrentAudioStream(SongFileRead.readFile("./data/Cannotread.wav"));
            fail("Should have thrown exception");
        } catch (IOException e) {

        }
    }




}