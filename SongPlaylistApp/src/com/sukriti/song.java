package com.sukriti;

public class song {
    String title;
    double duration;

    public song(String title,double duration) {
        this.title= title;
        this.duration=duration;
    }
    public song(){

    }
    public String getTitle(){
        return title;
    }
    public double getDuration(){
        return duration;
    }

    @Override
    public String toString() {
        return "song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
