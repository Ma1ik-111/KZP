package KI305.Malynovskyi.Lab3;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public abstract class AudioPlayer {

    protected int volume = 50;
    protected boolean isPlaying = false;

    private FileWriter log;

    public AudioPlayer() {
        try {
            log = new FileWriter("Log.txt", true); // append mode
            writeLog("AudioPlayer created");
        } catch (IOException e) {
            System.out.println("Failed to open log file");
        }
    }

    protected void writeLog(String msg) {
        try {
            log.write(LocalDateTime.now() + " :: " + msg + "\n");
            log.flush();
        } catch (IOException e) {
            System.out.println("Log error");
        }
    }

    public abstract void play();
    public abstract void stop();

    public void setVolume(int v) {
        volume = Math.max(0, Math.min(100, v));
        writeLog("Volume set to " + volume);
        System.out.println("Volume: " + volume);
    }

    public void close() {
        try {
            writeLog("Session closed");
            log.close();
        } catch (Exception ignored) {}
    }
}
