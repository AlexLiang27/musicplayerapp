# Spotify Application


## Alex Liang | CPSC 210 | 2020W1

For my personal project, I decided to create a music player similar to 
Spotify. This sparked my interest because I listen to music everyday
and my first idea that came to my mind was to create a
functional music player. My application will do the following:


- run and import music files 
- be able to have a functioning play/pause, skip, playlist viewer, etc.
- anyone can use it, regardless of music tastes and age
- simple ui, easy to access
- be able to shuffle the song within the playlist
- a visual to show what song is currently playing
- my love for music and the everyday use of the Spotify application inspired me to create
something similar and to play user-created playlists

## User Stories

- As a user, I want to be able to skip the song and go to the next
- As a user, I want to be able to add multiple songs to the playlist
- As a user, I want to be able to shuffle the songs in the playlist
- As a user, I want to be able to save the playlist to a file
- As a user, I want to be able to load a playlist from a file
- As a user, I want to be able to play a song from the playlist
- As a user, I want to be able to pause a song from the playlist
- As a user, I want to be able to loop the current song
- As a user, I want to be able to remove the song from the playlist

## Phase 4: Task 2

I have chosen option 1 which was to test and design a class in my model package that is robust.
The class that is designed to be robust is the Song class in the model package. Specifically,
when the song's artist name length given is not a reasonable length and also when the song name length is not a reasonable length. This exception I 
created called SetSongException gets thrown in the constructor of the class song when the requirements of my if statements are met.

## Phase 4: Task 3

If I had more time to work on my project, I would have made my GUI a lot more neater and would have probably included the 
images for the song album everytime the song plays. The picture would then switch whenever the next song is played. Another thing
I would change is my action command if statements because they are really long in this current version.
I would make them switch statements if I had more time because switch statements are the same as if-else statements
but are visually cleaner. I only found out about switch statements near the end of my project. Lastly, another thing
I would add to my project is having multiple playlists.

In terms of design, I would make most if not all my classes more robust so it doesn't have to require anything. This would mean
including exceptions into my methods and my tests. 

