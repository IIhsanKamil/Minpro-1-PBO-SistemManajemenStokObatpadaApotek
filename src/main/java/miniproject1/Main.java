package miniproject1;
import java.util.Scanner;
/**
 *
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ManajemenStok app = new ManajemenStok();

        // Data dummy awal
        KategoriObat bebas = new KategoriObat("Obat Bebas", "Dapat dibeli tanpa resep");
        KategoriObat keras = new KategoriObat("Obat Keras", "Harus dengan resep dokter");

        app.tambahObat(new Obat("OBT01", "Paracetamol", 50, 5000, bebas));
        app.tambahObat(new Obat("OBT02", "Amoxicillin", 20, 12000, keras));

        boolean running = true;

        // Perulangan program
        while (running) {
            System.out.println("\n=== SISTEM MANAJEMEN STOK OBAT APOTEK ===");
            System.out.println("1. Tampilkan Semua Obat (Read)");
            System.out.println("2. Tambah Obat Baru (Create)");
            System.out.println("3. Ubah Data Obat (Update)");
            System.out.println("4. Hapus Obat (Delete)");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (pilihan) {
                case 1:
                    app.tampilkanSemuaObat();
                    break;

                case 2:
                    System.out.print("Masukkan ID Obat: ");
                    String id = scanner.nextLine();
                    
                    System.out.print("Masukkan Nama Obat: ");
                    String nama = scanner.nextLine();

                    int stok = inputInt(scanner, "Masukkan Jumlah Stok: ");
                    double harga = inputDouble(scanner, "Masukkan Harga Obat: ");

                    System.out.println("Pilih Kategori: 1. Obat Bebas | 2. Obat Keras");
                    System.out.print("Pilihan (1/2): ");
                    int katPilih = scanner.nextInt();
                    scanner.nextLine();

                    KategoriObat katTerpilih = (katPilih == 2) ? keras : bebas;

                    app.tambahObat(new Obat(id, nama, stok, harga, katTerpilih));
                    break;

                case 3:
                    System.out.print("Masukkan ID Obat yang ingin diubah: ");
                    String idUpdate = scanner.nextLine();
                    if (app.cariObatById(idUpdate) != null) {
                        System.out.print("Masukkan Nama Baru: ");
                        String namaBaru = scanner.nextLine();
                        int stokBaru = inputInt(scanner, "Masukkan Stok Baru: ");
                        double hargaBaru = inputDouble(scanner, "Masukkan Harga Baru: ");

                        if (app.updateObat(idUpdate, namaBaru, stokBaru, hargaBaru)) {
                            System.out.println("Data obat berhasil diubah!");
                        }
                        else {
                        System.out.println("ID Obat tidak ditemukan!");
                        } 
                    }
                    break;

                case 4:
                    System.out.print("Masukkan ID Obat yang ingin dihapus: ");
                    String idHapus = scanner.nextLine();
                    if (app.hapusObat(idHapus)) {
                        System.out.println("Obat berhasil dihapus!");
                    }
                        else {
                        System.out.println("ID Obat tidak ditemukan!");
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan sistem ini.");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        }
        scanner.close();
    }

    // Helper method untuk validasi input integer
    private static int inputInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int val = scanner.nextInt();
                scanner.nextLine();
                return val;
            }
            System.out.println("Input salah! Masukkan angka bulat.");
            scanner.next();
        }
    }

    // Helper method untuk validasi input double
    private static double inputDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                double val = sc.nextDouble();
                sc.nextLine();
                return val;
            }
            System.out.println("Input salah! Masukkan angka desimal/bulat.");
            sc.next();
        }
    }
}
