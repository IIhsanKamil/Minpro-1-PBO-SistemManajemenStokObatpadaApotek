package miniproject1;

/**
 *
 * @author Asus
 */
public class Obat {
    private String idObat;
    private String namaObat;
    private int stok;
    private double harga;
    private KategoriObat kategori;

    // Constructor
    public Obat(String idObat, String namaObat, int stok, double harga, KategoriObat kategori) {
        this.idObat = idObat;
        this.namaObat = namaObat;
        setStok(stok);
        setHarga(harga);
        this.kategori = kategori;
    }

    public String getIdObat() {
        return idObat;
    }

    public void setIdObat(String idObat) {
        this.idObat = idObat;
    }

    public String getNamaObat() {
        return namaObat;
    }

    public void setNamaObat(String namaObat) {
        this.namaObat = namaObat;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif!");
            this.stok = 0;
        } else {
            this.stok = stok;
        }
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif!");
            this.harga = 0;
        } else {
            this.harga = harga;
        }
    }

    public KategoriObat getKategori() {
        return kategori;
    }

    public void setKategori(KategoriObat kategori) {
        this.kategori = kategori;
    }

    public void tampilkanInfo() {
        System.out.printf("| %-8s | %-20s | %-15s | %-8d | Rp %-10.2f |\n", 
                idObat, namaObat, kategori.getNamaKategori(), stok, harga);
    }
}
