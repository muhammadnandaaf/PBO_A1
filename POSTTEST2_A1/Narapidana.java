class Narapidana {
    private String nama;
    private String asal;
    private String alasan;
    private int usia;
    private double waktu;

    public Narapidana(String nama, String asal, String alasan, int usia,double waktu){
        this.nama = nama;
        this.asal = asal;
        this.alasan = alasan;
        this.usia = usia;
        this.waktu = waktu;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    public int getUsia() {
        return usia;
    }

    public void setUsia(int usia) {
        this.usia = usia;
    }

    public double getWaktu() {
        return waktu;
    }

    public void setWaktu(double waktu) {
        this.waktu = waktu;
    }
}
