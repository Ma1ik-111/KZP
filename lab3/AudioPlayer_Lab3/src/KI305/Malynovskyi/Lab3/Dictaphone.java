package KI305.Malynovskyi.Lab3;

public class Dictaphone extends AudioPlayer implements Recordable {

    private boolean recording = false;
    private int recordedTime = 0;

    @Override
    public void play() {
        writeLog("Dictaphone: play()");

        if (recordedTime == 0) {
            System.out.println("No recordings!");
            return;
        }
        System.out.println("Playing dictaphone recording... (" + recordedTime + "s)");
    }

    @Override
    public void stop() {
        isPlaying = false;
        writeLog("Dictaphone: stop()");
        System.out.println(" Playback stopped.");
    }

    @Override
    public void startRecording() {
        writeLog("Dictaphone: startRecording()");
        recording = true;
        recordedTime = 0;
        System.out.println(" Recording started...");
    }

    @Override
    public void stopRecording() {
        writeLog("Dictaphone: stopRecording()");
        recording = false;
        recordedTime = (int)(Math.random() * 180);
        System.out.println(" Recording saved (" + recordedTime + " sec).");
    }

    @Override
    public int getRecordedSeconds() {
        return recordedTime;
    }
}
