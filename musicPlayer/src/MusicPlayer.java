import java.util.ArrayList;
import java.util.HashMap;

public class MusicPlayer {
    private Song current;
    private  DoublyLinkedList playList;
    private HashMap<String,Song> library;
    private HashMap<String,Integer> playCount;
    private SongStack history;
    private SongDeque queue;

    public MusicPlayer(){
        playList = new DoublyLinkedList();
        library = new HashMap<>();
        playCount = new HashMap<>();
        history = new SongStack();
        queue = new SongDeque();
    }

    public boolean addSong(String id, String title, String artist){
        if(library.containsKey(id)){
            return false;
        }

            Song tempSong = new Song(id,title,artist);
            playList.addLast(tempSong);
            library.put(tempSong.getId(), tempSong);
            return true;

    }

    public Song findSong(String id){

        return library.get(id);
    }

    public ArrayList<String> showPlaylist(){

        return playList.showPlaylist();
    }

        public Song play(String id){
            Song currentSong =  findSong(id);
            if(currentSong !=null){
                if(current!=null) {
                    history.push(current);
                }
                current = currentSong;
            if(playCount.containsKey(id)) {
                int num = playCount.get(id);
                num++;
                playCount.put(id, num);
            }else{

                playCount.put(id,1);

            }
            }
            return currentSong;


        }

        public Song nowPlaying(){
        if(current!=null){
            return current;
        }
        return null;
        }


        public int playCount(String id){

            if(playCount.containsKey(id)) {
                int num = playCount.get(id);
                return num;
            }

            return 0;

        }

        public boolean queueNext(String id){
            Song song = findSong(id);
            if(song!=null) {
                queue.addFirst(song);
                return true;
            }
            return false;

        }

        public boolean queueLater(String id){
            Song song = findSong(id);
            if(song!=null) {
                queue.addLast(song);
                return true;
            }
            return false;
        }


        public ArrayList<String> showUpNext() {
            ArrayList<String> list = new ArrayList<>();

            ArrayList<Song> songList = queue.getSongslist();
            for (int i = 0; i < songList.size(); i++) {
                if (library.containsKey(songList.get(i).getId())) {
                    list.add(songList.get(i).getTitle());
                }
            }
            return  list;


        }

    public Song next() {
        Song tempSong = null;
        while (!queue.isEmpty()) {
            tempSong = queue.removeFirst();
            if (library.containsKey(tempSong.getId())) {
                break;
            } else {
                tempSong = null;

            }


        }
        if (tempSong == null) {
            if(current!=null) {
                tempSong = playList.findNextSong(current);
            }

        }

        if (tempSong != null) {
            if(current!=null) {
                history.push(current);
            }
            current = tempSong;
            int num =  playCount(tempSong.getId());
            num++;
            playCount.put(tempSong.getId(), num);
            return tempSong;

        }
        return null;

    }

    public Song back(){
        Song tempSong = null;
        while(!history.isEmpty()) {
            tempSong = history.pop();
            if (library.containsKey(tempSong.getId())) {
                break;
            } else{
                tempSong=null;
            }
        }
        if(tempSong!=null){
            if(current!=null) {
                queue.addFirst(current);
            }
            current = tempSong;
           int num  = playCount(tempSong.getId());
           num++;
           playCount.put(tempSong.getId(),num);

            return tempSong;
        }
        return null;


        }

        public ArrayList<String> showHistory(){

            ArrayList<String> titleList = new ArrayList<>();

            ArrayList<Song>  songList = history.getHistory();
            for (Song song : songList) {
                if (library.containsKey(song.getId())) {
                    titleList.add(song.getTitle());

                }
            }
            return titleList;





        }

    public boolean removeSong(String id) {
        Song song = library.get(id);

        if (song == null) {
            return false;
        }

        if (current == song) {
            return false;
        }

        playList.removeSong(song);
        library.remove(id);
        playCount.remove(id);

        return true;
    }



    }

        


















