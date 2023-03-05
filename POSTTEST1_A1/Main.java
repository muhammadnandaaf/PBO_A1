import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Narapidana> narapidana = new ArrayList<Narapidana>();
    public static void main(String[] args) throws IOException {
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
                    edit();
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

    public static void create() throws IOException{
        System.out.print("Masukkan Nama : ");
        String addnama = br.readLine();
        System.out.print("Masukkan Asal : ");
        String addasal = br.readLine();
        System.out.print("Masukkan Alasan : ");
        String addalasan = br.readLine();
        System.out.print("Masukkan usia : ");
        int addusia = Integer.parseInt(br.readLine());
        System.out.print("Masukkan Lama Tahanan : ");
        double addwaktu = Double.parseDouble(br.readLine());
        Narapidana napi = new Narapidana(addnama, addasal, addalasan, addusia, addwaktu);

        narapidana.add(napi);
    }

    public static void read() throws IOException{
        System.out.println("Data Mahasiswa");
        for (int i = 0; i< narapidana.size(); i++){
            System.out.println("Napi ke - " + (i+1));
            System.out.println("Nama Narapidana : " + narapidana.get(i).nama);
            System.out.println("Asal Narapidana : " + narapidana.get(i).asal);
            System.out.println("Alasan Kriminal : " + narapidana.get(i).alasan);
            System.out.println("Usia Narapidana : " + narapidana.get(i).usia + " Tahun");
            System.out.println("Waktu Tahanan   : " + narapidana.get(i).waktu + " Tahun");
        }
    }
    public static void edit() throws IOException{
        System.out.println("Masukkan indeks Mahasiswa : ");
        int idx = Integer.parseInt(br.readLine());

        if (idx <= narapidana.size() || idx > 0) {
            System.out.print("Masukkan Nama : ");
            String addnama = br.readLine();
            System.out.print("Masukkan Asal : ");
            String addasal = br.readLine();
            System.out.print("Masukkan Alasan : ");
            String addalasan = br.readLine();
            System.out.print("Masukkan usia : ");
            int addusia = Integer.parseInt(br.readLine());
            System.out.print("Masukkan IPK : ");
            int addwaktu = Integer.parseInt(br.readLine());
            Narapidana napi = new Narapidana(addnama, addasal, addalasan, addusia, addwaktu);
            narapidana.set(idx - 1, napi);
            System.out.println("Data Berhasil diedit");
        }else{
            System.out.println("Data gagal di edit");
        }
    }
    public static void delete() throws IOException{
        System.out.println("Masukkan no urut Tahanan : ");
        int idx = Integer.parseInt(br.readLine());
        if(idx <= narapidana.size() || idx > 0){
            narapidana.remove(idx -1);
            System.out.println("Data berhasil Dihapus");
        }else{
            System.out.println("Data Gagal dihapus");
        }
    }
}