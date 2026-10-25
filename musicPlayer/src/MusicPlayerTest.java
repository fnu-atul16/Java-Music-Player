public class MusicPlayerTest {
   public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();
        String[] ids = {"S1","S2","S3","S4","S5","S6"};
       String[] titles = {
               "Night Drive",
               "Slow Tide",
               "Copper Sky",
               "Static Bloom",
               "Low Orbit",
               "Glass Rivers"
       };
       String[] artists = {
               "Alex Carter",
               "Ethan Brooks",
               "James Wilson",
               "Oliver Reed",
               "Noah Bennett",
               "Liam Parker"
       };

       System.out.println("--- 1. Build the playlist ---");


       for(int i=0;i< ids.length;i++){
           System.out.println(musicPlayer.addSong(ids[i],titles[i],artists[i]));
       }
       System.out.println("duplicate s3: " + musicPlayer.addSong("S3", "Midnight Echoes", "Ryan Mitchell"));
       System.out.println("--- 2. Look up songs ---");

       Song song = musicPlayer.findSong("S4");
       System.out.println("find S4: " + song.getTitle());

       Song missingSong = musicPlayer.findSong("S9");
       System.out.println("find S9: " + missingSong);
       System.out.println("--- 3. Play and move forward ---");

       System.out.println("play S1: " + musicPlayer.play("S1").getTitle());

       Song invalidSong = musicPlayer.play("S9");
       System.out.println("play S9: " + invalidSong);

       System.out.println("next: " + musicPlayer.next().getTitle());
       System.out.println("next: " + musicPlayer.next().getTitle());

       System.out.println("history: " + musicPlayer.showHistory());
       System.out.println("--- 4. Up next ---");

       System.out.println(musicPlayer.queueLater("S5"));
       System.out.println(musicPlayer.queueLater("S6"));
       System.out.println(musicPlayer.queueNext("S1"));

       System.out.println("queue S9: " + musicPlayer.queueNext("S9"));

       System.out.println("up next: " + musicPlayer.showUpNext());

       Song nextSong = musicPlayer.next();
       System.out.println("next: " + nextSong.getTitle());

       System.out.println("now playing: " + musicPlayer.nowPlaying().getTitle());

       System.out.println("history: " + musicPlayer.showHistory());
       System.out.println("--- 5. Back button ---");

       Song backSong = musicPlayer.back();
       System.out.println("back: " + backSong.getTitle());

       System.out.println("up next: " + musicPlayer.showUpNext());

       System.out.println("history: " + musicPlayer.showHistory());
       System.out.println("--- 6. Remove songs ---");

       System.out.println("remove S5: " + musicPlayer.removeSong("S5"));

       System.out.println("remove current (S3): " + musicPlayer.removeSong("S3"));

       System.out.println("remove S9: " + musicPlayer.removeSong("S9"));

       System.out.println("playlist: " + musicPlayer.showPlaylist());

       System.out.println("up next: " + musicPlayer.showUpNext());
       System.out.println("--- 7. Removed songs are skipped ---");

       System.out.println("next: " + musicPlayer.next().getTitle());

       System.out.println("next: " + musicPlayer.next().getTitle());

       Song endSong = musicPlayer.next();
       System.out.println("next at end: " + endSong);

       System.out.println("now playing: " + musicPlayer.nowPlaying().getTitle());

       System.out.println("back: " + musicPlayer.back().getTitle());

       System.out.println("up next: " + musicPlayer.showUpNext());
       System.out.println("--- 8. Play counts ---");

       System.out.println("S1: " + musicPlayer.playCount("S1"));
       System.out.println("S3: " + musicPlayer.playCount("S3"));
       System.out.println("S6: " + musicPlayer.playCount("S6"));
       System.out.println("S5 (removed): " + musicPlayer.playCount("S5"));
       System.out.println("--- 9. Empty player ---");

       MusicPlayer emptyPlayer = new MusicPlayer();

       System.out.println("next: " + emptyPlayer.next());
       System.out.println("back: " + emptyPlayer.back());
       System.out.println("now playing: " + emptyPlayer.nowPlaying());
       System.out.println("playlist: " + emptyPlayer.showPlaylist());
    }
}
