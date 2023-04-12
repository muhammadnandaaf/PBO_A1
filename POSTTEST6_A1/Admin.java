import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Admin extends Warga implements fungsiAdmin {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Narapidana> narapidana = new ArrayList<Narapidana>();
    static ArrayList<Pengunjung> pengunjung = new ArrayList<Pengunjung>();

    final String status = "Admin";
    private String username;
    private String password;
    
    public Admin(String nama, String kelamin, String alamat, String asal, int usia, String status, String username, String password) {
        super(nama, kelamin, alamat, asal, usia);
        this.username = username;
        this.password = password;
    }

    public String getStatus() {
        return status;
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
    
    @Override
    public void addDone(){
        System.out.println("ADMIN");
    }

    @Override
    public void display(){
        System.out.println("Nama Admin : " + this.nama);
    }

    
    @Override
    public void create() throws IOException {
        System.out.println("Nambah Data");
        System.out.println("[1] Narapidana");
        System.out.println("[2] Pengunjung");
        System.out.print("Masukkan Pilihan : ");
        int pilihan = Integer.parseInt(br.readLine());
        switch (pilihan){
            case 1 :
                System.out.print("Masukkan Nama : ");
                String addnama = br.readLine();
                System.out.print("Masukkan Jenis Kelamin : ");
                String addkelamin = br.readLine();
                System.out.print("Masukkan Alamat : ");
                String addalamat = br.readLine();
                System.out.print("Masukkan Asal : ");
                String addasal = br.readLine();
                System.out.print("Masukkan usia : ");
                int addusia = Integer.parseInt(br.readLine());
                System.out.print("Masukkan Alasan : ");
                String addalasan = br.readLine();
                System.out.print("Masukkan Lama Tahanan : ");
                double addwaktu = Double.parseDouble(br.readLine());

                Narapidana napi = new Narapidana(addnama, addkelamin, addalamat, addasal, addusia, addalasan, addwaktu);
                narapidana.add(napi);
                napi.addDone();
                break;
            case 2 :
                System.out.print("Masukkan Nama : ");
                String addnamap = br.readLine();
                System.out.print("Masukkan Jenis Kelamin : ");
                String addkelaminp = br.readLine();
                System.out.print("Masukkan Alamat : ");
                String addalamatp = br.readLine();
                System.out.print("Masukkan Asal : ");
                String addasalp = br.readLine();
                System.out.print("Masukkan usia : ");
                int addusiap = Integer.parseInt(br.readLine());
                System.out.print("Masukkan Hari Berkunjung : ");
                String addhari = br.readLine();
                System.out.print("Masukkan Jam Berkunjung : ");
                String addjam = br.readLine();
                System.out.print("Masukkan Nomor Antrian : ");
                System.out.println("Masukan Username :");
                String addUser = br.readLine();
                System.out.println("Masukan Password :");
                String addPass = br.readLine();
                int addantrian = Integer.parseInt(br.readLine());

                Pengunjung kunjung = new Pengunjung(addnamap, addkelaminp, addalamatp, addasalp, addusiap, addhari, addjam, addantrian,addUser,addPass);
                pengunjung.add(kunjung);
                kunjung.addDone();
                break;
            default :
                System.out.println("Gagal Ditambahkan");
                break;
        }
    }

    @Override
    public void read() throws IOException {
        System.out.println("Lihat Data");
        System.out.println("[1] Narapidana");
        System.out.println("[2] Pengunjung");
        System.out.print("Masukkan Pilihan : ");
        int pilihan = Integer.parseInt(br.readLine());
        switch (pilihan){
            case 1:
                if (narapidana.size() != 0) {
                    System.out.println("Data Narapidana");
                    for (int i = 0; i< narapidana.size(); i++){
                        System.out.println("Napi ke - " + (i+1));
                        narapidana.get(i).display();
                        System.out.println("\n");
                    }
                }else{
                    System.out.println("Data Napi Masih Kosong");
                }
                break;
            case 2:
                if (pengunjung.size() != 0) {
                    System.out.println("Data Pengunjung");
                    for (int i = 0; i< pengunjung.size(); i++){
                        System.out.println("Pengunjung ke - " + (i+1));
                        pengunjung.get(i).display();
                        System.out.println("\n");
                    }
                }else{
                    System.out.println("Data Kunjungan Masih Kosong");
                }
                break;
            default:
                System.out.println("Gagal Melihat Data");
                break;
        }
    }

    @Override
    public void update() throws IOException {
        System.out.println("Ubah Data");
        System.out.println("[1] Narapidana");
        System.out.println("[2] Pengunjung");
        System.out.print("Masukkan Pilihan : ");
        int pilihan = Integer.parseInt(br.readLine());
        switch (pilihan){
            case 1 :
                System.out.println("Masukkan nomor urut tahanan : ");
                int idx = Integer.parseInt(br.readLine());
                if (idx <= narapidana.size() || idx > 0) {
                    System.out.print("Masukkan Nama : ");
                    String addnama = br.readLine();
                    System.out.print("Masukkan Jenis Kelamin : ");
                    String addkelamin = br.readLine();
                    System.out.print("Masukkan Alamat : ");
                    String addalamat = br.readLine();
                    System.out.print("Masukkan Asal : ");
                    String addasal = br.readLine();
                    System.out.print("Masukkan usia : ");
                    int addusia = Integer.parseInt(br.readLine());
                    System.out.print("Masukkan Alasan : ");
                    String addalasan = br.readLine();
                    System.out.print("Masukkan Lama Tahanan : ");
                    double addwaktu = Double.parseDouble(br.readLine());

                    narapidana.get(idx-1).setNama(addnama);
                    narapidana.get(idx-1).setKelamin(addkelamin);
                    narapidana.get(idx-1).setAlamat(addalamat);
                    narapidana.get(idx-1).setAsal(addasal);
                    narapidana.get(idx-1).setUsia(addusia);
                    narapidana.get(idx-1).setAlasan(addalasan);
                    narapidana.get(idx-1).setLama(addwaktu);
                    Narapidana napi = new Narapidana(addnama, addkelamin, addalamat, addasal, addusia, addalasan, addwaktu);
                    napi.updateDone();
                }else{
                    System.out.println("Data gagal di edit");
                }
                break;
                case 2 :
                    System.out.println("Masukkan nomor urut pengunjung : ");
                    int indks = Integer.parseInt(br.readLine());
                    if (indks <= pengunjung.size() || indks > 0) {
                        System.out.print("Masukkan Nama : ");
                        String addnamap = br.readLine();
                        System.out.print("Masukkan Jenis Kelamin : ");
                        String addkelaminp = br.readLine();
                        System.out.print("Masukkan Alamat : ");
                        String addalamatp = br.readLine();
                        System.out.print("Masukkan Asal : ");
                        String addasalp = br.readLine();
                        System.out.print("Masukkan usia : ");
                        int addusiap = Integer.parseInt(br.readLine());
                        System.out.print("Masukkan Hari Berkunjung : ");
                        String addhari = br.readLine();
                        System.out.print("Masukkan Jam Berkunjung : ");
                        String addjam = br.readLine();
                        System.out.print("Masukkan Nomor Antrian : ");
                        int addantrian = Integer.parseInt(br.readLine());
                        System.out.println("Masukan Username :");
                        String addUser = br.readLine();
                        System.out.println("Masukan Password :");
                        String addPass = br.readLine();
                        

                        pengunjung.get(indks-1).setNama(addnamap);
                        pengunjung.get(indks-1).setKelamin(addkelaminp);
                        pengunjung.get(indks-1).setAlamat(addalamatp);
                        pengunjung.get(indks-1).setAsal(addasalp);
                        pengunjung.get(indks-1).setUsia(addusiap);
                        pengunjung.get(indks-1).setHari(addhari);
                        pengunjung.get(indks-1).setJam(addjam);
                        pengunjung.get(indks-1).setAntrian(addantrian);
                        Pengunjung kunjung = new Pengunjung(addnamap, addkelaminp, addalamatp, addasalp, addusiap, addhari, addjam, addantrian,addUser,addPass);
                        kunjung.updateDone();
                    }
                    break;  
                default:
                    System.out.println("Data Gagal Di Ubah");
                    break;
                }          
    }

    @Override
    public void delete() throws IOException {
        System.out.println("Hapus Data");
        System.out.println("[1] Narapidana");
        System.out.println("[2] Pengunjung");
        System.out.print("Masukkan Pilihan : ");
        int pilihan = Integer.parseInt(br.readLine());
        switch (pilihan) {
            case 1 :
                System.out.print("Masukkan no urut Tahanan : ");
                int idx = Integer.parseInt(br.readLine());
                if(idx <= narapidana.size() || idx > 0){
                    narapidana.remove(idx -1);
                    System.out.println("Data berhasil Dihapus");
                }else{
                    System.out.println("Data Gagal dihapus");
                }
                break;
            case 2 :
                System.out.println("Masukkan no urut Pengunjung : ");
                int indks = Integer.parseInt(br.readLine());
                if(indks <= pengunjung.size() || indks > 0){
                    pengunjung.remove(indks - 1);
                    System.out.println("Data berhasil Dihapus");
                }else{
                    System.out.println("Data Gagal dihapus");
                }
                break;
            default :
                System.out.println("Data Gagal Di Hapus");
                break;
        }
    }
    
    @Override
    public void menu() throws IOException {
        while (true){
            System.out.println("===== Pendataan Narapidana =====");
            System.out.println("1. Create");
            System.out.println("2. Read");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = Integer.parseInt(br.readLine());
            switch (pilihan) {
                case 1:
                    create();
                    break;
                case 2:
                    read();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    delete();
                    break;
                case 5:
                    System.out.println("Keluar");
                    System.exit(0);
                    break;
                default:
                    System.out.println("PILIHAN TIDAK ADA");
                    break;
            }
        }
    }
}
