import java.util.*;

public class MusicPlayerDriver {
    public static ArrayList<Album> albums=new ArrayList<>();
    public static void main(String[] args) {
     Album album=new Album("album1","arjit");
     album.addSong("a",4.5);
        album.addSong("b",4.0);
        album.addSong("c",5.0);
        album.addSong("d",5.5);
        albums.add(album);
        album=new Album("album2","pav");
        album.addSong("e",4.0);
        album.addSong("f",5.0);
        album.addSong("g",5.5);
        albums.add(album);

        LinkedList<Song>playlist1 =new LinkedList<>();
        albums.get(0).addToPlaylist("a",playlist1);
        albums.get(0).addToPlaylist("b",playlist1);
       // albums.get(0).addToPlaylist("c",playlist1);
        albums.get(1).addToPlaylist("e",playlist1);
        albums.get(1).addToPlaylist("f",playlist1);

        play(playlist1);
    }
    private static void play(LinkedList<Song>playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forword = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("This playlist is empty");
        } else {
            System.out.println("Now playing : " + listIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = sc.nextInt();
              sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("playlist is completed");
                    quit = true;
                    break;
                case 1:
                    if (!forword) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forword = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing :" + listIterator.next().toString());
                    } else {
                        System.out.println("Reached to the end of the list");
                        forword = false;
                    }
                    break;
                case 2:
                    if (forword) {
                        if ((listIterator.hasPrevious())) {
                            listIterator.previous();
                        }
                        forword = false;

                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("now playing :" + listIterator.previous().toString());
                    } else {
                        System.out.println("we are at the first song");
                        forword = false;
                    }
                    break;
                case 3:
                    if (forword) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("now playing :" + listIterator.previous().toString());
                        } else {
                            System.out.println("we are at the start of the list");
                        }

                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("now playing :" + listIterator.next().toString());
                            forword = true;
                        } else {
                            System.out.println("we reached to end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing :" + listIterator.next().toString());

                        }
                        else {
                            if(listIterator.hasPrevious())
                            {
                                System.out.println("now playing :"+listIterator.previous().toString());
                            }
                        }
                    }
            }

        }
    }
    private static void printMenu()
    {
        System.out.println("Available options \n press");
        System.out.println("0 to quite \n " +
                "1-To play next song \n"+
                "2-To play Previous song \n"+
                "3-To replay the current song \n"+
                "4-To view list of all songs \n"+
                "5-print all available options \n"+
                "6-To delete the current song \n");

    }
    private static void printList(LinkedList<Song>playlist)
    {
        Iterator<Song> iterator=playlist.iterator();
        System.out.println("------------------------------");
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
        System.out.println("------------------------------");
    }

}
