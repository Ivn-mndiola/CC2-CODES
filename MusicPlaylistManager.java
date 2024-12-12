import javax.swing.JOptionPane;

public class MusicPlaylistManager {
    // Node for Circular Doubly Linked List
    static class SongNode {
        String song;
        SongNode next;
        SongNode prev;

        SongNode(String song) {
            this.song = song;
            this.next = this;
            this.prev = this;
        }
    }

    private static SongNode currentSong = null;

    public static void main(String[] args) {
        // Menu options
        String[] homeOptions = { "Exit", "Remove Song", "Add Song", "Display Current Playlist", "Next Song", "Previous Song" };

        JOptionPane.showMessageDialog(null, 
            "Welcome to Ivan's Playlist", 
            "Playlist", JOptionPane.INFORMATION_MESSAGE);

        boolean running = true;
        while (running) {
            int choice = JOptionPane.showOptionDialog(null, 
                "What do you want to do?", 
                "Home", JOptionPane.DEFAULT_OPTION, 
                JOptionPane.PLAIN_MESSAGE, 
                null, homeOptions, homeOptions[2]);

            switch (choice) {
                case 4: // Next song
                    nextSong();
                    break;
                case 5: // Previous song
                    previousSong();
                    break;
                case 3: // Display playlist
                    displayCurrentPlaylist();
                    break;
                case 2: // Add song
                    addSong();
                    break;
                case 1: // Remove song
                    removeSong();
                    break;
                case 0: // Exit
                    running = false;
                    break;
                default:
                    break;
            }
        }

        JOptionPane.showMessageDialog(null, "Thank you for using Ivan's Playlist Manager!", "Goodbye", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void addSong() {
        String newSong = JOptionPane.showInputDialog(null, 
            "Enter the name of the song you want to add:", 
            "Add Song", JOptionPane.QUESTION_MESSAGE);

        if (newSong != null && !newSong.trim().isEmpty()) {
            SongNode newNode = new SongNode(newSong);

            if (currentSong == null) {
                currentSong = newNode;
            } else {
                SongNode tail = currentSong.prev;
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = currentSong;
                currentSong.prev = newNode;
            }

            JOptionPane.showMessageDialog(null, newSong + " has been added to your playlist.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No song entered. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void removeSong() {
        if (currentSong == null) {
            JOptionPane.showMessageDialog(null, "No songs in the playlist to remove.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String removeSong = JOptionPane.showInputDialog(null, 
            "Enter the name of the song you want to remove:", 
            "Remove Song", JOptionPane.QUESTION_MESSAGE);

        if (removeSong == null || removeSong.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "No song entered. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SongNode temp = currentSong;
        boolean found = false;
        do {
            if (temp.song.equalsIgnoreCase(removeSong)) {
                found = true;
                if (temp.next == temp) { // Only one song in the playlist
                    currentSong = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                    if (temp == currentSong) {
                        currentSong = temp.next;
                    }
                }
                break;
            }
            temp = temp.next;
        } while (temp != currentSong);

        if (found) {
            JOptionPane.showMessageDialog(null, removeSong + " has been removed from your playlist.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, removeSong + " not found in your playlist.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void displayCurrentPlaylist() {
        if (currentSong == null) {
            JOptionPane.showMessageDialog(null, "Your playlist is empty.", "Playlist", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder playlist = new StringBuilder("Current Playlist:\n");
        SongNode temp = currentSong;
        do {
            playlist.append("- ").append(temp.song).append(temp == currentSong ? " (Current)" : "").append("\n");
            temp = temp.next;
        } while (temp != currentSong);

        JOptionPane.showMessageDialog(null, playlist.toString(), "Current Playlist", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void nextSong() {
        if (currentSong == null) {
            JOptionPane.showMessageDialog(null, "Your playlist is empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        currentSong = currentSong.next;
        JOptionPane.showMessageDialog(null, "Now playing: " + currentSong.song, "Next Song", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void previousSong() {
        if (currentSong == null) {
            JOptionPane.showMessageDialog(null, "Your playlist is empty.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        currentSong = currentSong.prev;
        JOptionPane.showMessageDialog(null, "Now playing: " + currentSong.song, "Previous Song", JOptionPane.INFORMATION_MESSAGE);
    }
}
