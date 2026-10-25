import java.util.ArrayList;

public class SongStack {

    public static class Node{
        private Song song;
        private Node ref;


        public Node(Song song){
            this.song = song;

        }

        public void setRef(Node ref){

            this.ref = ref;
        }
        public Node getRef(){
            return ref;
        }
        public Song getSong(){
            return song;
        }

    }

    private Node top;
    private int size;


    public void push(Song song){
        Node n = new Node(song);
        n.setRef(top);
        top = n;
        size++;
    }

    public Song pop(){
        if(size == 0){
            return null;
        }
        Song sng = top.getSong();
        top = top.getRef();
        size--;

        return sng;

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public ArrayList<Song> getHistory(){
        ArrayList<Song> history = new ArrayList<>();
        Node tempNode = top;
        while(tempNode!=null){
            Song tempSong = tempNode.getSong();
            history.add(tempSong);
            tempNode = tempNode.getRef();

        }
        return history;
    }

}
