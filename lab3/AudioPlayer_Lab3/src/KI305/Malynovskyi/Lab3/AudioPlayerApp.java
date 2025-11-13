package KI305.Malynovskyi.Lab3;

import java.util.Scanner;

public class AudioPlayerApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1 - Audio Player (Lab2)");
            System.out.println("2 - Dictaphone (Lab3)");
            System.out.println("0 - Exit");
            System.out.print("Choice: ");
            while (!sc.hasNextInt()) {
                System.out.print("Enter number: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> runAudioPlayer(sc);
                case 2 -> runDictaphone(sc);   
            }

        } while (choice != 0);

        sc.close();
        System.out.println("Bye!");
    }

    private static void runAudioPlayer(Scanner sc) {
        Player player = new Player();
        int c;

        do {
            System.out.println("\n=== AUDIO PLAYER ===");
            System.out.println("1 - Play");
            System.out.println("2 - Stop");
            System.out.println("3 - Volume");
            System.out.println("0 - Back");
            System.out.print("Choice: ");
            while (!sc.hasNextInt()) {
                System.out.print("Enter number: ");
                sc.next();
            }
            c = sc.nextInt();

            switch (c) {
                case 1 -> player.play();
                case 2 -> player.stop();
                case 3 -> {
                    System.out.print("Volume: ");
                    int v = sc.nextInt();
                    player.setVolume(v);
                }
            }
        } while (c != 0);

        player.close(); 
    }

 
    private static void runDictaphone(Scanner sc) {
        
        AudioPlayer device = new Dictaphone();   
        Recordable rec = (Recordable) device;    

        int c;
        do {
            System.out.println("\n=== DICTAPHONE ===");
            System.out.println("1 - Start recording");
            System.out.println("2 - Stop recording");
            System.out.println("3 - Playback");
            System.out.println("4 - Info");
            System.out.println("0 - Back");
            System.out.print("Choice: ");
            while (!sc.hasNextInt()) {
                System.out.print("Enter number: ");
                sc.next();
            }
            c = sc.nextInt();

            switch (c) {
                case 1 -> rec.startRecording();
                case 2 -> rec.stopRecording();
                case 3 -> device.play(); 
                case 4 -> System.out.println("Recorded: " + rec.getRecordedSeconds() + " sec");
            }
        } while (c != 0);

        device.stop();
        device.close(); 
    }
}
