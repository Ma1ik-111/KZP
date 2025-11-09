package KI305.Malynovskyi.Lab3;

import java.io.FileNotFoundException;

/**
 * Клас Dictaphone — розширює AudioPlayer та реалізує Recordable.
 */
public class Dictaphone extends AudioPlayer implements Recordable {
    private boolean recording;
    private int recordedTime;

    public Dictaphone() throws FileNotFoundException {
        super();
        recording = false;
        recordedTime = 0;
        log("Dictaphone created");
    }

    @Override
    public void play() {
        isPlaying = true;
        log("Playback started");
        System.out.println("Playing recorded message...");
    }

    @Override
    public void stop() {
        isPlaying = false;
        log("Playback stopped");
        System.out.println(" Stopped.");
    }

    @Override
    public void startRecording() {
        recording = true;
        recordedTime = 0;
        log("Recording started");
        System.out.println("Recording started...");
    }

    @Override
    public void stopRecording() {
        recording = false;
        recordedTime = (int)(Math.random() * 300); // симуляція часу
        log("Recording stopped. Duration: " + recordedTime + "s");
        System.out.println(" Recording stopped (" + recordedTime + " s).");
    }

    @Override
    public int getRecordedSeconds() {
        return recordedTime;
    }
}
