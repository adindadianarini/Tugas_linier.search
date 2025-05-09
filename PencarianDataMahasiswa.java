import java.util.Scanner; // Mengimpor Scanner untuk mengambil input dari pengguna

class Mahasiswa { // Mendefinisikan kelas Mahasiswa untuk menyimpan data mahasiswa
    String nim; // Menyimpan nomor induk mahasiswa
    String nama; // Menyimpan nama mahasiswa
    String jurusan; // Menyimpan jurusan mahasiswa
    double ipk; // Menyimpan IPK mahasiswa

    public Mahasiswa(String nim, String nama, String jurusan, double ipk) { // Konstruktor untuk mengisi data mahasiswa saat objek dibuat
        this.nim = nim; // Mengisi atribut nim dengan nilai dari parameter
        this.nama = nama; // Mengisi atribut nama dengan nilai dari parameter
        this.jurusan = jurusan; // Mengisi atribut jurusan dengan nilai dari parameter
        this.ipk = ipk; // Mengisi atribut ipk dengan nilai dari parameter
    }

    @Override
    public String toString() { // Override method toString agar bisa menampilkan data dengan format yang lebih rapi
        return String.format("NIM: %s\nNama: %s\nJurusan: %s\nIPK: %.2f", nim, nama, jurusan, ipk);
    }
}

public class PencarianDataMahasiswa { // Kelas utama tempat program berjalan
    public static void main(String[] args) { // Method utama yang akan dieksekusi pertama kali

        Mahasiswa[] daftarMahasiswa = { // Membuat array berisi daftar mahasiswa
            new Mahasiswa("2023001", "Budi Santoso", "Teknik Informatika", 3.75),
            new Mahasiswa("2023002", "Andi Wijaya", "Sistem Informasi", 3.50),
            new Mahasiswa("2023003", "Dewi Lestari", "Teknik Komputer", 3.90),
            new Mahasiswa("2023004", "Rina Maulana", "Teknik Informatika", 3.60),
            new Mahasiswa("2023005", "Doni Kusuma", "Manajemen Informatika", 3.25),
            new Mahasiswa("2023006", "Sinta Rahma", "Sistem Informasi", 3.85),
            new Mahasiswa("2023007", "Rudi Hermawan", "Teknik Komputer", 3.40)
        };

        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk mengambil input dari pengguna

        System.out.println("=== SISTEM PENCARIAN DATA MAHASISWA ==="); // Menampilkan judul program
        System.out.print("Masukkan NIM Mahasiswa yang dicari: "); // Meminta pengguna memasukkan NIM
        String nimCari = scanner.nextLine(); // Menyimpan input NIM dari pengguna

        Mahasiswa hasilPencarian = cariMahasiswaByNIM(daftarMahasiswa, nimCari); // Memanggil fungsi pencarian berdasarkan NIM

        System.out.println("\nHASIL PENCARIAN:"); // Menampilkan bagian hasil pencarian
        if (hasilPencarian != null) { // Jika mahasiswa ditemukan
            System.out.println("Mahasiswa ditemukan!"); // Menampilkan pesan mahasiswa ditemukan
            System.out.println(hasilPencarian); // Menampilkan data mahasiswa yang ditemukan
        } else { // Jika mahasiswa tidak ditemukan
            System.out.println("Mahasiswa dengan NIM " + nimCari + " tidak ditemukan."); // Menampilkan pesan bahwa mahasiswa tidak ditemukan
        }

        scanner.close(); // Menutup Scanner untuk menghindari kebocoran sumber daya
    }

    public static Mahasiswa cariMahasiswaByNIM(Mahasiswa[] daftarMahasiswa, String nim) { // Fungsi untuk mencari mahasiswa berdasarkan NIM
        for (int i = 0; i < daftarMahasiswa.length; i++) { // Melakukan pencarian satu per satu dalam array mahasiswa
            if (daftarMahasiswa[i].nim.equals(nim)) { // Membandingkan NIM mahasiswa dengan NIM yang dicari
                return daftarMahasiswa[i]; // Jika cocok, mengembalikan objek mahasiswa yang ditemukan
            }
        }
        return null; // Jika tidak ditemukan, mengembalikan null
    }
}
