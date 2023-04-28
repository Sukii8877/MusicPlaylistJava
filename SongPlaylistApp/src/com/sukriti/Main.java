package com.sukriti;

import java.util.*;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Album1", "AG/DC");
        album.addsong("TNT", 4.5);
        album.addsong("Highway to Hell", 3.5);
        album.addsong("abc", 5.0);
        albums.add(album);
        album = new Album("Album2", "Eminem");
        album.addsong("Rap God", 4.5);
        album.addsong("Not Afraid", 3.5);
        album.addsong("Lose Yourself", 4.5);

        albums.add(album);


        LinkedList<song> playList_1 = new LinkedList<>();
        albums.get(0).addToPlayList("TNT", playList_1);
        albums.get(0).addToPlayList("Highway to hell", playList_1);
        albums.get(1).addToPlayList("Rap God", playList_1);
        albums.get(1).addToPlayList("Lose Yourself", playList_1);

        play(playList_1);
    }

    private static void play(LinkedList<song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<song> ListIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("this playlist have no song");
        } else {
            System.out.println("Now Playing" + ListIterator.next().toString());
            printMenu();
        }
        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();
            switch (action) {
                case 0:
                    System.out.println("PlayList Complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (ListIterator.hasNext()) {
                            ListIterator.next();
                        }
                        forward = true;
                    }
                    if (ListIterator.hasNext()) {
                        System.out.println("Now Playing" + ListIterator.next().toString());


                    }
            else{
                        System.out.println("no song available, reached to the end of list");
                  forward =false;

            }
            break;
                case 2:
                    if(forward){
                        if(ListIterator.hasPrevious()){
                            ListIterator.previous();
                        }
                        forward=false;
                    }
                    if(ListIterator.hasPrevious()){
                        System.out.println("now playing"+ListIterator.previous().toString());
                    }
                    else{
                        System.out.println("we are at the first song");
                        forward=false;
                    }
                    break;
                case 3:
                    if(forward){
                        if(ListIterator.hasPrevious()){
                            System.out.println("Now Playing"+ListIterator.previous().toString());
                            forward=false;
                        }
                        else{
                            System.out.println("we are at the start of the list");
                        }
                    }
                    else{
                        if(ListIterator.hasNext()){
                            System.out.println("now Playing"+ListIterator.next().toString());
                            forward=true;
                        }
                        else{
                            System.out.println("we have reached to end of list");
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
                    if(playList.size()>0){
                        ListIterator.remove();
                        if(ListIterator.hasNext()){
                            System.out.println("Now playing"+ListIterator.next().toString());

                        }
                        else{
                            if(ListIterator.hasPrevious())
                            System.out.println("Now PLaying"+ListIterator.previous().toString());
                        }
                    }
            }
            }
        }
        private static void printMenu () {
            System.out.println("Available options\n press");
            System.out.println("0- to quit\n" +
                    "1- to play next song\n" +
                    "2- to play previous song\n" +
                    "3- to replay\n" +
                    "4- list of all songs\n" +
                    "5-print all available options\n" +
                    "6-delete current song");
        }
        private static void printList (LinkedList < song > playList) {
            Iterator<song> iterator = playList.iterator();
            System.out.println("---------------------");
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
            System.out.println("---------------------");


        }
    }

