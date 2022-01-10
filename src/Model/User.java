package Model;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String userName;
    private String password;
    private String backupPassword;
    private boolean isAdmin;

    User() {
    }

    public User(String name, String userName, String password, String backupPassword, boolean isAdmin) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.backupPassword = backupPassword;
        this.isAdmin = isAdmin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBackupPassword() {
        return backupPassword;
    }

    public void setBackupPassword(String password2) {
        this.backupPassword = backupPassword;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User  [ Name = " + name + " || User Name = "
                + userName + " || Password = " + password + " || Is Admin = " + isAdmin + " ]";
    }
}
