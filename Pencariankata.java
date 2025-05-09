import java.util.ArrayList; // Menggunakan ArrayList untuk menyimpan hasil pencarian
import java.util.Scanner; // Menggunakan Scanner agar bisa membaca input dari pengguna

public class PencarianKata { // Kelas utama yang menjalankan program pencarian kata dalam teks
    public static void main(String[] args) { // Metode utama yang dieksekusi pertama kali
        Scanner scanner = new Scanner(System.in); // Membuat Scanner untuk membaca input dari pengguna

        System.out.println("=== SISTEM PENCARIAN KATA ==="); // Menampilkan judul program
        System.out.print("Masukkan teks: "); // Meminta pengguna memasukkan teks yang akan dicari
        String teks = scanner.nextLine(); // Menyimpan teks yang diinput pengguna

        System.out.print("Masukkan kata yang dicari: "); // Meminta pengguna memasukkan kata yang ingin dicari
        String kataCari = scanner.nextLine(); // Menyimpan kata yang diinput pengguna

        // Memanggil fungsi untuk mencari posisi kata dalam teks
        ArrayList<Integer> posisiDitemukan = cariKata(teks, kataCari);

        System.out.println("\nHASIL PENCARIAN:"); // Menampilkan hasil pencarian
        if (posisiDitemukan.size() > 0) { // Jika kata ditemukan dalam teks
            System.out.println("Kata '" + kataCari + "' ditemukan sebanyak " + 
                               posisiDitemukan.size() + " kali pada posisi berikut:");

            for (int i = 0; i < posisiDitemukan.size(); i++) { // Loop untuk menampilkan posisi setiap kata yang ditemukan
                System.out.println("- Indeks ke-" + posisiDitemukan.get(i) + 
                                   " (karakter ke-" + (posisiDitemukan.get(i) + 1) + ")");
            }

            // Menampilkan teks dengan tanda highlight pada kata yang ditemukan
            System.out.println("\nTeks dengan highlight:");
            tampilkanTeksHighlight(teks, kataCari, posisiDitemukan);
        } else { // Jika kata tidak ditemukan dalam teks
            System.out.println("Kata '" + kataCari + "' tidak ditemukan dalam teks.");
        }

        scanner.close(); // Menutup Scanner setelah selesai digunakan
    }

    public static ArrayList<Integer> cariKata(String teks, String kata) { // Fungsi untuk mencari kata dalam teks
        ArrayList<Integer> posisi = new ArrayList<>(); // List untuk menyimpan posisi kata yang ditemukan

        // Mengonversi teks dan kata ke huruf kecil agar pencarian tidak sensitif terhadap huruf besar/kecil
        String teksLower = teks.toLowerCase();
        String kataLower = kata.toLowerCase();

        int panjangKata = kataLower.length(); // Menghitung panjang kata yang dicari
        int panjangTeks = teksLower.length(); // Menghitung panjang teks yang diberikan

        // Pencarian kata menggunakan metode linear
        for (int i = 0; i <= panjangTeks - panjangKata; i++) { // Loop untuk mencari kata dalam teks
            String potongan = teksLower.substring(i, i + panjangKata); // Mengambil potongan teks dari posisi tertentu

            if (potongan.equals(kataLower)) { // Jika potongan teks cocok dengan kata yang dicari
                posisi.add(i); // Tambahkan posisi kata ke daftar hasil pencarian
            }
        }

        return posisi; // Mengembalikan daftar posisi kata yang ditemukan
    }

    public static void tampilkanTeksHighlight(String teks, String kata, ArrayList<Integer> posisi) { // Fungsi untuk menampilkan teks dengan tanda highlight
        StringBuilder hasil = new StringBuilder(teks); // Membuat objek StringBuilder dari teks asli

        // Menambahkan tanda highlight pada kata yang ditemukan (dari posisi terakhir agar indeks tidak tergeser)
        for (int i = posisi.size() - 1; i >= 0; i--) { // Loop dari akhir ke awal
            int pos = posisi.get(i); // Mengambil posisi kata
            hasil.insert(pos + kata.length(), "]"); // Menambahkan tanda akhir highlight
            hasil.insert(pos, "["); // Menambahkan tanda awal highlight
        }

        System.out.println(hasil.toString()); // Menampilkan teks dengan tanda highlight
    }
}
