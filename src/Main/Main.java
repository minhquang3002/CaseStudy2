package Main;

import Manager.ManagerAlbum;
import Manager.ManagerSong;
import Manager.ManagerUser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        Main.Authen();
    }

    static Scanner scanner = new Scanner(System.in);

    public static void menuSong(String name) throws FileNotFoundException, ClassNotFoundException, IOException {
        try {
            ManagerSong manageSong = new ManagerSong();
            while(true) {
                System.out.println("_____________Manage Song______________");
                System.out.println("|            1. Add Song              |");
                System.out.println("|            2. Edit Song             |");
                System.out.println("|            3. Remove Song           |");
                System.out.println("|            4. Show Song             |");
                System.out.println("|            5. Exit                  |");
                System.out.println("|_____________________________________|");
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice) {
                    case 1:
                        manageSong.addSong();
                        break;
                    case 2:
                        manageSong.editSong();
                        break;
                    case 3:
                        manageSong.removeSong();
                        break;
                    case 4:
                        manageSong.showSong();
                        break;
                    case 5:
                        Main.MenuAlbumAdmin();
                        break;
                }
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static void MenuAlbumUser() throws FileNotFoundException, ClassNotFoundException, IOException {
        try {
            ManagerAlbum managerAlbum = new ManagerAlbum();
            while(true) {
                System.out.println("____________Manage Album User__________");
                System.out.println("|            1. Select Album           |");
                System.out.println("|            2. Show Album             |");
                System.out.println("|            3. Exit                   |");
                System.out.println("|______________________________________|");
                int choice=Integer.parseInt(scanner.nextLine());
                switch(choice) {
                    case 1:
                        managerAlbum.selectAlbum();
                        break;
                    case 2:
                        managerAlbum.showAlbum();
                        break;
                    default :
                        Main.Authen();
                }
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static void MenuAlbumAdmin() throws FileNotFoundException, ClassNotFoundException, IOException {
        try {
            ManagerAlbum managerAlbum = new ManagerAlbum();
            while(true) {
                System.out.println("___________Manage Album Admin_________");
                System.out.println("|             1. Add                  |");
                System.out.println("|             2. Edit                 |");
                System.out.println("|             3. Remove               |");
                System.out.println("|             4. Select Album         |");
                System.out.println("|             5. Show                 |");
                System.out.println("|             6. Exit                 |");
                System.out.println("|_____________________________________|");
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice) {
                    case 1:
                        managerAlbum.addAlbum();
                        break;
                    case 2:
                        managerAlbum.editAlbum();
                        break;
                    case 3:
                        managerAlbum.removeAlbum();
                        break;
                    case 4:
                        managerAlbum.selectAlbum();
                        break;
                    case 5:
                        managerAlbum.showAlbum();
                        break;
                    default :
                        Main.Authen();
                }
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    public static void Authen() throws FileNotFoundException, ClassNotFoundException, IOException {
        try {
            ManagerUser managerUser = new ManagerUser();
            while(true) {
                System.out.println("______________LOGIN_______________");
                System.out.println("|         1. Log in               |");
                System.out.println("|         2. Register             |");
                System.out.println("|         3. Forgot password      |");
                System.out.println("|         4. Exit                 |");
                System.out.println("|_________________________________|");
                int choice = Integer.parseInt(scanner.nextLine());
                switch(choice) {
                    case 1:
                        System.out.println("Username");
                        String userName = scanner.nextLine();
                        System.out.println("Password");
                        String password = scanner.nextLine();
                        managerUser.Authentication(userName, password);
                        break;
                    case 2:
                        managerUser.addUser();
                        break;
                    case 3:
                        managerUser.forgotPassword();
                        break;
                    default:
                        System.exit(0);
                }
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
