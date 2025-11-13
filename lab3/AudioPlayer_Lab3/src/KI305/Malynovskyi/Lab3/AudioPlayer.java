package KI305.Malynovskyi.Lab3;

public abstract class AudioPlayer {
    protected int volume = 50;
    protected boolean isPlaying = false;

    public abstract void play();
    public abstract void stop();

    public void setVolume(int v) {
        volume = Math.max(0, Math.min(100, v));
        System.out.println("Volume: " + volume);
    }

    public int getVolume() {
        return volume;
    }
}
