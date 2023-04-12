import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Admin admin = new Admin("Nanda", "Laki-laki", "Sempaja", "Samarinda", 20, "Admin", "nandz", "admin123");
        Pengunjung pengunjung = new Pengunjung("Nanda", "Laki-laki", "Sempaja", "Samarinda", 20, "Senin", "14.00", 2,"pengunjung","pengunjung123");
        while(true){
            System.out.println("Halo User");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Masukan pilihan :");
            int pilihan = Integer.parseInt(br.readLine());
            if (pilihan == 1) {
                System.out.println("Masukan Username :");
                String username = br.readLine();
                System.out.println("Masukan Password :");
                String password = br.readLine();
                if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())){
                    System.out.println("Selamat datang Admin" + admin.getNama());
                    admin.menu();
                    continue;
                }
                if(username.equals(pengunjung.getUsername()) && password.equals(pengunjung.getPassword())){
                    System.out.println("Selamat datang pengunjung" + pengunjung.getNama());
                    pengunjung.menu();
                    continue;
                }
            } else if (pilihan == 2){
                System.out.println("Terima Kasih Telah Menggunakan Aplikasi");
                System.exit(1);
                break;
            } else {
                System.out.println("Pilihan Tidak Tersedia");
                continue;
            }
        }
    } 
}