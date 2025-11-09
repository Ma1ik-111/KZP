package KI305.Malynovskyi.Lab2;

import static java.lang.System.out;
import java.util.Scanner;

/**
 * Клас-драйвер AudioPlayerApp з інтерактивним меню та 3 попередньо доданими треками.
 */
public class AudioPlayerApp {
    public static void main(String[] args) throws Exception {
        try (AudioPlayer player = new AudioPlayer()) {

            // === Додаємо 3 пісні автоматично ===
            player.addTrack(new Track("Neon Samurai", "JJ SHOP", 210));
            player.addTrack(new Track("Midnight Drive", "SynthFox", 185));
            player.addTrack(new Track("Cyber Mirage", "OrionDeMirage", 240));
            out.println("🎵 Added 3 demo tracks to playlist.\n");

            Scanner sc = new Scanner(System.in);
            int choice;

            do {
                out.println("\n=== AUDIO PLAYER MENU ===");
                out.println("1 - Add track");
                out.println("2 - Play");
                out.println("3 - Pause");
                out.println("4 - Stop");
                out.println("5 - Next track");
                out.println("6 - Previous track");
                out.println("7 - Set volume");
                out.println("8 - Mute / Unmute");
                out.println("9 - Show status");
                out.println("0 - Exit");
                out.println("==========================");
                out.print("Enter choice: ");

                while (!sc.hasNextInt()) {
                    out.print("Enter number: ");
                    sc.next();
                }
                choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        sc.nextLine(); // очистити буфер
                        out.print("Enter track title: ");
                        String title = sc.nextLine();
                        out.print("Enter artist: ");
                        String artist = sc.nextLine();
                        out.print("Enter duration (sec): ");
                        int dur = sc.nextInt();
                        player.addTrack(new Track(title, artist, dur));
                        out.println("✅ Track added.");
                    }
                    case 2 -> {
                        player.play();
                        out.println("▶️  Playing current track...");
                        out.println(player.getStatus());
                    }
                    case 3 -> {
                        player.pause();
                        out.println("⏸️  Paused.");
                        out.println(player.getStatus());
                    }
                    case 4 -> {
                        player.stop();
                        out.println("⏹️  Stopped.");
                        out.println(player.getStatus());
                    }
                    case 5 -> {
                        player.next();
                        out.println("⏭️  Next track...");
                        out.println(player.getStatus());
                    }
                    case 6 -> {
                        player.prev();
                        out.println("⏮️  Previous track...");
                        out.println(player.getStatus());
                    }
                    case 7 -> {
                        out.print("Volume (0-100): ");
                        int v = sc.nextInt();
                        player.setVolume(v);
                        out.println("🔊 Volume set to " + v + "%");
                        out.println(player.getStatus());
                    }
                    case 8 -> {
                        out.print("Mute (1) / Unmute (0): ");
                        int m = sc.nextInt();
                        if (m == 1) {
                            player.mute();
                            out.println("🔇 Muted");
                        } else {
                            player.unmute();
                            out.println("🔊 Unmuted");
                        }
                        out.println(player.getStatus());
                    }
                    case 9 -> out.println(player.getStatus());
                    case 0 -> out.println("👋 Exiting player...");
                    default -> out.println("Unknown command.");
                }
            } while (choice != 0);
        }
    }
}
