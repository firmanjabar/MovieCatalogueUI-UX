package com.firmanjabar.submission2;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String title;
    private String year;
    private String description;
    private String director;
    private String actor;
    private int imgPoster, imgActor;
    private int imgBD;

    public Movie() {
    }

    public Movie(String title, String year, String description, String director, String actor, int imgPoster, int imgActor, int imgBD) {
        this.title = title;
        this.year = year;
        this.description = description;
        this.director = director;
        this.actor = actor;
        this.imgPoster = imgPoster;
        this.imgActor = imgActor;
        this.imgBD = imgBD;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public int getImgPoster() {
        return imgPoster;
    }

    public void setImgPoster(int imgPoster) {
        this.imgPoster = imgPoster;
    }

    public int getImgActor() {
        return imgActor;
    }

    public void setImgActor(int imgActor) {
        this.imgActor = imgActor;
    }

    public int getImgBD () {
        return imgBD;
    }

    public void setImgBD ( int imgBD ) {
        this.imgBD = imgBD;
    }


    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel ( Parcel dest, int flags ) {
        dest.writeString(this.title);
        dest.writeString(this.year);
        dest.writeString(this.description);
        dest.writeString(this.director);
        dest.writeString(this.actor);
        dest.writeInt(this.imgPoster);
        dest.writeInt(this.imgActor);
        dest.writeInt(this.imgBD);
    }

    protected Movie ( Parcel in ) {
        this.title = in.readString();
        this.year = in.readString();
        this.description = in.readString();
        this.director = in.readString();
        this.actor = in.readString();
        this.imgPoster = in.readInt();
        this.imgActor = in.readInt();
        this.imgBD = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel ( Parcel source ) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray ( int size ) {
            return new Movie[size];
        }
    };
}
