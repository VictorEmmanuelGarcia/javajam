package entity;

public class Playlist{
    private String songName;
    private String artistName;
    private int duration;
    
    public Playlist(){
    }

    public Playlist(String songName,String artistName,int duration){
        
        setSongName(songName); 
        setArtistName(artistName);
        setDuration(duration);        
    }
    
    public String getSongName(){
        return songName;
    }
    
    public String getArtistName(){
        return artistName;
    }
    
    public double getDuration(){
       return duration;
    }

    public void setSongName(String songName){
        this.songName = songName;
    }  
    
    public void setArtistName(String artistName){
        this.artistName = artistName;
    }
    public void setDuration(int duration){
        this.duration = duration;
    }
    
    //return as String
    @Override
    public String toString(){
        return "Song: " + songName + "\nArtist:" + artistName + "\nDuration: "+ duration +"\n";
    } 
}

