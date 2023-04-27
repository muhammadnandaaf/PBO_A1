package src;

public class aksesAdmin extends parentAdmin {
    final String status = "Admin";
    private String usernameAdmin;
    private String passwordAdmin;
    public aksesAdmin(String nama, String usernameAdmin, String passwordAdmin) {
        super(nama);
        this.usernameAdmin = usernameAdmin;
        this.passwordAdmin = passwordAdmin;
    }
    public String getStatus() {
        return status;
    }
    public String getUsernameAdmin() {
        return usernameAdmin;
    }
    public void setUsernameAdmin(String usernameAdmin) {
        this.usernameAdmin = usernameAdmin;
    }
    public String getPasswordAdmin() {
        return passwordAdmin;
    }
    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }   
}
