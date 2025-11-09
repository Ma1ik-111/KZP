package KI305.Malynovskyi.Lab2;

/**
 * Class <code>PlaybackEngine</code> simulates playback state machine.
 */
class PlaybackEngine {

    enum State { STOPPED, PLAYING, PAUSED }

    private State state = State.STOPPED;
    private Track current;
    private int positionSec = 0;

    public void play(Track t) {
        current = t;
        positionSec = 0;
        state = State.PLAYING;
    }

    public void pause() {
        if (state == State.PLAYING) state = State.PAUSED;
    }

    public void stop() {
        state = State.STOPPED;
        positionSec = 0;
    }

    public void seekTo(int seconds) {
        if (seconds < 0) seconds = 0;
        positionSec = seconds;
    }

    public State getState() {
        return state;
    }

    public Track getCurrent() { return current; }

    public int getPositionSec() { return positionSec; }
}
