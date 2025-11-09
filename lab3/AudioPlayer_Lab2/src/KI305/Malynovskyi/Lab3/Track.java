package KI305.Malynovskyi.Lab2;

/**
 * Immutable value object for a track.
 */
public record Track(String title, String artist, int durationSec) {
    @Override
    public String toString() {
        return "Track{" + title + " - " + artist + ", " + durationSec + "s}";
    }
}
