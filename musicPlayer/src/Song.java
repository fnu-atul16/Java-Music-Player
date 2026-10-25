public class Song {
    private String id;
    private String title;
    private String artist;


    public Song(String id, String title,String artist){
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public String getTitle(){
        return title;
    }
    public String getId(){
        return id;
    }



}
