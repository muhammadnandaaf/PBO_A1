public class Pengunjung extends Warga {
    private String hari;
    private String jam;
    private int antrian;
    public Pengunjung(String nama, String kelamin, String alamat, String asal, int usia, String hari, String jam,
            int antrian) {
        super(nama, kelamin, alamat, asal, usia);
        this.hari = hari;
        this.jam = jam;
        this.antrian = antrian;
    }
    public String getHari() {
        return hari;
    }
    public void setHari(String hari) {
        this.hari = hari;
    }
    public String getJam() {
        return jam;
    }
    public void setJam(String jam) {
        this.jam = jam;
    }
    public int getAntrian() {
        return antrian;
    }
    public void setAntrian(int antrian) {
        this.antrian = antrian;
    }
    
    
}
