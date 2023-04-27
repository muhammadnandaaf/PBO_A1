package src;

public abstract class parentAdmin {
    final String status = "Admin";
    protected String nama;
    public parentAdmin(String nama) {
        this.nama = nama;
    }
    public String getStatus() {
        return status;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }

}
