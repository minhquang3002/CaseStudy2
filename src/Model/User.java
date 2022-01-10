package Model;

public class User {
    private int idUser;
    private String name;
    private String email;
    private String userName;
    private String password;
    private String backupPassword;
    private boolean isAdmin;

    User() {
    }

    public User(int idUser, String name, String email, String userName, String password, String backupPassword, boolean isAdmin) {
        this.idUser = idUser;
        this.name = name;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.backupPassword = backupPassword;
        this.isAdmin = isAdmin;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        return "User  [ ID User = " + idUser + " || Name = " + name + " || User Name = "
                + userName + " || Password = " + password + " || Is Admin = " + isAdmin + " ]";
    }
}
