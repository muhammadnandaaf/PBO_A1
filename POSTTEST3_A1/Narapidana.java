public class Narapidana extends Warga{
    private String alasan;
    private double lama;
    public Narapidana(String nama, String kelamin, String alamat, String asal, int usia, String alasan, double lama) {
        super(nama, kelamin, alamat, asal, usia);
        this.alasan = alasan;
        this.lama = lama;
    }
    public String getAlasan() {
        return alasan;
    }
    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }
    public double getLama() {
        return lama;
    }
    public void setLama(double lama) {
        this.lama = lama;
    }
    
}