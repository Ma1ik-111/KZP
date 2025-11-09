package KI305.Malynovskyi.Lab3;

/**
 * Демонстрація роботи спадкування та інтерфейсів.
 */
public class AudioPlayerApp {
    public static void main(String[] args) throws Exception {
        AudioPlayer player = new Dictaphone(); // поліморфізм
        player.setVolume(70);

        if (player instanceof Recordable rec) {
            rec.startRecording();
            Thread.sleep(1000);
            rec.stopRecording();
            System.out.println("Recorded: " + rec.getRecordedSeconds() + " seconds");
        }

        player.play();
        player.stop();
        player.dispose();
    }
}
