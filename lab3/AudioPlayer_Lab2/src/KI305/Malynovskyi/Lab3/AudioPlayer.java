package KI305.Malynovskyi.Lab3;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * Абстрактний клас AudioPlayer — базова модель аудіоплеєра.
 */
public abstract class AudioPlayer {
    protected boolean isPlaying;
    protected int volume;
    protected PrintWriter log;

    public AudioPlayer() throws FileNotFoundException {
        log = new PrintWriter("Log3.txt");
        log("AudioPlayer created");
        volume = 50;
    }

    public abstract void play();
    public abstract void stop();

    public void setVolume(int value) {
        volume = Math.max(0, Math.min(100, value));
        log("Volume set to " + volume);
    }

    public void log(String msg) {
        log.println(LocalDateTime.now() + " :: " + msg);
        log.flush();
    }

    public void dispose() {
        log("Disposed");
        log.close();
    }
}
