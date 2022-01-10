package Manager;

import Main.Main;
import Model.Album;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ManagerAlbum {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Album> listAlbum = readFile();

    public ManagerAlbum() throws IOException, ClassNotFoundException {
        try {
            writeFile(readFile());
        } catch (IOException e){
            writeFile(new ArrayList<>());
        }
    }

    public Album createAlbum(){
        System.out.println("Enter album name");
        String nameAlbum = scanner.nextLine();
        return new Album(nameAlbum);
    }

    public void addAlbum() throws IOException {
        Album album = createAlbum();
        if (!checkNameAlbum(album.getNameAlbum())){
            listAlbum.add(album);
            writeFile(listAlbum);
            System.out.println("Create successful");
        }
    }

    public void showAlbum() {
        for (Album album : listAlbum) {
            System.out.println(album);
        }
    }

    public void editAlbum() throws IOException {
        System.out.println("Enter the name of the album you want to edit");
        String name = scanner.nextLine();
        int count = 0;
        for(int i = 0; i < listAlbum.size(); i++) {
            if(listAlbum.get(i).getNameAlbum().equals(name)) {
                System.out.println("Enter new album name");
                String nameAlbum = scanner.nextLine();
                listAlbum.get(i).setNameAlbum(nameAlbum);
                if (!checkNameAlbum(nameAlbum)){
                    writeFile(listAlbum);
                    count++;
                    break;
                }
            }
        }
        if(count == 0) {
            System.err.println("Album doesn't exist!!!");
        }
    }

    public void removeAlbum() throws IOException {
        System.out.println("Enter the name of the album you want to delete");
        String name = scanner.nextLine();
        int count = 0;
        for(int i = 0; i < listAlbum.size(); i++) {
            if(listAlbum.get(i).getNameAlbum().equals(name)) {
                System.out.println("Are you absolutely sure?");
                System.out.println("This action cannot be undone. This will permanently delete the album");
                System.out.println("1. I understand the consequences, delete this album");
                System.out.println("2. Cancel");
                int choice = scanner.nextInt();
                switch (choice){
                    case 1:
                        System.out.println("Deleted " + listAlbum.get(i));
                        listAlbum.remove(i);
                        writeFile(listAlbum);
                        count++;
                        break;
                    case 2:
                        count++;
                        break;
                }
            }
        }
        if(count == 0) {
            System.err.println("Album doesn't exist!!!");
        }
    }

    public void selectAlbum() throws ClassNotFoundException, IOException {
        String name = scanner.nextLine();
        int count = 0;
        for (Album album : listAlbum) {
            if (album.getNameAlbum().equals(name)) {
                Main.menuSong(name);
                count++;
            }
        }
        if(count == 0) {
            System.err.println("Album doesn't exist!!!");
        }
    }

    public boolean checkNameAlbum(String nameAlbum) {
        for (Album album : listAlbum) {
            if (album.getNameAlbum().equals(nameAlbum)) {
                System.err.println("Album name already exists");
                return true;
            }
            if (nameAlbum == null){
                System.err.println("Album name cannot be empty");
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Album> readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("src/File/Album.txt"));
        ArrayList<Album> list = (ArrayList<Album>) ois.readObject();
        ois.close();
        return list;
    }
    public static void writeFile(ArrayList<Album> List) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/File/Album.txt"));
        oos.writeObject(List);
        oos.close();
    }
}
