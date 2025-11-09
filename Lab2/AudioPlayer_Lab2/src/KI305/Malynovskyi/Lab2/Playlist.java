package KI305.Malynovskyi.Lab2;

import java.util.ArrayList;
import java.util.List;

/**
 * Class <code>Playlist</code> stores tracks and a cursor.
 */
class Playlist {
    private final List<Track> tracks = new ArrayList<>();
    private int index = 0;

    public void add(Track t) {
        tracks.add(t);
        if (tracks.size() == 1) index = 0;
    }

    public Track remove(int i) throws IndexOutOfBoundsException {
        Track r = tracks.remove(i);
        if (index >= tracks.size()) index = Math.max(0, tracks.size() - 1);
        return r;
    }

    public boolean isEmpty() { return tracks.isEmpty(); }

    public int size() { return tracks.size(); }

    public Track current() { return tracks.get(index); }

    public Track next() {
        if (tracks.isEmpty()) return null;
        index = (index + 1) % tracks.size();
        return tracks.get(index);
    }

    public Track prev() {
        if (tracks.isEmpty()) return null;
        index = (index - 1 + tracks.size()) % tracks.size();
        return tracks.get(index);
    }
}
