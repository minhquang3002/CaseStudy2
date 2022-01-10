package Manager;

import Main.Main;
import Model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerUser {
    Scanner scanner = new Scanner(System.in);
    ArrayList<User> listUser = readFile();

    public ManagerUser() throws ClassNotFoundException, IOException {
        try{
            writeFile(readFile());
        }catch(IOException e) {
            writeFile(new ArrayList<>());
        }
    }

    public User createUser() {
        System.out.println("Enter id user");
        int idUser = scanner.nextInt();
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter email");
        String email = scanner.nextLine();
        System.out.println("Enter username");
        String userName = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.nextLine();
        System.out.println("Enter backup password");
        String backupPassword = scanner.nextLine();
        System.out.println("Enter is admin");
        boolean isAdmin = Boolean.parseBoolean(scanner.nextLine());
        return new User(idUser, name, email, userName, password, backupPassword, isAdmin);
    }

    public void addUser() throws IOException {
        int count = 0;
        User user = createUser();
        for (User value : listUser) {
            if (value.getUserName().equals(user.getUserName())) {
                System.out.println("This account has already existed");
                count++;
            }
        }
        if(count == 0) {
            listUser.add(user);
            writeFile(listUser);
        }
    }

    public void forgotPassword() throws IOException {
        String name = scanner.nextLine();
        for (User user : listUser) {
            if (user.getUserName().equals(name)) {
                System.out.println("Enter backup password");
                String backupPassword = scanner.nextLine();
                if (user.getBackupPassword().equals(backupPassword)) {
                    System.out.println("Enter new password");
                    String newPassword1 = scanner.nextLine();
                    System.out.println("Enter the password");
                    String newPassword2 = scanner.nextLine();
                    if (newPassword1.equals(newPassword2)) {
                        user.setPassword(newPassword1);
                    } else {
                        System.out.println("Re-entered password is incorrect ");
                    }
                } else {
                    System.out.println("Incorrect backup password");
                }
            }
        }
        writeFile(listUser);
    }

    public void Authentication(String username, String password) throws ClassNotFoundException, IOException {
        int a = 0;
        for (User user : listUser) {
            if (user.getUserName().equals(username)) {
                a++;
                if (user.getPassword().equals(password)) {
                    if (user.isAdmin()) {
                        Main.MenuAlbumAdmin();
                        break;
                    } else {
                        Main.MenuAlbumUser();
                        break;
                    }
                } else {
                    System.err.println("The password you entered is incorrect");
                    break;
                }
            }
        }
        if(a == 0) {
            System.out.println("User does not exist");
        }
    }

    public ArrayList<User> readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/File/User.txt"));
        ArrayList<User> list = (ArrayList<User>) ois.readObject();
        ois.close();
        return list;
    }

    public void writeFile(ArrayList<User> list) throws FileNotFoundException, IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/File/User.txt"));
        oos.writeObject(list);
        oos.close();
    }
}
