import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String name;
    String artist;

    ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public Album() {
    }

    public boolean addSong(String title , double duration)
    {
        if (findSong(title)==null)
        {
            songs.add(new Song(title,duration));
            return true;
        }
        else {
            return false;
        }
    }

    private Song findSong(String title) {
        for(Song checkSong:songs)
        {
            if(checkSong.getTitle().equals(title))
                    return checkSong;
        }
        return null;
    }

    public boolean addToPlaylist(int trackNumber , LinkedList<Song> playLists)
    {
     int index=trackNumber-1;
     if(index>0&&index<=this.songs.size())
     {
       playLists.add(this.songs.get(index));
       return true;
     }
     return false;
    }

    public boolean addToPlaylist(String title ,LinkedList<Song> playLists )
    {
        for(Song checkedsong:this.songs)
        {
            if(checkedsong.getTitle().equals(title))
            {
                playLists.add(checkedsong);
                return true;
            }
        }
        return false;
    }
}
