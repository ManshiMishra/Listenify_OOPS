package listenify;

import java.util.*;

public class Main {
    public static List<Album>albums=new ArrayList<>();
    public static void main(String[] args) {
    Album album=new Album("rockstar","arijit singh");
    album.addSongInAlbum("tum ho",4.7);
    album.addSongInAlbum("kun faya kun",5);
    album.addSongInAlbum("rock on",4.3);
    albums.add(album);

    album=new Album("oldIsGold","udit narayan");
    album.addSongInAlbum("mohabbatain",7);
    album.addSongInAlbum("dhadkan",5.5);
    album.addSongInAlbum("andekhi anjani",6);
    albums.add(album);

    LinkedList<Song>playListMain=new LinkedList<>();
    albums.get(0).addSongToPlayList("tum ho",playListMain);
    albums.get(0).addSongToPlayList("kun faya kun",playListMain);
    albums.get(1).addSongToPlayList("mohabbatain",playListMain);
    albums.get(1).addSongToPlayList("andekhi anjani",playListMain);


    play(playListMain);
    }
    public static void play(LinkedList<Song>playList){
        ListIterator<Song>listIterator=playList.listIterator();
        Scanner sc=new Scanner(System.in);
        if(playList.size()==0) return;
        printMenu();
        System.out.println("Now playing"+listIterator.next());
        boolean forward=true;
        boolean quit=false;
        while(quit==false){
            int choice=sc.nextInt();
            switch (choice){
                case 0:  //quit
                    quit=true;
                    break;
                case 1:  //next
                    if(forward==false){
                        listIterator.next();
                        forward=true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println(listIterator.next().toString());
                    }else {
                        System.out.println("You are at the last song");
                    }
                    break;
                case 2:  //previous
                    if(forward==true){
                        listIterator.previous();
                        forward=false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println(listIterator.previous().toString());
                    }else {
                        System.out.println("You are already at first song");
                    }
                    break;
                case 3://replay
                    if(forward==true){
                        System.out.println(listIterator.previous().toString());
                        forward=false;
                    }
                    else{
                        System.out.println(listIterator.next().toString());
                        forward=true;
                    }
                    break;

                case 4://print all available songs in playlist
                    printAllSongs(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6: //delete song

                    break;
            }
        }
    }
    private static void printAllSongs(LinkedList<Song>songs){
        for(Song song: songs){
            System.out.println(song);
        }
    }
    public static void printMenu(){
        System.out.println("Available option \n press");
        System.out.println("0- quit application \n"+
               "1- play next song \n"+
                "2- play previous song \n"+
                "3- replay new song \n"+
                "4- list of all songs \n"+
                "5- print available songs \n"+
                "6- delete song");
    }
}