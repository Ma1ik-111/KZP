package KI305.Malynovskyi.Lab3;

public class Player extends AudioPlayer {

    @Override
    public void play() {
        isPlaying = true;
        writeLog("Player: play()");
        System.out.println("Playing audio...");
    }

    @Override
    public void stop() {
        isPlaying = false;
        writeLog("Player: stop()");
        System.out.println("Stopped.");
    }
}
