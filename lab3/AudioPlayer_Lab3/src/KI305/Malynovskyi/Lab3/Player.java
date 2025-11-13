package KI305.Malynovskyi.Lab3;

public class Player extends AudioPlayer {

    @Override
    public void play() {
        isPlaying = true;
        System.out.println("▶️ Playing audio...");
    }

    @Override
    public void stop() {
        isPlaying = false;
        System.out.println("⏹️ Stopped.");
    }
}
