import javax.swing.JOptionPane;

public class MusicPlaylistManager {
    public static void main(String[] args) {
        // Array for menu options
        String[] homeOptions = { "Exit", "Remove Song", "Add Song", "Display Current Playlist" };

        JOptionPane.showMessageDialog(null, 
            "Welcome to Brent's Playlist", 
            "Playlist", JOptionPane.INFORMATION_MESSAGE);

        // Ask user how many songs to add
        String inputSong = JOptionPane.showInputDialog(null,
            "Input how many songs you would like to have:\n(Recommended: 10)", 
            "Brent", JOptionPane.QUESTION_MESSAGE);
        
        int numOfSongs;
        try {
            numOfSongs = Integer.parseInt(inputSong);
            if (numOfSongs <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number entered. Defaulting to 10.", "Error", JOptionPane.ERROR_MESSAGE);
            numOfSongs = 6; // Default value
        }

        String[] songs = new String[numOfSongs];
        int songCount = 0;

        // Loop for user actions
        boolean running = true;
        while (running) {
            // Ask user what to do 
            int choice = JOptionPane.showOptionDialog(null, 
                "What do you want to do?", 
                "Home", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, homeOptions, homeOptions[2]);

            // If-else statement for choices 
            switch (choice) {
                case 3: // Display current songs being played
                    displayCurrentPlaylist(songs, songCount);
                    break;
                case 2: // Add song
                    addSong(songs, songCount);
                    songCount++;
                    break;
                case 1: // Remove song
                    removeSong(songs, songCount);
                    songCount--;
                    break;
                case 0: // Exit
                    running = false;
                    break;
                default:
                    break;
            }
        }

        // Exit message
        JOptionPane.showMessageDialog(null, "Thank you for using Brent's Playlist Manager!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void displayCurrentPlaylist(String[] songs, int songCount) {
        if (songCount == 0) {
            JOptionPane.showMessageDialog(null, "Your playlist is empty.", "Playlist", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        StringBuilder currentSongs = new StringBuilder("Current Playlist:\n");
        for (int i = 0; i < songCount; i++) {
            currentSongs.append((i + 1)).append(". ").append(songs[i]).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, currentSongs.toString(), "Current Playlist", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void addSong(String[] songs, int songCount) {
        if (songCount >= songs.length) {
            JOptionPane.showMessageDialog(null, "Playlist is full! Cannot add more songs.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String newSong = JOptionPane.showInputDialog(null, 
            "Enter the name of the song you want to add:", 
            "Add Song", JOptionPane.QUESTION_MESSAGE);
        
        if (newSong != null && !newSong.trim().isEmpty()) {
            songs[songCount] = newSong;
            JOptionPane.showMessageDialog(null, newSong + " has been added to your playlist.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No song entered. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void removeSong(String[] songs, int songCount) {
        if (songCount == 0) {
            JOptionPane.showMessageDialog(null, "No songs in the playlist to remove.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String removeSong = JOptionPane.showInputDialog(null, 
            "Enter the name of the song you want to remove:", 
            "Remove Song", JOptionPane.QUESTION_MESSAGE);
        
        boolean found = false;
        
        for (int i = 0; i < songCount; i++) {
            if (songs[i].equalsIgnoreCase(removeSong)) {
                found = true;
                // Shift songs down in the array
                for (int j = i; j < songCount - 1; j++) {
                    songs[j] = songs[j + 1];
                }
                songs[songCount - 1] = null; // Clear last element
                break;
            }
        }
        
        if (found) {
            JOptionPane.showMessageDialog(null, removeSong + " has been removed from your playlist.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, removeSong + " not found in your playlist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}