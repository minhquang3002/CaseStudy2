package Manager;

import Model.Album;
import Model.Song;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerSong {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Album> list = ManagerAlbum.readFile();
    ArrayList<Song> listSong = new ArrayList<>();

    public ManagerSong() throws IOException, ClassNotFoundException {
    }

    public Song createSong() {
        System.out.println("Enter Song Name");
        String nameSong = scanner.nextLine();
        System.out.println("Enter Author");
        String author = scanner.nextLine();
        return new Song(nameSong, author);
    }

    public void addSong() throws IOException {
        System.out.println("Enter album name");
        String nameAlbum = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNameAlbum().equals(nameAlbum)) {
                listSong = list.get(i).getListSong();
                Song song = createSong();
                if (!checkNameSong(song.getNameSong())){
                    listSong.add(song);
                    ManagerAlbum.writeFile(list);
                    System.out.println("Create successful");
                }
            }
        }
    }

    public void showSong() {
        System.out.println("Enter album name");
        String nameAlbum = scanner.nextLine();
        for (Album album : list) {
            if (album.getNameAlbum().equals(nameAlbum)) {
                listSong = album.getListSong();
                for (Song song : listSong) {
                    System.out.println(song);
                }
            }
        }
    }

    public void editSong() throws IOException {
        int countAlbum = 0;
        int countSong = 0;
        System.out.println("Enter the album name");
        String nameAlbum = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNameAlbum().equals(nameAlbum)) {
                countAlbum++;
                listSong = list.get(i).getListSong();
                System.out.println("Enter the name of the song you want to edit");
                String name = scanner.nextLine();
                for(int j = 0; j < listSong.size(); j++) {
                    if(listSong.get(j).getNameSong().equals(name)) {
                        listSong.set(j, createSong());
                        ManagerAlbum.writeFile(list);
                        countSong++;
                    }
                }
            }
        }
        if (countAlbum == 0){
            System.err.println("Album doesn't exist!!!");
        }
        if (countSong == 0){
            System.err.println("The song doesn't exist!!!");
        }
    }

    public void removeSong() throws IOException {
        int countAlbum = 0;
        int countSong = 0;
        System.out.println("Enter the album name");
        String nameAlbum = scanner.nextLine();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getNameAlbum().equals(nameAlbum)) {
                countAlbum++;
                listSong = list.get(i).getListSong();
                System.out.println("Enter the name of the song you want to delete");
                String name1 = scanner.nextLine();
                for(int j = 0; j < listSong.size(); j++) {
                    if(listSong.get(j).getNameSong().equals(name1)) {
                        System.out.println("Are you absolutely sure?");
                        System.out.println("This action cannot be undone. This will permanently delete the song");
                        System.out.println("1. I understand the consequences, delete this song");
                        System.out.println("2. Cancel");
                        int choice = scanner.nextInt();
                        switch (choice){
                            case 1:
                                System.out.println("Deleted " + listSong.get(i));
                                listSong.remove(j);
                                ManagerAlbum.writeFile(list);
                                countSong++;
                                break;
                            case 2:
                                countSong++;
                                break;
                        }
                    }
                }
            }
        }
        if (countAlbum == 0){
            System.err.println("Album doesn't exist!!!");
        }
        if (countSong == 0){
            System.err.println("The song doesn't exist!!!");
        }
    }

    public boolean checkNameSong(String nameSong) {
        for (Song song: listSong) {
            if (song.getNameSong().equals(nameSong)){
                System.err.println("The song title already exists");
                return true;
            }
            if (nameSong.equals("")){
                System.err.println("Song title can't be blank");
                return true;
            }
        }
        return false;
    }
}
