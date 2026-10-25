import java.util.ArrayList;

public class SongDeque {
    public static class Node {
        private Song song;
        private Node next;
        private Node prev;


        public Node(Song song){
            this.song = song;
        }

        public void setNext(Node next){
            this.next = next;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }

        public Node getNext(){
            return next;
        }

        public Node getPrev(){
            return prev;
        }

        public Song getSong(){
            return song;
        }


    }

    private Node front;
    private Node rear;
    private int size;



    public void addFirst(Song song){
        Node n = new Node(song);

        if(size == 0){
            front = n;
            rear = front;
            size++;

        }
        else{

          n.setNext(front);
          front.setPrev(n);

          front = n;

          size++;

        }

    }

    public void addLast(Song song){
        Node n = new Node(song);
        if(size == 0){
            front = n;
            rear = front;
            size++;

        }
        else{
            n.setPrev(rear);
            rear.setNext(n);
            rear = n;
            size++;
        }

    }

    public Song removeFirst(){
        if(size!=0) {
            Song song = front.getSong();
            front = front.getNext();
            if(front!=null) {
                front.setPrev(null);

            }
            else{
                rear = null;

            }
            size--;
            return song;

        }
        return null;
    }

    public Song removeLast(){
        if(size!=0){

            Song song = rear.getSong();
            rear = rear.getPrev();
            if(rear!=null){
                rear.setNext(null);
            }
            else{
                front = null;

            }
            size--;
            return song;

        }
        else{
            return null;
        }

    }

    public boolean isEmpty(){
        return size == 0;
    }

        public ArrayList<Song> getSongslist(){
            ArrayList<Song> songList = new ArrayList<Song>();
            Node temp = front;
            while(temp!=null) {
                Song song = temp.getSong();
                songList.add(song);
                temp = temp.getNext();
            }
            return songList;
        }





}
