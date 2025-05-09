import java.util.ArrayList; // Mengimpor ArrayList untuk menyimpan hasil pencarian
import java.util.Scanner; // Mengimpor Scanner untuk membaca input dari pengguna

class Produk { // Kelas Produk digunakan untuk menyimpan data produk
    String id; // ID unik produk
    String nama; // Nama produk
    String kategori; // Kategori produk
    double harga; // Harga produk
    int stok; // Jumlah stok produk

    public Produk(String id, String nama, String kategori, double harga, int stok) { // Konstruktor untuk menginisialisasi produk
        this.id = id; // Mengisi ID produk dengan nilai dari parameter
        this.nama = nama; // Mengisi nama produk dengan nilai dari parameter
        this.kategori = kategori; // Mengisi kategori produk dengan nilai dari parameter
        this.harga = harga; // Mengisi harga produk dengan nilai dari parameter
        this.stok = stok; // Mengisi stok produk dengan nilai dari parameter
    }

    @Override
    public String toString() { // Override metode toString agar produk bisa ditampilkan dengan format yang lebih rapi
        return String.format("%-5s | %-25s | %-15s | Rp %.2f | Stok: %d",
                             id, nama, kategori, harga, stok);
    }
}

public class PencarianProduk { // Kelas utama tempat program berjalan
    public static void main(String[] args) { // Metode utama yang akan dieksekusi pertama kali

        // Data produk
        Produk[] daftarProduk = { // Membuat array berisi daftar produk yang tersedia
            new Produk("P001", "Laptop Asus VivoBook", "Elektronik", 8500000, 10),
            new Produk("P002", "Smartphone Samsung Galaxy", "Elektronik", 5000000, 15),
            new Produk("P003", "Kemeja Formal Pria", "Fashion", 250000, 50),
            new Produk("P004", "Sepatu Lari Nike", "Fashion", 1200000, 25),
            new Produk("P005", "Buku Pemrograman Java", "Buku", 150000, 30),
            new Produk("P006", "Mouse Gaming Logitech", "Elektronik", 350000, 20),
            new Produk("P007", "Novel Bumi Manusia", "Buku", 95000, 40),
            new Produk("P008", "Tas Ransel", "Fashion", 300000, 35)
        };

        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk membaca input dari pengguna

        System.out.println("=== SISTEM PENCARIAN PRODUK ==="); // Menampilkan judul program
        System.out.println("Kategori tersedia: Elektronik, Fashion, Buku"); // Menampilkan daftar kategori yang tersedia
        System.out.print("Masukkan kategori produk: "); // Meminta pengguna memasukkan kategori produk
        String kategoriCari = scanner.nextLine(); // Menyimpan input kategori dari pengguna

        System.out.print("Masukkan harga minimum: Rp "); // Meminta pengguna memasukkan harga minimum
        double hargaMin = scanner.nextDouble(); // Menyimpan input harga minimum dari pengguna

        System.out.print("Masukkan harga maksimum: Rp "); // Meminta pengguna memasukkan harga maksimum
        double hargaMax = scanner.nextDouble(); // Menyimpan input harga maksimum dari pengguna

        // Lakukan pencarian linear multi-kriteria
        ArrayList<Produk> hasilPencarian = cariProdukByKriteria(daftarProduk, kategoriCari, hargaMin, hargaMax); // Memanggil fungsi pencarian produk berdasarkan kategori dan harga

        System.out.println("\nHASIL PENCARIAN:"); // Menampilkan hasil pencarian
        System.out.println("===============================================================");
        System.out.printf("%-5s | %-25s | %-15s | %-10s | %-10s\n",
                          "ID", "Nama Produk", "Kategori", "Harga", "Stok");
        System.out.println("---------------------------------------------------------------");

        if (hasilPencarian.size() > 0) { // Jika ada produk yang sesuai dengan kriteria pencarian
            for (Produk p : hasilPencarian) { // Loop untuk menampilkan setiap produk yang ditemukan
                System.out.println(p);
            }
        } else { // Jika tidak ada produk yang sesuai dengan kriteria pencarian
            System.out.println("Tidak ada produk yang sesuai dengan kriteria pencarian.");
        }
        System.out.println("===============================================================");

        scanner.close(); // Menutup Scanner untuk menghindari kebocoran sumber daya
    }

    public static ArrayList<Produk> cariProdukByKriteria(Produk[] daftarProduk, // Fungsi untuk mencari produk berdasarkan kategori dan harga
                                                         String kategori,
                                                         double hargaMin,
                                                         double hargaMax) {
        ArrayList<Produk> hasilPencarian = new ArrayList<>(); // Membuat daftar hasil pencarian

        for (int i = 0; i < daftarProduk.length; i++) { // Iterasi melalui daftar produk
            Produk produk = daftarProduk[i]; // Mengambil produk saat ini

            // Periksa apakah produk memenuhi semua kriteria
            if (produk.kategori.equalsIgnoreCase(kategori) && // Mengecek apakah kategori produk sesuai dengan input pengguna
                produk.harga >= hargaMin && // Mengecek apakah harga produk lebih besar atau sama dengan harga minimum
                produk.harga <= hargaMax) { // Mengecek apakah harga produk lebih kecil atau sama dengan harga maksimum
                hasilPencarian.add(produk); // Jika memenuhi kriteria, tambahkan produk ke hasil pencarian
            }
        }

        return hasilPencarian; // Mengembalikan daftar produk yang sesuai dengan kriteria pencarian
    }
}
