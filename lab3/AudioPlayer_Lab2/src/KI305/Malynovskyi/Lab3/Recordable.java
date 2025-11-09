package KI305.Malynovskyi.Lab3;

/**
 * Інтерфейс Recordable визначає функції запису звуку.
 */
public interface Recordable {
    void startRecording();
    void stopRecording();
    int getRecordedSeconds();
}
