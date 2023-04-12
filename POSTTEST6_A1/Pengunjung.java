import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Pengunjung extends Warga implements fungsiPengunjung{
    static ArrayList<Narapidana> narapidana = new ArrayList<Narapidana>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    private String hari;
    private String jam;
    private int antrian;
    private String username;
    private String password;
    public Pengunjung(String nama, String kelamin, String alamat, String asal, int usia, String hari, String jam,
            int antrian, String username, String password) {
        super(nama, kelamin, alamat, asal, usia);
        this.hari = hari;
        this.jam = jam;
        this.antrian = antrian;
        this.username = username;
        this.password = password;
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
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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
    //FUNGSI OVERRIDING
    @Override
    public void addDone(){
        System.out.println("Pengunjung dengan nama " + this.nama + " Berhasil Ditambahkan");
    }

    public void updateDone(){
        System.out.println("Pengunjung dengan nama " + this.nama + " Berhasil Diubah");
    }

    public void deleteDone(){
        System.out.println("Pengunjung dengan nama " + this.nama + " Berhasil Dihapus");
    }
    @Override
    public void menu() throws IOException {
        while (true){
            System.out.println("===== Pendataan Narapidana =====");
            System.out.println("1. Read Napi");
            System.out.println("2. Exit");
            int pilihan = Integer.parseInt(br.readLine());
            switch (pilihan){
                case 1:
                    readNapi();
                    break;
                case 2:
                    System.out.println("Keluar");
                    System.exit(0);
                    break;
                default:
                    System.out.println("PILIHAN TIDAK ADA");
                    break;
            }
        }
    }
    @Override
    public void readNapi() throws IOException {
        System.out.println("Lihat Data");
        if (narapidana.size() != 0) {
            System.out.println("Data Narapidana");
            for (int i = 0; i< narapidana.size(); i++){
                System.out.println("Napi ke - " + (i+1));
                narapidana.get(i).display();
                System.out.println("\n");
            }
        }else{
            System.out.println("Data Kunjungan Masih Kosong");
        }
    }

}
