package Model;

import java.io.Serializable;

public class Song implements Serializable {
    private String nameSong;
    private String author;

    public Song() {
    }

    public Song(String nameSong, String author) {
        this.nameSong = nameSong;
        this.author = author;
    }


    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Song  [ Name Song = " + nameSong + " || Author = " + author + " ]";
    }
}
