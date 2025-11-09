/****************************************************************************
 * Copyright (c) 2025.
 * SPDX-License-Identifier: AFL-3.0
 ****************************************************************************/

package KI305.Malynovskyi.Lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Class <code>AudioPlayer</code> models a simple audio player device.
 * <p>
 * It contains several components (engine, playlist, speaker, storage)
 * and writes a protocol of operations to a log file.
 * </p>
 * @author Malynovskyi
 * @version 1.0
 */
public class AudioPlayer implements AutoCloseable {

    private final PlaybackEngine engine;
    private final Playlist playlist;
    private final Speaker speaker;
    private final Storage storage;
    private final PrintWriter fout;

    /**
     * Default constructor: creates empty playlist and default components.
     * @throws FileNotFoundException if log file cannot be created
     */
    public AudioPlayer() throws FileNotFoundException {
        this(new Playlist(), new Speaker(), new Storage("Internal", 1024));
    }

    /**
     * Constructor with components.
     * @param pl playlist
     * @param spk speaker
     * @param st storage
     * @throws FileNotFoundException if log file cannot be created
     */
    public AudioPlayer(Playlist pl, Speaker spk, Storage st) throws FileNotFoundException {
        this.engine = new PlaybackEngine();
        this.playlist = Objects.requireNonNull(pl);
        this.speaker = Objects.requireNonNull(spk);
        this.storage = Objects.requireNonNull(st);
        this.fout = new PrintWriter(new File("Log.txt"));
        log("AudioPlayer created");
    }

    /** Starts playback from current index. */
    public void play() {
        if (playlist.isEmpty()) {
            log("play() -> playlist is empty");
            return;
        }
        Track t = playlist.current();
        engine.play(t);
        log("play() -> " + t.title());
    }

    /** Pauses playback. */
    public void pause() {
        engine.pause();
        log("pause()");
    }

    /** Stops playback. */
    public void stop() {
        engine.stop();
        log("stop()");
    }

    /** Skips to the next track and starts playing it. */
    public void next() {
        if (playlist.isEmpty()) {
            log("next() -> playlist is empty");
            return;
        }
        Track t = playlist.next();
        engine.play(t);
        log("next() -> " + t.title());
    }

    /** Returns to the previous track and starts playing it. */
    public void prev() {
        if (playlist.isEmpty()) {
            log("prev() -> playlist is empty");
            return;
        }
        Track t = playlist.prev();
        engine.play(t);
        log("prev() -> " + t.title());
    }

    /**
     * Seeks to a position (in seconds) on the current track.
     * @param seconds position in seconds
     */
    public void seekTo(int seconds) {
        engine.seekTo(seconds);
        log("seekTo(" + seconds + "s)");
    }

    /**
     * Adds a track to the playlist.
     * @param t track to add
     */
    public void addTrack(Track t) {
        playlist.add(t);
        log("addTrack(" + t + ") size=" + playlist.size());
    }

    /**
     * Removes a track by index.
     * @param index index of track
     */
    public void removeTrack(int index) {
        Track removed = playlist.remove(index);
        log("removeTrack(index=" + index + ") -> " + removed);
    }

    /**
     * Sets volume [0..100].
     * @param value volume
     */
    public void setVolume(int value) {
        speaker.setVolume(value);
        log("setVolume(" + value + ")");
    }

    /** Mutes the speaker. */
    public void mute() {
        speaker.mute();
        log("mute()");
    }

    /** Unmutes the speaker. */
    public void unmute() {
        speaker.unmute();
        log("unmute()");
    }

    /** @return textual playback status */
    public String getStatus() {
        String s = "Status{state=" + engine.getState() + ", volume=" + speaker.getVolume()
                + ", muted=" + speaker.isMuted() + ", track=" + (playlist.isEmpty() ? "-" : playlist.current().title())
                + "}";
        log("getStatus() -> " + s);
        return s;
    }

    /** Writes a line into the log with timestamp and flushes. */
    private void log(String message) {
        fout.print(LocalDateTime.now() + " :: " + message + "\n");
        fout.flush();
    }

    /** Releases resources (log file). */
    public void dispose() {
        log("dispose()");
        fout.close();
    }

    /** AutoCloseable support for try-with-resources. */
    @Override
    public void close() {
        dispose();
    }
}
