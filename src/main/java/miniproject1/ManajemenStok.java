package miniproject1;
import java.util.ArrayList;

public class ManajemenStok {
    private ArrayList<Obat> daftarObat = new ArrayList<>();

    // CREATE
    public void tambahObat(Obat obat) {
        daftarObat.add(obat);
        System.out.println("Data obat berhasil ditambahkan!");
    }

    // READ
    public void tampilkanSemuaObat() {
        if (daftarObat.isEmpty()) {
            System.out.println("Stok obat masih kosong.");
            return;
        }
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.printf("| %-8s | %-20s | %-15s | %-8s | %-13s |\n", "ID", "Nama Obat", "Kategori", "Stok", "Harga");
        System.out.println("-------------------------------------------------------------------------");
        for (Obat o : daftarObat) {
            o.tampilkanInfo();
        }
        System.out.println("-------------------------------------------------------------------------");
    }

    // UPDATE
    public boolean updateObat(String id, String namaBaru, int stokBaru, double hargaBaru) {
        Obat o = cariObatById(id);
        if (o != null) {
            o.setNamaObat(namaBaru);
            o.setStok(stokBaru);
            o.setHarga(hargaBaru);
            return true;
        }
        return false;
    }

    // DELETE
    public boolean hapusObat(String id) {
        Obat o = cariObatById(id);
        if (o != null) {
            daftarObat.remove(o);
            return true;
        }
        return false;
    }

    // Helper Method
    public Obat cariObatById(String id) {
        for (Obat o : daftarObat) {
            if (o.getIdObat().equalsIgnoreCase(id)) {
                return o;
            }
        }
        return null;
    }
}
