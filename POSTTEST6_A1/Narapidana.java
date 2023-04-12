public class Narapidana extends Warga{
    public String alasan;
    public double lama;
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

    //FUNGSI OVERRIDING
    @Override
    public void addDone(){
        System.out.println("Narapidana dengan nama " + this.nama + " Berhasil Ditambahkan");
    }
    @Override
    public void updateDone(){
        System.out.println("Narapidana dengan nama " + this.nama + " Berhasil Diubah");
    }
    @Override
    public void display(){
        System.out.println("Nama Narapidana : " + this.nama);
        System.out.println("Jenis Kelamin   : " + this.kelamin);
        System.out.println("Alamat          : " + this.alamat);
        System.out.println("Asal            : " + this.asal);
        System.out.println("Usia            : " + this.usia + " Tahun");
        System.out.println("Alasan          : " + this.alasan);
        System.out.println("Waktu Tahanan   : " + this.lama + " Tahun");
    }
    //FUNGSI OVERLOADING
    public void keterangan(String nama, String alamat){
        System.out.println("Narapidana dengan nama " + this.nama);
        System.out.println("Narapidana dengan alamat " + this.alamat);
    }

    public void keterangan(String nama, String alasan, int usia){
        System.out.println("Narapidana dengan nama " + this.nama + " Yang berusia " + this.usia + " Tahun");
        System.out.println("Telah melakukan Tindak Kriminal Yaitu " + this.alasan);
        System.out.println("Maka " + this.nama + " akan diberikan hukuman sesuai dengan hukum tertulis");
    }
    
}