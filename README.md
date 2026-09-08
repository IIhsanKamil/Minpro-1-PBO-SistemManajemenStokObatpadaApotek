# Minpro 1 PBO - Sistem Manajemen Stok Obat pada Apotek

Aplikasi berbasis **CLI (Command Line Interface)** yang dibangun menggunakan bahasa pemograman **Java** untuk mengelola data inventaris dan stok obat pada apotek secara terstruktur dengan menerapkan konsep **Object-Oriented Programming (OOP)**.

---

## Deskripsi Singkat Program
Sistem Manajemen Stok Obat Apotek merupakan program pengelolaan data inventaris obat berbasis konsol yang mendukung operasi **CRUD (Create, Read, Update, Delete)**. Program ini dirancang untuk memudahkan petugas apotek dalam memantau ketersediaan stok, menambahkan data obat baru, memperbarui rincian obat seperti jumlah stok dan harga, serta menghapus data obat.

---

## 🔄 Penjelasan Alur Program

1. **Inisialisasi Data & Menu Utama**:
   - Saat program dijalankan, sistem secara otomatis menginisialisasi sampel kategori obat (`Obat Bebas` dan `Obat Keras`) serta beberapa data obat awal ke dalam `ArrayList`.
   - Program menampilkan menu interaktif bertingkat dan menunggu masukan dari pengguna melalui `Scanner`.

2. **Perulangan Utama (Program Loop)**:
   - Program menggunakan struktur perulangan `while (running)` sehingga menu akan terus ditanyakan dan tidak akan berhenti sampai pengguna memilih menu **5 (Keluar)**.

3. **Operasi CRUD berdasarkan Pilihan Menu**:
   - **Menu 1 (Read - Tampilkan Semua Obat)**: Memanggil method `tampilkanSemuaObat()` pada class `ManajemenStok` untuk mengiterasi seluruh elemen di `ArrayList` dan memformat tampilannya ke dalam tabel konsol yang rapi.
   - **Menu 2 (Create - Tambah Obat Baru)**: Meminta masukan ID, Nama, Stok, Harga, dan Kategori. Data diproses melalui validasi input sebelum objek `Obat` baru diinstansiasi dan dimasukkan ke dalam `ArrayList`.
   - **Menu 3 (Update - Ubah Data Obat)**: Meminta ID obat yang ingin diubah. Jika ID ditemukan, sistem memperbarui nama, stok, dan harga obat tersebut menggunakan method *setter*.
   - **Menu 4 (Delete - Hapus Obat)**: Meminta ID obat yang ingin dihapus. Jika ditemukan, objek obat dikeluarkan dari `ArrayList`.
   - **Menu 5 (Keluar)**: Mengubah variabel kontrol perulangan menjadi `false` dan menutup program secara aman.

---

## Penerapan Lainnya

Dalam pembuatan program ini, beberapa konsep utama dan nilai tambah Pemrograman Berbasis Objek (PBO) telah diterapkan:

### 1. Access Modifier & Encapsulation
- **Penerapan**: Seluruh variabel atribut/properties pada class entitas (`Obat` dan `KategoriObat`) diset dengan akses `private` (misalnya `private int stok`, `private double harga`).
- **Tujuan**: Mencegah akses atau manipulasi data langsung dari luar class tanpa melalui aturan yang telah ditentukan.
- **Akses Data**: Akses dan perubahan data dikontrol sepenuhnya melalui method *getter* dan *setter* publik (`public get...()` dan `public set...()`).

### 2. Validasi Input
Validasi diterapkan di dua lapisan program untuk mencegah terjadinya error saat program berjalan:
- **Validasi Tipe Data Input (Scanner)**: Pada class `Main`, input integer (`inputInt`) dan double (`inputDouble`) dilengkapi dengan pengecekan `hasNextInt()` dan `hasNextDouble()`. Jika pengguna memasukkan huruf/karakter tidak valid pada input angka, sistem menangkap kesalahan tersebut dan meminta masukan ulang tanpa membuat program mengalami crash.
- **Validasi Nilai Atribut (Business Logic)**: Pada setter `setStok()` dan `setHarga()` di class `Obat`, terdapat kondisi pengecekan untuk memastikan nilai stok dan harga tidak bernilai negatif (`< 0`). Jika input negatif dimasukkan, sistem secara otomatis memberikan peringatan dan mengatur nilai default ke `0`.

---

## Struktur Class Program

- `Obat.java` *_(Class Entitas Utama)_*
- `KategoriObat.java` *(_Class Entitas Pendukung)_*
- `ManajemenStok.java` *_(Class Pengelola CRUD & ArrayList)_*
- `Main.java` *_(Class Entry Point & Menu Interaktif)_*
