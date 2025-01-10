import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AplikasiCatatan {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            FileWriter penulisFile = new FileWriter("catatan.txt", true); // Membuka file untuk menambahkan data.

            System.out.println("Selamat datang di Aplikasi Catatan!");
            boolean lanjutkan = true;

            while (lanjutkan) {
                System.out.println("\nPilih menu:");
                System.out.println("1. Tambah Catatan");
                System.out.println("2. Lihat Catatan");
                System.out.print("Masukkan pilihan (1/2): ");
                int menuPilihan = scanner.nextInt();
                scanner.nextLine(); // Membersihkan newline

                switch (menuPilihan) {
                    case 1:
                        tambahCatatan(scanner, penulisFile);
                        break;
                    case 2:
                        lihatCatatan();
                        break;
                    default:
                        System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        break;
                }

                // Menanyakan apakah pengguna ingin melanjutkan
                System.out.print("Ingin kembali ke menu utama? (ya/tidak): ");
                String jawaban = scanner.nextLine();
                if (!jawaban.equalsIgnoreCase("ya")) {
                    lanjutkan = false;
                }
            }

            penulisFile.close(); // Menutup file setelah selesai
            System.out.println("Terima kasih telah menggunakan Aplikasi Catatan!");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyimpan ke file: " + e.getMessage());
        }
    }

    // Metode untuk menambahkan catatan
    private static void tambahCatatan(Scanner scanner, FileWriter penulisFile) throws IOException {
        System.out.println("\nPilih jenis catatan yang ingin dibuat:");
        System.out.println("1. Catatan Teks");
        System.out.println("2. Catatan dengan Prioritas");
        System.out.println("3. Catatan Keamanan (Email/Username dan Password)");
        System.out.print("Masukkan pilihan (1/2/3): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        Catatan catatan;

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan judul catatan: ");
                String judulTeks = scanner.nextLine();
                System.out.print("Masukkan isi catatan: ");
                String isiTeks = scanner.nextLine();
                catatan = new CatatanTeks(judulTeks, isiTeks);
                break;
            case 2:
                System.out.print("Masukkan judul catatan: ");
                String judulPrioritas = scanner.nextLine();
                System.out.print("Masukkan isi catatan: ");
                String isiPrioritas = scanner.nextLine();
                System.out.print("Masukkan prioritas (Tinggi/Sedang/Rendah): ");
                String prioritas = scanner.nextLine();
                catatan = new CatatanPrioritas(judulPrioritas, isiPrioritas, prioritas);
                break;
            case 3:
                System.out.print("Masukkan judul catatan: ");
                String judulKeamanan = scanner.nextLine();
                System.out.print("Masukkan email/username: ");
                String emailAtauUsername = scanner.nextLine();
                System.out.print("Masukkan password: ");
                String password = scanner.nextLine();
                catatan = new CatatanKeamanan(judulKeamanan, emailAtauUsername, password);
                break;
            default:
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                return;
        }

        // Menyimpan catatan ke file
        simpanKeFile(penulisFile, catatan);
        System.out.println("Catatan berhasil disimpan!");
    }

    // Metode untuk melihat catatan
    private static void lihatCatatan() {
        System.out.println("\nIsi catatan:");
        try (BufferedReader pembacaFile = new BufferedReader(new FileReader("catatan.txt"))) {
            String baris;
            while ((baris = pembacaFile.readLine()) != null) {
                System.out.println(baris);
            }
        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }

    // Metode untuk menyimpan catatan ke file
    private static void simpanKeFile(FileWriter penulisFile, Catatan catatan) throws IOException {
        penulisFile.write(catatan.formatkanCatatan());
        penulisFile.write("---------------------------\n"); // Separator antar catatan
    }
}


