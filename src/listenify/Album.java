package listenify;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    public String albumName;
    public String artistName;
    public List<Song>songList;

    public Album(String albumName, String artistName) {
        this.albumName = albumName;
        this.artistName = artistName;
        this.songList=new ArrayList<>();
    }
    public boolean findSongInAlbum(String title){
        for(Song song:songList){
            if((song.title).equals(title)){
                return true;
            }
        }
        return false;
    }
    public String addSongInAlbum(String title,double duration){
        if(findSongInAlbum(title)==true){
            return "Song is already added!";
        }else{
            Song newSong=new Song(title,duration);
            songList.add(newSong);
            return "Song is added in the Album";
        }

    }
    public String addSongToPlayList(int trackNumber, LinkedList<Song>playList){
        //track no. will be 1,2,3,..and so on
        //but idx start with 0,1,2,3....
        int idx=trackNumber-1;
        if(idx>=0 && idx< songList.size()){
            Song song=this.songList.get(idx);
            playList.add(song);
            return "Song is added in the playlist";
        }
        return "Invalid track number";
    }
    //Adding song with the help of title
    public  String addSongToPlayList(String title,LinkedList<Song>playList){
        for(Song song : songList){
            if(song.title==title){
                playList.add(song);
                return "Song is added to playList";
            }
        }
        return "Song doesn't exist";
    }

}

