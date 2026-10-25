import java.util.ArrayList;

public class DoublyLinkedList {

    public static class Node{
        private Song song;
        private Node prev;
        private Node next;

        public Node(Song song){
            this.song = song;
        }

        public void setPrev(Node prev){
            this.prev = prev;
        }
        public void setNext(Node next){
            this.next = next;
        }
        public Node getPrev(){
            return prev;
        }
        public Node getNext(){
            return next;
        }

        public Song getSong(){
            return song;
        }

    }

    private Node head;
    private Node tail;
    private int size;

    public void addLast(Song song){
        if(size == 0){
            tail = new Node(song);
            head = tail;

            size++;

        }
        else{
            Node n = new Node(song);
           tail.setNext(n);
           n.setPrev(tail);
           tail = n;
           size++;


        }

    }
    public Song getFirst(){
        if(size!=0) {
            return head.getSong();
        }
        return null;
    }
    public Song getLast(){
        if(size!=0) {
            return tail.getSong();
        }
        return null;
    }

    public ArrayList<String> showPlaylist(){
        ArrayList<String> plyList =  new ArrayList<>();
        Node temp = head;
        while(temp !=null){
             Song sng=temp.getSong();
             plyList.add(sng.getTitle());
            temp = temp.getNext();


        }
        return plyList;
    }

    public Song findNextSong(Song song){
        Node temp = head;
        while( temp!=null && temp.getSong() != song ){

            temp = temp.getNext();

        }
        if (temp == null || temp.getNext() == null) {
            return null;
        }
        return temp.getNext().getSong();
    }

    public void removeSong(Song song) {
        Node tempNode = head;

        while (tempNode != null) {
            if (tempNode.getSong() == song) {

                if (tempNode == head) {
                    head = head.getNext();

                    if (head != null) {
                        head.setPrev(null);
                    } else {
                        tail = null;
                    }
                }
                else if (tempNode == tail) {
                    tail = tail.getPrev();
                    tail.setNext(null);
                }
                else {
                    tempNode.getPrev().setNext(tempNode.getNext());
                    tempNode.getNext().setPrev(tempNode.getPrev());
                }

                size--;
                return;
            }

            tempNode = tempNode.getNext();
        }
    }


    }











