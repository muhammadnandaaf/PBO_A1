public class Warga {
    public String nama;
    public String kelamin;
    public String alamat;
    public String asal;
    public int usia;
    public Warga(String nama, String kelamin, String alamat, String asal, int usia) {
        this.nama = nama;
        this.kelamin = kelamin;
        this.alamat = alamat;
        this.asal = asal;
        this.usia = usia;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getKelamin() {
        return kelamin;
    }
    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getAsal() {
        return asal;
    }
    public void setAsal(String asal) {
        this.asal = asal;
    }
    public int getUsia() {
        return usia;
    }
    public void setUsia(int usia) {
        this.usia = usia;
    }
    //FUNGSI OVERRIDING
    public void addDone(){
        System.out.println("Data dengan nama " + this.nama + " Berhasil Ditambahkan");
    }

    public void updateDone(){
        System.out.println("Data dengan nama " + this.nama + " Berhasil Diubah");
    }

    public void deleteDone(){
        System.out.println("Data dengan nama " + this.nama + " Berhasil Dihapus");
    }

    //FUNGSI OVERLOADING
    public void keterangan(String Nama, String Alamat){
        System.out.println("Nama " + this.nama);
        System.out.println("Alamat " + this.alamat);
    }

}
