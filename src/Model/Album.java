package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Album implements Serializable {
    private String nameAlbum;
    private Date dateCreated;
    private ArrayList<Song> listSong = new ArrayList<>();

    public Album() {
    }

    public Album(String nameAlbum) {
        this.nameAlbum = nameAlbum;
        dateCreated = new Date();
    }

    public String getNameAlbum() {
        return nameAlbum;
    }

    public void setNameAlbum(String nameAlbum) {
        this.nameAlbum = nameAlbum;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date date) {
        dateCreated = date;
    }

    public ArrayList<Song> getListSong() {
        return listSong;
    }

    public void setListSong(ArrayList<Song> listSong) {
        this.listSong = listSong;
    }

    @Override
    public String toString() {
        return "Album  [ Name Album = " + nameAlbum
                + " || Date Created = " + dateCreated + " ]";
    }
}
