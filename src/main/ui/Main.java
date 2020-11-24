package ui;

import exception.SetSongException;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new SpotifyApp();
        } catch (FileNotFoundException | SetSongException e) {
            System.out.println("Unable to run application: file not found");
        }
    }
}
