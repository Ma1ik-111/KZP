package KI305.Malynovskyi.Lab2;

/**
 * Class <code>Speaker</code> controls volume and mute state.
 */
class Speaker {
    private int volume = 50;
    private boolean muted = false;

    public void setVolume(int v) {
        if (v < 0) v = 0;
        if (v > 100) v = 100;
        this.volume = v;
    }

    public void mute() { muted = true; }
    public void unmute() { muted = false; }

    public int getVolume() { return volume; }

    public boolean isMuted() { return muted; }
}
