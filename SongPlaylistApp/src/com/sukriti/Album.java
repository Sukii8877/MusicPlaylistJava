package com.sukriti;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<song>();
    }
    public Album(){

    }
    public song findsong(String title){
        for(song checkedsong:songs){
            if(checkedsong.getTitle().equals(title))
                return checkedsong;
        }
        return null;
    }
    public boolean addsong(String title,double duration){
        if(findsong(title)==null){
            songs.add(new song(title,duration));
           //System.out.println(title+"successfully added to the list");
            return true;
        }
        else{
           // System.out.println("song with  name" +title+ "already exists");
           return false;
        }
    }
    public boolean addToPlayList(int trackNumber, LinkedList<song>PlayList){
        int index=trackNumber-1;
        if(index>0 && index<=this.songs.size()){
            PlayList.add(this.songs.get(index));
            return true;
        }
       // System.out.println("this album doesn't have song with track"+trackNumber);
        return false;
    }
    public boolean addToPlayList(String title,LinkedList<song>Playlist){
        for(song checkedsong:this.songs){
            if(checkedsong.getTitle().equals(title)){
                Playlist.add(checkedsong);
                return true;
            }
        }
        //System.out.println(title+"not found");
        return false;
    }
}
